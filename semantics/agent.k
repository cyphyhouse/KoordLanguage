require "agent-syntax.k"

module AGENT
  imports AGENT-SYNTAX
  imports DOMAINS
  configuration
  <T>
   //agent cells
    <agent multiplicity = "*" type="Set">
      <k> $PGM:Pgm </k>

      //local agent environment
      <env> .Map </env>
      <store> .Map </store>
      <nextLoc> 0 </nextLoc>

      //sensors
      <senseEnv> .Map </senseEnv>
      <senseStore> .Map </senseStore>
      <senseNextLoc> 0 </senseNextLoc>

      //actuators
      <actEnv> .Map </actEnv>
      <actStore> .Map </actStore>
      <actNextLoc> 0 </actNextLoc>

      <awEnv> .Map </awEnv>
      <awStore> .Map </awStore>
      <awNextLoc> 0 </awNextLoc>

      <arEnv> .Map </arEnv>
      <arStore> .Map </arStore>
      <arNextLoc> 0 </arNextLoc>

      //agent pid
      <id> 0 </id>
      //mapping time
      <loctmap> .Map </loctmap>
      <artmap> .Map </artmap>
      <awtmap> .Map </awtmap>
      <sensetmap> .Map </sensetmap>
      <actmap> .Map </actmap>
      <nts> 0 </nts>
      //event precondition values
      <evPreMap> .Map </evPreMap>
    </agent>

    //cells storing code for preprocessing, and later execution
    <codeStorage>

      <awdeclcode>  .K </awdeclcode>
      <ardeclcode>  .K </ardeclcode>
      <locdeclcode> .K </locdeclcode>
      <initcode> .K  </initcode>
      <eventcode> .K  </eventcode>
      <moduleCode> .K </moduleCode>
      <simcode> .K  </simcode>
      <moduleName> Trivial </moduleName>
      <safetyCode> .K </safetyCode>
    </codeStorage>


    //bookkeeping for barrier-sync type behavior
    //number of robots
    <numBots> 1 </numBots>

    //init block executed
    <numProcessed> 0 </numProcessed>

    //number of robots created
    <numStarted> 1 </numStarted>

    //finished with either env transition or initialization, ready to copy global environment into local
    <updateReady> 0 </updateReady>

    //executing prog transition
    <inProg> 0 </inProg>

    //executing env transition
    <inEnv> 0 </inEnv>

    //ordering of memory update
    <order> .List </order>
    //active agent
    <active> -1 </active>

    //delta and steps
    <delta> 0 </delta>
    <steps> 0 </steps>
    //overall code execution stage
    <codeStage> Preproc </codeStage>

    <safety> Safe </safety>
    //global environment
    <gawEnv> .Map </gawEnv>
    <gawStore> .Map </gawStore>
    <garEnv> .Map </garEnv>
    <garStore> .Map </garStore>
    //mapping time
    <gartmap> .Map </gartmap>
    <garwmap> .Map </garwmap>
    <ts> 0 </ts>
    //mapping events to preconditions and effects
    <numEvents> 1 </numEvents>
    <precondmap> .Map </precondmap>
    <effmap> .Map </effmap>
    <eventNames> .Map </eventNames>
  </T>

  /*code stages : Preprocessing overall, module preprocessing, allwrite preprocessing, allread preprocessing, event preprocessing, simulation parameters preprocessing, Local declaration preprocessing, initialization, program transition, update between transitions, environment transition, final state when unsafe config has been detected.
  */
  syntax Id ::= "Trivial" [token]

  syntax Safety ::= "Safe" | "Unsafe" | "Refine"

  syntax CodeStage ::= "SensorPreproc"
                    |  "ActPreproc"
                    |  "Preproc"
                    |  "AWpreproc"
                    |  "ARpreproc"
                    |  "Eventpreproc"
                    |  "Simpreproc"
                    |  "Locpreproc"
                    |  "Init"
                    |  "Prog"
                    |  "Update"
                    |  "Env"
                    |  "Final"

  /*syntax for starting procedures*/
  syntax KItem ::= "procSensor"
                 | "procAct"
                 | "procAW"
                 | "procAR"
                 | "procEvents"
                 | "procSim"
                 | "activate"
                 | "initialize"
                 | "updateNow"
                 | "updateMem"
                 | "startEvent"

  //for declaration without initialization
  syntax Val ::= "undefined"
  syntax KResult ::= Val
  syntax Val ::= Int | Bool
  //store code first.
  rule
  <k> M:Module I:AWDecls J:ARDecls K:LocDecls In:Init E:Events S:SimBlock SafetyProp {SC}
      => . ~> S ~> procSensor ~> procAct ~> procAW ~> procAR ~> procEvents ~> procSim
     ... </k>
  <codeStorage>

    <awdeclcode> .K => I ... </awdeclcode>
    <ardeclcode> .K => J ... </ardeclcode>
    <locdeclcode> .K => K ... </locdeclcode>
    <initcode> .K => In ... </initcode>
    <eventcode> .K => E ... </eventcode>
    <moduleCode> .K => M ... </moduleCode>
    <simcode> .K => S ... </simcode>
    <safetyCode> .K => SC </safetyCode>
    ...
  </codeStorage>
  <codeStage> Preproc </codeStage>

  //preprocess sensor variables, create store and environment
  rule <k> T:Type I:Id ; => . ... </k>
       <senseEnv> Rho:Map (.Map => I |-> L)  </senseEnv>
       <senseStore> ... (.Map => L |-> undefined )  </senseStore>
       <senseNextLoc> L => L +Int 1 </senseNextLoc>
       <codeStage> SensorPreproc </codeStage>

  //preprocess actuator variables, create store and environment
  rule <k> T:Type I:Id ; => . ... </k>
       <actEnv> Rho:Map (.Map => I |-> L)  </actEnv>
       <actStore> ... (.Map => L |-> undefined )  </actStore>
       <actNextLoc> L => L +Int 1 </actNextLoc>
       <codeStage> ActPreproc </codeStage>

  //preprocess allwrite variables, create store and environment, and copy to global environment at end of processing.
  rule <k> T:Type I:Id ; => . ... </k>
       <awEnv> Rho:Map (.Map => I |-> L)  </awEnv>
       <awStore> ... (.Map => L |-> undefined )  </awStore>
       <awNextLoc> L => L +Int 1 </awNextLoc>
       <codeStage> AWpreproc </codeStage>

  //syntax for processing allread declarations
  syntax KItem ::= "addARL" Int Type Id
                 | "nextARL" Int Type Id

  //create numbots number of entries in the allread store for each declaration
  rule <k> T:Type I:Id ; => addARL N T I ... </k>
       <numBots> N </numBots>
       <codeStage> ARpreproc </codeStage>

  rule <k> addARL N T I => nextARL N -Int 1 T I ... </k>
       <arEnv> Rho:Map (.Map => I |-> L)  </arEnv>
       <arStore> ... (.Map => L |-> undefined )  </arStore>
       <arNextLoc> L => L +Int 1 </arNextLoc>       requires N >Int 1

  //case when there is only one robot
  rule <k> addARL 1 T I => nextARL 1 T I ... </k>
       <arEnv> Rho:Map (.Map => I |-> L)  </arEnv>
       <arStore> ... (.Map => L |-> undefined )  </arStore>
       <arNextLoc> L => L +Int 1 </arNextLoc>

  rule <k> nextARL N T I => nextARL N -Int 1 T I ... </k>
       <arStore> ... (.Map => L |-> undefined )  </arStore>
       <arNextLoc> L => L +Int 1 </arNextLoc>       requires N >Int 1

  rule <k> nextARL 1 T I => . ... </k>
       <arStore> ... (.Map => L |-> undefined )  </arStore>
       <arNextLoc> L => L +Int 1 </arNextLoc>

  //local variable declaration processing.
  rule <k> T:Type I:Id ; => . ... </k>
       <env> Rho:Map (.Map => I |-> L)  </env>
       <store> ... (.Map => L |-> undefined )  </store>
       <nextLoc> L => L +Int 1 </nextLoc>
       <codeStage> Locpreproc </codeStage>

  //extract simulation parameters delta and number of time steps.
  rule <k> Sim I Delta J Steps K ; => . ... </k>
       <numBots> _ => I </numBots>
       <delta> _ => J </delta>
       <steps> _ => K </steps>
       <codeStage> Preproc </codeStage>

  //process sensors
  rule <k> procSensor => D ... </k>
       <moduleCode> using module I { sensors { D } actuators { D1 } } </moduleCode>
       <moduleName> _ => I </moduleName>
       <codeStage> Preproc => SensorPreproc </codeStage>

  //process actuators
  rule <k> procAct => D1 ... </k>
       <moduleCode> using module I { sensors { D } actuators { D1 } } </moduleCode>
       <codeStage> SensorPreproc => ActPreproc </codeStage>

  //process awdecls
  rule <k> procAW => I ... </k>
       <awdeclcode> I </awdeclcode>
       <codeStage> ActPreproc => AWpreproc </codeStage>

  rule <k> allwrite { D:Decls } => D ...  </k>
       <codeStage> AWpreproc </codeStage>

  //process ardecls after awdecls
  rule <k> procAR => I ... </k>
       <awEnv> E </awEnv>
       <awStore> S </awStore>
       <ardeclcode> I </ardeclcode>
       <gawEnv> _ => E </gawEnv>
       <gawStore> _ => S </gawStore>
       <codeStage> AWpreproc => ARpreproc </codeStage>

  rule <k> allread { D:Decls } => D ...  </k>
       <codeStage> ARpreproc </codeStage>

  //process the event code first
  rule <k> procEvents => I ... </k>
       <arEnv> E </arEnv>
       <arStore> S </arStore>
       <eventcode> I </eventcode>
       <garEnv> _ => E  </garEnv>
       <garStore> _ => S </garStore>
       <codeStage> ARpreproc => Eventpreproc </codeStage>

  syntax List ::= Id
  //store event precondition and effects in a map
  rule <k> I:Id () { pre(V)  eff { X } } => . ... </k>
       <evPreMap> Rho:Map (.Map => N  |-> false ) </evPreMap>
       <precondmap> Rho1:Map (.Map => N |-> V) </precondmap>
       <effmap> Phi:Map (.Map => N |-> X) </effmap>
       <eventNames> Gamma:Map (.Map => N |-> I) </eventNames>
       <numEvents> N => N +Int 1 </numEvents>
       <codeStage> Eventpreproc </codeStage>

  //add the required number of robots
  rule <k> procSim => S ... </k>
       <simcode> S </simcode>
       <numEvents> N => N -Int 1 </numEvents>
       <codeStage> Eventpreproc => Simpreproc </codeStage>

  syntax KItem ::= "Sim" Int ";"

  rule <k> Sim N Delta I Steps J ; => Sim N ; ... </k>
       <codeStage> Simpreproc </codeStage>

  rule <agent>
          <k> Sim N; => Sim N -Int 1; ... </k>

          <senseEnv> SE </senseEnv>
          <senseStore> SS </senseStore>
          <senseNextLoc> SL </senseNextLoc>

          <actEnv> AE </actEnv>
          <actStore> AS </actStore>
          <actNextLoc> AL </actNextLoc>

          <env> E </env>
          <store> S </store>
          <nextLoc> L </nextLoc>

          <awEnv> AWE </awEnv>
          <awStore> AWS </awStore>
          <awNextLoc> AWL </awNextLoc>

          <arEnv> ARE </arEnv>
          <arStore> ARS </arStore>
          <arNextLoc> ARL </arNextLoc>
          <evPreMap> EP </evPreMap>
          ...
       //creating an agent for every declared number of agents
       </agent>
       (.Bag =>
        <agent>
          <k> D ~> activate </k>

          <senseEnv> SE </senseEnv>
          <senseStore> SS </senseStore>
          <senseNextLoc> SL </senseNextLoc>

          <actEnv> AE </actEnv>
          <actStore> AS </actStore>
          <actNextLoc> AL </actNextLoc>

          <env> E </env>
          <store> S </store>
          <nextLoc> L </nextLoc>

          <awEnv> AWE </awEnv>
          <awStore> AWS </awStore>
          <awNextLoc> AWL </awNextLoc>

          <loctmap> .Map </loctmap>
          <artmap> .Map </artmap>
          <awtmap> .Map </awtmap>
          <sensetmap> .Map </sensetmap>
          <actmap> .Map </actmap>
          <nts> 0 </nts>

          <arEnv> ARE </arEnv>
          <arStore> ARS </arStore>
          <arNextLoc> ARL </arNextLoc>
          <evPreMap> EP </evPreMap>
          <id> I </id>
        </agent> )
        <codeStage> Simpreproc </codeStage>
        <numStarted> I => I +Int 1 </numStarted>
        <locdeclcode> D </locdeclcode>            requires N >Int 1

  rule <k> Sim 1; => D ~> activate ... </k>
       <codeStage> Simpreproc => Locpreproc </codeStage>
       <locdeclcode> D </locdeclcode>

  rule <k> local { D:Decls } => D ... </k>
       <codeStage> Locpreproc </codeStage>

  rule <k> activate => . ~> I ~> updateNow ... </k>
       <initcode> I </initcode>
       <numProcessed> N => N +Int 1 </numProcessed>

  rule <numProcessed> N </numProcessed>
       <numBots> N </numBots>
       <codeStage> Locpreproc => Prog </codeStage>

  rule <k> updateNow => . ~> updateMem ... </k>
       <updateReady> N => N +Int 1 </updateReady>
       <codeStage> Prog </codeStage>

  rule <updateReady> N => 0  </updateReady>
       <numBots> N  </numBots>
       <gawStore> AWS </gawStore>
       <garStore> ARS </garStore>
       <gartmap> .Map => (I |-> ARS) ... </gartmap>
       <garwmap> .Map => (I |-> AWS) ...  </garwmap>
       <ts> I => I +Int 1 </ts>
       <codeStage> Prog => Update </codeStage>

  syntax KItem ::= "Eval" "(" Int ")"
  rule <agent>
          <k> updateMem => . ~>  Eval(N) ... </k>
          <store> LS </store>
          <senseStore> SS </senseStore>
          <actStore> AC </actStore>
          <awStore> AW => AWS </awStore>
          <arStore> AR => ARS </arStore>
          <loctmap> .Map => (T |-> LS) ... </loctmap>
          <artmap> .Map => (T |-> AR) ... </artmap>
          <awtmap> .Map => (T |-> AW) ... </awtmap>
          <sensetmap> .Map => (T |-> SS) ... </sensetmap>
          <actmap> .Map => (T |-> AC) ... </actmap>
          <nts> T => T +Int 1 </nts>
          ...
       </agent>
       <numEvents> N </numEvents>
       <gawStore> AWS </gawStore>
       <garStore> ARS </garStore>
       <codeStage> Update </codeStage>

  rule <agent> <k> X:Id => V ...</k>
       <env>... X |-> L ...</env>
       <store>... L |-> V:Val ...</store> ... </agent>  [lookup]

  rule <agent> <k> X:Id => V ...</k>
       <actEnv>... X |-> L ...</actEnv>
       <actStore>... L |-> V:Val ...</actStore> ... </agent>  [lookup]
  rule <agent> <k> X:Id => V ...</k>
       <senseEnv>... X |-> L ...</senseEnv>
       <senseStore>... L |-> V:Val ...</senseStore> ... </agent>  [lookup]

  rule <agent> <k> X:Id => V ...</k>
       <awEnv>... X |-> L ...</awEnv>
       <awStore>... L |-> V:Val ...</awStore> ... </agent>  [lookup]


  rule <agent> <k> pid => I ... </k>
       <id> I </id> ... </agent>   [lookup]
  syntax KItem ::= "Replace" "(" Exp "," Int ")"  [strict]

  rule <k> Eval(N) => Replace(P,N) ~> Eval(N -Int 1) ... </k>
       <precondmap> ... N |-> P ... </precondmap>      requires N >Int 0

  rule <agent> <k> Replace(P,N) => . ... </k>
       <evPreMap> ... N |-> (_ => P)  ... </evPreMap> ... </agent> requires isKResult(P)

  rule <k> Eval(0) => . ~> startEvent ... </k>
       <inProg> N => N +Int 1 </inProg>
       <codeStage> Update </codeStage>

  rule <inProg> N => 0 </inProg>
       <numBots> N </numBots>
       <codeStage> Update => Prog </codeStage>
       <steps> I </steps>           requires I >Int 0

  rule <inEnv> N => 0 </inEnv>
      <numBots> N </numBots>
      <codeStage> Prog => Env </codeStage>

  //Init assignment
  rule <agent> <k> X:Id = V:Val ; => . ... </k>
       <senseEnv> ... X |-> L ... </senseEnv>
       <senseStore> ... L |-> (_ => V) ... </senseStore> ... </agent>
       <codeStage> Prog </codeStage>


  rule <agent> <k> X:Id = V:Val ; => . ... </k>
       <env> ... X |-> L ... </env>
       <store> ... L |-> (_ => V) ... </store> ... </agent>
       <codeStage> Prog </codeStage>

  rule <agent> <k> X:Id = V:Val ; => . ... </k>
       <actEnv> ... X |-> L ... </actEnv>
       <actStore> ... L |-> (_ => V) ... </actStore> ... </agent>
       <codeStage> Prog </codeStage>

  rule <agent> <k> X:Id = V:Val ; => . ... </k>
       <awEnv> ... X |-> L ... </awEnv>
       <awStore> ... L |-> (_ => V) ... </awStore> ... </agent>
       <gawEnv> ... X |-> L1 ... </gawEnv>
       <gawStore> ... L1 |-> (_ => V) ... </gawStore>
       <codeStage> Prog </codeStage>

  rule <agent> <k> X:Id = V:Val ; => . ... </k>
       <arEnv> ... X |-> L ... </arEnv>
       <arStore> ... (L +Int I) |-> (_ => V) ... </arStore>
       <id> I </id> ... </agent>
       <garEnv> ... X |-> L1 ... </garEnv>
       <garStore> ... (L1 +Int I)  |-> (_ => V) ... </garStore>
       <codeStage> Prog </codeStage>

  //if then else
  syntax KItem ::= "evalcond" "(" Exp "," Exp "," Stmts "," Stmts ")" [strict(1)]

  syntax KItem ::= "evalSafe" "(" Exp ")" [strict(1)]

  rule if (C) {E} else {Es} => evalcond(C,C,E,Es)
  rule evalcond(false, _, _, Es) => Es
  rule evalcond(true, _, E, _) => E

  rule  evalcond(undet, C, E, Es) => mkJunct(C) ~> E [ifbranch]
  rule  evalcond(undet, C, E, Es) => mknegJunct(C) ~> Es [ifbranch]

  //rule if (undet) { E } else { Es } => E    [ifbranch]
  //rule if (undet) { E } else { Es } => Es   [elsebranch]

  // Boolean operations
  rule A && B => A andBool B
  rule A || B => A  orBool B

  //arithmetic
  rule [I1:Int,J1:Int] + [I2:Int,J2:Int] => [I1 +Int I2,J1 +Int J2]   requires (I1 <Int J1) andBool (I2 <Int J2) [anywhere]
  rule [I1:Int,J1:Int] - [I2:Int,J2:Int] => [I1 -Int I2,J1 -Int J2]   requires (I1 <Int J1) andBool (I2 <Int J2) [anywhere]
  rule [I1:Int,J1:Int] * [I2:Int,J2:Int] => mkInterval(minProd(I1 *Int I2; J1 *Int J2;I1 *Int J2; J1 *Int I2), maxProd(I1 *Int I2; I1 *Int J2; J1 *Int J2; J1 *Int I2))


  //Interval - Int Arithmetic Interactions
  rule [I1:Int,J1:Int] + I2:Int => [I1 +Int I2,J1 +Int I2]
  rule [I1:Int,J1:Int] - I2:Int => [I1 -Int I2,J1 -Int I2]
  rule I2:Int + [I1:Int,J1:Int] => [I1 +Int I2,J1 +Int I2]
  rule I2:Int - [I1:Int,J1:Int] => [I2 -Int I1,I2 -Int J1]
  rule [I1:Int,J1:Int] * I2:Int => [I1 *Int I2,J1 *Int I2]
  rule I2:Int * [I1:Int,J1:Int] => [I1 *Int I2,J1 *Int I2]


  //normalization of interval
  //TODO:do we need normalize instead, or do we *still* need normalize
  rule  [I:Int,J:Int] => [J,I]  requires J <Int I [anywhere]
  rule [I:Int,I:Int] => I [anywhere]

  //compute intersections
  //TODO:compress into if then else.
  rule [I1:Int, J1:Int] AA [I2:Int, J2:Int] => [I2, J1] requires I2 >Int I1 andBool J2 >Int J1 andBool I2 <Int J1 [anywhere]
  rule [I1:Int, J1:Int] AA [I2:Int, J2:Int] => [I1, J2] requires I1 >Int I2 andBool J1 >Int J2 andBool I2 <Int J1   [anywhere]
  rule [I1:Int, J1:Int] AA [J1:Int, J2:Int] => J1 [anywhere]

  rule [I1:Int, J1:Int] AA [I2:Int, J2:Int] => phi requires I2 >Int J1  [anywhere]
  rule [I1:Int, J1:Int] AA [I2:Int, J2:Int] => phi requires J2 <Int I1   [anywhere]

  //empty set interactions
  //TODO: Investigate why I made these structural, seems kind of unnecessary now.
  rule phi VV J:Junction => J [structural]
  rule J:Junction VV phi => J [structural]
  rule phi + I:Junction => phi [structural]
  rule phi - I:Junction => phi [structural]
  rule I:Junction + phi => phi [structural]
  rule I:Junction - phi => phi [structural]

  rule I1:Int + I2:Int => I1 +Int I2
  rule I1:Int - I2:Int => I1 -Int I2
  rule I1:Int * I2:Int => I1 *Int I2

  rule I1:Junction VV I2:Junction + I3:Junction => normalize( I1 + I3 ) VV normalize(I2 + I3)
  rule I1:Junction VV I2:Junction - I3:Junction => normalize( I1 - I3 ) VV normalize(I2 - I3)

  rule <k> phi => . ... </k>
       <safety> _ => Refine </safety>
       <codeStage> _ => Final </codeStage>
 //auxiliary functions

  //TODO: get rid of normalize. It may be superflous, used the "anywhere" attribute rather unsafely everywhere. Original plan was to use it to  make sure that intervals are always of the form [lesser integer, greater integer]
 //TODO: mkInterval may be superfluous as well. Investigate when you have time. This is a helper for the interval multiplication nonsense.
  syntax Junction ::=  normalize ( Exp )       [function]
                    |   mkInterval(Int,Int) [function]
  syntax Stmt::=      mkJunct(Exp)
		| mknegJunct(Exp)
  //auxiliary functions for max and min of products of interval bounds to compute interval product
  syntax Int ::= minProd(Exps) [function]
                |  maxProd(Exps) [function]

  rule normalize(I:Junction) => I

//mkjunct
//local environment
  rule <agent> <k>   mkJunct(V > I:Int) => V = [I +Int 1,1000] AA J ; ... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
        ... </agent>

  rule <agent> <k>  mkJunct(V >= I:Int) => V = [I,1000] AA J ;  ... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
       ... </agent>

  rule <agent> <k> mkJunct(V < I:Int) => V = [-1000,I-Int 1] AA J ;... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
       ... </agent>

  rule <agent> <k>  mkJunct(V <= I:Int) => V = [-1000,I] AA J ;  ... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
       ... </agent>

  rule <agent> <k>   mkJunct(V != I:Int) => V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ;  ... </k>
      <env> ... V |-> L ... </env>
      <store> ... L |-> J ... </store>
  ... </agent>

//allread
  rule <agent> <k>   mkJunct(V > I:Int) => V = [I +Int 1,1000] AA J ; ... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
        ... </agent>

  rule <agent> <k>  mkJunct(V >= I:Int) => V = [I,1000] AA J ;  ... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
       ... </agent>

  rule <agent> <k> mkJunct(V < I:Int) => V = [-1000,I-Int 1] AA J ;... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
       ... </agent>

  rule <agent> <k>  mkJunct(V <= I:Int) => V = [-1000,I] AA J ;  ... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
       ... </agent>

  rule <agent> <k>   mkJunct(V != I:Int) => V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ;  ... </k>
      <arEnv> ... V |-> L ... </arEnv>
      <arStore> ... L |-> J ... </arStore>
  ... </agent>

//allwrite
  rule <agent> <k>   mkJunct(V > I:Int) => V = [I +Int 1,1000] AA J ; ... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
        ... </agent>

  rule <agent> <k>  mkJunct(V >= I:Int) => V = [I,1000] AA J ;  ... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
       ... </agent>

  rule <agent> <k> mkJunct(V < I:Int) => V = [-1000,I-Int 1] AA J ;... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
       ... </agent>

  rule <agent> <k>  mkJunct(V <= I:Int) => V = [-1000,I] AA J ;  ... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
       ... </agent>

  rule <agent> <k>   mkJunct(V != I:Int) => V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ;  ... </k>
      <awEnv> ... V |-> L ... </awEnv>
      <awStore> ... L |-> J ... </awStore>
  ... </agent>

//actuators
  rule <agent> <k>   mkJunct(V > I:Int) => V = [I +Int 1,1000] AA J ; ... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
        ... </agent>

  rule <agent> <k>  mkJunct(V >= I:Int) => V = [I,1000] AA J ;  ... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
       ... </agent>

  rule <agent> <k> mkJunct(V < I:Int) => V = [-1000,I-Int 1] AA J ;... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
       ... </agent>

  rule <agent> <k>  mkJunct(V <= I:Int) => V = [-1000,I] AA J ;  ... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
       ... </agent>

  rule <agent> <k>   mkJunct(V != I:Int) => V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ;  ... </k>
      <actEnv> ... V |-> L ... </actEnv>
      <actStore> ... L |-> J ... </actStore>
  ... </agent>

//sensors
  rule <agent> <k>   mkJunct(V > I:Int) => V = [I +Int 1,1000] AA J ; ... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
        ... </agent>

  rule <agent> <k>  mkJunct(V >= I:Int) => V = [I,1000] AA J ;  ... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
       ... </agent>

  rule <agent> <k> mkJunct(V < I:Int) => V = [-1000,I-Int 1] AA J ;... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
       ... </agent>

  rule <agent> <k>  mkJunct(V <= I:Int) => V = [-1000,I] AA J ;  ... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
       ... </agent>

  rule <agent> <k>   mkJunct(V != I:Int) => V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ;  ... </k>
      <senseEnv> ... V |-> L ... </senseEnv>
      <senseStore> ... L |-> J ... </senseStore>
  ... </agent>

//neg
//local
  rule <agent> <k>     mknegJunct(V > I:Int) => V = [-1000,I] AA J ; ... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
        ... </agent>

  rule <agent> <k>    mknegJunct(V >= I:Int) => V = [-1000,I+Int 1] AA J ; ... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
       ... </agent>

  rule <agent> <k>  mknegJunct(V < I:Int) => V = [I,1000] AA J ; ... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
       ... </agent>

  rule <agent> <k>    mknegJunct(V <= I:Int) => V = [I+Int 1,1000] AA J ; ... </k>
       <env> ... V |-> L ... </env>
       <store> ... L |-> J ... </store>
       ... </agent>

  rule <agent> <k>    mknegJunct(V == I:Int) =>V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ; ... </k>
      <env> ... V |-> L ... </env>
      <store> ... L |-> J ... </store>
  ... </agent>

//allread
  rule <agent> <k>    mknegJunct(V > I:Int) => V = [-1000,I] AA J ; ... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
        ... </agent>

  rule <agent> <k>   mknegJunct(V >= I:Int) => V = [-1000,I+Int 1] AA J ; ... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
       ... </agent>

  rule <agent> <k>   mknegJunct(V < I:Int) => V = [I,1000] AA J ; ... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
       ... </agent>

  rule <agent> <k>    mknegJunct(V <= I:Int) => V = [I+Int 1,1000] AA J ; ... </k>
       <arEnv> ... V |-> L ... </arEnv>
       <arStore> ... L |-> J ... </arStore>
       ... </agent>

  rule <agent> <k>     mknegJunct(V == I:Int) =>V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ; ... </k>
      <arEnv> ... V |-> L ... </arEnv>
      <arStore> ... L |-> J ... </arStore>
  ... </agent>

//allwrite
  rule <agent> <k>     mknegJunct(V > I:Int) => V = [-1000,I] AA J ; ... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
        ... </agent>

  rule <agent> <k>    mknegJunct(V >= I:Int) => V = [-1000,I+Int 1] AA J ; ... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
       ... </agent>

  rule <agent> <k>   mknegJunct(V < I:Int) => V = [I,1000] AA J ; ... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
       ... </agent>

  rule <agent> <k>   mknegJunct(V <= I:Int) => V = [I+Int 1,1000] AA J ; ... </k>
       <awEnv> ... V |-> L ... </awEnv>
       <awStore> ... L |-> J ... </awStore>
       ... </agent>

  rule <agent> <k>    mknegJunct(V == I:Int) =>V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ; ... </k>
      <awEnv> ... V |-> L ... </awEnv>
      <awStore> ... L |-> J ... </awStore>
  ... </agent>

//actuators
  rule <agent> <k>     mknegJunct(V > I:Int) => V = [-1000,I] AA J ; ... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
        ... </agent>

  rule <agent> <k>    mknegJunct(V >= I:Int) => V = [-1000,I+Int 1] AA J ; ... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
       ... </agent>

  rule <agent> <k>   mknegJunct(V < I:Int) => V = [I,1000] AA J ; ... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
       ... </agent>

  rule <agent> <k>    mknegJunct(V <= I:Int) => V = [I+Int 1,1000] AA J ; ... </k>
       <actEnv> ... V |-> L ... </actEnv>
       <actStore> ... L |-> J ... </actStore>
       ... </agent>

  rule <agent> <k>  mknegJunct(V == I:Int) =>V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ; ... </k>
      <actEnv> ... V |-> L ... </actEnv>
      <actStore> ... L |-> J ... </actStore>
  ... </agent>

//SENSORS
  rule <agent> <k>     mknegJunct(V > I:Int) => V = [-1000,I] AA J ; ... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
        ... </agent>

  rule <agent> <k>    mknegJunct(V >= I:Int) => V = [-1000,I+Int 1] AA J ; ... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
       ... </agent>

  rule <agent> <k>   mknegJunct(V < I:Int) => V = [I,1000] AA J ; ... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
       ... </agent>

  rule <agent> <k>    mknegJunct(V <= I:Int) => V = [I+Int 1,1000] AA J ; ... </k>
       <senseEnv> ... V |-> L ... </senseEnv>
       <senseStore> ... L |-> J ... </senseStore>
       ... </agent>

  rule <agent> <k>  mknegJunct(V == I:Int) =>V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ; ... </k>
      <senseEnv> ... V |-> L ... </senseEnv>
      <senseStore> ... L |-> J ... </senseStore>
  ... </agent>

/*
  mknegJunct(V > I:Int) => V = [-1000,I] AA J ; ... </k>
  mknegJunct(V >= I:Int) => V = [-1000,I+Int 1] AA J ; ... </k>
  mknegJunct(V < I:Int) => V = [I,1000] AA J ; ... </k>
  mknegJunct(V <= I:Int) => V = [I+Int 1,1000] AA J ; ... </k>
  mknegJunct(V == I:Int) =>V = ([-1000,I-Int 1] VV [I+Int 1,1000]) AA J ; ... </k>
 */
  rule minProd(I1:Int;.Exps) => I1
  rule minProd(I1:Int;I2:Int;I3:Exps) => #if I1 <=Int I2 #then minProd(I1;I3) #else minProd(I2;I3) #fi

  rule maxProd(I1:Int;.Exps) => I1
  rule maxProd(I1:Int;I2:Int;I3:Exps) => #if I1 <=Int I2 #then maxProd(I2;I3) #else maxProd(I1;I3) #fi

  rule mkInterval(I1,I2) => [I1,I2]
  rule I1:Int > I2 => I1 >Int I2
  rule I1:Int < I2 => I1 <Int I2
  rule I1:Int >= I2 => I1 >=Int I2
  rule I1:Int <= I2 => I1 <=Int I2
  rule I1:Int == I2 => I1 ==Int I2
  rule I1:Int != I2 => notBool (I1 ==Int I2)


  rule [I1,J1] > [I2,J2] => I1 >Int J2
  rule [I1,J1] < [I2,J2] => J1 <Int I2
  rule [I1,J1] > I2  => #if I1 >Int I2 #then true #else #if J1 <=Int I2 #then false #else undet #fi #fi
  rule [I1,J1] < I2 => #if I1 >=Int I2 #then false #else #if J1 <Int I2 #then true #else undet #fi #fi
  rule [I1,J1] >= I2  => #if I1 >=Int I2 #then true #else #if J1 <Int I2 #then false #else undet #fi #fi
  rule [I1,J1] <= I2 => #if I1 >Int I2 #then false #else #if J1 <=Int I2 #then true #else undet #fi #fi

  rule [I1,J1] >= [I2,J2] => #if I1 >=Int J2 #then true #else #if J1 <Int I2 #then false #else undet #fi #fi
  rule [I1,J1] <= [I2,J2] => #if J1 <=Int I2 #then true #else #if I1 >Int J2 #then false #else undet #fi #fi

  rule [I1,J1] == [I2,J2] => I1 ==Int I2 andBool J1 ==Int J2
  rule [I1,J1] != [I2,J2] => #if (I1 >Int J2) orBool (I2 >Int J1) #then true #else undet #fi


  //throwaway
  rule <k> init { S } => . ~> S ... </k>
       <codeStage> Prog </codeStage>

  syntax K ::= "endEvent" | "callBB" | "endcallBB"

  rule <agent>
          <k> startEvent => EFFMAP[L] ~> endEvent ~> callBB ~> endcallBB ... </k>
          <id> I </id>
          <evPreMap> ... L |-> true ... </evPreMap>
          ...
       </agent>
       <codeStage> Prog </codeStage>
       <effmap> EFFMAP </effmap>
       <active> -1 => I </active>
    requires L ==K choice(EFFMAP)

       /*<inEnv> N => N +Int 1 </inEnv> */          [execute]

  rule <k> endEvent => . ~> evalSafe(C) ... </k>
       <active> _ => -1 </active>
       <safetyCode> C </safetyCode>
       <inEnv> N => N +Int 1 </inEnv>

  rule evalSafe(true) => .

  rule <k> evalSafe(false) => . ... </k>
       <safety> _ => Unsafe </safety>
       <codeStage> _ => Final </codeStage>

  rule <k> evalSafe(undet) => . ... </k>
       <safety> _ => Refine </safety>
       <codeStage> _ => Final </codeStage>

  syntax K ::= "replacetemp" "(" Exp ")" [strict]
  syntax Exp ::= "tempUpdate" "(" Val"," Val "," Val ")"   [function]
  rule tempUpdate(V1,V2,V3) => V1 + (V2 * V3)


  rule <agent> <k> callBB => . 	~> replacetemp(tempUpdate(V,S,D)) ... </k>
       <senseStore> 0 |-> V ...  </senseStore>
       <actStore> 0 |-> S ... </actStore> ...
       </agent>
       <delta> D </delta>

  rule <agent> <k> replacetemp(V) => . ... </k>
       <senseStore> 0 |-> (_ => V) ...  </senseStore>
       <actStore> 0 |-> S ... </actStore> ...
       </agent>    requires isKResult(V)

  rule <agent> <k> endcallBB => . ~> updateMem ... </k> ... </agent>
       <updateReady> N => N +Int 1 </updateReady>
       <codeStage> Env </codeStage>

  rule <updateReady> N => 0  </updateReady>
       <numBots> N  </numBots>
       <codeStage> Env => Update </codeStage>
       <steps> I => I -Int 1 </steps>

  rule D:Event Ds:Events => D ~> Ds [structural]
  rule D:Event Ds:Event => D ~> Ds [structural]
  rule D:Decl Ds:Decls => D ~> Ds [structural]
  rule .Decls => .                [structural]
  rule S:Stmt Ss:Stmts => S ~> Ss [structural]
  rule .Stmts => .                [structural]

endmodule

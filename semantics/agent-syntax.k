module AGENT-SYNTAX   
  imports DOMAINS-SYNTAX 
//a program consists of variable declarations, event code, and simulation parameters. 

     syntax Pgm ::= Module DeclBlock Init Events SimBlock SafetyProp 

     syntax Module ::= "using" "module" Id "{" Sensors Actuators "}"
     syntax Sensors ::= "sensors" "{" Decls "}"
     syntax Actuators ::= "actuators" "{" Decls "}"

     syntax SafetyProp ::= "SafetyProp" "{" Exp "}"

/*
Declarations can be allwrite, allread or local. 
*/
     syntax DeclBlock ::= AWDecls ARDecls LocDecls
     syntax AWDecls ::= "allwrite" "{" Decls "}"
     syntax ARDecls ::= "allread" "{" Decls "}"
     syntax LocDecls ::= "local" "{" Decls "}"

     syntax Decl ::= Type Id ";"
     syntax Decls ::= List{Decl,""}
  
     syntax Type ::= "int" | "bool" 
/*
code block consists of events
*/
     syntax Init ::= "init" "{" Stmts "}"
     syntax Events ::= Event Events | Event 

     syntax Event ::= Id "(" ")" "{" Precondition Effect "}"
     syntax Precondition ::= "pre" "(" Exp ")"
     syntax Effect ::= "eff" "{" Stmts "}"
     
     syntax Stmt ::= Asgn | ITE
 
     syntax Stmts ::= List{Stmt,""}

     syntax Asgn ::= Var "=" Exp ";"     [strict(2)]
                 |  Var "in" Junction ";"   [strict(2), right]

     syntax ITE ::= "if" "(" Exp ")" "{" Stmts "}"
                    "else" "{" Stmts "}"  //[strict(1)]


     syntax Var ::= Id | "pid" 
     syntax Val ::= Int | Bool | Junction | "undet"
     syntax Val ::= "inf"| "-inf"
     
     syntax CI ::= "[" Int "," Int "]"
                 | Int
     syntax Junction ::= Junction "VV" Junction [left]
                  | Junction "AA" Junction   [left]
                  | CI 
                  | "(" Junction ")"         [bracket]
                  | "phi"

     syntax Exp ::= Val | Var 
               | "(" Exp ")"             [bracket]
               > Exp "[" Exp "]"         [strict]
               > left:
                 Exp "*" Exp             [strict, left]
               > left:
                 Exp "+" Exp             [strict, left]
               | Exp "-" Exp             [strict, left]
               | "-" Exp                 [strict]
               > non-assoc:
                 Exp "<" Exp             [strict, non-assoc]
               | Exp "<=" Exp            [strict, non-assoc]
               | Exp ">" Exp             [strict, non-assoc]
               | Exp ">=" Exp            [strict, non-assoc]
               | Exp "==" Exp            [strict, non-assoc]
               | Exp "!=" Exp            [strict, non-assoc]
               > "!" Exp                 [strict]
               > left:
                 Exp "&&" Exp            [seqstrict, left]
               | Exp "||" Exp            [seqstrict, left]

    syntax Exps ::= List{Exp,";"}
/*
sim block has the simulation parameters, including the number of robots, delta, and number of steps. It also has Initial sensor values 
*/
   
    syntax SimBlock ::= "Sim" Int  "Delta" Int "Steps" Int ";"  
endmodule 

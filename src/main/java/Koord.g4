
grammar Koord;

tokens { INDENT, DEDENT }

@lexer::header {
  import java.util.*;             
}

@lexer::members { //this must be put on the top, and not after the grammar rules
                
  private int prevNumSpaces = 0;             
  private Queue<Token> tokens = new LinkedList<>();
  private Deque<Integer> spaces = new LinkedList<>();

  @Override
  public void emit(Token t) {
    super.setToken(t);
    System.out.println("added token" + t.toString());
    tokens.offer(t);
  }

  private CommonToken commonToken(int type, String text) {
    int stop = this.getCharIndex() - 1;
    int start = text.isEmpty() ? stop : stop - text.length() + 1;
    CommonToken t = new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
    t.setText(text);
    return t;
  }
  @Override
  public Token nextToken() {
    if (_input.LA(1) == EOF) {
        if (!spaces.isEmpty()) {

        emit(commonToken(KoordParser.NEWLINE, "<newline>"));
      while (!spaces.isEmpty()) {
        spaces.poll();
        emit(commonToken(KoordParser.DEDENT, "dedent"));
      }
        }
    }
    Token next = super.nextToken();
    return tokens.isEmpty() ? next : tokens.poll();
  }
}

AGENT: 'agent';
MODULE:'module';
USING : 'using';

DEF: 'def';
TYPE: 'type';
FUN: 'fun';
ADT : 'adt';


ACTUATORS:'actuators';
SENSORS:'sensors';

ALLWRITE:'allwrite';
ALLREAD:'allread';
LOCAL:'local';

LIST:'list';
MAP:'map';
QUEUE:'queue';

INIT:'init';
INT:'int';
FLOAT:'float';
BOOL:'boolean'; //bool or boolean?


POS:'pos';
INPUTMAP : 'inputMap';
IF:'if';
ELSE:'else';
ATOMIC:'atomic';

PRE:'pre';
EFF:'eff';
TRUE:'true';
FALSE:'false';

PID:'pid';
NUMAGENTS:'numBots'; //num agents or numbots?


COLON : ':';
COMMA : ',';
SEMICOLON : ';';
LPAR : '(';
RPAR : ')';
LBRACE : '[';
RBRACE : ']';
LCURLY : '{';
RCURLY : '}';
LANGLE : '<';
RANGLE : '>';
AND : '&&';
OR : '||';
NOT : '!';
LID : [a-z][a-zA-Z0-9]*; //difference betwee lid and cid???
CID : [A-Z][a-zA-Z0-9]*;
INUM : [-]?[0-9]+;
FNUM : [-]?[0-9]+([.][0-9]+)?;
PLUS : '+';
MINUS : '-';
TIMES : '*';
BY : '/';
EQ : '==';
GEQ : '>=';
LEQ : '<=';
NEQ : '!=';
ASGN : '=';



NEWLINE
 :  '\n' WS?
  
   {
      Integer numSpaces = (int) getText().chars().filter(x -> x == ' ').count();
      if (_input.LA(1) != '\n')            {
        emit(commonToken(NEWLINE, "<newline>"));

        if (spaces.isEmpty() || numSpaces > spaces.peek()) {
            emit(commonToken(KoordParser.INDENT, "<indent>"));
            spaces.push(numSpaces);
        } else if (spaces.peek() > numSpaces ) {
          while (!spaces.isEmpty() && spaces.peek() > numSpaces) {

            emit(commonToken(KoordParser.DEDENT, "<dedent>"));
            spaces.pop();
          }
        } 
      } else {
        skip();
      }
   }
 ;


SKIP_
 : ( WS ) -> skip
;
fragment WS : [ \t]+ ; //should be parsed ?



lexemes : AGENT|MODULE| DEF |TYPE |FUN | ACTUATORS|SENSORS|
ALLWRITE|ALLREAD|LOCAL| LIST|MAP|QUEUE| INIT|INT|FLOAT|BOOL| POS|IF|ELSE|ATOMIC|
PRE|EFF|TRUE|FALSE| PID|NUMAGENTS | COLON| COMMA| SEMICOLON| LPAR| RPAR| LBRACE|
RBRACE| LCURLY| RCURLY| LANGLE| RANGLE| AND| OR| NOT| LID| CID| INUM| FNUM|
PLUS| MINUS| TIMES| BY| EQ| GEQ| LEQ| NEQ| ASGN | NEWLINE | SKIP_ | INDENT | DEDENT;


top : lexemes+;


program :  defs  module*   decblock*   init?  event+ EOF;
defs : funcdef* /* adtdef* */;
funcdef : DEF FUN LID LPAR param* RPAR COLON NEWLINE statementblock;
//adtdef : DEF ADT LID COLON decl+;
param : TYPE LID;

event : LID COLON NEWLINE INDENT PRE COLON expr NEWLINE EFF COLON NEWLINE statementblock DEDENT;
statementblock : INDENT stmt+ DEDENT;

stmt : assign NEWLINE
     | funccall NEWLINE
     | IF expr COLON NEWLINE statementblock (ELSE COLON NEWLINE statementblock)?
     | ATOMIC COLON NEWLINE statementblock; //add later

funccall : LID LPAR (expr (COMMA expr)*)? RPAR;

assign : LID ASGN expr;
expr : aexpr | bexpr; //more

bexpr : 
      NOT bexpr
      | LPAR bexpr RPAR
      | aexpr relop aexpr
      | bexpr AND bexpr
      | bexpr OR bexpr
      | FALSE
      | TRUE
      | LID;
      



aexpr :
      LPAR aexpr RPAR
      | aexpr (TIMES | BY)  aexpr
      | aexpr (PLUS | MINUS) aexpr
      | funccall
      | number
      | NUMAGENTS
      | LID;

number : FNUM | INUM | PID;
relop : LANGLE | RANGLE | GEQ | LEQ | EQ | NEQ; //more

decblock : (ALLWRITE | ALLREAD | LOCAL) COLON NEWLINE INDENT decl+ DEDENT;

decl : (INT | BOOL | FLOAT | POS | QUEUE) /* there might be more */ LID (ASGN expr)? NEWLINE;

module : USING MODULE CID COLON NEWLINE INDENT actuatordecls sensordecls DEDENT;

actuatordecls : ACTUATORS COLON NEWLINE INDENT decl+ DEDENT;

sensordecls : SENSORS COLON NEWLINE INDENT decl+ DEDENT;

init : INIT COLON NEWLINE statementblock;



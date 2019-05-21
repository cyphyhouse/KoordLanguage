
grammar Koord;

tokens { INDENT, DEDENT }

@lexer::members {
                
  private int prevNumSpaces = 0;             
  public static final int INDENT_SIZE = 2;
}

AGENT: 'agent';
MODULE:'module';

DEF: 'def ';
TYPE: 'type ';
FUN: 'fun ';

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
BOOL:'bool';

POS:'pos';
IF:'if';
ELSE:'else';
ATOMIC:'atomic';

PRE:'pre';
EFF:'eff';
TRUE:'true';
FALSE:'false';

PID:'pid';
NUMAGENTS:'numAgents';

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
LID : [a-z][a-zA-Z0-9]*;
CID : [A-Z][a-zA-Z0-9]*;
INUM : [-]?[0-9]+;
FNUM : [-]?[0-9]+([.][0-9]+)?;
PLUS : '+';
MINUS : '-';
TIMES : '*';
BY : '/';
LT : '<'; //duplicate ?
GT : '>';
EQ : '==';
GEQ : '>=';
LEQ : '<=';
NEQ : '!=';
ASGN : '=';


NEWLINE
 :  '\n' WS?
  
   {
      int numSpaces = (int) getText().chars().filter(x -> x == ' ').count() / INDENT_SIZE;
      if (numSpaces > prevNumSpaces) {
         for (int i = 0; i < prevNumSpaces - numSpaces; i++) {
           emit(new CommonToken(KoordParser.INDENT, "indent"));
         }
      } else if (prevNumSpaces > numSpaces ) {
         for (int i = 0; i < numSpaces - prevNumSpaces; i++) {
           emit(new CommonToken(KoordParser.DEDENT, "dedent"));
         }
      } 
      prevNumSpaces = numSpaces;
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
PLUS| MINUS| TIMES| BY| LT| GT| EQ| GEQ| LEQ| NEQ| ASGN | NEWLINE | SKIP_ | INDENT | DEDENT;


top : lexemes+;


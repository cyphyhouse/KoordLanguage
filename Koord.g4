
grammar Koord;


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
WS : ' '; //should be parsed ?
NL : '\n' ;


lexemes : AGENT|MODULE| DEF |TYPE |FUN | ACTUATORS|SENSORS|
ALLWRITE|ALLREAD|LOCAL| LIST|MAP|QUEUE| INIT|INT|FLOAT|BOOL| POS|IF|ELSE|ATOMIC|
PRE|EFF|TRUE|FALSE| PID|NUMAGENTS | COLON| COMMA| SEMICOLON| LPAR| RPAR| LBRACE|
RBRACE| LCURLY| RCURLY| LANGLE| RANGLE| AND| OR| NOT| LID| CID| INUM| FNUM|
PLUS| MINUS| TIMES| BY| LT| GT| EQ| GEQ| LEQ| NEQ| ASGN| WS| NL;


WHITESPACE : [ \n]+ -> skip;

top : lexemes+;


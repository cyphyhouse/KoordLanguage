
grammar Koord;

tokens { INDENT, DEDENT }

@lexer::members { //this must be put on the top, and not after the grammar rules
                
  private int prevNumSpaces = 0;             
  public static final int INDENT_SIZE = 2;
  private java.util.Queue<Token> tokens = new java.util.LinkedList<>();
  @Override
  public void emit(Token t) {
    super.setToken(t);
    System.out.println("added token" + t.toString());
    tokens.offer(t);
  }

  private CommonToken commonToken(int type, String text) {
    int stop = this.getCharIndex() - 1;
    int start = text.isEmpty() ? stop : stop - text.length() + 1;
    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
  }
  @Override
  public Token nextToken() {
    if (_input.LA(1) == EOF) {
      for (int i = 0; i < prevNumSpaces; i++) {
        emit(commonToken(KoordParser.DEDENT, "dedent"));
      }
    }
    Token next = super.nextToken();
    return tokens.isEmpty() ? next : tokens.poll();
  }
}

AGENT: 'agent';
MODULE:'module';

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
      int numSpaces = (int) getText().chars().filter(x -> x == ' ').count() / INDENT_SIZE;
      System.out.println("numspaces is " + numSpaces);
      System.out.println("prevnumspaces is " + prevNumSpaces);
      if (_input.LA(1) != '\n')            {
        emit(commonToken(NEWLINE, "newline"));

        if (numSpaces > prevNumSpaces) {
          for (int i = 0; i < numSpaces - prevNumSpaces; i++) {
            emit(commonToken(KoordParser.INDENT, "indent"));
            System.out.println("indent emitted");
          }
        } else if (prevNumSpaces > numSpaces ) {
          for (int i = 0; i < prevNumSpaces - numSpaces; i++) {
            emit(commonToken(KoordParser.DEDENT, "dedent"));
            System.out.println("dedent emitted");
          }
        } 
        prevNumSpaces = numSpaces;
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


program : /* defs  module+  decblock  init? */ event+;
defs : funcdef* /* adtdef* */;
funcdef : DEF FUN LID LPAR param+ RPAR COLON stmt+;
//adtdef : DEF ADT LID COLON decl+;
param : TYPE LID;

event : LID COLON NEWLINE INDENT PRE COLON LPAR expr RPAR NEWLINE EFF COLON NEWLINE statementblock DEDENT;
statementblock : INDENT stmt+ DEDENT;

stmt : assign NEWLINE; //add later

assign : LID ASGN expr;
expr : bexpr; //more

bexpr : bexpr relop bexpr | LID ; //more
relop : EQ; //more


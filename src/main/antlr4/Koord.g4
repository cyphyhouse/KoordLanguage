
grammar Koord;

tokens { INDENT, DEDENT }

@lexer::header {
  import java.util.*;             
}

@lexer::members { //this must be put on the top, and not after the grammar rules
//     modified from https://github.com/antlr/grammars-v4/blob/master/python3/Python3.g4           
  private int prevNumSpaces = 0;             
  private Queue<Token> tokens = new LinkedList<>();
  private Deque<Integer> spaces = new LinkedList<>();

  @Override
  public void emit(Token t) {
    super.setToken(t);
    //System.out.println("added token" + t.toString());
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
    if (_input.LA(1) == EOF && !spaces.isEmpty()) {
        if (spaces.peek() != 0) {

            emit(commonToken(KoordParser.NEWLINE, "<newline>"));
            while (spaces.peek() != 0) {
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
STRINGTYPE:'string';
STREAM : 'stream';


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
AND : '&&' | 'and';
OR : '||' | 'or';
NOT : '!';
fragment LID : [a-z][a-zA-Z0-9]*; //difference betwee lid and cid???

fragment CID : [A-Z][a-zA-Z0-9]*;
MODULENAME : CID;
VARNAME : LID | (CID '.' LID);
INUM : [0-9]+;
FNUM : [0-9]+[.][0-9]+;
PLUS : '+';
MINUS : '-';
TIMES : '*';
BY : '/';
EQ : '==';
GEQ : '>=';
LEQ : '<=';
NEQ : '!=';
ASGN : '=';
LSHIFT : '<<';

STRING : '"' (~('"'))*? '"';

NEWLINE
 :  '\n' WS?
  
   {
//     modified from https://github.com/antlr/grammars-v4/blob/master/python3/Python3.g4           
      if (spaces.isEmpty()) {
        spaces.push(0);
      }
      Integer numSpaces = (int) getText().chars().filter(x -> x == ' ').count();
      if (_input.LA(1) != '\n')            {
        emit(commonToken(NEWLINE, "<newline>"));

        if (numSpaces > spaces.peek()) {
            emit(commonToken(KoordParser.INDENT, "<indent>"));
            spaces.push(numSpaces);
        } else if (spaces.peek() > numSpaces ) {
          while (spaces.peek() > numSpaces) {

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



program :  NEWLINE? defs  module*   decblock*   init?  event+ EOF;
defs : funcdef* /* adtdef* */;
funcdef : DEF FUN VARNAME LPAR param* RPAR COLON NEWLINE statementblock;
//adtdef : DEF ADT VARNAME COLON decl+;
param : TYPE VARNAME;

event : VARNAME COLON NEWLINE INDENT PRE COLON expr NEWLINE EFF COLON NEWLINE statementblock DEDENT;
statementblock : INDENT stmt+ DEDENT;

stmt : assign NEWLINE
     | funccall NEWLINE
     | iostream NEWLINE
     | IF expr COLON NEWLINE statementblock (ELSE COLON NEWLINE statementblock)?
     | ATOMIC COLON NEWLINE statementblock; //add later

iostream : VARNAME LSHIFT expr
    | iostream LSHIFT expr;

funccall : VARNAME LPAR (arglist)? RPAR;

arglist : expr (COMMA expr)*;

assign : VARNAME (LBRACE aexpr RBRACE)? ASGN expr; //assume these can't be nested
expr : aexpr | bexpr; //more

bexpr : 
      NOT bexpr
      | LPAR bexpr RPAR
      | aexpr relop aexpr
      | bexpr AND bexpr
      | bexpr OR bexpr
      | FALSE
      | TRUE
      | VARNAME;
      



aexpr :
      LPAR aexpr RPAR
      | MINUS aexpr
      | aexpr (TIMES | BY)  aexpr
      | aexpr (PLUS | MINUS) aexpr
      | funccall
      | number
      | VARNAME LBRACE aexpr RBRACE
      | NUMAGENTS
      | STRING
      | VARNAME;



number : FNUM | INUM | PID;
relop : LANGLE | RANGLE | GEQ | LEQ | EQ | NEQ; //more


decblock : (ALLWRITE | ALLREAD | LOCAL) COLON NEWLINE INDENT decl+ DEDENT;

decl : (INT | BOOL | FLOAT | POS | QUEUE | STRINGTYPE | STREAM) /* there might be more */ VARNAME (arraydec)? (ASGN expr)? NEWLINE;

arraydec : LBRACE RBRACE;

module : USING MODULENAME COLON NEWLINE INDENT (actuatordecls sensordecls | sensordecls actuatordecls) DEDENT;

actuatordecls : ACTUATORS COLON NEWLINE INDENT decl+ DEDENT;

sensordecls : SENSORS COLON NEWLINE INDENT decl+ DEDENT;

init : INIT COLON NEWLINE statementblock;



// Generated from /Users/johnwang/Desktop/koord/src/main/java/Koord.g4 by ANTLR 4.7.2

  import java.util.*;             

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KoordLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AGENT=1, MODULE=2, USING=3, DEF=4, TYPE=5, FUN=6, ADT=7, ACTUATORS=8, 
		SENSORS=9, ALLWRITE=10, ALLREAD=11, LOCAL=12, LIST=13, MAP=14, QUEUE=15, 
		INIT=16, INT=17, FLOAT=18, BOOL=19, POS=20, INPUTMAP=21, IF=22, ELSE=23, 
		ATOMIC=24, PRE=25, EFF=26, TRUE=27, FALSE=28, PID=29, NUMAGENTS=30, COLON=31, 
		COMMA=32, SEMICOLON=33, LPAR=34, RPAR=35, LBRACE=36, RBRACE=37, LCURLY=38, 
		RCURLY=39, LANGLE=40, RANGLE=41, AND=42, OR=43, NOT=44, LID=45, CID=46, 
		INUM=47, FNUM=48, PLUS=49, MINUS=50, TIMES=51, BY=52, EQ=53, GEQ=54, LEQ=55, 
		NEQ=56, ASGN=57, NEWLINE=58, SKIP_=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AGENT", "MODULE", "USING", "DEF", "TYPE", "FUN", "ADT", "ACTUATORS", 
			"SENSORS", "ALLWRITE", "ALLREAD", "LOCAL", "LIST", "MAP", "QUEUE", "INIT", 
			"INT", "FLOAT", "BOOL", "POS", "INPUTMAP", "IF", "ELSE", "ATOMIC", "PRE", 
			"EFF", "TRUE", "FALSE", "PID", "NUMAGENTS", "COLON", "COMMA", "SEMICOLON", 
			"LPAR", "RPAR", "LBRACE", "RBRACE", "LCURLY", "RCURLY", "LANGLE", "RANGLE", 
			"AND", "OR", "NOT", "LID", "CID", "INUM", "FNUM", "PLUS", "MINUS", "TIMES", 
			"BY", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'agent'", "'module'", "'using'", "'def'", "'type'", "'fun'", "'adt'", 
			"'actuators'", "'sensors'", "'allwrite'", "'allread'", "'local'", "'list'", 
			"'map'", "'queue'", "'init'", "'int'", "'float'", "'boolean'", "'pos'", 
			"'inputMap'", "'if'", "'else'", "'atomic'", "'pre'", "'eff'", "'true'", 
			"'false'", "'pid'", "'numAgents'", "':'", "','", "';'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'<'", "'>'", "'&&'", "'||'", "'!'", null, 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'=='", "'>='", "'<='", 
			"'!='", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AGENT", "MODULE", "USING", "DEF", "TYPE", "FUN", "ADT", "ACTUATORS", 
			"SENSORS", "ALLWRITE", "ALLREAD", "LOCAL", "LIST", "MAP", "QUEUE", "INIT", 
			"INT", "FLOAT", "BOOL", "POS", "INPUTMAP", "IF", "ELSE", "ATOMIC", "PRE", 
			"EFF", "TRUE", "FALSE", "PID", "NUMAGENTS", "COLON", "COMMA", "SEMICOLON", 
			"LPAR", "RPAR", "LBRACE", "RBRACE", "LCURLY", "RCURLY", "LANGLE", "RANGLE", 
			"AND", "OR", "NOT", "LID", "CID", "INUM", "FNUM", "PLUS", "MINUS", "TIMES", 
			"BY", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	 //this must be put on the top, and not after the grammar rules
	                
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


	public KoordLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Koord.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 57:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

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
			   
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u0194\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#"+
		"\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3"+
		".\3.\7.\u014c\n.\f.\16.\u014f\13.\3/\3/\7/\u0153\n/\f/\16/\u0156\13/\3"+
		"\60\5\60\u0159\n\60\3\60\6\60\u015c\n\60\r\60\16\60\u015d\3\61\5\61\u0161"+
		"\n\61\3\61\6\61\u0164\n\61\r\61\16\61\u0165\3\61\3\61\6\61\u016a\n\61"+
		"\r\61\16\61\u016b\5\61\u016e\n\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\3:\3:\3;\3;\5;\u0188"+
		"\n;\3;\3;\3<\3<\3<\3<\3=\6=\u0191\n=\r=\16=\u0192\2\2>\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y\2\3\2"+
		"\t\3\2c|\5\2\62;C\\c|\3\2C\\\3\2//\3\2\62;\3\2\60\60\4\2\13\13\"\"\2\u019c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3{\3\2\2\2\5"+
		"\u0081\3\2\2\2\7\u0088\3\2\2\2\t\u008e\3\2\2\2\13\u0092\3\2\2\2\r\u0097"+
		"\3\2\2\2\17\u009b\3\2\2\2\21\u009f\3\2\2\2\23\u00a9\3\2\2\2\25\u00b1\3"+
		"\2\2\2\27\u00ba\3\2\2\2\31\u00c2\3\2\2\2\33\u00c8\3\2\2\2\35\u00cd\3\2"+
		"\2\2\37\u00d1\3\2\2\2!\u00d7\3\2\2\2#\u00dc\3\2\2\2%\u00e0\3\2\2\2\'\u00e6"+
		"\3\2\2\2)\u00ee\3\2\2\2+\u00f2\3\2\2\2-\u00fb\3\2\2\2/\u00fe\3\2\2\2\61"+
		"\u0103\3\2\2\2\63\u010a\3\2\2\2\65\u010e\3\2\2\2\67\u0112\3\2\2\29\u0117"+
		"\3\2\2\2;\u011d\3\2\2\2=\u0121\3\2\2\2?\u012b\3\2\2\2A\u012d\3\2\2\2C"+
		"\u012f\3\2\2\2E\u0131\3\2\2\2G\u0133\3\2\2\2I\u0135\3\2\2\2K\u0137\3\2"+
		"\2\2M\u0139\3\2\2\2O\u013b\3\2\2\2Q\u013d\3\2\2\2S\u013f\3\2\2\2U\u0141"+
		"\3\2\2\2W\u0144\3\2\2\2Y\u0147\3\2\2\2[\u0149\3\2\2\2]\u0150\3\2\2\2_"+
		"\u0158\3\2\2\2a\u0160\3\2\2\2c\u016f\3\2\2\2e\u0171\3\2\2\2g\u0173\3\2"+
		"\2\2i\u0175\3\2\2\2k\u0177\3\2\2\2m\u017a\3\2\2\2o\u017d\3\2\2\2q\u0180"+
		"\3\2\2\2s\u0183\3\2\2\2u\u0185\3\2\2\2w\u018b\3\2\2\2y\u0190\3\2\2\2{"+
		"|\7c\2\2|}\7i\2\2}~\7g\2\2~\177\7p\2\2\177\u0080\7v\2\2\u0080\4\3\2\2"+
		"\2\u0081\u0082\7o\2\2\u0082\u0083\7q\2\2\u0083\u0084\7f\2\2\u0084\u0085"+
		"\7w\2\2\u0085\u0086\7n\2\2\u0086\u0087\7g\2\2\u0087\6\3\2\2\2\u0088\u0089"+
		"\7w\2\2\u0089\u008a\7u\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c"+
		"\u008d\7i\2\2\u008d\b\3\2\2\2\u008e\u008f\7f\2\2\u008f\u0090\7g\2\2\u0090"+
		"\u0091\7h\2\2\u0091\n\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094\7{\2\2\u0094"+
		"\u0095\7r\2\2\u0095\u0096\7g\2\2\u0096\f\3\2\2\2\u0097\u0098\7h\2\2\u0098"+
		"\u0099\7w\2\2\u0099\u009a\7p\2\2\u009a\16\3\2\2\2\u009b\u009c\7c\2\2\u009c"+
		"\u009d\7f\2\2\u009d\u009e\7v\2\2\u009e\20\3\2\2\2\u009f\u00a0\7c\2\2\u00a0"+
		"\u00a1\7e\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4\7c\2\2"+
		"\u00a4\u00a5\7v\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8"+
		"\7u\2\2\u00a8\22\3\2\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac"+
		"\7p\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7t\2\2\u00af"+
		"\u00b0\7u\2\2\u00b0\24\3\2\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7n\2\2\u00b3"+
		"\u00b4\7n\2\2\u00b4\u00b5\7y\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7k\2\2"+
		"\u00b7\u00b8\7v\2\2\u00b8\u00b9\7g\2\2\u00b9\26\3\2\2\2\u00ba\u00bb\7"+
		"c\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7t\2\2\u00be\u00bf"+
		"\7g\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7f\2\2\u00c1\30\3\2\2\2\u00c2\u00c3"+
		"\7n\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7c\2\2\u00c6"+
		"\u00c7\7n\2\2\u00c7\32\3\2\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7k\2\2\u00ca"+
		"\u00cb\7u\2\2\u00cb\u00cc\7v\2\2\u00cc\34\3\2\2\2\u00cd\u00ce\7o\2\2\u00ce"+
		"\u00cf\7c\2\2\u00cf\u00d0\7r\2\2\u00d0\36\3\2\2\2\u00d1\u00d2\7s\2\2\u00d2"+
		"\u00d3\7w\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\7g\2\2"+
		"\u00d6 \3\2\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7p\2\2\u00d9\u00da\7k\2"+
		"\2\u00da\u00db\7v\2\2\u00db\"\3\2\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7"+
		"p\2\2\u00de\u00df\7v\2\2\u00df$\3\2\2\2\u00e0\u00e1\7h\2\2\u00e1\u00e2"+
		"\7n\2\2\u00e2\u00e3\7q\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7v\2\2\u00e5"+
		"&\3\2\2\2\u00e6\u00e7\7d\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7q\2\2\u00e9"+
		"\u00ea\7n\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed\7p\2\2"+
		"\u00ed(\3\2\2\2\u00ee\u00ef\7r\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7u\2"+
		"\2\u00f1*\3\2\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7"+
		"r\2\2\u00f5\u00f6\7w\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7O\2\2\u00f8\u00f9"+
		"\7c\2\2\u00f9\u00fa\7r\2\2\u00fa,\3\2\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd"+
		"\7h\2\2\u00fd.\3\2\2\2\u00fe\u00ff\7g\2\2\u00ff\u0100\7n\2\2\u0100\u0101"+
		"\7u\2\2\u0101\u0102\7g\2\2\u0102\60\3\2\2\2\u0103\u0104\7c\2\2\u0104\u0105"+
		"\7v\2\2\u0105\u0106\7q\2\2\u0106\u0107\7o\2\2\u0107\u0108\7k\2\2\u0108"+
		"\u0109\7e\2\2\u0109\62\3\2\2\2\u010a\u010b\7r\2\2\u010b\u010c\7t\2\2\u010c"+
		"\u010d\7g\2\2\u010d\64\3\2\2\2\u010e\u010f\7g\2\2\u010f\u0110\7h\2\2\u0110"+
		"\u0111\7h\2\2\u0111\66\3\2\2\2\u0112\u0113\7v\2\2\u0113\u0114\7t\2\2\u0114"+
		"\u0115\7w\2\2\u0115\u0116\7g\2\2\u01168\3\2\2\2\u0117\u0118\7h\2\2\u0118"+
		"\u0119\7c\2\2\u0119\u011a\7n\2\2\u011a\u011b\7u\2\2\u011b\u011c\7g\2\2"+
		"\u011c:\3\2\2\2\u011d\u011e\7r\2\2\u011e\u011f\7k\2\2\u011f\u0120\7f\2"+
		"\2\u0120<\3\2\2\2\u0121\u0122\7p\2\2\u0122\u0123\7w\2\2\u0123\u0124\7"+
		"o\2\2\u0124\u0125\7C\2\2\u0125\u0126\7i\2\2\u0126\u0127\7g\2\2\u0127\u0128"+
		"\7p\2\2\u0128\u0129\7v\2\2\u0129\u012a\7u\2\2\u012a>\3\2\2\2\u012b\u012c"+
		"\7<\2\2\u012c@\3\2\2\2\u012d\u012e\7.\2\2\u012eB\3\2\2\2\u012f\u0130\7"+
		"=\2\2\u0130D\3\2\2\2\u0131\u0132\7*\2\2\u0132F\3\2\2\2\u0133\u0134\7+"+
		"\2\2\u0134H\3\2\2\2\u0135\u0136\7]\2\2\u0136J\3\2\2\2\u0137\u0138\7_\2"+
		"\2\u0138L\3\2\2\2\u0139\u013a\7}\2\2\u013aN\3\2\2\2\u013b\u013c\7\177"+
		"\2\2\u013cP\3\2\2\2\u013d\u013e\7>\2\2\u013eR\3\2\2\2\u013f\u0140\7@\2"+
		"\2\u0140T\3\2\2\2\u0141\u0142\7(\2\2\u0142\u0143\7(\2\2\u0143V\3\2\2\2"+
		"\u0144\u0145\7~\2\2\u0145\u0146\7~\2\2\u0146X\3\2\2\2\u0147\u0148\7#\2"+
		"\2\u0148Z\3\2\2\2\u0149\u014d\t\2\2\2\u014a\u014c\t\3\2\2\u014b\u014a"+
		"\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\\\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0154\t\4\2\2\u0151\u0153\t\3\2\2"+
		"\u0152\u0151\3\2\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u0155^\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0159\t\5\2\2\u0158"+
		"\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u015c\t\6"+
		"\2\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e`\3\2\2\2\u015f\u0161\t\5\2\2\u0160\u015f\3\2\2\2"+
		"\u0160\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u0164\t\6\2\2\u0163\u0162"+
		"\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u016d\3\2\2\2\u0167\u0169\t\7\2\2\u0168\u016a\t\6\2\2\u0169\u0168\3\2"+
		"\2\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u016e\3\2\2\2\u016d\u0167\3\2\2\2\u016d\u016e\3\2\2\2\u016eb\3\2\2\2"+
		"\u016f\u0170\7-\2\2\u0170d\3\2\2\2\u0171\u0172\7/\2\2\u0172f\3\2\2\2\u0173"+
		"\u0174\7,\2\2\u0174h\3\2\2\2\u0175\u0176\7\61\2\2\u0176j\3\2\2\2\u0177"+
		"\u0178\7?\2\2\u0178\u0179\7?\2\2\u0179l\3\2\2\2\u017a\u017b\7@\2\2\u017b"+
		"\u017c\7?\2\2\u017cn\3\2\2\2\u017d\u017e\7>\2\2\u017e\u017f\7?\2\2\u017f"+
		"p\3\2\2\2\u0180\u0181\7#\2\2\u0181\u0182\7?\2\2\u0182r\3\2\2\2\u0183\u0184"+
		"\7?\2\2\u0184t\3\2\2\2\u0185\u0187\7\f\2\2\u0186\u0188\5y=\2\u0187\u0186"+
		"\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b;\2\2\u018a"+
		"v\3\2\2\2\u018b\u018c\5y=\2\u018c\u018d\3\2\2\2\u018d\u018e\b<\3\2\u018e"+
		"x\3\2\2\2\u018f\u0191\t\b\2\2\u0190\u018f\3\2\2\2\u0191\u0192\3\2\2\2"+
		"\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193z\3\2\2\2\r\2\u014d\u0154"+
		"\u0158\u015d\u0160\u0165\u016b\u016d\u0187\u0192\4\3;\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
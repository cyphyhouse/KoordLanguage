// Generated from Koord.g4 by ANTLR 4.7.2
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
		AGENT=1, MODULE=2, DEF=3, TYPE=4, FUN=5, ADT=6, ACTUATORS=7, SENSORS=8, 
		ALLWRITE=9, ALLREAD=10, LOCAL=11, LIST=12, MAP=13, QUEUE=14, INIT=15, 
		INT=16, FLOAT=17, BOOL=18, POS=19, IF=20, ELSE=21, ATOMIC=22, PRE=23, 
		EFF=24, TRUE=25, FALSE=26, PID=27, NUMAGENTS=28, COLON=29, COMMA=30, SEMICOLON=31, 
		LPAR=32, RPAR=33, LBRACE=34, RBRACE=35, LCURLY=36, RCURLY=37, LANGLE=38, 
		RANGLE=39, AND=40, OR=41, NOT=42, LID=43, CID=44, INUM=45, FNUM=46, PLUS=47, 
		MINUS=48, TIMES=49, BY=50, EQ=51, GEQ=52, LEQ=53, NEQ=54, ASGN=55, NEWLINE=56, 
		SKIP_=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AGENT", "MODULE", "DEF", "TYPE", "FUN", "ADT", "ACTUATORS", "SENSORS", 
			"ALLWRITE", "ALLREAD", "LOCAL", "LIST", "MAP", "QUEUE", "INIT", "INT", 
			"FLOAT", "BOOL", "POS", "IF", "ELSE", "ATOMIC", "PRE", "EFF", "TRUE", 
			"FALSE", "PID", "NUMAGENTS", "COLON", "COMMA", "SEMICOLON", "LPAR", "RPAR", 
			"LBRACE", "RBRACE", "LCURLY", "RCURLY", "LANGLE", "RANGLE", "AND", "OR", 
			"NOT", "LID", "CID", "INUM", "FNUM", "PLUS", "MINUS", "TIMES", "BY", 
			"EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'agent'", "'module'", "'def'", "'type'", "'fun'", "'adt'", "'actuators'", 
			"'sensors'", "'allwrite'", "'allread'", "'local'", "'list'", "'map'", 
			"'queue'", "'init'", "'int'", "'float'", "'boolean'", "'pos'", "'if'", 
			"'else'", "'atomic'", "'pre'", "'eff'", "'true'", "'false'", "'pid'", 
			"'numAgents'", "':'", "','", "';'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'<'", "'>'", "'&&'", "'||'", "'!'", null, null, null, null, "'+'", 
			"'-'", "'*'", "'/'", "'=='", "'>='", "'<='", "'!='", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AGENT", "MODULE", "DEF", "TYPE", "FUN", "ADT", "ACTUATORS", "SENSORS", 
			"ALLWRITE", "ALLREAD", "LOCAL", "LIST", "MAP", "QUEUE", "INIT", "INT", 
			"FLOAT", "BOOL", "POS", "IF", "ELSE", "ATOMIC", "PRE", "EFF", "TRUE", 
			"FALSE", "PID", "NUMAGENTS", "COLON", "COMMA", "SEMICOLON", "LPAR", "RPAR", 
			"LBRACE", "RBRACE", "LCURLY", "RCURLY", "LANGLE", "RANGLE", "AND", "OR", 
			"NOT", "LID", "CID", "INUM", "FNUM", "PLUS", "MINUS", "TIMES", "BY", 
			"EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_"
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
		case 55:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

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
			   
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u0181\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\7,\u0139"+
		"\n,\f,\16,\u013c\13,\3-\3-\7-\u0140\n-\f-\16-\u0143\13-\3.\5.\u0146\n"+
		".\3.\6.\u0149\n.\r.\16.\u014a\3/\5/\u014e\n/\3/\6/\u0151\n/\r/\16/\u0152"+
		"\3/\3/\6/\u0157\n/\r/\16/\u0158\5/\u015b\n/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3"+
		"\67\38\38\39\39\59\u0175\n9\39\39\3:\3:\3:\3:\3;\6;\u017e\n;\r;\16;\u017f"+
		"\2\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u\2\3\2\t\3\2c|\5\2\62;C\\c|\3\2C\\\3\2//\3\2\62;\3\2\60\60\4"+
		"\2\13\13\"\"\2\u0189\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2"+
		"\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3w\3\2\2\2\5}"+
		"\3\2\2\2\7\u0084\3\2\2\2\t\u0088\3\2\2\2\13\u008d\3\2\2\2\r\u0091\3\2"+
		"\2\2\17\u0095\3\2\2\2\21\u009f\3\2\2\2\23\u00a7\3\2\2\2\25\u00b0\3\2\2"+
		"\2\27\u00b8\3\2\2\2\31\u00be\3\2\2\2\33\u00c3\3\2\2\2\35\u00c7\3\2\2\2"+
		"\37\u00cd\3\2\2\2!\u00d2\3\2\2\2#\u00d6\3\2\2\2%\u00dc\3\2\2\2\'\u00e4"+
		"\3\2\2\2)\u00e8\3\2\2\2+\u00eb\3\2\2\2-\u00f0\3\2\2\2/\u00f7\3\2\2\2\61"+
		"\u00fb\3\2\2\2\63\u00ff\3\2\2\2\65\u0104\3\2\2\2\67\u010a\3\2\2\29\u010e"+
		"\3\2\2\2;\u0118\3\2\2\2=\u011a\3\2\2\2?\u011c\3\2\2\2A\u011e\3\2\2\2C"+
		"\u0120\3\2\2\2E\u0122\3\2\2\2G\u0124\3\2\2\2I\u0126\3\2\2\2K\u0128\3\2"+
		"\2\2M\u012a\3\2\2\2O\u012c\3\2\2\2Q\u012e\3\2\2\2S\u0131\3\2\2\2U\u0134"+
		"\3\2\2\2W\u0136\3\2\2\2Y\u013d\3\2\2\2[\u0145\3\2\2\2]\u014d\3\2\2\2_"+
		"\u015c\3\2\2\2a\u015e\3\2\2\2c\u0160\3\2\2\2e\u0162\3\2\2\2g\u0164\3\2"+
		"\2\2i\u0167\3\2\2\2k\u016a\3\2\2\2m\u016d\3\2\2\2o\u0170\3\2\2\2q\u0172"+
		"\3\2\2\2s\u0178\3\2\2\2u\u017d\3\2\2\2wx\7c\2\2xy\7i\2\2yz\7g\2\2z{\7"+
		"p\2\2{|\7v\2\2|\4\3\2\2\2}~\7o\2\2~\177\7q\2\2\177\u0080\7f\2\2\u0080"+
		"\u0081\7w\2\2\u0081\u0082\7n\2\2\u0082\u0083\7g\2\2\u0083\6\3\2\2\2\u0084"+
		"\u0085\7f\2\2\u0085\u0086\7g\2\2\u0086\u0087\7h\2\2\u0087\b\3\2\2\2\u0088"+
		"\u0089\7v\2\2\u0089\u008a\7{\2\2\u008a\u008b\7r\2\2\u008b\u008c\7g\2\2"+
		"\u008c\n\3\2\2\2\u008d\u008e\7h\2\2\u008e\u008f\7w\2\2\u008f\u0090\7p"+
		"\2\2\u0090\f\3\2\2\2\u0091\u0092\7c\2\2\u0092\u0093\7f\2\2\u0093\u0094"+
		"\7v\2\2\u0094\16\3\2\2\2\u0095\u0096\7c\2\2\u0096\u0097\7e\2\2\u0097\u0098"+
		"\7v\2\2\u0098\u0099\7w\2\2\u0099\u009a\7c\2\2\u009a\u009b\7v\2\2\u009b"+
		"\u009c\7q\2\2\u009c\u009d\7t\2\2\u009d\u009e\7u\2\2\u009e\20\3\2\2\2\u009f"+
		"\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7u\2\2"+
		"\u00a3\u00a4\7q\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7u\2\2\u00a6\22\3\2"+
		"\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab"+
		"\7y\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7v\2\2\u00ae"+
		"\u00af\7g\2\2\u00af\24\3\2\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7n\2\2\u00b2"+
		"\u00b3\7n\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7c\2\2"+
		"\u00b6\u00b7\7f\2\2\u00b7\26\3\2\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7"+
		"q\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7n\2\2\u00bd\30"+
		"\3\2\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7u\2\2\u00c1"+
		"\u00c2\7v\2\2\u00c2\32\3\2\2\2\u00c3\u00c4\7o\2\2\u00c4\u00c5\7c\2\2\u00c5"+
		"\u00c6\7r\2\2\u00c6\34\3\2\2\2\u00c7\u00c8\7s\2\2\u00c8\u00c9\7w\2\2\u00c9"+
		"\u00ca\7g\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7g\2\2\u00cc\36\3\2\2\2\u00cd"+
		"\u00ce\7k\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7v\2\2"+
		"\u00d1 \3\2\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7v\2"+
		"\2\u00d5\"\3\2\2\2\u00d6\u00d7\7h\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7"+
		"q\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7v\2\2\u00db$\3\2\2\2\u00dc\u00dd"+
		"\7d\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7n\2\2\u00e0"+
		"\u00e1\7g\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7p\2\2\u00e3&\3\2\2\2\u00e4"+
		"\u00e5\7r\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7u\2\2\u00e7(\3\2\2\2\u00e8"+
		"\u00e9\7k\2\2\u00e9\u00ea\7h\2\2\u00ea*\3\2\2\2\u00eb\u00ec\7g\2\2\u00ec"+
		"\u00ed\7n\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7g\2\2\u00ef,\3\2\2\2\u00f0"+
		"\u00f1\7c\2\2\u00f1\u00f2\7v\2\2\u00f2\u00f3\7q\2\2\u00f3\u00f4\7o\2\2"+
		"\u00f4\u00f5\7k\2\2\u00f5\u00f6\7e\2\2\u00f6.\3\2\2\2\u00f7\u00f8\7r\2"+
		"\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7g\2\2\u00fa\60\3\2\2\2\u00fb\u00fc"+
		"\7g\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe\7h\2\2\u00fe\62\3\2\2\2\u00ff\u0100"+
		"\7v\2\2\u0100\u0101\7t\2\2\u0101\u0102\7w\2\2\u0102\u0103\7g\2\2\u0103"+
		"\64\3\2\2\2\u0104\u0105\7h\2\2\u0105\u0106\7c\2\2\u0106\u0107\7n\2\2\u0107"+
		"\u0108\7u\2\2\u0108\u0109\7g\2\2\u0109\66\3\2\2\2\u010a\u010b\7r\2\2\u010b"+
		"\u010c\7k\2\2\u010c\u010d\7f\2\2\u010d8\3\2\2\2\u010e\u010f\7p\2\2\u010f"+
		"\u0110\7w\2\2\u0110\u0111\7o\2\2\u0111\u0112\7C\2\2\u0112\u0113\7i\2\2"+
		"\u0113\u0114\7g\2\2\u0114\u0115\7p\2\2\u0115\u0116\7v\2\2\u0116\u0117"+
		"\7u\2\2\u0117:\3\2\2\2\u0118\u0119\7<\2\2\u0119<\3\2\2\2\u011a\u011b\7"+
		".\2\2\u011b>\3\2\2\2\u011c\u011d\7=\2\2\u011d@\3\2\2\2\u011e\u011f\7*"+
		"\2\2\u011fB\3\2\2\2\u0120\u0121\7+\2\2\u0121D\3\2\2\2\u0122\u0123\7]\2"+
		"\2\u0123F\3\2\2\2\u0124\u0125\7_\2\2\u0125H\3\2\2\2\u0126\u0127\7}\2\2"+
		"\u0127J\3\2\2\2\u0128\u0129\7\177\2\2\u0129L\3\2\2\2\u012a\u012b\7>\2"+
		"\2\u012bN\3\2\2\2\u012c\u012d\7@\2\2\u012dP\3\2\2\2\u012e\u012f\7(\2\2"+
		"\u012f\u0130\7(\2\2\u0130R\3\2\2\2\u0131\u0132\7~\2\2\u0132\u0133\7~\2"+
		"\2\u0133T\3\2\2\2\u0134\u0135\7#\2\2\u0135V\3\2\2\2\u0136\u013a\t\2\2"+
		"\2\u0137\u0139\t\3\2\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013bX\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u0141\t\4\2\2\u013e\u0140\t\3\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142Z\3\2\2\2\u0143\u0141"+
		"\3\2\2\2\u0144\u0146\t\5\2\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0148\3\2\2\2\u0147\u0149\t\6\2\2\u0148\u0147\3\2\2\2\u0149\u014a\3\2"+
		"\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\\\3\2\2\2\u014c\u014e"+
		"\t\5\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0150\3\2\2\2\u014f"+
		"\u0151\t\6\2\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u015a\3\2\2\2\u0154\u0156\t\7\2\2\u0155"+
		"\u0157\t\6\2\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0156\3\2"+
		"\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0154\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b^\3\2\2\2\u015c\u015d\7-\2\2\u015d`\3\2\2\2\u015e"+
		"\u015f\7/\2\2\u015fb\3\2\2\2\u0160\u0161\7,\2\2\u0161d\3\2\2\2\u0162\u0163"+
		"\7\61\2\2\u0163f\3\2\2\2\u0164\u0165\7?\2\2\u0165\u0166\7?\2\2\u0166h"+
		"\3\2\2\2\u0167\u0168\7@\2\2\u0168\u0169\7?\2\2\u0169j\3\2\2\2\u016a\u016b"+
		"\7>\2\2\u016b\u016c\7?\2\2\u016cl\3\2\2\2\u016d\u016e\7#\2\2\u016e\u016f"+
		"\7?\2\2\u016fn\3\2\2\2\u0170\u0171\7?\2\2\u0171p\3\2\2\2\u0172\u0174\7"+
		"\f\2\2\u0173\u0175\5u;\2\u0174\u0173\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u0176\3\2\2\2\u0176\u0177\b9\2\2\u0177r\3\2\2\2\u0178\u0179\5u;\2\u0179"+
		"\u017a\3\2\2\2\u017a\u017b\b:\3\2\u017bt\3\2\2\2\u017c\u017e\t\b\2\2\u017d"+
		"\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180v\3\2\2\2\r\2\u013a\u0141\u0145\u014a\u014d\u0152\u0158\u015a"+
		"\u0174\u017f\4\39\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
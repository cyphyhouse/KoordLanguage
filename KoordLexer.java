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
		AGENT=1, MODULE=2, DEF=3, TYPE=4, FUN=5, ACTUATORS=6, SENSORS=7, ALLWRITE=8, 
		ALLREAD=9, LOCAL=10, LIST=11, MAP=12, QUEUE=13, INIT=14, INT=15, FLOAT=16, 
		BOOL=17, POS=18, IF=19, ELSE=20, ATOMIC=21, PRE=22, EFF=23, TRUE=24, FALSE=25, 
		PID=26, NUMAGENTS=27, COLON=28, COMMA=29, SEMICOLON=30, LPAR=31, RPAR=32, 
		LBRACE=33, RBRACE=34, LCURLY=35, RCURLY=36, LANGLE=37, RANGLE=38, AND=39, 
		OR=40, NOT=41, LID=42, CID=43, INUM=44, FNUM=45, PLUS=46, MINUS=47, TIMES=48, 
		BY=49, LT=50, GT=51, EQ=52, GEQ=53, LEQ=54, NEQ=55, ASGN=56, NEWLINE=57, 
		SKIP_=58;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AGENT", "MODULE", "DEF", "TYPE", "FUN", "ACTUATORS", "SENSORS", "ALLWRITE", 
			"ALLREAD", "LOCAL", "LIST", "MAP", "QUEUE", "INIT", "INT", "FLOAT", "BOOL", 
			"POS", "IF", "ELSE", "ATOMIC", "PRE", "EFF", "TRUE", "FALSE", "PID", 
			"NUMAGENTS", "COLON", "COMMA", "SEMICOLON", "LPAR", "RPAR", "LBRACE", 
			"RBRACE", "LCURLY", "RCURLY", "LANGLE", "RANGLE", "AND", "OR", "NOT", 
			"LID", "CID", "INUM", "FNUM", "PLUS", "MINUS", "TIMES", "BY", "LT", "GT", 
			"EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'agent'", "'module'", "'def '", "'type '", "'fun '", "'actuators'", 
			"'sensors'", "'allwrite'", "'allread'", "'local'", "'list'", "'map'", 
			"'queue'", "'init'", "'int'", "'float'", "'bool'", "'pos'", "'if'", "'else'", 
			"'atomic'", "'pre'", "'eff'", "'true'", "'false'", "'pid'", "'numAgents'", 
			"':'", "','", "';'", "'('", "')'", "'['", "']'", "'{'", "'}'", null, 
			null, "'&&'", "'||'", "'!'", null, null, null, null, "'+'", "'-'", "'*'", 
			"'/'", null, null, "'=='", "'>='", "'<='", "'!='", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AGENT", "MODULE", "DEF", "TYPE", "FUN", "ACTUATORS", "SENSORS", 
			"ALLWRITE", "ALLREAD", "LOCAL", "LIST", "MAP", "QUEUE", "INIT", "INT", 
			"FLOAT", "BOOL", "POS", "IF", "ELSE", "ATOMIC", "PRE", "EFF", "TRUE", 
			"FALSE", "PID", "NUMAGENTS", "COLON", "COMMA", "SEMICOLON", "LPAR", "RPAR", 
			"LBRACE", "RBRACE", "LCURLY", "RCURLY", "LANGLE", "RANGLE", "AND", "OR", 
			"NOT", "LID", "CID", "INUM", "FNUM", "PLUS", "MINUS", "TIMES", "BY", 
			"LT", "GT", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_"
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


	  private int prevNumSpaces = 0;             


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
		case 56:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			      int numSpaces = (int) getText().chars().filter(x -> x == ' ').count();
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
			   
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2<\u0183\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\7+\u0137\n+\f+\16+\u013a"+
		"\13+\3,\3,\7,\u013e\n,\f,\16,\u0141\13,\3-\5-\u0144\n-\3-\6-\u0147\n-"+
		"\r-\16-\u0148\3.\5.\u014c\n.\3.\6.\u014f\n.\r.\16.\u0150\3.\3.\6.\u0155"+
		"\n.\r.\16.\u0156\5.\u0159\n.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63"+
		"\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38"+
		"\39\39\3:\3:\5:\u0177\n:\3:\3:\3;\3;\3;\3;\3<\6<\u0180\n<\r<\16<\u0181"+
		"\2\2=\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w\2\3\2\t\3\2c|\5\2\62;C\\c|\3\2C\\\3\2//\3\2\62;\3\2\60\60"+
		"\4\2\13\13\"\"\2\u018b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3"+
		"y\3\2\2\2\5\177\3\2\2\2\7\u0086\3\2\2\2\t\u008b\3\2\2\2\13\u0091\3\2\2"+
		"\2\r\u0096\3\2\2\2\17\u00a0\3\2\2\2\21\u00a8\3\2\2\2\23\u00b1\3\2\2\2"+
		"\25\u00b9\3\2\2\2\27\u00bf\3\2\2\2\31\u00c4\3\2\2\2\33\u00c8\3\2\2\2\35"+
		"\u00ce\3\2\2\2\37\u00d3\3\2\2\2!\u00d7\3\2\2\2#\u00dd\3\2\2\2%\u00e2\3"+
		"\2\2\2\'\u00e6\3\2\2\2)\u00e9\3\2\2\2+\u00ee\3\2\2\2-\u00f5\3\2\2\2/\u00f9"+
		"\3\2\2\2\61\u00fd\3\2\2\2\63\u0102\3\2\2\2\65\u0108\3\2\2\2\67\u010c\3"+
		"\2\2\29\u0116\3\2\2\2;\u0118\3\2\2\2=\u011a\3\2\2\2?\u011c\3\2\2\2A\u011e"+
		"\3\2\2\2C\u0120\3\2\2\2E\u0122\3\2\2\2G\u0124\3\2\2\2I\u0126\3\2\2\2K"+
		"\u0128\3\2\2\2M\u012a\3\2\2\2O\u012c\3\2\2\2Q\u012f\3\2\2\2S\u0132\3\2"+
		"\2\2U\u0134\3\2\2\2W\u013b\3\2\2\2Y\u0143\3\2\2\2[\u014b\3\2\2\2]\u015a"+
		"\3\2\2\2_\u015c\3\2\2\2a\u015e\3\2\2\2c\u0160\3\2\2\2e\u0162\3\2\2\2g"+
		"\u0164\3\2\2\2i\u0166\3\2\2\2k\u0169\3\2\2\2m\u016c\3\2\2\2o\u016f\3\2"+
		"\2\2q\u0172\3\2\2\2s\u0174\3\2\2\2u\u017a\3\2\2\2w\u017f\3\2\2\2yz\7c"+
		"\2\2z{\7i\2\2{|\7g\2\2|}\7p\2\2}~\7v\2\2~\4\3\2\2\2\177\u0080\7o\2\2\u0080"+
		"\u0081\7q\2\2\u0081\u0082\7f\2\2\u0082\u0083\7w\2\2\u0083\u0084\7n\2\2"+
		"\u0084\u0085\7g\2\2\u0085\6\3\2\2\2\u0086\u0087\7f\2\2\u0087\u0088\7g"+
		"\2\2\u0088\u0089\7h\2\2\u0089\u008a\7\"\2\2\u008a\b\3\2\2\2\u008b\u008c"+
		"\7v\2\2\u008c\u008d\7{\2\2\u008d\u008e\7r\2\2\u008e\u008f\7g\2\2\u008f"+
		"\u0090\7\"\2\2\u0090\n\3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093\7w\2\2\u0093"+
		"\u0094\7p\2\2\u0094\u0095\7\"\2\2\u0095\f\3\2\2\2\u0096\u0097\7c\2\2\u0097"+
		"\u0098\7e\2\2\u0098\u0099\7v\2\2\u0099\u009a\7w\2\2\u009a\u009b\7c\2\2"+
		"\u009b\u009c\7v\2\2\u009c\u009d\7q\2\2\u009d\u009e\7t\2\2\u009e\u009f"+
		"\7u\2\2\u009f\16\3\2\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3"+
		"\7p\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7t\2\2\u00a6"+
		"\u00a7\7u\2\2\u00a7\20\3\2\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7n\2\2\u00aa"+
		"\u00ab\7n\2\2\u00ab\u00ac\7y\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7k\2\2"+
		"\u00ae\u00af\7v\2\2\u00af\u00b0\7g\2\2\u00b0\22\3\2\2\2\u00b1\u00b2\7"+
		"c\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6"+
		"\7g\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7f\2\2\u00b8\24\3\2\2\2\u00b9\u00ba"+
		"\7n\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7e\2\2\u00bc\u00bd\7c\2\2\u00bd"+
		"\u00be\7n\2\2\u00be\26\3\2\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7k\2\2\u00c1"+
		"\u00c2\7u\2\2\u00c2\u00c3\7v\2\2\u00c3\30\3\2\2\2\u00c4\u00c5\7o\2\2\u00c5"+
		"\u00c6\7c\2\2\u00c6\u00c7\7r\2\2\u00c7\32\3\2\2\2\u00c8\u00c9\7s\2\2\u00c9"+
		"\u00ca\7w\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd\7g\2\2"+
		"\u00cd\34\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7"+
		"k\2\2\u00d1\u00d2\7v\2\2\u00d2\36\3\2\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5"+
		"\7p\2\2\u00d5\u00d6\7v\2\2\u00d6 \3\2\2\2\u00d7\u00d8\7h\2\2\u00d8\u00d9"+
		"\7n\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\"\3\2\2\2\u00dd\u00de\7d\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7q\2\2\u00e0"+
		"\u00e1\7n\2\2\u00e1$\3\2\2\2\u00e2\u00e3\7r\2\2\u00e3\u00e4\7q\2\2\u00e4"+
		"\u00e5\7u\2\2\u00e5&\3\2\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7h\2\2\u00e8"+
		"(\3\2\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7u\2\2\u00ec"+
		"\u00ed\7g\2\2\u00ed*\3\2\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7v\2\2\u00f0"+
		"\u00f1\7q\2\2\u00f1\u00f2\7o\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7e\2\2"+
		"\u00f4,\3\2\2\2\u00f5\u00f6\7r\2\2\u00f6\u00f7\7t\2\2\u00f7\u00f8\7g\2"+
		"\2\u00f8.\3\2\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7h\2\2\u00fb\u00fc\7"+
		"h\2\2\u00fc\60\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100"+
		"\7w\2\2\u0100\u0101\7g\2\2\u0101\62\3\2\2\2\u0102\u0103\7h\2\2\u0103\u0104"+
		"\7c\2\2\u0104\u0105\7n\2\2\u0105\u0106\7u\2\2\u0106\u0107\7g\2\2\u0107"+
		"\64\3\2\2\2\u0108\u0109\7r\2\2\u0109\u010a\7k\2\2\u010a\u010b\7f\2\2\u010b"+
		"\66\3\2\2\2\u010c\u010d\7p\2\2\u010d\u010e\7w\2\2\u010e\u010f\7o\2\2\u010f"+
		"\u0110\7C\2\2\u0110\u0111\7i\2\2\u0111\u0112\7g\2\2\u0112\u0113\7p\2\2"+
		"\u0113\u0114\7v\2\2\u0114\u0115\7u\2\2\u01158\3\2\2\2\u0116\u0117\7<\2"+
		"\2\u0117:\3\2\2\2\u0118\u0119\7.\2\2\u0119<\3\2\2\2\u011a\u011b\7=\2\2"+
		"\u011b>\3\2\2\2\u011c\u011d\7*\2\2\u011d@\3\2\2\2\u011e\u011f\7+\2\2\u011f"+
		"B\3\2\2\2\u0120\u0121\7]\2\2\u0121D\3\2\2\2\u0122\u0123\7_\2\2\u0123F"+
		"\3\2\2\2\u0124\u0125\7}\2\2\u0125H\3\2\2\2\u0126\u0127\7\177\2\2\u0127"+
		"J\3\2\2\2\u0128\u0129\7>\2\2\u0129L\3\2\2\2\u012a\u012b\7@\2\2\u012bN"+
		"\3\2\2\2\u012c\u012d\7(\2\2\u012d\u012e\7(\2\2\u012eP\3\2\2\2\u012f\u0130"+
		"\7~\2\2\u0130\u0131\7~\2\2\u0131R\3\2\2\2\u0132\u0133\7#\2\2\u0133T\3"+
		"\2\2\2\u0134\u0138\t\2\2\2\u0135\u0137\t\3\2\2\u0136\u0135\3\2\2\2\u0137"+
		"\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139V\3\2\2\2"+
		"\u013a\u0138\3\2\2\2\u013b\u013f\t\4\2\2\u013c\u013e\t\3\2\2\u013d\u013c"+
		"\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140"+
		"X\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0144\t\5\2\2\u0143\u0142\3\2\2\2"+
		"\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0147\t\6\2\2\u0146\u0145"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"Z\3\2\2\2\u014a\u014c\t\5\2\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2"+
		"\u014c\u014e\3\2\2\2\u014d\u014f\t\6\2\2\u014e\u014d\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0158\3\2\2\2\u0152"+
		"\u0154\t\7\2\2\u0153\u0155\t\6\2\2\u0154\u0153\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2\2\2\u0158"+
		"\u0152\3\2\2\2\u0158\u0159\3\2\2\2\u0159\\\3\2\2\2\u015a\u015b\7-\2\2"+
		"\u015b^\3\2\2\2\u015c\u015d\7/\2\2\u015d`\3\2\2\2\u015e\u015f\7,\2\2\u015f"+
		"b\3\2\2\2\u0160\u0161\7\61\2\2\u0161d\3\2\2\2\u0162\u0163\7>\2\2\u0163"+
		"f\3\2\2\2\u0164\u0165\7@\2\2\u0165h\3\2\2\2\u0166\u0167\7?\2\2\u0167\u0168"+
		"\7?\2\2\u0168j\3\2\2\2\u0169\u016a\7@\2\2\u016a\u016b\7?\2\2\u016bl\3"+
		"\2\2\2\u016c\u016d\7>\2\2\u016d\u016e\7?\2\2\u016en\3\2\2\2\u016f\u0170"+
		"\7#\2\2\u0170\u0171\7?\2\2\u0171p\3\2\2\2\u0172\u0173\7?\2\2\u0173r\3"+
		"\2\2\2\u0174\u0176\7\f\2\2\u0175\u0177\5w<\2\u0176\u0175\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\b:\2\2\u0179t\3\2\2\2\u017a"+
		"\u017b\5w<\2\u017b\u017c\3\2\2\2\u017c\u017d\b;\3\2\u017dv\3\2\2\2\u017e"+
		"\u0180\t\b\2\2\u017f\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u017f\3\2"+
		"\2\2\u0181\u0182\3\2\2\2\u0182x\3\2\2\2\r\2\u0138\u013f\u0143\u0148\u014b"+
		"\u0150\u0156\u0158\u0176\u0181\4\3:\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
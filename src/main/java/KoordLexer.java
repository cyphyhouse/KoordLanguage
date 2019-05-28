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
		RCURLY=39, LANGLE=40, RANGLE=41, AND=42, OR=43, NOT=44, MODULENAME=45, 
		VARNAME=46, INUM=47, FNUM=48, PLUS=49, MINUS=50, TIMES=51, BY=52, EQ=53, 
		GEQ=54, LEQ=55, NEQ=56, ASGN=57, NEWLINE=58, SKIP_=59;
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
			"AND", "OR", "NOT", "LID", "CID", "MODULENAME", "VARNAME", "INUM", "FNUM", 
			"PLUS", "MINUS", "TIMES", "BY", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", 
			"SKIP_", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'agent'", "'module'", "'using'", "'def'", "'type'", "'fun'", "'adt'", 
			"'actuators'", "'sensors'", "'allwrite'", "'allread'", "'local'", "'list'", 
			"'map'", "'queue'", "'init'", "'int'", "'float'", "'boolean'", "'pos'", 
			"'inputMap'", "'if'", "'else'", "'atomic'", "'pre'", "'eff'", "'true'", 
			"'false'", "'pid'", "'numBots'", "':'", "','", "';'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'<'", "'>'", null, null, "'!'", null, null, null, 
			null, "'+'", "'-'", "'*'", "'/'", "'=='", "'>='", "'<='", "'!='", "'='"
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
			"AND", "OR", "NOT", "MODULENAME", "VARNAME", "INUM", "FNUM", "PLUS", 
			"MINUS", "TIMES", "BY", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", 
			"SKIP_"
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
		case 59:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u01a0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3+\5+\u0149"+
		"\n+\3,\3,\3,\3,\5,\u014f\n,\3-\3-\3.\3.\7.\u0155\n.\f.\16.\u0158\13.\3"+
		"/\3/\7/\u015c\n/\f/\16/\u015f\13/\3\60\3\60\3\61\3\61\3\61\3\61\3\61\5"+
		"\61\u0168\n\61\3\62\6\62\u016b\n\62\r\62\16\62\u016c\3\63\6\63\u0170\n"+
		"\63\r\63\16\63\u0171\3\63\3\63\6\63\u0176\n\63\r\63\16\63\u0177\5\63\u017a"+
		"\n\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\39\39\39\3:\3:"+
		"\3:\3;\3;\3;\3<\3<\3=\3=\5=\u0194\n=\3=\3=\3>\3>\3>\3>\3?\6?\u019d\n?"+
		"\r?\16?\u019e\2\2@\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[\2]\2_/a\60c\61e"+
		"\62g\63i\64k\65m\66o\67q8s9u:w;y<{=}\2\3\2\b\3\2c|\5\2\62;C\\c|\3\2C\\"+
		"\3\2\62;\3\2\60\60\4\2\13\13\"\"\2\u01a7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2"+
		"k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3"+
		"\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3\177\3\2\2\2\5\u0085\3\2\2\2\7\u008c\3\2"+
		"\2\2\t\u0092\3\2\2\2\13\u0096\3\2\2\2\r\u009b\3\2\2\2\17\u009f\3\2\2\2"+
		"\21\u00a3\3\2\2\2\23\u00ad\3\2\2\2\25\u00b5\3\2\2\2\27\u00be\3\2\2\2\31"+
		"\u00c6\3\2\2\2\33\u00cc\3\2\2\2\35\u00d1\3\2\2\2\37\u00d5\3\2\2\2!\u00db"+
		"\3\2\2\2#\u00e0\3\2\2\2%\u00e4\3\2\2\2\'\u00ea\3\2\2\2)\u00f2\3\2\2\2"+
		"+\u00f6\3\2\2\2-\u00ff\3\2\2\2/\u0102\3\2\2\2\61\u0107\3\2\2\2\63\u010e"+
		"\3\2\2\2\65\u0112\3\2\2\2\67\u0116\3\2\2\29\u011b\3\2\2\2;\u0121\3\2\2"+
		"\2=\u0125\3\2\2\2?\u012d\3\2\2\2A\u012f\3\2\2\2C\u0131\3\2\2\2E\u0133"+
		"\3\2\2\2G\u0135\3\2\2\2I\u0137\3\2\2\2K\u0139\3\2\2\2M\u013b\3\2\2\2O"+
		"\u013d\3\2\2\2Q\u013f\3\2\2\2S\u0141\3\2\2\2U\u0148\3\2\2\2W\u014e\3\2"+
		"\2\2Y\u0150\3\2\2\2[\u0152\3\2\2\2]\u0159\3\2\2\2_\u0160\3\2\2\2a\u0167"+
		"\3\2\2\2c\u016a\3\2\2\2e\u016f\3\2\2\2g\u017b\3\2\2\2i\u017d\3\2\2\2k"+
		"\u017f\3\2\2\2m\u0181\3\2\2\2o\u0183\3\2\2\2q\u0186\3\2\2\2s\u0189\3\2"+
		"\2\2u\u018c\3\2\2\2w\u018f\3\2\2\2y\u0191\3\2\2\2{\u0197\3\2\2\2}\u019c"+
		"\3\2\2\2\177\u0080\7c\2\2\u0080\u0081\7i\2\2\u0081\u0082\7g\2\2\u0082"+
		"\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\4\3\2\2\2\u0085\u0086\7o\2\2\u0086"+
		"\u0087\7q\2\2\u0087\u0088\7f\2\2\u0088\u0089\7w\2\2\u0089\u008a\7n\2\2"+
		"\u008a\u008b\7g\2\2\u008b\6\3\2\2\2\u008c\u008d\7w\2\2\u008d\u008e\7u"+
		"\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7i\2\2\u0091\b"+
		"\3\2\2\2\u0092\u0093\7f\2\2\u0093\u0094\7g\2\2\u0094\u0095\7h\2\2\u0095"+
		"\n\3\2\2\2\u0096\u0097\7v\2\2\u0097\u0098\7{\2\2\u0098\u0099\7r\2\2\u0099"+
		"\u009a\7g\2\2\u009a\f\3\2\2\2\u009b\u009c\7h\2\2\u009c\u009d\7w\2\2\u009d"+
		"\u009e\7p\2\2\u009e\16\3\2\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7f\2\2\u00a1"+
		"\u00a2\7v\2\2\u00a2\20\3\2\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7e\2\2\u00a5"+
		"\u00a6\7v\2\2\u00a6\u00a7\7w\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7v\2\2"+
		"\u00a9\u00aa\7q\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7u\2\2\u00ac\22\3\2"+
		"\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1"+
		"\7u\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7u\2\2\u00b4"+
		"\24\3\2\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7n\2\2\u00b8"+
		"\u00b9\7y\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7v\2\2"+
		"\u00bc\u00bd\7g\2\2\u00bd\26\3\2\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7"+
		"n\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4"+
		"\7c\2\2\u00c4\u00c5\7f\2\2\u00c5\30\3\2\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8"+
		"\7q\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7n\2\2\u00cb"+
		"\32\3\2\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7u\2\2\u00cf"+
		"\u00d0\7v\2\2\u00d0\34\3\2\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\7c\2\2\u00d3"+
		"\u00d4\7r\2\2\u00d4\36\3\2\2\2\u00d5\u00d6\7s\2\2\u00d6\u00d7\7w\2\2\u00d7"+
		"\u00d8\7g\2\2\u00d8\u00d9\7w\2\2\u00d9\u00da\7g\2\2\u00da \3\2\2\2\u00db"+
		"\u00dc\7k\2\2\u00dc\u00dd\7p\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7v\2\2"+
		"\u00df\"\3\2\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7v"+
		"\2\2\u00e3$\3\2\2\2\u00e4\u00e5\7h\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7"+
		"\7q\2\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7v\2\2\u00e9&\3\2\2\2\u00ea\u00eb"+
		"\7d\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee\7n\2\2\u00ee"+
		"\u00ef\7g\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7p\2\2\u00f1(\3\2\2\2\u00f2"+
		"\u00f3\7r\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7u\2\2\u00f5*\3\2\2\2\u00f6"+
		"\u00f7\7k\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9\7r\2\2\u00f9\u00fa\7w\2\2"+
		"\u00fa\u00fb\7v\2\2\u00fb\u00fc\7O\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe"+
		"\7r\2\2\u00fe,\3\2\2\2\u00ff\u0100\7k\2\2\u0100\u0101\7h\2\2\u0101.\3"+
		"\2\2\2\u0102\u0103\7g\2\2\u0103\u0104\7n\2\2\u0104\u0105\7u\2\2\u0105"+
		"\u0106\7g\2\2\u0106\60\3\2\2\2\u0107\u0108\7c\2\2\u0108\u0109\7v\2\2\u0109"+
		"\u010a\7q\2\2\u010a\u010b\7o\2\2\u010b\u010c\7k\2\2\u010c\u010d\7e\2\2"+
		"\u010d\62\3\2\2\2\u010e\u010f\7r\2\2\u010f\u0110\7t\2\2\u0110\u0111\7"+
		"g\2\2\u0111\64\3\2\2\2\u0112\u0113\7g\2\2\u0113\u0114\7h\2\2\u0114\u0115"+
		"\7h\2\2\u0115\66\3\2\2\2\u0116\u0117\7v\2\2\u0117\u0118\7t\2\2\u0118\u0119"+
		"\7w\2\2\u0119\u011a\7g\2\2\u011a8\3\2\2\2\u011b\u011c\7h\2\2\u011c\u011d"+
		"\7c\2\2\u011d\u011e\7n\2\2\u011e\u011f\7u\2\2\u011f\u0120\7g\2\2\u0120"+
		":\3\2\2\2\u0121\u0122\7r\2\2\u0122\u0123\7k\2\2\u0123\u0124\7f\2\2\u0124"+
		"<\3\2\2\2\u0125\u0126\7p\2\2\u0126\u0127\7w\2\2\u0127\u0128\7o\2\2\u0128"+
		"\u0129\7D\2\2\u0129\u012a\7q\2\2\u012a\u012b\7v\2\2\u012b\u012c\7u\2\2"+
		"\u012c>\3\2\2\2\u012d\u012e\7<\2\2\u012e@\3\2\2\2\u012f\u0130\7.\2\2\u0130"+
		"B\3\2\2\2\u0131\u0132\7=\2\2\u0132D\3\2\2\2\u0133\u0134\7*\2\2\u0134F"+
		"\3\2\2\2\u0135\u0136\7+\2\2\u0136H\3\2\2\2\u0137\u0138\7]\2\2\u0138J\3"+
		"\2\2\2\u0139\u013a\7_\2\2\u013aL\3\2\2\2\u013b\u013c\7}\2\2\u013cN\3\2"+
		"\2\2\u013d\u013e\7\177\2\2\u013eP\3\2\2\2\u013f\u0140\7>\2\2\u0140R\3"+
		"\2\2\2\u0141\u0142\7@\2\2\u0142T\3\2\2\2\u0143\u0144\7(\2\2\u0144\u0149"+
		"\7(\2\2\u0145\u0146\7c\2\2\u0146\u0147\7p\2\2\u0147\u0149\7f\2\2\u0148"+
		"\u0143\3\2\2\2\u0148\u0145\3\2\2\2\u0149V\3\2\2\2\u014a\u014b\7~\2\2\u014b"+
		"\u014f\7~\2\2\u014c\u014d\7q\2\2\u014d\u014f\7t\2\2\u014e\u014a\3\2\2"+
		"\2\u014e\u014c\3\2\2\2\u014fX\3\2\2\2\u0150\u0151\7#\2\2\u0151Z\3\2\2"+
		"\2\u0152\u0156\t\2\2\2\u0153\u0155\t\3\2\2\u0154\u0153\3\2\2\2\u0155\u0158"+
		"\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\\\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0159\u015d\t\4\2\2\u015a\u015c\t\3\2\2\u015b\u015a\3\2"+
		"\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"^\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161\5]/\2\u0161`\3\2\2\2\u0162\u0168"+
		"\5[.\2\u0163\u0164\5]/\2\u0164\u0165\7\60\2\2\u0165\u0166\5[.\2\u0166"+
		"\u0168\3\2\2\2\u0167\u0162\3\2\2\2\u0167\u0163\3\2\2\2\u0168b\3\2\2\2"+
		"\u0169\u016b\t\5\2\2\u016a\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a"+
		"\3\2\2\2\u016c\u016d\3\2\2\2\u016dd\3\2\2\2\u016e\u0170\t\5\2\2\u016f"+
		"\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2"+
		"\2\2\u0172\u0179\3\2\2\2\u0173\u0175\t\6\2\2\u0174\u0176\t\5\2\2\u0175"+
		"\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178\u017a\3\2\2\2\u0179\u0173\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"f\3\2\2\2\u017b\u017c\7-\2\2\u017ch\3\2\2\2\u017d\u017e\7/\2\2\u017ej"+
		"\3\2\2\2\u017f\u0180\7,\2\2\u0180l\3\2\2\2\u0181\u0182\7\61\2\2\u0182"+
		"n\3\2\2\2\u0183\u0184\7?\2\2\u0184\u0185\7?\2\2\u0185p\3\2\2\2\u0186\u0187"+
		"\7@\2\2\u0187\u0188\7?\2\2\u0188r\3\2\2\2\u0189\u018a\7>\2\2\u018a\u018b"+
		"\7?\2\2\u018bt\3\2\2\2\u018c\u018d\7#\2\2\u018d\u018e\7?\2\2\u018ev\3"+
		"\2\2\2\u018f\u0190\7?\2\2\u0190x\3\2\2\2\u0191\u0193\7\f\2\2\u0192\u0194"+
		"\5}?\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2\2\2\u0195"+
		"\u0196\b=\2\2\u0196z\3\2\2\2\u0197\u0198\5}?\2\u0198\u0199\3\2\2\2\u0199"+
		"\u019a\b>\3\2\u019a|\3\2\2\2\u019b\u019d\t\7\2\2\u019c\u019b\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f~\3\2\2\2"+
		"\16\2\u0148\u014e\u0156\u015d\u0167\u016c\u0171\u0177\u0179\u0193\u019e"+
		"\4\3=\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
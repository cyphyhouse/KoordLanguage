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
		RCURLY=39, LANGLE=40, RANGLE=41, AND=42, OR=43, NOT=44, VARNAME=45, CID=46, 
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
			"AND", "OR", "NOT", "LID", "VARNAME", "CID", "INUM", "FNUM", "PLUS", 
			"MINUS", "TIMES", "BY", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", 
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
			"']'", "'{'", "'}'", "'<'", "'>'", "'&&'", "'||'", "'!'", null, null, 
			null, null, "'+'", "'-'", "'*'", "'/'", "'=='", "'>='", "'<='", "'!='", 
			"'='"
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
			"AND", "OR", "NOT", "VARNAME", "CID", "INUM", "FNUM", "PLUS", "MINUS", 
			"TIMES", "BY", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_"
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
		case 58:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u019b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3"+
		".\7.\u014c\n.\f.\16.\u014f\13.\3/\3/\3/\3/\3/\5/\u0156\n/\3\60\3\60\7"+
		"\60\u015a\n\60\f\60\16\60\u015d\13\60\3\61\5\61\u0160\n\61\3\61\6\61\u0163"+
		"\n\61\r\61\16\61\u0164\3\62\5\62\u0168\n\62\3\62\6\62\u016b\n\62\r\62"+
		"\16\62\u016c\3\62\3\62\6\62\u0171\n\62\r\62\16\62\u0172\5\62\u0175\n\62"+
		"\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\67\38\38\38\39\3"+
		"9\39\3:\3:\3:\3;\3;\3<\3<\5<\u018f\n<\3<\3<\3=\3=\3=\3=\3>\6>\u0198\n"+
		">\r>\16>\u0199\2\2?\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[\2]/_\60a\61c\62"+
		"e\63g\64i\65k\66m\67o8q9s:u;w<y={\2\3\2\t\3\2c|\5\2\62;C\\c|\3\2C\\\3"+
		"\2//\3\2\62;\3\2\60\60\4\2\13\13\"\"\2\u01a3\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\3}\3\2\2\2\5\u0083\3\2\2\2\7\u008a\3\2"+
		"\2\2\t\u0090\3\2\2\2\13\u0094\3\2\2\2\r\u0099\3\2\2\2\17\u009d\3\2\2\2"+
		"\21\u00a1\3\2\2\2\23\u00ab\3\2\2\2\25\u00b3\3\2\2\2\27\u00bc\3\2\2\2\31"+
		"\u00c4\3\2\2\2\33\u00ca\3\2\2\2\35\u00cf\3\2\2\2\37\u00d3\3\2\2\2!\u00d9"+
		"\3\2\2\2#\u00de\3\2\2\2%\u00e2\3\2\2\2\'\u00e8\3\2\2\2)\u00f0\3\2\2\2"+
		"+\u00f4\3\2\2\2-\u00fd\3\2\2\2/\u0100\3\2\2\2\61\u0105\3\2\2\2\63\u010c"+
		"\3\2\2\2\65\u0110\3\2\2\2\67\u0114\3\2\2\29\u0119\3\2\2\2;\u011f\3\2\2"+
		"\2=\u0123\3\2\2\2?\u012b\3\2\2\2A\u012d\3\2\2\2C\u012f\3\2\2\2E\u0131"+
		"\3\2\2\2G\u0133\3\2\2\2I\u0135\3\2\2\2K\u0137\3\2\2\2M\u0139\3\2\2\2O"+
		"\u013b\3\2\2\2Q\u013d\3\2\2\2S\u013f\3\2\2\2U\u0141\3\2\2\2W\u0144\3\2"+
		"\2\2Y\u0147\3\2\2\2[\u0149\3\2\2\2]\u0155\3\2\2\2_\u0157\3\2\2\2a\u015f"+
		"\3\2\2\2c\u0167\3\2\2\2e\u0176\3\2\2\2g\u0178\3\2\2\2i\u017a\3\2\2\2k"+
		"\u017c\3\2\2\2m\u017e\3\2\2\2o\u0181\3\2\2\2q\u0184\3\2\2\2s\u0187\3\2"+
		"\2\2u\u018a\3\2\2\2w\u018c\3\2\2\2y\u0192\3\2\2\2{\u0197\3\2\2\2}~\7c"+
		"\2\2~\177\7i\2\2\177\u0080\7g\2\2\u0080\u0081\7p\2\2\u0081\u0082\7v\2"+
		"\2\u0082\4\3\2\2\2\u0083\u0084\7o\2\2\u0084\u0085\7q\2\2\u0085\u0086\7"+
		"f\2\2\u0086\u0087\7w\2\2\u0087\u0088\7n\2\2\u0088\u0089\7g\2\2\u0089\6"+
		"\3\2\2\2\u008a\u008b\7w\2\2\u008b\u008c\7u\2\2\u008c\u008d\7k\2\2\u008d"+
		"\u008e\7p\2\2\u008e\u008f\7i\2\2\u008f\b\3\2\2\2\u0090\u0091\7f\2\2\u0091"+
		"\u0092\7g\2\2\u0092\u0093\7h\2\2\u0093\n\3\2\2\2\u0094\u0095\7v\2\2\u0095"+
		"\u0096\7{\2\2\u0096\u0097\7r\2\2\u0097\u0098\7g\2\2\u0098\f\3\2\2\2\u0099"+
		"\u009a\7h\2\2\u009a\u009b\7w\2\2\u009b\u009c\7p\2\2\u009c\16\3\2\2\2\u009d"+
		"\u009e\7c\2\2\u009e\u009f\7f\2\2\u009f\u00a0\7v\2\2\u00a0\20\3\2\2\2\u00a1"+
		"\u00a2\7c\2\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7w\2\2"+
		"\u00a5\u00a6\7c\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9"+
		"\7t\2\2\u00a9\u00aa\7u\2\2\u00aa\22\3\2\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad"+
		"\7g\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7q\2\2\u00b0"+
		"\u00b1\7t\2\2\u00b1\u00b2\7u\2\2\u00b2\24\3\2\2\2\u00b3\u00b4\7c\2\2\u00b4"+
		"\u00b5\7n\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7y\2\2\u00b7\u00b8\7t\2\2"+
		"\u00b8\u00b9\7k\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7g\2\2\u00bb\26\3\2"+
		"\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0"+
		"\7t\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7f\2\2\u00c3"+
		"\30\3\2\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7e\2\2\u00c7"+
		"\u00c8\7c\2\2\u00c8\u00c9\7n\2\2\u00c9\32\3\2\2\2\u00ca\u00cb\7n\2\2\u00cb"+
		"\u00cc\7k\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7v\2\2\u00ce\34\3\2\2\2\u00cf"+
		"\u00d0\7o\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7r\2\2\u00d2\36\3\2\2\2\u00d3"+
		"\u00d4\7s\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7w\2\2"+
		"\u00d7\u00d8\7g\2\2\u00d8 \3\2\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7p\2"+
		"\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7v\2\2\u00dd\"\3\2\2\2\u00de\u00df\7"+
		"k\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1\7v\2\2\u00e1$\3\2\2\2\u00e2\u00e3"+
		"\7h\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7c\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7&\3\2\2\2\u00e8\u00e9\7d\2\2\u00e9\u00ea\7q\2\2\u00ea"+
		"\u00eb\7q\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7c\2\2"+
		"\u00ee\u00ef\7p\2\2\u00ef(\3\2\2\2\u00f0\u00f1\7r\2\2\u00f1\u00f2\7q\2"+
		"\2\u00f2\u00f3\7u\2\2\u00f3*\3\2\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7"+
		"p\2\2\u00f6\u00f7\7r\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa"+
		"\7O\2\2\u00fa\u00fb\7c\2\2\u00fb\u00fc\7r\2\2\u00fc,\3\2\2\2\u00fd\u00fe"+
		"\7k\2\2\u00fe\u00ff\7h\2\2\u00ff.\3\2\2\2\u0100\u0101\7g\2\2\u0101\u0102"+
		"\7n\2\2\u0102\u0103\7u\2\2\u0103\u0104\7g\2\2\u0104\60\3\2\2\2\u0105\u0106"+
		"\7c\2\2\u0106\u0107\7v\2\2\u0107\u0108\7q\2\2\u0108\u0109\7o\2\2\u0109"+
		"\u010a\7k\2\2\u010a\u010b\7e\2\2\u010b\62\3\2\2\2\u010c\u010d\7r\2\2\u010d"+
		"\u010e\7t\2\2\u010e\u010f\7g\2\2\u010f\64\3\2\2\2\u0110\u0111\7g\2\2\u0111"+
		"\u0112\7h\2\2\u0112\u0113\7h\2\2\u0113\66\3\2\2\2\u0114\u0115\7v\2\2\u0115"+
		"\u0116\7t\2\2\u0116\u0117\7w\2\2\u0117\u0118\7g\2\2\u01188\3\2\2\2\u0119"+
		"\u011a\7h\2\2\u011a\u011b\7c\2\2\u011b\u011c\7n\2\2\u011c\u011d\7u\2\2"+
		"\u011d\u011e\7g\2\2\u011e:\3\2\2\2\u011f\u0120\7r\2\2\u0120\u0121\7k\2"+
		"\2\u0121\u0122\7f\2\2\u0122<\3\2\2\2\u0123\u0124\7p\2\2\u0124\u0125\7"+
		"w\2\2\u0125\u0126\7o\2\2\u0126\u0127\7D\2\2\u0127\u0128\7q\2\2\u0128\u0129"+
		"\7v\2\2\u0129\u012a\7u\2\2\u012a>\3\2\2\2\u012b\u012c\7<\2\2\u012c@\3"+
		"\2\2\2\u012d\u012e\7.\2\2\u012eB\3\2\2\2\u012f\u0130\7=\2\2\u0130D\3\2"+
		"\2\2\u0131\u0132\7*\2\2\u0132F\3\2\2\2\u0133\u0134\7+\2\2\u0134H\3\2\2"+
		"\2\u0135\u0136\7]\2\2\u0136J\3\2\2\2\u0137\u0138\7_\2\2\u0138L\3\2\2\2"+
		"\u0139\u013a\7}\2\2\u013aN\3\2\2\2\u013b\u013c\7\177\2\2\u013cP\3\2\2"+
		"\2\u013d\u013e\7>\2\2\u013eR\3\2\2\2\u013f\u0140\7@\2\2\u0140T\3\2\2\2"+
		"\u0141\u0142\7(\2\2\u0142\u0143\7(\2\2\u0143V\3\2\2\2\u0144\u0145\7~\2"+
		"\2\u0145\u0146\7~\2\2\u0146X\3\2\2\2\u0147\u0148\7#\2\2\u0148Z\3\2\2\2"+
		"\u0149\u014d\t\2\2\2\u014a\u014c\t\3\2\2\u014b\u014a\3\2\2\2\u014c\u014f"+
		"\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\\\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u0150\u0156\5[.\2\u0151\u0152\5[.\2\u0152\u0153\7\60\2"+
		"\2\u0153\u0154\5[.\2\u0154\u0156\3\2\2\2\u0155\u0150\3\2\2\2\u0155\u0151"+
		"\3\2\2\2\u0156^\3\2\2\2\u0157\u015b\t\4\2\2\u0158\u015a\t\3\2\2\u0159"+
		"\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c`\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0160\t\5\2\2\u015f\u015e"+
		"\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u0163\t\6\2\2\u0162"+
		"\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165b\3\2\2\2\u0166\u0168\t\5\2\2\u0167\u0166\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168\u016a\3\2\2\2\u0169\u016b\t\6\2\2\u016a\u0169\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0174\3\2"+
		"\2\2\u016e\u0170\t\7\2\2\u016f\u0171\t\6\2\2\u0170\u016f\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2"+
		"\2\2\u0174\u016e\3\2\2\2\u0174\u0175\3\2\2\2\u0175d\3\2\2\2\u0176\u0177"+
		"\7-\2\2\u0177f\3\2\2\2\u0178\u0179\7/\2\2\u0179h\3\2\2\2\u017a\u017b\7"+
		",\2\2\u017bj\3\2\2\2\u017c\u017d\7\61\2\2\u017dl\3\2\2\2\u017e\u017f\7"+
		"?\2\2\u017f\u0180\7?\2\2\u0180n\3\2\2\2\u0181\u0182\7@\2\2\u0182\u0183"+
		"\7?\2\2\u0183p\3\2\2\2\u0184\u0185\7>\2\2\u0185\u0186\7?\2\2\u0186r\3"+
		"\2\2\2\u0187\u0188\7#\2\2\u0188\u0189\7?\2\2\u0189t\3\2\2\2\u018a\u018b"+
		"\7?\2\2\u018bv\3\2\2\2\u018c\u018e\7\f\2\2\u018d\u018f\5{>\2\u018e\u018d"+
		"\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\b<\2\2\u0191"+
		"x\3\2\2\2\u0192\u0193\5{>\2\u0193\u0194\3\2\2\2\u0194\u0195\b=\3\2\u0195"+
		"z\3\2\2\2\u0196\u0198\t\b\2\2\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2"+
		"\u0199\u0197\3\2\2\2\u0199\u019a\3\2\2\2\u019a|\3\2\2\2\16\2\u014d\u0155"+
		"\u015b\u015f\u0164\u0167\u016c\u0172\u0174\u018e\u0199\4\3<\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
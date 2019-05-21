// Generated from Koord.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KoordParser extends Parser {
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
		SKIP_=58, INDENT=59, DEDENT=60;
	public static final int
		RULE_lexemes = 0, RULE_top = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"lexemes", "top"
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
			"LT", "GT", "EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_", "INDENT", 
			"DEDENT"
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

	@Override
	public String getGrammarFileName() { return "Koord.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KoordParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LexemesContext extends ParserRuleContext {
		public TerminalNode AGENT() { return getToken(KoordParser.AGENT, 0); }
		public TerminalNode MODULE() { return getToken(KoordParser.MODULE, 0); }
		public TerminalNode DEF() { return getToken(KoordParser.DEF, 0); }
		public TerminalNode TYPE() { return getToken(KoordParser.TYPE, 0); }
		public TerminalNode FUN() { return getToken(KoordParser.FUN, 0); }
		public TerminalNode ACTUATORS() { return getToken(KoordParser.ACTUATORS, 0); }
		public TerminalNode SENSORS() { return getToken(KoordParser.SENSORS, 0); }
		public TerminalNode ALLWRITE() { return getToken(KoordParser.ALLWRITE, 0); }
		public TerminalNode ALLREAD() { return getToken(KoordParser.ALLREAD, 0); }
		public TerminalNode LOCAL() { return getToken(KoordParser.LOCAL, 0); }
		public TerminalNode LIST() { return getToken(KoordParser.LIST, 0); }
		public TerminalNode MAP() { return getToken(KoordParser.MAP, 0); }
		public TerminalNode QUEUE() { return getToken(KoordParser.QUEUE, 0); }
		public TerminalNode INIT() { return getToken(KoordParser.INIT, 0); }
		public TerminalNode INT() { return getToken(KoordParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(KoordParser.FLOAT, 0); }
		public TerminalNode BOOL() { return getToken(KoordParser.BOOL, 0); }
		public TerminalNode POS() { return getToken(KoordParser.POS, 0); }
		public TerminalNode IF() { return getToken(KoordParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(KoordParser.ELSE, 0); }
		public TerminalNode ATOMIC() { return getToken(KoordParser.ATOMIC, 0); }
		public TerminalNode PRE() { return getToken(KoordParser.PRE, 0); }
		public TerminalNode EFF() { return getToken(KoordParser.EFF, 0); }
		public TerminalNode TRUE() { return getToken(KoordParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(KoordParser.FALSE, 0); }
		public TerminalNode PID() { return getToken(KoordParser.PID, 0); }
		public TerminalNode NUMAGENTS() { return getToken(KoordParser.NUMAGENTS, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public TerminalNode COMMA() { return getToken(KoordParser.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(KoordParser.SEMICOLON, 0); }
		public TerminalNode LPAR() { return getToken(KoordParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(KoordParser.RPAR, 0); }
		public TerminalNode LBRACE() { return getToken(KoordParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KoordParser.RBRACE, 0); }
		public TerminalNode LCURLY() { return getToken(KoordParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(KoordParser.RCURLY, 0); }
		public TerminalNode LANGLE() { return getToken(KoordParser.LANGLE, 0); }
		public TerminalNode RANGLE() { return getToken(KoordParser.RANGLE, 0); }
		public TerminalNode AND() { return getToken(KoordParser.AND, 0); }
		public TerminalNode OR() { return getToken(KoordParser.OR, 0); }
		public TerminalNode NOT() { return getToken(KoordParser.NOT, 0); }
		public TerminalNode LID() { return getToken(KoordParser.LID, 0); }
		public TerminalNode CID() { return getToken(KoordParser.CID, 0); }
		public TerminalNode INUM() { return getToken(KoordParser.INUM, 0); }
		public TerminalNode FNUM() { return getToken(KoordParser.FNUM, 0); }
		public TerminalNode PLUS() { return getToken(KoordParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(KoordParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(KoordParser.TIMES, 0); }
		public TerminalNode BY() { return getToken(KoordParser.BY, 0); }
		public TerminalNode LT() { return getToken(KoordParser.LT, 0); }
		public TerminalNode GT() { return getToken(KoordParser.GT, 0); }
		public TerminalNode EQ() { return getToken(KoordParser.EQ, 0); }
		public TerminalNode GEQ() { return getToken(KoordParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(KoordParser.LEQ, 0); }
		public TerminalNode NEQ() { return getToken(KoordParser.NEQ, 0); }
		public TerminalNode ASGN() { return getToken(KoordParser.ASGN, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public TerminalNode SKIP_() { return getToken(KoordParser.SKIP_, 0); }
		public TerminalNode INDENT() { return getToken(KoordParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(KoordParser.DEDENT, 0); }
		public LexemesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexemes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterLexemes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitLexemes(this);
		}
	}

	public final LexemesContext lexemes() throws RecognitionException {
		LexemesContext _localctx = new LexemesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lexemes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGENT) | (1L << MODULE) | (1L << DEF) | (1L << TYPE) | (1L << FUN) | (1L << ACTUATORS) | (1L << SENSORS) | (1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL) | (1L << LIST) | (1L << MAP) | (1L << QUEUE) | (1L << INIT) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS) | (1L << IF) | (1L << ELSE) | (1L << ATOMIC) | (1L << PRE) | (1L << EFF) | (1L << TRUE) | (1L << FALSE) | (1L << PID) | (1L << NUMAGENTS) | (1L << COLON) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LPAR) | (1L << RPAR) | (1L << LBRACE) | (1L << RBRACE) | (1L << LCURLY) | (1L << RCURLY) | (1L << LANGLE) | (1L << RANGLE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << LID) | (1L << CID) | (1L << INUM) | (1L << FNUM) | (1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << BY) | (1L << LT) | (1L << GT) | (1L << EQ) | (1L << GEQ) | (1L << LEQ) | (1L << NEQ) | (1L << ASGN) | (1L << NEWLINE) | (1L << SKIP_) | (1L << INDENT) | (1L << DEDENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopContext extends ParserRuleContext {
		public List<LexemesContext> lexemes() {
			return getRuleContexts(LexemesContext.class);
		}
		public LexemesContext lexemes(int i) {
			return getRuleContext(LexemesContext.class,i);
		}
		public TopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterTop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitTop(this);
		}
	}

	public final TopContext top() throws RecognitionException {
		TopContext _localctx = new TopContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_top);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				lexemes();
				}
				}
				setState(9); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGENT) | (1L << MODULE) | (1L << DEF) | (1L << TYPE) | (1L << FUN) | (1L << ACTUATORS) | (1L << SENSORS) | (1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL) | (1L << LIST) | (1L << MAP) | (1L << QUEUE) | (1L << INIT) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS) | (1L << IF) | (1L << ELSE) | (1L << ATOMIC) | (1L << PRE) | (1L << EFF) | (1L << TRUE) | (1L << FALSE) | (1L << PID) | (1L << NUMAGENTS) | (1L << COLON) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LPAR) | (1L << RPAR) | (1L << LBRACE) | (1L << RBRACE) | (1L << LCURLY) | (1L << RCURLY) | (1L << LANGLE) | (1L << RANGLE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << LID) | (1L << CID) | (1L << INUM) | (1L << FNUM) | (1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << BY) | (1L << LT) | (1L << GT) | (1L << EQ) | (1L << GEQ) | (1L << LEQ) | (1L << NEQ) | (1L << ASGN) | (1L << NEWLINE) | (1L << SKIP_) | (1L << INDENT) | (1L << DEDENT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3>\16\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\3\6\3\n\n\3\r\3\16\3\13\3\3\2\2\4\2\4\2\3\3\2\3>\2\f\2\6"+
		"\3\2\2\2\4\t\3\2\2\2\6\7\t\2\2\2\7\3\3\2\2\2\b\n\5\2\2\2\t\b\3\2\2\2\n"+
		"\13\3\2\2\2\13\t\3\2\2\2\13\f\3\2\2\2\f\5\3\2\2\2\3\13";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
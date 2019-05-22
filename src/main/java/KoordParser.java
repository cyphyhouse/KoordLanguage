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
		AGENT=1, MODULE=2, DEF=3, TYPE=4, FUN=5, ADT=6, ACTUATORS=7, SENSORS=8, 
		ALLWRITE=9, ALLREAD=10, LOCAL=11, LIST=12, MAP=13, QUEUE=14, INIT=15, 
		INT=16, FLOAT=17, BOOL=18, POS=19, IF=20, ELSE=21, ATOMIC=22, PRE=23, 
		EFF=24, TRUE=25, FALSE=26, PID=27, NUMAGENTS=28, COLON=29, COMMA=30, SEMICOLON=31, 
		LPAR=32, RPAR=33, LBRACE=34, RBRACE=35, LCURLY=36, RCURLY=37, LANGLE=38, 
		RANGLE=39, AND=40, OR=41, NOT=42, LID=43, CID=44, INUM=45, FNUM=46, PLUS=47, 
		MINUS=48, TIMES=49, BY=50, EQ=51, GEQ=52, LEQ=53, NEQ=54, ASGN=55, NEWLINE=56, 
		SKIP_=57, INDENT=58, DEDENT=59;
	public static final int
		RULE_lexemes = 0, RULE_top = 1, RULE_program = 2, RULE_defs = 3, RULE_funcdef = 4, 
		RULE_param = 5, RULE_event = 6, RULE_statementblock = 7, RULE_stmt = 8, 
		RULE_assign = 9, RULE_expr = 10, RULE_bexpr = 11, RULE_aexpr = 12, RULE_number = 13, 
		RULE_relop = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"lexemes", "top", "program", "defs", "funcdef", "param", "event", "statementblock", 
			"stmt", "assign", "expr", "bexpr", "aexpr", "number", "relop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'agent'", "'module'", "'def'", "'type'", "'fun'", "'adt'", "'actuators'", 
			"'sensors'", "'allwrite'", "'allread'", "'local'", "'list'", "'map'", 
			"'queue'", "'init'", "'int'", "'float'", "'bool'", "'pos'", "'if'", "'else'", 
			"'atomic'", "'pre'", "'eff'", "'true'", "'false'", "'pid'", "'numAgents'", 
			"':'", "','", "';'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", 
			"'>'", "'&&'", "'||'", "'!'", null, null, null, null, "'+'", "'-'", "'*'", 
			"'/'", "'=='", "'>='", "'<='", "'!='", "'='"
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
			"EQ", "GEQ", "LEQ", "NEQ", "ASGN", "NEWLINE", "SKIP_", "INDENT", "DEDENT"
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
			setState(30);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGENT) | (1L << MODULE) | (1L << DEF) | (1L << TYPE) | (1L << FUN) | (1L << ACTUATORS) | (1L << SENSORS) | (1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL) | (1L << LIST) | (1L << MAP) | (1L << QUEUE) | (1L << INIT) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS) | (1L << IF) | (1L << ELSE) | (1L << ATOMIC) | (1L << PRE) | (1L << EFF) | (1L << TRUE) | (1L << FALSE) | (1L << PID) | (1L << NUMAGENTS) | (1L << COLON) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LPAR) | (1L << RPAR) | (1L << LBRACE) | (1L << RBRACE) | (1L << LCURLY) | (1L << RCURLY) | (1L << LANGLE) | (1L << RANGLE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << LID) | (1L << CID) | (1L << INUM) | (1L << FNUM) | (1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << BY) | (1L << EQ) | (1L << GEQ) | (1L << LEQ) | (1L << NEQ) | (1L << ASGN) | (1L << NEWLINE) | (1L << SKIP_) | (1L << INDENT) | (1L << DEDENT))) != 0)) ) {
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				lexemes();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGENT) | (1L << MODULE) | (1L << DEF) | (1L << TYPE) | (1L << FUN) | (1L << ACTUATORS) | (1L << SENSORS) | (1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL) | (1L << LIST) | (1L << MAP) | (1L << QUEUE) | (1L << INIT) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS) | (1L << IF) | (1L << ELSE) | (1L << ATOMIC) | (1L << PRE) | (1L << EFF) | (1L << TRUE) | (1L << FALSE) | (1L << PID) | (1L << NUMAGENTS) | (1L << COLON) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LPAR) | (1L << RPAR) | (1L << LBRACE) | (1L << RBRACE) | (1L << LCURLY) | (1L << RCURLY) | (1L << LANGLE) | (1L << RANGLE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << LID) | (1L << CID) | (1L << INUM) | (1L << FNUM) | (1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << BY) | (1L << EQ) | (1L << GEQ) | (1L << LEQ) | (1L << NEQ) | (1L << ASGN) | (1L << NEWLINE) | (1L << SKIP_) | (1L << INDENT) | (1L << DEDENT))) != 0) );
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

	public static class ProgramContext extends ParserRuleContext {
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				event();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LID );
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

	public static class DefsContext extends ParserRuleContext {
		public List<FuncdefContext> funcdef() {
			return getRuleContexts(FuncdefContext.class);
		}
		public FuncdefContext funcdef(int i) {
			return getRuleContext(FuncdefContext.class,i);
		}
		public DefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterDefs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitDefs(this);
		}
	}

	public final DefsContext defs() throws RecognitionException {
		DefsContext _localctx = new DefsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(42);
				funcdef();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(KoordParser.DEF, 0); }
		public TerminalNode FUN() { return getToken(KoordParser.FUN, 0); }
		public TerminalNode LID() { return getToken(KoordParser.LID, 0); }
		public TerminalNode LPAR() { return getToken(KoordParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(KoordParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitFuncdef(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(DEF);
			setState(49);
			match(FUN);
			setState(50);
			match(LID);
			setState(51);
			match(LPAR);
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				param();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TYPE );
			setState(57);
			match(RPAR);
			setState(58);
			match(COLON);
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				stmt();
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ATOMIC || _la==LID );
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(KoordParser.TYPE, 0); }
		public TerminalNode LID() { return getToken(KoordParser.LID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(TYPE);
			setState(65);
			match(LID);
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

	public static class EventContext extends ParserRuleContext {
		public TerminalNode LID() { return getToken(KoordParser.LID, 0); }
		public List<TerminalNode> COLON() { return getTokens(KoordParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(KoordParser.COLON, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(KoordParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KoordParser.NEWLINE, i);
		}
		public TerminalNode INDENT() { return getToken(KoordParser.INDENT, 0); }
		public TerminalNode PRE() { return getToken(KoordParser.PRE, 0); }
		public TerminalNode LPAR() { return getToken(KoordParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(KoordParser.RPAR, 0); }
		public TerminalNode EFF() { return getToken(KoordParser.EFF, 0); }
		public StatementblockContext statementblock() {
			return getRuleContext(StatementblockContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(KoordParser.DEDENT, 0); }
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitEvent(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_event);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(LID);
			setState(68);
			match(COLON);
			setState(69);
			match(NEWLINE);
			setState(70);
			match(INDENT);
			setState(71);
			match(PRE);
			setState(72);
			match(COLON);
			setState(73);
			match(LPAR);
			setState(74);
			expr();
			setState(75);
			match(RPAR);
			setState(76);
			match(NEWLINE);
			setState(77);
			match(EFF);
			setState(78);
			match(COLON);
			setState(79);
			match(NEWLINE);
			setState(80);
			statementblock();
			setState(81);
			match(DEDENT);
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

	public static class StatementblockContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(KoordParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(KoordParser.DEDENT, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StatementblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterStatementblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitStatementblock(this);
		}
	}

	public final StatementblockContext statementblock() throws RecognitionException {
		StatementblockContext _localctx = new StatementblockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statementblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(INDENT);
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84);
				stmt();
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ATOMIC || _la==LID );
			setState(89);
			match(DEDENT);
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

	public static class StmtContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public TerminalNode ATOMIC() { return getToken(KoordParser.ATOMIC, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public StatementblockContext statementblock() {
			return getRuleContext(StatementblockContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LID:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				assign();
				setState(92);
				match(NEWLINE);
				}
				break;
			case ATOMIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(ATOMIC);
				setState(95);
				match(COLON);
				setState(96);
				match(NEWLINE);
				setState(97);
				statementblock();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode LID() { return getToken(KoordParser.LID, 0); }
		public TerminalNode ASGN() { return getToken(KoordParser.ASGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(LID);
			setState(101);
			match(ASGN);
			setState(102);
			expr();
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

	public static class ExprContext extends ParserRuleContext {
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				aexpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				bexpr(0);
				}
				break;
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

	public static class BexprContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(KoordParser.NOT, 0); }
		public List<BexprContext> bexpr() {
			return getRuleContexts(BexprContext.class);
		}
		public BexprContext bexpr(int i) {
			return getRuleContext(BexprContext.class,i);
		}
		public TerminalNode LPAR() { return getToken(KoordParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(KoordParser.RPAR, 0); }
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(KoordParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(KoordParser.TRUE, 0); }
		public TerminalNode LID() { return getToken(KoordParser.LID, 0); }
		public TerminalNode AND() { return getToken(KoordParser.AND, 0); }
		public TerminalNode OR() { return getToken(KoordParser.OR, 0); }
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterBexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitBexpr(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		return bexpr(0);
	}

	private BexprContext bexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BexprContext _localctx = new BexprContext(_ctx, _parentState);
		BexprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_bexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(109);
				match(NOT);
				setState(110);
				bexpr(8);
				}
				break;
			case 2:
				{
				setState(111);
				match(LPAR);
				setState(112);
				bexpr(0);
				setState(113);
				match(RPAR);
				}
				break;
			case 3:
				{
				setState(115);
				aexpr(0);
				setState(116);
				relop();
				setState(117);
				aexpr(0);
				}
				break;
			case 4:
				{
				setState(119);
				match(FALSE);
				}
				break;
			case 5:
				{
				setState(120);
				match(TRUE);
				}
				break;
			case 6:
				{
				setState(121);
				match(LID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(130);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(124);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(125);
						match(AND);
						setState(126);
						bexpr(6);
						}
						break;
					case 2:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(127);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(128);
						match(OR);
						setState(129);
						bexpr(5);
						}
						break;
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AexprContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(KoordParser.LPAR, 0); }
		public List<AexprContext> aexpr() {
			return getRuleContexts(AexprContext.class);
		}
		public AexprContext aexpr(int i) {
			return getRuleContext(AexprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(KoordParser.RPAR, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode LID() { return getToken(KoordParser.LID, 0); }
		public TerminalNode TIMES() { return getToken(KoordParser.TIMES, 0); }
		public TerminalNode BY() { return getToken(KoordParser.BY, 0); }
		public TerminalNode PLUS() { return getToken(KoordParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(KoordParser.MINUS, 0); }
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterAexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitAexpr(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		return aexpr(0);
	}

	private AexprContext aexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexprContext _localctx = new AexprContext(_ctx, _parentState);
		AexprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_aexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				setState(136);
				match(LPAR);
				setState(137);
				aexpr(0);
				setState(138);
				match(RPAR);
				}
				break;
			case PID:
			case INUM:
			case FNUM:
				{
				setState(140);
				number();
				}
				break;
			case LID:
				{
				setState(141);
				match(LID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new AexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexpr);
						setState(144);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(145);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==BY) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(146);
						aexpr(5);
						}
						break;
					case 2:
						{
						_localctx = new AexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexpr);
						setState(147);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(148);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(149);
						aexpr(4);
						}
						break;
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode FNUM() { return getToken(KoordParser.FNUM, 0); }
		public TerminalNode INUM() { return getToken(KoordParser.INUM, 0); }
		public TerminalNode PID() { return getToken(KoordParser.PID, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PID) | (1L << INUM) | (1L << FNUM))) != 0)) ) {
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

	public static class RelopContext extends ParserRuleContext {
		public TerminalNode LANGLE() { return getToken(KoordParser.LANGLE, 0); }
		public TerminalNode RANGLE() { return getToken(KoordParser.RANGLE, 0); }
		public TerminalNode GEQ() { return getToken(KoordParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(KoordParser.LEQ, 0); }
		public TerminalNode EQ() { return getToken(KoordParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(KoordParser.NEQ, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitRelop(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LANGLE) | (1L << RANGLE) | (1L << EQ) | (1L << GEQ) | (1L << LEQ) | (1L << NEQ))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return bexpr_sempred((BexprContext)_localctx, predIndex);
		case 12:
			return aexpr_sempred((AexprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean bexpr_sempred(BexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean aexpr_sempred(AexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u00a2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\6\3$\n\3"+
		"\r\3\16\3%\3\4\6\4)\n\4\r\4\16\4*\3\5\7\5.\n\5\f\5\16\5\61\13\5\3\6\3"+
		"\6\3\6\3\6\3\6\6\68\n\6\r\6\16\69\3\6\3\6\3\6\6\6?\n\6\r\6\16\6@\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\6\tX\n\t\r\t\16\tY\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ne\n"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\5\fm\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r}\n\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0085"+
		"\n\r\f\r\16\r\u0088\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0091"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0099\n\16\f\16\16\16\u009c\13"+
		"\16\3\17\3\17\3\20\3\20\3\20\2\4\30\32\21\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36\2\7\4\2\3\7\t=\3\2\63\64\3\2\61\62\4\2\35\35/\60\4\2()\658\2"+
		"\u00a5\2 \3\2\2\2\4#\3\2\2\2\6(\3\2\2\2\b/\3\2\2\2\n\62\3\2\2\2\fB\3\2"+
		"\2\2\16E\3\2\2\2\20U\3\2\2\2\22d\3\2\2\2\24f\3\2\2\2\26l\3\2\2\2\30|\3"+
		"\2\2\2\32\u0090\3\2\2\2\34\u009d\3\2\2\2\36\u009f\3\2\2\2 !\t\2\2\2!\3"+
		"\3\2\2\2\"$\5\2\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\5\3\2\2"+
		"\2\')\5\16\b\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\7\3\2\2\2,.\5"+
		"\n\6\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\t\3\2\2\2\61/\3"+
		"\2\2\2\62\63\7\5\2\2\63\64\7\7\2\2\64\65\7-\2\2\65\67\7\"\2\2\668\5\f"+
		"\7\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\7#\2\2"+
		"<>\7\37\2\2=?\5\22\n\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\13\3\2"+
		"\2\2BC\7\6\2\2CD\7-\2\2D\r\3\2\2\2EF\7-\2\2FG\7\37\2\2GH\7:\2\2HI\7<\2"+
		"\2IJ\7\31\2\2JK\7\37\2\2KL\7\"\2\2LM\5\26\f\2MN\7#\2\2NO\7:\2\2OP\7\32"+
		"\2\2PQ\7\37\2\2QR\7:\2\2RS\5\20\t\2ST\7=\2\2T\17\3\2\2\2UW\7<\2\2VX\5"+
		"\22\n\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7=\2\2\\"+
		"\21\3\2\2\2]^\5\24\13\2^_\7:\2\2_e\3\2\2\2`a\7\30\2\2ab\7\37\2\2bc\7:"+
		"\2\2ce\5\20\t\2d]\3\2\2\2d`\3\2\2\2e\23\3\2\2\2fg\7-\2\2gh\79\2\2hi\5"+
		"\26\f\2i\25\3\2\2\2jm\5\32\16\2km\5\30\r\2lj\3\2\2\2lk\3\2\2\2m\27\3\2"+
		"\2\2no\b\r\1\2op\7,\2\2p}\5\30\r\nqr\7\"\2\2rs\5\30\r\2st\7#\2\2t}\3\2"+
		"\2\2uv\5\32\16\2vw\5\36\20\2wx\5\32\16\2x}\3\2\2\2y}\7\34\2\2z}\7\33\2"+
		"\2{}\7-\2\2|n\3\2\2\2|q\3\2\2\2|u\3\2\2\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2"+
		"\2}\u0086\3\2\2\2~\177\f\7\2\2\177\u0080\7*\2\2\u0080\u0085\5\30\r\b\u0081"+
		"\u0082\f\6\2\2\u0082\u0083\7+\2\2\u0083\u0085\5\30\r\7\u0084~\3\2\2\2"+
		"\u0084\u0081\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\31\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\b\16\1\2\u008a"+
		"\u008b\7\"\2\2\u008b\u008c\5\32\16\2\u008c\u008d\7#\2\2\u008d\u0091\3"+
		"\2\2\2\u008e\u0091\5\34\17\2\u008f\u0091\7-\2\2\u0090\u0089\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u009a\3\2\2\2\u0092\u0093\f\6"+
		"\2\2\u0093\u0094\t\3\2\2\u0094\u0099\5\32\16\7\u0095\u0096\f\5\2\2\u0096"+
		"\u0097\t\4\2\2\u0097\u0099\5\32\16\6\u0098\u0092\3\2\2\2\u0098\u0095\3"+
		"\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\33\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\t\5\2\2\u009e\35\3\2\2\2\u009f"+
		"\u00a0\t\6\2\2\u00a0\37\3\2\2\2\20%*/9@Ydl|\u0084\u0086\u0090\u0098\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
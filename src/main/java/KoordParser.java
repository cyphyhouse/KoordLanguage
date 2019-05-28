// Generated from /Users/johnwang/Desktop/koord/src/main/java/Koord.g4 by ANTLR 4.7.2
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
		AGENT=1, MODULE=2, USING=3, DEF=4, TYPE=5, FUN=6, ADT=7, ACTUATORS=8, 
		SENSORS=9, ALLWRITE=10, ALLREAD=11, LOCAL=12, LIST=13, MAP=14, QUEUE=15, 
		INIT=16, INT=17, FLOAT=18, BOOL=19, POS=20, INPUTMAP=21, IF=22, ELSE=23, 
		ATOMIC=24, PRE=25, EFF=26, TRUE=27, FALSE=28, PID=29, NUMAGENTS=30, COLON=31, 
		COMMA=32, SEMICOLON=33, LPAR=34, RPAR=35, LBRACE=36, RBRACE=37, LCURLY=38, 
		RCURLY=39, LANGLE=40, RANGLE=41, AND=42, OR=43, NOT=44, MODULENAME=45, 
		VARNAME=46, INUM=47, FNUM=48, PLUS=49, MINUS=50, TIMES=51, BY=52, EQ=53, 
		GEQ=54, LEQ=55, NEQ=56, ASGN=57, NEWLINE=58, SKIP_=59, INDENT=60, DEDENT=61, 
		CID=62;
	public static final int
		RULE_lexemes = 0, RULE_top = 1, RULE_program = 2, RULE_defs = 3, RULE_funcdef = 4, 
		RULE_param = 5, RULE_event = 6, RULE_statementblock = 7, RULE_stmt = 8, 
		RULE_funccall = 9, RULE_arglist = 10, RULE_assign = 11, RULE_expr = 12, 
		RULE_bexpr = 13, RULE_aexpr = 14, RULE_number = 15, RULE_relop = 16, RULE_decblock = 17, 
		RULE_decl = 18, RULE_module = 19, RULE_actuatordecls = 20, RULE_sensordecls = 21, 
		RULE_init = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"lexemes", "top", "program", "defs", "funcdef", "param", "event", "statementblock", 
			"stmt", "funccall", "arglist", "assign", "expr", "bexpr", "aexpr", "number", 
			"relop", "decblock", "decl", "module", "actuatordecls", "sensordecls", 
			"init"
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
			"SKIP_", "INDENT", "DEDENT", "CID"
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
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
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
			setState(46);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGENT) | (1L << MODULE) | (1L << DEF) | (1L << TYPE) | (1L << FUN) | (1L << ACTUATORS) | (1L << SENSORS) | (1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL) | (1L << LIST) | (1L << MAP) | (1L << QUEUE) | (1L << INIT) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS) | (1L << IF) | (1L << ELSE) | (1L << ATOMIC) | (1L << PRE) | (1L << EFF) | (1L << TRUE) | (1L << FALSE) | (1L << PID) | (1L << NUMAGENTS) | (1L << COLON) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LPAR) | (1L << RPAR) | (1L << LBRACE) | (1L << RBRACE) | (1L << LCURLY) | (1L << RCURLY) | (1L << LANGLE) | (1L << RANGLE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << VARNAME) | (1L << INUM) | (1L << FNUM) | (1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << BY) | (1L << EQ) | (1L << GEQ) | (1L << LEQ) | (1L << NEQ) | (1L << ASGN) | (1L << NEWLINE) | (1L << SKIP_) | (1L << INDENT) | (1L << DEDENT) | (1L << CID))) != 0)) ) {
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
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				lexemes();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AGENT) | (1L << MODULE) | (1L << DEF) | (1L << TYPE) | (1L << FUN) | (1L << ACTUATORS) | (1L << SENSORS) | (1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL) | (1L << LIST) | (1L << MAP) | (1L << QUEUE) | (1L << INIT) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS) | (1L << IF) | (1L << ELSE) | (1L << ATOMIC) | (1L << PRE) | (1L << EFF) | (1L << TRUE) | (1L << FALSE) | (1L << PID) | (1L << NUMAGENTS) | (1L << COLON) | (1L << COMMA) | (1L << SEMICOLON) | (1L << LPAR) | (1L << RPAR) | (1L << LBRACE) | (1L << RBRACE) | (1L << LCURLY) | (1L << RCURLY) | (1L << LANGLE) | (1L << RANGLE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << VARNAME) | (1L << INUM) | (1L << FNUM) | (1L << PLUS) | (1L << MINUS) | (1L << TIMES) | (1L << BY) | (1L << EQ) | (1L << GEQ) | (1L << LEQ) | (1L << NEQ) | (1L << ASGN) | (1L << NEWLINE) | (1L << SKIP_) | (1L << INDENT) | (1L << DEDENT) | (1L << CID))) != 0) );
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
		public DefsContext defs() {
			return getRuleContext(DefsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(KoordParser.EOF, 0); }
		public List<ModuleContext> module() {
			return getRuleContexts(ModuleContext.class);
		}
		public ModuleContext module(int i) {
			return getRuleContext(ModuleContext.class,i);
		}
		public List<DecblockContext> decblock() {
			return getRuleContexts(DecblockContext.class);
		}
		public DecblockContext decblock(int i) {
			return getRuleContext(DecblockContext.class,i);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
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
			setState(53);
			defs();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USING) {
				{
				{
				setState(54);
				module();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL))) != 0)) {
				{
				{
				setState(60);
				decblock();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INIT) {
				{
				setState(66);
				init();
				}
			}

			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				event();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VARNAME );
			setState(74);
			match(EOF);
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(76);
				funcdef();
				}
				}
				setState(81);
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
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
		public TerminalNode LPAR() { return getToken(KoordParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(KoordParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public StatementblockContext statementblock() {
			return getRuleContext(StatementblockContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
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
			setState(82);
			match(DEF);
			setState(83);
			match(FUN);
			setState(84);
			match(VARNAME);
			setState(85);
			match(LPAR);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(86);
				param();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(RPAR);
			setState(93);
			match(COLON);
			setState(94);
			match(NEWLINE);
			setState(95);
			statementblock();
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
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
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
			setState(97);
			match(TYPE);
			setState(98);
			match(VARNAME);
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
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
			setState(100);
			match(VARNAME);
			setState(101);
			match(COLON);
			setState(102);
			match(NEWLINE);
			setState(103);
			match(INDENT);
			setState(104);
			match(PRE);
			setState(105);
			match(COLON);
			setState(106);
			expr();
			setState(107);
			match(NEWLINE);
			setState(108);
			match(EFF);
			setState(109);
			match(COLON);
			setState(110);
			match(NEWLINE);
			setState(111);
			statementblock();
			setState(112);
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
			setState(114);
			match(INDENT);
			setState(116); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				stmt();
				}
				}
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ATOMIC) | (1L << VARNAME))) != 0) );
			setState(120);
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
		public List<TerminalNode> NEWLINE() { return getTokens(KoordParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KoordParser.NEWLINE, i);
		}
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public TerminalNode IF() { return getToken(KoordParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COLON() { return getTokens(KoordParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(KoordParser.COLON, i);
		}
		public List<StatementblockContext> statementblock() {
			return getRuleContexts(StatementblockContext.class);
		}
		public StatementblockContext statementblock(int i) {
			return getRuleContext(StatementblockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(KoordParser.ELSE, 0); }
		public TerminalNode ATOMIC() { return getToken(KoordParser.ATOMIC, 0); }
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
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				assign();
				setState(123);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				funccall();
				setState(126);
				match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(IF);
				setState(129);
				expr();
				setState(130);
				match(COLON);
				setState(131);
				match(NEWLINE);
				setState(132);
				statementblock();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(133);
					match(ELSE);
					setState(134);
					match(COLON);
					setState(135);
					match(NEWLINE);
					setState(136);
					statementblock();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(ATOMIC);
				setState(140);
				match(COLON);
				setState(141);
				match(NEWLINE);
				setState(142);
				statementblock();
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

	public static class FunccallContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
		public TerminalNode LPAR() { return getToken(KoordParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(KoordParser.RPAR, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public FunccallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funccall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitFunccall(this);
		}
	}

	public final FunccallContext funccall() throws RecognitionException {
		FunccallContext _localctx = new FunccallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funccall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(VARNAME);
			setState(146);
			match(LPAR);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << PID) | (1L << NUMAGENTS) | (1L << LPAR) | (1L << NOT) | (1L << VARNAME) | (1L << INUM) | (1L << FNUM))) != 0)) {
				{
				setState(147);
				arglist();
				}
			}

			setState(150);
			match(RPAR);
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

	public static class ArglistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KoordParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KoordParser.COMMA, i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitArglist(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			expr();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(153);
				match(COMMA);
				setState(154);
				expr();
				}
				}
				setState(159);
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
		public TerminalNode ASGN() { return getToken(KoordParser.ASGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(KoordParser.LBRACE, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(KoordParser.RBRACE, 0); }
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
		enterRule(_localctx, 22, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(VARNAME);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(161);
				match(LBRACE);
				setState(162);
				aexpr(0);
				setState(163);
				match(RBRACE);
				}
			}

			setState(167);
			match(ASGN);
			setState(168);
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
		enterRule(_localctx, 24, RULE_expr);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				aexpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
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
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_bexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(175);
				match(NOT);
				setState(176);
				bexpr(8);
				}
				break;
			case 2:
				{
				setState(177);
				match(LPAR);
				setState(178);
				bexpr(0);
				setState(179);
				match(RPAR);
				}
				break;
			case 3:
				{
				setState(181);
				aexpr(0);
				setState(182);
				relop();
				setState(183);
				aexpr(0);
				}
				break;
			case 4:
				{
				setState(185);
				match(FALSE);
				}
				break;
			case 5:
				{
				setState(186);
				match(TRUE);
				}
				break;
			case 6:
				{
				setState(187);
				match(VARNAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(196);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(190);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(191);
						match(AND);
						setState(192);
						bexpr(6);
						}
						break;
					case 2:
						{
						_localctx = new BexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bexpr);
						setState(193);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(194);
						match(OR);
						setState(195);
						bexpr(5);
						}
						break;
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public FunccallContext funccall() {
			return getRuleContext(FunccallContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
		public TerminalNode LBRACE() { return getToken(KoordParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(KoordParser.RBRACE, 0); }
		public TerminalNode NUMAGENTS() { return getToken(KoordParser.NUMAGENTS, 0); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_aexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(202);
				match(LPAR);
				setState(203);
				aexpr(0);
				setState(204);
				match(RPAR);
				}
				break;
			case 2:
				{
				setState(206);
				funccall();
				}
				break;
			case 3:
				{
				setState(207);
				number();
				}
				break;
			case 4:
				{
				setState(208);
				match(VARNAME);
				setState(209);
				match(LBRACE);
				setState(210);
				aexpr(0);
				setState(211);
				match(RBRACE);
				}
				break;
			case 5:
				{
				setState(213);
				match(NUMAGENTS);
				}
				break;
			case 6:
				{
				setState(214);
				match(VARNAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new AexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexpr);
						setState(217);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(218);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==BY) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(219);
						aexpr(8);
						}
						break;
					case 2:
						{
						_localctx = new AexprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_aexpr);
						setState(220);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(221);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(222);
						aexpr(7);
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		enterRule(_localctx, 30, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
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
		enterRule(_localctx, 32, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
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

	public static class DecblockContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(KoordParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(KoordParser.DEDENT, 0); }
		public TerminalNode ALLWRITE() { return getToken(KoordParser.ALLWRITE, 0); }
		public TerminalNode ALLREAD() { return getToken(KoordParser.ALLREAD, 0); }
		public TerminalNode LOCAL() { return getToken(KoordParser.LOCAL, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public DecblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterDecblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitDecblock(this);
		}
	}

	public final DecblockContext decblock() throws RecognitionException {
		DecblockContext _localctx = new DecblockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_decblock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALLWRITE) | (1L << ALLREAD) | (1L << LOCAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(233);
			match(COLON);
			setState(234);
			match(NEWLINE);
			setState(235);
			match(INDENT);
			setState(237); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(236);
				decl();
				}
				}
				setState(239); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUEUE) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS))) != 0) );
			setState(241);
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

	public static class DeclContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(KoordParser.VARNAME, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public TerminalNode INT() { return getToken(KoordParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(KoordParser.BOOL, 0); }
		public TerminalNode FLOAT() { return getToken(KoordParser.FLOAT, 0); }
		public TerminalNode POS() { return getToken(KoordParser.POS, 0); }
		public TerminalNode QUEUE() { return getToken(KoordParser.QUEUE, 0); }
		public TerminalNode ASGN() { return getToken(KoordParser.ASGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUEUE) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(244);
			match(VARNAME);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASGN) {
				{
				setState(245);
				match(ASGN);
				setState(246);
				expr();
				}
			}

			setState(249);
			match(NEWLINE);
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

	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(KoordParser.USING, 0); }
		public TerminalNode MODULE() { return getToken(KoordParser.MODULE, 0); }
		public TerminalNode MODULENAME() { return getToken(KoordParser.MODULENAME, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(KoordParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(KoordParser.DEDENT, 0); }
		public List<ActuatordeclsContext> actuatordecls() {
			return getRuleContexts(ActuatordeclsContext.class);
		}
		public ActuatordeclsContext actuatordecls(int i) {
			return getRuleContext(ActuatordeclsContext.class,i);
		}
		public List<SensordeclsContext> sensordecls() {
			return getRuleContexts(SensordeclsContext.class);
		}
		public SensordeclsContext sensordecls(int i) {
			return getRuleContext(SensordeclsContext.class,i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitModule(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(USING);
			setState(252);
			match(MODULE);
			setState(253);
			match(MODULENAME);
			setState(254);
			match(COLON);
			setState(255);
			match(NEWLINE);
			setState(256);
			match(INDENT);
			setState(259); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(259);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ACTUATORS:
					{
					setState(257);
					actuatordecls();
					}
					break;
				case SENSORS:
					{
					setState(258);
					sensordecls();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ACTUATORS || _la==SENSORS );
			setState(263);
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

	public static class ActuatordeclsContext extends ParserRuleContext {
		public TerminalNode ACTUATORS() { return getToken(KoordParser.ACTUATORS, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(KoordParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(KoordParser.DEDENT, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ActuatordeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actuatordecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterActuatordecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitActuatordecls(this);
		}
	}

	public final ActuatordeclsContext actuatordecls() throws RecognitionException {
		ActuatordeclsContext _localctx = new ActuatordeclsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_actuatordecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(ACTUATORS);
			setState(266);
			match(COLON);
			setState(267);
			match(NEWLINE);
			setState(268);
			match(INDENT);
			setState(270); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(269);
				decl();
				}
				}
				setState(272); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUEUE) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS))) != 0) );
			setState(274);
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

	public static class SensordeclsContext extends ParserRuleContext {
		public TerminalNode SENSORS() { return getToken(KoordParser.SENSORS, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(KoordParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(KoordParser.DEDENT, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public SensordeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensordecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterSensordecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitSensordecls(this);
		}
	}

	public final SensordeclsContext sensordecls() throws RecognitionException {
		SensordeclsContext _localctx = new SensordeclsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sensordecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(SENSORS);
			setState(277);
			match(COLON);
			setState(278);
			match(NEWLINE);
			setState(279);
			match(INDENT);
			setState(281); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(280);
				decl();
				}
				}
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUEUE) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << POS))) != 0) );
			setState(285);
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

	public static class InitContext extends ParserRuleContext {
		public TerminalNode INIT() { return getToken(KoordParser.INIT, 0); }
		public TerminalNode COLON() { return getToken(KoordParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(KoordParser.NEWLINE, 0); }
		public StatementblockContext statementblock() {
			return getRuleContext(StatementblockContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KoordListener ) ((KoordListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(INIT);
			setState(288);
			match(COLON);
			setState(289);
			match(NEWLINE);
			setState(290);
			statementblock();
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
		case 13:
			return bexpr_sempred((BexprContext)_localctx, predIndex);
		case 14:
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
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0127\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\3\6\3\64\n\3\r\3\16\3\65\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\7\4@\n\4"+
		"\f\4\16\4C\13\4\3\4\5\4F\n\4\3\4\6\4I\n\4\r\4\16\4J\3\4\3\4\3\5\7\5P\n"+
		"\5\f\5\16\5S\13\5\3\6\3\6\3\6\3\6\3\6\7\6Z\n\6\f\6\16\6]\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\6\tw\n\t\r\t\16\tx\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\n\3\n\3\n\3\n\5\n"+
		"\u0092\n\n\3\13\3\13\3\13\5\13\u0097\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u009e"+
		"\n\f\f\f\16\f\u00a1\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a8\n\r\3\r\3\r\3\r"+
		"\3\16\3\16\5\16\u00af\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00bf\n\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u00c7\n\17\f\17\16\17\u00ca\13\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00da\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u00e2\n\20\f\20\16\20\u00e5\13\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\6\23\u00f0\n\23\r\23\16\23\u00f1\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\5\24\u00fa\n\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\6\25\u0106\n\25\r\25\16\25\u0107\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\6\26\u0111\n\26\r\26\16\26\u0112\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\6\27\u011c\n\27\r\27\16\27\u011d\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\2\4\34\36\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\2\t\7\2\3\4\6\b\n\26\30.\60@\3\2\65\66\3\2\63\64\4\2\37\37\61"+
		"\62\4\2*+\67:\3\2\f\16\4\2\21\21\23\26\2\u0133\2\60\3\2\2\2\4\63\3\2\2"+
		"\2\6\67\3\2\2\2\bQ\3\2\2\2\nT\3\2\2\2\fc\3\2\2\2\16f\3\2\2\2\20t\3\2\2"+
		"\2\22\u0091\3\2\2\2\24\u0093\3\2\2\2\26\u009a\3\2\2\2\30\u00a2\3\2\2\2"+
		"\32\u00ae\3\2\2\2\34\u00be\3\2\2\2\36\u00d9\3\2\2\2 \u00e6\3\2\2\2\"\u00e8"+
		"\3\2\2\2$\u00ea\3\2\2\2&\u00f5\3\2\2\2(\u00fd\3\2\2\2*\u010b\3\2\2\2,"+
		"\u0116\3\2\2\2.\u0121\3\2\2\2\60\61\t\2\2\2\61\3\3\2\2\2\62\64\5\2\2\2"+
		"\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\5\3\2\2\2"+
		"\67;\5\b\5\28:\5(\25\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<A\3\2\2"+
		"\2=;\3\2\2\2>@\5$\23\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BE\3\2\2"+
		"\2CA\3\2\2\2DF\5.\30\2ED\3\2\2\2EF\3\2\2\2FH\3\2\2\2GI\5\16\b\2HG\3\2"+
		"\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\2\2\3M\7\3\2\2\2NP\5"+
		"\n\6\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2\2SQ\3\2\2\2TU"+
		"\7\6\2\2UV\7\b\2\2VW\7\60\2\2W[\7$\2\2XZ\5\f\7\2YX\3\2\2\2Z]\3\2\2\2["+
		"Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7%\2\2_`\7!\2\2`a\7<\2\2a"+
		"b\5\20\t\2b\13\3\2\2\2cd\7\7\2\2de\7\60\2\2e\r\3\2\2\2fg\7\60\2\2gh\7"+
		"!\2\2hi\7<\2\2ij\7>\2\2jk\7\33\2\2kl\7!\2\2lm\5\32\16\2mn\7<\2\2no\7\34"+
		"\2\2op\7!\2\2pq\7<\2\2qr\5\20\t\2rs\7?\2\2s\17\3\2\2\2tv\7>\2\2uw\5\22"+
		"\n\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7?\2\2{\21\3"+
		"\2\2\2|}\5\30\r\2}~\7<\2\2~\u0092\3\2\2\2\177\u0080\5\24\13\2\u0080\u0081"+
		"\7<\2\2\u0081\u0092\3\2\2\2\u0082\u0083\7\30\2\2\u0083\u0084\5\32\16\2"+
		"\u0084\u0085\7!\2\2\u0085\u0086\7<\2\2\u0086\u008b\5\20\t\2\u0087\u0088"+
		"\7\31\2\2\u0088\u0089\7!\2\2\u0089\u008a\7<\2\2\u008a\u008c\5\20\t\2\u008b"+
		"\u0087\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0092\3\2\2\2\u008d\u008e\7\32"+
		"\2\2\u008e\u008f\7!\2\2\u008f\u0090\7<\2\2\u0090\u0092\5\20\t\2\u0091"+
		"|\3\2\2\2\u0091\177\3\2\2\2\u0091\u0082\3\2\2\2\u0091\u008d\3\2\2\2\u0092"+
		"\23\3\2\2\2\u0093\u0094\7\60\2\2\u0094\u0096\7$\2\2\u0095\u0097\5\26\f"+
		"\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099"+
		"\7%\2\2\u0099\25\3\2\2\2\u009a\u009f\5\32\16\2\u009b\u009c\7\"\2\2\u009c"+
		"\u009e\5\32\16\2\u009d\u009b\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2"+
		"\u00a7\7\60\2\2\u00a3\u00a4\7&\2\2\u00a4\u00a5\5\36\20\2\u00a5\u00a6\7"+
		"\'\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\7;\2\2\u00aa\u00ab\5\32\16\2\u00ab\31\3\2\2"+
		"\2\u00ac\u00af\5\36\20\2\u00ad\u00af\5\34\17\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b1\b\17\1\2\u00b1\u00b2\7.\2"+
		"\2\u00b2\u00bf\5\34\17\n\u00b3\u00b4\7$\2\2\u00b4\u00b5\5\34\17\2\u00b5"+
		"\u00b6\7%\2\2\u00b6\u00bf\3\2\2\2\u00b7\u00b8\5\36\20\2\u00b8\u00b9\5"+
		"\"\22\2\u00b9\u00ba\5\36\20\2\u00ba\u00bf\3\2\2\2\u00bb\u00bf\7\36\2\2"+
		"\u00bc\u00bf\7\35\2\2\u00bd\u00bf\7\60\2\2\u00be\u00b0\3\2\2\2\u00be\u00b3"+
		"\3\2\2\2\u00be\u00b7\3\2\2\2\u00be\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00c8\3\2\2\2\u00c0\u00c1\f\7\2\2\u00c1\u00c2\7,"+
		"\2\2\u00c2\u00c7\5\34\17\b\u00c3\u00c4\f\6\2\2\u00c4\u00c5\7-\2\2\u00c5"+
		"\u00c7\5\34\17\7\u00c6\u00c0\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c7\u00ca\3"+
		"\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\35\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00cb\u00cc\b\20\1\2\u00cc\u00cd\7$\2\2\u00cd\u00ce\5\36"+
		"\20\2\u00ce\u00cf\7%\2\2\u00cf\u00da\3\2\2\2\u00d0\u00da\5\24\13\2\u00d1"+
		"\u00da\5 \21\2\u00d2\u00d3\7\60\2\2\u00d3\u00d4\7&\2\2\u00d4\u00d5\5\36"+
		"\20\2\u00d5\u00d6\7\'\2\2\u00d6\u00da\3\2\2\2\u00d7\u00da\7 \2\2\u00d8"+
		"\u00da\7\60\2\2\u00d9\u00cb\3\2\2\2\u00d9\u00d0\3\2\2\2\u00d9\u00d1\3"+
		"\2\2\2\u00d9\u00d2\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da"+
		"\u00e3\3\2\2\2\u00db\u00dc\f\t\2\2\u00dc\u00dd\t\3\2\2\u00dd\u00e2\5\36"+
		"\20\n\u00de\u00df\f\b\2\2\u00df\u00e0\t\4\2\2\u00e0\u00e2\5\36\20\t\u00e1"+
		"\u00db\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\37\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7"+
		"\t\5\2\2\u00e7!\3\2\2\2\u00e8\u00e9\t\6\2\2\u00e9#\3\2\2\2\u00ea\u00eb"+
		"\t\7\2\2\u00eb\u00ec\7!\2\2\u00ec\u00ed\7<\2\2\u00ed\u00ef\7>\2\2\u00ee"+
		"\u00f0\5&\24\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7?\2\2\u00f4"+
		"%\3\2\2\2\u00f5\u00f6\t\b\2\2\u00f6\u00f9\7\60\2\2\u00f7\u00f8\7;\2\2"+
		"\u00f8\u00fa\5\32\16\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00fc\7<\2\2\u00fc\'\3\2\2\2\u00fd\u00fe\7\5\2\2\u00fe"+
		"\u00ff\7\4\2\2\u00ff\u0100\7/\2\2\u0100\u0101\7!\2\2\u0101\u0102\7<\2"+
		"\2\u0102\u0105\7>\2\2\u0103\u0106\5*\26\2\u0104\u0106\5,\27\2\u0105\u0103"+
		"\3\2\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107"+
		"\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\7?\2\2\u010a)\3\2\2\2\u010b"+
		"\u010c\7\n\2\2\u010c\u010d\7!\2\2\u010d\u010e\7<\2\2\u010e\u0110\7>\2"+
		"\2\u010f\u0111\5&\24\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\7?\2\2\u0115"+
		"+\3\2\2\2\u0116\u0117\7\13\2\2\u0117\u0118\7!\2\2\u0118\u0119\7<\2\2\u0119"+
		"\u011b\7>\2\2\u011a\u011c\5&\24\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u0120\7?\2\2\u0120-\3\2\2\2\u0121\u0122\7\22\2\2\u0122\u0123\7!\2\2\u0123"+
		"\u0124\7<\2\2\u0124\u0125\5\20\t\2\u0125/\3\2\2\2\34\65;AEJQ[x\u008b\u0091"+
		"\u0096\u009f\u00a7\u00ae\u00be\u00c6\u00c8\u00d9\u00e1\u00e3\u00f1\u00f9"+
		"\u0105\u0107\u0112\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
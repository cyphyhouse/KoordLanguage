// Generated from Koord.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KoordParser}.
 */
public interface KoordListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KoordParser#lexemes}.
	 * @param ctx the parse tree
	 */
	void enterLexemes(KoordParser.LexemesContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#lexemes}.
	 * @param ctx the parse tree
	 */
	void exitLexemes(KoordParser.LexemesContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#top}.
	 * @param ctx the parse tree
	 */
	void enterTop(KoordParser.TopContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#top}.
	 * @param ctx the parse tree
	 */
	void exitTop(KoordParser.TopContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(KoordParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(KoordParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#defs}.
	 * @param ctx the parse tree
	 */
	void enterDefs(KoordParser.DefsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#defs}.
	 * @param ctx the parse tree
	 */
	void exitDefs(KoordParser.DefsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(KoordParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(KoordParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(KoordParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(KoordParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(KoordParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(KoordParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#statementblock}.
	 * @param ctx the parse tree
	 */
	void enterStatementblock(KoordParser.StatementblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#statementblock}.
	 * @param ctx the parse tree
	 */
	void exitStatementblock(KoordParser.StatementblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(KoordParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(KoordParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#funccall}.
	 * @param ctx the parse tree
	 */
	void enterFunccall(KoordParser.FunccallContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#funccall}.
	 * @param ctx the parse tree
	 */
	void exitFunccall(KoordParser.FunccallContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(KoordParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(KoordParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(KoordParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(KoordParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(KoordParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(KoordParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void enterBexpr(KoordParser.BexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#bexpr}.
	 * @param ctx the parse tree
	 */
	void exitBexpr(KoordParser.BexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void enterAexpr(KoordParser.AexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#aexpr}.
	 * @param ctx the parse tree
	 */
	void exitAexpr(KoordParser.AexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(KoordParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(KoordParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(KoordParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(KoordParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#decblock}.
	 * @param ctx the parse tree
	 */
	void enterDecblock(KoordParser.DecblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#decblock}.
	 * @param ctx the parse tree
	 */
	void exitDecblock(KoordParser.DecblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(KoordParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(KoordParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#arraydec}.
	 * @param ctx the parse tree
	 */
	void enterArraydec(KoordParser.ArraydecContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#arraydec}.
	 * @param ctx the parse tree
	 */
	void exitArraydec(KoordParser.ArraydecContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(KoordParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(KoordParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#actuatordecls}.
	 * @param ctx the parse tree
	 */
	void enterActuatordecls(KoordParser.ActuatordeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#actuatordecls}.
	 * @param ctx the parse tree
	 */
	void exitActuatordecls(KoordParser.ActuatordeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#sensordecls}.
	 * @param ctx the parse tree
	 */
	void enterSensordecls(KoordParser.SensordeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#sensordecls}.
	 * @param ctx the parse tree
	 */
	void exitSensordecls(KoordParser.SensordeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link KoordParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(KoordParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link KoordParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(KoordParser.InitContext ctx);
}
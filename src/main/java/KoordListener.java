// Generated from Koord.g4 by ANTLR 4.7.2
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
}
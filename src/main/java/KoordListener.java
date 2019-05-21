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
}
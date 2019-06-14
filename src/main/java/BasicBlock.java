import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a basic block, a linear block of instructions.
 * This block could either have two outgoing arrows, indicating that
 * the block ends with a branch statement, or it could have a single
 * out going arrow, indicating that it is pointing toward a merge block,
 * or it could have no arrows, meaning that it is the end.
 */
public class BasicBlock {

    private static Deque<BasicBlock> blocks = new ArrayDeque<>();
    private List<KoordParser.StmtContext> instructions;
    private BasicBlock trueExit;
    private BasicBlock falseExit;
    private BasicBlock singleExit;
    //when the last statement is a branch,
    //the condition is stored here instead of instructions
    private KoordParser.ExprContext condition;

    private BasicBlock() {
        instructions = new ArrayList<>();
    }

    /**
     * Factory method to construct a control flow graph.
     * Use this instead of the constructor.
     *
     * @param tree the parse tree
     * @return the root of the control flow graph
     */
    public static BasicBlock createFromTree(ParseTree tree) {
        blocks.clear();
        BasicBlock begin = new BasicBlock();
        blocks.push(begin);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            @Override
            public void enterStmt(KoordParser.StmtContext ctx) {
                if (ctx.conditional() == null) {
                    blocks.peek().instructions.add(ctx);
                } else {
                    blocks.peek().condition = ctx.conditional().expr();
                }
            }

            @Override
            public void enterConditional(KoordParser.ConditionalContext ctx) {
                blocks.peek().trueExit = new BasicBlock();

                blocks.push(blocks.peek().trueExit);
            }

            @Override
            public void enterElseblock(KoordParser.ElseblockContext ctx) {
                //means that the true block has finished
                BasicBlock trueBlock = blocks.pop();
                BasicBlock falseBlock = new BasicBlock();
                blocks.peek().falseExit = falseBlock;

                blocks.push(trueBlock);
                blocks.push(falseBlock);

            }

            @Override
            public void exitConditional(KoordParser.ConditionalContext ctx) {

                BasicBlock falseBlock;
                if (ctx.elseblock() != null) {
                    falseBlock = blocks.pop();
                } else {
                    falseBlock = new BasicBlock();
                }
                var trueBlock = blocks.pop();

                var splitBlock = blocks.pop();

                if (ctx.elseblock() == null) {
                    splitBlock.falseExit = falseBlock;
                }

                var mergeBlock = new BasicBlock();

                falseBlock.singleExit = mergeBlock;
                trueBlock.singleExit = mergeBlock;
                blocks.push(mergeBlock);
            }


        }, tree);
        return begin;
    }

    /**
     * The linear list of statements that are inside the BasicBlock.
     *
     * @return the list of statements
     */
    public List<KoordParser.StmtContext> getInstructions() {
        return instructions;
    }

    /**
     * The arrow when the corresponding branch statement is true.
     *
     * @return the block
     */
    public BasicBlock getTrueExit() {
        return trueExit;
    }

    /**
     * The arrow when the branch statement is false, aka the else statement.
     * If there is an if with no else, this will point to an empty basic block.
     *
     * @return the else block
     */
    public BasicBlock getFalseExit() {
        return falseExit;
    }

    /**
     * Used when pointing to a merge block.
     *
     * @return the block.
     */
    public BasicBlock getSingleExit() {
        return singleExit;
    }

    /**
     * Create a human readable form of the basic block.
     * Shows the statements and the condition.
     *
     * @return the string form
     */
    public String toString() {
        var statements = instructions
                .stream()
                .map(RuleContext::getText)
                .collect(Collectors.joining(", "));

        return "statements: [" + statements + "]"
                + "condition: " + (condition == null ? "null" : condition.getText());
    }

    private Set<BasicBlock> seen = new HashSet<>();

    public void dfs(BasicBlockListener listener) {
        listener.enterNode(this);
        if (singleExit != null) {
            listener.enterSingle(this);
            singleExit.dfs(listener);
            listener.exitSingle(this);
        }
        if (trueExit != null) {
            listener.enterTrue(this);
            trueExit.dfs(listener);
            listener.exitTrue(this);
        }
        if (falseExit != null) {
            listener.enterFalse(this);
            falseExit.dfs(listener);
            listener.exitFalse(this);
        }
        listener.exitNode(this);
    }

    public void memoDfs(BasicBlockListener listener) {
        seen.clear();
        memoRec(listener);

    }

    private void memoRec(BasicBlockListener listener) {
        if (seen.contains(this)) {
            return;
        }

        listener.enterNode(this);
        if (singleExit != null) {
            listener.enterSingle(singleExit);
            singleExit.memoRec(listener);
            listener.exitSingle(singleExit);
        }
        if (trueExit != null) {
            listener.enterTrue(trueExit);
            trueExit.memoRec(listener);
            listener.exitTrue(trueExit);
        }
        if (falseExit != null) {
            listener.enterFalse(falseExit);
            falseExit.memoRec(listener);
            listener.exitFalse(falseExit);
        }
        listener.exitNode(this);
    }
}

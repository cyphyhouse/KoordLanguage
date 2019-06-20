import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to find the worst case scenario in a control flow graph.
 */
public class Timer {

    /**
     * Rerpresents the cost of each statement/expression type.
     */
    public enum StatementType {
        /**
         * Variable assignment cost
         */
        Assign(1),
        /**
         * A function call cost
         */
        FunctionCall(5),
        /**
         * IO stream cost
         */
        Stream(10),
        /**
         * Add cost
         */
        Add(1),
        /**
         * Subtraction cost
         */
        Minus(2),
        /**
         * Multiplication cost
         */
        Multiply(2);

        /**
         * Cost of the statement/expression
         */
        public int cost;
        StatementType(int i) {
            cost = i;
        }

        /**
         * Turns a statement into the enum
         * @param ctx statement context
         * @return a statement type
         */
        static StatementType fromStatementContext(KoordParser.StmtContext ctx) {
            if (ctx.assign() != null) {
                return Assign;
            }
            if (ctx.funccall() != null) {
                return FunctionCall;
            }

            if (ctx.iostream() != null) {
                return Stream;
            }
            return null;
        }

        static int expressionCost;
        static int statementCost(KoordParser.StmtContext tree) {
            expressionCost = fromStatementContext(tree).cost;
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new KoordBaseListener() {
                @Override
                public void enterAexpr(KoordParser.AexprContext ctx) {
                    if (ctx.PLUS() != null) {
                        expressionCost += StatementType.Add.cost;
                    } else if (ctx.MINUS() != null) {
                        expressionCost += StatementType.Minus.cost;
                    } else if (ctx.TIMES() != null) {
                        expressionCost += StatementType.Multiply.cost;
                    }
                }
            }, tree);
            return expressionCost;
        }

        /**
         * Finds the cost of a basic block, but not the descendents
         * @param b the block
         * @return the cost
         */
        static int blockCost(BasicBlock b) {

            int cost = b
                    .getInstructions()
                    .stream()
                    .mapToInt(ctx -> statementCost(ctx))
                    .sum();

            return cost;
        }
    }


    private BasicBlock beginBlock;

    /**
     * Creates the timer using the basic block.
     * @param root The root of the tree.
     */
    public Timer(BasicBlock root) {
        beginBlock = root;
    }


    private Map<BasicBlock, Integer> costs = new HashMap<>();
    /**
     * Finds the worst case scenario using a dfs.
     * @return The worst cost.
     */
    public int getWorstCost() {

        beginBlock.memoDfs(new BasicBlockListener() {
            @Override
            public void enterTrue(BasicBlock block) {

            }

            @Override
            public void exitTrue(BasicBlock block) {

            }

            @Override
            public void enterFalse(BasicBlock block) {
            }

            @Override
            public void exitFalse(BasicBlock block) {

            }

            @Override
            public void enterSingle(BasicBlock block) {

            }

            @Override
            public void exitSingle(BasicBlock block) {

            }

            @Override
            public void enterNode(BasicBlock block) {

            }

            @Override
            public void exitNode(BasicBlock block) {
                int cost = StatementType.blockCost(block);

                BasicBlock single = block.getSingleExit();
                BasicBlock trueExit = block.getTrueExit();
                BasicBlock falseExit = block.getFalseExit();

                if (single != null) {
                    cost += costs.get(single);
                }

                if (trueExit != null && falseExit != null) {
                    cost += Math.max(costs.get(trueExit), costs.get(falseExit));
                }

                costs.put(block, cost);
            }
        });
        return costs.get(beginBlock);
    }

}

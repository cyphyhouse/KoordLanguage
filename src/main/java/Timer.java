import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayDeque;
import java.util.Deque;
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
        Assign(1),
        FunctionCall(5),
        Stream(10),
        Add(1),
        Minus(2),
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


    /**
     * Finds the worst case scenario using a dfs.
     * @return The worst cost.
     */
    public int getWorstCost() {

        Deque<BasicBlock> blocks = new ArrayDeque<>();
        Map<BasicBlock, Integer> costs = new HashMap<>();

        blocks.push(beginBlock);

        while (!blocks.isEmpty()) {
            BasicBlock currentBlock = blocks.peek();
            if (costs.containsKey(currentBlock)) {
                blocks.pop();
                continue;
            }

            int cost = StatementType.blockCost(currentBlock);

            var single = currentBlock.getSingleExit();
            var trueExit = currentBlock.getTrueExit();
            var falseExit = currentBlock.getFalseExit();

            if (single != null && !costs.containsKey(single)) {
                blocks.push(single);
                continue;
            }
            if (trueExit != null && !costs.containsKey(trueExit)) {
                blocks.push(trueExit);
                continue;
            }
            if (falseExit != null && !costs.containsKey(falseExit)) {
                blocks.push(falseExit);
                continue;
            }


            if (single != null) {
                cost += costs.get(single);
            } else if (trueExit != null && falseExit != null) {
                cost += Math.max(costs.get(trueExit), costs.get(falseExit));
            } else {
                //this is a leaf node
            }

            costs.put(currentBlock, cost);
        }

        return costs.get(beginBlock);
    }

}

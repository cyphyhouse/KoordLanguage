import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Timer {
    public enum StatementType {
        Assign(1),
        FunctionCall(5),
        Stream(10);

        int cost;
        StatementType(int i) {
            cost = i;
        }



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

        static int blockCost(BasicBlock b) {

            int cost = b
                    .getInstructions()
                    .stream()
                    .mapToInt(ctx -> StatementType.fromStatementContext(ctx).cost)
                    .sum();

            return cost;
        }
    }


    private BasicBlock beginBlock;

    public Timer(BasicBlock b) {
        beginBlock = b;
    }


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

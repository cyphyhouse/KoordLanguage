import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BasicBlock {

    private List<KoordParser.StmtContext> instructions;

    private BasicBlock trueExit;
    private BasicBlock falseExit;
    private BasicBlock singleExit;


    private static Deque<BasicBlock> blocks;
    public static BasicBlock createFromTree(ParseTree tree) {
        BasicBlock begin = new BasicBlock();
        blocks.push(begin);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            @Override
            public void enterStmt(KoordParser.StmtContext ctx) {
                blocks.peek().instructions.add(ctx);
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

                BasicBlock falseBlock = null;
                if (ctx.elseblock() != null) {
                    falseBlock = blocks.pop();
                }
                var trueBlock = blocks.pop();

                var splitBlock = blocks.pop();

                var mergeBlock = new BasicBlock();

                falseBlock.singleExit = mergeBlock;
                trueBlock.singleExit = mergeBlock;
                blocks.push(mergeBlock);
            }


        }, tree);
        return begin;
    }

    private BasicBlock() {
        instructions = new ArrayList<>();
    }
}

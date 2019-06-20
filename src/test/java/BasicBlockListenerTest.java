import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicBlockListenerTest {
    int numTotal = 0;
    int numTrue = 0;
    int numFalse = 0;
    int numSingle = 0;

    @Test
    void checkDfs() {
        numTotal = 0;
        numTrue = 0;
        numFalse = 0;
        numSingle = 0;

        var tree = Utils.treeFromFile("src/test/resources/nestedif.koord");
        BasicBlock root = BasicBlock.createFromTree(tree);

        root.dfs(new AddListener());
        assertEquals(2, numTrue);
        assertEquals(2, numFalse);
        assertEquals(5, numSingle);
        assertEquals(10, numTotal);

    }

    @Test
    void memodfs() {
        numTotal = 0;
        numTrue = 0;
        numFalse = 0;
        numSingle = 0;

        var tree = Utils.treeFromFile("src/test/resources/nestedif.koord");
        BasicBlock root = BasicBlock.createFromTree(tree);

        root.memoDfs(new AddListener());
        assertEquals(2, numTrue);
        assertEquals(2, numFalse);
        assertEquals(4, numSingle);
        assertEquals(7, numTotal);

    }

    class AddListener implements BasicBlockListener {
        @Override
        public void enterTrue(BasicBlock block) {
            numTrue++;
        }

        @Override
        public void exitTrue(BasicBlock block) {

        }

        @Override
        public void enterFalse(BasicBlock block) {
            numFalse++;

        }

        @Override
        public void exitFalse(BasicBlock block) {

        }

        @Override
        public void enterSingle(BasicBlock block) {
            numSingle++;

        }

        @Override
        public void exitSingle(BasicBlock block) {

        }

        @Override
        public void enterNode(BasicBlock block) {

            numTotal++;
        }

        @Override
        public void exitNode(BasicBlock block) {
        }
    }
}

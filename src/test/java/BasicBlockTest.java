import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasicBlockTest {
    @Test
    void nestedIf() {
        var tree = Utils.treeFromFile("src/test/resources/nestedif.koord");
        BasicBlock b = BasicBlock.createFromTree(tree);
        var mergeBlock1 = b.getTrueExit().getTrueExit().getSingleExit();
        var mergeBlock2 = b.getTrueExit().getFalseExit().getSingleExit();
        assertEquals(mergeBlock1, mergeBlock2);
        var mergeBlock3 = b.getFalseExit().getSingleExit();
        var mergeBlock4 = mergeBlock2.getSingleExit();
        assertEquals(mergeBlock3, mergeBlock4);
        assertNull(mergeBlock3.getSingleExit());
        assertNull(mergeBlock3.getTrueExit());
        assertNull(mergeBlock3.getFalseExit());
/*
diagram looks like this

                                             +----------+
                                             |          |
                                             |          |
                                             | if true  |
                                             |   +      |
                                             +----------+
                                                 |
                     +----------+                |
                     |          |                |              +--------------+
                     |          | <--------------+------------> |              |
                     |   if true|                               |              |
                     |          |                               |     c()      |
                     |          |                               |              |
                     +--+-------+                               |              |
                        |                                       +------+-------+
                        |                                              |
                        |                                              |
+-------------+         |       +------------+                         |
|             |         |       |            |                         |
|             +<--------+------>+            |                         |
|     a()     |                 |   b()      |                         |
|             |                 |            |                         |
|             |                 |            |                         |
+-----+-------+                 +------+-----+                         |
      |                                |                               |
      |                                |                               |
      |                                |                               |
      |                                |                               |
      |          +------------+        |                               |
      |          |            |        |                               |
      |          |            |        |                               |
      +--------> |            | <------+                               |
                 |            |                                        |
                 +-----+------+                                        |
                       |                                               |
                       |                                               |
                       |                                               |
                       |               +------------+                  |
                       |               |            |                  |
                       |               |            | <----------------+
                       +-------------->+            |
                                       +------------+

 */

    }


    @Test
    void deeperNest() {

        var tree = Utils.treeFromFile("src/test/resources/deepernestedif.koord");
        BasicBlock root = BasicBlock.createFromTree(tree);


        var branch1 = root.getTrueExit();
        var branch2 = root.getFalseExit();
        assertTrue(branch2.toString().contains("c()"));

        var branch3 = branch1.getTrueExit();
        assertTrue(branch3.toString().contains("a()"));

        var branch4 = branch1.getFalseExit();
        assertTrue(branch4.toString().contains("b()"));


        var branch5 = branch3.getTrueExit();
        assertTrue(branch5.toString().contains("f()"));
        var branch6 = branch3.getFalseExit();
        assertTrue(branch6.toString().contains("g()"));


        assertEquals(branch5.getSingleExit(), branch6.getSingleExit());
        var branch7 = branch5.getSingleExit();
        assertTrue(branch7.toString().contains("h()"));
        var branch8 = branch4.getSingleExit();
        assertTrue(branch8.toString().contains("e()"));
        assertEquals(branch7.getSingleExit(), branch8);


        assertEquals(branch8.getSingleExit(), branch2.getSingleExit());
        /*

                                      if true
                                         +
                                         |
                         if false<-------+----------->  c()
                            +                            +
        +-----------+       |                            |
        |   a()     +<------+-----> b()                  |
        |   if true |                +                   |
        +----+------+                |                   |
             |                       |                   |
             |                       |                   |
f()  <-------+-------> g()           |                   |
 +                      +            |                   |
 |                      |            |                   |
 |                      |            |                   |
 |                      |            |                   |
 +---------> h()<-------+            |                   |
              +                      |                   |
              |                      |                   |
              +--------> e()---------+                   |
                          +                              |
                          |                              |
                          |       +-------+              |
                          +-----> |       +<-------------+
                                  |       |
                                  +-------+

         */
    }

    @Test
    void hangingIf() {
        var tree = Utils.treeFromFile("src/test/resources/hangingif.koord");
        BasicBlock root = BasicBlock.createFromTree(tree);


        var branch1 = root.getTrueExit();
        var branch2 = root.getFalseExit();
        assertTrue(branch2.getInstructions().isEmpty());

        var branch3 = branch1.getTrueExit();
        assertTrue(branch3.toString().contains("a()"));

        var branch4 = branch1.getFalseExit();
        assertTrue(branch4.toString().contains("b()"));


        var branch5 = branch3.getTrueExit();
        assertTrue(branch5.toString().contains("f()"));
        var branch6 = branch3.getFalseExit();
        assertTrue(branch6.getInstructions().isEmpty());


        assertEquals(branch5.getSingleExit(), branch6.getSingleExit());
        var branch7 = branch5.getSingleExit();
        assertTrue(branch7.toString().contains("h()"));
        var branch8 = branch4.getSingleExit();
        assertTrue(branch8.toString().contains("e()"));
        assertEquals(branch7.getSingleExit(), branch8);


        assertEquals(branch8.getSingleExit(), branch2.getSingleExit());
        assertTrue(branch8.getSingleExit().toString().contains("g()"));
         /*

                                      if true
                                         +
                                         |
                         if false<-------+----------->  blank
                            +                            +
        +-----------+       |                            |
        |    a()    +<------+-----> b()                  |
        |   if true |                +                   |
        +----+------+                |                   |
             |                       |                   |
             |                       |                   |
f()  <-------+-------> <blank>       |                   |
 +                      +            |                   |
 |                      |            |                   |
 |                      |            |                   |
 |                      |            |                   |
 +---------> h()<-------+            |                   |
              +                      |                   |
              |                      |                   |
              +--------> e()---------+                   |
                          +                              |
                          |                              |
                          |       +-------+              |
                          +-----> |       +<-------------+
                                  |  g()  |
                                  +-------+

         */
    }


    @Test
    public void timeNestedIf() {

        var tree = Utils.treeFromFile("src/test/resources/time.koord");
        BasicBlock root = BasicBlock.createFromTree(tree);
        Timer t = new Timer(root);
        assertEquals(t.getWorstCost(), 16);
        //assuming we have 1, 5, 10
    }
    @Test
    public void timeNestedIfWithExpr() {

        var tree = Utils.treeFromFile("src/test/resources/timeexpr.koord");
        BasicBlock root = BasicBlock.createFromTree(tree);
        Timer t = new Timer(root);
        assertEquals(t.getWorstCost(), 19);
        //assuming we have 1, 5, 10, 2 and 1 for multiplecatio, addition
    }

    private int findIndexOfSubString(List<String> list, String sub) {
        return IntStream.range(0, list.size())
                .filter(x -> list.get(x).contains(sub))
                .findFirst()
                .getAsInt();
    }

    @Test
    public void topoSort() {
        var tree = Utils.treeFromFile("src/test/resources/deepernestedif.koord");
        BasicBlock root = BasicBlock.createFromTree(tree);
        List<String> list = new ArrayList<>();
        root.topological(new BasicBlockListener() {
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
                list.add(block.toString());

            }

            @Override
            public void exitNode(BasicBlock block) {

            }
        });
        assertTrue(findIndexOfSubString(list, "a()") < findIndexOfSubString(list, "f()"));
        assertTrue(findIndexOfSubString(list, "a()") < findIndexOfSubString(list, "g()"));
        assertTrue(findIndexOfSubString(list, "b()") < findIndexOfSubString(list, "e()"));

    }
}

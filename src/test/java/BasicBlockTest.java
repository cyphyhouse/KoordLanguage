import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
}

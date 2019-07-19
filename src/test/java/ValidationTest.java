import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class ValidationTest {
    @Test
    void lineform() throws IOException {
        assumeTrue (new Utils.SyntaxChecker().testFile("src/test/resources/lineform.koord"));
        ParseTree p = Utils.treeFromFile("src/test/resources/lineform.koord");
        var map = new SymbolTable(p);
        assertTrue(map.isValid());

    }

    @Test
    void shapeform() throws IOException {
        assumeTrue (new Utils.SyntaxChecker().testFile("src/test/resources/shapeform.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/shapeform.koord");
        var map = new SymbolTable(p);
        assertTrue (map.isValid());

    }

    @Test
    void hvac() throws IOException {
        assumeTrue(new Utils.SyntaxChecker().testFile("src/test/resources/hvac.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/hvac.koord");
        var map = new SymbolTable(p);
        assertTrue (map.isValid());

    }


    @Test
    void log() throws IOException {
        assumeTrue(new Utils.SyntaxChecker().testFile("src/test/resources/log.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/log.koord");
        var map = new SymbolTable(p);
        assertTrue(map.isValid());

    }

    @Test
    void arrayaccess() throws IOException {
        assumeTrue(new Utils.SyntaxChecker().testFile("src/test/resources/arrayaccess.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/arrayaccess.koord");
        var map = new SymbolTable(p);
        assertTrue(map.isValid());

    }

    @Test
    void basicFollow() throws IOException {
        var filename = "src/test/resources/basicFollow.koord";
        assumeTrue(new Utils.SyntaxChecker().testFile(filename));

        ParseTree p = Utils.treeFromFile(filename);
        var map = new SymbolTable(p);
        assertTrue(map.isValid());

    }

    @Test
    void tasks() throws IOException {
        var filename = "src/test/resources/tasks.koord";
        assumeTrue(new Utils.SyntaxChecker().testFile(filename));

        ParseTree p = Utils.treeFromFile(filename);
        var map = new SymbolTable(p);
        assertTrue(map.isValid());

    }

    @Test
    void position() throws IOException {
        var filename = "src/test/resources/position.koord";
        assumeTrue(new Utils.SyntaxChecker().testFile(filename));

        ParseTree p = Utils.treeFromFile(filename);
        var map = new SymbolTable(p);
        assertTrue(map.isValid());

    }
}

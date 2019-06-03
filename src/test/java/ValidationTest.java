import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ValidationTest {
    @Test
    void lineform() throws IOException {
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/lineform.koord"));
        ParseTree p = Utils.treeFromFile("src/test/resources/lineform.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    void shapeform() throws IOException {
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/shapeform.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/shapeform.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    void hvac() throws IOException{
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/hvac.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/hvac.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }


    @Test
    void log() throws IOException{
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/log.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/log.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    void arrayaccess() throws IOException{
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/arrayaccess.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/arrayaccess.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
}

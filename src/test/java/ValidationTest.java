import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ValidationTest {
    @Test
    public void lineform() throws IOException {
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/lineform.koord"));
        ParseTree p = Utils.treeFromFile("src/test/resources/lineform.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    public void shapeform() throws IOException {
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/shapeform.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/shapeform.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    public void hvac() throws IOException{
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/hvac.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/hvac.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }


    @Test
    public void log() throws IOException{
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/log.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/log.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    public void arrayaccess() throws IOException{
        assert(new Utils.SyntaxChecker().testFile("src/test/resources/arrayaccess.koord"));

        ParseTree p = Utils.treeFromFile("src/test/resources/arrayaccess.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
}

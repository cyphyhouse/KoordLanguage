import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    public void lineform() {

        ParseTree p = Utils.treeFromFile("src/test/resources/lineform.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    public void shapeform() {

        ParseTree p = Utils.treeFromFile("src/test/resources/shapeform.koord");
        var map = new SymbolTable(p);
        assert(map.isValid());

    }
    @Test
    public void hvac() {

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

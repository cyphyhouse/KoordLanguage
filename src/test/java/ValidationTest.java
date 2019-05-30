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
}

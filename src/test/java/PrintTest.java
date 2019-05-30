import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

public class PrintTest {
    @Test
    public void printTest() {
        ParseTree p = Utils.treeFromFile("src/test/resources/scopes.koord");
        var map = new SymbolTable(p);
        System.out.println(map.getTable().toString());
    }
}

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolTest {

    @Test
    public void findUnresolvedSymbols() {
        KoordParser p = Utils.parserFromFile("src/test/resources/test1.koord");
        ParseTree tree = p.program();
        List<String> actual = new SymbolTable(tree).getUnresolvedSymbols()
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        List<String> expected = Arrays.asList(new String[] {"added", "finalsum", "numadded", "sum" });


        assert(expected.equals(actual) );
    }

    @Test
    public void allDeclared() {
        KoordParser p = Utils.parserFromFile("src/test/resources/test3.koord");
        ParseTree tree = p.program();
        List<String> actual = new SymbolTable(tree).getUnresolvedSymbols();

        assert(actual.isEmpty());

    }

    @Test
    public void correctScope() {
        KoordParser p = Utils.parserFromFile("src/test/resources/scopes.koord");
        ParseTree tree = p.program();
        var map = new SymbolTable(tree).getTable();
        var a = map.get("a");
        assert(a.scope == SymbolTable.Scope.AllWrite);
        assert(map.get("b").scope == SymbolTable.Scope.AllWrite);
        assert(map.get("c").scope == SymbolTable.Scope.AllRead);
        assert(map.get("d").scope == SymbolTable.Scope.AllRead);
        assert(map.get("e").scope == SymbolTable.Scope.Local);
        assert(map.get("f").scope == SymbolTable.Scope.Local);

    }
}

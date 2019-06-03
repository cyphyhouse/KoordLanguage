import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        assert(a.scope == Scope.AllWrite);
        assert(map.get("b").scope == Scope.AllWrite);
        assert(map.get("c").scope == Scope.AllRead);
        assert(map.get("d").scope == Scope.AllRead);
        assert(map.get("e").scope == Scope.Local);
        assert(map.get("f").scope == Scope.Local);
        assert(map.get("Motion.foo").scope == Scope.Actuator);
        assert(map.get("Motion.bar").scope == Scope.Sensor);

    }

    @Test
    public void arrayScalar() {
        KoordParser p = Utils.parserFromFile("src/test/resources/badscope.koord");
        ParseTree tree = p.program();
        var table = new SymbolTable(tree);
        var badTypes = table.getTypeMismatch()
                .stream()
                .map((x) -> x.getText())
                .collect(Collectors.toList());

        assert(badTypes.get(0).contains("a"));
        assert(badTypes.get(1).contains("f"));

    }

    @Test
    public void assignToSharedLocal() {
        KoordParser p = Utils.parserFromFile("src/test/resources/badassign.koord");
        ParseTree tree = p.program();
        var table = new SymbolTable(tree);
        var badTypes = table.getTypeMismatch()
                .stream()
                .map((x) -> x.getText())
                .collect(Collectors.toList());
        var assignToSensor = table.getAssignToSensor();

        assert(badTypes.get(0).contains("e"));
        assert(badTypes.get(1).contains("c"));
        assert(assignToSensor.contains("Motion.foo"));
    }


    @Test
    public void multipleDeclaration() {

        ParseTree p = Utils.treeFromFile("src/test/resources/multipledecl.koord");
        var map = new SymbolTable(p);
        var multipleDec = map.getMultipleDeclaration();
        assert(multipleDec.contains("a"));

    }

    @Test
    public void typeMismatch() {

        ParseTree p = Utils.treeFromFile("src/test/resources/badtype.koord");
        var map = new SymbolTable(p);
        var badTypes = map.getTypeMismatch()
                .stream()
                .map((x) -> x.getText())
                .collect(Collectors.toList());
        assert(badTypes.get(0).contains("apple"));

    }
    @Test
    public void nestedTypeFail() {

        ParseTree p = Utils.treeFromFile("src/test/resources/badtype.koord");
        var map = new SymbolTable(p);
        var badTypes = map.getTypeMismatch()
                .stream()
                .map((x) -> x.getText())
                .collect(Collectors.toList());
        assert(badTypes.get(1).contains("banana"));

    }


}

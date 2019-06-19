import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsageTableTest {
    @Test
    public void allDeclared() {
        KoordParser p = Utils.parserFromFile("src/test/resources/manyevents.koord");
        ParseTree tree = p.program();

        var symbolTable = new SymbolTable(tree);
        var usageTable = new UsageTable(symbolTable);

        assertTrue(usageTable.getSharedReadVars("eventA").contains("writeFoo"));
        assertTrue(usageTable.getSharedWriteVars("eventA").contains("writeFoo"));
        assertFalse(usageTable.getSharedWriteVars("eventA").contains("localFoo"));


        assertTrue(usageTable.getSharedReadVars("eventB").contains("readFoo"));
        assertTrue(usageTable.getSharedWriteVars("eventB").contains("writeBar"));
        assertFalse(usageTable.getSharedWriteVars("eventB").contains("writeFoo"));

    }
}

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

public class UsageTable {
    private List<TableEntry> table = new ArrayList<>();
    private String currentEvent;
    private SymbolTable symbolTable;


    public UsageTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        ParseTree tree = symbolTable.getTree();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            @Override
            public void enterEvent(KoordParser.EventContext ctx) {
                currentEvent = ctx.VARNAME().getText();
            }

            @Override
            public void enterAssign(KoordParser.AssignContext ctx) {
                var name = ctx.VARNAME().getText();
                var entry = new TableEntry();
                entry.usage = Usage.Write;
                entry.entry = symbolTable.getTable().get(name);
                entry.event = currentEvent;
                table.add(entry);
            }

            @Override
            public void enterBexpr(KoordParser.BexprContext ctx) {

                var variable = ctx.VARNAME();
                if (variable != null) {
                    var name = variable.getText();
                    var entry = new TableEntry();
                    entry.usage = Usage.Read;
                    entry.entry = symbolTable.getTable().get(name);
                    entry.event = currentEvent;
                    table.add(entry);

                }
            }

            @Override
            public void enterAexpr(KoordParser.AexprContext ctx) {

                var variable = ctx.VARNAME();
                if (variable != null) {
                    var name = variable.getText();
                    var entry = new TableEntry();
                    entry.usage = Usage.Read;
                    entry.entry = symbolTable.getTable().get(name);
                    entry.event = currentEvent;
                    table.add(entry);

                }
            }
        }, tree);

    }

    enum Usage {
        Read,
        Write,
    }

    class TableEntry {
        Usage usage;
        SymbolTable.SymbolTableEntry entry;
        String event;
    }


}

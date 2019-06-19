import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * For analysis on variable usage, such as when assigning
 * to a shared variable or reading from one.
 * <p>
 * For each variable usage, it should contain the symbol table
 * information along with the event and whether it was read or write.
 */
public class UsageTable {
    private List<TableEntry> table = new ArrayList<>();
    private String currentEvent;
    private SymbolTable symbolTable;


    /**
     * Builds the table, including the information
     * from the symbol table along.
     * @param symbolTable the symbol table
     */
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

    /**
     * Gets all variables that are read from.
     * @param event which event
     * @return List of variables.
     */
    public List<String> getReadVars(String event) {
        return table.stream()
                .filter(x -> x.event.equals(event) && x.usage == Usage.Read)
                .map(x -> x.entry.name)
                .collect(Collectors.toList());
    }

    /**
     * Gets shared (non local) variables that are read from.
     * @param event which event
     * @return List of variables.
     */
    public List<String> getSharedReadVars(String event) {
        return table.stream()
                .filter(x -> x.event.equals(event) && x.usage == Usage.Read && x.entry.scope != Scope.Local)
                .map(x -> x.entry.name)
                .collect(Collectors.toList());
    }

    /**
     * Gets all variables that are written to.
     * @param event which event
     * @return List of variables.
     */
    public List<String> getWriteVars(String event) {
        return table.stream()
                .filter(x -> x.event.equals(event) && x.usage == Usage.Write)
                .map(x -> x.entry.name)
                .collect(Collectors.toList());
    }

    /**
     * Gets shared (non local) variables that are written to.
     * @param event which event
     * @return List of variables.
     */
    public List<String> getSharedWriteVars(String event) {
        return table.stream()
                .filter(x -> x.event.equals(event) && x.usage == Usage.Write && x.entry.scope != Scope.Local)
                .map(x -> x.entry.name)
                .collect(Collectors.toList());
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

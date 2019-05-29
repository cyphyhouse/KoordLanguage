import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SymbolTable {

    //right now it doesn't do any type checking, just cheks to make sure it was declared
    private Map<String, SymbolTableEntry> vars = new HashMap<>();

    enum Scope {
        Local,
        AllRead,
        AllWrite
    }

    enum Type {
        Int,
        Float,
        Bool
    }
    class SymbolTableEntry {
        public Scope scope;
        public Type type;
        public String name;

        SymbolTableEntry(Scope s, Type t, String n) {
            this.scope = s;
            this.type = t;
            this.name = n;
        }

        @Override
        public String toString() {
            return name + type.toString() + scope.toString();
        }
    }

    private List<String> unresolvedSymbols = new ArrayList<>();

    public SymbolTable(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            private Scope currentScope;

            @Override
            public void enterDecblock(KoordParser.DecblockContext ctx) {
                if (ctx.ALLREAD() != null) {
                    currentScope = Scope.AllRead;
                } else if (ctx.ALLWRITE() != null) {
                    currentScope = Scope.AllWrite;
                } else if (ctx.LOCAL() != null) {
                    currentScope = Scope.Local;
                } else {
                    System.err.println("Unknown scope");
                }
            }
            @Override
            public void enterDecl(KoordParser.DeclContext ctx) {
                Type t = null;

                if (ctx.FLOAT() != null) {
                    t = Type.Float;
                } else if (ctx.INT() != null) {
                    t = Type.Int;
                } else if (ctx.BOOL() != null) {
                    t = Type.Bool;
                } else {
                    System.err.println("Unable to determine type");
                }

                String name = ctx.VARNAME().getText();

                var entry = new SymbolTableEntry(currentScope, t, name);
                vars.put(name, entry);
            }

            @Override
            public void enterBexpr(KoordParser.BexprContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                if (variable != null) {

                    if (vars.get(variable.getText()) == null) {
                        unresolvedSymbols.add(variable.getText());
                    }
                }
            }

            @Override
            public void enterAexpr(KoordParser.AexprContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                if (variable != null) {
                    if (vars.get(variable.getText()) == null) {
                        unresolvedSymbols.add(variable.getText());
                    }
                }
            }

            @Override
            public void enterAssign(KoordParser.AssignContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                if (variable != null) {
                    if (vars.get(variable.getText()) == null) {
                        unresolvedSymbols.add(variable.getText());
                    }
                }
            }
        }, tree);
    }

    public Set<String> getAllVars() {
        return vars.keySet();
    }

    public List<String> getUnresolvedSymbols() {
        return unresolvedSymbols;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SymbolTableEntry entry : vars.values()) {
            sb.append(entry.toString());
        }
        return sb.toString();
    }

    public Map<String, SymbolTableEntry> getTable() {
        return vars;
    }
}

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SymbolTable {

    private Map<String, SymbolTableEntry> vars = new HashMap<>();

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
            return String.format("{name: %s, type: %s, scope: %s}", name, type.toString(), scope.toString());
        }
    }

    private List<String> unresolvedSymbols = new ArrayList<>();

    public List<String> getMultipleDeclaration() {
        return multipleDeclaration;
    }

    public List<String> getSharedRequiresId() {
        return sharedRequiresId;
    }

    public List<String> getLocalWithId() {
        return localWithId;
    }

    private List<String> multipleDeclaration = new ArrayList<>();
    private List<String> sharedRequiresId = new ArrayList<>();
    private List<String> localWithId = new ArrayList<>();

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
                if (vars.get(name) != null) {
                    multipleDeclaration.add(name);
                    return;
                }

                var entry = new SymbolTableEntry(currentScope, t, name);
                vars.put(name, entry);
            }

            @Override
            public void enterBexpr(KoordParser.BexprContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                if (variable != null) {

                    var entry = vars.get(variable.getText());
                    if (entry == null) {
                        unresolvedSymbols.add(variable.getText());
                        return;
                    }
                }
            }

            @Override
            public void enterAexpr(KoordParser.AexprContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                if (variable != null) {
                    var entry = vars.get(variable.getText());
                    if (entry == null) {
                        unresolvedSymbols.add(variable.getText());
                        return;
                    }
                    if (ctx.LBRACE() == null) {
                        if (entry.scope == Scope.AllRead || entry.scope == Scope.AllWrite) {
                            sharedRequiresId.add(entry.name);
                        }
                    } else {
                        if (entry.scope == Scope.Local) {
                            localWithId.add(entry.name);
                        }
                    }
                }
            }

            @Override
            public void enterAssign(KoordParser.AssignContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                if (variable != null) {
                    var entry = vars.get(variable.getText());
                    if (entry == null) {
                        unresolvedSymbols.add(variable.getText());
                        return;
                    }
                    if (ctx.LBRACE() == null) {
                        if (entry.scope == Scope.AllRead || entry.scope == Scope.AllWrite) {
                            sharedRequiresId.add(entry.name);
                        }
                    } else {
                        if (entry.scope == Scope.Local) {
                            localWithId.add(entry.name);
                        }
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

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

/**
 * Contains information such as scope and type for variables, and reports scope/type errors.
 */
public class SymbolTable {

    private Map<String, SymbolTableEntry> vars = new HashMap<>();

    /**
     * Type mismatches, such as assigning a boolean to an int
     * @return list of variables that are bad
     */
    public List<String> getTypeMismatch() {
        return typeMismatch;
    }

    /**
     * Sensors are read only and cannot be assigned to.
     * @return list of variables that are bad
     */
    public List<String> getAssignToSensor() {
        return assignToSensor;
    }

    /**
     * The information associated with each variable.
     */
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

    /**
     * When a variable is declared multiple times
     * @return list of bad vars
     */
    public List<String> getMultipleDeclaration() {
        return multipleDeclaration;
    }

    /**
     * When a shared variable is used as a local variable
     * @return list of bad vars
     */
    public List<String> getSharedRequiresId() {
        return sharedRequiresId;
    }

    /**
     * When a local variable is treated like a shared variable
     * @return list of bad vars
     */
    public List<String> getLocalWithId() {
        return localWithId;
    }

    private List<String> multipleDeclaration = new ArrayList<>();
    private List<String> sharedRequiresId = new ArrayList<>();
    private List<String> localWithId = new ArrayList<>();
    private List<String> typeMismatch = new ArrayList<>();
    private List<String> assignToSensor = new ArrayList<>();

    /**
     * Performs a tree walk on construction
     * @param tree the tree to walk on
     */
    public SymbolTable(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            private Scope currentScope;
            private String moduleName;
            private Deque<Type> types = new LinkedList<>();

            @Override
            public void enterModule(KoordParser.ModuleContext ctx) {
                moduleName = ctx.MODULENAME().getText();
            }

            @Override
            public void exitModule(KoordParser.ModuleContext ctx) {
                moduleName = null;
            }

            @Override
            public void enterActuatordecls(KoordParser.ActuatordeclsContext ctx) {
                currentScope = Scope.Actuator;
            }

            @Override
            public void enterSensordecls(KoordParser.SensordeclsContext ctx) {
                currentScope = Scope.Sensor;
            }
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
                } else if (ctx.POS() != null) {
                    t = Type.Pos;
                } else {
                    System.err.println("Unable to determine type");
                }

                String name = ctx.VARNAME().getText();
                if (moduleName != null) {
                    name = moduleName + "." + name;
                }
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

                    //check for correct usage for shared/local
                    if (ctx.LBRACE() == null) {
                        if (entry.scope == Scope.AllRead || entry.scope == Scope.AllWrite) {
                            sharedRequiresId.add(entry.name);
                        }
                    } else {
                        if (entry.scope == Scope.Local) {
                            localWithId.add(entry.name);
                        }
                    }
                    if (entry.scope == Scope.Sensor) {
                        assignToSensor.add(entry.name);
                    }

                    //check for type
                    var expression = ctx.expr();
                    if (expression.aexpr() != null) {
                        var rhsVar = expression.aexpr().VARNAME();

                        //rhs has to be an arithmetic expression if it is not a variable
                        if (rhsVar == null ) {
                            if (entry.type == Type.Bool) {

                                typeMismatch.add(entry.name);
                            }
                        } else {
                            if (vars.get(rhsVar.getText()).type != entry.type) {
                                typeMismatch.add(entry.name);
                            }
                        }

                    } else if (expression.bexpr() != null) {
                        if (entry.type != Type.Bool) {
                            typeMismatch.add(entry.name);
                        }
                    } else {
                        System.err.println("Error in parsing expressino");
                    }


                }
            }
        }, tree);
    }

    public Set<String> getAllVars() {
        return vars.keySet();
    }

    /**
     * Variables that have not been declared
     * @return bad vars
     */
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

    /**
     * The table that maps var names to symbol info
     * @return the table
     */
    public Map<String, SymbolTableEntry> getTable() {

        return vars;
    }

    /**
     * Checks if there are any errors with type and scope
     * @return whether it is valid
     */
    public boolean isValid() {
        return multipleDeclaration.isEmpty()
                && sharedRequiresId.isEmpty()
                && localWithId.isEmpty()
                && typeMismatch.isEmpty()
                && assignToSensor.isEmpty();
    }
}

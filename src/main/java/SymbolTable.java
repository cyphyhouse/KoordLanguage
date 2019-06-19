import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

/**
 * Contains information such as scope and type for variables, and reports scope/type errors.
 */
public class SymbolTable {

    private Map<String, SymbolTableEntry> vars = new HashMap<>();
    private List<String> unresolvedSymbols = new ArrayList<>();
    private List<String> multipleDeclaration = new ArrayList<>();
    private List<ParserRuleContext> typeMismatch = new ArrayList<>();
    private List<String> assignToSensor = new ArrayList<>();
    private List<String> assignToStream = new ArrayList<>();
    private List<String> assignToReadOnly = new ArrayList<>();

    private ParseTree tree;

    /**
     * @param tree the tree to walk on
     */
    public SymbolTable(ParseTree tree) {
        this.tree = tree;
        this.buildTable(tree);
        if (this.multipleDeclaration.isEmpty()) {
            checkAllDeclared(tree);
            if (this.unresolvedSymbols.isEmpty()) {
                checkTypes(tree);
                checkScope(tree);

            }
        }
    }

    /**
     * Type mismatches, such as assigning a boolean to an int
     *
     * @return list of variables that are bad
     */
    public List<ParserRuleContext> getTypeMismatch() {
        return typeMismatch;
    }

    /**
     * Sensors are read only and cannot be assigned to.
     *
     * @return list of variables that are bad
     */
    public List<String> getAssignToSensor() {
        return assignToSensor;
    }

    /**
     * When a variable is declared multiple times
     *
     * @return list of bad vars
     */
    public List<String> getMultipleDeclaration() {
        return multipleDeclaration;
    }

    /**
     * Builds the symbol table
     */
    private void buildTable(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(new SymbolTableBuilderListener(), tree);
    }

    /**
     * makes sure all variables got declared
     */
    private void checkAllDeclared(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(new KoordBaseListener() {
            @Override
            public void enterBexpr(KoordParser.BexprContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                checkIfDeclared(variable);
            }

            @Override
            public void enterAexpr(KoordParser.AexprContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                checkIfDeclared(variable);
            }

            @Override
            public void enterAssign(KoordParser.AssignContext ctx) {
                TerminalNode variable = ctx.VARNAME();
                checkIfDeclared(variable);
            }
        }, tree);
    }

    private void checkScope(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            @Override
            public void enterAssign(KoordParser.AssignContext ctx) {
                var entry = vars.get(ctx.VARNAME().getText());
                if (entry.scope == Scope.Sensor) {
                    assignToSensor.add(entry.name);
                }
                if (entry.type.equals(Type.Stream)) {
                    assignToStream.add(entry.name);
                }
                if (entry.scope.equals(Scope.AllRead)) {
                    if (ctx.aexpr() == null) {

                        assignToReadOnly.add(entry.name);
                    }
                    var num = ctx.aexpr().number();
                    if (num == null) {
                        assignToReadOnly.add(entry.name);
                    }
                    if (num.PID() == null) {
                        assignToReadOnly.add(entry.name);
                    }
                }
            }
        }, tree);
    }

    private void checkTypes(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TypeCheckerListener(), tree);
    }

    private void checkIfDeclared(TerminalNode variable) {
        if (variable != null) {
            var entry = vars.get(variable.getText());
            if (entry == null) {
                unresolvedSymbols.add(variable.getText());
            }
        }
    }

    public Set<String> getAllVars() {
        return vars.keySet();
    }

    /**
     * Variables that have not been declared
     *
     * @return bad vars
     */
    public List<String> getUnresolvedSymbols() {
        return unresolvedSymbols;
    }

    /**
     * Create a human readable form.
     *
     * @return string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SymbolTableEntry entry : vars.values()) {
            sb.append(entry.toString());
        }
        return sb.toString();
    }

    /**
     * The table that maps var names to symbol info
     *
     * @return the table
     */
    public Map<String, SymbolTableEntry> getTable() {

        return vars;
    }

    /**
     * Checks if there are any errors with type and scope
     *
     * @return whether it is valid
     */
    public boolean isValid() {
        return
                unresolvedSymbols.isEmpty()
                        && multipleDeclaration.isEmpty()
                        && typeMismatch.isEmpty()
                        && assignToSensor.isEmpty()
                        && assignToStream.isEmpty()
                        && assignToReadOnly.isEmpty();
    }

    public List<String> getAssignToStream() {
        return assignToStream;
    }

    public List<String> getAssignToReadOnly() {
        return assignToReadOnly;
    }

    public ParseTree getTree() {
        return tree;
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

    private class SymbolTableBuilderListener extends KoordBaseListener {


        private Scope currentScope;
        private String moduleName;

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
            } else if (ctx.STRINGTYPE() != null) {
                t = Type.String;

            } else if (ctx.STREAM() != null) {
                t = Type.Stream;
            } else {
                System.err.println("Unable to determine type");
            }

            if (ctx.arraydec() != null) {
                t = Type.Array(t);
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

    }

    private class TypeCheckerListener extends KoordBaseListener {
        private Deque<Type> types = new LinkedList<>();

        @Override
        public void exitNumber(KoordParser.NumberContext ctx) {
            if (ctx.FNUM() != null) {
                types.push(Type.Float);
            } else if (ctx.INUM() != null) {
                types.push(Type.Int);
            } else if (ctx.PID() != null) {
                types.push(Type.Int);
            } else {
                System.err.println("Unable to recognize number");
            }
        }

        @Override
        public void exitAexpr(KoordParser.AexprContext ctx) {
            if (ctx.aexpr().size() == 2) {


                var right = types.pop();
                var left = types.pop();
                if (right == null || left == null) {
                    types.push(null);
                    return;
                }
                if (ctx.PLUS() != null) {

                    //string concatenation
                    if (right.equals(Type.String) || left.equals(Type.String)) {
                        types.push(Type.String);
                        return;
                    }
                }
                if (!right.equals(left)) {
                    typeMismatch.add(ctx); //because there is no associated variable
                }
                types.push(left);

            } else if (ctx.VARNAME() != null) {
                var varType = vars.get(ctx.VARNAME().getText());
                if (ctx.LBRACE() != null) {
                    var index = types.pop();
                    if (!index.equals(Type.Int)) {
                        typeMismatch.add(ctx); //because there is no associated variable
                    }

                    if (varType.type.isArray()) {
                        types.push(varType.type.getInnerType());
                    } else {
                        typeMismatch.add(ctx);
                    }
                } else {

                    types.push(varType.type);
                }

            } else if (ctx.funccall() != null) {
                //do nothing for now
                types.push(null);
            } else if (ctx.STRING() != null) {
                types.push(Type.String);
            } else if (ctx.LBRACE() != null) {
            }
            //if the size is 1, then the type should be the exact same
        }

        @Override
        public void exitBexpr(KoordParser.BexprContext ctx) {
            if (ctx.VARNAME() == null) {
                for (var ignored : ctx.aexpr()) {
                    types.poll();
                }
                for (var ignored : ctx.bexpr()) {
                    types.poll();
                }
                types.push(Type.Bool);
            }
        }

        @Override
        public void exitAssign(KoordParser.AssignContext ctx) {
            Type t = vars.get(ctx.VARNAME().getText()).type;
            Type actual = types.poll();
            if (actual == null) {
                return; //null means the type is not yet determined
                //eg a function
            }

            //check if indexing into array
            if (ctx.LBRACE() != null) {
                if (t.isArray()) {
                    //the inner type should be equal to it
                    if (!t.getInnerType().equals(actual)) {
                        typeMismatch.add(ctx);
                    }
                } else {
                    typeMismatch.add(ctx);
                }
            } else {

                if (!t.equals(actual)) {
                    typeMismatch.add(ctx);
                }
            }

        }

        @Override
        public void exitIostream(KoordParser.IostreamContext ctx) {
            if (ctx.VARNAME() != null) {
                var entry = vars.get(ctx.VARNAME().getText());
                if (!entry.type.equals(Type.Stream)) {
                    typeMismatch.add(ctx);
                }
            }
        }

    }
}

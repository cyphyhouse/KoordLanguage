import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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

    /**
     * @param tree the tree to walk on
     */
    public SymbolTable(ParseTree tree) {
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
            public void enterLval(KoordParser.LvalContext ctx) {
                if (ctx.CID() != null) {
                    checkIfDeclared(ctx.getText());
                } else if (ctx.LID() != null && ctx.DOT() == null) {
                    checkIfDeclared(ctx.LID().getText());
                }
            }
        }, tree);
    }

    private void checkScope(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            @Override
            public void enterAssign(KoordParser.AssignContext ctx) {
                var lval = ctx.lval();

                while (lval.lval() != null) {
                    lval = lval.lval();
                }
                SymbolTableEntry entry = null;
                if (lval.CID() != null) {
                    //means that it has to be a module definition
                    var moduleName = lval.CID().getText();
                    //the first one should be the actual name
                    var fieldName = lval.LID();
                    var varName = moduleName + "." + fieldName;
                    entry = vars.get(varName);
                } else if (lval.lval() == null) {
                    entry = vars.get(lval.LID().getText());
                } else {
                    return;
                }


                if (entry == null) {
                    System.err.println("could not find variable");
                }

                if (entry.scope == Scope.Sensor) {
                    assignToSensor.add(entry.name);
                }
                if (entry.type.equals(Type.Stream)) {
                    assignToStream.add(entry.name);
                }
                if (entry.scope.equals(Scope.AllRead)) {
                    //needs to check if it is an
                    if (!(lval.parent instanceof KoordParser.LvalContext)) {

                        assignToReadOnly.add(entry.name);
                        return;
                    }
                    KoordParser.LvalContext parentLval = (KoordParser.LvalContext) lval.parent;
                    if (parentLval.arrayderef() == null) {

                        assignToReadOnly.add(entry.name);
                        return;
                    }
                    var num = parentLval.arrayderef().aexpr().constant();
                    if (num == null) {
                        assignToReadOnly.add(entry.name);
                        return;
                    }
                    if (num.PID() == null) {
                        assignToReadOnly.add(entry.name);
                        return;
                    }
                }
            }
        }, tree);
    }

    private void checkTypes(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TypeCheckerListener(), tree);
    }

    private Type getFieldType(String type, String field) {
        return Type.CustomType(type).getCustomType().getFields().get(field);
    }


    //only check the variable
    //does not check array or dot syntax
    private void checkIfDeclared(String text) {
        var entry = vars.get(text);
        if (entry == null) {
            unresolvedSymbols.add(text);
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
        private Map<String, Type> fields;

        @Override
        public void enterModule(KoordParser.ModuleContext ctx) {
            moduleName = ctx.CID().getText();
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
        public void enterAllreadvars(KoordParser.AllreadvarsContext ctx) {
            currentScope = Scope.AllRead;
        }

        @Override
        public void enterAllwritevars(KoordParser.AllwritevarsContext ctx) {
            currentScope = Scope.AllWrite;
        }

        @Override
        public void enterLocalvars(KoordParser.LocalvarsContext ctx) {
            currentScope = Scope.Local;
        }

        @Override
        public void enterAdtdef(KoordParser.AdtdefContext ctx) {
            fields = new HashMap<>();
        }

        @Override
        public void exitAdtdef(KoordParser.AdtdefContext ctx) {
            Type.createType(fields, ctx.CID().getText());
            fields = null;
        }


        @Override
        public void enterDecl(KoordParser.DeclContext declContext) {
            var ctx = declContext.primitive();
            Type t = null;

            if (ctx != null) {
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
            } else {
                //has to be a custom type then
                var typeName = declContext.CID().getText();
                t = Type.getCustomTypes().get(typeName);

            }

            for (var dec : declContext.arraydec()) {
                t = Type.Array(t);
            }

            String name = declContext.LID().getText();

            if (fields == null) { //we are not in class definition

                if (moduleName != null) {
                    name = moduleName + "." + name;
                }
                if (vars.get(name) != null) {
                    multipleDeclaration.add(name);
                    return;
                }

                var entry = new SymbolTableEntry(currentScope, t, name);
                vars.put(name, entry);
            } else {
                fields.put(name, t);
            }
        }

    }

    private class TypeCheckerListener extends KoordBaseListener {
        private Deque<Type> types = new LinkedList<>();

        @Override
        public void exitConstant(KoordParser.ConstantContext ctx) {
            if (ctx.FNUM() != null) {
                types.push(Type.Float);
            } else if (ctx.INUM() != null) {
                types.push(Type.Int);
            } else if (ctx.PID() != null) {
                types.push(Type.Int);
            } else if (ctx.NUMAGENTS() != null) {
                types.push(Type.Int);
            } else {
                System.err.println("Unable to recognize number");
            }
        }

        @Override
        public void exitLval(KoordParser.LvalContext ctx) {

            if (ctx.DOT() == null && ctx.arrayderef() == null) {
                //meaning it is just a bare variable
                //aka the left most
                var entry = vars.get(ctx.LID().getText());

                types.push(entry.type);
                return;
            }

            if (ctx.CID() != null) {
                //is a module
                var moduleName = ctx.CID().getText();
                var field = ctx.LID().getText();
                var entry = vars.get(moduleName + "." + field);
                types.push(entry.type);
                return;
            }

            if (ctx.LID() != null && ctx.lval() != null) {
                var fieldName = ctx.LID().getText();
                var type = types.pop();
                if (type.getCustomType() == null) {
                    System.err.println("Cannot access field on primitive");
                } else {
                    var fieldType = type.getCustomType().getFields().get(fieldName);
                    if (fieldType == null) {
                        System.err.println("Cannot access field " + fieldName + " for " + type.toString());
                    } else {
                        types.push(fieldType);
                    }

                }
                return;

            }

            if (ctx.arrayderef() != null) {
                //its an array type

                var indexType = types.pop();
                if (!indexType.equals(Type.Int)) {
                    typeMismatch.add(ctx); //because there is no associated variable
                    return;
                }

                var type = types.pop();

                if (type.isArray()) {
                    types.push(type.getInnerType());
                } else {
                    typeMismatch.add(ctx);
                    types.push(null);
                }
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

            } else if (ctx.lval() != null) {

            } else if (ctx.funccall() != null) {
                //do nothing for now
                types.push(null);
            } else if (ctx.STRING() != null) {
                types.push(Type.String);
            }
            //if the size is 1, then the type should be the exact same
        }

        @Override
        public void exitBexpr(KoordParser.BexprContext ctx) {
            if (ctx.relop() != null) {
                if (types.pop() != types.pop()) {
                    typeMismatch.add(ctx);
                } else {
                    types.push(Type.Bool);
                }
            } else if (ctx.aexpr(0) != null) {
                if (types.peek() != null && !types.peek().equals(Type.Bool)) {
                    typeMismatch.add(ctx);
                }
            } else {
                //bool expression always has type bool
                for (var t : ctx.bexpr()) {
                    types.poll();
                }
                types.push(Type.Bool);

            }
        }

        @Override
        public void exitAssign(KoordParser.AssignContext ctx) {
            var exprType = types.pop();
            var lvalType = types.pop();

            if (exprType != null && lvalType != null && !exprType.equals(lvalType)) {
                typeMismatch.add(ctx);
            }

        }

        @Override
        public void exitStmt(KoordParser.StmtContext ctx) {
            types.clear();
        }

        @Override
        public void exitIostream(KoordParser.IostreamContext ctx) {
            if (ctx.expr() != null) {
                types.pop();
            }
            if (!types.peek().equals(Type.Stream)) {
                typeMismatch.add(ctx);
            }
        }

    }
}

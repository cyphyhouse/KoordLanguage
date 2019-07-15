/**
 * Class for code generation from Koord to Python.
 */
public class CodeGen {
    /**
     * The amount of spaces used for indentation in the generated python.
     */
    public static final int INDENT_SPACES = 4;
    private static final String INDENT = " ".repeat(INDENT_SPACES);
    private static final String imports = "from agentThread import AgentThread, Pos\n\n\n";
    private static final String generatedFunctions = "";

    private static final String generateMethods = "";
    private static final String classStart =
            "class %s(AgentThread):\n" +
                    "\n" +
                    INDENT + "def __init__(self, config):\n" +
                    INDENT + INDENT + "super(%s, self).__init__(config)\n" +
                    INDENT + INDENT + "self.start()\n" +
                    "\n" + generateMethods;
    private static final String loopBody = "\n" +
            INDENT + "def loop_body(self):\n";

    private static final String initiation =
            INDENT + "def initialize_vars(self):\n" +
                    INDENT + INDENT + "self.locals = {}\n";

    private StringBuilder builder;
    private int currentIndent;
    private SymbolTable table;


    /**
     * Creates a tree with a default name.
     *
     * @param table
     * @param ctx
     */
    public CodeGen(SymbolTable table, KoordParser.ProgramContext ctx) {
        this(table, ctx, "DefaultName");
    }

    /**
     * Constructor that traverses the tree and generates
     * the code.
     *
     * @param table the symbol table
     * @param ctx   the tree
     */
    public CodeGen(SymbolTable table, KoordParser.ProgramContext ctx, String name) {

        this.table = table;
        builder = new StringBuilder();
        builder.append(imports);
        builder.append(generatedFunctions);
        builder.append(String.format(classStart, name, name));
        currentIndent = INDENT_SPACES * 2;


        builder.append(initiation);
        if (ctx.localvars(0) != null) {
            generateLocals(ctx.localvars(0));
        }
        if (ctx.allwritevars(0) != null) {
            generateAllWrite(ctx.allwritevars(0));
        }
        if (ctx.allreadvars(0) != null) {
            generateAllRead(ctx.allreadvars(0));
        }

        currentIndent = INDENT_SPACES * 1;
        if (ctx.init() != null) {
            generateInitial(ctx.init());
        }

        builder.append(loopBody);
        currentIndent = INDENT_SPACES * 2;

        for (var event : ctx.event()) {
            generateEvent(event);
        }
    }

    private void generateInitial(KoordParser.InitContext ctx) {
        generateStatementBlock(ctx.statementblock());
    }

    private void generateLocals(KoordParser.LocalvarsContext ctx) {
        for (var decls : ctx.decl()) {
            builder.append(indent() + "self.locals['" + decls.VARNAME().getText() + "'] = ");
            if (decls.expr() != null) {
                generateExpression(decls.expr());
            } else {
                builder.append("None");
            }
            builder.append("\n");
        }
    }

    private void generateAllRead(KoordParser.AllreadvarsContext ctx) {

        for (var decls : ctx.decl()) {
            var entry = table.getTable().get(decls.VARNAME().getText());
            builder.append(indent())
                    .append(String.format("self.create_ar_var('%s', %s, ", entry.name, entry.type.python()));
            if (decls.expr() != null) {
                generateExpression(decls.expr());
            } else {
                builder.append("None");
            }
            builder.append(")\n");
        }
    }

    private void generateAllWrite(KoordParser.AllwritevarsContext ctx) {

        for (var decls : ctx.decl()) {
            var entry = table.getTable().get(decls.VARNAME().getText());
            builder.append(indent())
                    .append(String.format("self.create_aw_var('%s', %s, ", entry.name, entry.type.python()));
            if (decls.expr() != null) {
                generateExpression(decls.expr());
            } else {
                builder.append("None");
            }
            builder.append(")\n");
        }
    }

    private String indent() {
        return " ".repeat(currentIndent);
    }

    private void generateStatement(KoordParser.StmtContext ctx) {
        builder.append(indent());
        if (ctx.assign() != null) {
            var str = ctx.assign().VARNAME().getText();

            var entry = table.getTable().get(str);
            if (entry.scope == Scope.Local) {
                builder.append("self.locals['")
                        .append(str)
                        .append("'] = ");
                generateExpression(ctx.assign().expr());
            } else if (entry.scope == Scope.Actuator) {
                builder.append("self.write_to_actuator('")
                        .append(entry.name)
                        .append("', ");
                generateExpression(ctx.assign().expr());
                builder.append(")");
            } else if (entry.scope == Scope.AllRead || entry.scope == Scope.AllWrite) {
                builder.append("self.write_to_shared('")
                        .append(str)
                        .append("', ");
                if (ctx.assign().aexpr() == null) {
                    builder.append("None");
                } else {
                    generateAExpression(ctx.assign().aexpr());
                }
                builder.append(", ");
                generateExpression(ctx.assign().expr());
                builder.append(")");

            }

        } else if (ctx.STOP() != null) {
            builder.append("self.stop()");
        } else if (ctx.conditional() != null) {
            builder.append("if ");
            generateExpression(ctx.conditional().expr());
            builder.append(":\n");
            generateStatementBlock(ctx.conditional().statementblock());
            var elseblock = ctx.conditional().elseblock();
            if (elseblock != null) {
                builder.append(indent())
                        .append("else:\n");
                generateStatementBlock(elseblock.statementblock());
            }
        } else if (ctx.iostream() != null) {
            generateStream(ctx.iostream());
        } else if (ctx.ATOMIC() != null) {
            //add atomic stuff later
            builder.append("if not self.lock():\n" +
                    indent() + " ".repeat(INDENT_SPACES) + "return\n");

            for (var s : ctx.statementblock().stmt()) {
                generateStatement(s);
            }
            builder.append(indent())
                    .append("self.unlock()\n");
            return;
        }
        newline();

    }

    private StringBuilder newline() {
        return builder.append("\n");
    }

    private void generateStream(KoordParser.IostreamContext ctx) {
        if (ctx.iostream() != null) {
            generateStream(ctx.iostream());
            builder.append(indent());
        }
        builder.append("self.log(");
        generateExpression(ctx.expr());
        builder.append(")\n");

    }

    private void generateStatementBlock(KoordParser.StatementblockContext ctx) {

        currentIndent += INDENT_SPACES;
        for (var stmt : ctx.stmt()) {
            generateStatement(stmt);
        }
        currentIndent -= INDENT_SPACES;
    }

    private void generateEvent(KoordParser.EventContext ctx) {
        builder.append(indent());
        builder.append("if ");

        generateExpression(ctx.expr());
        builder.append(":\n");
        currentIndent += INDENT_SPACES;


        for (var statement : ctx.statementblock().stmt()) {
            generateStatement(statement);
        }
        builder.append(indent() + "return\n");
        currentIndent -= INDENT_SPACES;

    }

    private void generateExpression(KoordParser.ExprContext ctx) {
        if (ctx.bexpr() != null) {
            generateBExpression(ctx.bexpr());
        }
        if (ctx.aexpr() != null) {
            generateAExpression(ctx.aexpr());
        }
    }

    private void generateAExpression(KoordParser.AexprContext ctx) {
        if (ctx.VARNAME() != null) {
            var entry = table.getTable().get(ctx.VARNAME().getText());
            if (entry.scope == Scope.Local) {
                builder.append("self.locals['")
                        .append(entry.name)
                        .append("']");
            } else if (entry.scope == Scope.AllWrite || entry.scope == Scope.AllRead) {
                builder.append("self.read_from_shared('")
                        .append(entry.name)
                        .append("', ");
                if (ctx.aexpr(0) == null) {
                    builder.append("None");
                } else {
                    generateAExpression(ctx.aexpr(0));
                }
                builder.append(")");
            } else if (entry.scope == Scope.Sensor) {
                builder.append("self.read_from_sensor('")
                        .append(entry.name)
                        .append("')");

            }
        } else if (ctx.number() != null) {
            if (ctx.number().PID() != null) {
                builder.append("self.pid()");
            } else if (ctx.number().NUMAGENTS() != null) {
                builder.append("self.num_agents()");
            } else {
                builder.append(ctx.number().getText());
            }
        } else if (ctx.funccall() != null) {
            builder.append("self.")
                    .append(ctx.funccall().VARNAME().getText())
                    .append("(");
            var func = ctx.funccall();
            if (func.arglist() != null) {
                var expressions = ctx.funccall().arglist().expr();
                generateExpression(expressions.get(0));
                for (int i = 1; i < expressions.size(); i++) {
                    builder.append(", ");
                    generateExpression(expressions.get(i));
                }
            }

            builder.append(")");
        } else if (ctx.TIMES() != null) {
            generateAExpression(ctx.aexpr(0));
            builder.append(" * ");
            generateAExpression(ctx.aexpr(1));
        } else if (ctx.BY() != null) {
            generateAExpression(ctx.aexpr(0));
            builder.append(" / ");
            generateAExpression(ctx.aexpr(1));
        } else if (ctx.PLUS() != null) {
            generateAExpression(ctx.aexpr(0));
            builder.append(" + ");
            generateAExpression(ctx.aexpr(1));
        } else if (ctx.MINUS() != null) {
            if (ctx.aexpr().size() == 2) {
                generateAExpression(ctx.aexpr(0));
                builder.append(" - ");
                generateAExpression(ctx.aexpr(1));
            } else if (ctx.aexpr().size() == 1) {
                builder.append(" -");
                generateAExpression(ctx.aexpr(0));

            }
        } else if (ctx.STRING() != null) {
            builder.append(ctx.getText());
        } else if (ctx.LPAR() != null) {
            builder.append("(");
            generateAExpression(ctx.aexpr(0));
            builder.append(")");
        }

    }

    private void generateBExpression(KoordParser.BexprContext ctx) {
        if (ctx.relop() != null) {
            generateAExpression(ctx.aexpr(0));
            builder.append(" ")
                    .append(ctx.relop().getText())
                    .append(" ");
            generateAExpression(ctx.aexpr(1));
        } else if (ctx.TRUE() != null) {
            builder.append("True");
        } else if (ctx.FALSE() != null) {
            builder.append("False");
        } else if (ctx.LPAR() != null) {
            builder.append("(");
            generateBExpression(ctx.bexpr(0));
            builder.append(")");
        } else if (ctx.OR() != null) {
            generateBExpression(ctx.bexpr(0));
            builder.append(" or ");
            generateBExpression(ctx.bexpr(1));
        } else if (ctx.AND() != null) {
            generateBExpression(ctx.bexpr(0));
            builder.append(" and ");
            generateBExpression(ctx.bexpr(1));
        } else if (ctx.NOT() != null) {
            builder.append(" not ");
            generateBExpression(ctx.bexpr(0));
        } else if (ctx.VARNAME() != null) {
            var entry = table.getTable().get(ctx.VARNAME().getText());
            if (entry.scope == Scope.Local) {
                builder.append("self.locals['")
                        .append(entry.name)
                        .append("']");
            } else {
                //check for shared vialiton
            }
        }
    }


    /**
     * Creates the generated python program.
     * @return the python program
     */
    @Override
    public String toString() {
        return builder.toString();
    }
}

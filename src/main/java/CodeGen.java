import java.util.Locale;

/**
 * Class for code generation from Koord to Python.
 */
public class CodeGen {
    /**
     * The amount of spaces used for indentation in the generated python.
     */
    public static final int INDENT_SPACES = 4;
    private static final String imports = "from agentThread import AgentThread\n" +
            "from geometry_msgs.msg import Pose\n" +
            "from gvh import Gvh\n" +
            "import time\n\n";
    public static final double TIME_DELTA = 1.0;
    private static final String generatedFunctions = "" +
            "def pos3d(a, b, c):\n" +
            "   pos = Pose()\n" +
            "   pos.position.x, pos.position.y, pos.position.z = a, b, c\n" +
            "   return pos\n\n";
    private static final String generateMethods =
            "    def write_to_shared(self, var_name, index, value):\n" +
                    "       pass\n\n" +
                    "    def read_from_shared(self, var_name, index):\n" +
                    "        pass\n\n" +
                    "    def read_from_sensor(self, var_name):\n" +
                    "       pass\n\n" +
                    "    def write_to_actuator(self, var_name, value):\n" +
                    "        if var_name == \"Motion.target\":\n" +
                    "             self.agent_gvh.moat.goTo(value)\n\n";
    private static final String classStart =
            "class %s(AgentThread):\n" +
                    "\n" +
                    "    def __init__(self, pid: int, num_bots: int):\n" +
                    "        super(%s, self).__init__(Gvh(pid, num_bots))\n" +
                    "        self.start()\n" +
                    "\n" + generateMethods +
                    "    def run(self):\n";
    private static final String mainLoop =
            "        while not self.stopped():\n" +
                    "            time.sleep(%f)\n";

    private StringBuilder builder;
    private int currentIndent;
    private SymbolTable table;


    /**
     * Constructor that traverses the tree and generates
     * the code.
     *
     * @param table the symbol table
     * @param ctx   the tree
     */
    public CodeGen(SymbolTable table, KoordParser.ProgramContext ctx) {
        this(table, ctx, "DefaultName");
    }

    public CodeGen(SymbolTable table, KoordParser.ProgramContext ctx, String name) {

        this.table = table;
        builder = new StringBuilder();
        builder.append(imports);
        builder.append(generatedFunctions);
        builder.append(String.format(classStart, name, name));
        currentIndent = INDENT_SPACES * 2;
        if (ctx.localvars(0) != null) {
            generateLocals(ctx.localvars(0));
        }

        builder.append(String.format((Locale) null, mainLoop, TIME_DELTA));

        if (ctx.init() != null) {
            generateInitial(ctx.init());
        }
        currentIndent = INDENT_SPACES * 3;

        for (var event : ctx.event()) {
            generateEvent(event);
        }
    }

    private void generateInitial(KoordParser.InitContext ctx) {
        generateStatementBlock(ctx.statementblock());
    }

    private void generateLocals(KoordParser.LocalvarsContext ctx) {
        for (var decls : ctx.decl()) {
            builder.append(" ".repeat(currentIndent) + decls.VARNAME().getText() + " = ");
            if (decls.expr() != null) {
                generateExpression(decls.expr());
            } else {
                builder.append("None");
            }
            builder.append("\n");
        }
    }

    private void generateStatement(KoordParser.StmtContext ctx) {
        builder.append(" ".repeat(currentIndent));
        if (ctx.assign() != null) {
            var str = ctx.assign().VARNAME().getText();

            var entry = table.getTable().get(str);
            if (entry.scope == Scope.Local) {
                builder.append(str);
                builder.append(" = ");
                generateExpression(ctx.assign().expr());
            } else if (entry.scope == Scope.Actuator) {
                builder.append("self.write_to_actuator(\"")
                        .append(entry.name)
                        .append("\", ");
                generateExpression(ctx.assign().expr());
                builder.append(")");
            } else if (entry.scope == Scope.AllRead || entry.scope == Scope.AllWrite) {
                builder.append("self.write_to_shared(\"")
                        .append(str)
                        .append("\", ");
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
                generateStatementBlock(elseblock.statementblock());
            }
        }
        builder.append("\n");

    }

    private void generateStatementBlock(KoordParser.StatementblockContext ctx) {

        currentIndent += INDENT_SPACES;
        for (var stmt : ctx.stmt()) {
            generateStatement(stmt);
        }
        currentIndent -= INDENT_SPACES;
    }

    private void generateEvent(KoordParser.EventContext ctx) {
        builder.append(" ".repeat(currentIndent));
        builder.append("if ");
        generateBExpression(ctx.expr().bexpr());
        builder.append(":\n");
        currentIndent += INDENT_SPACES;


        for (var statement : ctx.statementblock().stmt()) {
            generateStatement(statement);
        }
        builder.append(" ".repeat(currentIndent) + "continue\n");
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
                builder.append(entry.name);
            } else if (entry.scope == Scope.AllWrite || entry.scope == Scope.AllRead) {
                builder.append("self.read_from_shared(\"")
                        .append(entry.name)
                        .append("\", ");
                generateAExpression(ctx.aexpr(0));
                builder.append(")");
            } else if (entry.scope == Scope.Sensor) {
                builder.append("self.read_from_sensor(\"")
                        .append(entry.name)
                        .append("\")");

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
            builder.append(ctx.funccall().VARNAME().getText() + "(");
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
            generateAExpression(ctx.aexpr(0));
            builder.append(" - ");
            generateAExpression(ctx.aexpr(1));
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

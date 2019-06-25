import java.util.Map;

public class CodeGen {
    public static final int INDENT_SPACES = 4;
    public static String imports = "from agentThread import AgentThread\n" +
            "from geometry_msgs.msg import Pose\n" +
            "from gvh import Gvh\n" +
            "import time\n\n";
    public static String generatedMethods = "" +
            "def pos3d(a, b, c):\n" +
            "   pos = Pose()\n" +
            "   pos.position.x, pos.position.y, pos.position.z = a, b, c\n" +
            "   return pos\n" +
            "\n";
    public static String classStart =
            "class BasicFollowApp(AgentThread):\n" +
                    "\n" +
                    "    def __init__(self, pid: int, num_bots: int):\n" +
                    "        super(BasicFollowApp, self).__init__(Gvh(pid, num_bots))\n" +
                    "        self.start()\n" +
                    "\n" +
                    "    def run(self):\n";
    public static String mainLoop =
            "        while not self.stopped():\n" +
                    "            time.sleep(1.0)\n";
    private static Map<String, String> actuatorToFunction = Map.of(
            "Motion.target", "self.agent_gvh.moat.goTo"
    );
    private StringBuilder builder;
    private int currentIndent;
    private SymbolTable table;


    public CodeGen(SymbolTable table, KoordParser.ProgramContext ctx) {
        this.table = table;
        builder = new StringBuilder();
        builder.append(imports);
        builder.append(generatedMethods);
        builder.append(classStart);
        currentIndent = INDENT_SPACES * 2;
        generateLocals(ctx.localvars(0));

        builder.append(mainLoop);
        currentIndent = INDENT_SPACES * 3;

        for (var event : ctx.event()) {
            generateEvent(event);
        }
    }

    public void generateLocals(KoordParser.LocalvarsContext ctx) {
        for (var decls : ctx.decl()) {
            builder.append(" ".repeat(currentIndent) + decls.VARNAME().getText() + " = ");
            generateExpression(decls.expr());
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
                builder.append(actuatorToFunction.get(str));
                builder.append("(");
                generateExpression(ctx.assign().expr());
                builder.append(")");
            }

        } else if (ctx.STOP() != null) {
            builder.append("self.stop()");
        }
        builder.append("\n");

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
            builder.append(ctx.VARNAME().getText());
        }

        if (ctx.number() != null) {
            builder.append(ctx.number().getText());
        }
        if (ctx.funccall() != null) {
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
        }

    }

    private void generateBExpression(KoordParser.BexprContext ctx) {
        if (ctx.relop() != null) {
            generateAExpression(ctx.aexpr(0));
            builder.append(" ");
            builder.append(ctx.relop().getText());
            builder.append(" ");
            generateAExpression(ctx.aexpr(1));
        }

    }

    @Override
    public String toString() {
        return builder.toString();
    }
}

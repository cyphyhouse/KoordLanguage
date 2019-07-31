import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for code generation from Koord to Python.
 */
public class CodeGen {
    /**
     * The amount of spaces used for indentation in the generated python.
     */
    public static final int INDENT_SPACES = 4;
    private static final String INDENT = " ".repeat(INDENT_SPACES);
    private static final String imports = "from src.harness.agentThread import AgentThread, Pos\n\n\n";
    private static final String generatedFunctions = "";

    private static final String generateMethods = "";
    private static final String classStart =
            "class %s(AgentThread):\n" +
                    "\n" +
                    INDENT + "def __init__(self, config):\n" +
                    INDENT + INDENT + "super(%s, self).__init__(config, None)\n" +
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
    private String currentEvent;
    private List<String> eventsWithAtomic = new ArrayList<>();

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
        for (var adt : ctx.defs().adtdef()) {
            generateClasses(adt);
        }
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

        findEventsWithAtomic(ctx);

        for (var event : eventsWithAtomic) {
            builder.append(indent())
                    .append("self.initialize_lock('")
                    .append(event)
                    .append("')\n");
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


    /**
     * Creates a tree with a default name.
     *
     * @param table
     * @param ctx
     */
    public CodeGen(SymbolTable table, KoordParser.ProgramContext ctx) {
        this(table, ctx, "DefaultName");
    }

    private void findEventsWithAtomic(KoordParser.ProgramContext ctx) {
        new ParseTreeWalker().walk(new KoordBaseListener() {
            String eventName;

            @Override
            public void enterEvent(KoordParser.EventContext eventCtx) {
                eventName = eventCtx.VARNAME().getText();
            }

            @Override
            public void enterStmt(KoordParser.StmtContext stmtCtx) {
                if (stmtCtx.ATOMIC() != null) {
                    eventsWithAtomic.add(eventName);
                }
            }
        }, ctx);
    }

    private void generateClasses(KoordParser.AdtdefContext adtdef) {
        var name = adtdef.UPPER().getText();

        builder.append("class ")
                .append(name)
                .append(":\n\n")
                .append(INDENT + "def __init__(self):\n");
        currentIndent = INDENT_SPACES * 2;

        for (var dec : adtdef.decl()) {
            builder.append(indent())
                    .append("self.")
                    .append(dec.VARNAME().getText())
                    .append(" = None\n");
        }
        builder.append("\n\n\n");
        currentIndent = 0;

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
            builder.append("if not self.lock('")
                    .append(currentEvent)
                    .append("'):\n")
                    .append(indent())
                    .append(" ".repeat(INDENT_SPACES))
                    .append("return\n");

            for (var s : ctx.statementblock().stmt()) {
                generateStatement(s);
            }
            builder.append(indent())
                    .append("self.unlock('")
                    .append(currentEvent)
                    .append("')\n");
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
        currentEvent = ctx.VARNAME().getText();
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
            generateReadFromVariable(ctx.VARNAME().getText(), ctx.aexpr());
        } else if (ctx.constant() != null) {
            if (ctx.constant().PID() != null) {
                builder.append("self.pid()");
            } else if (ctx.constant().NUMAGENTS() != null) {
                builder.append("self.num_agents()");
            } else {
                builder.append(ctx.constant().getText());
            }
        } else if (ctx.funccall() != null) {
            generateFuncCall(ctx.funccall());
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

    private void generateReadFromVariable(String var, List<KoordParser.AexprContext> indeces) {
        var entry = table.getTable().get(var);
        if (entry.scope == Scope.Local) {
            builder.append("self.locals['")
                    .append(entry.name)
                    .append("']");
        } else if (entry.scope == Scope.AllWrite || entry.scope == Scope.AllRead) {
            builder.append("self.read_from_shared('")
                    .append(entry.name)
                    .append("', ");
            if (indeces.size() == 0) {
                builder.append("None");
            } else {
                generateAExpression(indeces.get(0));
            }

            builder.append(")");
        } else if (entry.scope == Scope.Sensor) {
            builder.append("self.read_from_sensor('")
                    .append(entry.name)
                    .append("')");
        }
        for (int i = 1; i < indeces.size(); i++) {
            builder.append("[");
            generateAExpression(indeces.get(i));
            builder.append("]");
        }
    }

    private void generateFuncCall(KoordParser.FunccallContext ctx) {
        builder.append("self.")
                .append(ctx.VARNAME().getText())
                .append("(");
        if (ctx.arglist() != null) {
            var expressions = ctx.arglist().expr();
            generateExpression(expressions.get(0));
            for (int i = 1; i < expressions.size(); i++) {
                builder.append(", ");
                generateExpression(expressions.get(i));
            }
        }

        builder.append(")");
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
            generateReadFromVariable(ctx.VARNAME().getText(), new ArrayList<>());
        } else if (ctx.funccall() != null) {
            generateFuncCall(ctx.funccall());
        } else if (ctx.aexpr() != null) {
            generateAExpression(ctx.aexpr(0));
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

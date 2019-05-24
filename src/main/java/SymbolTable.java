import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SymbolTable {

    //right now it doesn't do any type checking, just cheks to make sure it was declared
    private Set<String> vars = new HashSet<>();

    private List<String> unresolvedSymbols = new ArrayList<>();

    public SymbolTable(ParseTree tree) {

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KoordBaseListener() {
            @Override
            public void enterDecl(KoordParser.DeclContext ctx) {
                vars.add(ctx.LID().getText());
            }

            @Override
            public void enterBexpr(KoordParser.BexprContext ctx) {
                TerminalNode variable = ctx.LID();
                if (variable != null) {

                    if (!vars.contains(variable.getText())) {
                        unresolvedSymbols.add(variable.getText());
                    }
                }
            }

            @Override
            public void enterAexpr(KoordParser.AexprContext ctx) {
                TerminalNode variable = ctx.LID();
                if (variable != null) {
                    if (!vars.contains(variable.getText())) {
                        unresolvedSymbols.add(variable.getText());
                    }
                }
            }

            @Override
            public void enterAssign(KoordParser.AssignContext ctx) {
                TerminalNode variable = ctx.LID();
                if (variable != null) {
                    if (!vars.contains(variable.getText())) {
                        unresolvedSymbols.add(variable.getText());
                    }
                }
            }
        }, tree);
    }

    public Set<String> getVars() {
        return vars;
    }

    public List<String> getUnresolvedSymbols() {
        return unresolvedSymbols;
    }
}

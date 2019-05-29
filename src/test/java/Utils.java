import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.BitSet;

public class Utils {
    public static KoordParser parserFromFile(String filename) {
        CharStream cs;
        try {
            cs = CharStreams.fromFileName(filename);
        } catch (IOException e) {
            return null;
        }
        KoordLexer lex = new KoordLexer(cs);
        CommonTokenStream tokenStream = new CommonTokenStream(lex);
        KoordParser parser = new KoordParser(tokenStream);
        return parser;
    }

    public static ParseTree treeFromFile(String filename) {
        var parser = parserFromFile(filename);
        return parser.program();
    }

    public static KoordParser parserFromString(String s) {
        CharStream cs = CharStreams.fromString(s);
        KoordLexer lex = new KoordLexer(cs);
        CommonTokenStream tokenStream = new CommonTokenStream(lex);
        KoordParser parser = new KoordParser(tokenStream);
        return parser;
    }
    /**
     *
     * A simple listener that only checks if a syntax error was emitted
     */
    public static class SyntaxChecker implements ANTLRErrorListener {
        public boolean isValid = true;
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
            isValid = false;

        }

        @Override
        public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

        }

        @Override
        public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

        }

        @Override
        public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

        }

        public boolean testFile(String fileName) throws IOException {


            var cs = CharStreams.fromFileName(fileName);
            KoordLexer lex = new KoordLexer(cs);
            CommonTokenStream tokenStream = new CommonTokenStream(lex);
            KoordParser parser = new KoordParser(tokenStream);


            parser.addErrorListener(this);

            parser.program();

            return this.isValid;
        }

        public boolean testExpr(KoordParser p) {
            p.addErrorListener(this);
            p.expr();
            return this.isValid;
        }




    }
}

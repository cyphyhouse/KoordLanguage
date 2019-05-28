import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.BitSet;

public class BadFileTest {
    /**
     *
     * A simple listener that only checks if a syntax error was emitted
     */
    class SyntaxChecker implements ANTLRErrorListener {
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



    }
    @Test
    public void badfile() throws IOException{ //should fail
        SyntaxChecker checker = new SyntaxChecker();
        assert(!checker.testFile("src/test/resources/badfile.koord"));
    }

    @Test
    public void file1() throws IOException{
        SyntaxChecker checker = new SyntaxChecker();
        assert(checker.testFile("src/test/resources/test1.koord"));
    }

    @Test
    public void file2() throws IOException{
        SyntaxChecker checker = new SyntaxChecker();
        assert(checker.testFile("src/test/resources/test2.koord"));
    }

    @Test
    public void file3() throws IOException{
        SyntaxChecker checker = new SyntaxChecker();
        assert(checker.testFile("src/test/resources/test3.koord"));
    }

    @Test
    public void lineform_mod() throws IOException{
        SyntaxChecker checker = new SyntaxChecker();
        assert(checker.testFile("src/test/resources/lineform_mod.koord"));
    }
    @Test
    public void shapeform_mod() throws IOException{
        SyntaxChecker checker = new SyntaxChecker();
        assert(checker.testFile("src/test/resources/shapeform_mod.koord"));
    }
}

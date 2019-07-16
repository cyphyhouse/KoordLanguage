import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParseFileTest {


    @Test
    public void file1() throws IOException {
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testFile("src/test/resources/test1.koord"));
    }

    @Test
    public void file2() throws IOException {
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testFile("src/test/resources/test2.koord"));
    }

    @Test
    public void file3() throws IOException {
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testFile("src/test/resources/test3.koord"));
    }

    @Test
    public void lineform_mod() throws IOException {
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testFile("src/test/resources/lineform.koord"));
    }

    @Test
    public void shapeform_mod() throws IOException {
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testFile("src/test/resources/shapeform.koord"));
    }

    @Test
    public void newlinestart() throws IOException {
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testFile("src/test/resources/newlinestart.koord"));
    }

    @Test
    public void tasks() throws IOException {
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testFile("src/test/resources/tasks.koord"));
    }
}

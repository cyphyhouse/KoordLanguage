import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParseTest {
    @Test
    public void subtraction() {
        KoordParser a = Utils.parserFromString("1 - 1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        checker.testExpr(a);
        assertTrue(checker.isValid);
    }

    @Test
    public void subNoSpace() {
        KoordParser a = Utils.parserFromString("1-1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        checker.testExpr(a);
        assertTrue(checker.isValid);
    }

    @Test
    public void addNegative() {
        KoordParser a = Utils.parserFromString("1 + - 1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testExpr(a));
    }

    @Test
    public void addNegativeNoSpace() {
        KoordParser a = Utils.parserFromString("1 +-1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testExpr(a));
    }

    @Test
    public void stringTest() {
        KoordParser a = Utils.parserFromString(" \" ahelo19   283@\" ");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testExpr(a));
    }

    @Test
    public void stringConcat() {
        KoordParser a = Utils.parserFromString(" \" ahelo19   283@\" + 123 ");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assertTrue(checker.testExpr(a));
    }

}

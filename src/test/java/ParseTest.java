import org.junit.jupiter.api.Test;

public class ParseTest {
    @Test
    public void subtraction() {
        KoordParser a = Utils.parserFromString("1 - 1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        checker.testExpr(a);
        assert(checker.isValid);
    }
    @Test
    public void subNoSpace() {
        KoordParser a = Utils.parserFromString("1-1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        checker.testExpr(a);
        assert(checker.isValid);
    }
    @Test
    public void addNegative() {
        KoordParser a = Utils.parserFromString("1 + - 1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assert(checker.testExpr(a));
    }
    @Test
    public void addNegativeNoSpace() {
        KoordParser a = Utils.parserFromString("1 +-1");
        Utils.SyntaxChecker checker = new Utils.SyntaxChecker();
        assert(checker.testExpr(a));
    }
}

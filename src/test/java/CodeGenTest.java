import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CodeGenTest {
    @Test
    void verifySyntax() {
        var tree = Utils.treeFromFile("src/test/resources/basicFollow.koord");
        var symbol = new SymbolTable(tree);

        var gen = new CodeGen(symbol, tree);
        var outputFile = "output.py";
        try (var writer = new PrintWriter(outputFile)) {

            writer.print(gen.toString());
            var process = Runtime.getRuntime().exec(new String[]{"python3", "-m", "py_compile", outputFile});
            assertEquals(process.waitFor(), 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("bad file");
        } catch (IOException e) {
            e.printStackTrace();
            fail("bad python command");
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }


    }
}

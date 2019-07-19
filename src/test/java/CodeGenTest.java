import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CodeGenTest {
    void verifySyntax(String filename, String outputFile) {
        var tree = Utils.treeFromFile(filename);
        var symbol = new SymbolTable(tree);

        var gen = new CodeGen(symbol, tree);
        try (var writer = new PrintWriter(outputFile)) {

            writer.print(gen.toString());
            writer.flush();
            //verifies syntax
            var process = Runtime.getRuntime().exec(new String[]{"python3", "-m", "py_compile", outputFile});
            process.waitFor();
            assertEquals(process.exitValue(), 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("bad file");
        } catch (IOException e) {
            e.printStackTrace();
            fail("bad python command");
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("interrupted ");
        }
    }

    void mockSharedVariables(String input, String output, String testFile) {

        var tree = Utils.treeFromFile(input);
        var symbol = new SymbolTable(tree);

        var gen = new CodeGen(symbol, tree);
        try (var writer = new PrintWriter(output)) {

            writer.print(gen.toString());
            writer.flush();
            var process = Runtime.getRuntime().exec(new String[]{"python3", testFile});
            process.waitFor();
            assertEquals(process.exitValue(), 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void syntaxBasicFollow() {
        verifySyntax("src/test/resources/basicFollow.koord", "GeneratedPython/basicFollow.py");
    }

    @Test
    void syntaxLineForm() {
        verifySyntax("src/test/resources/lineform.koord", "GeneratedPython/lineform.py");
    }
    @Test
    void syntaxShapeForm() {
        verifySyntax("src/test/resources/shapeform.koord", "GeneratedPython/shapeform.py");
    }

    @Test
    void syntaxLog() {
        verifySyntax("src/test/resources/log.koord", "GeneratedPython/log.py");
    }

    @Test
    void syntaxHvac() {
        verifySyntax("src/test/resources/hvac.koord", "GeneratedPython/hvac.py");
    }
    @Test
    void syntaxAddnums() {
        verifySyntax("src/test/resources/addnums.koord", "GeneratedPython/addnums.py");
    }

    @Test
    void syntaxLeader() {
        verifySyntax("src/test/resources/leader.koord", "GeneratedPython/leader.py");
    }

    @Test
    void syntaxTasks() {
        verifySyntax("src/test/resources/tasks.koord", "GeneratedPython/tasks.py");
    }

    @Test
    void syntaxPos() {
        verifySyntax("src/test/resources/position.koord", "GeneratedPython/position.py");
    }

    @Test
    void mockLineForm() {
        mockSharedVariables("src/test/resources/lineform.koord", "MockGvh/lineform.py", "MockGvh/lineformtest.py");
    }

    @Test
    void mockAddNum() {
        mockSharedVariables("src/test/resources/addnums.koord", "MockGvh/addnums.py", "MockGvh/addnumstest.py");
    }
}

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Need file name");
            return;
        }

        if (args.length > 2) {
            System.out.println("Too many arguments.");
            return;
        }

        var inputFile = args[0];

        var outputFile = "a.out";

        if (args.length == 2) {
            outputFile = args[1];
        }


        CharStream cs = null;
        try {
            cs = CharStreams.fromFileName(inputFile);
        } catch (IOException e) {
            System.out.println("Could not open file.");
            return;
        }
        KoordLexer lex = new KoordLexer(cs);
        CommonTokenStream tokenStream = new CommonTokenStream(lex);
        KoordParser parser = new KoordParser(tokenStream);

        var tree = parser.program();

        var symbolTable = new SymbolTable(tree);

        if (symbolTable.isValid()) {
            var name = inputFile.split("\\.")[0];
            var path = name.split("/");
            name = path[path.length - 1];
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            var codegen = new CodeGen(symbolTable, tree, name);

            try (var writer = new PrintWriter(outputFile)) {

                writer.print(codegen.toString());
                writer.flush();
            } catch (FileNotFoundException e) {
                System.out.println("Cannot write to output file.");
            }

            System.out.printf("Successfully compiled %s to %s\n", inputFile, outputFile);
            return;
        }

        System.out.println("Errors in file:\n");
        for (var dec : symbolTable.getMultipleDeclaration()) {
            System.out.println(dec + " was declared multiple times.\n");
        }
        for (var dec : symbolTable.getUnresolvedSymbols()) {
            System.out.printf("Could not identify %s.\n", dec);
        }
        for (var dec : symbolTable.getAssignToStream()) {
            System.out.printf("Cannot assign %s to stream\n", dec);
        }
        for (var dec : symbolTable.getAssignToReadOnly()) {
            System.out.printf("Cannot assign to %s as it is read only.\n", dec);
        }
        for (var dec : symbolTable.getAssignToSensor()) {
            System.out.printf("Cannot assign to sensor %s\n", dec);
        }
        for (var dec : symbolTable.getTypeMismatch()) {
            System.out.printf("Type error near %s\n", dec.getText());
        }
    }
}

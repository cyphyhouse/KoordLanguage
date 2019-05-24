import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

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
}

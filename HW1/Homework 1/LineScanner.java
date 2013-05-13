
import java.io.*;
import java.util.*;

public class LineScanner {

    private int linenumber;
    private WordScanner wScanner;

    public LineScanner(String filename) throws IOException {
        Scanner linescanner = new Scanner(new FileInputStream(filename));
        linenumber = 1;
        while (linescanner.hasNextLine()) {
            String line = linescanner.nextLine();
            Scanner wordscanner = new Scanner(line);
            wScanner = new WordScanner(wordscanner, linenumber);
            linenumber++;
        }
        linescanner.close();
    }

    public CrossRefPrinter getPrinter() {
        return new CrossRefPrinter(WordScanner.getMap());
    }
}

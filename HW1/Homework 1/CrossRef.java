
import java.io.*;

public class CrossRef {

    private static CrossRefPrinter printer;

    public static void main(String[] args) throws IOException {
        LineScanner linescan = new LineScanner(args[0]);
        printer = linescan.getPrinter();
        printer.print();
    }
}

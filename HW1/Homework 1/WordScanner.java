
import java.util.*;

public class WordScanner {

    private static Map<String, Set<Integer>> wordmap = new TreeMap<String, Set<Integer>>();
    private int linenumber;
    private Scanner wordscanner;

    public WordScanner(Scanner wordscanner, int linenumber) {
        this.linenumber = linenumber;
        this.wordscanner = wordscanner;
        wordscanner.useDelimiter("\\W+");

        while (wordscanner.hasNext()) {
            String word = wordscanner.next();
            Set<Integer> lines = wordmap.get(word);
            if (lines == null) {
                lines = new TreeSet<Integer>();
            }
            lines.add(new Integer(linenumber));
            wordmap.put(word, lines);
        }
        linenumber++;
    }

    public static Map<String, Set<Integer>> getMap() {
        return wordmap;
    }
}


import java.util.*;

public class CrossRefPrinter {

    private Map<String, Set<Integer>> wordmap;

    public CrossRefPrinter(Map<String, Set<Integer>> wordmap) {
        this.wordmap = wordmap;
    }

    public void print() {
        for (String word : wordmap.keySet()) {
            System.out.print(word + ": ");
            Set<Integer> lines = wordmap.get(word);
            for (Integer linenum : lines) {
                System.out.print(linenum + " ");
            }
            System.out.println();
        }
    }
}

import java.io.*;
import java.util.*;

public class CrossRef {
   private static Map<String,Set<Integer>> wordmap = new TreeMap<String,Set<Integer>>();
   
   public static void main(String[] args) throws IOException {
      int linenumber = 1;
      Scanner linescanner = new Scanner(new FileInputStream(args[0]));
      
      // process each line
      while (linescanner.hasNextLine()) {
         String line = linescanner.nextLine();
         Scanner wordscanner = new Scanner(line);
         wordscanner.useDelimiter("\\W+");
         
         // process each word in the line
         while (wordscanner.hasNext()) {
            String word = wordscanner.next();
            Set<Integer> lines = wordmap.get(word);
            if (lines == null)
               lines = new TreeSet<Integer>();
            lines.add(new Integer(linenumber));
            wordmap.put(word, lines);
         }
         
         linenumber++;
      }
      linescanner.close();
      
      // then print output
      for (String word : wordmap.keySet()) {
         System.out.print(word + ": ");
         Set<Integer> lines = wordmap.get(word);
         for (Integer linenum : lines)
            System.out.print(linenum + " ");
         System.out.println();
      }
   }
}


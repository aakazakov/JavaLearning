package homework.hw2;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class FileParser {
  
  private static final String REGEXP = "\\d+\\s+\\w+\\s+\\d+";
  
  public static List<String> getDataStringsFromFile(String path) {
    List<String> dataStrings = new ArrayList<>();
    try {
      File file = new File(path);
      Scanner sc = new Scanner(file, "utf8");
      while (sc.hasNextLine()) {
        sc.nextLine();
        String str = sc.findInLine(REGEXP);
        if (str == null) continue;
        dataStrings.add(str);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return dataStrings;
  }

}

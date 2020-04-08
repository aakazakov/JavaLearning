package homework.hw2;

import java.io.*;
import java.util.*;

public class FileParser {
  
  public static List<String> getDataStringsFromFile(String path) {
    List<String> dataStrings = new ArrayList<>();
    try {
      File file = new File(path);
      Scanner sc = new Scanner(file, "utf8");
      while (sc.hasNextLine()) {
        sc.nextLine();
        String str = sc.findInLine("\\d+\\s+\\w+\\s+\\d+");
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

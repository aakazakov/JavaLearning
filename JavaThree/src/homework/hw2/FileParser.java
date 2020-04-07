package homework.hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
  
  public static void scanFile(String path) {
    try {
      File file = new File(path);
      Scanner sc = new Scanner(file, "utf8");
      while (sc.hasNextLine()) {
        String str = sc.nextLine();
        System.out.println(str);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}

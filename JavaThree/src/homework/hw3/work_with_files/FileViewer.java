package homework.hw3.work_with_files;

import java.io.*;

public class FileViewer {
  
  public static void readAndShowInConsole(String file) {
    try (FileInputStream in = new FileInputStream(file)) {
      byte[] arr = new byte[256];
      int x;
      while((x = in.read(arr)) > 0) {
        System.out.println(new String(arr, 0, x));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

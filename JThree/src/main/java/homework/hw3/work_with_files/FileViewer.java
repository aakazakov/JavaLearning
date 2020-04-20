package homework.hw3.work_with_files;

import java.io.*;
import java.util.*;

public class FileViewer {
  
  public static void readStreamAndShowInConsole(String file) {
    try (FileInputStream in = new FileInputStream(file)) {
      byte[] arr = new byte[64];
      int x;
      while((x = in.read(arr)) > 0) {
        System.out.println(new String(arr, 0, x));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void writeStreamInOneFile(String out, String...in) {
    try (SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(getInputStreamList(in)));
        FileOutputStream fos = new FileOutputStream(out)) {
      byte[] arr = new byte[1024];
      int x;
      while ((x = sis.read(arr)) > 0) {
        fos.write(arr, 0, x);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private static List<InputStream> getInputStreamList(String...files) {
    List<InputStream> list = new ArrayList<>();
    for (int i = 0; i < files.length; i++) {
      try {
        list.add(new FileInputStream(files[i]));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return list;
  }
  
  
  // Read large file in chunks
  public static void readLargeFileInConsole(File file) {
    
    long start1 = System.currentTimeMillis(); // test
    
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      char[] chars = new char[1802];
      int x;
      while((x = br.read(chars)) != -1) {
        
        long start2 = System.currentTimeMillis(); // test
        
        System.out.println(new String(chars, 0, x));
        
        System.out.printf("PAGE OUTPUT: %d s%n", (System.currentTimeMillis() - start2) / 1000); // 0s
        
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    System.out.printf("PROGRAM ENDED: %d s%n", (System.currentTimeMillis() - start1) / 1000); // 3s
  }
  
}

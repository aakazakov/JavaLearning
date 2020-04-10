package homework.hw3;

import java.io.*;

import homework.hw3.work_with_files.FileViewer;

public class Homework {
  
  public static final String DIR = "src/homework/hw3/files/";
  
  public static void main(String[] args) {
     
//    // #1
//    FileViewer.readStreamAndShowInConsole(DIR + "file0.txt");
//
//    // #2
//    FileViewer.writeStreamInOneFile(DIR + "out.txt",
//      DIR + "in0.txt",
//      DIR + "in1.txt",
//      DIR + "in2.txt",
//      DIR + "in3.txt",
//      DIR + "in4.txt");

//    // #3
//    // System.out.println(createVeryLargeFIle()); // 647650
//    
//    FileViewer.readLargeFileInConsole(DIR + "bigIn.txt");
  }
  
  // Создает файл размером около 11 Мб.
  public static int createVeryLargeFIle() {
    File file = new File(DIR + "bigIn.txt");
    int stringsCounter = 0;
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      if (!file.exists()) file.createNewFile();
      while (file.length() < 11e+6) {
        bw.write("FromJavaWithLove\n");
        stringsCounter++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return stringsCounter;
  }
  
}

package homework.hw3;

import java.io.File;

import homework.hw3.work_with_files.FileViewer;

public class Homework {
  
  public static final String DIR = "src/homework/hw3/files/";
  
  public static void main(String[] args) {
     
//     File file = new File(DIR + "in4.txt");
//     System.out.println(file.length());
    
//    FileViewer.readStreamAndShowInConsole(DIR + "file0.txt");
    
    FileViewer.writeStreamInOneFile(DIR + "out.txt",
        DIR + "in0.txt",
        DIR + "in1.txt",
        DIR + "in2.txt",
        DIR + "in3.txt",
        DIR + "in4.txt");
    
  }
  
}

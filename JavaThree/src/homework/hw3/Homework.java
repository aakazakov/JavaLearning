package homework.hw3;

import java.io.File;

import homework.hw3.work_with_files.FileViewer;

public class Homework {
  
  public static final String DIR = "src/homework/hw3/files/";
  
  public static void main(String[] args) {
     
//     File file = new File(DIR + "file0.txt");
//     System.out.println(file.length());
    
    FileViewer.readStreamAndShowInConsole(DIR + "file0.txt");
    
  }
  
}

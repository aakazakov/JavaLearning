package homework.hw3;

import java.io.File;

public class Homework {
  
  public static final String DIR = "src/homework/hw3/files/";
  
  public static void main(String[] args) {
     
     File file = new File(DIR + "file1.txt");
     
     System.out.println(file.length());
   }
   
}

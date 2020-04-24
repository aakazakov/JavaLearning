package homework.hw6;

import homework.hw6.testing.Tester;

public class Homework {

  public static void main(String[] args) {
    
    try {
      Tester.start("homework.hw6.TestableClass");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
      
  }

}

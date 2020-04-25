package homework.hw6;

public class Homework {

  public static void main(String[] args) {
    
    try {
      SimpleTestInvoke.start("homework.hw6.Robot");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }  
    
  }

}

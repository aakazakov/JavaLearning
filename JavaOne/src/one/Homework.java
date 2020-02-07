package one;

public class Homework {

  /**
   * Run exercises.
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    Homework.printVaraibles();
  }
  
  /** #1. */
  public static void printVaraibles() {
    byte myByte = 2;
    short myshort = 15;
    int myInt = 100;
    long myLong = 101010L;
    float myFloat = 12.6f;
    double myDouble = 12.6547898;
    char myChar = 'c';
    String myString = "hi";   
    System.out.println(
        "myByte = " + myByte
        + "\nmyshort = " + myshort
        + "\nmyInt = " + myInt
        + "\nmyLong = " + myLong
        + "\nmyFloat = " + myFloat
        + "\nmyDouble = " + myDouble
        + "\nmyChar = " + myChar
        + "\nmyString = " + myString
    );
  }
}

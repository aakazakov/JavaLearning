package one;

public class Homework {

  /**
   * Run exercises.
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    Homework.printVaraibles(); // #2.
    System.out.println("\n" + Homework.compute(5f, 10.125f, 4.1f, 9.1f)); // #3.
    System.out.println("\n" + Homework.isSumInRange(5, 7)); // #4.
    Homework.isPositiveOrNegativeNumber(0); // #5.
    System.out.println("\n" + Homework.isNegativeNumber(-2)); // #6.
    Homework.greeting("Everybody"); // #7.
    Homework.isLeapYear(2100); // #8.
  }
  
  /**
   *  #2.
   *  
   *  <p>Prints variables name & value.
   */
  public static void printVaraibles() {
    byte myByte = 2;
    short myshort = 15;
    int myInt = 100;
    long myLong = 101010L;
    float myFloat = 12.6f;
    double myDouble = 12.6547898;
    char myChar = 'c';
    boolean myBoolean = true;
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
        + "\nmyBoolean = " + myBoolean
    );
  }
  
  /**
   * #3. 
   * 
   * <p>Computes the result of a math expression.
   * 
   * @param a number
   * @param b number
   * @param c number
   * @param d number
   * @return computed result
   */
  public static float compute(float a, float b, float c, float d) {
    return a * (b + (c / d));
  }
  
  /**
   * #4.
   * 
   * <p>Checks if the sum of numbers is in a certain range.
   * 
   * @param a number
   * @param b number
   * @return true if the sum is in the range, otherwise false
   */
  public static boolean isSumInRange(int a, int b) {
    int sum = a + b;
    return sum >= 10 && sum <= 20;
  }
  
  /**
   * #5. 
   * 
   * <p>Prints if the argument is a positive or negative number.
   * 
   * @param a number
   */
  public static void isPositiveOrNegativeNumber(int a) {
    if (a >= 0) {
      System.out.println("\nPositive number.");
    } else {
      System.out.println("\nNegative number.");
    }
  }
  
  /**
   * #6.
   * 
   * <p>Checks if argument less then zero.
   * 
   * @param a number
   * @return true if the argument is a negative number, otherwise false
   */
  public static boolean isNegativeNumber(int a) {
    return a < 0;
  }
  
  /**
   * #7.
   * 
   * <p>Prints greeting ).
   * 
   * @param name name
   */
  public static void greeting(String name) {
    System.out.println("\nHello, " + name + "!");
  }
  
  /**
   * #8.
   * 
   * <p>Checks if the year is a leap year and prints result.
   * 
   * @param year year
   */
  public static void isLeapYear(int year) {
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
      System.out.println("\nIt's a leap year.");
    } else {
      System.out.println("\nIt's not a leap year.");
    }
  }
}

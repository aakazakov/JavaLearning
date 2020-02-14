package three;

import java.util.Random;
import java.util.Scanner;

public class Homework {
  private static Random rand = new Random();
  private static Scanner scanner = new Scanner(System.in);

  /**
   * Run exercises.
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    guessTheNumber();
  }
  
  /**
   * #1.
   * 
   * <p>Guess the number game.
   */
  public static void guessTheNumber() {
    int number = getRandomNumber(9);
    System.out.println(number); // test
    System.out.print("input number: ");
    int userNumber = getUserInputValue();
    System.out.println(userNumber); // test
  }
  
  /**
   * Random integer generator.
   * 
   * @param edge max edge
   * @return random number
   */
  public static int getRandomNumber(int edge) {
    return rand.nextInt(edge + 1);
  }
  
  /**
   * Scans user input.
   * 
   * @return user input value
   */
  public static int getUserInputValue() {
    int number = scanner.nextInt();
    scanner.close();
    return number;
  }
}

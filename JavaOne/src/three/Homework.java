package three;

import java.util.Random;

public class Homework {
  private static Random rand = new Random(); 

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
}

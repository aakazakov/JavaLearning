package practice3;

import java.util.Random;
import java.util.Scanner;

public class Homework {
  private static Random rand = new Random();
  private static Scanner scanner = new Scanner(System.in);
  private static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
      "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
      "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
      "pineapple", "pumpkin", "potato"};

  /**
   * Run exercises.
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    
    // #1.
    // guessTheNumber();
    
    // #2.
    // guessTheWord();
  }
  
  /**
   * #1.
   * 
   * <p>Guess the number game.
   */
  public static void guessTheNumber() {
    String repeat = "1";
    while (repeat.equals("1")) {
      int number = getRandomNumber(9);
      int attempts = 3;
      System.out.println(number); // test
      System.out.println("The game started.");
      while (attempts > 0) {
        System.out.printf("%nAttempts: %d%nEnter your number: ", attempts);
        if (scanner.hasNextInt()) {
          int userNumber = scanner.nextInt();
          if (userNumber > number) {
            System.out.println("Try less.");
            attempts--;
          } else if (userNumber < number) {
            System.out.println("Try greater.");
            attempts--;
          } else {
            System.out.println("You guessed it!");
            break;
          }
        } else {
          String value = scanner.nextLine();
          System.out.printf("The value '%s' you entered is not a number.%n", value);
        }
      }     
      System.out.println("\nGame over."
          + "\nWant to play again?"
          + "\nEnter 1, otherwise 0\n");
      repeat = scanner.next();
    }
    scanner.close();
    System.out.println("Good bye!");
  }
  
  /**
   * #2.
   * 
   * <p>Guess the word game.
   */
  public static void guessTheWord() {
    String word = getWord();
    System.out.println(word); // test
    System.out.println("The game started.");
    while (true) {     
      System.out.print("\nEnter your word: ");
      String userWord = scanner.nextLine(); 
      if (userWord.equals(word)) {
        System.out.println("You guessed it!");
        break;
      }
      if (userWord.length() >= word.length()) {
        System.out.println(getComparisonResult(word, userWord));
      } else {
        System.out.println(getComparisonResult(userWord, word));
      }
    }
    scanner.close();
    System.out.println("\nGame over.");
  }
  
  /**
   * Returns a formatted StringBuilder string.
   * 
   * @param strOne word whose length is less than or equal to the second
   * @param strTwo word
   * @return something like '###a#b#####')
   */
  private static StringBuilder getComparisonResult(String strOne, String strTwo) {
    StringBuilder sharps = new StringBuilder(15);
    for (int i = 0; i < sharps.capacity(); i++) {
      if (i < strOne.length() && strOne.charAt(i) == strTwo.charAt(i)) {
        sharps.append(strOne.charAt(i));
        continue;
      }
      sharps.append('#');
    }
    return sharps;
  }
  
  /**
   * Random integer generator.
   * 
   * @param edge max edge
   * @return random number
   */
  private static int getRandomNumber(int edge) {
    return rand.nextInt(edge + 1);
  }
 
  /**
   * Random word getter.
   * 
   * @return word
   */
  private static String getWord() {
    int i = getRandomNumber(words.length);
    return words[i];
  }
}

package four;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework {
  private static final int SIZE = 5;
  private static final char[][] MAP = new char[SIZE][SIZE];
  private static final char CHAR_SHARP = '#';
  private static final char CHAR_X = 'X';
  private static final char CHAR_O = 'O';
  private static final char WIN_CHARS = 4;
  private static boolean winner;
  private static Scanner sc = new Scanner(System.in);
  private static Random rand = new Random();

  /**
   * The main method.)
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    ticTacToe();
  }
  
  /**
   * TicTacToe game.
   */
  public static void ticTacToe() {
    System.out.println("Game started!");   
    int stepCount = SIZE * SIZE;
    initMap();
    printMap();    
    while (true) {
      if (stepCount > 0) {
        humanStep();
        printMap();
        if (winner) {
          System.out.println("\nHUMAN WON!");
          break;
        }
        stepCount--;
      }
      if (stepCount > 0) {
        aiStep();
        printMap();
        if (winner) {
          System.out.println("\nAI WON!");
          break;
        }
        stepCount--;
      }
      if (stepCount == 0) {
        System.out.println("\nDead heat. )");
        break;
      }
    } 
    System.out.println("\nGame over.");
  }
  
  /**
   * Fills a map with chars.
   */
  private static void initMap() {
    for (int i = 0; i < SIZE; i++) {
      Arrays.fill(MAP[i], CHAR_SHARP);
    }
  }
  
  /**
   * Prints a map.
   */
  private static void printMap() {
    for (int i = 0; i <= SIZE; i++) {
      if (i == 0) {
        System.out.print("  ");
        continue;
      }
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i = 0; i < SIZE; i++) {
      System.out.print(i + 1 + " ");
      for (int j = 0; j < SIZE; j++) {
        System.out.print(MAP[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  /**
   * Human takes a step.
   */
  private static void humanStep() {
    while (true) {
//      System.out.print("Enter the coordinates 'X' (x y): ");
//      int x = sc.nextInt();
//      int y = sc.nextInt();
      
       int x = rand.nextInt(SIZE) + 1; // test
       int y = rand.nextInt(SIZE) + 1; // test
      
      if (isValidStep(x, y)) {
        step(x, y, CHAR_X);
        winner = isWin(x, y, CHAR_X);
        break;
      }
    }
  }
  
  /**
   * AI takes a step.
   */
  private static void aiStep() {
    while (true) {
      int x = rand.nextInt(SIZE) + 1;
      int y = rand.nextInt(SIZE) + 1;
      if (isValidStep(x, y)) {
        step(x, y, CHAR_O);
        winner = isWin(x, y, CHAR_O);
        break;
      }
    }
  }
  
  /**
   * Checks if a step is valid.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @return true if a step can be taken., otherwise false
   */
  private static boolean isValidStep(int x, int y) {
    return x > 0 && x <= SIZE && y > 0 && y <= SIZE
        && MAP[y - 1][x - 1] == CHAR_SHARP;
  }
  
  /**
   * Puts the character in a specific place.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   */
  private static void step(int x, int y, char ch) {
    MAP[y - 1][x - 1] = ch;
  }
  
  /**
   * Checks player for victory.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   * @return true if the player won, otherwise false
   */
  private static boolean isWin(int x, int y, char ch) {
    return vertically(x, y, ch) || horizontally(x, y, ch)
        || diagonallyOne(x, y, ch) || diagonallyTwo(x, y, ch);
  }
  
  /**
   * Checks if player won horizontally.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   * @return true if the player won, otherwise false
   */
  private static boolean horizontally(int x, int y, char ch) {
    int charCount = 0;
    for (int i = x - 1; i < SIZE; i++) {
      if (MAP[y - 1][i] != ch) {
        break;
      }
      charCount++;
    }
    for (int i = x - 2; i >= 0; i--) {
      if (MAP[y - 1][i] != ch) {
        break;
      }
      charCount++;
    }
    return charCount >= WIN_CHARS;
  }
  
  /**
   * Checks if player won vertically.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   * @return true if the player won, otherwise false
   */
  private static boolean vertically(int x, int y, char ch) {
    int charCount = 0;
    for (int i = y - 1; i < SIZE; i++) {
      if (MAP[i][x - 1] != ch) {
        break;
      }
      charCount++;
    }
    for (int i = y - 2; i >= 0; i--) {
      if (MAP[i][x - 1] != ch) {
        break;
      }
      charCount++;
    }
    return charCount >= WIN_CHARS;
  }
  
  /**
   * Checks if player won diagonally (from up-left to down-right).
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   * @return true if the player won, otherwise false
   */
  private static boolean diagonallyOne(int x, int y, char ch) {
    if (x != y) {
      return false;
    }  
    int charCount = 0;
    for (int i = y - 1; i < SIZE; i++) {
      if (MAP[i][i] != ch) {
        break;
      }
      charCount++;
    }
    for (int i = y - 2; i >= 0; i--) {
      if (MAP[i][i] != ch) {
        break;
      }
      charCount++;
    }
    return charCount >= WIN_CHARS;
  }
  
  /**
   * Checks if player won diagonally (from up-right to down-left).
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   * @return true if the player won, otherwise false
   */
  private static boolean diagonallyTwo(int x, int y, char ch) {
    if (y != SIZE - x + 1) {
      return false;
    }
    int charCount = 0;
    for (int i = y - 1; i < SIZE; i++) {
      if (MAP[i][SIZE - i - 1] != ch) {
        break;
      }
      charCount++;
    }
    for (int i = y - 2; i >= 0; i--) {
      if (MAP[i][SIZE - i - 1] != ch) {
        break;
      }
      charCount++;
    }
    return charCount >= WIN_CHARS;
  }
}

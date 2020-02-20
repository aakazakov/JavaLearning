package four;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework {
  private static final int SIZE = 3;
  private static final char[][] MAP = new char[SIZE][SIZE];
  private static final char CHAR_SHARP = '#';
  private static final char CHAR_X = 'X';
  private static final char CHAR_O = 'O';
  private static final char WIN_CHARS = 3;
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
    fillMap();
    printMap();
    
    for (int i = 0; i < 4; i++) {
      System.out.println("\nstep " + i);
      
      humanStep();
      printMap();
  
      aiStep();
      printMap();
    }
  }
  
  /**
   * Fills a map with chars.
   */
  private static void fillMap() {
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
      // System.out.print("Enter the coordinates 'X' (x y): ");
      // int x = sc.nextInt();
      // int y = sc.nextInt();
      
      int x = rand.nextInt(SIZE) + 1; // test
      int y = rand.nextInt(SIZE) + 1; // test
      
      if (canStep(x, y)) {
        putChar(x, y, CHAR_X);
        isWin(x, y, CHAR_X);
        break;
      }
    }
    // sc.close();
  }
  
  /**
   * AI takes a step.
   */
  private static void aiStep() {
    while (true) {
      int x = rand.nextInt(SIZE) + 1;
      int y = rand.nextInt(SIZE) + 1;
      if (canStep(x, y)) {
        putChar(x, y, CHAR_O);
        break;
      }
    }
  }
  
  /**
   * Checks if a step can be taken.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @return true if a step can be taken., otherwise false
   */
  private static boolean canStep(int x, int y) {
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
  private static void putChar(int x, int y, char ch) {
    MAP[y - 1][x - 1] = ch;
  }
  
  private static void isWin(int x, int y, char ch) {
    // horizontally(x, y, ch);
    // vertically(x, y, ch);
    diagonallyOne(x, y, ch);
  }
  
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
    
    System.out.println("count_x: " + charCount); // test
    
    return charCount == WIN_CHARS;
  }
  
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
    
    System.out.println("count_y: " + charCount); // test
    
    return charCount == WIN_CHARS;
  }
  
  private static boolean diagonallyOne(int x, int y, char ch) {
    
    System.out.println("x: " + x + " y: " + y); // test
    
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
      
    System.out.println("count_d1: " + charCount); // test
    
    return charCount == WIN_CHARS;
  }
  
  private static void diagonallyTwo(int x, int y, char ch) {
    int charCount = 0;
  }
}

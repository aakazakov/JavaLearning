package four;

import java.util.Arrays;
import java.util.Scanner;

public class Homework {
  private static final int SIZE = 3;
  private static final char[][] MAP = new char[SIZE][SIZE];
  private static final char CHAR_SHARP = '#';
  private static final char CHAR_X = 'X';
  private static final char CHAR_O = 'O';
  private static Scanner sc = new Scanner(System.in);

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
    
    humanStep();
    printMap();

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
   * Human step.
   */
  private static void humanStep() {
    while (true) {
      System.out.print("Enter the coordinates 'X' (x y): ");
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (isValidStep(x, y)) {
        putChar(x, y, CHAR_X);
        break;
      }
    }
    sc.close();
  }
  
  /**
   * Checks if a step can be taken.
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
  private static void putChar(int x, int y, char ch) {
    MAP[y - 1][x - 1] = ch;
  }
}

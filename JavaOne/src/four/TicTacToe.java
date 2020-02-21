package four;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
  private static final int SIZE = 5;
  private static final char[][] MAP = new char[SIZE][SIZE];
  private static final char CHAR_EMPTY = '#';
  private static final char CHAR_X = 'X';
  private static final char CHAR_O = 'O';
  private static final char QUANTITY_TO_WIN = 4;
  private static Scanner sc = new Scanner(System.in);
  private static Random rand = new Random();

  public static void main(String[] args) {
    launch();
  }
  
  /**
   * Launches the game TicTacToe.
   */
  public static void launch() {
    fillMap();
    printMap();
    
    while (true) {
//      humanTurn();
      computerTurn(); // test
      printMap();
      if (isWin(CHAR_X)) {
        System.out.println("\nHuman win.");
      }
      if (!isTherePlaceForStep()) {
        System.out.println("\nDead heat...");
        break;
      }
      
      computerTurn();
      printMap();
      if (isWin(CHAR_O)) {
        System.out.println("\nComputer win.");
      }
      if (!isTherePlaceForStep()) {
        System.out.println("\nDead heat...");
        break;
      }
    }
    
    System.out.println("launch");
  }
  
  /**
   * Fills a map with chars.
   */
  private static void fillMap() {
    for (int i = 0; i < SIZE; i++) {
      Arrays.fill(MAP[i], CHAR_EMPTY);
    }
  }
  
  /**
   * Prints a map.
   */
  private static void printMap() {
    System.out.print("  ");
    for (int i = 1; i <= SIZE; i++) {
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
  private static void humanTurn() {
    int x;
    int y;
    do {
      System.out.print("Enter the coordinates 'X' (x y): ");
      x = sc.nextInt() - 1;
      y = sc.nextInt() - 1;
    } while (!isValidStep(x, y));
    makeStep(x, y, CHAR_X);
  }
  
  /**
   * Computer takes a step.
   */
  private static void computerTurn() {
    int x;
    int y;
    do {
      x = rand.nextInt(SIZE);
      y = rand.nextInt(SIZE);
    } while (!isValidStep(x, y));
    makeStep(x, y, CHAR_O);
  }
  
  /**
   * Checks if a step is valid.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @return true if a step can be taken., otherwise false
   */
  private static boolean isValidStep(int x, int y) {
    return x >= 0 && x < SIZE && y >= 0 && y < SIZE
        && MAP[y][x] == CHAR_EMPTY;
  }
  
  /**
   * Puts the character in a specific place.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   */
  private static void makeStep(int x, int y, char ch) {
    MAP[y][x] = ch;
  }

  /**
   * Checks if there is a place on the map for a step.
   * 
   * @return true if there is, otherwise false
   */
  private static boolean isTherePlaceForStep() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (MAP[i][j] == CHAR_EMPTY) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean isWin(char ch) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (diagonally(i, j, ch) || vertically(i, j, ch) || diagonally(i, j, ch)) {
          return true;
        } 
      }
    }
    return false;
  }
  
  private static boolean horizontally(int row, int col, char ch) {
    for (int i = 0; i < QUANTITY_TO_WIN; i++) {
      if (col + i >= SIZE || MAP[row][col + i] != ch) {
        break;
      }
      if (i == QUANTITY_TO_WIN - 1) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean vertically(int row, int col, char ch) {
    for (int i = 0; i < QUANTITY_TO_WIN; i++) {
      if (row + i >= SIZE || MAP[row + i][col] != ch) {
        break;
      }
      if (i == QUANTITY_TO_WIN - 1) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean diagonally(int row, int col, char ch) {
    for (int i = 0; i < QUANTITY_TO_WIN; i++) {
      if (row + i >= SIZE && col + i >= SIZE || MAP[row + i][col + i] != ch) {
        break;
      }
      if (i == QUANTITY_TO_WIN - 1) {
        return true;
      }
    }
    for (int i = 0; i < QUANTITY_TO_WIN; i++) {
      if (row - i < 0 && col + i >= SIZE || MAP[row - i][col + i] != ch) {
        break;
      }
      if (i == QUANTITY_TO_WIN - 1) {
        return true;
      }
    }   
    return false;
  }
}

// MAP[row][col + i]
// MAP[row + i][col]
// MAP[row + i][col + i]
// MAP[row - i][col + i]

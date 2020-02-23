package four;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
  private static final int SIZE = 3;
  private static final char[][] MAP = new char[SIZE][SIZE];
  private static final char CHAR_EMPTY = '#';
  private static final char CHAR_X = 'X';
  private static final char CHAR_O = 'O';
  private static final char QUANTITY_TO_WIN = 3;
  private static Scanner sc = new Scanner(System.in);
  private static Random rand = new Random();
  
  /**
   * Launches the game TicTacToe.
   */
  public static void launch() {
    fillMap();
    printMap();    
    while (true) {
      humanTurn();
      printMap();
      if (isWin(CHAR_X)) {
        System.out.println("\nHuman win.");
        break;
      }
      if (!isTherePlaceForStep()) {
        System.out.println("\nDead heat...");
        break;
      }     
      computerTurn();
      printMap();
      if (isWin(CHAR_O)) {
        System.out.println("\nComputer win.");
        break;
      }
      if (!isTherePlaceForStep()) {
        System.out.println("\nDead heat...");
        break;
      }
    }   
    System.out.println("Game over.");
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
    } while (!moveOn(x, y, CHAR_EMPTY));
    makeStep(x, y, CHAR_X);
  }
  
  /**
   * Computer takes a step.
   */
  private static void computerTurn() {
    
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        
        if (moveOn(j, j, CHAR_EMPTY)) {
          
          makeStep(j, i, CHAR_O);
          
          if (isWin(CHAR_O)) {
            return;
          }
          
          makeStep(j, i, CHAR_EMPTY);
          
        }
        
      }
      
    }
    
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        // code
      }
      
    }
    
//    int x;
//    int y;
//    do {
//      x = rand.nextInt(SIZE);
//      y = rand.nextInt(SIZE);
//    } while (!moveOn(x, y, CHAR_EMPTY));
//    makeStep(x, y, CHAR_O);
  }
  
  /**
   * Checks if a step is valid.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   * @return true if a step can be taken., otherwise false
   */
  private static boolean moveOn(int x, int y, char ch) {
    return x >= 0 && x < SIZE && y >= 0 && y < SIZE
        && MAP[y][x] == ch;
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
  
  /**
   * Win checking.
   * 
   * @param ch character
   * @return true if the player won, otherwise true
   */
  private static boolean isWin(char ch) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (checking(i, j, ch)) {
         return true;
        }
      }
    }
    return false;
  }
  
  /**
   * Finds the winning sequence.
   * 
   * @param r row
   * @param c column
   * @param ch character
   * @return true if the winning sequence is find in one of four directions, otherwise false.
   */
  private static boolean checking(int r, int c, char ch) {
    int[][] dirValue = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
    for (int i = 0; i < dirValue.length; i++ ) {     
      int row = r;
      int col = c;
      for (int j = 0; j < QUANTITY_TO_WIN; j++) {
        if (!moveOn(col, row, ch)) {
          break;
        }
        if (j == QUANTITY_TO_WIN - 1) {
          return true;
        }
        row += dirValue[i][0];
        col += dirValue[i][1];
      }
    }
    return false;
  }
}

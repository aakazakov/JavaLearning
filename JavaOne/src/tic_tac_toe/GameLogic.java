package tic_tac_toe;

import java.util.*;

public class GameLogic {
  static int fieldSize;
  static int winLength;
  static int level;
  static boolean gameOver = false;
  static boolean humanWin = false;
  static boolean computerWin = false;
  static boolean deadHeat = false;
  
  private static char[][] field;
  private static final char CHAR_EMPTY = '#';
  private static final char CHAR_X = 'X';
  private static final char CHAR_O = 'O';
    
  private static Scanner sc = new Scanner(System.in);
  private static Random rand = new Random();
  
  public static void launch() {
      
    gameOver = true;
    
    printField();
    if (isWin(CHAR_X)) {
      humanWin = true;
      System.out.println("\nHuman win.");
      return;
    }
    if (!isTherePlaceForStep()) {
      deadHeat = true;
      System.out.println("\nDead heat...");
      return;
    }     
    computerTurn();
    printField();
    if (isWin(CHAR_O)) {
      computerWin = true;
      System.out.println("\nComputer win.");
      return;
    }
    if (!isTherePlaceForStep()) {
      deadHeat = true;
      System.out.println("\nDead heat...");
      return;
    }
      
    gameOver = false;
    System.out.println("Game over.");
  }
  
  static void fieldInit() {
    field  = new char[fieldSize][fieldSize];
    for (int i = 0; i < fieldSize; i++) {
      Arrays.fill(field[i], CHAR_EMPTY);
    }
  }
  
  private static void printField() {
    System.out.print("  ");
    for (int i = 1; i <= fieldSize; i++) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i = 0; i < fieldSize; i++) {
      System.out.print(i + 1 + " ");
      for (int j = 0; j < fieldSize; j++) {
        System.out.print(field[i][j] + " ");
      }
      System.out.println();
    }
  }
  
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
  
  static void setHumanTurnParams(int x, int y) {
    if (moveOn(x, y, CHAR_EMPTY)) {
      field[y][x] = CHAR_X;
      launch();
    }
  }
  
  private static void computerTurn() {  
    boolean success = tryToWin();
    if (!success) {
      success = tryNotToLose();
    }
    if (!success) {
      randomStep();
    }
  }
  
  private static boolean tryToWin() {
    for (int i = 0; i < fieldSize; i++) {
      for (int j = 0; j < fieldSize; j++) {        
        if (moveOn(j, i, CHAR_EMPTY)) {          
          makeStep(j, i, CHAR_O);         
          if (isWin(CHAR_O)) {
            return true;
          }          
          makeStep(j, i, CHAR_EMPTY);          
        }       
      }     
    }
    return false;
  }
  
  private static boolean tryNotToLose() {
    for (int i = 0; i < fieldSize; i++) {
      for (int j = 0; j < fieldSize; j++) {        
        if (moveOn(j, i, CHAR_EMPTY)) {          
          makeStep(j, i, CHAR_X);          
          if (isWin(CHAR_X)) {
            makeStep(j, i, CHAR_O);
            return true;
          }         
          makeStep(j, i, CHAR_EMPTY);         
        }
      }     
    }
    return false;
  }
  
  private static void randomStep() {
    int x;
    int y;
    do {
      x = rand.nextInt(fieldSize);
      y = rand.nextInt(fieldSize);
    } while (!moveOn(x, y, CHAR_EMPTY));
    makeStep(x, y, CHAR_O);
  }
  
  private static boolean moveOn(int x, int y, char ch) {
    return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize
        && field[y][x] == ch;
  }
  
  private static void makeStep(int x, int y, char ch) {
    field[y][x] = ch;
  }

  private static boolean isTherePlaceForStep() {
    for (int i = 0; i < fieldSize; i++) {
      for (int j = 0; j < fieldSize; j++) {
        if (field[i][j] == CHAR_EMPTY) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean isWin(char ch) {
    for (int i = 0; i < fieldSize; i++) {
      for (int j = 0; j < fieldSize; j++) {
        if (checking(i, j, ch)) {
         return true;
        }
      }
    }
    return false;
  }
  
  private static boolean checking(int r, int c, char ch) {
    int[][] dirValue = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
    for (int i = 0; i < dirValue.length; i++ ) {     
      int row = r;
      int col = c;
      for (int j = 0; j < winLength; j++) {
        if (!moveOn(col, row, ch)) {
          break;
        }
        if (j == winLength - 1) {
          return true;
        }
        row += dirValue[i][0];
        col += dirValue[i][1];
      }
    }
    return false;
  }
}

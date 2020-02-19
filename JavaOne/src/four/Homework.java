package four;

import java.util.Arrays;

public class Homework {
  private static final int SIZE = 3;
  private static final char[][] MAP = new char[SIZE][SIZE];
  private static final char CHAR_SHARP = '#';
  private static final char CHAR_X = 'X';
  private static final char CHAR_O = 'O';

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
    fillTheMap();
    printTheMap();
    
    putTheChar(3, 1, CHAR_O);
    printTheMap();

  }
  
  private static void fillTheMap() {
    for (int i = 0; i < SIZE; i++) {
      Arrays.fill(MAP[i], CHAR_SHARP);
    }
  }
  
  private static void printTheMap() {
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
   * Puts the character in a specific place.
   * 
   * @param x x coordinate
   * @param y y coordinate
   * @param ch character
   */
  private static void putTheChar(int x, int y, char ch) {
    MAP[y - 1][x - 1] = ch;
  } 
}

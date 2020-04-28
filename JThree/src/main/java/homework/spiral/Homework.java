package homework.spiral;

public class Homework {
  
  public static class Spiral {
    
    int[][] getSpiralOfNumbers(int[][] squareMatrix, int x, int y, int number) {
      
      if (squareMatrix.length == 1) {
        squareMatrix[y][x] = number;
        return squareMatrix;
      }
      
      // left -> right
      while (true) {
        if (x + 1 == squareMatrix.length || squareMatrix[y][x + 1] != 0) break;
        squareMatrix[y][x] = number;
        x++;
        number++;
      }
      
      // up -> down
      while (true) {
        if (y + 1 == squareMatrix.length || squareMatrix[y + 1][x] != 0) break;
        squareMatrix[y][x] = number;
        y++;
        number++;
      }
      
      // right -> left
      while (true) {
        if (x == 0 || squareMatrix[y][x - 1] != 0) break;
        squareMatrix[y][x] = number;
        x--;
        number++;
      }
      
      // down -> up
      while (true) {
        if (y == 0 || squareMatrix[y][x] != 0) break;
        squareMatrix[y][x] = number;
        y--;
        number++;
      }
      
      // exit from recursion
      if (number - 1 == squareMatrix.length * squareMatrix.length) return squareMatrix;
      
      x++;
      y++;
      return getSpiralOfNumbers(squareMatrix, x, y, number);
    }
    
  }

  public static void main(String[] args) {
    
    int size = 6;
    int[][] squareMatrix = new int[size][size];
    
    Spiral spiral = new Spiral();
    spiral.getSpiralOfNumbers(squareMatrix, 0, 0, 1);
    
    for (int i = 0; i < squareMatrix.length; i++) {
      for (int j = 0; j < squareMatrix[i].length; j++) {
        System.out.printf("%2d ", squareMatrix[i][j]);
      }
      System.out.println();
    }
  }
  
//  1  2  3  4  5  6 
//  20 21 22 23 24  7 
//  19 32 33 34 25  8 
//  18 31 36 35 26  9 
//  17 30 29 28 27 10 
//  16 15 14 13 12 11

}

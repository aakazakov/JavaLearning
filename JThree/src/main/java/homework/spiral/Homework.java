package homework.spiral;

import java.util.Arrays;

public class Homework {
  
  public static class Spiral {
    
    int[][] getSpiralOfNumbers(int[][] matrix, int counter, int x, int y, int delta) {
      
      System.out.println(x + " " + y + " " + counter + " " + delta);
      
      if ( x > 0 
          && y > 0 
          && x < matrix.length 
          && y < matrix.length 
          && matrix[y][x - 1] != 0 
          && matrix[y][x + 1] != 0 
          && matrix[y - 1][x] != 0 
          && matrix[y + 1][x] != 0) {
        matrix[y][x] = counter;
        return matrix;        
      }
      
      // left -> right
      while (x < matrix[y].length - delta) {
        
        matrix[y][x] = counter;
        
        x++;
        counter++;
        
      }
           
      // up -> down
      while (y < matrix.length - delta) {
        
        matrix[y][x] = counter;
        
        y++;
        counter++;
        
      }
      
      // right -> left
      while (x > delta - 1) {
        
        matrix[y][x] = counter;
        
        x--;
        counter++;
        
      }
      
      // down -> up
      while (y > delta - 1) {
                
        matrix[y][x] = counter;
        
        y--;
        counter++;
        
      }
      
      ++x; ++y; ++delta;
      
      return getSpiralOfNumbers(matrix, counter, x, y, delta);
      
    }
    
  }

  public static void main(String[] args) {

    Spiral spiral = new Spiral();
    
    int size = 7;
    
    int[][] square = new int[size][size];
    
    for (int[] row : square) {
      Arrays.fill(row, 0);
    }
    
    spiral.getSpiralOfNumbers(square, 1, 0, 0, 1);
    
    for (int i = 0; i < square.length; i++) {
      for (int j = 0; j < square[i].length; j++) {
        System.out.printf("%2d ", square[i][j]);
      }
      System.out.println();
    }
  }

}

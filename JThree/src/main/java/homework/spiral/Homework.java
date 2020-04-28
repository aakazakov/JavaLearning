package homework.spiral;

import java.util.Arrays;

public class Homework {
  
  public static class Spiral {
    
    int[][] getSpiralOfNumbers(int[][] matrix, int counter, int x, int y) {
      
      // left -> right
      
      while (true) {
        
        if (x + 1 == matrix.length || matrix[y][x + 1] != 0) {
          break;
        }
        
        matrix[y][x] = counter;
        
        x++;
        counter++;
        
      }
      
      // up -> down
      
      while (true) {
        
        if (y + 1 == matrix.length || matrix[y + 1][x] != 0) {
          break;
        }
        
        matrix[y][x] = counter;
        
        y++;
        counter++;
        
      }
      
      // right -> left
      
      while (true) {
        
        if (x == 0 || matrix[y][x - 1] != 0) {
          break;
        }
        
        matrix[y][x] = counter;
        
        x--;
        counter++;
        
      }
      
      // down -> up
      
      while (true) {
        
        if (y == 0 || matrix[y][x] != 0) {
          break;
        }
        
        matrix[y][x] = counter;
        
        y--;
        counter++;
        
      }
      
      System.out.println(x + " " + y);
      
      return matrix;
    }
    
  }

  public static void main(String[] args) {

    Spiral spiral = new Spiral();
    
    int size = 4;
    
    int[][] square = new int[size][size];
    
    for (int[] row : square) {
      Arrays.fill(row, 0);
    }
    
    spiral.getSpiralOfNumbers(square, 1, 0, 0);
    
    for (int i = 0; i < square.length; i++) {
      for (int j = 0; j < square[i].length; j++) {
        System.out.printf("%2d ", square[i][j]);
      }
      System.out.println();
    }
  }

}

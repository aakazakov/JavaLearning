package homework.spiral;

import java.util.Arrays;

public class Homework {
  
  public static class Spiral {
    
    int[][] getSpiralOfNumbers(int size) {
      int[][] matrix = new int[size][size];
      
      int counter = 1;
      
      for (int[] row : matrix) {
        Arrays.fill(row, 0);
      }
      
      int x = 0;
      int y = 0;
      
      // left -> right
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        x++;
        counter++;
        
        if (x == matrix[y].length - 1) break;
      }
           
      // up -> down
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        y++;
        counter++;
        
        if (y == matrix.length - 1) break;
        
      }
      
      // right -> left
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        x--;
        counter++;
        
        if (x == 0) break;
        
      }
      
      // down -> up
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        y--;
        counter++;
        
        if (y == 0) break;
        
      }
      
      x++; y++;
      
      
      // left -> right
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        x++;
        counter++;
        
        if (x == matrix[y].length - 2) break;
        
      }
           
      // up -> down
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        y++;
        counter++;
        
        if (y == matrix[y].length - 2) break;
        
      }
      
      // right -> left
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        x--;
        counter++;
        
        if (x == 1) break;
        
      }
      
      // down -> up
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        y--;
        counter++;
        
        if (y == 1) break;
        
      }
      
      x++; y++;
      
      // left -> right
      while (true) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        x++;
        counter++;
        
        if (x == matrix[y].length - 3) break;
        
      }
      
      return matrix;
    }
    
  }

  public static void main(String[] args) {

    Spiral spiral = new Spiral();
    int[][] matrix = spiral.getSpiralOfNumbers(5);
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

}

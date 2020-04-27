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
      while (x < matrix[y].length - 1) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        x++;
        counter++;
        
      }
           
      // up -> down
      while (y < matrix.length - 1) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        y++;
        counter++;
        
      }
      
      // right -> left
      while (x >= 1) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        x--;
        counter++;
        
      }
      
      // down -> up
      while (y >= 1) {
        
        if (matrix[y][x] != 0) break;
        
        matrix[y][x] = counter;
        
        y--;
        counter++;
        
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

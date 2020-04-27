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
      
      // left -> right
      for (int i = 0; i < matrix[0].length; i++) {
        matrix[0][i] = counter;
        counter++;
      }
      
      // up -> down
      for (int i = 1; i < matrix.length; i++) {
        matrix[i][matrix[i].length - 1] = counter;
        counter++;
      }
      
      // right -> left
      for (int i = matrix[0].length - 2; i >= 0; i--) {
        matrix[matrix[0].length - 1][i] = counter;
        counter++;
      }
      
      // down -> up
      for (int i = matrix.length - 2; i > 0; i--) {
        matrix[i][matrix[i][0]] = counter;
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

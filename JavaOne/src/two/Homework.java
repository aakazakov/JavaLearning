package two;

import java.util.Arrays;

public class Homework {

  /**
   * Run exercises.
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    
    // #1.
    int[] myArray = {0, 1, 0, 1, 1, 0};
    Homework.swapToOppositeValue(myArray);
    System.out.println(Arrays.toString(myArray));
    
    // #2.
    myArray = new int[8];
    Homework.fillTheArray(myArray);
    System.out.println(Arrays.toString(myArray));
    
    // #3.
    int[] myNewArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    Homework.changeSomeValuesInArray(myNewArray);
    System.out.println(Arrays.toString(myNewArray));
    
    // #4.
    Homework.printSquareMatrix(5);
    
    // #5.
    Homework.printMinAndMaxValues(myNewArray);
  }
  
  /**
   * #1.
   * 
   * <p>Swaps zeros to ones and vice versa.
   * 
   * @param arr array of zeros and ones
   * @return modified array
   */
  public static int[] swapToOppositeValue(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int value = arr[i];
      if (value == 1) {
        arr[i] = 0;
      }
      if (value == 0) {
        arr[i] = 1;
      }
    }
    return arr;
  }
  
  /**
   * #2.
   * 
   * <p>Fills an empty array.
   * 
   * @param arr an empty array
   * @return filled array
   */
  public static int[] fillTheArray(int[] arr) {
    int value = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = value;
      value += 3;
    }
    return arr;
  }
  
  /**
   * #3.
   * 
   * <p>Multiplies the value by 2 if it is less than 6.
   * 
   * @param arr array
   * @return modified array
   */
  public static int[] changeSomeValuesInArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < 6) {
        arr[i] *= 2; 
      }
    }
    return arr;
  }
  
  /**
   * #4.
   * 
   * <p>Square matrix printing ).
   * 
   * @param size matrix size
   */
  public static void printSquareMatrix(int size) {
    int[][] matrix = new int[size][size];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (j == i || j == size - i - 1) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = 0;
        }       
      }
      System.out.println(Arrays.toString(matrix[i]));
    }
  }
  
  /**
   * #5.
   * 
   * <p>Prints min and max values.
   * 
   * @param arr array
   */
  public static void printMinAndMaxValues(int[] arr) {
    Arrays.sort(arr);
    System.out.println("min value = " + arr[0] + "\nmax value = " + arr[arr.length - 1]);
  }
}

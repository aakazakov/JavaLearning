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
    
    // #6.
    System.out.println(Homework.isMiddleGroundExists(myNewArray));
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
    int min = arr[0];
    int max = arr[0];
    for (int value : arr) {
      if (value > max) {
        max = value;
      }
      if (value < min) {
        min = value;
      }
    }
    System.out.println("min value = " + min + ", max value = " + max);
  }
  
  /**
   * #6.
   * 
   * <p>Checks if there is a place (middle ground) in the array
   * where the sum of the left and the sum of the right parts are equal. 
   * 
   * @param arr array
   * @return true if the middle exists, otherwise false
   */
  public static boolean isMiddleGroundExists(int[] arr) {
    if (arr.length == 2 && arr[0] == arr[1]) {
      return true;
    }
    if (arr.length > 2) {    
      int middle = 1;
      while (middle <= arr.length - 1) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < middle; i++) {
          left += arr[i];
        }
        for (int i = middle; i < arr.length; i++) {
          right += arr[i];
        }
        if (left == right) {
          return true;
        }
        middle++;
      }
    }
    return false;
  }
}

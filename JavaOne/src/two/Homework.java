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
    swapToOppositeValue(myArray);
    System.out.println(Arrays.toString(myArray));
    
    // #2.
    myArray = new int[8];
    fillTheArray(myArray);
    System.out.println(Arrays.toString(myArray));
    
    // #3.
    int[] myNewArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    changeSomeValuesInArray(myNewArray);
    System.out.println(Arrays.toString(myNewArray));
    
    // #4.
    getSquareMatrix(5);
    
    // #5.
    printMinAndMaxValues(myNewArray); // myNewArray was changed on line 26.
    
    // #6.
    System.out.println(isMiddleGroundExists(myNewArray));
    
    // #7.
    int[] arr = {0, 1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(arrayRoll(arr, 11)));
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
      if (arr[i] == 1) {
        arr[i] = 0;
      } else {
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
   * <p>Square matrix creating ).
   * 
   * @param size matrix size
   * @return two-dimensional array
   */
  public static int[][] getSquareMatrix(int size) {
    int[][] matrix = new int[size][size];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (j == i || j == size - i - 1) {
          matrix[i][j] = 1;
        } else {
          matrix[i][j] = 0;
        }       
      }
      System.out.println(Arrays.toString(matrix[i])); // For visualization purposes.
    }
    return matrix;
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
    for (int i = 1; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
      if (min > arr[i]) {
        min = arr[i];
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

  /**
   * #7.
   * 
   * <p>Array rock 'n' roll ).
   * Moves array elements one step.
   * 
   * @param arr array
   * @param step step length
   * @return modified array
   */
  public static int[] arrayRoll(int[] arr, int step) {
    step = getDivisionRemainder(step, arr.length);
    if (step != 0) { 
      int startIndex = 0;
      int currentIndex = startIndex + step;
      int valueStorage = arr[startIndex];
      int needToChange = arr.length;
      while (needToChange > 0) {
        currentIndex = getCurrentIndex(currentIndex, arr.length);
        if (currentIndex == startIndex) {
          arr[currentIndex] = valueStorage;
          startIndex++;
          currentIndex = startIndex + step;
          valueStorage = arr[startIndex];
          needToChange--;
          continue;
        }
        arr[currentIndex] = arr[currentIndex] + valueStorage;
        valueStorage = arr[currentIndex] - valueStorage;
        arr[currentIndex] = arr[currentIndex] - valueStorage;
        currentIndex += step;
        needToChange--;
      }
    }
    return arr;
  }
  
  /**
   * #7.1
   * 
   * <p>Computes the remainder of division.
   * 
   * @param a number
   * @param b number
   * @return division remainder 'a' by 'b'
   */
  public static int getDivisionRemainder(int a, int b) {
    return a % b;
  }
  
  /**
   * #7.2
   * 
   * <p>Modifies the index value, if necessary.
   * 
   * @param currentIndex index
   * @param arrayLength array length
   * @return currentIndex value, modified if necessary
   */
  public static int getCurrentIndex(int currentIndex, int arrayLength) {
    if (currentIndex > arrayLength - 1) {
      return currentIndex - arrayLength;
    }
    if (currentIndex < 0) {
      return currentIndex + arrayLength;
    }
    return currentIndex;
  }
}

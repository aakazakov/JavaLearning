package practice;

public class Homework {
  public static void main(String[] args) {
    String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    
    String[][] squareMatrix = getSquareMatrix(str, 4);
    printMatrix(squareMatrix);
    
    int result = getResult(squareMatrix);
    System.out.print("\nResult: " + result);
  }
  
  public static String[][] getSquareMatrix(String str, int size) {
    if (size != 4) {
      throw new SizeException("incorrect size of matrix");
    }
    return convertToSquareMatrix(str, size);
  }
  
  public static String[][] convertToSquareMatrix(String str, int size) {
    String[] strArr = makeArray(str);
    String[][] matrix = new String[size][size];
    int current = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[i][j] = strArr[current];
        current++;
      }
    }
    return matrix;
  }
  
  public static String[] makeArray(String str) {
    return str.split("(\n| )");
  }
  
  public static void printMatrix(String[][] strArr) {
    System.out.println("Matrix:\n");
    for (int i = 0; i < strArr.length; i++) {
      for (int j = 0; j < strArr.length; j++) {
        System.out.print(strArr[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static int getResult(String[][] arr) {
    try {
      return makeArithmetic(arr);
    } catch (NumberFormatException e) {
      throw new NotAnIntegerException(e.getMessage());
    }
  }
  
  public static int makeArithmetic(String[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        sum += Integer.parseInt(arr[i][j]);
      }
    }
    return sum / 2;
  }
}

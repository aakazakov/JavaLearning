package practice;

public class Homework {
  static final int MATRIX_SIZE = 4;
  static final String STR = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
  static final String STR_NUMBER_EXCEPTION = "10 3 1 2\n2 3 2n 2\n5 6 7 1\n300 3 1 0";
  static final String STR_COLS_EXCEPTION = "10 3 1 2 7\n2 3 2 2\n5 6 7 1\n300 3 1 0";
  static final String STR_ROWS_EXCEPTION = "10 3 1 2\n2 3 2 2\n5 6 7 1";
  
  public static void main(String[] args) {
    try {
      String[][] matrix =  getSquareMatrix(STR);
      // String[][] matrix =  getSquareMatrix(STR_NUMBER_EXCEPTION);
      // String[][] matrix =  getSquareMatrix(STR_COLS_EXCEPTION);
      // String[][] matrix =  getSquareMatrix(STR_ROWS_EXCEPTION);
      printMatrix(matrix);      
      int result = makeArithmetic(matrix);
      System.out.printf("%nResult: %d.", result);
    } catch (SizeException e) {
      System.out.println(e.getMessage() + ". Ñorrect value: " + MATRIX_SIZE);
    } catch (NotAnIntegerException e) {
      System.out.println(e.getMessage());
    }   
  }
  
  public static String[][] getSquareMatrix(String str) {
    String[] rows = str.split("\n");
    if (rows.length != MATRIX_SIZE) {
      throw new SizeException("Rows amount mismatch: " + rows.length);
    }
    String[][] matrix = new String[MATRIX_SIZE][];
    for (int i = 0; i < MATRIX_SIZE; i++) {
      matrix[i] = rows[i].split(" ");
      if (matrix[i].length != MATRIX_SIZE) {
        throw new SizeException("Colls amount mismatch: " + matrix[i].length);
      }
    }
    return matrix;
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
  
 public static int makeArithmetic(String[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        try {
          sum += Integer.parseInt(arr[i][j]);
        } catch (NumberFormatException e) {
          throw new NotAnIntegerException(e.getMessage() + " on position " 
           + "arr"  + "[" + i + "]" + "[" + j + "]");
        }
      }
    }
    return sum / 2;
  }
}

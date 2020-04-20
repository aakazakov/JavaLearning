package homework.hw5;

public class ArrayMethods {
  
  public int[] getItemsAfterFour(int[] arr) {
    if (arr.length == 0) { throw new RuntimeException("Empty array"); }
    int i = arr.length - 1;
    while (i >= 0) {
      if (arr[i] == 4) { break; }
      if (i == 0 && arr[i] != 4) { throw new RuntimeException("There is no 4 in the array"); }
      i--;
    }
    int[] newArr = new int[arr.length - i - 1];
    System.arraycopy(arr, i + 1, newArr, 0, newArr.length);
    return newArr;
  }
}

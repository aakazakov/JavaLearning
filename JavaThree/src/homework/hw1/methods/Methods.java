package homework.hw1.methods;

import java.util.*;

public class Methods {
  
  public void swap(Object[] arr, int index1, int index2) {
    Object temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
   
  public <T> ArrayList<T> makeArrayList(T[] arr) {
    ArrayList<T> arrList = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      arrList.add(arr[i]);
    }
    return arrList;
  }
  
}

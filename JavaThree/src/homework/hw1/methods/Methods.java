package homework.hw1.methods;

import java.util.*;

public class Methods {
  
  public void swap(String[] arr, int index1, int index2) {
    String temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
  
  // Ќе знаю почему IDE предложила перед void T поставить )
  public <T> void swap(List<T> arr, int index1, int index2 ) {
    T temp = arr.get(index1);
    arr.set(index1, arr.get(index2));
    arr.set(index2, temp);
  }
  
  // ћожно было указать в качестве параметра массив примитивов,
  // но тогда пришлось бы €вным образом указывать значение “.
  // я посмотрел реализацию метода Arrays.asList, там переданный массив
  // преобразуетс€ в последовательность аргументов (T ...arr). Ќе пойму, почему 
  // в случае с (T ...arr) можно передать массив примитивов, а в моЄм случае нет).
  public <T> ArrayList<T> makeArrayList(T[] arr) {
    ArrayList<T> arrList = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      arrList.add(arr[i]);
    }
    return arrList;
  }
  
}

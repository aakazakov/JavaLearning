package homework.hw1.methods;

import java.util.*;

public class Methods {
  
  public <T> void swap(T[] arr, int index1, int index2) {
    T temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
   
/*
 В методе Arrays.asList при передаче в него массива, массив преобразуется в последоваьельность
 аргументов (Т ...arr) и передавать можно как массив примитивов так и массив ссылок.
 В мой метод возможно передать только массив ссылок, в противном случае не работает).
 Можно конечно параметром указать массив примитивов, но тогда нужно будет явно указать тип
 возвращаемого значения - лист ссылок-оберток для этого примитива.
 Я не пойму - почему в Arrays.asList можно передавать массив любых типов ? ) 
 */
  public <T> ArrayList<T> makeArrayList(T[] arr) {
    ArrayList<T> arrList = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      arrList.add(arr[i]);
    }
    return arrList;
  }
  
}

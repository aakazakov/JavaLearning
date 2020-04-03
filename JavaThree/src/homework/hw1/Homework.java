package homework.hw1;

import java.util.*;

import homework.hw1.methods.Methods;

public class Homework {

  public static void main(String[] args) {
    
    Methods method = new Methods();
    
    // #1.
    String[] arrStr = new String[] {"a", "b" , "c" , "d", "e"};  
    System.out.println("Before: " + Arrays.toString(arrStr));
    
    method.swap(arrStr, 0, 4);
    System.out.println("After: " + Arrays.toString(arrStr));
    
    List<String> list = Arrays.asList(arrStr);
    method.swap(list, 1, 3);
    System.out.println("And after another swap: " + list);
    
    // #2.
    Integer[] arrInt = new Integer[] {1, 2, 3, 4, 5};
    ArrayList<Integer> listInt = method.makeArrayList(arrInt);
    System.out.println("Form Array to ArrayList: " + listInt);
     
  }

}

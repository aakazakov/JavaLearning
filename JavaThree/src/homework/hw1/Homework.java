package homework.hw1;

import java.util.*;

import homework.hw1.methods.Methods;

public class Homework {

  public static void main(String[] args) {
    
    Methods method = new Methods();
    
    // #1.
    String[] arr = new String[] {"a", "b" , "c" , "d", "e"};  
    System.out.println("Before: " + Arrays.toString(arr));
    
    method.swap(arr, 0, 4);
    System.out.println("After: " + Arrays.toString(arr));
    
    List<String> list = Arrays.asList(arr);
    method.swap(list, 1, 3);
    System.out.println("And after another swap: " + list);
    
  }

}

package homework.hw1;

import java.util.*;

import homework.hw1.fruitBox.*;
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
    System.out.println("And after another swap: " + list + "\n");
    
    // #2.
    Integer[] arrInt = new Integer[] {1, 2, 3, 4, 5};
    ArrayList<Integer> listInt = method.makeArrayList(arrInt);
    System.out.println("Form Array to ArrayList: " + listInt + "\n");
    
    // #3.
    Box<Apple> appleBox = new Box<>();
    Box<Orange> orangeBox = new Box<>();
    
    appleBox.put(new Apple());
    appleBox.put(new Apple());
    appleBox.put(new Apple());
    System.out.println("Apple box weight: " + appleBox.getBoxWeightNetto());
    
    orangeBox.put(new Orange());
    orangeBox.put(new Orange());
    orangeBox.put(new Orange());
    System.out.println("Orange box weigh: " + orangeBox.getBoxWeightNetto());
    
    System.out.println("The boxes are equal: " + appleBox.compareBoxesByWeight(orangeBox) + "\n");
    
    Box<Apple> appleBox1 = new Box<>();
    appleBox1.put(new Apple());
    appleBox1.put(new Apple());
    appleBox1.put(new Apple());
    
    System.out.println("appleBox1 weight: " + appleBox1.getBoxWeightNetto());
    System.out.println("appleBox weight: " + appleBox.getBoxWeightNetto());
    
    appleBox1.moveFruitsToAnother(appleBox);
    
    System.out.println("appleBox1 weight: " + appleBox1.getBoxWeightNetto());
    System.out.println("appleBox weight: " + appleBox.getBoxWeightNetto());
    
  }

}

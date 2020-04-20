package homework.hw5;

import java.util.Arrays;

public class Homework {
  
  public static void main(String[] args) {
    
    ArrayMethods am = new ArrayMethods();
    
    int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
   
    System.out.println(Arrays.toString(am.getItemsAfterFour(arr)));
  }

}

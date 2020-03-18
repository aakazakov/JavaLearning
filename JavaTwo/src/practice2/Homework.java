package practice2;

import java.util.Arrays;

public class Homework {
  static final int size = 10000000;
  static final int h = size / 2;

  public static void main(String[] args) {
    
    float [] arr = new float[size];
    Arrays.fill(arr, 1f);
    
    long start = System.currentTimeMillis();
    goThroughTheArrayAndDoSomething(arr);
    System.out.println(System.currentTimeMillis() - start); // 1180
    
    
  }
  
  static void goThroughTheArrayAndDoSomething(float[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) 
          * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
  }
}

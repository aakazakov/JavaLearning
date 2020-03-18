package practice2;

import java.util.Arrays;

public class Homework {
  static final int SIZE = 10000000;
  static final int H = SIZE / 2;

  public static void main(String[] args) {
    
    float[] arr = new float[SIZE];
    Arrays.fill(arr, 1f);
    
//    inOneThread(arr); // 1212 ms
    
//    inTwoThreads(arr); // 644 ms
    
  }
  
  static void inOneThread(float[] arr) {
    long start = System.currentTimeMillis();
    goThroughTheArrayAndDoSomethingAmazing(arr);
    System.out.println(System.currentTimeMillis() - start);
  }
  
  static void inTwoThreads(float[] arr) {
    long start = System.currentTimeMillis();
    
    float[] a1 = new float[H];
    float[] a2 = new float[H];
    System.arraycopy(arr, 0, a1, 0, H);
    System.arraycopy(arr, H, a2, 0, H);
    
    Thread t1 = new Thread(() -> 
      goThroughTheArrayAndDoSomethingAmazing(a1)
    );
    Thread t2 = new Thread(() -> 
      goThroughTheArrayAndDoSomethingAmazing(a2)
    );
    
    t1.start();
    t2.start();
    
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.arraycopy(a1, 0, arr, 0, H);
    System.arraycopy(a2, 0, arr, H, H);
    
    System.out.println(System.currentTimeMillis() - start);
  }
  
  static void goThroughTheArrayAndDoSomethingAmazing(float[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) 
          * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
  }
}

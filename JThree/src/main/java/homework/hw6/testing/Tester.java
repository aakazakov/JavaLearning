package homework.hw6.testing;

import java.lang.reflect.*;
import java.util.Arrays;

public class Tester {
  
  public static void start(String className) throws ClassNotFoundException {
    Class<?> testClass = Class.forName(className);
    
    Method[] methods = testClass.getDeclaredMethods();
    for (Method m : methods) {
      System.out.println(m.getName() + " " + Arrays.toString(m.getAnnotations()));
    }
  }
}

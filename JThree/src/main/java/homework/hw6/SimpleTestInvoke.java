package homework.hw6;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleTestInvoke {
  
  public static void start(String className) throws ClassNotFoundException {
    Class<?> testClass = Class.forName(className);
    
    Method[] methods = testClass.getDeclaredMethods();
    for (Method m : methods) {
      System.out.println(m.getName() + " " + Arrays.toString(m.getAnnotations()));
    }
  }
  
}

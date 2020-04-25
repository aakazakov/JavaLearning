package homework.hw6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleTestInvoke {
  
  public static void start(String className)
      throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
    Class<?> testClass = Class.forName(className);
    Method[] methods = testClass.getDeclaredMethods();
    Robot robot = new Robot();
    
    startBeforeSuite(methods, robot);
    
    for (Method m : methods) {
      if (m.isAnnotationPresent(Test.class)) {
        m.invoke(robot);
      }
    }
    
    for (Method m : methods) {
      if (m.isAnnotationPresent(AfterSuite.class)) {
        m.invoke(robot);
      }
    }
    
  }
  
  private static void startBeforeSuite(Method[] methods, Object obj)
      throws IllegalAccessException, InvocationTargetException {
    boolean wasInvoked = false;
    for (Method m : methods) {
      if (m.isAnnotationPresent(BeforeSuite.class)) {
        if (wasInvoked) { throw new RuntimeException("BeforeSuite occurs more than 1 time"); }
        m.setAccessible(true);
        m.invoke(obj);
        wasInvoked = true;
      }
    }
  }
  
}

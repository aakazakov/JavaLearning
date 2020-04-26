package homework.hw6;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class SimpleTestInvoke {
  private static Class<?> testClass;
  private static Method[] methods;
  private static Object object;
  
  public static void start(String className)
      throws ClassNotFoundException,
      IllegalAccessException,
      InvocationTargetException,
      NoSuchMethodException,
      InstantiationException {
    testClass = Class.forName(className);
    Constructor<?> constructor = testClass.getConstructor();
    object = constructor.newInstance();
    methods = testClass.getDeclaredMethods();
    
    launchOnce(BeforeSuite.class);
    
    for (Method m : methods) {
      if (m.isAnnotationPresent(Test.class)) {
        m.invoke(object);
      }
    }
    
    launchOnce(AfterSuite.class);
    
  }
  
  private static void launchOnce(Class<? extends Annotation> annotationClass)
      throws IllegalAccessException, InvocationTargetException {
    boolean wasInvoked = false;
    for (Method m : methods) {
      if (m.isAnnotationPresent(annotationClass)) {
        if (wasInvoked) { throw new RuntimeException("Annotation occurs more than 1 time"); }
        m.setAccessible(true);
        m.invoke(object);
        wasInvoked = true;
      }
    }
  }
  
}

package homework.hw6;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

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
    launchAllTestsByPriority();
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
  
  private static void launchAllTestsByPriority()
      throws IllegalAccessException, InvocationTargetException {
    List<Method> testList = new ArrayList<>();
    
    for (Method m : methods) {
      if (!m.isAnnotationPresent(Test.class)) { continue; }
      testList.add(m);
    }
    
    testList.sort(new Comparator<Method>() {

      @Override
      public int compare(Method m1, Method m2) {
        return m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority();
      }
    });
    
    for (Method m : testList) {
      m.setAccessible(true);
      m.invoke(object);
    }
  }
  
}

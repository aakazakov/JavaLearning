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
    sortByPriorirty();
    for (int i = 0; i < methods.length; i++) {
      if (!methods[i].isAnnotationPresent(Test.class)) { continue; }
      methods[i].setAccessible(true);
      methods[i].invoke(object);
    }
  }

  private static void sortByPriorirty() {
    for (int i = 0; i < methods.length - 1; i++) {
      for (int j = 0; j < methods.length - i - 1; j++) {
        if (!methods[j].isAnnotationPresent(Test.class)) { continue; }
        for (int k = j + 1; k < methods.length - i; k++) {
          if (!methods[k].isAnnotationPresent(Test.class)) { continue; }
          if (methods[j].getAnnotation(Test.class).priority() < methods[k].getAnnotation(Test.class).priority()) {
            Method tmp = methods[j];
            methods[j] = methods[k];
            methods[k] = tmp;
          }
          break;
        }
      }
    }
  }
  
}

package practice;

import org.junit.*;

import homework.hw5.ArrayMethods;

public class ArrayMethodsAdditionalTests {

  ArrayMethods am;
  
  @Before
  public void init() {
    am = new ArrayMethods();
  }
  
  @Test (expected = RuntimeException.class) // empty input array
  public void emptyArrayExceptionTest() {
    int[] inArr = {};
    Assert.assertArrayEquals("Here we have to throw a new RuntimeException )", null, am.getItemsAfterLastFour(inArr));
  }
  
  @Test (expected = RuntimeException.class) // no 4 in array
  public void noFourExceptionTest() {
    int[] inArr = {1, 2, 3, 5, 6, 7, 7};
    Assert.assertArrayEquals("Here we have to throw a new RuntimeException )", null, am.getItemsAfterLastFour(inArr));
  }
  
  @Test // array does not contain '4'
  public void returnFalseTest0() {
    int[] inArr = {1, 1, 1, 1, 1, 1};
    Assert.assertFalse("Here we have to get false", am.doesTheArrayContainOnlyOneAndFour(inArr));
  }
  
  @Test // array does not contain '1'
  public void returnFalseTest1() {
    int[] inArr = {4, 4, 4, 4, 4, 4, 4};
    Assert.assertFalse("Here we have to get false", am.doesTheArrayContainOnlyOneAndFour(inArr));
  }
  
  @Test // array contains not only '1' and '4'
  public void returnFalseTest2() {
    int[] inArr = {1, 1, 4, 1, 5, 1, 1};
    Assert.assertFalse("Here we have to get false", am.doesTheArrayContainOnlyOneAndFour(inArr));
  }
  
  @Test // empty input array
  public void returnFalseTest3() {
    int[] inArr = {};
    Assert.assertFalse("Here we have to get false", am.doesTheArrayContainOnlyOneAndFour(inArr));
  }

}

package practice;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import homework.hw5.ArrayMethods;

public class ArrayMethodsTest {
  private ArrayMethods am;
  
  @Before
  public void init() {
    am = new ArrayMethods();
  }

  @Test
  public void getItemsAfterLastFourTest() {
    int[] arrIn = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
    int[] arrOut = {3, 2, 1};
    Assert.assertArrayEquals(arrOut, am.getItemsAfterLastFour(arrIn));
  }

}

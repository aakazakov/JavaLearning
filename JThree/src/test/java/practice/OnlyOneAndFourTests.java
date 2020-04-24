package practice;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import homework.hw5.ArrayMethods;

@RunWith(Parameterized.class)
public class OnlyOneAndFourTests {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
      { new int[] {1, 4, 4, 1, 4, 1, 4, 4, 1} },
      { new int[] {1, 1, 1, 1, 1, 1, 4} },
      { new int[] {4, 4, 4, 4, 4, 4, 4, 1} }
    });
  }

  private int[] inArr;
  
  public OnlyOneAndFourTests(int[] inArr) {
    this.inArr = inArr;
  }
  
  private ArrayMethods am;
  
  @Before
  public void init() {
    am = new ArrayMethods();
  }
  
  @Test
  public void doesTheArrayContainOnlyOneAndFourTest() {
    Assert.assertTrue(am.doesTheArrayContainOnlyOneAndFour(inArr));
  }

}

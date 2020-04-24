package practice;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import homework.hw5.ArrayMethods;

@RunWith(Parameterized.class)
public class ItemsAfterLastFourTests {
  
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
      { new int[] {1, 2, 3, 4, 5, 4, 3, 2, 1}, new int[] {3, 2, 1} },
      { new int[] {4, 4, 4, 4, 4, 1}, new int[] {1} },
      { new int[] {4}, new int[] {} },
      { new int[] {4, 0, 4, 1, 4, 2, 4, 3, 4, 4, 5}, new int[] {5} },
      { new int[] {4, 3, 6, 5, 8, 4}, new int[] {} },
      { new int[] {4, 3, 6, -5, 8, -9}, new int[] {3, 6, -5, 8, -9} }
    });
  }

  private int[] inArr;
  private int[] outArr;
  
  public ItemsAfterLastFourTests(int[] inArr, int[] outArr) {
    
    this.inArr = inArr;
    this.outArr = outArr;

  }
  
  private ArrayMethods am;
  
  @Before
  public void init() {
    am = new ArrayMethods();
  }
  
  @Test
  public void getItemsAfterLastFourTest() {
    Assert.assertArrayEquals(outArr, am.getItemsAfterLastFour(inArr));
  }

}

package practice;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import homework.hw5.ArrayMethods;

@RunWith(Parameterized.class)
public class ItemsAfterLastFourTest {
  
  @Parameterized.Parameters
  public static Collection<Integer[][]> data() {
    return Arrays.asList(new Integer[][][] {
      { {1, 2, 3, 4, 5, 4, 3, 2, 1}, {3, 2, 1} },
      { {4, 4, 4, 4, 4, 1}, {1} },
      { {4}, {} },
      { {4, 0, 4, 1, 4, 2, 4, 3, 4, 4, 5}, {5} },
      { {4, 3, 6, 5, 8, 4}, {} },
      { {4, 3, 6, -5, 8, -9}, {3, 6, -5, 8, -9} }
    });
  }

  private int[] inArr;
  private int[] outArr;
  
  public ItemsAfterLastFourTest(Integer[] inArr, Integer[] outArr) {
    
    this.inArr = new int[inArr.length];
    this.outArr = new int[outArr.length];
    
    for (int i = 0; i < inArr.length; i++) {
      this.inArr[i] = inArr[i].intValue();
    }
    
    for (int i = 0; i < outArr.length; i++) {
      this.outArr[i] = outArr[i].intValue();
    }

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

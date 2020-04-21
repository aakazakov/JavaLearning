package practice;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import homework.hw5.ArrayMethods;

@RunWith(Parameterized.class)
public class OnlyOneAndFour {

  @Parameterized.Parameters
  public static Collection<Integer[][]> data() {
    return Arrays.asList(new Integer[][][] {
      {{1, 4, 4, 1, 4, 1, 4, 4, 1}},
      {{1, 1, 1, 1, 1, 1, 4}},
      {{4, 4, 4, 4, 4, 4, 4, 1}}
    });
  }

  private int[] inArr;
  
  public OnlyOneAndFour(Integer[] inArr) {
    this.inArr = new int[inArr.length];
    
    for (int i = 0; i < inArr.length; i++) {
      this.inArr[i] = inArr[i].intValue();
    }
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

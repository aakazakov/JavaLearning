package homework.hw6;

import homework.hw6.testing.*;

/**
 * Just some class with some methods).
 */
public class TestableClass {
  private int firstOperand;
  private int secondOperand;
  
  @BeforeSuite
  public void init(int firstOperand, int secondOrerand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOrerand;
  }
  
  @Test
  public int getResultOf(String operator) {
    switch (operator) {
      case "+": return firstOperand + secondOperand;
      case "-": return firstOperand - secondOperand;
      case "/": return firstOperand / secondOperand;
      case "*": return firstOperand * secondOperand;
      default: return firstOperand % secondOperand;
    }
  }
  
  @Test
  public int getPositiveSubtractionResult() {
    if (isFirstGraterThenSecond()) return firstOperand - secondOperand;
    return secondOperand - firstOperand;
  }
  
  @Test
  private boolean isFirstGraterThenSecond() {
    return firstOperand >= secondOperand;
  }
  
  @AfterSuite
  public String getTestInfo() {
    return "Well Done. Testing is over.";
  }
}

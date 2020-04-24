package homework.hw6;

/**
 * Just some class with some methods).
 */
public class TestableClass {
  private int firstOperand;
  private int secondOperand;
  
  public void init(int firstOperand, int secondOrerand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOrerand;
  }
  
  public int getResultOf(String operator) {
    switch (operator) {
      case "+": return firstOperand + secondOperand;
      case "-": return firstOperand - secondOperand;
      case "/": return firstOperand / secondOperand;
      case "*": return firstOperand * secondOperand;
      default: return firstOperand % secondOperand;
    }
  }
  
  public int getPositiveSubtractionResult() {
    if (isFirstGraterThenSecond()) return firstOperand - secondOperand;
    return secondOperand - firstOperand;
  }
  
  private boolean isFirstGraterThenSecond() {
    return firstOperand >= secondOperand;
  }
  
  public String getTestInfo() {
    return "Well Done. Testing is over.";
  }
}

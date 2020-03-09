package practice;

public class NotAnIntegerException extends ArithmeticException {
  public NotAnIntegerException(String errorMessage) {
    super(errorMessage + " can't convert to integer");
  }
}

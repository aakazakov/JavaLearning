package practice;

public class NotAnIntegerException extends NumberFormatException {
  public NotAnIntegerException(String errorMessage) {
    super(errorMessage + " can't convert to integer");
  }
  
  public NotAnIntegerException() {
    
  }
}

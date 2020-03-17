package chat.exceptions;

import java.io.IOException;

public class FileWritingException extends IOException {
  public FileWritingException() {
    super();
  }
  
  public FileWritingException(String message) {
    super("Can't to write in the file by path: " + message);
  }
}

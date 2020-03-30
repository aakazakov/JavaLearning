package com.chat.library.exceptions;

public class UnknownSourceException extends RuntimeException {
  public UnknownSourceException(String e) {
    super(e);
  }
  
  public UnknownSourceException() {
    
  }
}

package homework.hw3.serializzz;

import java.net.*;
import java.io.*;

public class Client {
  
  private static final String HOST = "127.0.0.1";

  public static void main(String[] args) {
    
    try (Socket socket = new Socket(HOST, Server.PORT);
        ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream())) {
      
      Entity entity = new Entity("Substance", "square", "green", 10);
      
      outObj.writeObject(entity);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
     
  }
}

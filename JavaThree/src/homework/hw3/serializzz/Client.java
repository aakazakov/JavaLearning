package homework.hw3.serializzz;

import java.net.*;
import java.io.*;

public class Client {
  
  private static final String HOST = "127.0.0.1";

  public static void main(String[] args) {
    
    try (Socket socket = new Socket(HOST, Server.PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
      System.out.println("Client created");
      System.out.println("Output stream opened");
      
      out.writeUTF("HELLO");
      out.flush();    
      
    } catch (Exception e) {
      e.printStackTrace();
    }
     
  }
}

package homework.hw3.serializzz;

import java.net.*;
import java.io.*;

public class Server {
  public static final int PORT = 8189;
  
  public static void main(String[] args) {

    try (ServerSocket server = new ServerSocket(PORT)) {
      Socket socket = server.accept();
      ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
      
      Entity entity = (Entity) inObj.readObject();
      System.out.println(entity);
      System.out.println(entity.computeFactorial(5));
      
      inObj.close();
      socket.close();      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}

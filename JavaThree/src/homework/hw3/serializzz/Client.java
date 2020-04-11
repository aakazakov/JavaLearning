package homework.hw3.serializzz;

import java.net.*;
import java.util.Arrays;
import java.io.*;

public class Client {
  
  private static final String HOST = "127.0.0.1";

  public static void main(String[] args) {
    
//    try (Socket socket = new Socket(HOST, Server.PORT);
//        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
//      System.out.println("Client created");
//      System.out.println("Output stream opened");
//      
//      Entity e = new Entity("Substance", "square", "green", 10);
//      System.out.println(e);
//      System.out.println(e.computeFactorial(3));
//      
//      out.writeUTF("HELLO");
//      out.flush();    
//      
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
    try (Socket socket = new Socket(HOST, Server.PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream outObj = new ObjectOutputStream(outStream)) {
      Entity entity = new Entity("Substance", "square", "green", 10);
      
      outObj.writeObject(entity);
      
      byte[] byteArr = outStream.toByteArray();
      out.write(byteArr);      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
     
  }
}

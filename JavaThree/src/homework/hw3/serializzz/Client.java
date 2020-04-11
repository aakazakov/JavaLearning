package homework.hw3.serializzz;

import java.net.*;
import java.io.*;

public class Client {
  
  private static final String HOST = "127.0.0.1";

  public static void main(String[] args) {
    
    try (Socket socket = new Socket(HOST, Server.PORT);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ObjectOutputStream outObj = new ObjectOutputStream(outStream)) {
      
      Entity entity = new Entity("Substance", "square", "green", 10);
      
      outObj.writeObject(entity);
      byte[] outBytes = outStream.toByteArray();
      
      out.write(outBytes);    
      
    } catch (Exception e) {
      e.printStackTrace();
    }
     
  }
}

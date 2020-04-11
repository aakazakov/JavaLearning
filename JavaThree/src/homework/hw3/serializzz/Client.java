package homework.hw3.serializzz;

import java.io.*;
import java.net.Socket;

public class Client {
  private DataOutputStream out;
  
  public Client() {
    connect();
  }
  
  private void connect() {
    try (Socket socket = new Socket("127.0.0.1", 8189)) {
      out = new DataOutputStream(socket.getOutputStream());
      System.out.println("client find server");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void send(String msg) {
    try {
      out.writeUTF(msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  } 
}

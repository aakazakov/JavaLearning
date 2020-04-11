package homework.hw3.serializzz;

import java.net.*;
import java.io.*;

public class Server {
  private static final int PORT = 8189;
  
  public static void main(String[] args) {
    
    try (ServerSocket server = new ServerSocket(PORT)) {
      System.out.println("Server created");
      
      Socket socket = server.accept();
      System.out.println("Connection accepted");
      
      DataInputStream in = new DataInputStream(socket.getInputStream());
      System.out.println("Input stream opened");
      
      String entry = in.readUTF();
      System.out.println(entry);
      
      in.close();
      System.out.println("Input stream closed");
      
      socket.close();
      System.out.println("Connection ended");
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
}

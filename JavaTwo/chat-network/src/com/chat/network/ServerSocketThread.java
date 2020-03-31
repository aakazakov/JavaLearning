package com.chat.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerSocketThread extends Thread {
  private ServerSocketThreadListener listener;
  private int port;
  private int timeout;
  
  public ServerSocketThread(ServerSocketThreadListener listener, String name, int port, int timeout) {
    super(name);
    this.listener = listener;
    this.port = port;
    this.timeout = timeout;
    start();
  }
  
  @Override
  public void run() {
    listener.onServerStarted();
    try (ServerSocket server = new ServerSocket(port)) {
      server.setSoTimeout(timeout);
      listener.onServerSocketCreated();
      while (!isInterrupted()) {
        Socket socket;
        try {
          socket = server.accept();
        } catch (SocketTimeoutException e) {
          listener.onServerTimeOut();
          continue;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

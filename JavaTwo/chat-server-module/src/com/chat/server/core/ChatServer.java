package com.chat.server.core;

import com.chat.network.ServerSocketThread;
import com.chat.network.ServerSocketThreadListener;

public class ChatServer implements ServerSocketThreadListener {
  ServerSocketThread server;
  
  public void start(int port) {
    if (server == null || !server.isAlive()) {
      server = new ServerSocketThread(this, "Server", port, 2000);
    } else {
      System.out.println("Server has already been started");
    }
  }
  
  public void stop() {
    System.out.println("Server stopped");
  }

  @Override
  public void onServerStarted() {
    System.out.println("Server started");
    
  }

  @Override
  public void onServerStopped() {
    System.out.println("ServerSopped");
  }

  @Override
  public void onServerSocketCreated() {
    System.out.println("Server socket created");
  }

  @Override
  public void onServerTimeOut() { }

  @Override
  public void onSocketAccepted() {
    System.out.println("Server accepted");
  }

  @Override
  public void onServerException() {
    System.out.println("Exception happened");
  }
}

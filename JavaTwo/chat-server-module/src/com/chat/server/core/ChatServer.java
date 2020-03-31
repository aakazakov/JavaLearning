package com.chat.server.core;

import java.net.ServerSocket;
import java.net.Socket;

import com.chat.network.*;

public class ChatServer implements ServerSocketThreadListener, SocketThreadListener {
  private ServerSocketThread server;
  private ChatServerListener listener;
  
  public ChatServer(ChatServerListener listener) {
    this.listener = listener;
  }
  
  public void start(int port) {
    if (server == null || !server.isAlive()) {
      server = new ServerSocketThread(this, "Server", port, 2000);
    } else {
      putLog("Server has already been started");
    }
  }
  
  public void stop() {
    putLog("Server stopped");
  }
  
  private void putLog(String str) {
    listener.onChatServerMessage(str);
  }

  @Override
  public void onServerStarted() {
    putLog("Server started");
  }

  @Override
  public void onServerStopped() {
    putLog("ServerSopped");
  }

  @Override
  public void onServerSocketCreated() {
    putLog("Server socket created");
  }

  @Override
  public void onServerTimeOut() { }

  @Override
  public void onSocketAccepted(ServerSocketThread thread, ServerSocket server, Socket socket) {
    putLog("Client connected");
    String name = "Socket Thread " + socket.getInetAddress() + ":" + socket.getPort();
    new SocketThread(this, name, socket);
  }

  @Override
  public void onServerException() {
    putLog("Exception happened");
  }

  @Override
  public void onSocketStarted() {
    putLog("socket started on server");    
  }

  @Override
  public void onSocketReady() {
    putLog("socket ready on server");
  }

  @Override
  public void onReceivedString(String str) {
    putLog(str);
  }

  @Override
  public void onSocketStopped() {
    putLog("socket stopped on server");
  }

  @Override
  public void onSocketException() {
    putLog("socket exception on server");
  }
}

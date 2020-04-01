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
    if (server != null && server.isAlive()) {
      server.interrupt();
    } else {
      putLog("Server is not running");
    }
  }
  
  private void putLog(String str) {
    listener.onChatServerMessage(str);
  }

  @Override
  public void onServerStarted(ServerSocketThread thread) {
    putLog("Server started");
  }

  @Override
  public void onServerStopped(ServerSocketThread thread) {
    putLog("Server stopped");
  }

  @Override
  public void onServerSocketCreated(ServerSocketThread thread, ServerSocket server) {
    putLog("Server socket created");
  } 

  @Override
  public void onServerTimeOut(ServerSocketThread thread, ServerSocket server) { }

  @Override
  public void onSocketAccepted(ServerSocketThread thread, ServerSocket server, Socket socket) {
    putLog("Client connected");
    String name = "Socket Thread " + socket.getInetAddress() + ":" + socket.getPort();
    new ClientThread(this, name, socket);
  }

  @Override
  public void onServerException(ServerSocketThread thread, Throwable e) {
    e.printStackTrace();
  }

  @Override
  public void onSocketStarted(SocketThread thread, Socket socket) {
    putLog("Setting communication with client");    
  }

  @Override
  public void onSocketReady(SocketThread thread, Socket socket) {
    putLog("Client is ready to chat");
  }

  @Override
  public void onReceivedString(SocketThread thread, Socket socket, String msg) {
    ClientThread client = (ClientThread) thread;
    client.sendMessage(msg);
  }

  @Override
  public void onSocketStopped(SocketThread thread) {
    putLog("Client disconnected");
  }

  @Override
  public void onSocketException(SocketThread thread, Throwable e) {
    putLog("Oops! Exception happend");
    e.printStackTrace();
  }
}

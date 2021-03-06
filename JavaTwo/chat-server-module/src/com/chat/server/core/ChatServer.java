package com.chat.server.core;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import com.chat.library.Library;
import com.chat.network.*;

public class ChatServer implements ServerSocketThreadListener, SocketThreadListener {
  private ServerSocketThread server;
  private ChatServerListener listener;
  private Vector<SocketThread> clients = new Vector<>();
  
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
    SqlClient.connect();
  }

  @Override
  public void onServerStopped(ServerSocketThread thread) {
    putLog("Server stopped");
    for (int i = 0; i < clients.size(); i++) {
      clients.get(i).close();
    }
    SqlClient.disconnect();
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
    clients.add(thread);
  }
  
  @Override
  public void onSocketStopped(SocketThread thread) {
    ClientThread client = (ClientThread) thread;
    clients.remove(thread);
    if (client.isAuthorized() && !client.isReconnected()) {
      sendToAllAuthorizedClients(Library.getTypeBroadcast("Server speak ",
          client.getNickname() + " is no longer with us"));
    }
    putLog(client.getNickname() + " disconnected");
    sendToAllAuthorizedClients(Library.getUserList(getUsers()));
  }

  @Override
  public void onSocketException(SocketThread thread, Throwable e) {
    putLog("Oops! Exception happend");
    e.printStackTrace();
  }

  @Override
  public void onReceivedString(SocketThread thread, Socket socket, String msg) {
    ClientThread client = (ClientThread) thread;
    System.out.println(msg);
    if (client.isAuthorized()) {
      handleAuthorizedMessage(client, msg);
    } else {
      handleNonAuthorizedMassage(client, msg);
    }
  }
  
  private void handleNonAuthorizedMassage(ClientThread client, String msg) {
    String[] arr = msg.split(Library.DELIMITER);   
    if (arr.length != 3 || !arr[0].equals(Library.AUTH_REQUEST)) {
      client.msgFormatError(msg);
      return;
    }
    String login = arr[1];
    String password = arr[2];
    String nickname = SqlClient.getNickname(login, password);
    if (nickname == null) {
      putLog("Invalid credantials for user " + login);
      client.authFail();
      return;
    } else {
      ClientThread oldClient = findClientByNickname(nickname);
      client.authAccept(nickname);
      if (oldClient == null) {
        sendToAllAuthorizedClients(Library.getTypeBroadcast("Server speak ", nickname + " with us"));
      } else {
        oldClient.reconnect();
        clients.remove(oldClient);
      }
    }
    sendToAllAuthorizedClients(Library.getUserList(getUsers()));
  }
  
  private void handleAuthorizedMessage(ClientThread client, String msg) {
    String[] arr = msg.split(Library.DELIMITER);
    String msgType = arr[0];
    switch (msgType) {
      case Library.TYPE_BCAST_CLIENT:
        sendToAllAuthorizedClients(Library.getTypeBroadcast(client.getNickname(), arr[1]));
        break;
      default:
        client.sendMessage(Library.getMsgFormatError(msg));
    }
  }
  
  private synchronized void sendToAllAuthorizedClients(String msg) {
    for (int i = 0; i < clients.size(); i++) {
      ClientThread client = (ClientThread) clients.get(i);
      if (!client.isAuthorized()) continue;
      client.sendMessage(msg);
    }
  }
  
  private synchronized String getUsers() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < clients.size(); i++) {
      ClientThread client = (ClientThread) clients.get(i);
      if (!client.isAuthorized()) continue;
      sb.append(client.getNickname()).append(Library.DELIMITER);
    }
    return sb.toString();
  }
  
  private synchronized ClientThread findClientByNickname(String nickname) {
    for (int i = 0; i < clients.size(); i++) {
      ClientThread client = (ClientThread) clients.get(i);
      if (!client.isAuthorized()) continue;
      if (client.getNickname().equals(nickname)) return client;
    }
    return null;
  }
}

package com.chat.network;

import java.io.*;
import java.net.Socket;

public class SocketThread extends Thread {
  SocketThreadListener listener;
  Socket socket;
  DataInputStream in;
  DataOutputStream out;
  
  public SocketThread(SocketThreadListener listener, String name, Socket socket) {
    super(name);
    this.listener = listener;
    this.socket = socket;
    start();
  }
  
  @Override
  public void run() {
    try {
      listener.onSocketStarted(this, socket);
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      listener.onSocketReady(this, socket);
      while(!isInterrupted()) {
        String str = in.readUTF();
        listener.onReceivedString(this, socket, str);
      }
    } catch (IOException e) {
      listener.onSocketException(this, e);
    } finally {
      close();
      listener.onSocketStopped(this);
    }
  }

  public synchronized void close() {
    interrupt();
    try {
      socket.close();
    } catch (IOException e) {
      listener.onSocketException(this, e);
    }
  }
  
  public synchronized boolean sendMessage(String msg) {
    try {
      out.writeUTF(msg);
      out.flush();
      return true;
    } catch (IOException e) {
      listener.onSocketException(this, e);
      close();
      return false;
    }
  }

}

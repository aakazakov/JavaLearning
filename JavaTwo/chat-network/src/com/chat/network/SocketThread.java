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
      listener.onSocketStarted();
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      listener.onSocketReady();
      while(!isInterrupted()) {
        String str = in.readUTF();
        listener.onReceivedString(str);
      }
    } catch (IOException e) {
      listener.onSocketException();
    } finally {
      close();
      listener.onSocketStopped();
    }
  }

  protected synchronized void close() {
    interrupt();
    try {
      socket.close();
    } catch (IOException e) {
      listener.onSocketException();
    }
  }

}

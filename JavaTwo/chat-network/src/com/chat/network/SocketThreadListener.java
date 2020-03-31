package com.chat.network;

import java.net.Socket;

public interface SocketThreadListener {
  public void onSocketStarted(SocketThread thread, Socket socket);
  public void onSocketReady(SocketThread thread, Socket socket);
  public void onReceivedString(SocketThread thread, Socket socket, String str);
  public void onSocketStopped(SocketThread thread);
  public void onSocketException(SocketThread thread, Throwable e);
}

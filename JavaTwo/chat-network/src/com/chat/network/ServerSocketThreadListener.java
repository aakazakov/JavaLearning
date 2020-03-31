package com.chat.network;

import java.net.*;

public interface ServerSocketThreadListener {
  public void onServerStarted(ServerSocketThread thread);
  public void onServerStopped(ServerSocketThread thread);
  public void onServerSocketCreated(ServerSocketThread thread, ServerSocket server);
  public void onServerTimeOut(ServerSocketThread thread, ServerSocket server);
  public void onSocketAccepted(ServerSocketThread thread, ServerSocket server, Socket socket);
  public void onServerException(ServerSocketThread thread, Throwable exception);
}

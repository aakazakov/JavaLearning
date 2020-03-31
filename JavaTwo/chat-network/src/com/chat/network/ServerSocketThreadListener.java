package com.chat.network;

import java.net.*;

public interface ServerSocketThreadListener {
  public void onServerStarted();
  public void onServerStopped();
  public void onServerSocketCreated();
  public void onServerTimeOut();
  public void onSocketAccepted(ServerSocketThread thread, ServerSocket server, Socket socket);
  public void onServerException();
}

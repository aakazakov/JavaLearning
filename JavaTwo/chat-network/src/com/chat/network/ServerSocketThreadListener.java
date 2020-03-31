package com.chat.network;

public interface ServerSocketThreadListener {
  public void onServerStarted();
  public void onServerStopped();
  public void onServerSocketCreated();
  public void onServerTimeOut();
  public void onSocketAccepted();
  public void onServerException();
}

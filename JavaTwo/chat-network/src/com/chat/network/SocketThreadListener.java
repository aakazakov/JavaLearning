package com.chat.network;

public interface SocketThreadListener {
  public void onSocketStarted();
  public void onSocketReady();
  public void onReceivedString(String str);
  public void onSocketStopped();
  public void onSocketException();
}

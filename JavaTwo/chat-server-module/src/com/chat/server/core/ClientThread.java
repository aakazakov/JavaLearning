package com.chat.server.core;

import java.net.Socket;

import com.chat.library.*;
import com.chat.network.*;

public class ClientThread extends SocketThread {
  private String nickname;
  private boolean isAuthorized;
  private boolean isReconnected;

  public ClientThread(SocketThreadListener listener, String name, Socket socket) {
    super(listener, name, socket);
  }
  
  public void authAccept(String nickname) {
    isAuthorized = true;
    this.nickname = nickname;
    sendMessage(Library.getAuthAccept(nickname));
  }
  
  public void authFail() {
    sendMessage(Library.getAuthDenied());
    close();
  }
  
  public void reconnect() {
    isReconnected = true;
    close();
  }
  
  public void msgFormatError(String msg) {
    sendMessage(Library.getMsgFormatError(msg));
    close();
  }
  
  public String getNickname() {
    return nickname;
  }
  
  public boolean isAuthorized() {
    return isAuthorized;
  }
  
  public boolean isReconnected() {
    return isReconnected;
  }
}

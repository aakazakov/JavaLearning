package com.chat.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.text.*;
import java.util.Arrays;

import javax.swing.*;

import com.chat.library.Library;
import com.chat.library.exceptions.UnknownSourceException;
import com.chat.network.*;

public class ClientGUI extends JFrame implements ActionListener,
Thread.UncaughtExceptionHandler, SocketThreadListener {
  private static final long serialVersionUID = 1L;
  private static final int WIDTH = 400;
  private static final int HEIGHT = 300;
  private static final int USERS_LIST_WIDTH = WIDTH / 4;
  private static final int USERS_LIST_HEIGHT = 0;
  
  private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
  private final JTextField tfIPAdress = new JTextField("127.0.0.1");
  private final JTextField tfPort = new JTextField("8189");
  private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
  private final JTextField tfLogin = new JTextField("Login");
  private final JTextField tfPassword = new JTextField("Password");
  private final JButton btnLogin = new JButton("Login");
  
  private final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss: ");
  private final String WINDOW_TITLE = "Chat";
  
  private final JTextArea log = new JTextArea();
  private final JList<String> userList = new JList<>();
  
  private final JPanel panelBottom = new JPanel(new BorderLayout());
  private final JButton btnDisconnect = new JButton("Disconnect");
  private final JTextField tfMessage = new JTextField();
  private final JButton btnSend = new JButton("Send");
  
  private SocketThread socketThread;
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        new ClientGUI();
      }
    });
  }
  
  private ClientGUI() {
    Thread.setDefaultUncaughtExceptionHandler(this);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(WIDTH, HEIGHT);
    setTitle("Funny chat )");
    
    log.setEditable(false);
    JScrollPane scrollLog = new JScrollPane(log);
    JScrollPane scrollUsers = new JScrollPane(userList);
    scrollUsers.setPreferredSize(new Dimension(USERS_LIST_WIDTH, USERS_LIST_HEIGHT));
    
    panelTop.add(tfIPAdress);
    panelTop.add(tfPort);
    panelTop.add(cbAlwaysOnTop);
    panelTop.add(tfLogin);
    panelTop.add(tfPassword);
    panelTop.add(btnLogin);
    panelBottom.add(btnDisconnect, BorderLayout.WEST);
    panelBottom.add(tfMessage, BorderLayout.CENTER);
    panelBottom.add(btnSend, BorderLayout.EAST);
    
    add(scrollLog, BorderLayout.CENTER);
    add(scrollUsers, BorderLayout.EAST);
    add(panelTop, BorderLayout.NORTH);
    add(panelBottom, BorderLayout.SOUTH);
    
    cbAlwaysOnTop.addActionListener(this);
    btnLogin.addActionListener(this);
    btnDisconnect.addActionListener(this);
    btnSend.addActionListener(this);
    tfMessage.addActionListener(this);
    
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == cbAlwaysOnTop) {
      setAlwaysOnTop(cbAlwaysOnTop.isSelected());
    } else if (src == btnLogin) {
      connect();
    } else if (src == btnSend || src == tfMessage) {
      sendMessage();
    } else if (src == btnDisconnect) {
      socketThread.close();
    } else {
      throw new UnknownSourceException("Unknown source: " + src);
    }
  }

  private void connect() {   
    try {
      Socket socket = new Socket(tfIPAdress.getText(), Integer.parseInt(tfPort.getText()));
      socketThread = new SocketThread(this, "Client", socket);
    } catch (NumberFormatException | IOException e) {
      showException(Thread.currentThread(), e);
    }
  }
  
  private void sendMessage() {
    String msg = tfMessage.getText();
    if (msg.isEmpty()) return;
    tfMessage.setText(null);
    tfMessage.grabFocus();
    socketThread.sendMessage(Library.getTypeBcastClient(msg));
  }

  private void putLog(String msg) {
    if (msg.isEmpty()) return;
    SwingUtilities.invokeLater(() ->
      log.append(msg + "\n")
    );
  }

  
  private void showException(Thread t, Throwable e) {
    String msg;
    StackTraceElement[] ste = e.getStackTrace();
    if (ste.length == 0) {
      msg = "No stack trace";
    } else {
      msg = "Exception in thread " + t.getName() + " " + e.getClass().getCanonicalName() + ": "
    + e.getMessage() + "\n\t" + ste[0];
    }
    JOptionPane.showMessageDialog(null, msg, "Oops!", JOptionPane.ERROR_MESSAGE);
  }
  
  @Override
  public void uncaughtException(Thread t, Throwable e) {
    e.printStackTrace();
    showException(t, e);
    System.exit(1);
  }

  @Override
  public void onSocketStarted(SocketThread thread, Socket socket) {
    putLog("Launch...");
  }

  @Override
  public void onSocketReady(SocketThread thread, Socket socket) {
    putLog("Ready");
    panelBottom.setVisible(true);
    panelTop.setVisible(false);
    String login = tfLogin.getText();
    String password = tfPassword.getText();
    thread.sendMessage(Library.getAuthRequest(login, password));
  }

  @Override
  public void onReceivedString(SocketThread thread, Socket socket, String msg) {
    String[] arr = msg.split(Library.DELIMITER);
    String msgType = arr[0];
    switch (msgType) {
      case Library.AUTH_ACCEPT:
        setTitle(WINDOW_TITLE + " entered with nickname: " + arr[1]);
        break;
      case Library.AUTH_DENIED:
        putLog("Authentication failed");
        break;
      case Library.MSG_FORMAT_ERROR:
        putLog(msg);
        socketThread.close();
        break;
      case Library.TYPE_BROADCAST:
        putLog(DATE_FORMAT.format(Long.parseLong(arr[1])) +
          arr[2] + ": " + arr[3]);
        break;
      case Library.USER_LIST:
        String users = msg.substring(Library.USER_LIST.length() +
          Library.DELIMITER.length());
        String[] usersArr = users.split(Library.DELIMITER);
        Arrays.sort(usersArr);
        userList.setListData(usersArr);
        break;     
      default:
        throw new RuntimeException("Unknown message type: " + msg);
    }
  }

  @Override
  public void onSocketStopped(SocketThread thread) {
    putLog("Stopped");
    panelBottom.setVisible(false);
    panelTop.setVisible(true);
    setTitle(WINDOW_TITLE);
    userList.setListData(new String[0]);
  }

  @Override
  public void onSocketException(SocketThread thread, Throwable e) {
    showException(thread, e);
  }
}

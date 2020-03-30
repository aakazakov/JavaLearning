package com.chat.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.chat.library.exceptions.UnknownSourceException;

public class ClientGUI extends JFrame implements ActionListener,
Thread.UncaughtExceptionHandler {
  private static final int WIDTH = 400;
  private static final int HEIGHT = 300;
  private static final int USERS_LIST_WIDTH = WIDTH / 4;
  private static final int USERS_LIST_HEIGHT = 0;
  
  private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
  private final JTextField tfIPAdress = new JTextField("127.0.0.1");
  private final JTextField tfPort = new JTextField("8080");
  private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
  private final JTextField tfLogin = new JTextField("User");
  private final JTextField tfPassword = new JTextField("123");
  private final JButton btnLogin = new JButton("Login");
  
  private final JTextArea log = new JTextArea();
  private final JList<String> userList = new JList<>();
  
  private final JPanel panelBottom = new JPanel(new BorderLayout());
  private final JButton btnDisconnect = new JButton("Disconnect");
  private final JTextField tfMessage = new JTextField();
  private final JButton btnSend = new JButton("Send");
  
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
    
    String[] users = {"User1", "User2", "User3", "User4",
        "user_with_an_exceptionally_very_super_long_name"};
    userList.setListData(users);
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
    btnSend.addActionListener(this);
    tfMessage.addActionListener(this);
    
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == cbAlwaysOnTop) {
      setAlwaysOnTop(cbAlwaysOnTop.isSelected());
    } else if (src == btnSend || src == tfMessage) {
      sendMassage();
    } else {
      throw new UnknownSourceException("Unknown source: " + src);
    }
  }

  private void sendMassage() {
    if (getMessage().isEmpty()) return;
    String str = String.format("%s: %s%n", getUserName(), getMessage());
    appendToLogField(str);
    clearMessageField();
    stayFocusedOnMessageField();
  }
  
  private String getMessage() {
    return tfMessage.getText();
  }
  
  private String getUserName() {
    return tfLogin.getText();
  }
  
  private void appendToLogField(String str) {
    SwingUtilities.invokeLater(() -> 
      log.append(str)
    );
  }
  
  private void clearMessageField() {
    tfMessage.setText(null);
  }
  
  private void stayFocusedOnMessageField() {
    tfMessage.grabFocus();
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
}

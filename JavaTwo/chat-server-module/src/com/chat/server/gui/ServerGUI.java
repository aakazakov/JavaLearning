package com.chat.server.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import com.chat.library.exceptions.UnknownSourceException;
import com.chat.server.core.*;

public class ServerGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler, ChatServerListener {
  private static final int POS_X = 800;
  private static final int POS_Y = 200;
  private static final int WIDTH = 600;
  private static final int HEIGHT = 300;
  
  private final ChatServer chatServer = new ChatServer(this::onChatServerMessage);
  private final JButton btnStart = new JButton("Start");
  private final JButton btnStop = new JButton("Stop");
  private final JPanel panelTop = new JPanel(new GridLayout(1, 2));
  private final JTextArea log = new JTextArea();
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        new ServerGUI();
      }
    });
  }
  
  private ServerGUI() {
    Thread.setDefaultUncaughtExceptionHandler(this);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
    setTitle("Chat server");
    setAlwaysOnTop(true);
    
    btnStart.addActionListener(this);
    btnStop.addActionListener(this);
    
    log.setEditable(false);
    log.setLineWrap(true);
    JScrollPane scrollLog = new JScrollPane(log);
    
    panelTop.add(btnStart);
    panelTop.add(btnStop);
    add(panelTop, BorderLayout.NORTH);
    add(scrollLog, BorderLayout.CENTER);
    
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == btnStart) {
      chatServer.start(8189);
    } else if (src == btnStop) {
      chatServer.stop();
    } else {
      throw new UnknownSourceException("Unknown source: " + src);
    }
  }
  
  @Override
  public void uncaughtException(Thread t, Throwable e) {
    e.printStackTrace();
    StackTraceElement[] ste = e.getStackTrace();
    String msg = "Exception in thread " + t.getName() + " " + e.getClass().getCanonicalName() + ": "
        + e.getMessage() + "\n\t" + ste[0];
    JOptionPane.showMessageDialog(null, msg, "Oops!", JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void onChatServerMessage(String msg) {
    SwingUtilities.invokeLater(() ->
      log.append(msg + "\n")
    );
  }
  
}

package chat.server.gui;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import chat.exceptions.UnknownSourceException;
import chat.server.core.ChatServer;

public class ServerGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
  private static final int POS_X = 1000;
  private static final int POS_Y = 550;
  private static final int WIDTH = 200;
  private static final int HEIGHT = 100;
  
  private final ChatServer chatServer = new ChatServer();
  private final JButton btnStart = new JButton("Start");
  private final JButton btnStop = new JButton("Stop");
  
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
    setResizable(false);
    setTitle("Chat server");
    setAlwaysOnTop(true);
    setLayout(new GridLayout(1, 2));
    
    btnStart.addActionListener(this);
    btnStop.addActionListener(this);
    add(btnStart);
    add(btnStop);
    
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == btnStart) {
      chatServer.start(8080);
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
  
}

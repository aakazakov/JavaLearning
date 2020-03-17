package chat.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;

import javax.swing.*;

import chat.exceptions.FileWritingException;
import chat.exceptions.UnknownSourceException;

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
    tfMessage.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          messageHandler();
        }
      }
    });
    
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object src = e.getSource();
    if (src == cbAlwaysOnTop) {
      setAlwaysOnTop(cbAlwaysOnTop.isSelected());
    } else if (src == btnSend) {
      messageHandler();
    } else {
      throw new UnknownSourceException("Unknown source: " + src);
    }
  }

  private void messageHandler() {
      String msg = getMessage();
      appendToLogField(msg);
      
      try {
        writeMessageTo("log.txt", msg);
      } catch (FileWritingException e) {
        e.printStackTrace();
      }
      
      clearMessageField();
  }
  
  private String getMessage() {
    return tfMessage.getText();
  }
  
  private void appendToLogField(String str) {
    if (str.isEmpty()) { return; }
    log.append(str + "\n");
  }
  
  private void writeMessageTo(String path, String msg) throws FileWritingException {
    try (FileWriter fw = new FileWriter(path)) {
      fw.write(msg + "\n");
    } catch (Exception e) {
      throw new FileWritingException(path);
    }
  }
  
  private void clearMessageField() {
    tfMessage.setText("");
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
package tic_tac_toe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class TicTacToe extends JFrame {
  static final int WINDOW_X = 800;
  static final int WINDOW_Y = 200;
  static final int WINDOW_WIDTH = 500;
  static final int WINDOW_HEIGHT = 550;
  
  private GameSettingsWindow gsw;
  private GameField field;

  public TicTacToe() {
    setTitle("Tic Tac Toe");
    setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel(new GridLayout(1, 1));
    JButton start = new JButton("Start the game");
    start.setBackground(Color.GRAY);
    panel.add(start);
    add(panel, BorderLayout.SOUTH);
    gsw = new GameSettingsWindow(this);
    start.addActionListener(e -> 
      gsw.setVisible(true)
    );
    
    field = new GameField();
    add(field, BorderLayout.CENTER);
    
    
    setVisible(true);
  }
  
  public void takeGameSettings(int level, int fieldSize, int winLength) {
    System.out.println(level + " " + fieldSize + " " + winLength);
  }
}

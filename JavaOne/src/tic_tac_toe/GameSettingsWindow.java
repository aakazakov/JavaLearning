package tic_tac_toe;

import javax.swing.*;

public class GameSettingsWindow extends JFrame {
  private int windowX = TicTacToe.WINDOW_X + TicTacToe.WINDOW_WIDTH / 10;
  private int windowY = TicTacToe.WINDOW_Y + TicTacToe.WINDOW_HEIGHT / 10;
  private int windowW = TicTacToe.WINDOW_WIDTH * 8 / 10;
  private int windowH = TicTacToe.WINDOW_HEIGHT * 8 / 10;
  
  public GameSettingsWindow() {
    setTitle("Tic Tac Toe");
    setBounds(windowX, windowY, windowW, windowH);
    
    setVisible(false);
  }
}

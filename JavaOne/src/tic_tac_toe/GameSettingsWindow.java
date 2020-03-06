package tic_tac_toe;

import java.awt.GridLayout;

import javax.swing.*;

public class GameSettingsWindow extends JFrame {
  private final int MIN_FIELD_SIZE = 3;
  private final int MAX_FIELD_SIZE = 10;
  private final int MIN_WIN_LENGTH = 3;
  private final int MAX_WIN_LENGTH = 10;
  
  private int windowX;
  private int windowY;
  private int windowW;
  private int windowH;
  
  private JRadioButton hardLevel;
  private JRadioButton middleLevel;
  private JRadioButton easyLevel;
  private ButtonGroup levels;
  private JSlider fieldSize;
  private JSlider winLength;
  
  public GameSettingsWindow() {
    windowX = TicTacToe.WINDOW_X + TicTacToe.WINDOW_WIDTH / 10;
    windowY = TicTacToe.WINDOW_Y + TicTacToe.WINDOW_HEIGHT / 10;
    windowW = TicTacToe.WINDOW_WIDTH * 8 / 10;
    windowH = TicTacToe.WINDOW_HEIGHT * 8 / 10;   
    setTitle("Game settings");
    setBounds(windowX, windowY, windowW, windowH);
    setLayout(new GridLayout(8, 1));
    hardLevel = new JRadioButton("Hard", true);
    middleLevel = new JRadioButton("Middle");
    easyLevel = new JRadioButton("Easy");
    levels = new ButtonGroup();
    levels.add(hardLevel);
    levels.add(middleLevel);
    levels.add(easyLevel);
    add(hardLevel);
    add(middleLevel);
    add(easyLevel);
    fieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    winLength = new JSlider(MIN_WIN_LENGTH, MIN_WIN_LENGTH, MIN_WIN_LENGTH);
    add(fieldSize);
    add(winLength);
    setVisible(false);
  }
}

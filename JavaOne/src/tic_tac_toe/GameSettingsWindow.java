package tic_tac_toe;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GameSettingsWindow extends JFrame {
  private static final int MIN_FIELD_SIZE = 3;
  private static final int MAX_FIELD_SIZE = 10;
  private static final int MIN_WIN_LENGTH = 3;
  private static final int MAX_WIN_LENGTH = MIN_WIN_LENGTH;
  
  private final TicTacToe mainWindow;
  
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
  
  public GameSettingsWindow(TicTacToe mainWindow) {
    this.mainWindow = mainWindow;
    windowX = TicTacToe.WINDOW_X + TicTacToe.WINDOW_WIDTH / 10;
    windowY = TicTacToe.WINDOW_Y + TicTacToe.WINDOW_HEIGHT / 10;
    windowW = TicTacToe.WINDOW_WIDTH * 8 / 10;
    windowH = TicTacToe.WINDOW_HEIGHT * 8 / 10;   
    setTitle("Game settings");
    setBounds(windowX, windowY, windowW, windowH);
    setLayout(new GridLayout(9, 1));
    
    hardLevel = new JRadioButton("Hard", true);
    middleLevel = new JRadioButton("Middle");
    easyLevel = new JRadioButton("Easy");
    levels = new ButtonGroup();
    levels.add(hardLevel);
    levels.add(middleLevel);
    levels.add(easyLevel);
    add(new JLabel("=== Choose game level: ==="));
    add(hardLevel);
    add(middleLevel);
    add(easyLevel);
    
    fieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    fieldSize.setMajorTickSpacing(1);
    fieldSize.setPaintTicks(true);
    fieldSize.setPaintLabels(true);
    add(new JLabel("=== Choose field size: ==="));
    add(fieldSize);
    fieldSize.addChangeListener(e -> {
      int currentSize = fieldSize.getValue();
      winLength.setMaximum(currentSize);
    });   
    
    winLength = new JSlider(MIN_WIN_LENGTH, MAX_WIN_LENGTH, MIN_WIN_LENGTH);
    winLength.setMajorTickSpacing(1);
    winLength.setPaintTicks(true);
    winLength.setPaintLabels(true);
    add(new JLabel("=== Choose win line lenght: ==="));
    add(winLength);
    
    JButton settingsOk = new JButton("Ok");
    add(settingsOk);
    settingsOk.addActionListener(e -> {
      int level = getLevel();
      int fSize = fieldSize.getValue();
      int wLength = winLength.getValue();
      mainWindow.takeGameSettings(level, fSize, wLength);
      setVisible(false);
    });
    
    setVisible(false);
  }
  
  private int getLevel() {
    if (hardLevel.isSelected()) { return 3; }
    if (middleLevel.isSelected()) { return 2; }
    return 1;
  }
}

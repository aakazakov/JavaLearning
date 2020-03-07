package tic_tac_toe;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class GameField extends JPanel {
  private int cellSide;
  private int fieldSize;
  private int winLength;
  private boolean isInit = false;
  
  public GameField() {
    setBackground(Color.DARK_GRAY);
    
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        clickHandler(e);
      }
    });
  }
  
  public void takeGameSettings(int fieldSize, int winLength) {
    this.fieldSize = fieldSize;
    this.winLength = winLength;
    isInit = true;
    repaint();
  }
  
  private void clickHandler(MouseEvent e) {
    int clickX = e.getX() / cellSide;
    int clickY = e.getY() / cellSide;
    if (!GameLogic.gameOver) {
      GameLogic.setHumanTurnParams(clickX, clickY);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    render(g);
  }
  
  private void render (Graphics g) {
    if (isInit) {
      int panelSize = getWidth();
      cellSide = panelSize / fieldSize;
      for (int i = 0; i < fieldSize; i++) {
        int x = i * cellSide;
        int y = x;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3f));
        g2.drawLine(x, 0, x, panelSize);
        g2.drawLine(0, y, panelSize, y);
        g2.setColor(Color.GRAY);        
      }
    }
  }
}

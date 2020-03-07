package tic_tac_toe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameField extends JPanel {
  private int cellSideSize;
  private int level;
  private int fieldSize;
  private int winLength;
  private boolean isInit = false;
  
  public GameField() {
    setBackground(Color.DARK_GRAY);
  }
  
  public void takeGameSettings(int level, int fieldSize, int winLength) {
    this.level = level;
    this.fieldSize = fieldSize;
    this.winLength = winLength;
    isInit = true;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    render(g);
  }
  
  private void render (Graphics g) {
    if (isInit) {
      int panelSideSize = getWidth();
      cellSideSize = panelSideSize / fieldSize;
      for (int i = 0; i < fieldSize; i++) {
        int x = i * cellSideSize;
        int y = x;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3f));
        g2.drawLine(x, 0, x, panelSideSize);
        g2.drawLine(0, y, panelSideSize, y);
        g2.setColor(Color.GRAY);        
      }
    }
  }
}

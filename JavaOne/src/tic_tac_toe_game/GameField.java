package tic_tac_toe_game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

public class GameField extends JPanel {
  private int cellSide;
  private int fieldSize;
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
    isInit = true;
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
    repaint();
  }
  
  private void render(Graphics g) {
    if (isInit) {
      int panelSize = getWidth();
      cellSide = panelSize / fieldSize;
      Graphics2D g2 = (Graphics2D) g;
      for (int i = 0; i < fieldSize; i++) {
        int x = i * cellSide;
        int y = x;
        g2.setStroke(new BasicStroke(3f));
        g2.drawLine(x, 0, x, panelSize);
        g2.drawLine(0, y, panelSize, y);
        g2.setColor(Color.GRAY);
      }
      
      for (int i = 0; i < fieldSize; i++) {
        for (int j = 0; j < fieldSize; j++) {
          if (GameLogic.field[i][j] ==  GameLogic.CHAR_X) {
            drawCross(g2, j, i);
          }
          if (GameLogic.field[i][j] ==  GameLogic.CHAR_O) {
            drawRound(g2, j, i);
          }
        }
      }
    }
  }
  
  void drawCross(Graphics2D g2, int x, int y) {
    g2.setStroke(new BasicStroke(5f));
    g2.drawLine(x * cellSide, y * cellSide, (x + 1) * cellSide, (y + 1) * cellSide);
    g2.drawLine(x * cellSide, (y + 1) * cellSide, (x + 1) * cellSide, y * cellSide);
  }
  
  void drawRound(Graphics2D g2, int x, int y) {
    g2.setStroke(new BasicStroke(5f));
    g2.drawOval(x * cellSide, y * cellSide, cellSide, cellSide);
  }

}

package circles;

import java.awt.Graphics;

import javax.swing.*;

public class MainCircles extends JFrame {
  private static final int POS_X = 400;
  private static final int POS_Y = 200;
  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;
  
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        new MainCircles();
      }
    });
  }
  
  private MainCircles() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
    setTitle("Circles");
    MainCanvas canvas = new MainCanvas(this);
    add(canvas);
    setVisible(true);
  }
  
  public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
    update(canvas, deltaTime);
    render(canvas, g);
  }
  
  private void update(MainCanvas canvas, float deltaTime) {
    for (int i = 0; i < sprites.length; i++) {
        sprites[i].update(canvas, deltaTime);
    }
  }

  private void render(MainCanvas canvas, Graphics g) {
      for (int i = 0; i < sprites.length; i++) {
          sprites[i].render(canvas, g);
      }
  }

}

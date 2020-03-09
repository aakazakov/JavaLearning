package circles;

import java.awt.Graphics;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class MainCircles extends JFrame {
  private static final int POS_X = 400;
  private static final int POS_Y = 200;
  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;
  
  private Sprite[] sprites = new Sprite[10];
  private int spritesCount;
  
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
    initApplication();
    MainCanvas canvas = new MainCanvas(this);
    add(canvas);
    
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
          addSprite(new Circle(e.getX(), e.getY()));
        }
        if (e.getButton() == 3) {
          removeSprite();
        }
      }
    });
    
    setVisible(true);
  }
  
  private void initApplication() {
    sprites[0] =  new Background();
    for (int i = 1; i < sprites.length; i++) {
        sprites[i] = new Circle();
        spritesCount++;
    }
  }
  
  private void addSprite(Sprite s) {
    if (!isThereSpaceIn(sprites)) {
      sprites = Arrays.copyOf(sprites, sprites.length * 2);
    }
    sprites[spritesCount++] = s;
  }
  
  private void removeSprite() {
    if (spritesCount > 1) {
      spritesCount--;
    } 
  }
  
  private boolean isThereSpaceIn(Sprite[] sprites) {
    return spritesCount < sprites.length;
  }
  
  
  
  public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
    update(canvas, deltaTime);
    render(canvas, g);
  }
  
  private void update(MainCanvas canvas, float deltaTime) {
    for (int i = 0; i < spritesCount; i++) {
      sprites[i].update(canvas, deltaTime);
    }
  }

  private void render(MainCanvas canvas, Graphics g) {
      for (int i = 0; i < spritesCount; i++) {
        sprites[i].render(canvas, g);
      }
  }

}

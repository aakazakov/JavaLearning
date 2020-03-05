package circles;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.*;

public class MainCircles extends JFrame {
  private static final int POS_X = 400;
  private static final int POS_Y = 200;
  private static final int WINDOW_WIDTH = 800;
  private static final int WINDOW_HEIGHT = 600;
  
  private Sprite[] sprites = new Sprite[10];
  private Background bg;
  
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
        addBall();
      }
    });
    
    setVisible(true);
  }
  
  private void initApplication() {
    bg = new Background();
    for (int i = 0; i < sprites.length; i++) {
        sprites[i] = new Ball();
    }
  }
  
  private void addBall() {
    if (isEmptyArray(sprites)) {
      for (int i = sprites.length - 1; i >= 0; i--) {
        if (sprites[i] == null
            && (i == 0 || sprites[i - 1] != null)) {
          sprites[i] = new Ball();
        }
      }
    } else {      
      sprites = Arrays.copyOf(sprites, sprites.length * 2);
    }
  }
  
  private boolean isEmptyArray(Sprite[] arr) {
    return arr[arr.length - 1] == null;
  }
  
  public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
    update(canvas, deltaTime);
    render(canvas, g);
  }
  
  private void update(MainCanvas canvas, float deltaTime) {
    bg.update(canvas, deltaTime);
    for (int i = 0; i < sprites.length; i++) {
      if (sprites[i] == null) { break; }
      sprites[i].update(canvas, deltaTime);
    }
  }

  private void render(MainCanvas canvas, Graphics g) {
      bg.render(canvas, g);
      for (int i = 0; i < sprites.length; i++) {
        if (sprites[i] == null) { break; }
        sprites[i].render(canvas, g);
      }
  }

}

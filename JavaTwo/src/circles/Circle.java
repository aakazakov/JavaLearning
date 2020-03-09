package circles;

import java.awt.*;

public class Circle extends Sprite {
  private final Color color = getRandomColor();
  private float vX = (float) (100f + (Math.random() * 200f));
  private float vY = (float) (100f + (Math.random() * 200f));
  
  Circle() {
    halfHeight = 20 + (float) (Math.random() * 50f);
    halfWidth = halfHeight;
  }
  
  Circle(int x, int y) {
    this();
    this.x = x;
    this.y = y;
  }

  @Override
  public void update(MainCanvas canvas, float deltaTime) {
    x += vX * deltaTime;
    y += vY * deltaTime;
    if (getLeft() < canvas.getLeft()) {
        setLeft(canvas.getLeft());
        vX = -vX;
    }
    if (getRight() > canvas.getRight()) {
        setRight(canvas.getRight());
        vX = -vX;
    }
    if (getTop() < canvas.getTop()) {
        setTop(canvas.getTop());
        vY = -vY;
    }
    if (getBottom() > canvas.getBottom()) {
        setBottom(canvas.getBottom());
        vY = -vY;
    }   
  }

  @Override
  public void render(MainCanvas canvas, Graphics g) {
    g.setColor(color);
    g.fillOval((int) getLeft(), (int) getTop(),
            (int) getWidth(), (int) getHeight());    
  }
  
}

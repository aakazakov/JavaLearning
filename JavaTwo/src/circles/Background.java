package circles;

import java.awt.*;

public class Background extends Sprite {
  private Color color;
  private float deltaTime;
  
  public Background(float deltaTime) {
    color = getRandomColor();
    this.deltaTime = deltaTime;
  }

  @Override
  public void update(MainCanvas canvas, float deltaTime) {
    x = halfWidth;
    y = halfHeight;
  }

  @Override
  public void render(MainCanvas canvas, Graphics g) {
    g.setColor(color);
    g.fillRect((int) x, (int) y, (int) getWidth(), (int) getHeight());
  }

}

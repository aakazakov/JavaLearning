package circles;

import java.awt.*;

public class Background extends Sprite {
  private Color color;
  private float deltaTime;
  
  public Background(float deltaTime) {
    color = getRandomColor();
    this.deltaTime = deltaTime;
    x = 0;
    y = 0;
  }

  @Override
  public void update(MainCanvas canvas, float deltaTime) {
    x = 0;
    y = 0;
  }

  @Override
  public void render(MainCanvas canvas, Graphics g) {
    g.setColor(color);
    g.fillRect((int) x, (int) y, (int) 800f, (int) 600f);
  }

}

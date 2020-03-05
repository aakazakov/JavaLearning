package circles;

import java.awt.*;

public class Background extends Sprite {
  private float multiplier;
  private long initialTime;
  private Color color;
  
  public Background() {
    initialTime = System.nanoTime();
    multiplier = 100;
    color = getRandomColor();
  }

  @Override
  public void update(MainCanvas canvas, float deltaTime) {
    long currentTime = System.nanoTime();
    float timePeriod = (currentTime - initialTime) * 0.000000001f;
    if (timePeriod >= deltaTime * multiplier) {
      color = getRandomColor();
      initialTime = currentTime;
    }    
  }

  @Override
  public void render(MainCanvas canvas, Graphics g) {
    g.setColor(color);
    g.fillRect(0, 0, 800, 600);    
  }
  
}

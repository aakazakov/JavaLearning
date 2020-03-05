package circles;

import java.awt.*;

public class Background extends Sprite {
  private float multiplier;
  private Color color;
  private long initialTime;
  
  public Background() {
    multiplier = 100;
    color = getRandomColor();
    initialTime = System.nanoTime();
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
    g.fillRect(canvas.getLeft(), canvas.getTop(),
        canvas.getWidth(), canvas.getHeight());
  }
  
}

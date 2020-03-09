package circles;

import java.awt.*;

public class Background extends Sprite {
  private static final float AMPLITUDE = 255f / 2f;
  private float time;
  private Color color;

  @Override
  public void update(MainCanvas canvas, float deltaTime) {
    time += deltaTime;
    int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time / 6));
    int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time / 4));
    int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time / 2));
    color = new Color(red, green, blue);
  }

  @Override
  public void render(MainCanvas canvas, Graphics g) {
    g.setColor(color);
    g.fillRect(canvas.getLeft(), canvas.getTop(),
        canvas.getWidth(), canvas.getHeight());
  }
}

package circles;

import java.awt.*;

public class Background implements FormedObject {
  private static final float AMPLITUDE = 255f / 2f;
  private float time;
  private Color color;

  @Override
  public void update(MainCanvas canvas, float deltaTime) {
    time += deltaTime;
    int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
    int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time / 4));
    int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time / 5));
    color = new Color(red, green, blue);
  }

  @Override
  public void render(MainCanvas canvas, Graphics g) {
    canvas.setBackground(color);
  }
}

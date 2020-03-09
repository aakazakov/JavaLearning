package circles;

import java.awt.Graphics;

public interface FormedObject {
  void update(MainCanvas canvas, float deltaTime);
  void render(MainCanvas canvas, Graphics g);
}

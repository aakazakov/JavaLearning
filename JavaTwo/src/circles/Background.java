package circles;

import javax.swing.JPanel;

public class Background {
  private float multiplier; 
  private JPanel p;
  private long initialTime;
  
  public Background(JPanel p) {
    initialTime = System.nanoTime();
    multiplier = 100;
    this.p = p;
    setColor();
  }
  
  public void setColor() {
    p.setBackground(Sprite.getRandomColor());
  }
  
  public void changeColor(float time) {
    long currentTime = System.nanoTime();
    float deltaTime = (currentTime - initialTime) * 0.000000001f;
    if (deltaTime >= time * multiplier) {
      setColor();
      initialTime = currentTime;
    }    
  }
}

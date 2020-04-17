package homework.race;

public class Tunnel extends Stage {
  
  public Tunnel() {
    this.length = 80;
    this.description = "tunnel " + length + "m";
  }
  
  @Override
  public void go(Car car) {
    try {
      try {
        System.out.println(car.getName() + " is getting started stage (waiting...): " + description);
        System.out.println(car.getName() + " started stage: " + description);
        Thread.sleep(length / car.getSpeed() * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println(car.getName() + " ended stage: " + description);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

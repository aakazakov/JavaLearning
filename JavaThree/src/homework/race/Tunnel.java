package homework.race;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
  private Semaphore semaphore = new Semaphore((int) Launcher.NUMBER_OF_CARS / 2);
  
  public Tunnel(int length) {
    this.length = length;
    this.description = "tunnel " + length + "m";
  }
  
  @Override
  public void go(Car car) {
    try {
      try {
        System.out.println(car.getName() + " is getting started stage (waiting...): " + description);
        semaphore.acquire();
        System.out.println(car.getName() + " started stage: " + description);
        Thread.sleep(length / car.getSpeed() * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println(car.getName() + " ended stage: " + description);
        semaphore.release();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

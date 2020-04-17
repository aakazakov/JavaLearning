package homework.race;

import java.util.concurrent.*;

public class Car implements Runnable {
  private static final CountDownLatch LATCH = new CountDownLatch(Launcher.NUMBER_OF_CARS);
  private Race race;
  private int speed;
  private String name;
  
  public Car(Race race, int speed, String name) {
    this.race = race;
    this.speed = speed;
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public int getSpeed() {
    return speed;
  }

  @Override
  public void run() {
    try {
      System.out.println(this.name + " is getting ready...");
      Thread.sleep(500 + (int)(Math.random() * 800));
      System.out.println(this.name + " is ready...");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    LATCH.countDown();
    try {
      LATCH.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < race.getStages().size(); i++) {
      race.getStages().get(i).go(this);
    }
  }
}

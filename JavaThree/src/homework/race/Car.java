package homework.race;

import java.util.concurrent.*;

public class Car implements Runnable {
  private static final CountDownLatch LATCH = new CountDownLatch(Launcher.NUMBER_OF_CARS + 1);
  private Track track;
  private int speed;
  private String name;
  
  public Car(Track race, int speed, String name) {
    this.track = race;
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
    for (int i = 0; i < track.getStages().size(); i++) {
      track.getStages().get(i).go(this);
    }
  }
  
  public static boolean areAllCarsReadyToStart() {
    return (int) LATCH.getCount() == 1;
  }
  
  public static void launch() {
    LATCH.countDown();
  }
}

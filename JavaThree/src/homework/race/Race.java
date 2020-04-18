package homework.race;

import java.util.concurrent.*;

public class Race {
  private Car[] cars = new Car[Launcher.NUMBER_OF_CARS];
  private ExecutorService pool = Executors.newFixedThreadPool(Launcher.NUMBER_OF_CARS, (Runnable r) -> new Thread(r));
  private Track track;
  
  public Race(Track track) {
    this.track = track;
  }

  public void init() {
    System.out.println("== Preparation ==");
    executeCarsFromPool();
    
    while (true) {
      if (Car.areAllCarsReadyToStart()) {
        System.out.println("== Race started ==");
        Car.launch();
        break;
      }
    }
    
    while (true) {
      if (pool.isTerminated()) {
        System.out.println("== Race ended ==");
        break;
      }
    }
  }
  
  private void executeCarsFromPool() {
    createCars();
    for (int i = 0; i < cars.length; i++) {
      pool.execute(cars[i]);
    }
    pool.shutdown();
  }
  
  private void createCars() {
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(track, 20 + (int) (Math.random() * 10), "Car #" + (i + 1));
    }
  }
  
}

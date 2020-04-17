package homework.race;

import java.util.concurrent.*;

public class Launcher {
  static final int NUMBER_OF_CARS = 4;

  public static void main(String[] args) {
    System.out.println("== Preparation ==");
    
    Race race = new Race(new Road(60), new Tunnel(), new Road(40), new Finish());
    Car[] cars = new Car[NUMBER_OF_CARS]; 
    
    ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_CARS, new ThreadFactory() {
      
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r);
      }
    });
    
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 20 + (int) (Math.random() * 10), "Car #" + (i + 1));
    }
    for (int i = 0; i < cars.length; i++) {
      pool.execute(cars[i]);
    }
    
    pool.shutdown();
    
    System.out.println("== Race started ==");
    System.out.println("== Race ended ==");
  }

}

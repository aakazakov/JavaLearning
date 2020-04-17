package homework.race;

public class Launcher {
  private static final int NUMBER_OF_CARS = 4;

  public static void main(String[] args) {
    System.out.println("== Preparation ==");
    Race race = new Race(new Road(60), new Tunnel(), new Road(40));
    Car[] cars = new Car[NUMBER_OF_CARS];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 20 + (int) (Math.random() * 10), "Car #" + (i + 1));
    }
    for (int i = 0; i < cars.length; i++) {
      new Thread(cars[i]).start();
    }
    System.out.println("== Race started ==");
    System.out.println("== Race ended ==");
  }

}

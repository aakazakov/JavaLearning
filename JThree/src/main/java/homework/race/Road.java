package homework.race;

public class Road extends Stage {
  
  public Road(int length) {
    this.length = length;
    this.description = "road " + length + "m";
  }

  @Override
  public void go(Car car) {
    try {
      System.out.println(car.getName() + " started stage: " + description);
      Thread.sleep(length / car.getSpeed() * 1000);
      System.out.println(car.getName() + " ended stage: " + description);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

package practice7;

public class Plate {
  private int food;
  
  public Plate(int food) {
    this.food = food;
  }
  
  public void info() {
    System.out.printf("Food on the plate: %d.%n", food);
  }
  
  public boolean decreaseFood(int amount) {
    if (food >= amount) {
      food -= amount;
      return true;
    }
    return false;
  }
  
  public void increaseFood(int amount) {
    food += amount;
  }
}

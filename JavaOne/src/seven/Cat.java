package seven;

public class Cat {
  private String name;
  private int appetite;
  private boolean full;

  public Cat(String name, int appetite) {
    this.name = name;
    this.appetite = appetite;
    this.full = false;
  }

  public void eat(Plate plateOfFood) {
    full = plateOfFood.decreaseFood(appetite);
    printDidTheCatEat();
  }
  
  private void printDidTheCatEat() {
    if (full) {
      System.out.println(name + " ate.");
    } else {
      System.out.println(name + " is not full. Need more food.");
    }
  }
  
  public boolean isFull() {
    return full;
  }
}

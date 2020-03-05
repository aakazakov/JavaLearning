package seven;

public class Homework {

  public static void main(String[] args) {  
    Plate plateOfFood = new Plate(40);
    Cat[] hungryCats = {
        new Cat("Joker", 15),
        new Cat("Bars", 25),
        new Cat("Kitty", 5),
        new Cat("Snow", 10),
        new Cat("Cat", 15)        
    };
    
    plateOfFood.info();
    System.out.println();
    
    feed(hungryCats, plateOfFood);
    
    plateOfFood.info();
  }
  
  public static void feed(Cat[] cats, Plate plateOfFood) {
    for (Cat cat : cats) {
      cat.eat(plateOfFood);
      while (!cat.isFull()) {
        plateOfFood.increaseFood(10);
        cat.eat(plateOfFood);
      }
      System.out.println();
    }
  }
}

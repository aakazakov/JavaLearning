package six;

public class Homework {

  public static void main(String[] args) {
    
    Cat cat = new Cat("Joker", 2018);
    Dog dog = new Dog("Flash", 2017);
    
    cat.setPhysicalPowerParams(200f, 0f, 2f);
    dog.setPhysicalPowerParams(500f, 10f, 0.5f);
    
    System.out.println(cat.run(20f));
    System.out.println(dog.run(300f));
    
    System.out.println(cat.swim(10f));
    System.out.println(dog.swim(10f));
    
    System.out.println(cat.jumpOverAnObstacle(1f));
    System.out.println(dog.jumpOverAnObstacle(1f));
    
    System.out.println(Animal.animalCount);
  }

}

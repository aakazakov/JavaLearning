package six;

public class Homework {

  public static void main(String[] args) {
    
    Cat cat = new Cat("Joker", 2018);
    Dog dog = new Dog("Flash", 2017);
    
    cat.setPhysicalPowerParams(200f, 0f, 2f);
    dog.setPhysicalPowerParams(500f, 10f, 0.5f);
    
    cat.printResultOfRun(200f);
    cat.printResultOfSwim(5f);
    cat.printResultOfjump(1.5f);
    
    dog.printResultOfRun(200f);
    dog.printResultOfSwim(5f);
    dog.printResultOfjump(1.5f);
    
    Animal.printAnimalsCount();
  }

}

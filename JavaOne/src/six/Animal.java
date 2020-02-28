package six;

public class Animal {
  String name;
  int yearOfBirth;
  float maxRunDistance = 0;
  float maxSwimDistance = 0;
  float maxJumpHeight = 0;
  static int animalsCount = 0;
  
  public Animal(String name, int yearOfBirth) {
    this.name = name;
    this.yearOfBirth = yearOfBirth;
    animalsCounter();
  }
   
  public void setPhysicalPowerParams(float maxRunDistance,
      float maxSwimDistance, float maxJumpHeight) {
    this.maxRunDistance = maxRunDistance;
    this.maxSwimDistance = maxSwimDistance;
    this.maxJumpHeight = maxJumpHeight;
  }
  
  public void printResultOfRun(float distance) {
    System.out.println(name + ". Run: " + run(distance));
  }
  
  public void printResultOfSwim(float distance) {
    System.out.println(name + ". Swim: " + swim(distance));
  }
  
  public void printResultOfjump(float height) {
    System.out.println(name + ". Jump: " + jumpOverAnObstacle(height));
  }
  
  boolean run(float distance) {
    return distance <= maxRunDistance;
  }
  
  boolean swim(float distance) {
    return distance <= maxSwimDistance;
  }
  
  boolean jumpOverAnObstacle(float height) {
    return height <= maxJumpHeight;
  }
  
  static void animalsCounter() {
    animalsCount++;
  }
  
  public static void printAnimalsCount() {
    System.out.printf("Number of animals: %d.%n", animalsCount);
  }
  
}

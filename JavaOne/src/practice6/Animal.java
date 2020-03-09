package practice6;

public class Animal {
  private static int animalsCount;
  String name;
  int yearOfBirth;
  float canRunDistance;
  float canSwimDistance;
  float canJumpHeight;
  
  static {
    animalsCount = 0;
  }
   
  public Animal(String name, int yearOfBirth) {
    this.name = name;
    this.yearOfBirth = yearOfBirth;
    animalsCounter();
  }
   
  public void setPhysicalPowerParams(float canRunDistance,
      float canSwimDistance, float canJumpHeight) {
    if (canRunDistance >= 0 && canSwimDistance >= 0 && canJumpHeight >= 0) {
      this.canRunDistance = canRunDistance;
      this.canSwimDistance = canSwimDistance;
      this.canJumpHeight = canJumpHeight;
    }
  }
  
  public void printResultOfRun(float distance) {
    System.out.printf("%s. Run: %b.%n", name, run(distance));
  }
  
  public void printResultOfSwim(float distance) {
    System.out.printf("%s. Swim: %b.%n", name, swim(distance));
  }
  
  public void printResultOfjump(float height) {
    System.out.printf("%s. Jump: %b.%n", name, jumpOverAnObstacle(height));
  }
  
  boolean run(float distance) {
    return distance <= canRunDistance && distance >= 0;
  }
  
  boolean swim(float distance) {
    return distance <= canSwimDistance && distance >= 0;
  }
  
  boolean jumpOverAnObstacle(float height) {
    return height <= canJumpHeight && height >= 0;
  }
  
  private static void animalsCounter() {
    animalsCount++;
  }
  
  public static void printAnimalsCount() {
    System.out.printf("Number of animals: %d.%n", animalsCount);
  }
  
}

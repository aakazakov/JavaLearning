package six;

public class Animal {
  String name;
  int yearOfBirth;
  float maxRunDistance = 0;
  float maxSwimDistance = 0;
  float maxJumpHeight = 0;
  static int animalCount = 0;
  
  public Animal(String name, int yearOfBirth) {
    this.name = name;
    this.yearOfBirth = yearOfBirth;
    animalCounter();
  }
   
  public void setPhysicalPowerParams(float maxRunDistance,
      float maxSwimDistance, float maxJumpHeight) {
    this.maxRunDistance = maxRunDistance;
    this.maxSwimDistance = maxSwimDistance;
    this.maxJumpHeight = maxJumpHeight;
  }
  
  public boolean run(float distance) {
    return distance <= maxRunDistance;
  }
  
  public boolean swim(float distance) {
    return distance <= maxSwimDistance;
  }
  
  public boolean jumpOverAnObstacle(float height) {
    return height <= maxJumpHeight;
  }
  
  static void animalCounter() {
    animalCount++;
  }
  
}

package six;

public class Animal {
  String name;
  int yearOfBirth;
  int maxRunDistance = 0;
  int maxSwimDistance = 0;
  int maxJumpHeight = 0;
  
  public Animal(String name, int yearOfBirth) {
    this.name = name;
    this.yearOfBirth = yearOfBirth;
  }
   
  public boolean run(int distance) {
    return distance <= maxRunDistance;
  }
  
  public boolean swim(int distance) {
    return distance <= maxSwimDistance;
  }
  
  public boolean jumpOverAnObstacle(int height) {
    return height <= maxJumpHeight;
  }
  
  public void setPhysicalPowerParameters(int maxRunDistance,
      int maxSwimDistance, int maxJumpHeight) {
    this.maxRunDistance = maxRunDistance;
    this.maxSwimDistance = maxSwimDistance;
    this.maxJumpHeight = maxJumpHeight;
  }
}

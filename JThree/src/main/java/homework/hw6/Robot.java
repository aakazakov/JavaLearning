package homework.hw6;

public class Robot {
  
  @BeforeSuite
  void turnOn() {
    System.out.println("Robot is ON");
  }
  
  @AfterSuite
  void turnOff() {
    System.out.println("Robot is OFF");
  }
  
  @Test(priority = 2)
  void makeBeep() {
    System.out.println("Beeeeep...");
  }
  
  @Test(priority = 10)
  void takeStep() {
    System.out.println("Robot took a step");
  }
  
  @Test(priority = 6)
  void raiseHand() {
    System.out.println("Robot raised his hand");
  }
}

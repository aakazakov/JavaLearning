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
  
  @Test
  void makeBeep() {
    System.out.println("Beeeeep...");
  }
  
  @Test
  void takeStep() {
    System.out.println("Robot took a step");
  }
  
  @Test
  void raiseHand() {
    System.out.println("Robot raised his hand");
  }
}

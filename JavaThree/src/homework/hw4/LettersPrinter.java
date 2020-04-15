package homework.hw4;

public class LettersPrinter {
  private volatile char currentLetter = 'A';
  
  public synchronized void printA() {
    try {
      for (int i = 0; i < 5; i++) {
        while (currentLetter != 'A') {
          wait();
        }
        System.out.println("A");
        currentLetter = 'B';
        notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public synchronized void printB() {
    try {
      for (int i = 0; i < 5; i++) {
        while (currentLetter != 'B') {
          wait();
        }
        System.out.println("B");
        currentLetter = 'C';
        notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public synchronized void printC() {
    try {
      for (int i = 0; i < 5; i++) {
        while (currentLetter != 'C') {
          wait();
        }
        System.out.println("C");
        currentLetter = 'A';
        notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  } 
}

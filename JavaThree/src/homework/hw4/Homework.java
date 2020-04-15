package homework.hw4;

public class Homework {
  
  public static void main(String[] args) {
    LettersPrinter printer = new LettersPrinter();
    new Thread(() -> printer.printA()).start();
    new Thread(() -> printer.printB()).start();
    new Thread(() -> printer.printC()).start();
  }
}

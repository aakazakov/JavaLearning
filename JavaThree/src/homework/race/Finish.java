package homework.race;

import java.util.concurrent.atomic.AtomicInteger;

public class Finish extends Stage {
  AtomicInteger haveWinner = new AtomicInteger(0);

  @Override
  public void go(Car c) {
    if (haveWinner.get() == 0) {
      haveWinner.incrementAndGet();
      System.out.println(c.getName() + " WINNER !!!");
    }
  }
  
}

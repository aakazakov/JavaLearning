package homework.race;

public class Launcher {
  public static final int NUMBER_OF_CARS = 4;

  public static void main(String[] args) {
    Track track = new Track(new Road(60), new Tunnel(80), new Road(40), new Finish());
    Race race = new Race(track);
    race.init();
  }

}

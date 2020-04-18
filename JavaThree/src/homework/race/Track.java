package homework.race;

import java.util.*;

public class Track {
  private List<Stage> stages;
  
  public Track(Stage...stages) {
    this.stages = new ArrayList<>(Arrays.asList(stages));
  }
  
  public List<Stage> getStages() {
    return stages;
  }
}

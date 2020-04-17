package homework.race;

import java.util.*;

public class Race {
  private List<Stage> stages;
  
  public Race(Stage...stages) {
    this.stages = new ArrayList<>(Arrays.asList(stages));
  }
  
  public List<Stage> getStages() {
    return stages;
  }
}

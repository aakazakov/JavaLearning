package homework.hw1.fruitBox;

import java.util.*;

public class Box<T extends Fruit> {
  private List<T> fruits = new ArrayList<>();
  
  public void put(T fruit) {
    fruits.add(fruit);
  }
  
  public float getBoxWeightNetto() {
    float weight = 0;
    for (T fruit : fruits) {
      weight += fruit.getWeight();
    }
    return weight;
  }
  
  public boolean compareBoxesByWeight(Box<?> box) {
    return this.getBoxWeightNetto() == box.getBoxWeightNetto();
  }
  
  public void moveFruitsToAnother(Box<T> box) {
    for (T fruit : fruits) {
      box.put(fruit);
    }
    fruits.clear();
  }

}

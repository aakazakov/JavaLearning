package homework.hw3.serializzz;

import java.io.Serializable;

// kasha ))
public class Entity implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private String shape;
  private String color;
  private int weight;
  
  public Entity(String name, String shape, String color, int weight) {
    this.name = name;
    this.shape = shape;
    this.color = color;
    this.weight = weight;
  }
  
  public int computeFactorial(int number) {
    if (number == 1) return number;
    return number * computeFactorial(number - 1);
  }
  
  @Override
  public String toString() {
    return String.format("This is a certain entity called %s, %s shape, %s color, weighs %d )).",
        name, shape, color, weight);
  }
  
}

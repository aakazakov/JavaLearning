package practice1;

import java.util.Set;

public class Homework {
  static final String[] words = {
      "apple", "orange", "banana", "pineapple", "grape", "watermelon",
      "coconut", "juice", "mandarin", "berry", "tea", "coffe", "grape",
      "mango", "pineapple", "coconut", "melon", "melon", "tea", "coffe",
      "apple", "orange", "banana", "pineapple", "grape", "watermelon",
      "coconut", "juice", "mandarin", "berry", "tea", "coffe", "grape",
      "mango", "pineapple", "coconut", "melon", "melon", "tea", "coffe"
  };

  public static void main(String[] args) {
    
    Words w = new Words();
    Set<String> unique = w.getUniqueWords(words);
    System.out.println(unique);
    
  }

}

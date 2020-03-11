package practice1;

import java.util.*;

public class Words {
  private Set<String> uniqueWords = new HashSet<>();
  
  public Set<String> getUniqueWords(String[] arr) {
    uniqueWords(arr);
    return uniqueWords;
  }
  
  private void uniqueWords(String[] arr) {
    Collections.addAll(uniqueWords, arr);
  }

}

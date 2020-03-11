package practice1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Words {
  private Set<String> uniqueWords = new HashSet<>();
  
  private void uniqueWords(String[] arr) {
    Collections.addAll(uniqueWords, arr);
  }

  public Set<String> getUniqueWords(String[] arr) {
    uniqueWords(arr);
    return uniqueWords;
  }
}

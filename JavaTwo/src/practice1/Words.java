package practice1;

import java.util.*;

public class Words {
  private Set<String> uniqueWords = new HashSet<>();
  private Map<String, Integer> wordsMap = new HashMap<>();
  
  public Set<String> getUniqueWords(String[] arr) {
    fillUniqueWords(arr);
    return uniqueWords;
  }
  
  private void fillUniqueWords(String[] arr) {
    try {
      Collections.addAll(uniqueWords, arr);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public Map<String, Integer> getRepetitionOfWords(String[] arr) {
    fillWordsMap(arr);
    return wordsMap;
  }
  
  private void fillWordsMap(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      try {
        if (wordsMap.containsKey(arr[i])) {
          wordsMap.put(arr[i], wordsMap.get(arr[i]) + 1);
        } else {
          wordsMap.put(arr[i], 1);
        }
      } catch (RuntimeException e) {
        e.printStackTrace();
      }
    }
  }

}

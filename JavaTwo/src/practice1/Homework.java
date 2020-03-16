package practice1;

import java.util.*;

public class Homework {
  static final String[] someWords = {
      "apple", "orange", "banana", "pineapple", "grape", "watermelon",
      "coconut", "juice", "mandarin", "berry", "tea", "coffe", "grape",
      "mango", "pineapple", "coconut", "melon", "melon", "tea", "coffe",
      "apple", "orange", "banana", "pineapple", "grape", "watermelon",
      "coconut", "juice", "mandarin", "berry", "tea", "coffe", "grape",
      "mango", "pineapple", "coconut","tea", "coffe", "strawberry"
  };
  
  public static void main(String[] args) {
    
    // ex. 1.
    
    Words w = new Words();
    
    Set<String> uniqueWords = w.getUniqueWords(someWords);
    Map<String, Integer> wordsWithScore = w.getRepetitionOfWords(someWords);
    
    System.out.println(uniqueWords);
    printRepetitionOfWords(wordsWithScore);
    
    // ex. 2.
    
    PhoneBook p = new PhoneBook();
    
    p.addToPhoneBook("Doe", "+123456789", "doe@doe.com");
    p.addToPhoneBook("Doe", "+234567890", "another@doe.com");
    p.addToPhoneBook("Smith", "+345678912", "s@s.com");
    p.addToPhoneBook("Freeman", "+456789123", "free@man.com");
    
    System.out.println("Doe" + " emails: " + p.getAllEmails("Doe"));
    System.out.println("Doe" + " phones: " + p.getAllPhones("Doe"));
    System.out.println("Smith" + " emails: " + p.getAllEmails("Smith"));
    System.out.println("Smith" + " phones: " + p.getAllPhones("Smith"));
    System.out.println("Freeman" + " emails: " + p.getAllEmails("Freeman"));
    System.out.println("Freeman" + " phones: " + p.getAllPhones("Freeman"));
  }
  
  public static void printRepetitionOfWords(Map<String, Integer> m) {
    Set<Map.Entry<String, Integer>> entries = m.entrySet();
    Iterator<Map.Entry<String, Integer>> i = entries.iterator();
    while (i.hasNext()) {
      Map.Entry<String, Integer> entry = i.next();
      if (entry.getValue() > 1) {
        System.out.printf("'%s' is repeated %d times.%n", entry.getKey(), entry.getValue());
      } else {
        System.out.printf("'%s' has no repetition.%n", entry.getKey());
      }
    }
  }
  
}

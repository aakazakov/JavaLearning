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
    
    String surname = "Gates";
    String[] emails = {"gates@micro.soft", "bg@mail.com"};
    String[] phones = {"+123456789", "+234567891"};
    p.addToPhoneBook(new Person(surname, emails, phones));
    
    p.printInfo(surname, PhoneBook.EMAIL);
    p.printInfo(surname, PhoneBook.PHONE);
    
    String surname1 = "Mask";
    String[] emails1 = {"mask@tes.la", "im@mail.com"};
    String[] phones1 = {"+345678912", "+456789123"};
    p.addToPhoneBook(new Person(surname1, emails1, phones1));
    
    p.printInfo(surname1, PhoneBook.EMAIL);
    p.printInfo(surname1, PhoneBook.PHONE);
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

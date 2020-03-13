package practice1;

import java.util.*;

public class PhoneBook {
  public static final String EMAIL = "email";
  public static final String PHONE = "phone";
  
  private Map<String, Map<String, List<String>>> phoneBookEntries = new HashMap<>();
  
  public void addToPhoneBook(Person p) {
    try {
      phoneBookEntries.put(p.getSurname(), p.getContacts());
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public void printInfo(String surname, String param) {
    surname = surname.toLowerCase();
    List<String> result = null;
    if (param.equals(EMAIL)) {
      result = getEmail(surname);
    }
    if (param.equals(PHONE)) {
      result = getPhone(surname);
    }
    System.out.println(result);
  }
  
  private List<String> getEmail(String surname) {
    return phoneBookEntries.get(surname).get(EMAIL);
  }
  
  private List<String> getPhone(String surname) {
    return phoneBookEntries.get(surname).get(PHONE);
  }
}

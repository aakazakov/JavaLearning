package practice1;

import java.util.*;

public class PhoneBook {
  public static final String EMAIL = "email";
  public static final String PHONE = "phone";
  
  private Map<String, Map<String, List<String>>> phoneBookEntries = new HashMap<>();

  public void addToPhoneBook(Person p) {
    try {
      Map<String, List<String>> contacts = new HashMap<>();
      contacts.put(EMAIL, p.getEmail());
      contacts.put(PHONE, p.getPhone());
      phoneBookEntries.put(p.getSurname(), contacts);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public void printInfo(String surname, String param) {
    List<String> info;
    if (param.equals(EMAIL)) {
      info = getEmail(surname);
      System.out.println(info);
    }
    if (param.equals(PHONE)) {
      info = getPhone(surname);
      System.out.println(info);
    }
  }
  
  private List<String> getEmail(String surname) {
      Map<String, List<String>> contacts = phoneBookEntries.get(surname);
      return contacts.get(EMAIL);
  }
  
  private List<String> getPhone(String surname) {
      Map<String, List<String>> contacts = phoneBookEntries.get(surname);
      return contacts.get(PHONE);
  }
}

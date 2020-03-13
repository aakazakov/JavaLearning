package practice1;

import java.util.*;

public class Person {
  private String surname;
  private Map<String, List<String>> contacts = new HashMap<>();
  private List<String> emails = new ArrayList<>();
  private List<String> phones = new ArrayList<>();
  
  public Person(String surname, String[] emails, String[] numbers) {
    this.surname = surname.toLowerCase();
    addToEmail(emails);
    addToPhone(numbers);
  }
  
  private void addToEmail(String[] addresses) {
    try {
      emails.addAll(Arrays.asList(addresses));
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  private void addToPhone(String[] numbers) {
    try {
      phones.addAll(Arrays.asList(numbers));
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public Map<String, List<String>> getContacts() {
    fillContacts();
    return contacts;
  }
  
  private void fillContacts() {
    try {
      contacts.put(PhoneBook.EMAIL, emails);
      contacts.put(PhoneBook.PHONE, phones);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public String getSurname() {
    return surname;
  }
  
}

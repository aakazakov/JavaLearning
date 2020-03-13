package practice1;

import java.util.*;

public class Person {
  private String surname;
  private Map<String, List<String>> contacts = new HashMap<>();
  private List<String> email = new ArrayList<>();
  private List<String> phone = new ArrayList<>();
  
  public Person(String surname, String[] emails, String[] numbers) {
    this.surname = surname.toLowerCase();
    addToEmail(emails);
    addToPhone(numbers);
  }
  
  private void addToEmail(String[] address) {
    try {
      email.addAll(Arrays.asList(address));
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  private void addToPhone(String[] numbers) {
    try {
      phone.addAll(Arrays.asList(numbers));
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
      contacts.put(PhoneBook.EMAIL, email);
      contacts.put(PhoneBook.PHONE, phone);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public String getSurname() {
    return surname;
  }
  
}

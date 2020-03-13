package practice1;

import java.util.*;

public class Person {
  private String surname;
  private List<String> email = new ArrayList<>();
  private List<String> phone = new ArrayList<>();
  
  public Person(String surname) {
    this.surname = surname;
  }
  
  public void addEmail(String address) {
    try {
      email.add(address);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public void addEmail(List<String> address) {
    try {
      email.addAll(address);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public void addPhone(String number) {
    try {
      phone.add(number);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
  
  public void addPhone(List<String> numbers) {
    try {
      phone.addAll(numbers);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }

  public String getSurname() {
    return surname;
  }
  
}

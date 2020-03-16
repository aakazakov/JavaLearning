package practice1;

import java.util.*;

public class PhoneBook {
  Map<String, List<Person>> entries = new HashMap<>();

  public void addToPhoneBook(String surname, String phone, String email) {
    if (entries.containsKey(surname)) {
      List<Person> persons = entries.get(surname);
      persons.add(new Person(phone, email));
    } else {
      List<Person> person = new ArrayList<>();
      person.add(new Person(phone, email));
      entries.put(surname, person);
    }
  }
  
  public List<String> getAllEmails(String surname) {
    if (!entries.containsKey(surname)) { return Collections.emptyList(); }
    List<Person> persons = entries.get(surname);
    List<String> emails = new ArrayList<>();
    for (int i = 0; i < persons.size(); i++) {
      emails.add(persons.get(i).getEmail());
    }
    return emails;
  }
  
  public List<String> getAllPhones(String surname) {
    if (!entries.containsKey(surname)) { return Collections.emptyList(); }
    List<Person> persons = entries.get(surname);
    List<String> phones = new ArrayList<>();
    for (int i = 0; i < persons.size(); i++) {
      phones.add(persons.get(i).getPhone());
    }
    return phones;
  }
}

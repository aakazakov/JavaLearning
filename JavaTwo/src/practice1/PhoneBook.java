package practice1;

import java.util.*;

public class PhoneBook {
  Map<String, List<Person>> entries;

  public void addToPhoneBook(String surname, String phone, String email) {
    if (entries.containsKey(surname)) {
      List<Person> person = entries.get(surname);
      person.add(new Person(phone, email));
    } else {
      List<Person> person = new ArrayList<>();
      person.add(new Person(phone, email));
      entries.put(surname, person);
    }
  }
}

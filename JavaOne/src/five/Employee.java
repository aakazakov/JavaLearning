package five;

public class Employee {
  private String name;
  private String surname;
  private int age;
  private String phoneNumber;
  private String email;
  private String position;
  private int salary;
  
  public Employee(String name, String surname, int age,
      String phoneNumber, String email,
      String position, int salary) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.position = position;
    this.salary = salary;
  }
  
  public void fullInfo() {
    System.out.printf("%s %s | age: %d | tel: %s | email: %s | pos: %s | salary: %d.%n",
        name, surname, age, phoneNumber, email, position, salary);
  }
  
  public int getAge() {
    return age;
  }
}

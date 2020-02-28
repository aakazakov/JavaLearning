package five;

public class Homework {

  public static void main(String[] args) {
    Employee[] stuff = new Employee[5];
    stuff[0] = new Employee("Bill", "Gates", 41, "+0123456789", "bill@windows.com",
        "Engeneer", 1050);
    stuff[1] = new Employee("Elon", "Musk", 27, "+2345678901", "musk.ilon@tesla.com",
        "Programmer", 1150);
    stuff[2] = new Employee("Mark", "Zuckerberg", 24, "+3456789012", "mark1@f.b",
        "Developer", 1150);
    stuff[3] = new Employee("Robert", "Martin", 31, "+4567890123", "uncle.bob@com.com",
        "Engeneer", 1100);
    stuff[4] = new Employee("Thomas", "Cormen", 43, "+5678901234", "cormen@alg.net",
        "Analyst", 1120);
    
    for (Employee employee : stuff) {
      if (employee.getAge() > 40) {
        employee.fullInfo();
      }
    }
  }
}

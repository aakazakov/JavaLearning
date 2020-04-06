package homework.hw2;

import java.sql.SQLException;

import homework.hw2.database.DBConnector;

public class Homework {

  public static void main(String[] args) {
    
    DBConnector connector = new DBConnector();
    
    try {
      connector.connect();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return;
    }
    
    connector.disconnect();
  }

}

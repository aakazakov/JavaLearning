package homework.hw2;

import java.sql.SQLException;

import homework.hw2.database.DBConnector;
import homework.hw2.database.SQLQueries;

public class Homework {

  public static void main(String[] args) {
    
    try {
      DBConnector connector = new DBConnector();
      SQLQueries queries = new SQLQueries(connector.getConnection());
      
      
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

}

package homework.hw2;

import java.sql.SQLException;

import homework.hw2.database.DbConnector;
import homework.hw2.database.SQLQueries;

public class Homework {

  public static void main(String[] args) {
    
    DbConnector connector = new DbConnector();
    
    try {
      connector.connect();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return;
    }

    SQLQueries queries = new SQLQueries(connector.getConnection());
    
    System.out.println(queries.getMainDataAboutOne(4));

    
    connector.disconnect();
  }

}

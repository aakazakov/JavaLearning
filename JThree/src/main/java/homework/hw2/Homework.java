package homework.hw2;

import java.util.List;

import java.sql.SQLException;

import homework.hw2.database.*;

public class Homework {

  public static void main(String[] args) {
    
    DbConnector connector = new DbConnector();
    
    try {
      connector.connect();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return;
    }

    DbQueries queries = new DbQueries(connector.getConnection());
    
    List<String> dataList = FileParser.getDataStringsFromFile("src/homework/hw2/DZ_update.txt");
    
    queries.updateScoreValueAtAllFromList(dataList);
    
    connector.disconnect();
    
  }

}

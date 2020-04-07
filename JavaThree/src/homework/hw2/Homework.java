package homework.hw2;

//import java.sql.SQLException;
//
//import homework.hw2.database.DbConnector;

public class Homework {

  public static void main(String[] args) {
    
//    DbConnector connector = new DbConnector();
//    
//    try {
//      connector.connect();
//    } catch (ClassNotFoundException | SQLException e) {
//      e.printStackTrace();
//      return;
//    }
//
//    
//    
//    connector.disconnect();
    
    FileParser.scanFile("D:\\TEMP\\DZ_update.txt");
  }

}

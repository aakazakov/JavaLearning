package homework.hw2.database;

import java.sql.*;

public class DbConnector {
  private final String driverName = "org.sqlite.JDBC";
  private final String connectionString = "jdbc:sqlite:src/homework/hw2/mainDB.db";
  private Connection connection;
  
  public void connect() throws ClassNotFoundException, SQLException {
    Class.forName(driverName);
    connection = DriverManager.getConnection(connectionString);
  }
  
  public void disconnect() {
    try {
      connection.close();
    } catch (SQLException | NullPointerException e) {
      e.printStackTrace();
    }
  }
  
  public Connection getConnection() {
    return connection;
  }
}

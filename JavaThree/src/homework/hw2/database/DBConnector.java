package homework.hw2.database;

import java.sql.*;

public class DBConnector {
  private final String driverName = "org.sqlite.JDBC";
  private final String connectionString = "jdbc:sqlite:mainDB.db";
  private Connection connection;
  
  public DBConnector() throws ClassNotFoundException, SQLException {
    connect();
  }
  
  public void connect() throws ClassNotFoundException, SQLException {
    Class.forName(driverName);
    connection = DriverManager.getConnection(connectionString);
  }
  
  public void disconnect() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }
}

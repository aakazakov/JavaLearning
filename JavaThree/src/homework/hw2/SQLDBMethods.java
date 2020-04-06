package homework.hw2;

import java.sql.*;

public class SQLDBMethods {
  Connection connection;
  String tableName = "Students";
  
  public SQLDBMethods(Connection connection) {
    this.connection = connection;
  }
  
  public void createTable() throws SQLException {
    String query = "CREATE TABLE IF NOT EXISTS" + tableName
        + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
        + "name TEXT NOT NULL,"
        + "score INTEGER NOT NULL);";
    connection.prepareStatement(query);
  }
  
  public void updateName(int id, String newName) {
    String query = String.format("UPDATE %s SET name = ?, WHERE id = ?;", tableName);
    try {
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setString(1, newName);
      ps.setInt(2, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void updateScore(int id, int newScore) {
    String query = String.format("UPDATE %s SET score = ?, WHERE id = ?;", tableName);
    try {
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setInt(1, newScore);
      ps.setInt(2, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void deleteFromTable(int id) {
    String query = String.format("DELETE FROM %s + WHERE id = ?;", tableName);
    try {
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void insertIntoTable(String name, int score) {
    String query = String.format("INSERT INTO %s (name, score) VALUES (?, ?)", tableName);
    try {
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setString(1, name);
      ps.setInt(2, score);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public ResultSet getAllMainInfoFromTable() {
    String query = String.format("SELECT id, name, score FROM %s;", tableName);
    try {
      Statement stetement = connection.createStatement();
      return stetement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}

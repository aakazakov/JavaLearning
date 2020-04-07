package homework.hw2.database;

import java.sql.*;
import java.util.List;

public class DbQueries {
  private Connection connection;
  private String tableName = "students";
  
  public DbQueries (Connection connection) {
    this.connection = connection;
  }
  
  public void createTable() throws SQLException {
    Statement s = connection.createStatement();
    String query = String.format("CREATE TABLE IF NOT EXISTS %s ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
        + "name TEXT NOT NULL,"
        + "score INTEGER NOT NULL);",
        tableName);
    s.executeUpdate(query);
  }
  
  public void insertOne(String name, int score) {
    String query = String.format("INSERT INTO %s (name, score) VALUES (?, ?);", tableName);
    try (PreparedStatement ps = connection.prepareStatement(query)) {
      ps.setString(1,name);
      ps.setInt(2, score);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void deleteOne(int id) {
    String query = String.format("DELETE FROM %s WHERE id = ?;", tableName);
    try (PreparedStatement ps = connection.prepareStatement(query)) {
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void updateScoreValueAtOne(int newValue, int id) {
    String query = String.format("UPDATE %s SET score = ? WHERE id = ?;", tableName);
    try (PreparedStatement ps = connection.prepareStatement(query)) {
      ps.setInt(1, newValue);
      ps.setInt(2,id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void updateScoreValueAtAllFromList(List<String> dataList) {
    String query = String.format("UPDATE %s SET score = ? WHERE id = ?;", tableName);
    try (PreparedStatement ps = connection.prepareStatement(query)) {
      for (int i = 0; i < dataList.size(); i++) {
        
        String[] data = dataList.get(i).split("  ");
        ps.setInt(1, Integer.parseInt(data[data.length - 1]));
        ps.setInt(2, Integer.parseInt(data[0]));
        ps.addBatch();
        
      }
      ps.executeBatch();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public ResultSet getMainDataAboutOne(int id) {
    String query = String.format("Select id, name, score FROM %s WHERE id = ?", tableName);
    try (PreparedStatement ps = connection.prepareStatement(query)) {
      ps.setInt(1,id);
      return ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
  
}

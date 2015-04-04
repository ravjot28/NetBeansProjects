import java.sql.*;

public class MysqlConnect{
  public static void main(String[] args) {
    System.out.println("MySQL Connect Example.");
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3303/";
    String dbName = "emp";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "";
    String password = "rav";
    try {
      Class.forName(driver).newInstance();
      conn = DriverManager.getConnection(url+dbName,userName,password);
      System.out.println("Connected to the database");
      conn.close();
      System.out.println("Disconnected from database");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
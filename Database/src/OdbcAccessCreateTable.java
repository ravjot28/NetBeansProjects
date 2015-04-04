import java.sql.*;

public class OdbcAccessCreateTable
{
  public static void main(String [] args)
  {
    Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Airlines");
        // Creating a database table
        Statement sta = con.createStatement();
        int count = sta.executeUpdate("CREATE TABLE plideduction (EMPID INT,adl INT)");
        System.out.println("Table created.");
        sta.close();
        con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}

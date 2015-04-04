import java.sql.*;
public class OdbcAccessConnection
{
  public static void main(String [] args)
  {
    Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver") ;
        // Connect with a url string
        con = DriverManager.getConnection("jdbc:odbc:Airlines");
        System.out.println("Connection ok.");
        con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}

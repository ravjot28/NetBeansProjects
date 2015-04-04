import java.sql.*;
public class OdbcAccessDatabaseInfo
{
  public static void main(String [] args)
  {
    Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:HY_ACCESS");
        // Database and driver info
        DatabaseMetaData meta = con.getMetaData();
        System.out.println("Server name: "+ meta.getDatabaseProductName());
        System.out.println("Server version: "+ meta.getDatabaseProductVersion());
        System.out.println("Driver name: "+ meta.getDriverName());
        System.out.println("Driver version: "+ meta.getDriverVersion());
        System.out.println("JDBC major version: "+ meta.getJDBCMajorVersion());
        System.out.println("JDBC minor version: "+ meta.getJDBCMinorVersion());
        con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}

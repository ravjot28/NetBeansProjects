import java.io.File;
import java.sql.*;

public class CreateTable
{
  public static void main(String [] args)
  {
    Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        File f = new File("db.mdb");

        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+f.getAbsolutePath();

        System.out.println(driver);
        con = DriverManager.getConnection(driver,"","");
        // Creating a database table
        Statement sta = con.createStatement();

        /*
         employee name
         the department name
         the employee number
         Address (Max 200 characters)
         Extension Phone Number (Max 5 characters)
         Direct Phone Number (Max 15 characters)
         Mobile number (Max 15 characters)
         Joining Date (MM/DD/YYY format) */

        sta.executeUpdate("CREATE TABLE Emp ("
                                                + "empid INT,"
                                                + "name VARCHAR(90),"
                                                + "dept VARCHAR(90),"
                                                + "address VARCHAR(90),"
                                                + "extension VARCHAR(5),"
                                                + "phone VARCHAR(15),"
                                                + "mobilephone VARCHAR(15),"
                                                + "doj DATETIME,"
                                                +"pswd VARCHAR(8),"
                                                + "admin INT);");
        System.out.println("Table created.");
        sta.close();
        con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}

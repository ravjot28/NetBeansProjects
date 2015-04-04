import java.sql.*;

public class UpdateDOB
{
  public UpdateDOB(String empid,String dob,String doj,String rav)
  {
    Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
        sta.executeUpdate("UPDATE EMP SET DOB='"+dob+"',DOJ='"+doj+"' where EMPID="+empid);
        sta.close();
        con.close();
    } catch (Exception e) {    }
  }
}

import java.sql.*;

public class Update
{
  public Update(String empid,String emailid,String pswd,String rav)
  {
    Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
        sta.executeUpdate("UPDATE EMP SET EMAIL='"+emailid+"',PASS='"+pswd+"' where EMPID="+empid);
        sta.close();
        con.close();
    } catch (Exception e) {    }
  }
}

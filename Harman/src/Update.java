import java.io.File;
import java.sql.*;

public class Update
{
  public Update(String empid,String rav)
  {
    Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
           String loc=new File("Bin/reasons/"+empid+".ravs").getAbsolutePath();
        sta.executeUpdate("UPDATE exitmanag SET reason='"+loc+"'"+" where emp_id="+empid);
        sta.executeUpdate("UPDATE exitmanag SET dor='"+new Calendar1().getdate()+"'"+" where emp_id="+empid);
        sta.executeUpdate("UPDATE exitmanag SET confirmation='11101101'"+" where emp_id="+empid);
        sta.close();
        con.close();
    } catch (Exception e) {    }
  }
}

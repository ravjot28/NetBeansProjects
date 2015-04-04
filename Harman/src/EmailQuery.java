import java.sql.*;
public class EmailQuery
{
    String empid;
  public EmailQuery(String emp)
  {
        empid=emp;
  }

  public String search(String rav)
  {
      String p="";
      Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM exitmanag where emp_id="+empid);
            if(res.next())
            {
                return res.getString("email");
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {    }
      return p;
  }
}

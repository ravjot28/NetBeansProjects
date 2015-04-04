import java.io.File;
import java.sql.*;
public class LoginCheck
{
    String empid;
    String p;
  public LoginCheck(String emp,String pswd)
  {
        this.empid=emp;
        this.p = pswd;
  }

  public boolean check()
  {
      Connection con = null;
        try
        {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        File f = new File("db.mdb");

        String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+f.getAbsolutePath();

        System.out.println(driver);
        con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT pswd FROM Emp where empid="+empid);
            if(res.next())
            {
                if(res.getString("pswd").equals(p))
                {
                    return true;
                }
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }

            return false;
  }
}

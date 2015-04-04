import java.io.File;
import java.sql.*;
public class Search
{
    String empid;
    String p;
  public Search(String emp,String pswd)
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
            ResultSet res ;
                res = sta.executeQuery("SELECT pswd FROM Emp where phone=\""+empid+"\"");
            
            while(res.next())
            {
                System.out.println(res.getString("empid")+" "+res.getString("name")
                                   );/* +" "+res.getString("dept")+" "+res.getString("address")
                                    +" "+res.getString("phone")+" "+res.getString("mobilephone")
                                    +" "+res.getString("doj")+" "+res.getString("extension"));*/
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }

            return false;
  }

  public static void main(String asp[])
    {
      Search s = new Search("28083160","");
      s.check();
  }
}

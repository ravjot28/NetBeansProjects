import java.sql.*;
public class OdbcAccessQuery1
{
  public static void main(String [] args)
  {
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:HY_ACCESS");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM Rav");
            System.out.println("List of Addresses: ");
            while (res.next())
            {
                String a=res.getString("ID");
                if(a.length()!=3)
                {
                    int space=3-a.length();
                    while(space!=0)
                    {
                        a=" "+a;
                        space=space-1;
                    }
                }
                String b=res.getString("StreetName");
                if(b.length()!=30)
                {
                    int space=30-b.length();
                    while(space!=0)
                    {
                        b=" "+b;
                        space=space-1;
                    }
                }
                String c=res.getString("City");
                if(c.length()!=30)
                {
                    int space=30-c.length();
                    while(space!=0)
                    {
                        c=" "+c;
                        space=space-1;
                    }
                }
                System.out.println("  "+a+ ", "+b+ ", "+c);
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Get
{
    String records[][];
    public int size() throws ClassNotFoundException, SQLException
    {
            Connection con = null;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:hello");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM student");
            int i = 0;
            while (res.next()) {
                i++;
            }
            return i;
    }
  public String[][] get()
  {
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:hello");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM student");
            int i=0;
            while(res.next())
            {
                i++;
            }
            records=new String[i][5];
            ResultSet res1 = sta.executeQuery("SELECT * FROM student");
            int count=0;
            while (res1.next())
            {
                records[count][0]=res1.getString("Name");
                records[count][1]=res1.getString("R No");
                records[count][2]=res1.getString("C org");
                records[count][3]=res1.getString("java");
                records[count][4]=res1.getString("Multimedia");
                count++;
            }
      res.close();
      sta.close();
      con.close();
      return records;
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
        String r[][]={{}};
        return records;
  }
}

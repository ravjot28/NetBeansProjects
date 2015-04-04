import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckFirstUse
{
    Connection con = null;
    String table_name;
    
    CheckFirstUse(String tname)
    {
        table_name = tname;
    }

    public boolean check()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=Bin\\Contacts\\Details.mdb");
            // Creating a database table
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery("SELECT no FROM DETAILS where prefix = '"+table_name+"'");
            int numberOfColumns=-1;
            while(res.next())
            {
                numberOfColumns=0;
                sta.close();
                con.close();
                return false;
            }
            sta.close();
            con.close();
            return true;
        }catch(Exception e)
            {
            System.out.println("Exception in CheckFirstUse "+e);
                return false;
            }
    }
}

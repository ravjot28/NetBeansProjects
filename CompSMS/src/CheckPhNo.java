import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckPhNo
{
    Connection con = null;
    String table_name;
    String phno;

    CheckPhNo(String tname,String p)
    {
        this.table_name = tname;
        this.phno=p;
    }

    public boolean check()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"Bin\\Contacts\\"+table_name+".mdb");
            // Creating a database table
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery("SELECT FNAME FROM CUST"+table_name+" where PH_NO = '"+phno+"'");
            int numberOfColumns=-1;
            while(res.next())
            {
                numberOfColumns=0;
                sta.close();
                con.close();
                return true;
            }
            sta.close();
            con.close();
            return false;
        }catch(Exception e)
            {
            System.out.println("Exception in CheckPhNo "+e);
                return false;
            }
    }
}

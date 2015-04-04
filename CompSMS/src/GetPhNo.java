import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetPhNo
{
    Connection con = null;
    String table_name;
    String email;

    GetPhNo(String tname,String p)
    {
        this.table_name = tname;
        this.email=p;
    }

    public String check()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"Bin\\Contacts\\"+table_name+".mdb");
            // Creating a database table
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery("SELECT PH_NO FROM CUST"+table_name+" where EMAIL_ID_OR_Mobile = '"+email+"'");
            int numberOfColumns=-1;
            while(res.next())
            {
                numberOfColumns=0;
                return res.getString(1);
            }
            sta.close();
            con.close();
        }catch(Exception e)
            {
                System.out.println("Exception in GetPhNo "+e);
                
            }
        return null;
    }
}

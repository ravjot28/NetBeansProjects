
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CreateTable
{
    Connection con = null;
    String table_name;
    CreateTable(String tname)
    {
        table_name = tname;
    }

    public void create()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"Bin\\Contacts\\"+table_name+".mdb");
            // Creating a database table
            Statement sta = con.createStatement();
            int count = sta.executeUpdate("CREATE TABLE CUST"+table_name+" (PH_NO VARCHAR(8) NOT NULL PRIMARY KEY,FNAME VARCHAR(100),MNAME VARCHAR(100),LNAME VARCHAR(100),EMAIL_ID_OR_Mobile VARCHAR(100), LOCATION VARCHAR(50))");
            //int count = sta.executeUpdate("CREATE TABLE DETAILS (prefix VARCHAR(4),no INT)");
            sta.close();
            con.close();
            //JOptionPane.showMessageDialog(null, "Success","Table created", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e)
            {
                System.out.println("Exception in CreateTable "+e);
            }
    }
}

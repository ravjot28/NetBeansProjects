import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UpdateFirstUse
{
    Connection con = null;

    String prefix;

    public UpdateFirstUse(String p)
    {
        this.prefix = p;
    }

    public void insert()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"Bin\\Contacts\\Details.mdb");
            // Creating a database table
            Statement sta = con.createStatement();
            // getting the data back
            int c = sta.executeUpdate("INSERT INTO DETAILS VALUES('"+prefix+"',0)");

            sta.close();
            con.close();
            //JOptionPane.showMessageDialog(null, "Success","Record Inserted", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e)
                {
                    System.out.println("Exception in InsertCust "+e);
                }
    }

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertCust
{
    Connection con = null;

    String ph_no;
    String f_name;
    String m_name;
    String l_name;
    String location;
    String email;
    String table_name;

    public InsertCust(String p,String f,String m,String l,String lo,String e,String t)
    {
        this.ph_no = p;
        this.f_name = f;
        this.m_name = m;
        this.l_name = l;
        this.location = lo;
        this.email = e;
        this.table_name = t;
    }

    public void insert()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"Bin\\Contacts\\"+table_name+".mdb");
            // Creating a database table
            Statement sta = con.createStatement();
            // getting the data back
            int c = sta.executeUpdate("INSERT INTO CUST"+table_name+" VALUES('"+ph_no+"','"+f_name+"','"+m_name+"','"+l_name+"','"+email+"','"+location+"')");

            sta.close();
            con.close();
            //JOptionPane.showMessageDialog(null, "Success","Record Inserted", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e)
                {
                    System.out.println("Exception in InsertCust "+e);
                }
    }

}

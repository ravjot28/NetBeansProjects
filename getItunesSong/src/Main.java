
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
public class Main {
Connection con;
    Statement stmt;
    public static void main(String ar[])
    {
        new Main();
    }
    private final ResultSet res;

    public Main()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+"Apne DB ka complete path eg.: C:\\Temp\\details.mdb";
            con = DriverManager.getConnection(driver,"","");
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from details where Project_Name= '"+modelname+"'");
            int count=0;
            while(res.next())
            {

                System.out.println(Integer.parseInt(res.getString("Effort")));
                        }
               con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(0);
        }
    }

}

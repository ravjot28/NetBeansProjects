
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC
{
    public static void main(String asda[]) throws ClassNotFoundException, SQLException
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String myDB ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Users\\Rav\\Documents\\EnggAirlines.mdb";
        Connection con = DriverManager.getConnection(myDB,"","");
        java.sql.Statement sta = con.createStatement();
        ResultSet res = sta.executeQuery("SELECT * FROM EnggDept");
            int i = 0;
            while (res.next()) {
                i++;
            }
            System.out.println(i);
    }

}

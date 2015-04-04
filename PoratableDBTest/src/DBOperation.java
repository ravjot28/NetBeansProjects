import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperation {

    String command ="";

    public DBOperation(String command){
        this.command = command;
    }

    public void process(){
         try{
         System.out.println("Inside Add Item Method");
        String url = "jdbc:mysql://localhost:3306/";
        String db = "dummydatabase";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "12345";
        Connection con = null;

        Class.forName(driver);
        con = DriverManager.getConnection(url+db, user, pass);
        con.setAutoCommit(false);
        con.commit();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(command);
        con.commit();
      } catch (SQLException ex) {
               ex.printStackTrace();
      } catch(Exception e){
            e.printStackTrace();
      }
    }
}

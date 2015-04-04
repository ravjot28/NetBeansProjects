import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main 
{
    String dir=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/";
    int c=0;
    public static void main(String asd[])
    {
        new Main();
    }

    Main()
    {
        try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         }catch(Exception e){}
        File f=new File(dir);
        if(f.exists())
        {
            if(check())
     {
         JOptionPane.showMessageDialog(null, "Please enter the DOB and DOJ file first.","Error",JOptionPane.ERROR_MESSAGE);
         new Installation(-1).filecho();
     }
        else
        {

            String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
            new GUI(dir1+"MDB/"+"Emp.mdb").setVisible(true);
            }
        }
        else
        {
            new Installation(0).setVisible(true);
        }
        
    }

    public boolean check()
    {
        String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
        String add=dir1+"MDB/"+"Emp.mdb";
        Connection con = null;
        boolean bb=true;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+add;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM EMP");
            while(res.next())
            {
                String p=res.getString("DOB");
                String q=res.getString("DOJ");
                if((p.length()!=10)||(q.length()!=10))
                {
                    c++;
                    break;
                }
 else
                {
                    c=-90;
 }
            }
      res.close();
      sta.close();
      con.close();
        }catch(Exception asd){}
        if(c!=-90)
        {
            return true;
        }
        return false;
    }
}

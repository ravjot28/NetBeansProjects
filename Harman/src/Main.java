
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;


public class Main
{
    public static void main(String asdasd[])
    {
        File f=new File("Bin/Message");
        if(f.exists())
        {
            java.awt.EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new login().setVisible(true);
                    }
                });
        }
        else
        {
            (new File("Bin/Message")).mkdir();
            String empids[]=new Main().getempids();
            for(int i=0;i<empids.length;i++)
            {
                (new File("Bin/Message/"+empids[i])).mkdir();
                System.out.println(i);
            }
            java.awt.EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new login().setVisible(true);
                    }
                });
        }
    }

    public String[] getempids()
    {
        String a[] = null;
        String p="";
         Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=D:/Harman.mdb";
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM exitmanag where roles='E'");
            while(res.next())
            {
                p=p+res.getString("emp_id")+",";
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {    }
         StringTokenizer t=new StringTokenizer(p,",");
         a=new String[t.countTokens()];
         int i=0;
         System.out.println(t.countTokens());
         while(t.hasMoreTokens())
         {
             a[i]=t.nextToken();
             i++;
         }
        return a;
    }

}

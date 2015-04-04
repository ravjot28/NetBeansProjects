package delete;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import process.ModifyAdmin;
import sendnrecievedata.SendAdmin;


public class del implements Runnable
{
    String empno="";
    public del(String e)
    {
        this.empno = e;
    }

    public void run()
    {
        ModifyAdmin ma = new ModifyAdmin();
        String data[] = ma.process();

        String temp="";

        StringTokenizer s = new StringTokenizer(data[0],",");
        while(s.hasMoreTokens())
        {
            String t = s.nextToken();

            if(!(t.trim().equals("") || t.trim().equals(empno)))
            {
                temp+=t+",";
            }
        }

        SendAdmin sa= new SendAdmin("1",temp);
        if(sa.process())
        {
            JOptionPane.showMessageDialog(null,"Admin Deleted","Alert",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}

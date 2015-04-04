package Requests;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import process.GetAdmin;
import process.GetAdminRequests;
import support.CheckInternetConnection;

public class RecieveRequests implements Runnable
{
    Thread th;

    public void process()
    {
        th = new Thread(this);
        th.start();
    }

    public void run()
    {
        if(new CheckInternetConnection().process())
        {
            PleaseWait pw = new PleaseWait();
            pw.setVisible(true);
            GetAdminRequests ger = new GetAdminRequests();
            String[][] data = ger.process();

            String admin_list[] = new GetAdmin().process();


            if(data == null)
            {
                JOptionPane.showMessageDialog(null,"No Requests Present","Information",JOptionPane.INFORMATION_MESSAGE);
                pw.dispose();
            }
            else
            {
                if(admin_list == null)
                {
                    JOptionPane.showMessageDialog(null,"There are "+data.length+" requests","Alert",JOptionPane.INFORMATION_MESSAGE);
                    pw.dispose();
                    for(int i=0;i<data.length;i++)
                    {
                        String subject = data[i][0];
                        String body = data[i][1];
                        StringTokenizer s1 = new StringTokenizer(subject,"R");
                        String staffno = s1.nextToken();
                        int messageno = Integer.parseInt(s1.nextToken());
                        StringTokenizer s2 = new StringTokenizer(body,"$$$");
                        String emailid = s2.nextToken();
                        String dob = s2.nextToken();
                        new AdminDetailsFrame(staffno,emailid,dob,messageno).setVisible(true);
                    }
                }
                else
                {
                    StringTokenizer list = new StringTokenizer(admin_list[0],",");

                    if(list.countTokens()<5)
                    {
                        JOptionPane.showMessageDialog(null,"There are "+data.length+" requests","Alert",JOptionPane.INFORMATION_MESSAGE);
                        pw.dispose();
                        for(int i=0;i<data.length;i++)
                        {
                            String subject = data[i][0];
                            String body = data[i][1];

                            StringTokenizer s1 = new StringTokenizer(subject,"R");
                            String staffno = s1.nextToken();
                            int messageno = Integer.parseInt(s1.nextToken());

                            StringTokenizer s2 = new StringTokenizer(body,"$$$");
                            String emailid = s2.nextToken();
                            String dob = s2.nextToken();

                            new AdminDetailsFrame(staffno,emailid,dob,messageno).setVisible(true);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Oops!! Admin Limit is full","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

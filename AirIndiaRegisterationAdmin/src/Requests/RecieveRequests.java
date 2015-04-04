package Requests;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import process.GetEmployeeRequests;
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
            GetEmployeeRequests ger = new GetEmployeeRequests();
            String[][] data = ger.process();

            if(data == null)
            {
                JOptionPane.showMessageDialog(null,"No Requests Present","Information",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {

                JOptionPane.showMessageDialog(null,"There are "+data.length+" requests","Alert",JOptionPane.INFORMATION_MESSAGE);
            
                for(int i=0;i<data.length;i++)
                {
                    String subject = data[i][0];
                    String body = data[i][1];

                    StringTokenizer s1 = new StringTokenizer(subject,"R");
                    String e = s1.nextToken();
                    int number = Integer.parseInt(s1.nextToken().trim());

                    StringTokenizer s2 = new StringTokenizer(body,"$$$");
                    String emp = s2.nextToken();
                    String nomi = s2.nextToken();

                    StringTokenizer empp = new StringTokenizer(emp,"^");
                    String information[] = new String[empp.countTokens()];
                    int j=0;
                    while(empp.hasMoreTokens())
                    {
                        information[j] = empp.nextToken().trim();
                        j++;
                    }
                    ArrayList<String> nominations = new ArrayList<String>();
                    StringTokenizer nomina = new StringTokenizer(nomi,"^");
                    while(nomina.hasMoreTokens())
                        nominations.add(nomina.nextToken().trim());

                    if(e.charAt(0) == 'E')
                    {
                        if(new File("Bin"+System.getProperty("file.separator")+"Data"+System.getProperty("file.separator")+information[1]).exists())
                        {
                            new EmployeeDetailsFrame(information,nominations,number,true).setVisible(true);
                        }
                    }
                    else
                        new EmployeeDetailsFrame(information,nominations,number,false).setVisible(true);
                }
                pw.dispose();
            }
        }   
        else
        {
            JOptionPane.showMessageDialog(null,"Oops!! No Internet Connection","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

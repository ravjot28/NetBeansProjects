package download;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import process.GetAllEmployeeRequest;
import support.CheckInternetConnection;

public class RecieveAllRequests implements Runnable
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
            Wait pw = new Wait();
            pw.setVisible(true);
            GetAllEmployeeRequest ger = new GetAllEmployeeRequest();
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

                    System.out.println(subject+" "+body);
                    StringTokenizer s = new StringTokenizer(subject,"R");
                    String fname = s.nextToken();

                    if(!new File("Bin"+System.getProperty("file.separator")+"Data").exists())
                    {
                        new File("Bin"+System.getProperty("file.separator")+"Data").mkdirs();
                    }

                    if(new File("Bin"+System.getProperty("file.separator")+"Data"+System.getProperty("file.separator")+fname+".txt").exists())
                    {
                        continue;
                    }
                    try
                    {
                        BufferedWriter b = new BufferedWriter(new FileWriter("Bin"+System.getProperty("file.separator")+"Data"+System.getProperty("file.separator")+fname+".txt"));
                        b.append(body);
                        b.close();
                    }catch(Exception ae){}
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

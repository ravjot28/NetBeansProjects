package ravrun;

import javax.swing.JOptionPane;

public class Rav implements Runnable
{
    public Thread t=new Thread(this);
    public String fname;

    public Rav(String url)
    {
        fname=url;
    }

    public void execute()
    {
        t.start();
    }

    public void run()
    {
        String cmd1="rundll32" + " " + "url.dll,FileProtocolHandler" + " "+fname;
        try
        {
            Runtime.getRuntime().exec(cmd1);
        } catch (Exception ex)
            {
                if(ex.toString().contains("java.io.IOException: Cannot run program \"rundll32\""))
                {
                    try
                    {
                        Runtime rt=Runtime.getRuntime();
                        rt.exec("open "+fname);
                    }catch(Exception as)
                        {
                            JOptionPane.showMessageDialog(null, "Open the Link:"+fname, "", JOptionPane.INFORMATION_MESSAGE);
                        }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Open the Link:"+fname, "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
    }

    public static void main(String a[])
    {
        
    }

}

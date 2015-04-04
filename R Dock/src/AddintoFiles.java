import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class AddintoFiles implements Runnable
{
    List f;
    String fname="Bin\\App\\Items\\DockItems.ravs";
    Thread t=new Thread(this);

    AddintoFiles(List l)
    {
        f=l;
        r();
    }

    public void r()
    {
        t.start();
    }

    public void run()
    {
        int i=0;
        BufferedWriter bb = null;
        try {
            bb = new BufferedWriter(new FileWriter(fname, true));
            StringTokenizer rav = new StringTokenizer(f.toString().substring(1, f.toString().length() - 1), ",");
            while (rav.hasMoreTokens())
            {
                String rr=rav.nextToken();
                if(new CheckDuplicates().ch(rr))
                {
                    JOptionPane.showMessageDialog(null,"Can not Add Duplicate Items","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    bb.append(rr);
                    bb.newLine();
                }
            }
            bb.close();
        } catch (IOException ex) { }
    }
}

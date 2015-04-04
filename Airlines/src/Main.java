import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;


public class Main
{
    public static void main(String asd[])
    {
        String rav = null;
        File f=new File("Bin//Data//db.ravs");
        if((f.exists())&&(f.length()!=0))
        {
            try
        {
            BufferedReader bb=new BufferedReader(new FileReader("Bin/Data/db.ravs"));
            rav=bb.readLine();
            bb.close();
        }catch(Exception sad){}
            Base64Decoder bbb= new Base64Decoder(rav);
                               Base64Decoder bbb1= new Base64Decoder(bbb.get());
                               Base64Decoder bbb2= new Base64Decoder(bbb1.get());
                               String rav1=bbb2.get();
            if((new File(rav1).exists())&&(new File(rav1).canWrite()))
            {
                        new GUI(rav1).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please choose another as this file is set Read-Only or it do not exists","Error",JOptionPane.ERROR_MESSAGE);
                new Installation().setVisible(true);
            }
        }
        else
        {
            new Main().mk("Bin/data");
            EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Installation().setVisible(true);
            }
        });
        }
     }

     public void mk(String strManyDirectories)
   {
       boolean success = (new File(strManyDirectories)).mkdir();
       if(success)
       {
       }
  }

}

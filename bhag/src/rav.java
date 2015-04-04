import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class rav extends JFrame implements ActionListener
{
JButton B1,B2;
String str;
JFrame f1;
public rav()
{
f1=new JFrame("Dock");
B1=new JButton("+");

Font f=new Font("Times New Roman",Font.BOLD,40);
B1.setFont(f);

B1.setBounds(75,0,40,40);

f1.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
          }
        }
      );
f1.setLayout(new GridLayout(1,3));

B1.addActionListener(this);
f1.add(new JPanel());
f1.add(new JPanel());
f1.add(B1);
f1.setBackground(Color.yellow);
f1.setForeground(Color.white);

f1.pack();
f1.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
str=ae.getActionCommand();
if(str.equals("+"))
{
FileDialog fd=new FileDialog(rav.this,"Select Dock Item");
fd.setVisible(true);

String fn=fd.getDirectory()+ fd.getFile();

if((fn=fd.getFile())!=null)
{
BufferedWriter pw=null;
BufferedReader br;
fn=fd.getDirectory()+fd.getFile();
if(check(fn))
{
JOptionPane.showMessageDialog(null,"Oops The Dock Item You Want To Add is Already Present..","Alert",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
new rav();
}
else
{
try
{
pw=new BufferedWriter(new FileWriter("DockItems.txt",true));
pw.append(fn);
pw.newLine();
pw.close();
fd.setVisible(false);
setVisible(false);
f1.dispose();
new rav();
}catch(Exception rr){}
}
}


}
}
class MyWindowAdapter extends WindowAdapter
{
rav sampleFrame;
public MyWindowAdapter(rav sampleFrame)
{
this.sampleFrame=sampleFrame;
}
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
    }

 public boolean check(String a)
    {
        boolean p=false;
        String b=null;
        try
        {
           BufferedReader b2=new BufferedReader(new FileReader("DockItems.txt"));
           b=b2.readLine();
           while(b!=null)
           {
                if(b.equalsIgnoreCase(a))
                {
                    p=true;
                    break;
                }
                b=b2.readLine();
           }
        }catch(Exception e){}
        return p;
    }


public static void main(String args[]) throws IOException
{
new rav();
}
}
//FileDialog.LOAD
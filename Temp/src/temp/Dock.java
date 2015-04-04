package temp;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Dock extends JFrame implements ActionListener
{
JButton B1,B2;
String str;
JFrame f1;
public Dock()
{
f1=new JFrame("Dock");
B1=new JButton("+");

Font f=new Font("Times New Roman",Font.BOLD,40);
B1.setFont(f);

B1.setBounds(75,0,40,40);

MyWindowAdapter adapter=new MyWindowAdapter(this);
f1.addWindowListener(adapter);
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
FileDialog fd=new FileDialog(Dock.this,"Select Dock Item");
fd.setVisible(true);
//StringBuffer sb=new StringBuffer(40);
String fn=fd.getDirectory()+ fd.getFile();

if((fn=fd.getFile())!=null)
{
BufferedWriter pw=null;
fn=fd.getDirectory()+fd.getFile();
if(fn==null)
{
JOptionPane.showMessageDialog(null,"Oops The Dock Item You Want To Add is Already Present..","Alert",JOptionPane.INFORMATION_MESSAGE);
setVisible(false);
new Dock();
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
new Dock();
}catch(Exception rr){}
}
}


}
}
class MyWindowAdapter extends WindowAdapter
{
Dock sampleFrame;
public MyWindowAdapter(Dock sampleFrame)
{
this.sampleFrame=sampleFrame;
}
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
    }

public static void main(String str[])
{
new Dock();
}
}
//FileDialog.LOAD
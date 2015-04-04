import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
public class NewClass2 extends JFrame implements ActionListener
{
    public String a[];
    static int c=-1;
    JButton add;
    JButton finish;
    JFrame f;
    JPanel p,p1;
    JLabel l[];

    public static void main(String args[])
    {
        new NewClass2();
    }
    public NewClass2()
    {
        a=new String[100];
        l=new JLabel[100];
        add=new JButton("Add");
        finish=new JButton("Finish");
        f=new JFrame("Attachement");
        p1=new JPanel();
        launch();
    }

    public void launch()
    {
        int line=getNumberOfLines("att.ravs");
        p=new JPanel(new GridLayout(line,1));
        f.setLayout(new BorderLayout());
        p1.add(add);
        p1.add(finish);
        add.addActionListener(this);
        finish.addActionListener(this);
        String data=null;
        JCheckBox l[]=new JCheckBox[line];
        for(int i=0;i<line;i++)
        {
            l[i]=new JCheckBox("",true);
        }
        try
        {
            BufferedReader b=new BufferedReader(new FileReader("att.ravs"));
            data=b.readLine();
        for(int i=0;i<line;i++)
        {
            l[i].setText(data);
            data=b.readLine();
        }
        }catch(Exception e){}
        for(int j=0;j<line;j++)
        {
            p.add(l[j]);
        }
        f.add(p,BorderLayout.CENTER);
        f.add(p1,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public int getNumberOfLines(String name) {
		int numberOfLines = 0;


		LineNumberReader lineCounter = null;
		try {
			lineCounter = new LineNumberReader(new FileReader(name));
			while ((lineCounter.readLine()) != null) {
				continue;
			}
			numberOfLines = lineCounter.getLineNumber();

		} catch (IOException e)
                {
		}

		return numberOfLines;
	}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Add"))
        {
            c++;
            String fn=null;
            FileDialog fd=new FileDialog(NewClass2.this,"Select Dock Item",FileDialog.LOAD);
                                    fd.show();
                                    if((fn=fd.getFile())!=null)
                                    {
                                        fn=fd.getDirectory()+fd.getFile();
                                        a[c]=fn;
                                    }
                                    try
                                    {
                                        BufferedWriter b=new BufferedWriter(new FileWriter("att.ravs",true));
                                        b.append(fn);
                                        b.newLine();
                                        b.close();
                                    }catch(Exception e23){}
                                    f.setVisible(false);
                                    new NewClass2();
        }
        else
        {
            try
                                    {
                                        BufferedWriter b=new BufferedWriter(new FileWriter("att.ravs"));
                                        b.append("");
                                        b.close();
                                    }catch(Exception e23){}
            f.setVisible(false);
        }
    }


}

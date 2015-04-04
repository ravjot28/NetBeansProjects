import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.swing.*;
public class attachementMail extends JFrame implements ActionListener
{
    JFrame f;
    JPanel p1,p2;
    JButton add,finish;
    JCheckBox b[];

    public attachementMail()
    {
        f=new JFrame("Attachement");
        p2=new JPanel();
        add=new JButton("Add");
        finish=new JButton("Finish");
        launch();
    }

    public void launch()
    {
        LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        int line=getNumberOfLines("att.ravs");
        b=new JCheckBox[line];
        String data=null;
        f.setLayout(new BorderLayout());
        p2.add(add);
        p2.add(finish);
        add.addActionListener(this);
        finish.addActionListener(this);
        p1=new JPanel(new GridLayout(line,1));
        try
        {
            BufferedReader bb=new BufferedReader(new FileReader("att.ravs"));
            data=bb.readLine();
        for(int i=0;i<line;i++)
        {
            b[i]=new JCheckBox(data,true);
            p1.add(b[i]);
            data=bb.readLine();
        }
            bb.close();
        }catch(Exception e){}
        f.add(p1,BorderLayout.CENTER);
        f.add(p2,BorderLayout.SOUTH);
        f.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        f.setVisible(false);     }    });
        f.setLocationRelativeTo(null);
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
        if(e.getActionCommand().equalsIgnoreCase("add"))
        {
            String fn;
            FileDialog fd=new FileDialog(attachementMail.this,"Select Dock Item",FileDialog.LOAD);
            fd.show();
            if((fn=fd.getFile())!=null)
            {
                fn=fd.getDirectory()+fd.getFile();
                try
                {
                    BufferedWriter b=new BufferedWriter(new FileWriter("att.ravs",true));
                    b.append(fn);
                    b.newLine();
                    b.close();
                }catch(Exception e1){}
            }
            f.setVisible(false);
            new attachementMail();
        }
        else
        {
            for(int i=0;i<getNumberOfLines("att.ravs");i++)
            {
                if(b[i].isSelected())
                {
                    try
                    {
                        BufferedWriter bd=new BufferedWriter(new FileWriter("attachment.ravs",true));
                        bd.append(b[i].getText());
                        bd.newLine();
                        bd.close();
                    }catch(Exception we){}
                }
            }
            f.setVisible(false);
        }
    }

}

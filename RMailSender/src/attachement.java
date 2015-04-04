import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
public class attachement extends JFrame
{
    JFrame f;
    JPanel p1,p2;
    JButton add,finish;
    JCheckBox b[];

    public attachement()
    {
        f=new JFrame("Attachement");
        p2=new JPanel();
        add=new JButton("Add");
        add.addActionListener(new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent ae)
                                    {
                                        int retVal;
                                        JFileChooser fc = new JFileChooser();
                                        fc.addChoosableFileFilter(new TextFilter());
                                        fc.setMultiSelectionEnabled(true);
                                        retVal = fc.showOpenDialog(fc);
                                        if (retVal == JFileChooser.APPROVE_OPTION)
                                        {
                                            String fn1 = fc.getSelectedFile().toString();
                                            try
                                            {
                                                BufferedWriter b=new BufferedWriter(new FileWriter("Bin/Temp/att.ravs",true));
                                                b.append(fn1);
                                                b.newLine();
                                                b.close();
                                            }catch(Exception e1){}
                                        }
                                        f.dispose();
                                        new attachement();
                                    }
        });
        finish=new JButton("Finish");
        finish.addActionListener(new ActionListener()
                                 {
                                    public void actionPerformed(ActionEvent ae)
                                    {
                                        int size=0;
                                        for(int i=0;i<getNumberOfLines("Bin/Temp/att.ravs");i++)
                                        {
                                            if(b[i].isSelected())
                                            {
                                                File file = new File(b[i].getText());
                                                size+=file.length();
                                            }
                                        }
                                        //System.out.println("Size "+size);
                                        if(size<=(1024*1024*20))
                                        {
                                            for(int i=0;i<getNumberOfLines("Bin/Temp/att.ravs");i++)
                                            {
                                                if(b[i].isSelected())
                                                {
                                                    try
                                                    {
                                                        BufferedWriter bd=new BufferedWriter(new FileWriter("Bin/Temp/attachment.ravs",true));
                                                        bd.append(b[i].getText());
                                                        bd.newLine();
                                                        bd.close();
                                                    }catch(Exception we){}
                                                }
                                            }
                                            try
                                            {
                                                BufferedWriter ba=new BufferedWriter(new FileWriter("Bin/Temp/att.ravs"));
                                                ba.append("");
                                                ba.close();

                                            }catch(Exception ada){}

                                            f.dispose();
                                        }
                                        else
                                        {
                                            JOptionPane.showMessageDialog(null,"OOPS!! Not more than 20 MB are allowed . Try Again","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                 });
        launch();
    }

    public void launch()
    {
        int line=getNumberOfLines("Bin/Temp/att.ravs");
        b=new JCheckBox[line];
        String data=null;
        f.setLayout(new BorderLayout());
        p2.add(add);
        p2.add(finish);
        p1=new JPanel(new GridLayout(line,1));
        try
        {
            BufferedReader bb=new BufferedReader(new FileReader("Bin/Temp/att.ravs"));
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
                            {
                                public void windowClosing(WindowEvent e)
                                {
                                    try
                                    {
                                        BufferedWriter ba=new BufferedWriter(new FileWriter("Bin/Temp/att.ravs"));
                                        BufferedWriter ba1=new BufferedWriter(new FileWriter("Bin/Temp/attachment.ravs"));
                                        ba.append("");
                                        ba1.append("");
                                        ba.close();
                                        ba1.close();
                                    }catch(Exception ada){}

                                    f.setVisible(false);
                                }
                            });
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
    }

    public int getNumberOfLines(String name)
    {
	int numberOfLines = 0;
        LineNumberReader lineCounter = null;
	try
        {
            lineCounter = new LineNumberReader(new FileReader(name));
            while ((lineCounter.readLine()) != null)
            {
                continue;
            }
            numberOfLines = lineCounter.getLineNumber();
	} catch (IOException e)
        {}
	return numberOfLines;
    }

     class TextFilter extends FileFilter
   {

  public boolean accept(File f)
  {
    if (f.isDirectory())
      return true;
    String s = f.getName();
    int i = s.lastIndexOf('.');

    if (i > 0 && i < s.length() - 1)
      if (!(s.substring(i + 1).toLowerCase().equals("exe")))
        return true;

    return false;
  }

  public String getDescription()
  {
    return "Except exe files";
  }

}
}

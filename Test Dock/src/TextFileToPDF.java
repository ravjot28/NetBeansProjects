import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;


public class TextFileToPDF extends JFrame implements ActionListener
{
    String source;
    String destination;
    String fd1=null;
    String fd2=null;
    JFrame f;
    JLabel l;
    JTextField t;
    JButton b1,b2;
    FileDialog fd;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    TextFileToPDF()
    {
        try
               {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception e) {   }
        f=new JFrame("Text to PDF");
        b1=new JButton("Source File");
        b1.addActionListener(this);
        b2=new JButton("Convert");
        b2.addActionListener(this);
        l=new JLabel("Enter the output file name:");
        t=new JTextField(10);
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        p.add(b1);
        p1.add(l);
        p1.add(t);
        p1.add(b2);
        f.setLayout(new GridLayout(2,1));
        f.add(p);
        f.add(p1);
        f.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        f.setVisible(false);      }    });
        f.setLocation((w/3), h/3);
        f.pack();
        f.setVisible(true);
    }

    public boolean check(int a)
    {
        File directory = new File(fd1);
             File[] files = directory.listFiles();
             for (int index = 0; index < files.length; index++)
             {
                 try
                 {
                    File frav=new File(files[index].toString());
                    if(frav.isFile())
                    {
                        System.out.println(destination +"   "+frav.getAbsolutePath());
                        if((frav.getAbsolutePath().equalsIgnoreCase(destination))&&(a==0))
                        {
                            JOptionPane.showMessageDialog(null,"Please enter your choice filename as same file is already present in the directory","Alert",JOptionPane.INFORMATION_MESSAGE);
                            return false;
                        }
                        else
                            if((frav.getAbsolutePath().equalsIgnoreCase(destination))&&(a==1))
                            {
                               JOptionPane.showMessageDialog(null,"Please choose another filename as same file is already present in the directory","Alert",JOptionPane.INFORMATION_MESSAGE);
                               return false;
                            }
                    }
                 }catch(Exception e){}
                 
             }
             return true;
    }

  void textpdf()
  {
    String result=null;
    BufferedReader input = null;
    Document output = null;
    String[] a=new String[2];
    a[0]=source;
    a[1]=destination;
    try
    {
      input = new BufferedReader (new FileReader(a[0]));
      output = new Document(PageSize.NOTE, 40, 40, 40, 40);
      PdfWriter.getInstance(output, new FileOutputStream (a[1]));
      output.open();
      output.addAuthor("Ravjot");
      output.addSubject(a[0]);
      output.addTitle(a[0]);
      String line = "";
      while(null != (line = input.readLine())) {
        if(line.equalsIgnoreCase(""))
        {
            Paragraph p = new Paragraph("                ");
            p.setAlignment(Element.ALIGN_CENTER);
            output.add(p);
        }
        else
        {
            Paragraph p = new Paragraph(line);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            output.add(p);
        }
      }
      result="Done. After Exiting this Alert window you will see your converted file !! Have Fun";
      output.close();
      input.close();
    }
    catch (Exception e) {
      result=e.getMessage();
    }
    JOptionPane.showMessageDialog(null,result,"Alert",JOptionPane.INFORMATION_MESSAGE);
    if(result.equalsIgnoreCase("Done. After Exiting this Alert window you will see your converted file !! Have Fun"))
    {
     try {
                    Process p = Runtime.getRuntime().exec("rundll32" + " " + "url.dll,FileProtocolHandler" + " " + destination);
                } catch (IOException ex) {  }
     
    }
    
  }

  /*public static void main(String rt[])
  {
      new TextFileToPDF();
  }*/

    public void actionPerformed(ActionEvent e)
    {
        int flag=-1;
        if((e.getActionCommand()).equals("Source File"))
        {

                fd=new FileDialog(TextFileToPDF.this,"Select Text File",FileDialog.LOAD);
                fd.show();
                fd.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        fd.setVisible(false);      }    });

                source=fd.getDirectory()+fd.getFile();
                fd1=fd.getDirectory();

                if(source.endsWith(".txt"))
                {
                    flag=0;
                }
                else
                 if((source.equalsIgnoreCase(""))||(source.equalsIgnoreCase("nullnull")))
                {
                }
                 else
                     if((!source.endsWith(".txt")))
                     {
                         JOptionPane.showMessageDialog(null,"Only .txt files are allowed","Alert",JOptionPane.INFORMATION_MESSAGE);
                     }
        }
        else
        {
            if(source==null)
            {
                JOptionPane.showMessageDialog(null,"Please Select the Source File","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                if((t.getText().equalsIgnoreCase(""))||(t.getText().equalsIgnoreCase(null)))
                {
                    String s=source.substring(source.lastIndexOf("\\")+1,source.lastIndexOf("."));
                    destination=fd1+s+".pdf";
                    if(check(0))
                    {
                        textpdf();
                    }
                }
                else
                {
                    if(t.getText().endsWith(".pdf"))
                    {
                        destination=fd1+t.getText();
                        if(check(1))
                        {
                            textpdf();
                        }
                    }
                    else
                    {
                        destination=fd1+t.getText()+".pdf";
                        if(check(1))
                        {
                            textpdf();
                        }
                    }
                }
                
            }
        }
    }
}
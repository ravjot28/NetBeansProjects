import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.FileDialog;
import java.awt.GridLayout;
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
    JButton b1,b2;
    FileDialog fd;
    TextFileToPDF()
    {
        f=new JFrame("Text to PDF");
        b1=new JButton("Source File");
        b1.addActionListener(this);
        b2=new JButton("Convert");
        b2.addActionListener(this);
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        p.add(b1);
        p1.add(b2);
        f.setLayout(new GridLayout(2,1));
        f.add(p);
        f.add(p1);
        f.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        f.pack();
        f.setVisible(true);
    }
  public static void main (String [] arg)
  {
      new TextFileToPDF();
  }


  void textpdf()
  {
      String result=null;
      BufferedReader input = null;
    Document output = null;
    String[] a=new String[2];
    a[0]=source;
    a[1]=destination;
    System.out.println("Convert text file to pdf");
    System.out.println("input  : " + a[0]);
    System.out.println("output : " + a[1]);
    try
    {
      input =
        new BufferedReader (new FileReader(a[0]));
      output = new Document(PageSize.LETTER, 40, 40, 40, 40);
      PdfWriter.getInstance(output, new FileOutputStream (a[1]));
      output.open();
      output.addAuthor("Ravjot");
      output.addSubject(a[0]);
      output.addTitle(a[0]);
      String line = "";
      while(null != (line = input.readLine())) {
        System.out.println(line);
        Paragraph p = new Paragraph(line);
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        output.add(p);
      }
      result="Done.";
      output.close();
      input.close();
    }
    catch (Exception e) {
      result=e.getMessage();
    }
    JOptionPane.showMessageDialog(null,result,"Alert",JOptionPane.INFORMATION_MESSAGE);
  }

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

                if(source.substring(source.lastIndexOf(".")+1).equalsIgnoreCase("txt"))
                {
                    flag=0;
                }
                else
                if(source!="")
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
                String s=source.substring(source.lastIndexOf("\\")+1,source.lastIndexOf("."));
                destination=fd1+s+".pdf";
                textpdf();
            }
        }
    }
}
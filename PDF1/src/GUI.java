import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame implements ActionListener,Runnable
{
    Thread th;
    String fname;
    String destination;
    JButton brow;
    JButton conv;
    JButton reset;
    JLabel srcl;
    JLabel opl;
    JSeparator Separator;
    JTextField src;
    JTextField op;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    InfiniteProgressPanel glassPane;

    public GUI()
    {
        initComponents();
    }

    private void initComponents()
    {
        look();
        glassPane = new InfiniteProgressPanel("Converting... Please Wait");
        srcl = new JLabel();
        src = new JTextField();
        brow = new JButton();
        opl = new JLabel();
        op = new JTextField();
        conv = new JButton();
        reset = new JButton();
        Separator = new JSeparator();

        setGlassPane(glassPane);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Txt To PDF");
        setBackground(new Color(255, 102, 51));
        setName("Txt To PDF"); // NOI18N

        srcl.setFont(new Font("Tahoma", 0, 18));
        srcl.setText("Source File");

        src.setFont(new Font("Tahoma", 0, 12));

        brow.setFont(new Font("Tahoma", 0, 16));
        brow.setText("Browse");


        opl.setFont(new Font("Tahoma", 0, 18));
        opl.setText("Convert File Name");

        op.setFont(new Font("Tahoma", 0, 12));

        conv.setFont(new Font("Tahoma", 0, 16));
        conv.setText("Convert");

        reset.setFont(new Font("Tahoma", 0, 16));
        reset.setText("Reset");

        brow.addActionListener(this);
        conv.addActionListener(this);
        reset.addActionListener(this);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(srcl)
                        .addGap(18, 18, 18)
                        .addComponent(src,GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(brow)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opl)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(reset)
                            .addComponent(op,GroupLayout.PREFERRED_SIZE, 145,GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(conv)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Separator,GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(brow)
                    .addComponent(srcl)
                    .addComponent(src,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(opl)
                    .addComponent(op,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(Separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(conv)
                    .addComponent(reset))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        //JFrame f=new JFrame("asdfas");
        setResizable(false);
        setLocation(h/2,w/7);
        pack();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("reset"))
        {
            src.setText("");
            op.setText("");
            src.setEditable(true);
            op.setEditable(true);
        }
        else
            if(e.getActionCommand().equalsIgnoreCase("browse"))
            {
                String fn=null;
                String fn1=null;
                FileDialog fd=new FileDialog(GUI.this,"Select the .txt File",FileDialog.LOAD);
                fd.show();
                if((fn=fd.getFile())!=null)
                {
                    if(fd.getFile().endsWith(".txt"))
                    {
                        src.setText(fd.getFile());
                        fname=fd.getDirectory()+fd.getFile();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Only .txt files are allowed.Please try again","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please select .txt file that you want to convert","Information",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
                if(e.getActionCommand().equalsIgnoreCase("convert"))
                {
                    if((fname.equalsIgnoreCase(""))||(fname.equalsIgnoreCase(null)))
                    {
                        JOptionPane.showMessageDialog(null,"First Choose the file name that is to be converted","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        if((op.getText().equalsIgnoreCase(""))||(op.getText().equalsIgnoreCase(null)))
                        {
                            destination=fname.substring(0,fname.lastIndexOf(".txt"))+".pdf";
                        }
                        else
                        {
                            if(op.getText().endsWith(".pdf"))
                            {
                                destination=fname.substring(0,fname.lastIndexOf("\\")+1)+op.getText();
                            }
                            else
                            {
                                destination=fname.substring(0,fname.lastIndexOf("\\")+1)+op.getText()+".pdf";
                            }
                        }
                        src.setEditable(false);
                        op.setEditable(false);
                        textpdf();//Doc2Pdf pdf=new Doc2Pdf();
                        
                    }
                    src.setText("");
                    op.setText("");
                    src.setEditable(true);
                    op.setEditable(true);
                }
    }

    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         }catch(Exception e){}
    }

    void textpdf()
  {
        th = null;
        th = new Thread(this);
        th.start();
      
    }

    public void run()
    {
        glassPane.start();
        String result=null;
      BufferedReader input = null;
    Document output = null;
    String[] a=new String[2];
    a[0]=fname;
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
      glassPane.stop();
                            JOptionPane.showMessageDialog(null,"Completed... Now the file will run after you exit this window","Information",JOptionPane.INFORMATION_MESSAGE);
                            try {
                    Process p = Runtime.getRuntime().exec("rundll32" + " " + "url.dll,FileProtocolHandler" + " " + destination);
                } catch (IOException ex) {  }
    }
    catch (Exception e) {
        glassPane.stop();
      JOptionPane.showMessageDialog(null,"File Cannot be converted","Error",JOptionPane.ERROR_MESSAGE);
    }
    }
    
  }

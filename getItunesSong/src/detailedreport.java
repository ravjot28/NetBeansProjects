import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class detailedreport extends JFrame implements ActionListener
{
    JButton j1,j2,j3;String modelname;
    Connection con;
    Statement stmt;
    ResultSet res;
    String s1, s2, s3, s4, s5, s6, s7, s8,model;
    JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8,l18a,pmodel;
    Container cp;
    Font f1;
    int x = 155, flag,i;
int[] S; String [] z;
    detailedreport(int flag,String modelname)
    {
        this.flag = flag;
         this.modelname=modelname;

        setLayout(null);
        cp = getContentPane();

        j1 = new JButton("OK");
        j2 = new JButton("Effort-Graph");
        j3 = new JButton("Time-Graph");

        if(flag == 0)
        {
            model = "Cocomo I-Basic Model";
            pmodel = new JLabel(modelname);
        }

        if (flag==1)
        {
            model = "Cocomo I-Intermediate Model";
            pmodel = new JLabel(modelname);
        }

        if (flag==2)
        {
            model = "Cocomo II-Application Composition Model ";
            pmodel = new JLabel(modelname);
        }
if (flag==3)
        {
            model = "Ccomo II-Early Design Model";
            pmodel = new JLabel(modelname);
        }

if (flag==4)
        {
            model = "Cocomo II-Post Architechtural Model";
            pmodel = new JLabel(modelname);
        }


        JLabel l1 = new JLabel("DETAILED SOFTWARE ESTIMATION REPORT");
        JLabel l11 = new JLabel("____________________________________");

        JLabel l12 = new JLabel("Project Name:");
      JLabel l21a = new JLabel("________________");
     JLabel l12a = new JLabel("Model");

        JLabel l2 = new JLabel("Analysis Timestamp");
        JLabel l21 = new JLabel("________________");
        JLabel l3 = new JLabel("Project Class");
        JLabel l31 = new JLabel("___________");
        JLabel l4 = new JLabel("Estimated Effort (person-months)");
        JLabel l41 = new JLabel("___________________________");
        JLabel l5 = new JLabel("Estimated Development Time");
        JLabel l51 = new JLabel("_______________________");
        JLabel l6 = new JLabel("Months");
        JLabel l61 = new JLabel("______");
        JLabel l7 = new JLabel("Days");
        JLabel l71 = new JLabel("____");
        JLabel l72 = new JLabel("Estimated People Required");
        JLabel l73 = new JLabel("______________________");
        JLabel l8 = new JLabel("Analysts");
        JLabel l81 = new JLabel("_______");
JLabel l18a = new JLabel("_____");
        JLabel l9 = new JLabel("Programmers");
        JLabel l91 = new JLabel("___________");

        f1 = new Font("Verdana",Font.BOLD,20);

        j1.setBounds(230,700,150,35);
        j2.setBounds(430,700,150,35);
        j3.setBounds(530,700,150,35);


        l1.setBounds(250,20,1000,25);
        l11.setBounds(250,25,1000,25);
        l12.setBounds(450,50,1000,25);
        pmodel.setBounds(550,50,1000,25);
        pmodel.setForeground(Color.red);

   l12a.setBounds(30,100,150,20)  ;
l18a.setBounds(30,105,150,20);
 l2.setBounds(310,100,150,20);
        l21.setBounds(310,105,150,20);

        l3.setBounds(470,100,150,20);
        l31.setBounds(470,105,150,20);

        l4.setBounds(600,100,200,20);
        l41.setBounds(600,105,200,20);

        l5.setBounds(820,100,200,20);
        l51.setBounds(820,105,200,20);

        l6.setBounds(820,130,80,20);
        l61.setBounds(820,135,80,20);

        l7.setBounds(920,130,50,20);
        l71.setBounds(920,135,50,20);

        l72.setBounds(1020,100,200,20);
        l73.setBounds(1020,105,200,20);

	l8.setBounds(1020,130,100,20);
        l81.setBounds(1020,135,100,20);

        l9.setBounds(1095,130,100,20);
        l91.setBounds(1095,135,100,20);

        l1.setFont(f1);
        l11.setFont(f1);
        l1.setForeground(Color.blue);
        l11.setForeground(Color.blue);

	j1.addActionListener(this);
                  j2.addActionListener(this);
                  j3.addActionListener(this);
        cp.add(j1);
        cp.add(j2);
         cp.add(j3);
       cp.add(l12a);
        cp.add(l1);
        cp.add(l11);
        cp.add(l12);
        cp.add(pmodel);
        cp.add(l2);
        cp.add(l21);
        cp.add(l3);
        cp.add(l31);
        cp.add(l4);
        cp.add(l41);
        cp.add(l5);
        cp.add(l51);
        cp.add(l6);
        cp.add(l61);
        cp.add(l7);
        cp.add(l71);
        cp.add(l72);
        cp.add(l73);
        cp.add(l8);
        cp.add(l81);
        cp.add(l9);
        cp.add(l91);
        cp.add(l18a);

        setTitle("Estimation Report");
        setSize(1324,800);
        setVisible(true);

         try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:details","","");
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from details where Project_Name= '"+modelname+"'");
            while(res.next())
            {
               s1 = res.getString(1);
               s2 = res.getString(3);
               s3 = res.getString(4);
               s4 = res.getString(5);
               s5 = res.getString(6);
               s6 = res.getString(7);
               s7 = res.getString(8);
               s8 = res.getString(9);

               lb1 = new JLabel(s1);
               lb2 = new JLabel(s2);
               lb3 = new JLabel(s3);
               lb4 = new JLabel(s4);
               lb5 = new JLabel(s5);
               lb6 = new JLabel(s6);
               lb7 = new JLabel(s7);
               lb8 = new JLabel(s8);

                          lb1.setForeground(Color.blue);
	       lb2.setForeground(Color.blue);
	       lb3.setForeground(Color.blue);
	       lb4.setForeground(Color.blue);
	       lb5.setForeground(Color.blue);
	       lb6.setForeground(Color.blue);
	       lb7.setForeground(Color.blue);
                          lb8.setForeground(Color.blue);

               lb1.setBounds(5,x,250,20);
               lb2.setBounds(250,x,230,20);
               lb3.setBounds(480,x,80,20);
               lb4.setBounds(680,x,100,20);
               lb5.setBounds(830,x,150,20);
               lb6.setBounds(930,x,50,20);
               lb7.setBounds(1035,x,50,20);
lb8.setBounds(1115,x,50,20);

               cp.add(lb1);
               cp.add(lb2);
               cp.add(lb3);
               cp.add(lb4);
               cp.add(lb5);
               cp.add(lb6);
               cp.add(lb7);
               cp.add(lb8);

               x = x + 20;
            }

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent ae)
    {

if(ae.getSource() == j2)
{
 try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:details","","");
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from details where Project_Name= '"+modelname+"'");
            if(res.next())
            {
               for(i=1;i<=5;i++)
              {
               S[i] = Integer.parseInt(res.getString("Effort"));
                     }   }
               con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.exit(0);
        }
String l[] = {"Basic Model ("+S[1]+" P-M)","Intermmediate ("+S[2]+" P-M)","Application Compositon ("+S[3]+" P-M)","Early Design ("+S[4]+" P-M)","Post Architechture ("+S[5]+" P-M)"};
                double v[] = {S[1],S[2],S[3],S[4],S[5]};
                new Chart1(v,l).setVisible(true);
}

        if(ae.getSource() == j1)

            this.setVisible(false);
    }

 class Chart1 extends JFrame
    {
        public Chart1(double[] value,String[] languages)
        {
            super("Chart");
            setSize(600,450);
            setLocation(300,100);

                    getContentPane().add(new SimpleBarChart(value, languages,"POST ARCHITECTURAL MODEL - EFFORT"));

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

}
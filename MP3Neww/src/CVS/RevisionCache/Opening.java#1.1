import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
public class Opening extends JFrame
{
    JFrame f,f1,ff;
    JButton n,exit,o;
    JTable table;
    JPanel pre;
    JScrollPane pane;
    JTextField t;
    public static void main(String as[])
    {
        new Opening();
    }

     public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
             //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
              //UIManager.setLookAndFeel("com.easynth.lookandfeel.EaSynthLookAndFeel");
             //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             /*System.setProperty("Quaqua.tabLayoutPolicy","wrap");
             UIManager.setLookAndFeel(
                  ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel()
              );*/
         }catch(Exception e){}
    }

    Opening()
    {
        look();
        f1=new JFrame("Rav's Media Player");
        f1.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\Icons\\r.gif"));
        f1.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        JPanel p=new JPanel();
        n=new JButton("New");
        o=new JButton("Open");
        exit=new JButton("Exit");
        p.add(n);
        p.add(o);
        p.add(exit);
        n.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    ff=new JFrame("Add New PlayList");
                                    JPanel pp=new JPanel();
                                    JButton add=new JButton("Add");
                                    JButton exit=new JButton("Exit");
                                    t=new JTextField(30);
                                    pp.add(t);
                                    pp.add(add);
                                    pp.add(exit);
                                    ff.add(pp);
                                    exit.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            ff.setVisible(false);
                                        }
                                    });
                                    add.addActionListener(new ActionListener()
                                    {
                                        
                                        public void actionPerformed(ActionEvent e)
                                        {
                                            ff.setVisible(false);
                                            if((t.getText()!="")&&(t.getText()!=null))
                                            {
                                                try
                                                {
                                                    BufferedWriter bf=new BufferedWriter(new FileWriter("Bin\\Playlist.rav",true));
                                                    bf.append(t.getText());
                                                    bf.newLine();
                                                    bf.close();
                                                }catch(Exception eee){}
                                            }
                                        }
                                    });
                                    ff.pack();
                                    ff.setLocationRelativeTo(f1);
                                    ff.setVisible(true);

                                }
                            });
        o.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                     tablee();
                                }
                            });

         exit.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    System.exit(0);
                                }
                            });
                            f1.add(p);
                            f1.pack();
                            f1.setLocationRelativeTo(null);
                            f1.setVisible(true);
    }

    public void tablee()
    {
        f=new JFrame("Tabel");
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\Icons\\r.gif"));
        pre=new JPanel();
        String[] columnNames = {"Number","Playlist"};
        Object[][] data =new Object[getNumberOfLines("Bin\\Playlist.rav")][2];
        int i=1;
        String data1=null;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader("Bin\\Playlist.rav"));
            data1=b.readLine();
            while(data1!=null)
            {
                data[i-1][0]=new Integer(i);
                data[i-1][1]=data1;
                data1=b.readLine();
                i++;
            }
        }catch(Exception e){}

        table = new JTable(data, columnNames){
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;   //Disallow the editing of any cell
      }
    };
    TableColumn column = null;
for (int i1 = 0; i1 < 2; i1++) {
    column = table.getColumnModel().getColumn(i1);
    if (i1 == 1) {
        column.setPreferredWidth(300); //third column is bigger
    } else {
        column.setPreferredWidth(50);
    }
}
    pane = new JScrollPane(table);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
   table.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent e){
      if (e.getClickCount() == 2)
      {
          int[] selRows;
          Object value;
         selRows = table.getSelectedRows();
         if (selRows.length > 0) {
          TableModel tm = table.getModel();
          value = tm.getValueAt(selRows[0],1);
          String ravs=value.toString();
          ravs="Bin\\"+ravs+".txt";
          f1.setVisible(false);
          f.setVisible(false);
          new GUI(ravs);
         }
      }
      }
     } );
pre.setLayout(new BorderLayout());
pre.add(table.getTableHeader(),BorderLayout.PAGE_START);
pre.add(pane, BorderLayout.CENTER);
f.add(pre);
f.setLocationByPlatform(true);
f.setSize(385,350);
f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {              }    });
//f.setUndecorated(true);
f.setLocationRelativeTo(f1);
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

}

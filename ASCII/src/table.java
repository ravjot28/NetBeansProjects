import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class table extends JFrame
{
    JFrame f;
    public table()
    {
        f=new JFrame("Tabel");
        JPanel pre=new JPanel();
        String[] columnNames = {"Number","Song"};
        Object[][] data =new Object[getNumberOfLines("list.txt")][2];
        int i=1;
        String data1=null;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader("list.txt"));
            data1=b.readLine();
            while(data1!=null)
            {
                data[i-1][0]=new Integer(i);
                data[i-1][1]=data1.substring(data1.lastIndexOf("\\")+1,data1.lastIndexOf("."));
                data1=b.readLine();
                i++;
            }
        }catch(Exception e){}

        JTable table = new JTable(data, columnNames){
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
        JTableHeader header = table.getTableHeader();
    header.setBackground(Color.yellow);
    JScrollPane pane = new JScrollPane(table);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
pre.setLayout(new BorderLayout());
pre.add(table.getTableHeader(), BorderLayout.PAGE_START);
pre.add(pane, BorderLayout.CENTER);
f.add(pre);
f.setSize(385,350);
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
public static void main(String args[])
{
    new table();
}
}

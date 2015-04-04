/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.table.*;

class JTableExample extends JFrame
{
private DefaultTableCellRenderer renderer;
private JTable table;
private int selectRow, selectColumn;

public JTableExample(){
JDesktopPane desktop = new JDesktopPane(); //a specialized layered pane
desktop.setLayout(new BorderLayout());

createJTable();

JButton button = new JButton("PRESS");
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

selectRow = 0; // pick a row 0-2
selectColumn = 0; // pick a column 0-2
renderer.setBackground(Color.red);
table.getCellRenderer(0,0);
table.repaint();
}
});


JPanel jpanel = new JPanel();
jpanel.add(new JLabel("Table"),BorderLayout.NORTH);
jpanel.add(button,BorderLayout.CENTER);
jpanel.add(table,BorderLayout.SOUTH);
desktop.add(jpanel);
desktop.repaint();

setContentPane(desktop);
setSize(300,300);
//pack();

addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {
System.exit(0);
}
});

}

private void createJTable(){
Object[] columns = new Object[]{"First","Last","Sex"};

Object[][] data = new Object[][]{{"Tom","Smith","Male"},
{"Dick","Johnson","Male"},
{"Jane","Brooks","Female"}};


renderer = new DefaultTableCellRenderer();


table = new JTable(data,columns){
public TableCellRenderer getCellRenderer(int row, int column) {

if ((row == selectRow) && (column == selectColumn) )
return renderer;
// else...
return super.getCellRenderer(row, column);
}

};
}
public static void main(String[] args) {

JTableExample app = new JTableExample();
app.setVisible(true);

}
}
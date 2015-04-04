package kj;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class MainFrame
{
    JFrame frame;
    PlayListTable pt;
    SongList sl;
    String list[][]={{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""}};
    String songlist[][]={{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""}};

    public static void main(String a[])
    {
        new MainFrame();
    }

    public MainFrame()
    {
        frame = new JFrame("Hi");
        pt = new PlayListTable(list);
        create();
    }

    public void create()
    {
        frame.add(pt,BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    

    public class PlayListTable extends javax.swing.JPanel

    {

        String playlist[][];


        public PlayListTable(String list[][])

        {
        
            playlist = list;

            initComponents();

        }
    
        private void initComponents()
        {


            jButton1 = new javax.swing.JButton();

            jLabel1 = new javax.swing.JLabel();

            jScrollPane1 = new javax.swing.JScrollPane();

            jTable1 = new javax.swing.JTable();


            jButton1.setText("+");


            jButton1.addActionListener(new ActionListener()

            {

                public void actionPerformed(ActionEvent ae)

                {

                    new nameplay().setVisible(true);

                }

            });


            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

            jLabel1.setText("PlayList");


            jTable1.setModel(new javax.swing.table.DefaultTableModel(

                    playlist,

                    new String [] {

                "Playlist Name"

            }

            ) {

                Class[] types = new Class [] {

                    java.lang.String.class

                };

                boolean[] canEdit = new boolean [] {

                    false

                };


                public Class getColumnClass(int columnIndex) {

                    return types [columnIndex];

                }


                public boolean isCellEditable(int rowIndex, int columnIndex) {

                    return canEdit [columnIndex];

                }

            });


            jTable1.addMouseListener(new MouseAdapter(){

                public void mouseClicked(MouseEvent e){

                    if (e.getClickCount() == 2)

                    {

                        int[] selRows;

                        Object value;

                        selRows = jTable1.getSelectedRows();

                        if (selRows.length > 0)

                        {

                            TableModel tm = jTable1.getModel();

                            value = tm.getValueAt(selRows[0],0);

                            String check = ""+value;

                            if(check.length()>0)

                            {

                                SongListFrame sf = new SongListFrame((String) value,songlist);

                                sf.create();

                            }

                        }

                    }

                }

            } );

            jTable1.setColumnSelectionAllowed(true);

            jScrollPane1.setViewportView(jTable1);

            jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);


            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);

            this.setLayout(layout);

            layout.setHorizontalGroup(

                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                        .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton1)
                    .addContainerGap())
            );
        }

        public void setList(String[][] l)
        {
            playlist = l;
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                playlist,
                new String [] {
                    "Playlist Name"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jTable1.repaint();
            jTable1.revalidate();
            repaint();
            revalidate();
        }

        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;

    }

    class nameplay extends JFrame
    {
        JLabel lab;
        JPanel p;
        String s;
        JTextField t;

        nameplay()
	{

            name();
	}

        public void name()
	{

            this.setLayout(new FlowLayout());

            JLabel lab2=new JLabel("NAME PLAYLIST");

            t=new JTextField(20);



            JButton b2=new JButton("OK");

            JButton b3=new JButton("CANCEL");

            this.add(lab2);

            this.add(t);

            this.add(b2);

            this.add(b3);

            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            this.pack();



            b2.addActionListener (new ActionListener()

            {

                public void actionPerformed(ActionEvent ae)

                {

                    for(int i=0;i<list.length;i++)

                    {

                        if(list[i][0].trim().equals(""))

                        {

                            list[i][0] = t.getText().trim();

                            break;

                        }

                    }

                    pt.setList(list);

                    dispose();

                }


            });




            b3.addActionListener (new ActionListener()

            {

                public void actionPerformed(ActionEvent ae)

                {

                    dispose();

                }

            });


        }

    }


    class SongListFrame

    {

        String name;

        String[][] s;

        public SongListFrame(String name,String[][] s)

        {

            this.name = name;

            this.s = s;

        }


        public void create()

        {

            JFrame f = new JFrame(name);

            sl = new SongList(name,s);

            f.add(sl);

            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            f.pack();

            f.setVisible(true);

        }

    }


    class SongList extends javax.swing.JPanel
    {


        String songlist[][];

        String playlistname;
    

        public SongList(String pname,String[][] s) {
        songlist = s;
        playlistname = pname;
        initComponents();

        }

        private void initComponents() {


            jScrollPane1 = new javax.swing.JScrollPane();

            jTable1 = new javax.swing.JTable();

            jLabel1 = new javax.swing.JLabel();

            jButton1 = new javax.swing.JButton();

            jButton2 = new javax.swing.JButton();


            jTable1.setModel(new javax.swing.table.DefaultTableModel(

                    songlist,

                    new String [] {

                "#", "Song Name"

            }

            ) {

                Class[] types = new Class [] {

                    java.lang.Integer.class, java.lang.String.class

                };

                boolean[] canEdit = new boolean [] {



                    false, false



                };





                public Class getColumnClass(int columnIndex) {

                    return types [columnIndex];

                }


                public boolean isCellEditable(int rowIndex, int columnIndex) {

                    return canEdit [columnIndex];



                }



            });


            jScrollPane1.setViewportView(jTable1);


            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

            jLabel1.setText(playlistname);



            jButton1.setText("Add File");


            jButton2.setText("Add Folder");


            TableColumn col = jTable1.getColumnModel().getColumn(0);

            int width = 100;

            col.setPreferredWidth(width);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);

            this.setLayout(layout);

            layout.setHorizontalGroup(

                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(layout.createSequentialGroup()

                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(layout.createSequentialGroup()

                    .addGap(140, 140, 140)

                    .addComponent(jLabel1))

                    .addGroup(layout.createSequentialGroup()

                    .addContainerGap()

                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)

                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()

                    .addComponent(jButton1)

                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                    .addComponent(jButton2))

                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))

                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                    );

            layout.setVerticalGroup(

                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(layout.createSequentialGroup()

                    .addGap(4, 4, 4)

                    .addComponent(jLabel1)


                    .addGap(18, 18, 18)

                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addGap(18, 18, 18)

                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                    .addComponent(jButton1)

                    .addComponent(jButton2))

                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                    );

        }

        public void setList(String[][] l)

        {

            songlist = l;

            jTable1.setModel(new javax.swing.table.DefaultTableModel(

                    songlist,

                    new String [] {

                "#", "Song Name"

            }

            ) {

                Class[] types = new Class [] {

                    java.lang.Integer.class, java.lang.String.class

                };

                boolean[] canEdit = new boolean [] {

                    false, false

                };



                public Class getColumnClass(int columnIndex) {

                    return types [columnIndex];

                }



                public boolean isCellEditable(int rowIndex, int columnIndex) {

                    return canEdit [columnIndex];

                }

            });

            jTable1.repaint();

            jTable1.revalidate();


            repaint();

            revalidate();

        }

        private javax.swing.JButton jButton1;

        private javax.swing.JButton jButton2;

        private javax.swing.JLabel jLabel1;

        private javax.swing.JScrollPane jScrollPane1;

        private javax.swing.JTable jTable1;

        // End of variables declaration



    }

}

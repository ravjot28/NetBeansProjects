

package mediaplayer;




import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class MainFrame11
{
    JFrame frame;
    PlayListTable pt;
    SongList sl;
    String songlist[][]={{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""}};

    String list[][];
    public MainFrame11(String l[][])
    {
        this.list = l;
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

                    {   repaint();

                        int[] selRows;

                        Object value;

                        selRows = jTable1.getSelectedRows();

                        if (selRows.length > 0)

                        {

                            TableModel tm = jTable1.getModel();

                            value = tm.getValueAt(selRows[0],0);

                            String check = ""+value;

                 ArrayList<String> a = new ArrayList<String>();
       File f=new File("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+value+".tan");
           if(f.exists())
           {     String [][]sl;
             try
                {
                     BufferedReader b1 = new BufferedReader(new FileReader("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+value+".tan"));
                     String data = b1.readLine();

               //      ArrayList<String> a = new ArrayList<String>();
                     while(data!=null)
                     {
                        a.add(data);
                        data = b1.readLine();
                     }

                    for(int i=0;i<a.size();i++)
                         songlist[i][0] = a.get(i);

                    b1.close();

             }

             catch(Exception sd){}
            try{ BufferedReader b1 = new BufferedReader(new FileReader("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+value+".tan"));

                    if (b1.readLine() != null)
                    {   System.out.println("if entrd");
                        new SongList((String) value, songlist);
                       repaint();
                   }
 else
                    { String list[][]={{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""}};
              new SongList((String) value,list);
                }
            } catch (Exception sd) {
               }
                            }


                           if(check.length()>0)

                            {
                                SongListFrame sf = new SongListFrame((String) value,songlist);

                                sf.create();
                                  for(int i=0;i<a.size();i++)
                                  {System.out.println(songlist[i][0]);
                                    songlist[i][0]="";
                                  }
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
            try
            {
                BufferedWriter b = new BufferedWriter(new FileWriter("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+"list.tan"));
                for(int i=0;i<playlist.length;i++)
                {    BufferedWriter b1 = new BufferedWriter(new FileWriter("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+playlist[i][0]+".tan"));
                    b.append(playlist[i][0]);
                    b.newLine();
                }
                b.close();
            }catch(Exception sd){}
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
            //getsongs();                          // cal a method to prnt vallues
            this.s = s;

        }

        public void prntsng(String s1[][])
        {   songlist=s1;
        }


        public void create()

        {

            JFrame f = new JFrame(name);
            songplayer s2=new songplayer();
            sl = new SongList(name,s);
            f.setLayout(new GridLayout(2,1));
            f.add(sl);
            f.add(s2);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.pack();
            f.setVisible(true);

        }







    }


    class songplayer extends javax.swing.JPanel
    {
        ArrayList<String> songs= new ArrayList<String>();
        MP3 mp=new MP3();

       public songplayer()

         {  mp3();

            mp.take(songs);

         }


              private javax.swing.JButton PLAY;
              private javax.swing.JButton S;
              private javax.swing.JButton PREV;
              private javax.swing.JButton NEXT;
              private javax.swing.JButton SHUFFLE;
              private javax.swing.JButton REPEAT;



            public void mp3()
            {
              REPEAT = new javax.swing.JButton();
              SHUFFLE = new javax.swing.JButton();
              PREV = new javax.swing.JButton();
              NEXT = new javax.swing.JButton();
              S = new javax.swing.JButton();
              PLAY = new javax.swing.JButton();



             setBackground(new java.awt.Color(0, 102, 102));
             setLayout(null);
             PLAY.addActionListener(new ActionListener()
               {
                 public void actionPerformed(ActionEvent ae)
                   {
                     startSong();
                   }
              });

            SHUFFLE.setText("shuffle");
            SHUFFLE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              mp.shuffle();
            }
        });
        add(SHUFFLE);
        SHUFFLE.setBounds(170, 10, 70, 23);

        REPEAT.setText("repeat");
        REPEAT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
             mp.repeat();
            }
        });
        add(REPEAT);
        REPEAT.setBounds(170, 70, 70, 23);

        NEXT.setText("next");
        add(NEXT);
        NEXT.setBounds(260, 40, 55, 23);
         NEXT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
             mp.next();
            }
        });
        PREV.setText("prev");
       add(PREV);
        PREV.setBounds(100, 40, 55, 23);
       PREV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
             mp.prev();
            }
        });
        S.setText("s");
        add(S);
        S.setBounds(30, 80, 20, 23);
        S.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
             mp.stop();
            }
        });

        PLAY.setText("play");

        add(PLAY);
        PLAY.setBounds(170, 40, 73, 23);
    ;
        //getContentPane().add(P1);
        setBounds(0, 0, 400, 90);
       // setBounds(200,200,400,150);
        }

    // </editor-fold>



     public void startSong()
    {
          //  mp3.get(songs);
            mp.play();
    }

    }


          class SongList extends javax.swing.JPanel

          {
                     String songlist[][];
                     String playlistname;



            public SongList(String pname,String[][] s)
              {   System.out.println("songlist cald");
                  songlist = s;
                  playlistname = pname;
                  initComponents();
              }


        private void initComponents()
        {


            jScrollPane1 = new javax.swing.JScrollPane();

            jTable1 = new javax.swing.JTable();

            jLabel1 = new javax.swing.JLabel();

            jButton1 = new javax.swing.JButton();

            jButton2 = new javax.swing.JButton();

            /// MY EDITN





            Object s[][] = new Object[songlist.length][2];
            for(int i =0 ;i<songlist.length;i++)
            {
                s[i][0] = i+1;
                s[i][1] = songlist[i][0];
            }

         // System.out.println(songlist);
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                s,

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

             jButton2.addActionListener(new ActionListener()
             {

                 public void actionPerformed(ActionEvent ae)
                 {
                     JFileChooser ch=new JFileChooser();
                     ch.setDialogTitle("find folder");
                     ch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                     if(ch.showOpenDialog(ch)==JFileChooser.APPROVE_OPTION)
                     {
                         String s=  ch.getSelectedFile().toString();
                         String songs[] = new GetSongs().getSongs(s);

                         try
                         {
                            BufferedWriter b = new BufferedWriter(new FileWriter("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+playlistname+".tan",true));
                            for (int i = 0; i < songs.length; i++)
                            {
                                b.append(songs[i]);
                                b.newLine();
                            }
                            b.close();
                         }catch(Exception as){}
                         setList();
                     }
                 }
    }
    );

      jButton1.addActionListener(new ActionListener()
             {

                 public void actionPerformed(ActionEvent ae)
              {   JFileChooser ch=new JFileChooser();
                  ch.setDialogTitle("find folder");

                  ch.setFileSelectionMode(JFileChooser.FILES_ONLY);

                  if(ch.showOpenDialog(ch)==JFileChooser.APPROVE_OPTION)

                  {
                      String song = ch.getSelectedFile().toString();
                      if(song.indexOf(".mp3")>=0)
                      {
                          try
                          {
                              BufferedWriter b = new BufferedWriter(new FileWriter("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+playlistname+".tan",true));
                              b.append(song);
                              b.newLine();
                              b.close();
                          }catch(Exception as){}
                          setList();
                      }
                      else
                      {
                          JOptionPane.showMessageDialog(null,"Oops!! Only .mp3 files allowed","Error",JOptionPane.ERROR_MESSAGE);
                      }
                  }

                     }
    }
    );




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

       public void setList()

        {   System.out.println("set list 0 last entrd");


            if(new File("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+playlistname+".tan").exists())
            {
                songlist = new String[getNumberOfLines("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+playlistname+".tan")][1];


                try

                {

                    BufferedReader b = new BufferedReader(new FileReader("Bin"+System.getProperty("file.separator")+"playlist"+System.getProperty("file.separator")+playlistname+".tan"));

                    String data = b.readLine();

                    int i =0;

                    while(data!=null)

                    {

                        songlist[i][0] = data;

                        data = b.readLine();

                        i++;

                    }

                }catch(Exception as){}
                if(songlist.length<15)
                {
                    String temp[][] = new String[15][1];
                    for(int i=0;i<temp.length;i++)
                        temp[i][0] = "";

                    for(int j=0;j<songlist.length;j++)
                        temp[j][0] = songlist[j][0];

                    songlist = temp;
                }
            }
            else
            {
                songlist = new String[15][1];

                for(int i=0;i<15;i++)
                    songlist[i][0] = "";
            }
            Object s[][] = new Object[songlist.length][2];
            for(int i =0 ;i<songlist.length;i++)
            {
                s[i][0] = i+1;
                s[i][1] = songlist[i][0];
            }


            jTable1.setModel(new javax.swing.table.DefaultTableModel(

                    s,

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

        private javax.swing.JButton jButton1;

        private javax.swing.JButton jButton2;

        private javax.swing.JLabel jLabel1;

        private javax.swing.JScrollPane jScrollPane1;

        private javax.swing.JTable jTable1;

        // End of variables declaration


    }

}


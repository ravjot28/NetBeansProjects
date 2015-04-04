
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewJFrame extends javax.swing.JFrame {

    ArrayList<String> songs=new ArrayList<String>();
    MP3 mp3;
    
    public NewJFrame() {
        mp3 = new MP3();
        create();
        initComponents();
        
    }
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Play");
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ar)
            {
                startSong();
            }
        });

        jButton2.setText("Stop");
        jButton2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ar){mp3.stop();}});
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }

    public void startSong()
    {
            mp3.play(songs);
    }

    public void create()
    {
        songs.add("D:\\Music\\Songs\\Hindi\\Hona Tha Pyaar.mp3");

        songs.add("D:\\Music\\Songs\\English Songs\\Lucky.mp3");
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration

}

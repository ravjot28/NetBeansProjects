package dock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class TransparentButton extends JButton {
        public TransparentButton(ImageIcon e) {
            super("",e);
            setOpaque(false);
        }

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            super.paint(g2);
            g2.dispose();
        }
}


public class Main extends JFrame implements ActionListener
{
    private static final float OPAQUE = 1.0f;
    private static final float TRANSLUCENT = 0.1f;
    public static void main(String[] args) 
    {

        new Main().dockk();
     
    }
    
    public void dockk()
    {
        final int a=380;
        final int b=3;
        final JFrame f=new JFrame();
        LookAndFeel lf = UIManager.getLookAndFeel();

// Install a different look and feel; specifically, the Windows look and feel
try {
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
   // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
   // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
} catch (InstantiationException e) {
} catch (ClassNotFoundException e) {
} catch (UnsupportedLookAndFeelException e) {
} catch (IllegalAccessException e) {
}
        f.setTitle("Rav Dock");
        f.setUndecorated(true);
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        f.setSize(504,48);
        f.setResizable(false);
        f.setLocation(a,b);
        TransparentButton Netbeans,MediaPlayer,Safari,Googletalk,YahooM,Word,NetBeans,DOSBOX,WT,PE,Fire,Chrome;

        NetBeans=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\netbeans2.png"));
        NetBeans.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{NetB();}catch(Exception r2){}}});

        DOSBOX=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\DOSBOX.png"));
        DOSBOX.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{DOS();}catch(Exception r2){}}});

        WT=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\WT.png"));
        WT.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{WT();}catch(Exception r3){}}});

        PE=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\PE.png"));
        PE.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{PE();}catch(Exception r4){}}});

        Fire=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\Fire.png"));
        Fire.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Fire();}catch(Exception r5){}}});

        Chrome=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\Chrome.png"));
        Chrome.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Chrome();}catch(Exception r6){}}});

        Word=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\Word.png"));
        Word.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Word();}catch(Exception r7){}}});

        Netbeans=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\netbeans.png"));
        Netbeans.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Netb();}catch(Exception e1){} }});

        MediaPlayer=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\wmpnss_bw120.png"));
        MediaPlayer.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Med();}catch(Exception e2){} }});

        Safari=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\compass.png"));
        Safari.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Saf();}catch(Exception e3){} }});

        Googletalk=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\mm_20_red.png"));
        Googletalk.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Go();}catch(Exception e4){} }});

        YahooM=new TransparentButton(new ImageIcon("E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\r\\generic_messenger.png"));
        YahooM.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ try{Ya();}catch(Exception e5){} }});

        NetBeans.setBackground(Color.white);
        Netbeans.setBackground(Color.white);
        MediaPlayer.setBackground(Color.white);
        Safari.setBackground(Color.white);
        Googletalk.setBackground(Color.white);
        YahooM.setBackground(Color.white);
        Word.setBackground(Color.white);
        DOSBOX.setBackground(Color.white);
        WT.setBackground(Color.white);
        PE.setBackground(Color.white);
        Fire.setBackground(Color.white);
        Chrome.setBackground(Color.white);

        f.setLayout(new GridLayout(1,12));
        f.add(MediaPlayer);
        f.add(Word);
        f.add(Netbeans);
        f.add(NetBeans);
        f.add(DOSBOX);
        f.add(WT);
        f.add(PE);
        f.add(Safari);
        f.add(Fire);
        f.add(Chrome);
        f.add(Googletalk);
        f.add(YahooM);
        f.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        //com.sun.awt.AWTUtilities.setWindowOpacity(f, OPAQUE);
      }

      @Override
      public void mouseExited(MouseEvent e) {
       // com.sun.awt.AWTUtilities.setWindowOpacity(f, TRANSLUCENT);
      }
    });
        f.setVisible(true);

    }

    public void Word()
    {
       Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\Microsoft Office\\Office12\\WINWORD.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void PE()
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\DzSoft\\Perl Editor\\Pleditor.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void NetB()
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\netbeans-5.5\\bin\\netbeans.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void DOS()
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\DOSBox-0.73\\dosbox.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void WT()
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\WTK2.5.2_01\\bin\\ktoolbar.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void Fire()
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\Mozilla Firefox 3.6 Beta 4\\firefox.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void Chrome()
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Users\\Rav\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }
    public void Netb() throws IOException
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\NetBeans 6.7\\bin\\netbeans.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void Saf() throws IOException
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\Safari\\Safari.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void Med() throws IOException
    {
        Runtime r=Runtime.getRuntime();;
        try
        {
            String s="H:\\Program Files\\Windows Media Player\\wmplayer.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void Go() throws IOException
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\Google\\Google Talk\\googletalk.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void Ya() throws IOException
    {
        Runtime r=Runtime.getRuntime();
        try
        {
            String s="H:\\Program Files\\Yahoo!\\Messenger\\YahooMessenger.exe";
            r.exec(s);
        }
        catch(Exception e)
        {
            System.out.println("error==="+e.getMessage());
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

package MainFrame;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import ravrun.Rav;

public class MainFrame extends JDialog
{
    JPanel searchPanel;
    JPanel booksPanel;
    JTextField searchField;
    JComponent[] books;
    SpotlightPanel glassPane;
    String apps[];
    
    public MainFrame(String[] a)
    {
        apps=a;
        searchPanel = new JPanel();
        searchField = new JTextField();
        booksPanel = new JPanel();
        
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.DARK_GRAY);

        glassPane = new SpotlightPanel(true);
        this.setGlassPane(glassPane);

        add(new MainPanel());

        addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e)
            {
                int key =e.getKeyCode();
                if(key==KeyEvent.VK_ESCAPE)
                {
                    dispose();
                }

            }
        });

        setUndecorated(true);
        setBackground(Color.DARK_GRAY);
        pack();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        setBounds(0,0,d.width,d.height);
    }

    private void one()
    {
        glassPane.clearSpotlights();
        addSpotForBook(0);
        //this.setGlassPane(glassPane);
    }

    private void two()
    {
        glassPane.clearSpotlights();
        addSpotForBook(1);
    }

    private void three()
    {
        glassPane.clearSpotlights();
        addSpotForBook(2);
    }

    private void four()
    {
        glassPane.clearSpotlights();
        addSpotForBook(3);
    }

    private void five()
    {
        glassPane.clearSpotlights();
        addSpotForBook(4);
    }

    private void six()
    {
        glassPane.clearSpotlights();
        addSpotForBook(5);
    }

    private void seven()
    {
        glassPane.clearSpotlights();
        addSpotForBook(6);
        //this.setGlassPane(glassPane);
    }

    private void eight()
    {
        glassPane.clearSpotlights();
        addSpotForBook(7);
    }

    private void nine()
    {
        glassPane.clearSpotlights();
        addSpotForBook(8);
    }

    private void ten()
    {
        glassPane.clearSpotlights();
        addSpotForBook(9);
    }

    private void eleven()
    {
        glassPane.clearSpotlights();
        addSpotForBook(10);
    }

    private void twelve()
    {
        glassPane.clearSpotlights();
        addSpotForBook(11);
    }

    private void createSpots(int[] a)
    {
        for(int i=0;i<a.length;i++)
        addSpotForBook(a[i]);
    }

    private void addSpotForBook(int i)
    {
        Point p = new Point(books[i].getLocation());
        SwingUtilities.convertPointToScreen(p, books[i].getParent());
        SwingUtilities.convertPointFromScreen(p, glassPane);
        glassPane.addSpotlight(p.x - 2, p.y - 4,160,160);// 96, 152);
    }

    private void createBooks(JPanel container)
    {
        books = new JComponent[12];
        for (int i = 0; i < books.length; i++)
        {
            JPanel f = new JPanel();
            f.setOpaque(false);

        f.add( books[i]  = new Reflect("Bin/img/"+(i+1)+".png") );
        books[i].setBorder(null);
        books[i].setOpaque(true);

        books[i].addMouseListener(new MouseListener()
                                    {

                public void mouseClicked(MouseEvent me)
                {
                    int row1=new Point(books[3].getLocationOnScreen()).y;
                    int row2=new Point(books[6].getLocationOnScreen()).y;
                    int row3=new Point(books[9].getLocationOnScreen()).y;
                    Point pp =me.getLocationOnScreen();
                    
                    if(pp.y<row1)
                    {
                        if(pp.x<new Point(books[1].getLocationOnScreen()).x)
                        {
                                    
                                    if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\Facebook\\RFB.jar").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/Facebook/RFB.jar").execute();
                                    }
                                    dispose();
                            //new Rav(apps[0][0]).execute();
                        }
                        else
                            if(pp.x<new Point(books[2].getLocationOnScreen()).x)
                            {
                                if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\TwitterMac\\RTweet.jar").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/TwitterMac/RTweet.jar").execute();
                                    }
                                    dispose();
                                //new Rav(apps[1][0]).execute();
                                //dispose();
                            }
                        else
                        {
                            if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\YoutubeMac\\Youtube.jar").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/YoutubeMac/Youtube.jar").execute();
                                    }
                                    dispose();
                            //new Rav(apps[2][0]).execute();
                            //dispose();
                        }
                    }
                    else
                    if(pp.y<row2)
                    {
                         if(pp.x<new Point(books[4].getLocationOnScreen()).x)
                        {
                             if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/").execute();
                                    }
                                    dispose();
                             //new Rav(apps[3][0]).execute();
                            //dispose();
                        }
                        else
                            if(pp.x<new Point(books[5].getLocationOnScreen()).x)
                            {
                                if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\Hukamnama\\Hukamnama.jar").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/Hukamnama/Hukamnama.jar").execute();
                                    }
                                    dispose();
                                // new Rav(apps[4][0]).execute();
                                //dispose();
                            }
                        else
                        {
                             if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\MP3Mac\\RPlayer.jar").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/MP3Mac/RPlayer.jar").execute();
                                    }
                                    dispose();
                            /// new Rav(apps[5][0]).execute();
                            //dispose();
                        }
                    }
                    else
                    if(pp.y<row3)
                    {
                         if(pp.x<new Point(books[7].getLocationOnScreen()).x)
                        {
                             if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/").execute();
                                    }
                                    dispose();
                             //new Rav(apps[6][0]).execute();
                            //dispose();
                        }
                        else
                            if(pp.x<new Point(books[8].getLocationOnScreen()).x)
                            {
                                if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\RMailSenderMac\\RMail.jar").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/RMailSenderMac/RMail.jar").execute();
                                    }
                                    dispose();
                                // new Rav(apps[7][0]).execute();
                                //dispose();
                            }
                        else
                        {
                             if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\iTunesControllerMac\\MaciTunesController.jar").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/iTunesControllerMac/MaciTunesController.jar").execute();
                                    }
                                    dispose();
                            // new Rav(apps[8][0]).execute();
                            //dispose();
                        }
                    }
                    else
                    {
                         if(pp.x<new Point(books[10].getLocationOnScreen()).x)
                        {
                             if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/").execute();
                                    }
                                    dispose();
                                //   new Rav(apps[9][0]).execute();
                                //dispose();
                        }
                        else
                            if(pp.x<new Point(books[11].getLocationOnScreen()).x)
                            {
                                if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/").execute();
                                    }
                                    dispose();
                                //       new Rav(apps[10][0]).execute();
                                //dispose();
                            }
                        else
                        {
                             if(new GetOSName().getName().equals("win"))
                                    {
                                        new Rav("Bin\\Data\\Apps\\").execute();
                                    }
                                    else
                                    {
                                        new Rav("Bin/Data/Apps/").execute();
                                    }
                                    dispose();
                            //   new Rav(apps[11][0]).execute();
                            //dispose();
                        }
                    }
                }

                public void mousePressed(MouseEvent me) {
                }

                public void mouseReleased(MouseEvent me) {

                }

                public void mouseEntered(MouseEvent me) {

                }

                public void mouseExited(MouseEvent me) {

                }

                                    });
            container.add(f);
        }
    }

    class Reflect extends JComponent
{

    private BufferedImage image;

    public Reflect(String img)
    {
        try
        {
            image = ImageIO.read( new File(img) );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public void paintComponent( Graphics g )
    {
        Graphics2D g2d = (Graphics2D)g;
        int width = getWidth();
        int height = getHeight();
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        int gap = 20;
        float opacity = 0.4f;
        float fadeHeight = 0.3f;

        g2d.setPaint( new GradientPaint( 0, 0, Color.DARK_GRAY, 0, height, Color.DARK_GRAY ) );
        g2d.fillRect( 0, 0, width, height );
        g2d.translate( (width-imageWidth)/2, height/2-imageHeight );
        g2d.drawRenderedImage( image, null );
        g2d.translate( 0, 2*imageHeight+gap );
        g2d.scale( 1, -1 );

        BufferedImage reflection = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
		Graphics2D rg = reflection.createGraphics();
        rg.drawRenderedImage( image, null );
		rg.setComposite( AlphaComposite.getInstance( AlphaComposite.DST_IN ) );
        rg.setPaint(
            new GradientPaint(
                0, imageHeight*fadeHeight, new Color( 0.0f, 0.0f, 0.0f, 0.0f ),
                0, imageHeight, new Color( 0.0f, 0.0f, 0.0f, opacity )
            )
        );
        rg.fillRect( 0, 0, imageWidth, imageHeight );
        rg.dispose();
        g2d.drawRenderedImage( reflection, null );
    }

    public Dimension getPreferredSize()
    {
        return new Dimension( 150, 150 );
    }
}


    class MainPanel extends JPanel
{
    JLabel head;
    public MainPanel()
    {
        initComponents();
    }

    private void initComponents()
    {
        searchPanel = new JPanel();
        searchField = new JTextField();
        booksPanel = new JPanel();
        head = new JLabel();
        setBackground(Color.DARK_GRAY);
        setForeground(Color.DARK_GRAY);
        booksPanel.setBackground(Color.DARK_GRAY);
        searchPanel.setBackground(Color.DARK_GRAY);

        searchField.setBackground(Color.DARK_GRAY);
        
        searchField.setForeground(new Color(255, 255, 255));


       head.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
       head.setForeground(new java.awt.Color(255, 255, 255));
       head.setText("Search Apps");

        GroupLayout jPanel1Layout = new GroupLayout(searchPanel);
        searchPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(head)
                .addGap(18, 18, 18)
                .addComponent(searchField,GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(head))
                .addContainerGap())
        );

        booksPanel.setLayout(new GridLayout(4, 3, 5, 5));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(searchPanel, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(booksPanel,GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(searchPanel,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(booksPanel,GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
        );

         searchField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int key =e.getKeyCode();
                if(key==KeyEvent.VK_ESCAPE)
                {
                    dispose();
                }

                String text = searchField.getText();
                String app="";
                for(int i=0;i<apps.length;i++)
                {
                    StringTokenizer token = new StringTokenizer(apps[i],",");
                    while(token.hasMoreElements())
                    {
                        if(text.contains(token.nextToken()))
                        {
                            app+=i+",";
                        }
                    }

                }
                if(!app.equalsIgnoreCase(""))
                {
                    StringTokenizer t = new StringTokenizer(app,",");
                    int aa[]=new int[t.countTokens()];
                    int p=0;
                    while(t.hasMoreElements())
                    {
                        aa[p]=Integer.parseInt(t.nextToken());
                        p++;
                    }
                    createSpots(aa);
                }
                else
                 {
                    glassPane.clearSpotlights();
                }
            }
        });

        createBooks(booksPanel);
    }
}

    class GetOSName
    {
        public String getName()
        {
            try
            {
                String osName= System.getProperty("os.name");
                if(osName.contains("Mac"))
                {
                    return "mac";
                }
                else
                    if(osName.contains("Window"))
                    {
                        return "win";
                    }
                else
                    {
                        return "linux";
                    }
            }catch (Exception e)
                {
                    return "No";
                }
    }
}

}

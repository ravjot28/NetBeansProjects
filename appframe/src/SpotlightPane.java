import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.*;
import ravrun.Rav;

public class SpotlightPane extends JFrame
{
    private SpotlightPanel glassPane;
    private JComponent[] books;
    JTextField searchField;
    final String apps[][];
    public SpotlightPane(String[][] a)
    {        
      super("R Apps");
      apps=a;
      com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.8f);
      setBackground(Color.DARK_GRAY);
      glassPane = new SpotlightPanel(true);
      this.setGlassPane(glassPane);

        Container c = new GradientPanel();
        setContentPane(c);
      c.setLayout(new BorderLayout());
      setBackground(Color.DARK_GRAY);
      
      /*  JPanel headerPanel = new JPanel(new BorderLayout());
        HeaderPanel header = new HeaderPanel();
        headerPanel.add(BorderLayout.NORTH, header);
        headerPanel.add(BorderLayout.SOUTH, new JSeparator(JSeparator.HORIZONTAL));
        c.add(BorderLayout.NORTH, headerPanel);*/

        //JPanel booksPanel = new GradientPanel();
      NewJPanel booksPanel = new NewJPanel();
        booksPanel.setOpaque(true);
        booksPanel.setLayout(new GridLayout(4, 3));
        //booksPanel.setBorder(new EmptyBorder(6, 0, 0, 0));
        booksPanel.setBackground(Color.DARK_GRAY);
        booksPanel.setForeground(Color.DARK_GRAY);
        createBooks(booksPanel);
        c.setBackground(Color.DARK_GRAY);
        c.add(BorderLayout.CENTER, booksPanel);

        JPanel searchPanel = new JPanel();
        searchPanel.setOpaque(false);
        searchPanel.setBackground(Color.DARK_GRAY);
        JLabel label = new JLabel("Search");
        label.setForeground(Color.DARK_GRAY);
        searchPanel.add(label);
        searchField = new JTextField(12);
        searchField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int key =e.getKeyCode();
                if(key==KeyEvent.VK_ESCAPE)
                {
                    dispose();
                }

                String text = searchField.getText();
                /*if (text.equals("1"))
                    one();//createSciFiSpots();
                else if (text.equals("2"))
                    two();//createSpotsForAll();
                else if (text.equals("3"))
                    three();//createPratchettSpots();
                else if (text.equals("4"))
                    four();//createAdamsSpots();
                else if (text.equals("5"))
                    five();//createPratchettSpots();
                else if (text.equals("6"))
                    six();//createAdamsSpots();
                else if (text.equals("7"))
                    seven();//createSpotsForAll();
                else if (text.equals("8"))
                    eight();//createPratchettSpots();
                else if (text.equals("9"))
                    nine();//createAdamsSpots();
                else if (text.equals("10"))
                    ten();//createPratchettSpots();
                else if (text.equals("11"))
                    eleven();//createAdamsSpots();
                else if (text.equals("12"))
                    twelve();//createAdamsSpots();*/
                String app="";
                for(int i=0;i<apps.length;i++)
                {
                    //System.out.println(text+" "+apps[i][1]);
                    StringTokenizer token = new StringTokenizer(apps[i][1],",");
                    while(token.hasMoreElements())
                    {
                        if(text.startsWith(token.nextToken()))
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
        /*searchField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                String text = ((JTextField) evt.getSource()).getText();
                if (text.equals("1"))
                    one();//createSciFiSpots();
                else if (text.equals("2"))
                    two();//createSpotsForAll();
                else if (text.equals("3"))
                    three();//createPratchettSpots();
                else if (text.equals("4"))
                    four();//createAdamsSpots();
                else if (text.equals("5"))
                    five();//createPratchettSpots();
                else if (text.equals("6"))
                    six();//createAdamsSpots();
                else if (text.equals("7"))
                    seven();//createSpotsForAll();
                else if (text.equals("8"))
                    eight();//createPratchettSpots();
                else if (text.equals("9"))
                    nine();//createAdamsSpots();
                else if (text.equals("10"))
                    ten();//createPratchettSpots();
                else if (text.equals("11"))
                    eleven();//createAdamsSpots();
                else if (text.equals("12"))
                    twelve();//createAdamsSpots();
            }
        });*/
        setUndecorated(true);
        searchPanel.add(searchField);
        c.add(BorderLayout.NORTH, searchPanel);
        setBackground(Color.DARK_GRAY);
        pack();
        //setResizable(false);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        setBounds(0,0,d.width,d.height);
      setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
/*
    /*private void createSpotsForAll()
    {
        for (int i = 0; i < 6; i++)
        {
            addSpotForBook(i);
        }
    }

    private void createSciFiSpots()
    {
        addSpotForBook(0);
        /*for (int i = 5; i < 6; i++)
        {
            addSpotForBook(i);
        }*/
    //}

    /*private void createAdamsSpots()
    {
        for (int i = 3; i < 6; i++)
        {
            addSpotForBook(i);
        }
    }

    private void createPratchettSpots()
    {
        addSpotForBook(2);
    }
*/
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
            //JPanel buttonPanel = new JPanel();
            //buttonPanel.setOpaque(false);
         //buttonPanel.add(books[i] = new JLabel("", "cover" + (i + 1) + "_small_button"));
            //buttonPanel.add(books[i] = new JLabel(new ImageIcon("r.png")));
            JPanel f = new JPanel();
            f.setOpaque(false);
            //f.setBackground(new Color(255,255,255,80));
        
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
                            dispose();
                            new Rav(apps[0][0]).execute();
                        }
                        else
                            if(pp.x<new Point(books[2].getLocationOnScreen()).x)
                            {
                                new Rav(apps[1][0]).execute();
                                dispose();
                            }
                        else
                        {
                            new Rav(apps[2][0]).execute();
                            dispose();
                        }
                    }
                    else
                    if(pp.y<row2)
                    {
                         if(pp.x<new Point(books[4].getLocationOnScreen()).x)
                        {
                             new Rav(apps[3][0]).execute();
                            dispose();
                        }
                        else
                            if(pp.x<new Point(books[5].getLocationOnScreen()).x)
                            {
                                 new Rav(apps[4][0]).execute();
                            dispose();
                            }
                        else
                        {
                             new Rav(apps[5][0]).execute();
                            dispose();
                        }
                    }
                    else
                    if(pp.y<row3)
                    {
                         if(pp.x<new Point(books[7].getLocationOnScreen()).x)
                        {
                             new Rav(apps[6][0]).execute();
                            dispose();
                        }
                        else
                            if(pp.x<new Point(books[8].getLocationOnScreen()).x)
                            {
                                 new Rav(apps[7][0]).execute();
                            dispose();
                            }
                        else
                        {
                             new Rav(apps[8][0]).execute();
                            dispose();
                        }
                    }
                    else
                    {
                         if(pp.x<new Point(books[10].getLocationOnScreen()).x)
                        {
                             new Rav(apps[9][0]).execute();
                            dispose();
                        }
                        else
                            if(pp.x<new Point(books[11].getLocationOnScreen()).x)
                            {
                                 new Rav(apps[10][0]).execute();
                            dispose();
                            }
                        else
                        {
                             new Rav(apps[11][0]).execute();
                            dispose();
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

    private static class GradientPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            if (!isOpaque())
            {
                return;
            }

            int width  = getWidth();
            int height = getHeight();

            Graphics2D g2 = (Graphics2D) g;

            Paint storedPaint = g2.getPaint();
            g2.setPaint(new GradientPaint(0, 0, Color.DARK_GRAY, width, height,Color.DARK_GRAY));
            g2.fillRect(0, 0, width, height);
            g2.setPaint(storedPaint);
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

    class NewJPanel extends javax.swing.JPanel
    {

    public NewJPanel()
    {
        initComponents();
    }

    private void initComponents()
    {
        setBackground(new Color(255,255,255,80));

        //setBackground(new java.awt.Color(0, 0, 0));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }
  }
}
package GUITest;

import AppDownload.DownloadMain;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import ravrun.Rav;


public class MainFrame extends JFrame
{
    JTextField tf;
    SpotlightPanel glassPane;
    String apps[];

    XrButton xr[];

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    int AppsNo=0;

    boolean position;

    int[][] post;
    MainPanel mp ;

    AppsFrame appsFrame ;

    ArrayList<XrButton> a;

    ArrayList<String> appss;

    final Point hotspot = new Point(0, 0);
    deleteFrame deleteframe;

    DragGestureRecognizer dragRecognizer1[];

    DragGestureRecognizer dragRecognizer2[];

    String appPath;

    JTextField GoogleSearch;

    JTextField WikipediaSearch;
    
    MainFrame(int n,boolean pos,int[][] po,String[] a1)
    {
        a = new ArrayList();
        appss = new ArrayList();
        apps=a1;
        position=pos;
        post=po;
        AppsNo=n;
        xr = new XrButton[n];
        setBackground(Color.DARK_GRAY);

        appsFrame = new AppsFrame();

        glassPane = new SpotlightPanel(true);
        this.setGlassPane(glassPane);
        setTitle("GizmoStore");
        setIconImage(new ImageIcon("Bin\\img\\logo.png").getImage());
        //setLayout(new GridLayout(2,0));

        setCursor(getToolkit().createCustomCursor(new ImageIcon("Bin\\img\\cursor.gif").getImage(), hotspot, "Rav Cursor"));

        mp = new MainPanel();
        add(mp,BorderLayout.CENTER);
        
        setUndecorated(true);
        setBackground(Color.DARK_GRAY);

        setBounds(0,0,d.width,d.height);
    }

    

    class MainPanel extends JPanel
{
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

        private String[] getContent(String fname)
    {
        String result[] = new String[getNumberOfLines(fname)];
        try
        {
            BufferedReader b = new BufferedReader(new FileReader(fname));
            for(int i=0;i<result.length;i++)
                result[i]=b.readLine();
        }catch(Exception asd){}
        return result;
    }
        
    MainPanel()
    {
        String tot[] = getContent("Bin\\Data\\tags.ravs");
        
        for(int i=0;i<getNumberOfLines("Bin\\Data\\tags.ravs");i++)
        {
            StringTokenizer s = new StringTokenizer(tot[i],"##");
                    StringTokenizer s1 = new StringTokenizer(s.nextToken().trim(),"^^");
                    String appName = s1.nextToken();
                    String appImage = s1.nextToken();
                    appPath = s1.nextToken();
                    xr[i] = new XrButton(new ImageIcon(appImage),appPath);
                    
                    xr[i].setName(tot[i]);
            if(position)
            {
                xr[i].setBounds(post[i][0],post[i][1], 100, 100);
            }
            else
            {
                xr[i].setBounds(d.height/5,d.width/5, 100, 100);
            }
            add(xr[i]);
        }

        setLayout(null);

        JButton b1 = new JButton();
        b1.setBounds(10, d.height-64,64, 64);
        b1.setIcon(new ImageIcon("Bin\\img\\addapp.png"));
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ar)
                                {
                                    AppsFrame f = new AppsFrame();
                                    f.setVisible(true);
                                }
                            });

        add(b1);

        JButton b2 = new JButton();
        b2.setBounds(d.width-64, d.height-64,64, 64);
        b2.setIcon(new ImageIcon("Bin\\img\\trashbutton.png"));
        b2.setBorderPainted(false);
        b2.setContentAreaFilled(false);
        
        b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae)
                                                        {
                                                            deleteframe = new deleteFrame();
                                                            deleteframe.setVisible(true);
                                                        }});
        add(b2);

        JButton b3 = new JButton();
        b3.setBounds((d.width-64)/2, d.height-64,64, 64);
        b3.setIcon(new ImageIcon("Bin\\img\\appstore.png"));
        b3.setBorderPainted(false);
        b3.setContentAreaFilled(false);

        b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae)
                                                        {

                                                                DownloadMain m = new DownloadMain();
                                                                m.launch();
                                                        }});
        add(b3);

        JButton b = new JButton(new ImageIcon("Bin\\img\\close1.png"));
        b.setBounds(0,0,28,28);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        add(b);
        b.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ae)
                                {
                                    BufferedWriter b = null;
                                    try
                                    {
                                       b = new BufferedWriter(new FileWriter("Bin\\Data\\Positions.ravs"));
                                       //System.out.println(AppsNo);
                                       for(int i=0;i<AppsNo;i++)
                                       {
                                           //System.out.println(getX(i)+","+getY(i));
                                           b.append(getX(i)+","+getY(i));
                                           b.newLine();
                                       }
                                       b.close();
                                    }catch(Exception asd)
                                        {
                                            try
                                                {
                                                System.out.println("A Size "+a.size());
                                        for(int i=0;i<a.size();i++)
                                            {
                                                    try
                                                    {
                                                    b.append(a.get(i).getLocationOnScreen().x + "," + a.get(i).getLocationOnScreen().y);
                                                    b.newLine();
                                                }catch(Exception sa){}


                                            }
                                        b.close();
                                        } catch (IOException ex) {                        }
                                            
                                        }
                                    dispose();
                                }

                            });

        tf = new JTextField(20);
        tf.setBounds(d.width-200, 5, 200, 20);
        tf.setFont(new java.awt.Font("Sylfaen", 1, 18));

        tf.addKeyListener(new KeyAdapter()
                        {
                            public void keyReleased(KeyEvent e)
                            {
                                BufferedWriter b = null;
                                int key =e.getKeyCode();
                                if(key==KeyEvent.VK_ESCAPE)
                                {
                                    try
                                    {
                                       b = new BufferedWriter(new FileWriter("Bin\\Data\\Positions.ravs"));
                                       for(int i=0;i<AppsNo;i++)
                                       {
                                           b.append(getX(i)+","+getY(i));
                                           b.newLine();
                                       }
                                       b.close();
                                    }catch(Exception asd){try
                                                {
                                        for(int i=0;i<a.size();i++)
                                            {
                                                
                                                    b.append(a.get(i).getLocationOnScreen().x + "," + a.get(i).getLocationOnScreen().y);
                                                    b.newLine();
                                                
                                                
                                            }
                                        b.close();
                                        } catch (IOException ex) {                        }
                                    }
                                    dispose();
                                }

                                String text = tf.getText();
                                //System.out.println(text);
                                String app="";
                                for(int i=0;i<apps.length;i++)
                                {
                                    //System.out.println(apps[i]);
                                    StringTokenizer token = new StringTokenizer(apps[i],",");
                                    while(token.hasMoreElements())
                                    {
                                        if(text.contains(token.nextToken()))
                                        {
                                            app+=i+",";
                                        }
                                    }

                                }
                                String app1="";
                                for(int i=0;i<appss.size();i++)
                                {
                                    StringTokenizer token = new StringTokenizer(appss.get(i),",");
                                    while(token.hasMoreElements())
                                    {
                                        if(text.contains(token.nextToken()))
                                        {
                                            app1+=i+",";
                                        }
                                    }
                                }
                                //System.out.println(app1);
                                if(!app.equalsIgnoreCase(""))
                                {
                                    StringTokenizer t = new StringTokenizer(app,",");
                                    int aa[]=new int[t.countTokens()];
                                    int p=0;
                                    while(t.hasMoreElements())
                                    {
                                        aa[p]=Integer.parseInt(t.nextToken());
                                        //System.out.println(aa[p]);
                                        p++;
                                    }
                                    createSpots(aa);
                                }
                                else
                                    if(!app1.equalsIgnoreCase(""))
                                    {
                                        StringTokenizer t = new StringTokenizer(app1,",");
                                         int aa[]=new int[t.countTokens()];
                                            int p=0;
                                            while(t.hasMoreElements())
                                             {
                                                aa[p]=Integer.parseInt(t.nextToken());
                                                //System.out.println(aa[p]);
                                                p++;
                                             }
                                           createSpots1(aa);
                                    }
                                else
                                {
                                    glassPane.clearSpotlights();
                                }
                            }
                        });

        //tf.setBackground(Color.DARK_GRAY);

        tf.setForeground(Color.GRAY);

        JLabel l = new JLabel();
        l.setIcon(new ImageIcon("Bin\\img\\Search.png"));
        l.setBounds(d.width-240, -7, 48, 48);

        l.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N

        JXPanel panel = new JXPanel();
            


        JXTaskPaneContainer taskpanecontainer = new JXTaskPaneContainer();


        // create a taskpane, and set it's title and icon

        JXTaskPane taskpane = new JXTaskPane();
        taskpane.setTitle("Web Search");
        taskpane.setToolTipText("Google & Wikipedia Search");
        taskpane.setIcon(new ImageIcon("Bin\\img\\Search1.png"));

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel google = new JLabel();
        google.setIcon(new ImageIcon("Bin\\img\\google.png"));
        GoogleSearch = new JTextField(10);
        GoogleSearch.addKeyListener
      (new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_ENTER) {
               dispose();
              callGoogle(GoogleSearch.getText().trim());
              GoogleSearch.setText("");
              }
           }
         }
      );
        p.add(google);
        p.add(GoogleSearch);

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        JLabel wikipedia = new JLabel();
        wikipedia.setIcon(new ImageIcon("Bin\\img\\wikipedia.png"));
        WikipediaSearch = new JTextField(10);
        WikipediaSearch.addKeyListener
      (new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_ENTER) {
               dispose();
              callWiki(WikipediaSearch.getText().trim());
              WikipediaSearch.setText("");
              }
           }
         }
      );
        p1.add(wikipedia);
        p1.add(WikipediaSearch);

        taskpane.add(p);
        taskpane.add(p1);
        taskpanecontainer.add(taskpane);
        panel.add(taskpanecontainer);
        //l.setForeground(new java.awt.Color(255, 255, 255));
        panel.setBounds(d.width-205, 30, 200, 200);
        add(panel);
        add(tf);
        add(l);
    }

    public void callWiki(String a)
    {
        Search s = new Search();
        s.wiki(a);
    }

    public void callGoogle(String a)
    {
        Search s = new Search();
        s.google(a);
    }

    public int getX(int n)
    {
        //System.out.println("N:"+n+"  Value: "+xr[n].getLocationOnScreen().x);
        return xr[n].getLocationOnScreen().x;
    }

    public int getY(int n)
    {
        return xr[n].getLocationOnScreen().y;
    }

    private void createSpots(int[] a)
    {
        for(int i=0;i<a.length;i++)
        addSpotForBook(a[i]);
    }

    private void createSpots1(int[] a2)
    {
        for(int i=0;i<a2.length;i++)
        {
            if(a2[i]<a.size())
            {
                addSpotForBook1(a2[i]);
            }
        }
    }

    private void addSpotForBook1(int i)
    {
            Point p = new Point(a.get(i).getLocation());
            SwingUtilities.convertPointToScreen(p, a.get(i).getParent());
            SwingUtilities.convertPointFromScreen(p, glassPane);
            glassPane.addSpotlight(p.x-15, p.y-15,130,130);// 96, 152);
    }

    private void addSpotForBook(int i)
    {
        Point p = new Point(xr[i].getLocation());
        SwingUtilities.convertPointToScreen(p, xr[i].getParent());
        SwingUtilities.convertPointFromScreen(p, glassPane);
        glassPane.addSpotlight(p.x-15, p.y-15,130,130);// 96, 152);
    }

    
}

    class Search
    {
        String link;
        
        public void wiki(String s)
        {
            link="";

            String result="";
            StringTokenizer s1=new StringTokenizer(s," ");
            while(s1.hasMoreTokens())
            {
                result=result+s1.nextToken()+"+";
            }
            result=result.substring(0,result.length()-1);

            System.out.println(result);
            link="http://en.wikipedia.org/wiki/Special:Search?search="+result+"&go=Go";
            try {
                String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + link;
                Process p = Runtime.getRuntime().exec(cmd);
            } catch (IOException ex) {
            }
        }

        public void google(String s)
        {
            link="";

            String result="";
            StringTokenizer s1=new StringTokenizer(s," ");
            while(s1.hasMoreTokens())
            {
                result=result+s1.nextToken()+"+";
            }
            result=result.substring(0,result.length()-1);

            System.out.println(result);
            link="http://www.google.co.in/#sclient=psy&hl=en&site=&source=hp&q="+result+"&aq=f&aqi=g5&aql=&oq=&pbx=1&fp=1e96ebb05fbca34f";
            try {
                String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + link;
                Process p = Runtime.getRuntime().exec(cmd);
            } catch (IOException ex) {
            }
        }

    }

    class AppsFrame extends JFrame
{
    String us[];
    String tot[];
    JPanel p;

    XrButton x[];

    int count=0;


    private javax.swing.JButton jButton1;

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

    AppsFrame()
    {
        super("Your Downloaded Apps");
        int using = this.getNumberOfLines("Bin\\Data\\tags.ravs");
        int total = this.getNumberOfLines("Bin\\Data\\totalapps.ravs");

        p = new JPanel();

        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\add.png"));
        
        setResizable(false);

        if((total==using))
        {
            JLabel l = new JLabel("No new Downloaded Apps Present");
            add(l,BorderLayout.CENTER);
            setBounds(200,d.height/2,223,50);
        }
        else
        {
            x = new XrButton[total-using];

            tot = getContent("Bin\\Data\\totalapps.ravs");

            us = getContent("Bin\\Data\\tags.ravs");

            setCursor(getToolkit().createCustomCursor(new ImageIcon("Bin\\img\\cursor.png").getImage(), hotspot, "Rav Cursor"));
            for(int i=0;i<tot.length;i++)
            {
                if(check(tot[i]))
                {
                    //System.out.println(tot[i]);
                    StringTokenizer s = new StringTokenizer(tot[i],"##");
                    StringTokenizer s1 = new StringTokenizer(s.nextToken().trim(),"^^");
                    
                    String appName = s1.nextToken();
                    String appImage = s1.nextToken();
                    appPath = s1.nextToken();
                    x[count] = new XrButton(new ImageIcon(appImage),appPath);
                    x[count].setActionCommand(tot[i]);
                    x[count].addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae)
                                                {
                                                    String temp = ae.getActionCommand();
                                                    try
                                                    {
                                                        BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\tags.ravs",true));
                                                        
                                                        b.append(temp);
                                                        b.newLine();
                                                        b.close();
                                                    }catch(Exception asd){}
                                                    StringTokenizer s = new StringTokenizer(temp,"##");
                                                    StringTokenizer s1 = new StringTokenizer(s.nextToken().trim(),"^^");
                                                    String appName = s1.nextToken();
                                                    String appImage = s1.nextToken();
                                                    appPath = s1.nextToken();                                                    
                                                    XrButton b= new XrButton(new ImageIcon(appImage),appPath);
                                                    b.setName(ae.getActionCommand());
                                                    b.setBounds(d.height/5,d.width/5, 100, 100);
                                                    a.add(b);
                                                    mp.add(a.get(a.size()-1));
                                                    mp.revalidate();
                                                    mp.repaint();
                                                    AppsNo = getNumberOfLines("Bin\\Data\\tags.ravs");
                                                    appss.add(temp);
                                                    remove(temp);
                                                }});
                    p.add(x[count]);
                    count++;
                }
            }
            add(p,BorderLayout.CENTER);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(200,d.height/2,600,300);
        }

    }


    public void remove(String asd)
    {
        for(int i=0;i<x.length;i++)
        {
            if(x[i].getActionCommand().equalsIgnoreCase(asd))
            {
                p.remove(x[i]);
                this.remove(x[i]);
                p.revalidate();
                p.repaint();
                this.repaint();
            }
        }
    }

    public boolean check(String a)
    {
        for(int j=0;j<us.length;j++)
        {
            if(us[j].equalsIgnoreCase(a))
            {
                return false;
            }
        }
        return true;
    }

    private String[] getContent(String fname)
    {
        String result[] = new String[getNumberOfLines(fname)];
        try
        {
            BufferedReader b = new BufferedReader(new FileReader(fname));
            for(int i=0;i<result.length;i++)
                result[i]=b.readLine();
        }catch(Exception asd){}
        return result;
    }
}

    /*class deleteFrame extends JFrame
    {
        deleteFrame()
        {
            super("Target Frame");
            setLayout(null);
            setAlwaysOnTop(true);
            DragDrop dndListener = new DragDrop();
            DragSource dragSource = new DragSource();

        //DropTarget dropTarget1 = new DropTarget(source,DnDConstants.ACTION_MOVE, dndListener);
            DropTarget dropTarget2 = new DropTarget(this,DnDConstants.ACTION_MOVE,dndListener);
            dragRecognizer1 = new DragGestureRecognizer[xr.length];
            for(int i=0;i<xr.length;i++)
            {
                dragRecognizer1[i] = dragSource.createDefaultDragGestureRecognizer(xr[i],DnDConstants.ACTION_MOVE, dndListener);
            }
            dragRecognizer2 = new DragGestureRecognizer[a.size()];
            for(int i=0;i<a.size();i++)
            {
                dragRecognizer2[i] = dragSource.createDefaultDragGestureRecognizer(a.get(i),DnDConstants.ACTION_MOVE, dndListener);
            }
            addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we)
                                                    {
                                                        for(int i=0;i<xr.length;i++)
                                                        {
                                                            dragRecognizer1[i] = null;
                                                        }

                                                        for(int i=0;i<a.size();i++)
                                                        {
                                                            dragRecognizer2[i] = null;
                                                        }
                                                    }});
            setBounds(220, 200, 200, 200);
        }
    }*/


class DragDrop implements DragGestureListener,DragSourceListener,DropTargetListener, Transferable
{
     final DataFlavor[] supportedFlavors = {null};

     {
        try {
            supportedFlavors[0] = new
            DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    Object object;
    // Transferable methods.
    public Object getTransferData(DataFlavor flavor)
    {
        if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType))
        {
            return object;
        } else
        {
            return null;
        }
    }
    public DataFlavor[] getTransferDataFlavors()
    {
        return supportedFlavors;
    }
    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
    }
    // DragGestureListener method.
    public void dragGestureRecognized(DragGestureEvent ev)
    {
        ev.startDrag(null, this, this);
    }
    // DragSourceListener methods.
    public void dragDropEnd(DragSourceDropEvent ev)
    {
    }
    public void dragEnter(DragSourceDragEvent ev)
    {
    }
    public void dragExit(DragSourceEvent ev)
    {
    }
    public void dragOver(DragSourceDragEvent ev)
    {
        object = ev.getSource();
    }
    public void dropActionChanged(DragSourceDragEvent ev)
    {
    }
    // DropTargetListener methods.
    public void dragEnter(DropTargetDragEvent ev)
    {
    }
    public void dragExit(DropTargetEvent ev)
    {
    }
    public void dragOver(DropTargetDragEvent ev)
    {
        dropTargetDrag(ev);
    }
    public void dropActionChanged(DropTargetDragEvent ev)
    {
        dropTargetDrag(ev);
    }
    void dropTargetDrag(DropTargetDragEvent ev)
    {
        ev.acceptDrag(ev.getDropAction());
    }
    public void drop(DropTargetDropEvent ev)
    {
        ev.acceptDrop(ev.getDropAction());
        try
        {
            Object target = ev.getSource();
            Object source = ev.getTransferable().getTransferData(supportedFlavors[0]);
            Component component = ((DragSourceContext)source).getComponent();
            Container oldContainer = component.getParent();
            Container container = (Container) ((DropTarget)target).getComponent();
            delete(component.getName());
            container.add(component);
            oldContainer.validate();
            oldContainer.repaint();
            container.validate();
            container.repaint();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        ev.dropComplete(true);
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

    public void delete(String delete)
    {
        String result[] = getContent("Bin\\Data\\tags.ravs");
        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\tags.ravs"));
            BufferedWriter b1 = new BufferedWriter(new FileWriter("Bin\\Data\\Positions.ravs"));
            for(int i=0;i<result.length;i++)
            {
                if(!result[i].equalsIgnoreCase(delete))
                {
                    b.append(result[i]);
                    b.newLine();
                    try
                    {
                    b1.append(a.get(i).getLocationOnScreen().x+","+a.get(i).getLocationOnScreen().y);
                    b1.newLine();
                    }catch(Exception as){b1.append(d.width/5+","+d.height/5);
                    b1.newLine();}
                }
            }
            b.close();
            b1.close();
        }catch(Exception as){System.out.println("Delete Exception "+as);}
    }

     private String[] getContent(String fname)
     {
        String result[] = new String[getNumberOfLines(fname)];
        try
        {
            BufferedReader b = new BufferedReader(new FileReader(fname));
            for(int i=0;i<result.length;i++)
                result[i]=b.readLine();
        }catch(Exception asd){}
        return result;
     }
}
class XrButton extends JButton implements MouseListener
{
	String  text;
	boolean mouseIn = false;

        private volatile int screenX = 0;
        private volatile int screenY = 0;
        private volatile int myX = 0;
        private volatile int myY = 0;

        String appPath;


public XrButton(ImageIcon s,String action)
{
	super(s);
        appPath=action;
	setBorderPainted(false);
	addMouseListener(this);
        setFocusable(false);
	setContentAreaFilled(false);
            addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e)
      {
          BufferedWriter b = null;
                                    try
                                    {
                                       b = new BufferedWriter(new FileWriter("Bin\\Data\\Positions.ravs"));
                                       for(int i=0;i<AppsNo;i++)
                                       {
                                           b.append(getX(i)+","+getY(i));
                                           b.newLine();
                                       }
                                       b.close();
                                    }catch(Exception asd){try
                                                {
                                        for(int i=0;i<a.size();i++)
                                            {

                                                    b.append(a.get(i).getLocationOnScreen().x + "," + a.get(i).getLocationOnScreen().y);
                                                    b.newLine();


                                            }
                                        b.close();
                                        } catch (IOException ex) {                        }
                                    }
            dispose();
            System.out.println(appPath+" Clicked");
            new Rav(appPath).execute();
      }

      @Override
      public void mousePressed(MouseEvent e) {
        screenX = e.getXOnScreen();
        screenY = e.getYOnScreen();

        myX = getX();
        myY = getY();
      }

      @Override
      public void mouseReleased(MouseEvent e) { }

      @Override
      public void mouseEntered(MouseEvent e) { }

      @Override
      public void mouseExited(MouseEvent e) { }

    });
    addMouseMotionListener(new MouseMotionListener() {

      @Override
      public void mouseDragged(MouseEvent e) {
        int deltaX = e.getXOnScreen() - screenX;
        int deltaY = e.getYOnScreen() - screenY;

        setLocation(myX + deltaX, myY + deltaY);
        //System.out.println("Loaction of JButton "+getName()+" "+getLocationOnScreen().x+"  "+getLocationOnScreen().y);
      }

      @Override
      public void mouseMoved(MouseEvent e) { }

    });

}
public void paintComponent(Graphics g)
{
 	Graphics2D g2 = (Graphics2D)g;
	if (getModel().isPressed())
	{
		g.setColor(Color.WHITE);
		g2.fillRect(3,3,getWidth()-6,getHeight()-6);
	}
	super.paintComponent(g);

	if (mouseIn) g2.setColor(Color.BLACK);
		else     g2.setColor(Color.DARK_GRAY);
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setStroke(new BasicStroke(1.2f));
	g2.draw(new RoundRectangle2D.Double(1,1,(getWidth()-3),(getHeight()-3),12,8));
	g2.setStroke(new BasicStroke(1.5f));
	g2.drawLine(4,getHeight()-3,getWidth()-4,getHeight()-3);

	g2.dispose();
}
public void mouseClicked(MouseEvent e){}
public void mouseEntered(MouseEvent e)
{
	mouseIn = true;
}
public void mouseExited(MouseEvent e)
{
	mouseIn = false;
}
public void mousePressed(MouseEvent e)
{
}
public void mouseReleased(MouseEvent e)
{
}

public int getX(int n)
    {
        //System.out.println("N:"+n+"  Value: "+xr[n].getLocationOnScreen().x);
        return xr[n].getLocationOnScreen().x;
    }

    public int getY(int n)
    {
        return xr[n].getLocationOnScreen().y;
    }

}

class deleteFrame extends JFrame
{
    Container con = null;
    JPanel panelBgImg;

    public deleteFrame()
    {
        setTitle("Trash");
        con = getContentPane();

        con.setLayout(null);
        ImageIcon imh = new ImageIcon("Bin\\img\\trash.png");
        setSize(imh.getIconWidth(), imh.getIconHeight());

        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                Image img = new ImageIcon("Bin\\img\\trash.png").getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            }
        };

        con.add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());

        GridBagLayout layout = new GridBagLayout();

        panelBgImg.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 200));
        setAlwaysOnTop(true);
            DragDrop dndListener = new DragDrop();
            DragSource dragSource = new DragSource();

        //DropTarget dropTarget1 = new DropTarget(source,DnDConstants.ACTION_MOVE, dndListener);
            DropTarget dropTarget2 = new DropTarget(this,DnDConstants.ACTION_MOVE,dndListener);
            dragRecognizer1 = new DragGestureRecognizer[xr.length];
            for(int i=0;i<xr.length;i++)
            {
                dragRecognizer1[i] = dragSource.createDefaultDragGestureRecognizer(xr[i],DnDConstants.ACTION_MOVE, dndListener);
            }
            dragRecognizer2 = new DragGestureRecognizer[a.size()];
            for(int i=0;i<a.size();i++)
            {
                dragRecognizer2[i] = dragSource.createDefaultDragGestureRecognizer(a.get(i),DnDConstants.ACTION_MOVE, dndListener);
            }
            addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we)
                                                    {
                                                        for(int i=0;i<xr.length;i++)
                                                        {
                                                            dragRecognizer1[i] = null;
                                                        }

                                                        for(int i=0;i<a.size();i++)
                                                        {
                                                            dragRecognizer2[i] = null;
                                                        }
                                                    }});
            //setUndecorated(true);
            setBounds(220, 200, 128, 160);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
}

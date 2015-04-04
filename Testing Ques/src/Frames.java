import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.StringTokenizer;
public class Frames extends JFrame implements ActionListener
{
    JFrame f;
   static int flag11=0;
   String in[]=new String[7];
   private JTextField _timeField;
   static boolean checc;
   final int a;
   static int timee;
   static int correct=0;
   static int incorrect=0;
   static boolean click1[];
   static boolean click2[];
   static boolean click3[];
   static boolean click4[];
   static JButton lis[];
   final int co;
   final int inco;
   static String n;
   static String ph;
   static int li[];
   static String q[];
   static String aa1[];
   static String aa2[];
   static String aa3[];
   static String aa4[];
   static int sub[];
   static int visible=0;
   static int ravdiv=0;
   JButton prev,next,submit,finish;
   TextArea ques;
   JRadioButton r1,r2,r3,r4;
   JPanel p,p2,p3,listt,ppp,pppp;
   ButtonGroup bg;
   JLabel b,bb,bbb,qu,head,lister;
   int flag=0;
   static int cq;
   JFrame ff;
    public Frames(String[] q,int l,String name,String phone,String[] info)
    {
        in=info;
        timee=Integer.parseInt(in[6]);
        a=Integer.parseInt(in[3]);
        co=Integer.parseInt(in[4]);
        inco=Integer.parseInt(in[5]);
        checc=true;
        lis=new JButton[a];
        sub=new int[a];
        for(int i=0;i<a;i++)
        {
            lis[i]=new JButton(new ImageIcon(""+(i+1)+".gif"));
            lis[i].setActionCommand(""+i);
            lis[i].addActionListener(this);
        }
        click1=new boolean[a];
        for(int i=0;i<a;i++)
        {
            click1[i]=false;
        }
        click2=new boolean[a];
        for(int i=0;i<a;i++)
        {
            click2[i]=false;
        }
        click3=new boolean[a];
        for(int i=0;i<a;i++)
        {
            click3[i]=false;
        }
        click4=new boolean[a];
        for(int i=0;i<a;i++)
        {
            click4[i]=false;
        }
        n=name;
        ph=phone;
        for(int i=0;i<a;i++)
        {
            sub[i]=-1;
        }
        String qq[]=new String[l];
        String a1[]=new String[l];
        String a2[]=new String[l];
        String a3[]=new String[l];
        String a4[]=new String[l];
        int c=0;
        for(int i=0;i<l;i++)
        {
            StringTokenizer s=new StringTokenizer(q[i],"$");
            while(s.hasMoreTokens())
            {
                String temp=s.nextElement().toString();
                switch(c)
                {
                    case 0: qq[i]=temp;
                        break;
                    case 1: a1[i]=temp;
                        break;
                    case 2:a2[i]=temp;
                        break;
                    case 3:a3[i]=temp;
                        break;
                    case 4:a4[i]=temp;
                        break;
                }
                c++;
            }
            c=0;
        }
        int list[]=new Random1().m(l,a);
        new TextClock1();
        launch(list,qq,a1,a2,a3,a4,0);
    }

    public void launch(int[] l,String[] qq,String[] a1,String[] a2,String[] a3,String[] a4,int cq)
    {
        li=l;
        q=qq;
        aa1=a1;
        aa2=a2;
        aa3=a3;
        aa4=a4;
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        f=new JFrame("Test");
        Toolkit tk = Toolkit.getDefaultToolkit();
        f.setUndecorated(true);
        f.setSize(((int) tk.getScreenSize().getWidth()), ((int) tk.getScreenSize().getHeight()));
        f.setVisible(true);
        launch1(cq);
    }

    public void launch1(int cq)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
         if(flag11==a)
        {
            re();
        }
        else
        {
        if(!checc)
        {
            re();
        }
        if(check())
        {
            re();
        }
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }

        ff=new JFrame("Test");
        bg=new ButtonGroup();
        ff.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {re();}});
        ff.setLayout(new BorderLayout());
        p=new JPanel(new BorderLayout());
        p2=new JPanel(new GridLayout(2,2));
        p3=new JPanel();
        if(a<=10)
        {
            listt=new JPanel(new GridLayout(a,1));
        }
        else
            if(a<=20)
            {
                int aa=a;
                if((a%2)!=0)
                {
                    aa=aa+1;
                }
                listt=new JPanel(new GridLayout((aa/2),2));
            }
            else
                if(a<=30)
                {
                    int aa=a;
                if((a%2)!=0)
                {
                    aa=aa+1;
                }
                listt=new JPanel(new GridLayout((aa/3),3));
                }
                else
                    if(a<=40)
                    {
                        int aa=a;
                if((a%2)!=0)
                {
                    aa=aa+1;
                }
                listt=new JPanel(new GridLayout((aa/4),4));
                    }
        
        ques=new TextArea(q[li[cq]],10,100,TextArea.SCROLLBARS_VERTICAL_ONLY);
        ques.setEditable(false);
        ques.setFont(new Font("Cosmic Sans",Font.BOLD,16));
        prev=new JButton(new ImageIcon("prev.gif"));
        next=new JButton(new ImageIcon("next.gif"));
        submit=new JButton(new ImageIcon("submit.gif"));
        finish=new JButton("Finish");
        finish.addActionListener(this);
        next.setActionCommand("next");
        prev.setActionCommand("prev");
        submit.setActionCommand("submit");
        next.addActionListener(this);
        prev.addActionListener(this);
        submit.addActionListener(this);
        _timeField = new JTextField(4);
        _timeField.setEditable(false);
        _timeField.setFont(new Font("sansserif", Font.PLAIN,16));
        for(int i=0;i<a;i++)
        {
            listt.add(lis[i]);
            if(i==cq)
            {
                lis[i].setBackground(Color.red);
            }
            else
            {
                lis[i].setBackground(Color.white);
            }
        }
        if(aa1[li[cq]].charAt(0)=='#')
        {
            String t4=aa1[li[cq]].substring(2);
            r1=new JRadioButton(t4,click1[cq]);
        }
        else
        {
             r1=new JRadioButton(aa1[li[cq]],click1[cq]);
        }
         if(aa2[li[cq]].charAt(0)=='#')
        {
            String t4=aa2[li[cq]].substring(2);
            r2=new JRadioButton(t4,click2[cq]);
        }
        else
        {
            r2=new JRadioButton(aa2[li[cq]],click2[cq]);
        }
         if(aa3[li[cq]].charAt(0)=='#')
        {
            String t4=aa3[li[cq]].substring(2);
            r3=new JRadioButton(t4,click3[cq]);
        }
        else
        {
             r3=new JRadioButton(aa3[li[cq]],click3[cq]);
        }
         if(aa4[li[cq]].charAt(0)=='#')
        {
            String t4=aa4[li[cq]].substring(2);
            r4=new JRadioButton(t4,click4[cq]);
        }
        else
        {
            r4=new JRadioButton(aa4[li[cq]],click4[cq]);
        }
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        p2.add(r1);
        p2.add(r2);
        p2.add(r3);
        p2.add(r4);
        JPanel h=new JPanel(new BorderLayout());
        String rav1="";
        int rrr=(int) tk.getScreenSize().getWidth();
        for(int rav=0;rav<(rrr/20)+25;rav++)
        {
            rav1=rav1+" ";
        }
        head=new JLabel(rav1+"Gates '10 "+in[0]);
        head.setFont(new Font("Segoe",Font.CENTER_BASELINE,23));
        h.add(head,BorderLayout.CENTER);
        h.add(_timeField,BorderLayout.EAST);
        p.add(h,BorderLayout.NORTH);
        qu=new JLabel("Question "+(cq+1)+"    ");
        qu.setFont(new Font("Segoe",Font.CENTER_BASELINE,18));
        p.add(qu,BorderLayout.WEST);
        p.add(ques,BorderLayout.CENTER);
        lister=new JLabel("                           ");
        lister.setFont(new Font("Segoe",Font.BOLD,22));
        p.add(lister,BorderLayout.EAST);
       // p.add(finish);
       _timeField.setFont(new Font("Cosmic Sans",Font.BOLD,20));
        p3.add(prev);
        p3.add(submit);
        p3.add(next);
        p3.add(finish);
        ff.add(p,BorderLayout.NORTH);
        ff.add(p2,BorderLayout.CENTER);
        ff.add(listt,BorderLayout.EAST);
        ppp=new JPanel(new BorderLayout());
        pppp=new JPanel(new GridLayout(3,1));
        b=new JLabel("Made By: Ravjot Singh  ");
        bb=new JLabel("Email: ravjot28@gmail.com  ");
        bbb=new JLabel("Phone Number:9540140052  ");
        b.setFont(new Font("Palatino Linotype",Font.BOLD,18));
        bb.setFont(new Font("Palatino Linotype",Font.BOLD,18));
        bbb.setFont(new Font("Palatino Linotype",Font.BOLD,18));
        pppp.add(b);
        pppp.add(bb);
        pppp.add(bbb);
        ppp.add(pppp,BorderLayout.SOUTH);
        ff.add(ppp,BorderLayout.WEST);
        ff.add(p3,BorderLayout.SOUTH);
        h.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}            public void keyTyped(KeyEvent e) {}});
        p.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
        p2.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
        p3.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
        ff.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e){ if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {} });
        ques.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
        ppp.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e){ if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {} });
        _timeField.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e){ if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {} });
        pppp.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       prev.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       next.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       submit.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       finish.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       r1.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       r2.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       r3.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       r4.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       listt.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       b.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       bb.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       bbb.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       qu.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       head.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
       lister.addKeyListener(new KeyListener(){public void keyPressed(KeyEvent e) { if((e.isAltDown())||(e.isControlDown())||(e.getKeyCode()==KeyEvent.VK_WINDOWS)){re();}}public void keyReleased(KeyEvent e) {}public void keyTyped(KeyEvent e) {}});
        //ff.setLocation(400,200);
        
        ff.setSize(((int) tk.getScreenSize().getWidth()), ((int) tk.getScreenSize().getHeight()));
        ff.setUndecorated(true);
       // ff.pack();
        if(sub[cq]==0)
        {
            submit.setEnabled(false);
        }
        if(cq==0)
        {
            prev.setEnabled(false);
        }
        else
            if(cq==(li.length-1))
            {
                next.setEnabled(false);
            }
        ff.setVisible(true);
        
    }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("next"))
        {
            ravdiv++;
            click1[cq]=r1.isSelected();
            click2[cq]=r2.isSelected();
            click3[cq]=r3.isSelected();
            click4[cq]=r4.isSelected();
            cq++;
            //ff.setVisible(false);
            //launch(li,q,aa1,aa2,aa3,aa4,cq);
            ques.setText(q[li[cq]]);
            r1.setText(aa1[li[cq]]);
            r1.setSelected(click1[cq]);
            r2.setText(aa1[li[cq]]);
            r2.setSelected(click2[cq]);
            r3.setText(aa1[li[cq]]);
            r3.setSelected(click3[cq]);
            r4.setText(aa1[li[cq]]);
            r4.setSelected(click4[cq]);
            ff.setVisible(false);
            launch1(cq);
        }
        else
            if(e.getActionCommand().equalsIgnoreCase("prev"))
            {
                ravdiv++;
                click1[cq]=r1.isSelected();
                click2[cq]=r2.isSelected();
                click3[cq]=r3.isSelected();
                click4[cq]=r4.isSelected();
                cq--;
               //ff.setVisible(false);
                //launch(li,q,aa1,aa2,aa3,aa4,cq);
            ques.setText(q[li[cq]]);
            r1.setText(aa1[li[cq]]);
            r1.setSelected(click1[cq]);
            r2.setText(aa1[li[cq]]);
            r2.setSelected(click2[cq]);
            r3.setText(aa1[li[cq]]);
            r3.setSelected(click3[cq]);
            r4.setText(aa1[li[cq]]);
            r4.setSelected(click4[cq]);
            ff.setVisible(false);
            launch1(cq);
            }
            else
                if(e.getActionCommand().equalsIgnoreCase("submit"))
                {
                    ravdiv++;
                    flag11++;
                    lis[cq].setEnabled(false);
                    click1[cq]=r1.isSelected();
                    click2[cq]=r2.isSelected();
                    click3[cq]=r3.isSelected();
                    click4[cq]=r4.isSelected();
                    if(aa1[li[cq]].charAt(0)=='#')
                    {
                        if(r1.isSelected())
                        {
                            correct++;
                        }
                        else
                        {
                            incorrect++;
                        }
                    }
                    else
                    {
                        if(aa2[li[cq]].charAt(0)=='#')
                        {
                            if(r2.isSelected())
                            {
                                correct++;
                            }
                            else
                            {
                                incorrect++;
                            }
                        }
                        else
                        {
                             if(aa3[li[cq]].charAt(0)=='#')
                             {
                                 if(r3.isSelected())
                                 {
                                    correct++;
                                 }
                                 else
                                 {
                                    incorrect++;
                                 }
                             }
                             else
                             {
                                if(r4.isSelected())
                                {
                                    correct++;
                                }
                                else
                                {
                                    incorrect++;
                                }
                             }
                        }
                    }
                    sub[cq]=0;
                    submit.setEnabled(false);
                    //ff.setVisible(false);
                    //launch(li,q,aa1,aa2,aa3,aa4,cq);
                    ff.setVisible(false);
            launch1(cq);
                }
                else
                    if(e.getActionCommand().equalsIgnoreCase("Finish"))
                    {

                        re();
                    }
                    else
                    {
                        ravdiv++;
                        click1[cq]=r1.isSelected();
                        click2[cq]=r2.isSelected();
                        click3[cq]=r3.isSelected();
                        click4[cq]=r4.isSelected();
                        cq=Integer.parseInt(e.getActionCommand());
                       ff.setVisible(false);
                        launch1(cq);

                    }

    }

    public boolean check()
    {
        int cp=0;
        for(int i=0;i<sub.length;i++)
        {
            if(sub[i]==0)
            {
                cp++;
            }
        }
        if(cp==sub.length)
        {
            return true;
        }
        return false;
    }

    public void re()
    {
        f.setVisible(false);
        ff.setVisible(false);
        int result=(correct*inco)+(incorrect*co);
        //String msg="Name:"+n+"\n"+"Phone:"+ph;
        //String sub=""+result;
        //sending ss=new sending(msg,sub);
        //ss.send();
        new Final(flag11,correct,incorrect,result);
    }

    class TextClock1
{
    int ss;

    public TextClock1()
    {
        ss =60;
        javax.swing.Timer t = new javax.swing.Timer(1000, new ClockListener());
        t.start();
    }
    class ClockListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
        {
            Calendar now = Calendar.getInstance();
            int m = now.get(Calendar.MINUTE);
            
            ss--;
            if(ss<0)
            {
                timee--;
                ss=60;
            }
            if((timee==0)&&(ss==60))
            {
                _timeField.setForeground(Color.red);
            }
            if((timee==0)&&(ss==0))
            {
                re();
            }
            String result;
            if(ss<10)
            {
                if(timee<10)
                {
                    result="0"+timee+":"+"0"+ss;
                }
                else
                {
                    result=timee+":"+"0"+ss;
                }
            }
            else
            {
                if(timee<10)
                {
                    result="0"+timee+":"+ss;
                }
                else
                {
                    result=timee+":"+ss;
                }
            }

            _timeField.setText(result);
    	}
    }

}
}

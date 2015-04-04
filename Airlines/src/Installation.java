import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;

public class Installation extends JFrame implements ActionListener
{
    XrButton sub = new XrButton(new ImageIcon("Bin\\img\\ok.png"));
    XrButton reset = new XrButton(new ImageIcon("Bin\\img\\reset.png"));
    JLabel head;
    JLabel id;
    JLabel pas;
    JPasswordField pass;
    JTextField idd;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
    public Installation()
    {
        launch();
    }

    private void launch()
    {
        head = new JLabel();
        id = new JLabel();
        pas = new JLabel();
        idd = new JTextField();
        pass = new JPasswordField();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setTitle("Installation Login");
        head.setFont(new  Font("Verdana", 1, 16));
        head.setText("Installation Login");

        id.setFont(new Font("Verdana", 0, 14));
        id.setText("Product ID");

        pas.setFont(new Font("Verdana", 0, 14));
        pas.setText("Password");

        idd.setFont(new Font("Verdana", 0, 14));

        sub.setToolTipText("Submit");
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                if((idd.getText().equalsIgnoreCase("")))
                {
                        JOptionPane.showMessageDialog(null, "Please Enter the Product ID that was provided to you","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                    if(pass.getText().equalsIgnoreCase(""))
                    {
                        JOptionPane.showMessageDialog(null, "Please Enter the Password that was provided to you","Error",JOptionPane.ERROR_MESSAGE);
                    }
                else
                {
                    if((idd.getText().equalsIgnoreCase("123456789"))&&(pass.getText().equalsIgnoreCase("ravjot")))
                    {
                         JFileChooser jfc = new JFileChooser();
                        ImagePreview preview = new ImagePreview(jfc);
                        jfc.addPropertyChangeListener(preview);
                        jfc.setAccessory(preview);
                        //jfc.showOpenDialog(null);
                       if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                        {
                           String r=jfc.getSelectedFile().toString();
                           if(r.endsWith(".mdb"))
                           {
                               Base64Encoder b= new Base64Encoder(r);
                               Base64Encoder b1= new Base64Encoder(b.get());
                               Base64Encoder b2= new Base64Encoder(b1.get());
                               String coded=b2.get();
                               try
                               {
                                   BufferedWriter bb=new BufferedWriter(new FileWriter("Bin\\Data\\db.ravs"));
                                   bb.write(coded);
                                   bb.close();
                               }catch(Exception sdf){}
                               dispose();
                             new GUI(r).setVisible(true);
                            }
                            else
                           {
                               JOptionPane.showMessageDialog(null, "Invalid file. Try Again","Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please Select the database file","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Oops Please enter the correct details","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        reset.setToolTipText("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                idd.setText("");
                pass.setText("");
            }
        });

         GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(head))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(id)
                                .addComponent(pas))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pass)
                                .addComponent(idd,GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(sub)
                        .addGap(57, 57, 57)
                        .addComponent(reset)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(head)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(idd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pas)
                    .addComponent(pass, GroupLayout.PREFERRED_SIZE, 21,GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sub)
                    .addComponent(reset))
                .addGap(39, 39, 39))
        );
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\airindia.jpg"));
        setLocation(h/2,w/7);
        setResizable(false);
        pack();
    }

    public void actionPerformed(ActionEvent e)
    {

    }

}

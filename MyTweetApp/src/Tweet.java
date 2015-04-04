import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Tweet extends JPanel
{
    JLabel jLabel1;
    JLabel jLabel2;
    JScrollPane jScrollPane1;
    JSeparator jSeparator1;
    JTextArea jTextArea1;
    ImageIcon img;
    String uname;
    String tweet;

    public Tweet(ImageIcon i , String u , String t)
    {
        this.img = i;
        this.uname = u;
        this.tweet = t;
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jSeparator1 = new JSeparator();

        setBackground(new Color(255, 255, 255));

        jLabel1.setIcon(img);
        jLabel1.setToolTipText(uname);

        jLabel2.setFont(new Font("Chalkboard", 1, 14));
        jLabel2.setText(uname);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("American Typewriter", 0, 14));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(tweet);
        jTextArea1.setEditable(false);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);
        jScrollPane1.setBorder(null);

        jSeparator1.setForeground(new Color(0, 0, 0));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator1, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1,GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1,GroupLayout.PREFERRED_SIZE, 10,GroupLayout.PREFERRED_SIZE))
        );
    }
}


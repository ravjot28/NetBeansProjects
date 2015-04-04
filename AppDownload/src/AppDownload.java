import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class AppDownload extends JPanel implements Observer
{
    JButton jButton1;
    JLabel jLabel1;
    JProgressBar jProgressBar1;

    private DownloadFile selectedDownload;
    String DownloadLink;    

    public AppDownload(String s)
    {
        this.DownloadLink = s;
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(70, 92));
        setMinimumSize(new java.awt.Dimension(70, 92));

        jLabel1.setIcon(new javax.swing.ImageIcon("Bin\\img\\2.png"));

        jButton1.setIcon(new javax.swing.ImageIcon("Bin\\img\\install.png"));
        jButton1.setName("install");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, 0, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        if(jButton1.getName().equalsIgnoreCase("install"))
        {
            this.actionAdd();
        }
    }



    // Add a new download.
    private void actionAdd()
    {
        URL verifiedUrl = verifyUrl(DownloadLink);
        if (verifiedUrl != null)
        {
            selectedDownload = new DownloadFile(verifiedUrl);
            selectedDownload.addObserver(this);
            jProgressBar1.setIndeterminate(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Server Side Problem.", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    // Verify download URL.
    private URL verifyUrl(String url)
    {
        // Only allow HTTP URLs.
        if (!url.toLowerCase().startsWith("http://"))
        return null;

        // Verify format of URL.
        URL verifiedUrl = null;
        try
        {
            verifiedUrl = new URL(url);
        } catch (Exception e)
            {
                return null;
            }

        // Make sure URL specifies a file.
        if (verifiedUrl.getFile().length() < 2)
        return null;

        return verifiedUrl;
    }

    /* Update each button's state based off of the currently selected download's status. */
    private void updateButtons()
    {
        if (selectedDownload != null)
        {
            int status = selectedDownload.getStatus();
            switch (status)
            {
                case DownloadFile.DOWNLOADING: System.out.println("Downloading");

                                          break;
                case DownloadFile.PAUSED:System.out.println("Paused");

                                     break;
                case DownloadFile.ERROR:System.out.println("Error");

                                    break;
                default: // COMPLETE or CANCELLED
                    System.out.println("Cancelled/Complete");
                    jButton1.setIcon(new javax.swing.ImageIcon("Bin\\img\\installed.png"));
                    jButton1.setName("installed");
                    revalidate();
                    repaint();
                    jProgressBar1.setIndeterminate(false);
            }
        }
        else
        {
            // No download is selected in table.

        }
  }

  /* Update is called when a Download notifies its observers of any changes. */
  public void update(Observable o, Object arg)
  {
    // Update buttons if the selected download has changed.
    if (selectedDownload != null && selectedDownload.equals(o))
      updateButtons();
  }
}

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame
{
    private DownloadList tableModel;
    private JTable table;
    int appid=-1;
    final String[] appnamemac = {"Facebook/","TwitterMac/","YoutubeMac/","GTBIT/Student/","Hukamnama/","MP3Mac/","MailNotifier/","RMailSenderMac/","iTunesControllerMac/","Speak/","txt2pdf/"};
    final String[] appnamewin = {"Facebook\\","TwitterWin\\","YoutubeWin\\","GTBIT\\Student\\","Hukamnama\\","MP3Win\\","MailNotifier\\","RMailSenderWin\\","iTunesControllerWin","Speak\\","txt2pdf\\"};

    public GUI(String s)
    {
        System.out.println("In GUI");
        // Set application title.
        setTitle("App Frame Updates");


        // Set window size.
       // setSize(340, 200);

        // Handle window closing events.
        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        // Set up Downloads table.
        tableModel = new DownloadList();
        table = new JTable(tableModel);
      
        // Allow only one row at a time to be selected.
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Set up ProgressBar as renderer for progress column.
        ProgressBar renderer = new ProgressBar(0, 100);
        renderer.setStringPainted(true); // show progress text
        table.setDefaultRenderer(JProgressBar.class, renderer);

        // Set table's row height large enough to fit JProgressBar.
        table.setRowHeight((int) renderer.getPreferredSize().getHeight());

        // Set up downloads panel.
        JPanel downloadsPanel = new JPanel();
        downloadsPanel.setBorder(BorderFactory.createTitledBorder("Updates"));
        downloadsPanel.setLayout(new BorderLayout());
        downloadsPanel.add(new JScrollPane(table),BorderLayout.CENTER);

        // Add panels to display.
        getContentPane().setLayout(new GridLayout(1,1));
        getContentPane().add(downloadsPanel);
        pack();
        setVisible(true);      
  }

    public void add(String s)
    {
        StringTokenizer s1 = new StringTokenizer(s,",");
        while(s1.hasMoreTokens())
        {
            String temp=s1.nextToken().trim();
            StringTokenizer t = new StringTokenizer(temp,"??");
            appid = Integer.parseInt(t.nextToken());
            String name = t.nextToken();
            actionAdd(name,appid);
        }
    }

    private void actionAdd(String url,int a)
    {

        URL verifiedUrl = verifyUrl(url);
        if (verifiedUrl != null)
        {
            if(new GetOSName().getName().equals("win"))
            {
                
                tableModel.addDownload(new DownloadFile(verifiedUrl,appnamewin[a]));
            }
            else
            {
                tableModel.addDownload(new DownloadFile(verifiedUrl,appnamemac[a]));
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Server Side Error . Report at ravjot28@gmail.com", "Error",JOptionPane.ERROR_MESSAGE);
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

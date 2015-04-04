import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


public class DownloadGUI extends JFrame implements Observer
{
    private JTextField addTextField;
    private DownloadList tableModel;
    private JTable table;
    private JButton pauseButton, resumeButton,cancelButton, clearButton;
    private DownloadFile selectedDownload;
    private boolean clearing;


    public DownloadGUI()
    {
        // Set application title.
        setTitle("Rav's Download Manager");

        // Set window size.
        setSize(640, 480);

        // Handle window closing events.
        addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        actionExit();      }    });

        // Set up add panel.
        JPanel addPanel = new JPanel();
        pauseButton = new JButton("",new ImageIcon("icons/pause.gif"));
        pauseButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionPause();      }    });
        pauseButton.setEnabled(false);
        addPanel.add(pauseButton);
        resumeButton = new JButton("",new ImageIcon("icons/resume.gif"));
        resumeButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionResume();      }    });
        resumeButton.setEnabled(false);
        addPanel.add(resumeButton);
        cancelButton = new JButton("",new ImageIcon("icons/cancel.gif"));
        cancelButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionCancel();      }    });
        cancelButton.setEnabled(false);
        addPanel.add(cancelButton);
        clearButton = new JButton("",new ImageIcon("icons/clear.gif"));
        clearButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionClear();      }    });
        clearButton.setEnabled(false);
        addPanel.add(clearButton);

        JPanel addPane2 = new JPanel();
        addTextField = new JTextField(30);
        addPane2.add(addTextField);
        JButton addButton = new JButton("",new ImageIcon("icons/add.gif"));
        addButton.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e) {        actionAdd();      }    });
        addPane2.add(addButton);

        // Set up Downloads table.
        tableModel = new DownloadList();
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {      public void valueChanged(ListSelectionEvent e) {        tableSelectionChanged();      }    });
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
        downloadsPanel.setBorder(BorderFactory.createTitledBorder("Downloads"));
        downloadsPanel.setLayout(new BorderLayout());
        downloadsPanel.add(new JScrollPane(table),BorderLayout.CENTER);

        // Add panels to display.
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(addPane2);
        getContentPane().add(addPanel);
        getContentPane().add(downloadsPanel);
  }

    // Exit this program.
    private void actionExit()
    {
        System.exit(0);
    }

    // Add a new download.
    private void actionAdd()
    {
        URL verifiedUrl = verifyUrl(addTextField.getText());
        if (verifiedUrl != null)
        {
            tableModel.addDownload(new DownloadFile(verifiedUrl));
            addTextField.setText(""); // reset add text field
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Invalid Download URL", "Error",JOptionPane.ERROR_MESSAGE);
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

    // Called when table row selection changes.
    private void tableSelectionChanged()
    {
        /* Unregister from receiving notifications from the last selected download. */
        if (selectedDownload != null)
        selectedDownload.deleteObserver(DownloadGUI.this);

        /* If not in the middle of clearing a download,set the selected download and register to receive notifications from it. */
        if (!clearing && table.getSelectedRow() > -1)
        {
            selectedDownload =tableModel.getDownload(table.getSelectedRow());
            selectedDownload.addObserver(DownloadGUI.this);
            updateButtons();
        }
    }

    // Pause the selected download.
    private void actionPause()
    {
        selectedDownload.pause();
        updateButtons();
    }

    // Resume the selected download.
    private void actionResume()
    {
        selectedDownload.resume();
        updateButtons();
    }

    // Cancel the selected download.
    private void actionCancel()
    {
        selectedDownload.cancel();
        updateButtons();
    }

    // Clear the selected download.
    private void actionClear()
    {
        clearing = true;
        tableModel.clearDownload(table.getSelectedRow());
        clearing = false;
        selectedDownload = null;
        updateButtons();
    }

    /* Update each button's state based off of the currently selected download's status. */
    private void updateButtons()
    {
        if (selectedDownload != null)
        {
            int status = selectedDownload.getStatus();
            switch (status)
            {
                case DownloadFile.DOWNLOADING:
                                          pauseButton.setEnabled(true);
                                          resumeButton.setEnabled(false);
                                          cancelButton.setEnabled(true);
                                          clearButton.setEnabled(false);
                                          break;
                case DownloadFile.PAUSED:
                                     pauseButton.setEnabled(false);
                                     resumeButton.setEnabled(true);
                                     cancelButton.setEnabled(true);
                                     clearButton.setEnabled(false);
                                     break;
                case DownloadFile.ERROR:
                                    pauseButton.setEnabled(false);
                                    resumeButton.setEnabled(true);
                                    cancelButton.setEnabled(false);
                                    clearButton.setEnabled(true);
                                    break;
                default: // COMPLETE or CANCELLED
                        pauseButton.setEnabled(false);
                        resumeButton.setEnabled(false);
                        cancelButton.setEnabled(false);
                        clearButton.setEnabled(true);
            }
        }
        else
        {
            // No download is selected in table.
            pauseButton.setEnabled(false);
            resumeButton.setEnabled(false);
            cancelButton.setEnabled(false);
            clearButton.setEnabled(false);
        }
  }

  /* Update is called when a Download notifies its observers of any changes. */
  public void update(Observable o, Object arg)
  {
    // Update buttons if the selected download has changed.
    if (selectedDownload != null && selectedDownload.equals(o))
      updateButtons();
  }

  // Run the Download Manager.
  public static void main(String[] args)
  {
    DownloadGUI manager = new DownloadGUI();
    manager.setLocationRelativeTo(null);
    manager.setVisible(true);
  }
}

class DownloadFile extends Observable implements Runnable {
  // Max size of download buffer.
  private static final int MAX_BUFFER_SIZE = 1024;

  // These are the status names.
  public static final String STATUSES[] = {"Downloading","Paused", "Complete", "Cancelled", "Error"};

  // These are the status codes.
  public static final int DOWNLOADING = 0;
  public static final int PAUSED = 1;
  public static final int COMPLETE = 2;
  public static final int CANCELLED = 3;
  public static final int ERROR = 4;

  private URL url; // download URL
  private int size; // size of download in bytes
  private int downloaded; // number of bytes downloaded
  private int status; // current status of download

  // Constructor for Download.
    public DownloadFile(URL url)
    {
        this.url = url;
        size = -1;
        downloaded = 0;
        status = DOWNLOADING;
        // Begin the download.
        download();
    }


    // Get this download's URL.
    public String getUrl()
    {
        return url.toString();
    }


    // Get this download's size.
    public int getSize()
    {
        return size;
    }

    //Get the downloaded bytes
    public int getDownloaded()
    {
        return downloaded;
    }


    // Get this download's progress.
    public float getProgress()
    {
        return ((float) downloaded / size) * 100;
    }

    // Get the file name
    public String getName()
    {
        String p=url.getFile();
        return p.substring(p.lastIndexOf('/') + 1);
    }


    // Get this download's status.
    public int getStatus()
    {
        return status;
    }


    // Pause this download.
    public void pause()
    {
        status = PAUSED;
        stateChanged();
    }


    // Resume this download.
    public void resume()
    {
        status = DOWNLOADING;
        stateChanged();
        download();
    }


    // Cancel this download.
    public void cancel()
    {
        status = CANCELLED;
        stateChanged();
    }


    // Mark this download as having an error.
    private void error()
    {
        status = ERROR;
        stateChanged();
    }


    // Start or resume downloading.
    private void download()
    {
        Thread thread = new Thread(this);
        thread.start();
    }


    // Get file name portion of URL.
    private String getFileName(URL url)
    {
        String fileName = url.getFile();
        return fileName.substring(fileName.lastIndexOf('/') + 1);
    }


    // Download file.
    public void run()
    {
        RandomAccessFile file = null;
        InputStream stream = null;
        String filendir=null;

        try
        {
            // Open connection to URL.
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();

            // Specify what portion of file to download.
            connection.setRequestProperty("Range","bytes=" + downloaded + "-");

            // Connect to server.
            connection.connect();

            // Make sure response code is in the 200 range.
            if (connection.getResponseCode() / 100 != 2)
            {
                error();
            }

            // Check for valid content length.
            int contentLength = connection.getContentLength();
            if (contentLength < 1)
            {
                error();
            }

            /* Set the size for this download if it hasn't been already set. */
            if (size == -1)
            {
                size = contentLength;
                stateChanged();
            }

            // Open file and seek to the end of it.
            FolderChooser fc=new FolderChooser();
            filendir=fc.go();
            if(filendir.equalsIgnoreCase("No"))
            {
                filendir=getFileName(url);
            }
            else
            {
                filendir=filendir+"\\"+getFileName(url);
            }
            file = new RandomAccessFile(filendir, "rw");
                file.seek(downloaded);
                stream = connection.getInputStream();
            while (status == DOWNLOADING)
            {
                /* Size buffer according to how much of the file is left to download. */
                byte buffer[];
                if (size - downloaded > MAX_BUFFER_SIZE)
                {
                    buffer = new byte[MAX_BUFFER_SIZE];
                }
                else
                {
                    buffer = new byte[size - downloaded];
                }

                // Read from server into buffer.
                int read = stream.read(buffer);
                if (read == -1)
                    break;

                // Write buffer to file.
                file.write(buffer, 0, read);
                downloaded += read;
                stateChanged();
            }

        /* Change status to complete if this point was reached because downloading has finished. */
        if (status == DOWNLOADING)
        {
            status = COMPLETE;
            String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + filendir;
            System.out.println(cmd);
            Process p = Runtime.getRuntime().exec(cmd);
            stateChanged();
        }
    } catch (Exception e)
        {
            error();
        } finally
            {
                // Close file.
                if (file != null)
                {
                    try
                    {
                        file.close();
                    } catch (Exception e)
                        {
                        }
                }

                // Close connection to server.
                if (stream != null)
                {
                    try
                    {
                        stream.close();
                    } catch (Exception e)
                        {
                        }
                }
            }
  }

    // Notify observers that this download's status has changed.
    private void stateChanged()
    {
        setChanged();
        notifyObservers();
    }
}


class FolderChooser extends JPanel implements ActionListener
{
   JButton go;
   JFileChooser chooser;
   String choosertitle="Select Location";

 public String go()
 {
    String r=null;
    chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
    {
      //System.out.println("getCurrentDirectory():"+  chooser.getCurrentDirectory());
      //System.out.println("getSelectedFile():"+  chooser.getSelectedFile());
      r=chooser.getSelectedFile().toString();
      }
    else
    {
      //System.out.println("No Selection ");
        r="No";
    }
    return(r);
     }

    public void actionPerformed(ActionEvent e)
    {

    }

}

// This class manages the download table's data.
class DownloadList extends AbstractTableModel implements Observer
{

  // These are the names for the table's columns.
  private static final String[] columnNames = {"File", "Size","Downloaded","Progress", "Status"};

  // These are the classes for each column's values.
  private static final Class[] columnClasses = {String.class,String.class,String.class,JProgressBar.class, String.class};

  // The table's list of downloads.
  private ArrayList<DownloadFile> downloadList =new ArrayList<DownloadFile>();

  public String output;

  // Add a new download to the table.
  public void addDownload(DownloadFile download)
  {
        // Register to be notified when the download changes.
        download.addObserver(this);

        downloadList.add(download);

        // Fire table row insertion notification to table.
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
  }

  // Get a download for the specified row.
  public DownloadFile getDownload(int row)
  {
        return (DownloadFile) downloadList.get(row);
  }

  // Remove a download from the list.
  public void clearDownload(int row)
  {
        downloadList.remove(row);

        // Fire table row deletion notification to table.
        fireTableRowsDeleted(row, row);
  }

  // Get table's column count.
  public int getColumnCount()
  {
        return columnNames.length;
  }

  // Get a column's name.
  public String getColumnName(int col)
  {
        return columnNames[col];
  }

  // Get a column's class.
  public Class getColumnClass(int col)
  {
        return columnClasses[col];
  }

  // Get table's row count.
  public int getRowCount()
  {
        return downloadList.size();
  }

  // Get value for a specific row and column combination.
  public Object getValueAt(int row, int col)
  {
        DownloadFile download = downloadList.get(row);
        switch (col)
        {
            case 0: // URL
                   return download.getName();
            case 1: // Size
                   int size = download.getSize();
                   float s=size/1024;
                   if(s>=1024)
                   {
                       s=s/1024;
                       output=Float.toString(s)+" MB";
                   }
                   else
                   {
                       output=Float.toString(s)+" KB";
                   }
                   return (size == -1) ? "" : output;
            case 2://Downloaded
                   int downloaded=download.getDownloaded();
                   float d=downloaded/1024;
                   if(d>=1024)
                   {
                       d=d/1024;
                       output=Float.toString(d)+" MB";
                   }
                   else
                   {
                       output=Float.toString(d)+" KB";
                   }
                   return (downloaded == -1) ? "": output;
            case 3: // Progress
                   return new Float(download.getProgress());
            case 4: // Status
                   return DownloadFile.STATUSES[download.getStatus()];
        }
        return "";
  }

  /* Update is called when a Download notifies its observers of any changes */
  public void update(Observable o, Object arg)
  {
    int index = downloadList.indexOf(o);
    // Fire table row update notification to table.
    fireTableRowsUpdated(index, index);
  }
}class ProgressBar extends JProgressBar implements TableCellRenderer
{
  // Constructor for ProgressRenderer.
  public ProgressBar(int min, int max)
  {
        super(min, max);
  }

  /* Returns this JProgressBar as the renderer for the given table cell. */
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column)
  {
        // Set JProgressBar's percent complete value.
        setValue((int) ((Float) value).floatValue());
        return this;
  }
}

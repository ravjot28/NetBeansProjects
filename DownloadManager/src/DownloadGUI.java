import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

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

        setTitle("Rav's Download Manager");

        setSize(640, 480);

        addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        actionExit();      }    });

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


        tableModel = new DownloadList();
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {      public void valueChanged(ListSelectionEvent e) {        tableSelectionChanged();      }    });
    
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ProgressBar renderer = new ProgressBar(0, 100);
        renderer.setStringPainted(true);
        table.setDefaultRenderer(JProgressBar.class, renderer);

        table.setRowHeight((int) renderer.getPreferredSize().getHeight());

        JPanel downloadsPanel = new JPanel();
        downloadsPanel.setBorder(BorderFactory.createTitledBorder("Downloads"));
        downloadsPanel.setLayout(new BorderLayout());
        downloadsPanel.add(new JScrollPane(table),BorderLayout.CENTER);


        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(addPane2);
        getContentPane().add(addPanel);
        getContentPane().add(downloadsPanel);

  }

    private void actionExit()
    {
        System.exit(0);
    }

    private void actionAdd()
    {
        URL verifiedUrl = verifyUrl(addTextField.getText());
        if (verifiedUrl != null)
        {
            tableModel.addDownload(new DownloadFile(verifiedUrl));
            addTextField.setText(""); 
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Invalid Download URL", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private URL verifyUrl(String url)
    {

        if (!url.toLowerCase().startsWith("http://"))
        return null;

        URL verifiedUrl = null;
        try
        {
            verifiedUrl = new URL(url);
        } catch (Exception e)
            {
                return null;
            }


        if (verifiedUrl.getFile().length() < 2)
        return null;

        return verifiedUrl;
    }

    private void tableSelectionChanged()
    {

        if (selectedDownload != null)
        selectedDownload.deleteObserver(DownloadGUI.this);


        if (!clearing && table.getSelectedRow() > -1)
        {
            selectedDownload =tableModel.getDownload(table.getSelectedRow());
            selectedDownload.addObserver(DownloadGUI.this);
            updateButtons();
        }
    }


    private void actionPause()
    {
        selectedDownload.pause();
        updateButtons();
    }


    private void actionResume()
    {
        selectedDownload.resume();
        updateButtons();
    }


    private void actionCancel()
    {
        selectedDownload.cancel();
        updateButtons();
    }


    private void actionClear()
    {
        clearing = true;
        tableModel.clearDownload(table.getSelectedRow());
        clearing = false;
        selectedDownload = null;
        updateButtons();
    }


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
                default: 
                        pauseButton.setEnabled(false);
                        resumeButton.setEnabled(false);
                        cancelButton.setEnabled(false);
                        clearButton.setEnabled(true);
            }
        }
        else
        {

            pauseButton.setEnabled(false);
            resumeButton.setEnabled(false);
            cancelButton.setEnabled(false);
            clearButton.setEnabled(false);
        }
  }


  public void update(Observable o, Object arg)
  {

    if (selectedDownload != null && selectedDownload.equals(o))
      updateButtons();
  }
  
  public static void main(String[] args)
  {
    DownloadGUI manager = new DownloadGUI();
    manager.setIconImage(Toolkit.getDefaultToolkit().getImage("rav.gif"));
    manager.setLocationRelativeTo(null);
    manager.setVisible(true);
  }
}

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

class DownloadList extends AbstractTableModel implements Observer
{

  private static final String[] columnNames = {"File", "Size","Downloaded","Progress", "Status"};

  private static final Class[] columnClasses = {String.class,String.class,String.class,JProgressBar.class, String.class};


  private ArrayList<DownloadFile> downloadList =new ArrayList<DownloadFile>();

  public String output;

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

  public void update(Observable o, Object arg)
  {
    int index = downloadList.indexOf(o);
    
    fireTableRowsUpdated(index, index);
  }
}
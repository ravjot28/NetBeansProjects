import java.text.DecimalFormat;
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

        download.addObserver(this);

        downloadList.add(download);

        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
  }


  public DownloadFile getDownload(int row)
  {
        return (DownloadFile) downloadList.get(row);
  }

  public void clearDownload(int row)
  {
        downloadList.remove(row);
        fireTableRowsDeleted(row, row);
  }

  public int getColumnCount()
  {
        return columnNames.length;
  }

  public String getColumnName(int col)
  {
        return columnNames[col];
  }

  public Class getColumnClass(int col)
  {
        return columnClasses[col];
  }

  public int getRowCount()
  {
        return downloadList.size();
  }

  public Object getValueAt(int row, int col)
  {
        DownloadFile download = downloadList.get(row);
        switch (col)
        {
            case 0:
                   return download.getName();
            case 1:
                   int size = download.getSize();
                   float s=size/1024;
                   float rav=(float) roundTwoDecimals(s);
                   if(s>=1024)
                   {
                       s=s/1024;
                       float rav1=(float) roundTwoDecimals(s);
                       output=Float.toString(rav1)+" MB";
                   }
                   else
                   {
                       output=Float.toString(rav)+" KB";
                   }
                   
                   return (size == -1) ? "" : output;
            case 2:
                   int downloaded=download.getDownloaded();
                   float d=downloaded/1024;
                   float rav2=(float) roundTwoDecimals(d);
                   if(d>=1024)
                   {
                       d=d/1024;
                       float rav3=(float) roundTwoDecimals(d);
                       output=Float.toString(rav3)+" MB";
                   }
                   else
                   {
                       output=Float.toString(rav2)+" KB";
                   }
                   return (downloaded == -1) ? "": output;
            case 3:
                   return new Float(download.getProgress());
            case 4:
                   return DownloadFile.STATUSES[download.getStatus()];
        }
        return "";
  }

  double roundTwoDecimals(double d) {
        	DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
}
  public void update(Observable o, Object arg)
  {
    int index = downloadList.indexOf(o);
    fireTableRowsUpdated(index, index);
  }
}
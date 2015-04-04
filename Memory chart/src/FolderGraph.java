import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import org.jfree.data.general.PieDataset;

public class FolderGraph
{
    static int totalFolderCount = 0;
    static int totalFileCount = 0;

    FolderGraph(String name)
    {
        String folder;
        if(name.startsWith("C:\\"))
        {
            folder ="C:\\Program Files";
        }
        else
        {
            folder =name;
        }
        ArrayList dataList = new ArrayList();
        File myFile = new File(folder);
        File[] fileArray = myFile.listFiles();
        for (int i = 0; i < fileArray.length; i++)
        {
            if ((fileArray[i].isDirectory())&&((!fileArray[i].isHidden())))
            {
                long fileSizeByte = getFileSize(new File(fileArray[i].getAbsolutePath()));
                MyFileObj obj = new MyFileObj(fileArray[i].getName(),fileSizeByte / (1024 * 1024));
                dataList.add(obj);
            }
        }
        CategoryDataset categoryDataset = createCategoryDataset(dataList);
        JFreeChart chartHorizontal = create3DBarChart(categoryDataset,
        PlotOrientation.VERTICAL);
        String horizontalChartFileSaveLocation = "C:/Temp/myFolderSizeGraph1.jpg";
        String cmd="rundll32" + " " + "url.dll,FileProtocolHandler" + " " +horizontalChartFileSaveLocation;
        saveChart(chartHorizontal, horizontalChartFileSaveLocation);
        try
        {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (Exception ex) {  }
        File f=new File(horizontalChartFileSaveLocation);
        f.deleteOnExit();
    }

    public static long getFileSize(File folder)
    {
        totalFolderCount++; // Counting the total folders
        long foldersize = 0;
        File[] filelist = folder.listFiles();
        for (int i = 0; i < filelist.length; i++)
        {
            if ((filelist[i].isDirectory())&&((!filelist[i].isHidden())))
            {
                foldersize += getFileSize(filelist[i]);
            }
            else
                if((!filelist[i].isHidden()))
            {
                totalFileCount++; // Counting the total files
                foldersize += filelist[i].length();
            }
        }
        return foldersize;
    }

    private static CategoryDataset createCategoryDataset(ArrayList myFileObjArr)
    {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < myFileObjArr.size(); i++)
        {
            dataset.addValue(((MyFileObj) myFileObjArr.get(i)).getFolderSizeTotal(), "Folder Size (MB)",((MyFileObj) myFileObjArr.get(i)).getFolderName());
        }
        return dataset;
    }

    private static JFreeChart create3DBarChart(CategoryDataset dataset,PlotOrientation plotOrientation)
    {
        JFreeChart chart = ChartFactory.createBarChart3D(
        "FolderGraph Rav Softs", // Chart Title
        "Folder Name", // Domain Axis Label
        "Folder Size", // Range Axis Label
        dataset, // Data
        plotOrientation, // Orientation
        true, // Include Legend
        true, // Tooltips
        false // Urls
                );
        return chart;
    }

    public static void saveChart(JFreeChart chart, String fileLocation)
    {
        try
        {
            ChartUtilities.saveChartAsJPEG(new File(fileLocation), chart, 900,900);
        } catch (IOException e) {System.err.println("Problem occurred creating chart.");}
    }

}

class MyFileObj
{
    String folderName;
    long folderSizeTotal;
    
    public MyFileObj(String folderName, long folderSizeTotal)
    {
        this.folderName = folderName;
        this.folderSizeTotal = folderSizeTotal;
    }

    public String getFolderName()
    {
        return folderName;
    }

    public void setFolderName(String folderName)
    {
        this.folderName = folderName;
    }

    public long getFolderSizeTotal()
    {
        return folderSizeTotal;
    }

    public void setFolderSizeTotal(long folderSizeTotal)
    {
        this.folderSizeTotal = folderSizeTotal;
    }
}

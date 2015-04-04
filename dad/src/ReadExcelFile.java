import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReadExcelFile
{

    ReadExcelFile(String fileName)
    {

    	Vector dataHolder=readExcelFile(fileName);
        
    	String data[]=printCellDataToConsole(dataHolder);
        System.out.println(data.length);
        for(int j=0;j<data.length;j++)
        {
            StringTokenizer t=new StringTokenizer(data[j],"&&");
            if(t.countTokens()>=7)
            {
                int rav=0;
                String rav1[]=new String[7];
                while((t.hasMoreElements())&&(rav<7))
                {
                    rav1[rav]=t.nextToken();
                    rav++;
                }
                createFiles(rav1);
            }
        }
    }

    public static void createFiles(String a[])
    {
        String memno=a[0];
        String name=a[1];
        String staffno=a[4];
        String dob=a[3];
        String nom=a[6];
        try
        {
            int a1 = 0;
            String a3="";
            try
            {
                a1=(int)Float.parseFloat(staffno);
                a3=staffno.substring(0,6);
                System.out.println(a3);
            }catch(Exception s){a3="neglect";}
            BufferedWriter b=new BufferedWriter(new FileWriter("Bin/Info/"+a3+".ravs"));
            b.append(new Base64Encoder(new Base64Encoder(new Base64Encoder(new Base64Encoder(dob).get()).get()).get()).get());
            b.newLine();
            b.append(new Base64Encoder(new Base64Encoder(new Base64Encoder(new Base64Encoder(""+(int)Float.parseFloat(memno)).get()).get()).get()).get());
            b.newLine();
            b.append(new Base64Encoder(new Base64Encoder(new Base64Encoder(new Base64Encoder(name).get()).get()).get()).get());
            b.newLine();
            b.append(new Base64Encoder(new Base64Encoder(new Base64Encoder(new Base64Encoder(staffno).get()).get()).get()).get());
            b.newLine();
            b.append(new Base64Encoder(new Base64Encoder(new Base64Encoder(new Base64Encoder(nom).get()).get()).get()).get());
            b.close();
        }catch(Exception asd){System.out.println(asd);}
    }

    public static Vector readExcelFile(String fileName)
    {
    	Vector cellVectorHolder = new Vector();

    	try
        {
            FileInputStream myInput = new FileInputStream(fileName);


            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);


            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);


            HSSFSheet mySheet = myWorkBook.getSheetAt(0);


            Iterator rowIter = mySheet.rowIterator();

            while(rowIter.hasNext())
            {
        	  HSSFRow myRow = (HSSFRow) rowIter.next();
        	  Iterator cellIter = myRow.cellIterator();
        	  Vector cellStoreVector=new Vector();
        	  while(cellIter.hasNext())
                  {
        		  HSSFCell myCell = (HSSFCell) cellIter.next();
                          //System.out.println(myCell);
        		  cellStoreVector.addElement(myCell);
        	  }
        	  cellVectorHolder.addElement(cellStoreVector);
          }
    	}catch (Exception e){e.printStackTrace(); }
    	return cellVectorHolder;
    }

	private static String[] printCellDataToConsole(Vector dataHolder)
        {
            String result[]=new String[dataHolder.size()-3];

		for (int i=3;i<dataHolder.size(); i++)
                {

                   Vector cellStoreVector=(Vector)dataHolder.elementAt(i);
                   String temp="";
			for (int j=0; j<cellStoreVector.size();j++)
                        {
				HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(j);
				String stringCellValue = myCell.toString();
				temp+=stringCellValue+"&&";
			}
			result[i-3]=temp;
		}

            return result;
	}
}

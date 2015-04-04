import java.io.*;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel implements Runnable
{
    private String inputFile;
    public static FileOutputStream Output;
    public static PrintStream file;
    Thread th = new Thread(this);

    ReadExcel(String inputFile)
    {
        this.inputFile = inputFile;                 //Excel file path
        th.start();                                 //Excel reading and DB creation thread
    }

    public void run()
    {
        File inputWorkbook = new File(inputFile);
        Workbook w = null;
        try
        {
            try
            {
                w = Workbook.getWorkbook(inputWorkbook);
            } catch (IOException ex)
                    {
                        System.out.println("Exception 1");
                    }
            // Get the first sheet
            Sheet sheet = w.getSheet(0);

            for (int j = 0; j < sheet.getRows(); j++)
            {
                Cell v1=sheet.getCell(1, j);
                try
                {
                    Output = new FileOutputStream("Bin\\Data\\Students\\"+v1.getContents()+".bal");        //Path where the db will be stored
                    file = new PrintStream(Output);
                }
                catch(Exception e)
                        {
                            System.out.println("Could not load file!");
                        }
                            
                for (int i = 0; i < sheet.getColumns(); i++)
                {
                    Cell cell = sheet.getCell(i, j);
                    CellType type = cell.getType();
                       
                    if ((cell.getType() == CellType.LABEL) ||  (cell.getType() == CellType.NUMBER))
                    {
                        file.println(new Base64Encoder(cell.getContents()).get());
                    }
                }
                            
            }

	} catch (BiffException e)
                    {
			e.printStackTrace();
                    }
    }
}




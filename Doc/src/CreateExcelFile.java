import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateExcelFile {

    public static void main( String [] args )
    {
    	/**Name of excel file that we are going to create**/
    	String fileName="/dj.xls";
    	writeDataToExcelFile(fileName);
    }
    /** This method writes data to new excel file **/
	 private static void writeDataToExcelFile(String fileName)
         {

	     String [][] excelData = preapreDataToWriteToExcel();

		 HSSFWorkbook myWorkBook = new HSSFWorkbook();
		 HSSFSheet mySheet = myWorkBook.createSheet();
		 HSSFRow myRow = null;
		 HSSFCell myCell = null;

		 for (int rowNum = 0; rowNum < excelData[0].length; rowNum++){
			 myRow = mySheet.createRow(rowNum);

			 for (int cellNum = 0; cellNum < 4 ; cellNum++){
		         myCell = myRow.createCell(cellNum);
		         myCell.setCellValue(excelData[rowNum][cellNum]);

		     }
		 }

		 try{
			 FileOutputStream out = new FileOutputStream(fileName);
			 myWorkBook.write(out);
			 out.close();
		 }catch(Exception e){ e.printStackTrace();}

	}
	 /**Prepare some demo data as excel file content**/
	 public static String [][] preapreDataToWriteToExcel(){
		 String [][] excelData = new String [4][4];
		 excelData[0][0]="First Name";
		 excelData [0][1]="Last Name";
		 excelData[0][2]="Telephone";
		 excelData[0][3]="Address";

		 excelData[1][0]="Kushal";
		 excelData[1][1]="Paudyal";
		 excelData[1][2]="000-000-0000";
		 excelData[1][3]="IL,USA";

		 excelData[2][0]="Randy";
		 excelData[2][1]="Ram Robinson";
		 excelData[2][2]="111-111-1111";
		 excelData[2][3]="TX, USA";

		 excelData[3][0]="Phil";
		 excelData[3][1]="Collins";
		 excelData[3][2]="222-222-2222";
		 excelData[3][3]="NY, USA";

		 return excelData;

	 }

}

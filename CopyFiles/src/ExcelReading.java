/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Rav
 */
public class ExcelReading {

    public static void main(String as[]) throws FileNotFoundException, IOException {

        boolean removeHeader = true;
        FileInputStream file = new FileInputStream(new File("C:\\Users\\Rav\\Desktop\\sample.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(file);

        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        if (rowIterator.hasNext() && removeHeader) {
            Row rowHeader = rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<String> list = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        list.add("" + cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        list.add("" + cell.getStringCellValue());
                        break;
                }
            }
            System.out.println(list);
            if (!isDirectoryAlreadyExisits(list.get(0))) {
                createDirectory(list.get(0));
            }
            createFile(list.get(0)+File.separator+list.get(1).replaceAll(".0","")+".txt",list.get(2).replaceAll("\\<.*?>",""));
        }
        file.close();
    }

    private static boolean isDirectoryAlreadyExisits(String name) {
        File f = new File(name);
        return f.exists();
    }

    private static boolean createDirectory(String name) {
        File f = new File(name);
        return f.mkdir();
    }

    private static void createFile(String name,String content) throws IOException {
        File file = new File(name);
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
        fw.close();
    }
}

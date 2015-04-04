/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 *
 * @author Rav
 */
public class ExcelCreator {

    public ExcelCreator(String[][] cabinetInfo, List<ArrayList> subrackInfo) {
        HSSFWorkbook wb = new HSSFWorkbook();

        Sheet sheet = wb.createSheet("Info");
        CellRangeAddress region = null;
        HSSFRow rowA = null;
        HSSFCell cellA = null;
        int start = 0;
        int cabins = 0;
        for (String[] cabinets : cabinetInfo) {
            int products = Integer.parseInt(cabinets[1]);
            int end = start + products - 1;
            region = new CellRangeAddress(start, end, 0, 0);
            sheet.addMergedRegion(region);
            rowA = (HSSFRow) sheet.createRow(start);
            cellA = rowA.createCell(0);
            cellA.setCellValue(new HSSFRichTextString(cabinets[0]));
            cabins++;
            start = end + 1;

        }

        start = 0;
        cabins = 0;

        for (List subRacks : subrackInfo) {

            int products = (Integer.parseInt(subRacks.get(3).toString()));
            if (products == 0) {
                products = 1;
            }

            int end = start + products - 1;


            region = new CellRangeAddress(start, end, 1, 1);
            sheet.addMergedRegion(region);
            rowA = (HSSFRow) sheet.getRow(start);
            if (rowA == null) {
                rowA = (HSSFRow) sheet.createRow(start);
            }
            cellA = rowA.createCell(1);
            cellA.setCellValue(new HSSFRichTextString(subRacks.get(0).toString()));


            region = new CellRangeAddress(start, end, 2, 2);
            sheet.addMergedRegion(region);
            rowA = (HSSFRow) sheet.getRow(start);
            if (rowA == null) {
                rowA = (HSSFRow) sheet.createRow(start);
            }
            cellA = rowA.createCell(2);
            cellA.setCellValue(new HSSFRichTextString(subRacks.get(1).toString()));

            region = new CellRangeAddress(start, end, 3, 3);
            sheet.addMergedRegion(region);
            rowA = (HSSFRow) sheet.getRow(start);
            if (rowA == null) {
                rowA = (HSSFRow) sheet.createRow(start);
            }
            cellA = rowA.createCell(3);
            cellA.setCellValue(new HSSFRichTextString(subRacks.get(2).toString()));
            start = end + 1;
        }


        int temp1 = 0;
        start = 0;
        for (List subRacks : subrackInfo) {
            List<ArrayList> boards = (List<ArrayList>) subRacks.get(4);

            for (ArrayList b : boards) {
                String boardName = (String) b.get(0);
                String slotPosition = (String) b.get(1);
                String type = (String) b.get(2);
                int size = Integer.parseInt((String) b.get(3));

                int end = start + size - 1;


                region = new CellRangeAddress(start, end, 4, 4);
                sheet.addMergedRegion(region);
                rowA = (HSSFRow) sheet.getRow(start);
                if (rowA == null) {
                    rowA = (HSSFRow) sheet.createRow(start);
                }
                cellA = rowA.createCell(4);
                cellA.setCellValue(new HSSFRichTextString(boardName));

                region = new CellRangeAddress(start, end, 5, 5);
                sheet.addMergedRegion(region);
                rowA = (HSSFRow) sheet.getRow(start);
                if (rowA == null) {
                    rowA = (HSSFRow) sheet.createRow(start);
                }
                cellA = rowA.createCell(5);
                cellA.setCellValue(new HSSFRichTextString(slotPosition));


                region = new CellRangeAddress(start, end, 6, 6);
                sheet.addMergedRegion(region);
                rowA = (HSSFRow) sheet.getRow(start);
                if (rowA == null) {
                    rowA = (HSSFRow) sheet.createRow(start);
                }
                cellA = rowA.createCell(6);
                cellA.setCellValue(new HSSFRichTextString(type));

                start = end + 1;

                List<ProductData> products = (List) b.get(4);

                for (ProductData product : products) {
                    rowA = (HSSFRow) sheet.getRow(temp1);
                    if (rowA == null) {
                        rowA = (HSSFRow) sheet.createRow(temp1);
                    }
                    cellA = rowA.createCell(7);
                    cellA.setCellValue(new HSSFRichTextString(product.getFirstOperationDate()));
                    
                    cellA = rowA.createCell(8);
                    cellA.setCellValue(new HSSFRichTextString(product.getLastChangedDate()));
                    
                    cellA = rowA.createCell(9);
                    cellA.setCellValue(new HSSFRichTextString(product.getManufacturedDate()));
                    
                    cellA = rowA.createCell(10);
                    cellA.setCellValue(new HSSFRichTextString(product.getProductName()));
                    
                    cellA = rowA.createCell(11);
                    cellA.setCellValue(new HSSFRichTextString(product.getProductNumber()));
                    
                    cellA = rowA.createCell(12);
                    cellA.setCellValue(new HSSFRichTextString(product.getProductRevision()));
                    
                    cellA = rowA.createCell(13);
                    cellA.setCellValue(new HSSFRichTextString(product.getSerialNumber()));
                    
                    cellA = rowA.createCell(14);
                    cellA.setCellValue(new HSSFRichTextString(product.getSupplier()));
                    
                }
                temp1++;
            }
        }


        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("Data.xls"));
            wb.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ExcelCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String as[]) {
        //new ExcelCreator();
    }
}

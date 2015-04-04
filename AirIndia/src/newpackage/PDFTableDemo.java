package newpackage;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPCell;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;

public class PDFTableDemo
{
    public static void main(String[] args)
    {
        String[] headers = new String[] {"Code","Amount"};
        String[][] data = new String[][] {
                {"001 BASIC PAY", "16345"},
                {"002 VDA", "3454"},
                {"003 POSITIONING ALC","200"}
        };
        Document document = new Document(PageSize.LETTER.rotate());

        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File("Table.pdf")));
            document.open();
            PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(header.toUpperCase(), new Font(Font.HELVETICA, 10, Font.BOLD)));
                table.addCell(cell);
            }
            table.completeRow();

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    String datum = data[i][j];
                    PdfPCell cell = new PdfPCell();
                    cell.setPhrase(new Phrase(datum.toUpperCase(), new Font(Font.HELVETICA, 10, Font.NORMAL)));
                    table.addCell(cell);
                }
                table.completeRow();
                
            }
            table.setWidthPercentage(50);
            document.addTitle("Table Demo");
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
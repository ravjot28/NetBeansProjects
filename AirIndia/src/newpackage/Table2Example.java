/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPCell;
public class Table2Example {
  public PdfPTable table(String[][] info) {
    Document document = new Document();

    try {
      String[] headers = new String[] {"Allow","Deduct"};
      document.open();
      PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header.toUpperCase()));
                cell.setGrayFill(0.9f);
                table.addCell(cell);
            }
      table.completeRow();

      /*PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
      PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
      PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));*/

      PdfPTable nestedTable = gettable(info);
      PdfPCell cell1 = new PdfPCell(new Paragraph(""));
      PdfPCell cell2 = new PdfPCell(new Paragraph(""));
      cell1.addElement(nestedTable);
      cell2.addElement(nestedTable);
      table.addCell(cell1);
      table.addCell(cell2);
      table.setWidthPercentage(100);
      return table;

    } catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }

  public PdfPTable gettable(String data[][])
    {
      String[] headers = new String[] {"Code","Amount"};
        try {
            PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(header.toUpperCase()));
                table.addCell(cell);
            }
            table.completeRow();

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    String datum = data[i][j];
                    PdfPCell cell = new PdfPCell();
                    cell.setPhrase(new Phrase(datum.toUpperCase(),new Font(Font.HELVETICA, 10, Font.BOLD)));
                    table.addCell(cell);
                }
                table.completeRow();

            }
            table.setWidthPercentage(100);
            return table;
  }catch(Exception sdfa){}
        return null;
  }
}
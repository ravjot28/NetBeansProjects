import java.io.FileOutputStream;
import java.util.HashMap;

import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PDFManipulation {

public static void main(String[] args) {
try {
	// we create a reader for a certain document
	PdfReader reader = new PdfReader("D:/Resume.pdf");
	int n = reader.getNumberOfPages();
	// we create a stamper that will copy the document to a new file
	PdfStamper stamp = new PdfStamper(reader, new FileOutputStream("D:/myOutPutFile.pdf"));
	// adding some metadata
	HashMap moreInfo = new HashMap();
	moreInfo.put("Author", "Kushal Paudyal");
	stamp.setMoreInfo(moreInfo);
	// adding content to each page
	int i = 0;
	PdfContentByte under;
	PdfContentByte over;

	Image img = Image.getInstance("D:/IMG_0079.jpg");

	BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,
			BaseFont.WINANSI, BaseFont.EMBEDDED);
	img.setAbsolutePosition(400, 400);
	while (i < n) {
		i++;
		// watermark under the existing page
		under = stamp.getUnderContent(i);
		under.addImage(img);
		// text over the existing page
		over = stamp.getOverContent(i);
		over.beginText();
		over.setFontAndSize(bf, 18);
		over.setTextMatrix(30, 30);
		over.showText("page " + i);
		over.setFontAndSize(bf, 26);

		over.showTextAligned(Element.ALIGN_LEFT,
		   "12N00607", 400, 730,0);
		over.endText();

	}
	// adding an extra page
	stamp.insertPage(1, PageSize.A4);
	over = stamp.getOverContent(1);
	over.beginText();
	over.setFontAndSize(bf, 18);
	over.showTextAligned(Element.ALIGN_LEFT,
		"DUPLICATE OF AN EXISTING PDF DOCUMENT", 30, 600, 0);
	over.endText();
	// adding a page from another document
	PdfReader rdr = new PdfReader("D:/HowTo.Base64.pdf");
	under = stamp.getUnderContent(1);
	under.addTemplate(stamp.getImportedPage(rdr, 3), 1, 0, 0, 1, 0,
			0);
	// closing PdfStamper will generate the new PDF file
	stamp.close();
} catch (Exception de) {
	de.printStackTrace();
}
}
}
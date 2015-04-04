import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfRectangle;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;

public class CropPages {

    /** The resulting PDF. */
    public static final String RESULT= "Bin/Certi.pdf";
    public void manipulatePdf(String src, String dest)
        throws IOException, DocumentException
    {
        PdfReader reader = new PdfReader(src);
        int n = reader.getNumberOfPages();
        PdfDictionary pageDict;
        PdfRectangle rect = new PdfRectangle(15, 586, 615, 1000);
        for (int i = 1; i <= n; i++) {
            pageDict = reader.getPageN(i);
            pageDict.put(PdfName.CROPBOX, rect);
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        File f=new File("Bin/Certi.pdf");
        f.delete();
    }
}
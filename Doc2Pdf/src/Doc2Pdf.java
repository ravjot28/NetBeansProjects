import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;


public class Doc2Pdf
{

    public boolean convert(String src,String op)
    {
        String result=null;
        Document output = null;
        String[] a=new String[2];
//        a[0]="C:\\Users\\Rav\\Desktop\\funny tag lines.doc";
        a[0]=src;
        a[1]=op;
        System.out.println("Convert Doc file to pdf");
        System.out.println("input  : " + a[0]);
        System.out.println("output : " + a[1]);
        try
        {
            String rav=new Doc().read(src);
            output = new Document(PageSize.A4, 100, 100, 50, 100);
            PdfWriter.getInstance(output, new FileOutputStream (a[1]));
            output.open();
            output.addAuthor("Ravjot");
            output.addSubject(a[0]);
            output.addTitle(a[0]);
            String line = rav;
                System.out.println(line);
                Paragraph p = new Paragraph(line);
                p.setAlignment(Element.ALIGN_JUSTIFIED);
                output.add(p);
            result="Done.";
            output.close();
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }

}

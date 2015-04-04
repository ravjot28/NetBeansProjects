import java.io.FileInputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Doc
{
    public String read(String fname)
    {
        String filesname =fname; // "C:\\Users\\Rav\\Desktop\\greetn.doc";
                String output="";
		POIFSFileSystem fs = null;
		try
		{
                  fs = new POIFSFileSystem(new FileInputStream(filesname));
                  //Couldn't close the braces at the end as my site did not allow it to close

                  HWPFDocument doc = new HWPFDocument(fs);

		  WordExtractor we = new WordExtractor(doc);

		  String[] paragraphs = we.getParagraphText();

		 // System.out.println( "Word Document has " + paragraphs.length + " paragraphs" );
		  for( int i=0; i<paragraphs .length; i++ )
                  {
			paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n","");
                	//System.out.println( "Length:"+paragraphs[ i ].length());
                        output=output+paragraphs[ i ]+"\n";

		  }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                return output;
    }
}

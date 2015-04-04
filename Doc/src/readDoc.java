import org.apache.poi.poifs.filesystem.*;
import org.apache.poi.hwpf.*;
import org.apache.poi.hwpf.extractor.*;
import java.io.*;

public class readDoc
{
	public static void main( String[] args )
	{
		String filesname = "C:\\Users\\Rav\\Desktop\\greetn.doc";
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
		  for( int i=0; i<paragraphs .length; i++ ) {
			paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n","");
                	//System.out.println( "Length:"+paragraphs[ i ].length());
                        output=output+paragraphs[ i ]+"\n";

		  }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
                 try
                {
                    BufferedWriter b=new BufferedWriter(new FileWriter("C:\\Users\\Rav\\Desktop\\greetn.txt"));
                    b.append(output);
                    b.close();
                }catch(Exception eas){}
                
         }
}
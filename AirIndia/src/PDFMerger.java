import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class PDFMerger {

public PDFMerger() throws IOException,
DocumentException {
String fileOne = new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Basic_Slips.pdf";
String fileTwo = new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Pli_Slips.pdf";
String mergedFileLocation = new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Complete_Pay_Slip.pdf";

String filesTobeMerges[] = new String[] { fileOne, fileTwo };

mergeMyFiles(filesTobeMerges, mergedFileLocation);
}

/**
* Tool that can be used to concatenate
* any number of existing PDF files To One.
*/

public static void mergeMyFiles(String filesToBeMerged[],
String mergedFileLocation) {
try {
int pageOffset = 0;
ArrayList masterBookMarkList = new ArrayList();

int fileIndex = 0;
String outFile = mergedFileLocation;
Document document = null;
PdfCopy writer = null;
PdfReader reader = null;

for (fileIndex = 0; fileIndex < filesToBeMerged.length; fileIndex++) {

/**
* Create a reader for the file that we are reading
*/
reader = new PdfReader(filesToBeMerged[fileIndex]);

/**
* Replace all the local named links with the actual destinations.
*/
reader.consolidateNamedDestinations();

/**
* Retrieve the total number of pages for this document
*/
int totalPages = reader.getNumberOfPages();

/**
* Get the list of bookmarks for the current document
* If the bookmarks are not empty, store the bookmarks
* into a master list
*/
List bookmarks = SimpleBookmark.getBookmark(reader);
if (bookmarks != null) {
if (pageOffset != 0)
SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset,
null);
masterBookMarkList.addAll(bookmarks);
}else
{
}
pageOffset += totalPages;

/**
* Merging the files to the first file.
* If we are passing file1, file2 and file3,
* we will merge file2 and file3 to file1.
*/
if (fileIndex == 0) {
/**
* Create the document object from the reader
*/
document = new Document(reader.getPageSizeWithRotation(1));

/**
* Create a pdf write that listens to this document.
* Any changes to this document will be written the file
*
* outFile is a location where the final merged document
* will be written to.
*/

writer = new PdfCopy(document,
new FileOutputStream(outFile));
/**
* Open this document
*/
document.open();
}
PdfImportedPage page;
for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
page = writer.getImportedPage(reader, currentPage);
writer.addPage(page);
}
PRAcroForm form = reader.getAcroForm();
if (form != null)
{
writer.copyAcroForm(reader);
}else
{}
}
if (!masterBookMarkList.isEmpty())
{
writer.setOutlines(masterBookMarkList);

}else
{

}
document.close();

} catch (Exception e) {
e.printStackTrace();
}
}
}

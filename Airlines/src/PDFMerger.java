import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class PDFMerger {

public PDFMerger() throws IOException,
DocumentException {
String fileOne = new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Salary_Slips.pdf";
String fileTwo = new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/PLI.pdf";
String mergedFileLocation = new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Complete Pay Slip.pdf";

String filesTobeMerges[] = new String[] { fileOne, fileTwo };

mergeMyFiles(filesTobeMerges, mergedFileLocation);
}

/**
* Tool that can be used to concatenate
* any number of existing PDF files To One.
*/

public static void mergeMyFiles(String filesToBeMerged[],
String mergedFileLocation) {

System.out.println("Starting To Merge Files...");
System.out.println("Total Number Of Files To Be Merged..."+filesToBeMerged.length+"\n");
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
System.out.println("Reading File -"+filesToBeMerged[fileIndex]);

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
System.out.println("Checking for bookmarks...");
List bookmarks = SimpleBookmark.getBookmark(reader);
if (bookmarks != null) {
if (pageOffset != 0)
SimpleBookmark.shiftPageNumbers(bookmarks, pageOffset,
null);
masterBookMarkList.addAll(bookmarks);
System.out.println("Bookmarks found and storing...");
}else
{
System.out.println("No bookmarks in this file...");
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

System.out.println("Creating an empty PDF...");
writer = new PdfCopy(document,
new FileOutputStream(outFile));
/**
* Open this document
*/
document.open();
}
/**
* Add the conent of the file into this document (writer).
* Loop through multiple Pages
*/
System.out.println("Merging File: "+filesToBeMerged[fileIndex]);
PdfImportedPage page;
for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
page = writer.getImportedPage(reader, currentPage);
writer.addPage(page);
}

/**
* This will get the documents acroform.
* This will return null if no acroform is part of the document.
*
* Acroforms are PDFs that have been turned into fillable forms.
*/
System.out.println("Checking for Acroforms");
PRAcroForm form = reader.getAcroForm();
if (form != null)
{
writer.copyAcroForm(reader);
System.out.println("Acroforms found and copied");
}else
System.out.println("Acroforms not found for this file");

System.out.println();
}
/**
* After looping through all the files, add the master bookmarklist.
* If individual PDF documents had separate bookmarks, master bookmark
* list will contain a combination of all those bookmarks in the
* merged document.
*/
if (!masterBookMarkList.isEmpty())
{
writer.setOutlines(masterBookMarkList);
System.out.println("All bookmarks combined and added");

}else
{
System.out.println("No bookmarks to add in the new file");

}

/**
* Finally Close the main document, which will trigger the pdfcopy
* to write back to the filesystem.
*/
document.close();

System.out.println("File has been merged and written to-"+mergedFileLocation);
} catch (Exception e) {
e.printStackTrace();
}
}
}

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

public class PDFSplitter {

	public static void main(String[] args) {

		/**
		 * Location of input file which is to be splitted.
		 */
		String fileToSplit = "C:\\Users\\Rav\\Desktop\\R.pdf";

		/**
		 * Page Size of each splitted files
		 *
		 * e.g. 4 pages each in the split.
		 */
		int splittedPageSize = 17;

		/**Call the split method with filename and page size as params**/
		splitPDFFile(fileToSplit, splittedPageSize);

	}

	/**
	 * @param fileName : PDF file that has to be splitted
	 * @param splittedPageSize : Page size of each splitted files
	 */
	public static void splitPDFFile(String fileName, int splittedPageSize) {
		try {
			/**
			 * Read the input PDF file
			 */
			PdfReader reader = new PdfReader(fileName);
			System.out.println("Successfully read input file: " + fileName
					+ "\n");
			int totalPages = reader.getNumberOfPages();
			System.out.println("There are total " + totalPages
					+ " pages in this input file\n");
			int split = 0;

			/**
			 * Note: Page numbers start from 1 to n (not 0 to n-1)
			 */
			for (int pageNum = 1; pageNum <= totalPages; pageNum += splittedPageSize) {
				split++;
				String outFile = fileName
						.substring(0, fileName.indexOf(".pdf"))
						+ "-split-" + split + ".pdf";
				Document document = new Document(reader
						.getPageSizeWithRotation(1));
				PdfCopy writer = new PdfCopy(document, new FileOutputStream(
						outFile));
				document.open();
				/**
				 * Each split might contain one or more pages defined by splittedPageSize
				 *
				 * E.g. We are splitting a 15 pages pdf to 4 page each.
				 * In this example, the last split will have only 3 pages (4+4+4+3 =15)
				 *
				 * Note the following condition that handles the scenario where total
				 * number of pages in the splitted file is less that splittedpageSize
				 *
				 * It will always be the last split.
				 *
				 * splittedPageSize && (pageNum+offset) <=totalPages
				 */
				int tempPageCount = 0;
				for (int offset = 0; offset < splittedPageSize
						&& (pageNum + offset) <= totalPages; offset++) {
					PdfImportedPage page = writer.getImportedPage(reader,
							pageNum + offset);
					writer.addPage(page);
					tempPageCount++;
				}

				document.close();
				/**The following will trigger the PDF file being written to the system**/
				writer.close();

				System.out.println("Split: [" + tempPageCount + " page]: "
						+ outFile);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

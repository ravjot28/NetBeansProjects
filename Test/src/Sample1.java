import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;

// Define a class that is called per page that needs printing. It implements
// the one and only method in the Printable interface : print. Note that
// this is quite separate from the PrinterJob class print() method.
//
// This method does not actually do any printing. All it does is write text
// and/or graphics onto the passed page (graphics context). The calling
// printer job object will then pass this page to the printer.

class PrintObject implements Printable
{
   public int print (Graphics g, PageFormat f, int pageIndex)
   {
      Graphics2D g2 = (Graphics2D) g;  // Allow use of Java 2 graphics on
                                       // the print pages :

      // A rectangle that shows the printable area of the page, allowing
      // for margins all round. To be drawn on the first page (index = 0).
      Rectangle2D rect = new Rectangle2D.Double(f.getImageableX(),
                                                f.getImageableY(),
                                                f.getImageableWidth(),
                                                f.getImageableHeight());

      // A simple circle to go on the second page (index = 1).
      Ellipse2D circle = new Ellipse2D.Double(100,100,100,100);

      switch (pageIndex)
      {
         case 0 : g2.setColor(Color.black);   // Page 1 : print a rectangle
                  g2.draw(rect);
                  return PAGE_EXISTS;
         case 1 : g2.setColor(Color.red);     // Page 2 : print a circle
                  g2.draw(circle);
                  return PAGE_EXISTS;
         default: return NO_SUCH_PAGE;        // No other pages
      }
   }
}

public class Sample1
{
   public static void main (String[] args)
   {
      // Create an object that will hold all print parameters, such as
      // page size, printer resolution. In addition, it manages the print
      // process (job).
      PrinterJob job = PrinterJob.getPrinterJob();

      // It is first called to tell it what object will print each page.
      job.setPrintable(new PrintObject());

      // Then it is called to display the standard print options dialog.
      if (job.printDialog())
      {
         // If the user has pressed OK (printDialog returns true), then go
         // ahead with the printing. This is started by the simple call to
         // the job print() method. When it runs, it calls the page print
         // object for page index 0. Then page index 1, 2, and so on
         // until NO_SUCH_PAGE is returned.
         try { job.print(); }
         catch (PrinterException e) { System.out.println(e); }
      }
   }
}
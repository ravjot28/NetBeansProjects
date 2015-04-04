package ppt;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;
import java.io.*;
import java.awt.*;
import org.apache.poi.hslf.model.Line;
class drawLine{
  public static void main(String a[])
  {
  try
  {   SlideShow slideShow = new SlideShow();
  Slide slide = slideShow.createSlide();
         Line line = new Line();
       line.setAnchor(new java.awt.Rectangle
(50, 50, 600,500));
       line.setLineColor(new Color(0, 128, 0));
       line.setLineStyle(Line.LINE_DOUBLE);
       slide.addShape(line);
   FileOutputStream out = new FileOutputStream
("drawLine.ppt");
        slideShow.write(out);
        out.close();
  }catch(Exception e){}
  }}
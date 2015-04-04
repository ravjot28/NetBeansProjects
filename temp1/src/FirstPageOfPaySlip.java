import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

public class FirstPageOfPaySlip
{
    public final static String suspendedimage="img/suspended.png";
    public final static String retireimage="img/retire.png";
    public final static String logoimage="img/logo.png";
    public final static String expiredimage="img/expired.png";
    public final static String expelledimage="img/expelled.png";
    public final static String signimage="img/sign.png";
    private static Font f1 = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL,Color.BLACK);
    private static Font f2=FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new Color(0, 0,0));
    private static Font f3=FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0,0));
    private static Font f4 = new Font(Font.TIMES_ROMAN, 12, Font.BOLD,Color.BLACK);
    String dob,name,memno,staffno,nom;
    

    public void launch(String no) throws DocumentException, FileNotFoundException, BadElementException, MalformedURLException, IOException
    {
        
    URL suspendedurl=getClass().getClassLoader().getResource(suspendedimage);
    URL retireurl=getClass().getClassLoader().getResource(retireimage);
    URL logourl=getClass().getClassLoader().getResource(logoimage);
    URL expiredurl=getClass().getClassLoader().getResource(expiredimage);
    URL expelledurl=getClass().getClassLoader().getResource(expelledimage);
    URL signurl=getClass().getClassLoader().getResource(signimage);
    System.out.println("URl intialized");
        String fname="Bin/Info/"+no+".ravs";
        try
        {
            BufferedReader b=new BufferedReader(new FileReader(fname));
            dob=new Base64Decoder(new Base64Decoder(new Base64Decoder(new Base64Decoder(b.readLine()).get()).get()).get()).get();
            memno=new Base64Decoder(new Base64Decoder(new Base64Decoder(new Base64Decoder(b.readLine()).get()).get()).get()).get();
            name=new Base64Decoder(new Base64Decoder(new Base64Decoder(new Base64Decoder(b.readLine()).get()).get()).get()).get();
            staffno=new Base64Decoder(new Base64Decoder(new Base64Decoder(new Base64Decoder(b.readLine()).get()).get()).get()).get();
            nom=new Base64Decoder(new Base64Decoder(new Base64Decoder(new Base64Decoder(b.readLine()).get()).get()).get()).get();
        }catch(Exception a){}
        System.out.println(dob+" "+memno+" "+name+" "+staffno+" "+nom);
        String head="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tBenevolent Society For Aircraft Engineers Of Indian Airlines";
        String subhead="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tReg'N No.54832 , Dated 7 Feb , 2006";
        String subhead1="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIGI Airport,Terminal-I , New Delhi PH. (011)-25672740";
        Document document=new Document(PageSize.LEGAL, 20, 10, 10, 20);
        document.addTitle("Pay Slip");
        document.addSubject("Pay Slip");
	document.addKeywords("Java, PDF");
	document.addAuthor("Rav");
	document.addCreator("Rav");
        PdfWriter.getInstance(document,new FileOutputStream("Bin/Certi.pdf"));
        document.open();
        System.out.println("Finished Open");
        document.add(new Paragraph(head,f2));
        System.out.println("Finished head");
        document.add(new Paragraph(subhead,f3));
        System.out.println("Finished subhead");
        document.add(new Paragraph(subhead1,f3));
        System.out.println("Finished subhead1");
        Image logo = Image.getInstance (logourl);
        logo.scalePercent(15f);
          System.out.println("Finished logo");
        logo.setAbsolutePosition(260f, 900f);
        document.add(logo);
        String name1="";
        if(name.contains("1"))
        {
            name1=name.replace("1","");
        }
        else
        if(name.contains("2"))
        {
            name1=name.replace("2","");
        }
        else
        if(name.contains("3"))
        {
            name1=name.replace("3","");
        }
        else
        {
            name1=name;
        }
        staffno=staffno.substring(0,6);
        Paragraph line1=new Paragraph();
        Chunk c=new Chunk("\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIt is certified that Mr/Ms.",f1);
        Chunk c1=new Chunk(name1,f4);
        Chunk c2=new Chunk(" Staff No. ",f1);
        Chunk c3=new Chunk(staffno,f4);
        Chunk c4=new Chunk(",",f1);
        line1.add(c);
        line1.add(c1);
        line1.add(c2);
        line1.add(c3);
        line1.add(c4);
        document.add(line1);
        
        Paragraph line2=new Paragraph();
        Chunk d1=new Chunk("\n\t\t\t\t\t\t\t\tmembership no. ",f1);
        Chunk d2=new Chunk(memno,f4);
        Chunk d3=new Chunk(" is a bonafied member of Benevolent Society for Aircraft Engineers Of Indian Airlines, ",f1);
        line2.add(d1);
        line2.add(d2);
        line2.add(d3);
        document.add(line2);
        System.out.println("Finished lin2");
        document.add(new Paragraph("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tHis/her nominee(s) will be entitled for all the benefits as per by - laws of the society.\n\n",f1));
        StringTokenizer date=new StringTokenizer(dob,"-");
        String dd = null,mm,m = null,yy = null;
        if(date.countTokens()==3)
        {
            dd=date.nextToken();
            mm=date.nextToken();
            m=getmonth(mm);
            yy=date.nextToken();            
        }
        int date1=Integer.parseInt(dd);
        int month1=Integer.parseInt(m);
        int year1=Integer.parseInt(yy.trim());
        int date2=Integer.parseInt(new CalendarDate().name());
        int month2=Integer.parseInt(new CalendarMonth().name());
        int year2=Integer.parseInt(new CalendarYear().name());
        boolean retire=false;
        if((year1+58)<=year2)
        {
            if(month1<=month2)
            {
                if(date1<=date2)
                {
                    retire=true;
                }
            }

        }
        Image image;
        if(retire)
        {
            image = Image.getInstance (retireurl);
            image.scalePercent(30f);
            image.setAbsolutePosition(230f, 750f);
            //image.setAbsolutePosition(500f, 650f);
            document.add(image);
        }
        System.out.println(name);
        if(name.contains("1"))
        {
            System.out.println("In 1");
            image = Image.getInstance (suspendedurl);
            image.scalePercent(30f);
            image.setAbsolutePosition(230f, 750f);
            //image.setAbsolutePosition(500f, 650f);
            document.add(image);
        }
        else
        if(name.contains("2"))
        {
            System.out.println("In 2");
            image = Image.getInstance (expiredurl);
            image.scalePercent(30f);
            image.setAbsolutePosition(230f, 750f);
            //image.setAbsolutePosition(500f, 650f);
            document.add(image);
        }
        else
        if(name.contains("3"))
        {
            System.out.println("In 3");
            image = Image.getInstance (expelledurl);
            image.scalePercent(30f);
            image.setAbsolutePosition(230f, 750f);
            //image.setAbsolutePosition(500f, 650f);
            document.add(image);
        }
        StringTokenizer tt=new StringTokenizer(nom,"/");
        int size=tt.countTokens();
        int aa=1;
        while(tt.hasMoreTokens())
        {
            if(aa==1)
            {
                Paragraph end=new Paragraph();
                Chunk e1=new Chunk("\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNominee  "+aa+". ",f1);
                Chunk e2=new Chunk(tt.nextToken().trim(),f4);
                end.add(e1);
                end.add(e2);
                document.add(end);
            }
            else
            {
                Paragraph end=new Paragraph();
                Chunk e1=new Chunk("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+aa+". ",f1);
                Chunk e2=new Chunk(tt.nextToken().trim(),f4);
                end.add(e1);
                end.add(e2);
                document.add(end);
            }
            aa++;
        }
        if(size==1)
        {
            Image image1 = Image.getInstance (signurl);
            image1.scalePercent(35f);
            image1.setAbsolutePosition(80f, 615f);
            document.add(image1);
            document.close();
        }
        else
        {
            for(int i=0;i<size-1;i++)
            {
                document.add(new Paragraph("\n"));
            }
            Image image1 = Image.getInstance (signurl);
           image1.setAbsolutePosition(80f, 615f);
           image1.scalePercent(35f);
            document.add(image1);
            document.close();
        }
        System.out.println("Finished");
   }

    public String getmonth(String a)
    {
        if(a.contains("Jan"))
        {
            return "1";
        }
        else
        if(a.contains("Feb"))
        {
            return "2";
        }
        else
        if(a.contains("Mar"))
        {
            return "3";
        }
        else
        if(a.contains("Apr"))
        {
            return "4";
        }
        else
        if(a.contains("May"))
        {
            return "5";
        }
        else
        if(a.contains("Jun"))
        {
            return "6";
        }
        else
        if(a.contains("Jul"))
        {
            return "7";
        }
        else
        if(a.contains("Aug"))
        {
            return "8";
        }
        else
        if(a.contains("Sep"))
        {
            return "9";
        }
        else
        if(a.contains("Oct"))
        {
            return "10";
        }
        else
        if(a.contains("Nov"))
        {
            return "11";
        }
        else
        {
            return "12";
        }
    }

}
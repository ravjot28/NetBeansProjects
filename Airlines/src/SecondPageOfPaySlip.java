import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import java.sql.*;
public class SecondPageOfPaySlip
{
    private static Font f1 = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL,Color.BLACK);
    private static Font f2=FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new Color(0, 0,0));
    private static Font f3=FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0,0));
    private static Font redFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL,Color.RED);
    public int d;
    public int tot;
    String rav;
    public void launch(String empid,String r) throws DocumentException, FileNotFoundException, BadElementException,IOException
    {
        rav=r;
        int pli[]=new SecondPageOfPaySlip().getpli(empid,rav);
        d=new SecondPageOfPaySlip().getplidedcution(empid,rav);
        String name=new FirstPageOfPaySlip().getnam(empid,rav);
        String acc=new FirstPageOfPaySlip().getacc(empid,rav);
        String dob=new FirstPageOfPaySlip().getdob(empid,rav);
        String doj=new FirstPageOfPaySlip().getdoj(empid,rav);
        String sex=new FirstPageOfPaySlip().getsex(empid,rav);
        String s;
        tot=(pli[0]+pli[1]+pli[2]+pli[3]+pli[4]);
        String space="";
        int i=name.length();
        if(sex.equalsIgnoreCase("m"))
        {
            sex="MALE";
        }
        else
        {
            sex="FEMALE";
        }
        while(i!=17)
        {
            space=space+"  ";
            i++;
        }
        String head="\n                                             NACIL – NORTHERN REGION";
     String subhead="\n                                                                           PAYSLIP FOR   "+new GetMonthNameExample().name()+"/"+new CalendarExample().name();
        Document document=new Document(PageSize.A4, 20, 10, 10, 20);
        document.addTitle("Pay Slip");
		document.addSubject("Pay Slip");
		document.addKeywords("Java, PDF");
		document.addAuthor("Rav");
		document.addCreator("Rav");
        PdfWriter.getInstance(document,new FileOutputStream(new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/PLI.pdf"));
        document.open();
        Image image = Image.getInstance ("Bin\\img\\airindia1.jpg");
        document.add(image);
        document.add(new Paragraph(head,f2));
        document.add(new Paragraph(subhead,f3));
        document.add(new Paragraph("            EMP NO :"+empid+"                                                                                       INC DT & CD: 112010/2",f1));
        document.add(new Paragraph("            EMP NAME :"+name+"                                                                  PAY SCALE : 16400-20300",f1));
        document.add(new Paragraph("            DESIGNATION: CH A/C ENGR (MNTC)                                             DESG CODE:1305311",f1));
        document.add(new Paragraph("            CESS CODE : 0                                                                                        BANK CODE :110229011",f1));
        document.add(new Paragraph("            SEX : "+sex+"                                                                                            A/C NUMBER"+acc,f1));
        document.add(new Paragraph("\n\n\n---------------------------------------------------------------------------------------------------------------------------------------------",f1));
        document.add(new Paragraph("\n                  EMOLUMENTS                                                                              DEDUCTIONS",f1));
        document.add(new Paragraph("\n         2153     FLYING HRS INC          "+pli[0]+"                                   3151     ADL ITAX PLI/IT          "+d,f1));
        document.add(new Paragraph("        2154     TECH DESP REG             "+pli[1],f1));
        document.add(new Paragraph("        2155     A/C ON MM                      "+pli[2],f1));
        document.add(new Paragraph("        2156     FIXED PROD                    "+pli[3],f1));
        document.add(new Paragraph("        2176     LUFA/UDFLEX                "+pli[4],f1));
        document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n",f1));
        document.add(new Paragraph("        TOTAL IN RUPEES                     "+tot,f1)); //total
        document.add(new Paragraph("                                                                                                                                                                   "+d,f1));//TOTAL DEDUCATION
        document.add(new Paragraph("                                                                                                                          NET AMT                      "+(pli[0]+pli[1]+pli[2]+pli[3]+pli[4]-d),f1));
        document.close();
   }



    public int[] getpli(String empid,String r)
    {
        int all[] = new int[5];
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM pli where EMPID="+empid);
            if(res.next())
            {
                all[0]=Integer.parseInt(res.getString("flyhr"));
                all[1]=Integer.parseInt(res.getString("tech"));
                all[2]=Integer.parseInt(res.getString("acon"));
                all[3]=Integer.parseInt(res.getString("fix"));
                all[4]=Integer.parseInt(res.getString("lufa"));
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
    }
        return all;
    }

     public int getplidedcution(String empid,String r)
    {
        int all = 0 ;
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM plideduction where EMPID="+empid);
            if(res.next())
            {
                all=Integer.parseInt(res.getString("adl"));
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
    }
        return all;
    }

}
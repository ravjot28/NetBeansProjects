import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import java.net.MalformedURLException;
import java.util.StringTokenizer;
public class FirstPageOfPaySlip
{
    String region,stationcode,empid,name;
    String desigcode,csc,inc,inccode,bankcode,acctype;
    String accno,hrent,perk,sex,ccb,hloan,txrecv,txassd;
    String nettxb,elg,hra,totsal,jwn,cesscode,rmtyr;
    String rcptnonint,rcptdate,rcpternint,nrwcode,incdtmnth;
    String nsc,lghl,hndcp,nss,lic,mtto,mtfr;
    int total,totde;
    com.itextpdf.text.pdf.PdfPTable table;
    private static Font f1 = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL,Color.BLACK);
    private static Font f2=FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new Color(0, 0,0));
    private static Font f3=FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0,0));
    private static Font redFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL,Color.RED);
    public void launch(String[] data,String time) throws DocumentException, FileNotFoundException, BadElementException, MalformedURLException, IOException
    {
        String al[]=null;
        String de[]=null;
        getinfo(data[0]);
        if(data.length==2)
        {
            if(data[1].substring(14,15).equalsIgnoreCase("2"))
            {
                de=new String[1];
                de[0]="0";
                al=getallow(data[1]);
            }
            else
            {
                al=new String[1];
                al[0]="0";
                de=getdeduc(data[1]);
            }
        }
        else
        {
            al=getallow(data[1]);
            de=getdeduc(data[2]);
        }
        total=0;
        totde=0;
        if((al.length==1)&&(al[0].equalsIgnoreCase("0")))
        {
                 total=0;
                  for(int j=0;j<de.length;j++)
        {

            totde=totde+Integer.parseInt(de[j].substring(3).trim());
        }
        }
 else
     if((de.length==1)&&(de[0].equalsIgnoreCase("0")))
        {
                 totde=0;
                 for(int i=0;i<al.length;i++)
        {
            total=total+Integer.parseInt(al[i].substring(3).trim());
        }
        }
 else
     {
        for(int i=0;i<al.length;i++)
        {
            total=total+Integer.parseInt(al[i].substring(3).trim());
        }
        for(int j=0;j<de.length;j++)
        {
            totde=totde+Integer.parseInt(de[j].substring(3).trim());
        }
        }
        String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
        String dob=new DOBQuery(empid).search(dir1+"MDB/"+"Emp.mdb");
        String doj=new DOJQuery(empid).search(dir1+"MDB/"+"Emp.mdb");
        String head="\n                                                                 NACIL – "+region;
        String subhead="\n                                                                           PAYSLIP FOR   "+time;
        Document document=new Document(PageSize.A4, 20, 10, 10, 20);
        document.addTitle("Pay Slip");
		document.addSubject("Pay Slip");
		document.addKeywords("Java, PDF");
		document.addAuthor("Rav");
		document.addCreator("Rav");
        PdfWriter.getInstance(document,new FileOutputStream(new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Basic_Slips.pdf"));
        document.open();
        totsal=""+Integer.parseInt(totsal);
        nettxb=""+Integer.parseInt(nettxb);
        txassd=""+Integer.parseInt(txassd);
        txrecv=""+Integer.parseInt(txrecv);
        Image image = Image.getInstance ("Bin\\img\\airindia1.jpg");
        document.add(image);
        document.add(new Paragraph(head,f2));
        document.add(new Paragraph(subhead,f3));
        document.add(new Paragraph("\n      "+name+"                              Emp No: "+empid+"                                                 Desig: "+new desg().getdesg(desigcode),f1));
        document.add(new Paragraph("     "+stationcode+"			                                          PAY SCL: 1600:23000	                                      PAN-No: AABPS8791R",f1));
        document.add(new Paragraph("     DOB: "+dob+"			                            DOJ: "+doj+"		                                               PENSION: 2.5%",f1));
        document.add(new Paragraph("     Bank: "+bankcode+"		                             AC/NO: "+accno+"                      *"+sex+"*",f1));
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------------------",f1));
        document.add(new Paragraph("     ANN SLRY        "+totsal+"                    LIC "+lic+"                                 IFB/FD                                   H/RENT "+hrent,f1));
        document.add(new Paragraph("     TAXABLE         "+nettxb+"                     ULIP                               SOCCC                                   MT FR/TO "+mtfr+" "+mtto,f1));
        document.add(new Paragraph("     PERKS        "+perk+"                                        PPF                                 ELSS                                       HRA-RLF "+hra,f1));
        document.add(new Paragraph("     TAX ASSD         "+txassd+"                       NSC                                NSS/JD "+nss+"                                  H-LOAN "+hloan+"                ",f1));
        document.add(new Paragraph("     TAX RCVD        "+txrecv+"                      NSCINT                          TUT-FEE                                TOT-SAV",f1));
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------------------",f1));
        /*int size;
        if(al.length>de.length)
        {
            size=al.length;
        }
        else
        {
            size=de.length;
        }
        for(int j=0;j<size;j++)
        {
            if(j>de.length)
            {
                document.add(new Paragraph("        "+al[j].trim().replaceAll(" ","     "+getename("2"+al[j].substring(0,3))+"    "),f1));
            }
     else
     if((j<de.length)&&(de.length!=1)&&(!de[0].equalsIgnoreCase("0")))
     {
        if((al.length!=1)&&(!al[0].equalsIgnoreCase("0")))
        {
            document.add(new Paragraph("        "+al[j].trim().replaceAll(" ","     "+getename("2"+al[j].substring(0,3))+"     ")+"                                                        "+de[j].trim().replaceAll(" ","     "+getename("3"+de[j].substring(0,3))+"      "),f1));
        }
 else
        {
            document.add(new Paragraph("                                                                                                                        "+de[j].trim().replaceAll(" ","     "+getename("3"+de[j].substring(0,3))+"      "),f1));
 }
     }
 else
     {
                document.add(new Paragraph("        "+al[j].trim().replaceAll(" ","     "+getename("2"+al[j].substring(0,3))+"     "),f1));
 }
        }*/
        if((al.length==1)&&(al[0].equalsIgnoreCase("0")))
        {
            String info[][]=new String[al.length][2];
            String info1[][]=new String[de.length][2];
            info=null;
            for(int j=0;j<de.length;j++)
            {
                String temp=de[j].trim().replaceAll(" "," "+getename("2"+de[j].substring(0,3))+"*");
                StringTokenizer t=new StringTokenizer(temp,"*");
                info1[j][0]=t.nextToken();
                info1[j][1]=t.nextToken();
            }
            String[] headers = new String[] {"FULL MTH-EMOLUMENTS","DEUCTIONS"};
            PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header.toUpperCase(),new Font(Font.TIMES_ROMAN, 12, Font.BOLD,Color.BLACK)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setGrayFill(0.9f);
                table.addCell(cell);
            }
      table.completeRow();

      PdfPTable nestedTable = gettable(info);
      PdfPTable nestedTable1 = gettable(info1);
      PdfPCell cell1 = new PdfPCell(new Paragraph(""));
      PdfPCell cell2 = new PdfPCell(new Paragraph(""));
      cell1.addElement(nestedTable);
      cell2.addElement(nestedTable1);
      table.addCell(cell1);
      table.addCell(cell2);
      table.setWidthPercentage(95);
      document.add(new Paragraph("\n"));
      document.add(table);
        }
        else
        if((de.length==1)&&(de[0].equalsIgnoreCase("0")))
        {
            String info[][]=new String[al.length][2];
            String info1[][]=new String[de.length][2];
            info1=null;
            for(int i=0;i<al.length;i++)
            {
                String temp=al[i].trim().replaceAll(" "," "+getename("2"+al[i].substring(0,3))+"*");
                StringTokenizer t=new StringTokenizer(temp,"*");
                info[i][0]=t.nextToken();
                info[i][1]=t.nextToken();
            }
            String[] headers = new String[] {"FULL MTH-EMOLUMENTS","DEUCTIONS"};
      PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header.toUpperCase(),new Font(Font.TIMES_ROMAN, 12, Font.BOLD,Color.BLACK)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setGrayFill(0.9f);
                table.addCell(cell);
            }
      table.completeRow();

      PdfPTable nestedTable = gettable(info);
      PdfPTable nestedTable1 = gettable(info1);
      PdfPCell cell1 = new PdfPCell(new Paragraph(""));
      PdfPCell cell2 = new PdfPCell(new Paragraph(""));
      cell1.addElement(nestedTable);
      cell2.addElement(nestedTable1);
      table.addCell(cell1);
      table.addCell(cell2);
      table.setWidthPercentage(100);
      document.add(new Paragraph("\n"));
      document.add(table);
        }
        else
        {
            String info[][]=new String[al.length][2];
            String info1[][]=new String[de.length][2];
            for(int i=0;i<al.length;i++)
            {
                String temp=al[i].trim().replaceAll(" "," "+getename("2"+al[i].substring(0,3))+"*");
                StringTokenizer t=new StringTokenizer(temp,"*");
                info[i][0]=t.nextToken();
                info[i][1]=t.nextToken();
            }
            for(int j=0;j<de.length;j++)
            {
                String temp=de[j].trim().replaceAll(" "," "+getename("2"+de[j].substring(0,3))+"*");
                StringTokenizer t=new StringTokenizer(temp,"*");
                info1[j][0]=t.nextToken();
                info1[j][1]=t.nextToken();
            }
            String[] headers = new String[] {"FULL MTH-EMOLUMENTS","DEUCTIONS"};
      PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase(header.toUpperCase(),new Font(Font.TIMES_ROMAN, 12, Font.BOLD,Color.BLACK)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setGrayFill(0.9f);
                table.addCell(cell);
            }
      table.completeRow();

      PdfPTable nestedTable = gettable(info);
      PdfPTable nestedTable1 = gettable(info1);
      PdfPCell cell1 = new PdfPCell(new Paragraph(""));
      PdfPCell cell2 = new PdfPCell(new Paragraph(""));
      cell1.addElement(nestedTable);
      cell2.addElement(nestedTable1);
      table.addCell(cell1);
      table.addCell(cell2);
      table.setWidthPercentage(100);
      document.add(new Paragraph("\n"));
      document.add(table);
      

            //document.add((Element) table);
        }
        document.add(new Paragraph("\n\n\n\n      TOTALS IN RUPEES                                        "+total,f1));
        document.add(new Paragraph("                                                                                                                                                                             "+totde,f1)); //deduction total
        String result="";
        if((total-totde)<0)
        {
            result=result+"CR "+(total-totde)*-1;
        }
 else
        {
            result=result+(total-totde);
 }
        if((total-totde)<0)
        {
            document.add(new Paragraph("\n                                                                                                                           NET PAY          "+result,f1));
        }
 else
        {
        document.add(new Paragraph("\n                                                                                                                                                     NET PAY          "+result,f1));
        }
        document.add(new Paragraph("\n",f1));
        document.add(new Paragraph("PLEASE CHECK PAN IN CASE OF MISSING OR WRONG \n PAN HIGHER RATE OF TAX WILL BE DEDUCATED AND NO \n CREDIT BE GIVEN BY  ITAX AUTHORITIES.",redFont));
        document.close();
        
        
        
   }

     public PdfPTable gettable(String data[][])
    {
      String[] headers = new String[] {"Salary Code","Amount"};

        try {


            PdfPTable table = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(header,new Font(Font.TIMES_ROMAN, 12, Font.BOLD,Color.BLACK)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            table.completeRow();

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    String datum = data[i][j];
                    PdfPCell cell = new PdfPCell();
                    cell.setPhrase(new Phrase(datum.toUpperCase(),new Font(Font.TIMES_ROMAN, 10, Font.NORMAL,Color.BLACK)));
                    if(j==1)
                    {
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setVerticalAlignment(Element.ALIGN_RIGHT);
                    }
                    else
                    {
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setVerticalAlignment(Element.ALIGN_LEFT);
                    }
                    table.addCell(cell);
                }
                table.completeRow();

            }
            table.setWidthPercentage(100);

            return table;
  }catch(Exception sdfa){}
        return null;
  }

    public String[] getallow(String a)
    {
        String result[];
        total=0;
        String dat=a.substring(15);
        int a1=dat.length()/10;
        int c=0;
        result=new String[a1];
        int p=0;
        for(int i=0;i<a1;i++)
        {
            if((!dat.substring(c, c+1).equalsIgnoreCase(" ")))
            {
                result[p]=(String) dat.subSequence(c, c+10);
                result[p]=result[p].substring(0, 3)+" "+Integer.parseInt(result[p].substring(3, result[p].length()));
                p++;
            }
            c=c+10;
        }
        String r[]=new String[p];
        int rav1=0;
        for(int j=0;j<p;j++)
        {
            if(check(result[j],0))
            {
                r[j]=result[j];
            }
 else
            {
                r[j]="";
                rav1++;
 }
        }
        String rav[]=new String[r.length-rav1];
        int cc=0;
        for(int i=0;i<r.length;i++)
        {
            if(!r[i].equalsIgnoreCase(""))
            {
                rav[cc]=r[i];
                cc++;
            }
        }
        return rav;
    }

    public String[] getdeduc(String b)
    {
        String result[];
        totde=0;
        String dat=b.substring(15);
        int a=dat.length()/10;
        int c=0;
        result=new String[a];
        int p=0;
        for(int i=0;i<a;i++)
        {
            if((!dat.substring(c, c+1).equalsIgnoreCase(" ")))
            {
                result[p]=(String) dat.subSequence(c, c+10);
                result[p]=result[p].substring(0, 3)+" "+Integer.parseInt(result[p].substring(3, result[p].length()));
                p++;
            }
            c=c+10;
        }
        String r[]=new String[p];
        int rav1=0;
        for(int j=0;j<p;j++)
        {
            if(check(result[j],1))
            {
                r[j]=result[j];
            }
            else
            {
                r[j]="";
                rav1++;
            }
        }
        String rav[]=new String[r.length-rav1];
        int cc=0;
        for(int i=0;i<r.length;i++)
        {
            if(!r[i].equalsIgnoreCase(""))
            {
                rav[cc]=r[i];
                cc++;
            }
        }
        return rav;
    }

    public void getinfo(String b)
    {
        String dat=b.substring(18);
        region=""+b.charAt(0);
        stationcode=b.substring(1,5)+"/"+b.substring(5,8);
        empid=b.substring(8,14);
        name=dat.substring(0,20);
        dat=removeSpaces(dat.substring(20));
        desigcode=dat.substring(0,7);
        csc=dat.substring(7,12);
        inc=dat.substring(12,20);
        inccode=dat.substring(20,21);
        bankcode=dat.substring(21,30);
        acctype=dat.substring(30,31);
        accno=dat.substring(31,51);
        hrent=dat.substring(51,57);
        if(hrent.equalsIgnoreCase("000000"))
        {
            hrent="            ";
        }
        mtfr=dat.substring(57,59);
        if(mtfr.equalsIgnoreCase("00"))
        {
            mtfr="";
        }
        mtto=dat.substring(59,61);
           if(mtto.equalsIgnoreCase("00"))
        {
            mtto="";
        }

        lic=dat.substring(61,67);
        if(lic.equalsIgnoreCase("000000"))
        {
            lic="";
        }
        nss=dat.substring(67,73);
        if(nss.equalsIgnoreCase("000000"))
        {
            nss="";
        }
        hndcp=dat.substring(73,79);
        lghl=dat.substring(79,86);
        nsc=dat.substring(86,92);
        if(nsc.equalsIgnoreCase("000000"))
        {
            nsc="";
        }
        incdtmnth=dat.substring(92,96);
        nrwcode=dat.substring(96,97);
        rcpternint=dat.substring(97,104);
        rcptdate=dat.substring(104,108);
        rcptnonint=dat.substring(108,114);
        rmtyr=dat.substring(114,120);
        cesscode=dat.substring(120,121);
        jwn=dat.substring(121,127);
        totsal=dat.substring(127,135);
        hra=dat.substring(135,143);
        if(hra.equalsIgnoreCase("00000000"))
        {
            hra="";
        }
        elg=dat.substring(143,151);
        nettxb=dat.substring(151,159);
        txassd=dat.substring(159,166);
        txrecv=dat.substring(166,173);
        if(txrecv.equalsIgnoreCase("0000000"))
        {
            txrecv="";
        }
        hloan=dat.substring(173,179);
        if(hloan.equalsIgnoreCase("000000"))
        {
            hloan="";
        }
        ccb=dat.substring(179,185);
        sex=dat.substring(185,186);
        if(sex.equalsIgnoreCase("m"))
        {
            sex="MALE";
        }
        else
        {
            sex="FEMALE";
        }
        perk=dat.substring(186,191);
        if(perk.equalsIgnoreCase("00000"))
        {
            perk="";
        }
        
    }

    public String removeSpaces(String s)
    {
        StringTokenizer st = new StringTokenizer(s," ",false);
        String t="";
        while (st.hasMoreElements()) t += st.nextElement();
        return t;
}


    boolean check(String p,int a)
    {
       boolean b=true;
       String a1[]={"148","018","151","152","153","154","155","158","026","053","113","127","146","156","176","085","114","131","143","004","005","041","051","069","075","076","080","082","162","174","035","189","190","191","068","183"};
       String a2[]={"151","152","133","134","178",};
       if(a==0)
       {
           for(int i=0;i<a1.length;i++)
           {
                if(p.startsWith(a1[i]))
                {
                    return false;
                }
           }
       }
       else
       {
            for(int i=0;i<a2.length;i++)
           {
                if(p.startsWith(a2[i]))
                {
                    return false;
                }
           }
       }
       return b;
    }
   
    public String getename(String a)
    {
        String result="";
        try
        {
            BufferedReader bb=new BufferedReader(new FileReader("Bin/Data/alc.txt"));
            String data=bb.readLine();
            while(data!=null)
            {
                if(data.trim().startsWith(a))
                {
                      return (data.trim().substring(5));
                  
                }
                data=bb.readLine();
            }
            bb.close();
        }catch(Exception sdff){}
        return result;
    }

}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import jxl.*;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

public class mine
{
  public static ArrayList<String> getFileContentList(String fileName)
  {

    ArrayList<String> data = new ArrayList<String>();
    BufferedReader input = null;
    try
    {
      input = new BufferedReader(new FileReader(fileName));
      String line = null;
      while((line = input.readLine()) != null)
      {
        if(isIgnore(line))
        {
          continue; //ignoring blank lines and lines starting with #
        }
        data.add(line);
      }
    }
    catch(IOException ex)
    {
      data = new ArrayList<String>();
    }
    finally
    {
      if(null != input)
      {
        try
        {
          input.close();
        }
        catch(Exception e)
        {
          data = new ArrayList<String>();
        }
      }
    }
    return data;
  }

  public static boolean isBlank(String data)
  {
    for(int i = 0;i < data.length();i++)
    {
      if(!Character.isWhitespace(data.charAt(i)))
      {
        return false;
      }
    }
    return true;
  }

  private static boolean isIgnore(String data)
  {
    return (data.startsWith("#") );
  }

  public static void main(String[] args)
  {
        try {
            ArrayList<String> configList = getFileContentList("assignmentfile.log");
            int ind1 = 0;
            int ind2 = 0;
            int plsvps = 0;
            int plsvpe = 0;
            //  try
            //  {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("Sathish_New.xls"));
            WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
            Label label = new Label(0, 1, "NODE");
            Label label1 = new Label(1, 1, "JFMGC1     APZ: 21250    HARDWARE: APG40C/4");
            Label label2 = new Label(0, 3, "Check Name");
            Label label3 = new Label(1, 3, "Status");
            Label label4 = new Label(2, 3, "Observation");
            Label label5 = new Label(3, 3, "Node/Network Impact");
            Label label6 = new Label(4, 3, "Action Recommended");
            Label label7 = new Label(5, 3, "Severity");
            Label label8 = new Label(6, 3, "First Reported");
            Label label9 = new Label(7, 3, "Recipient Update");
            Label label10 = new Label(0, 4, "APG status (active/passive)");
            Label label11 = new Label(0, 5, "APG software level check");
            Label label12 = new Label(0, 6, "Check APG RAID");
            Label label13 = new Label(0, 7, "Processor Load Supervision Data check");
            sheet.addCell(label);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            for (String st : configList) {
                if (st.contains("APG40 One Track AGM")) {
                    ind1 = configList.indexOf(st);
                    break;
                }
            }
            String ab = configList.get(ind1);
            String ab1 = ab.substring(26, 33);
            System.out.println("AGM value is " + ab1);
            Label label14 = new Label(2, 5, ab1);
            sheet.addCell(label14);
            for (String plsvp : configList) {
                if (plsvp.contains("<plsvp;")) {
                    plsvps = configList.indexOf(plsvp);
                    break;
                }
            }
            for (String plsvp : configList) {
                if (plsvp.contains("<sybfp:file;")) {
                    plsvpe = configList.indexOf(plsvp);
                    break;
                }
            }
            Vector<String> plsval = new Vector<String>();
            String plsvpse = null;
            String temp = "";
            for (int pls = plsvps; pls < plsvpe; pls++) {
                plsvpse = configList.get(pls);
                //            Vector<String> plsval = new Vector<String>();
                //plsval.add(plsvpse);
                temp+=plsvpse+"\n";
                Label label15 = new Label(1, 7, "warning");
                sheet.addCell(label15);
                Label label16 = new Label(2, 7, plsvpse.toString()); //unable to print into excel
                sheet.addCell(label16);
            }
            WritableCellFormat cf = new WritableCellFormat();
            cf.setWrap(true);
            Label label16 = new Label(2, 7, temp,cf); //unable to print into excel
                sheet.addCell(label16);
            int raids = 0;
            int raide = 0;
            for (String raidstr : configList) {
                if (raidstr.contains("megarc -ldinfo -a0 -lall")) {
                    raids = configList.indexOf(raidstr);
                    break;
                }
            }
            for (String raidstr : configList) {
                if (raidstr.contains("Exiting with 0")) {
                    raide = configList.indexOf(raidstr);
                    break;
                }
            }
            String raidstr = null;
            for (int raid = raids; raid <= raide; raid++) {
                Vector<String> raidcmp = new Vector<String>();
                raidstr = configList.get(raid);
                raidcmp.add(raidstr);
                System.out.println(raidcmp); // raids output
            }
            int raidind1 = 0;
            for (String raid1 : configList) {
                if (raid1.contains("Logical Drive : 0( Adapter: 0 ):  Status:")) {
                    raidind1 = configList.indexOf(raid1);
                    break;
                }
            }
            String r1 = configList.get(raidind1);
            String raidop1 = null;
            if (r1.endsWith("OPTIMAL")) {
                raidop1 = "Raid 1 is " + r1.substring(43);
                System.out.println(raidop1);
            } else {
                raidop1 = "Raid 1 is " + r1.substring(43);
                System.out.println(raidop1);
            }
            int raidind2 = 0;
            for (String raid2 : configList) {
                if (raid2.contains("Logical Drive : 1( Adapter: 0 ):  Status:")) {
                    raidind2 = configList.indexOf(raid2);
                    break;
                }
            }
            String r2 = configList.get(raidind2);
            String raidop2 = null;
            if (r2.endsWith("OPTIMAL")) {
                raidop2 = "Raid 2 is " + r2.substring(43);
                System.out.println(raidop2);
            } else {
                raidop2 = "Raid 2 is " + r2.substring(43);
                System.out.println(raidop2);
            }
            int raidind3 = 0;
            for (String raid3 : configList) {
                if (raid3.contains("Logical Drive : 2( Adapter: 0 ):  Status:")) {
                    raidind3 = configList.indexOf(raid3);
                    break;
                }
            }
            String r3 = configList.get(raidind3);
            String raidop3 = null;
            if (r3.endsWith("OPTIMAL")) {
                raidop3 = "Raid 3 is " + r3.substring(43);
                System.out.println(raidop3);
            } else {
                raidop3 = "Raid 3 is " + r3.substring(43);
                System.out.println(raidop3);
            }
            if (raidop1.contains("OPTIMAL") && raidop2.contains("OPTIMAL") && raidop3.contains("OPTIMAL")) {
                Label label17 = new Label(1, 6, "OK");
                sheet.addCell(label17);
            } else {
                Label label17 = new Label(1, 6, "warning");
                sheet.addCell(label17);
            }
            int r1p1 = 0;
            int r1p2 = 0;
            for (String phystr1 : configList) {
                if (phystr1.contains("Logical Drive 0 : SpanLevel_0 Disks")) {
                    int tmp = configList.indexOf(phystr1); // R1 P1
                    r1p1 = tmp + 3;
                    r1p2 = r1p1 + 1; // R1 P2
                    break;
                }
            }
            String r1phy1 = configList.get(r1p1);
            String r1phy2 = configList.get(r1p2);
            if (r1phy1.startsWith("0") && r1phy1.endsWith("ONLINE")) {
                String raid1op = "Phy disk of Node A under raid 1  is ONLINE";
                System.out.println(raid1op);
            } else {
                String raid1op = "Phy disk of Node A under raid 1 is " + r1phy1.substring(20);
                System.out.println(raid1op);
            }
            if (r1phy2.startsWith("1") && r1phy2.endsWith("ONLINE")) {
                String raid1op = "Phy disk of Node B under raid 1 is ONLINE";
                System.out.println(raid1op);
            } else {
                String raid1op = "Phy disk of node B under raid 1 is " + r1phy2.substring(20);
                System.out.println(raid1op);
            }
            // of raid 2
            int r2p1 = 0;
            int r2p2 = 0;
            for (String phystr2 : configList) {
                if (phystr2.contains("Logical Drive 1 : SpanLevel_0 Disks")) {
                    int tmp = configList.indexOf(phystr2);
                    r2p1 = tmp + 3;
                    r2p2 = r2p1 + 1;
                    break;
                }
            }
            String r2phy1 = configList.get(r2p1);
            String r2phy2 = configList.get(r2p2);
            if (r2phy1.startsWith("0") && r2phy1.endsWith("ONLINE")) {
                String raid1op = "Phy disk of Node A under raid 2  is ONLINE";
                System.out.println(raid1op);
            } else {
                String raid1op = "Phy disk of Node A under raid 2 is " + r2phy1.substring(20);
                System.out.println(raid1op);
            }
            if (r2phy2.startsWith("1") && r2phy2.endsWith("ONLINE")) {
                String raid1op = "Phy disk of Node B under raid 2 is ONLINE";
                System.out.println(raid1op);
            } else {
                String raid1op = "Phy disk of node B under raid 2 is " + r2phy2.substring(20);
                System.out.println(raid1op);
            }
            // of raid 3
            int r3p1 = 0;
            int r3p2 = 0;
            for (String phystr3 : configList) {
                if (phystr3.contains("Logical Drive 2 : SpanLevel_0 Disks")) {
                    int tmp = configList.indexOf(phystr3);
                    r3p1 = tmp + 3;
                    r3p2 = r3p1 + 1;
                    break;
                }
            }
            String r3phy1 = configList.get(r3p1);
            String r3phy2 = configList.get(r3p2);
            if (r3phy1.startsWith("0") && r3phy1.endsWith("ONLINE")) {
                String raid1op = "Phy disk of node A under raid 3 is ONLINE";
                System.out.println(raid1op);
            } else {
                String raid1op = "Phy disk of node A under raid 3 is " + r3phy1.substring(20);
                System.out.println(raid1op);
            }
            if (r3phy2.startsWith("1") && r3phy2.endsWith("ONLINE")) {
                String raid1op = "Phy disk of Node B under raid 3 is ONLINE";
                System.out.println(raid1op);
            } else {
                String raid1op = "Phy disk of node B under raid 3 is " + r3phy2.substring(20);
                System.out.println(raid1op);
            }
            workbook.write();
            workbook.close();
        } catch (WriteException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

  }

}
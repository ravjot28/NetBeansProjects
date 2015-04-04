import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.util.Calendar;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

import jxl.*;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.*;

public class Apg_new
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
       System.out.println(ex);
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
   for(int i=0; i<data.length();i++)
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

 public static void main(String[] args) throws ParseException
 {
       try {
           ArrayList<String> configList = getFileContentList("MSS_1.log");
           ArrayList<String> apgfile    = getFileContentList("apg.log");
           ArrayList<String> aptfile    = getFileContentList("APT logs.log");

           WritableWorkbook workbook = Workbook.createWorkbook(new File("MSS_1_APG.xls"));
           WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
           sheet.setColumnView(0, 35);
           sheet.setColumnView(2, 30);
           sheet.setColumnView(3, 30);
           sheet.setColumnView(4, 30);
           sheet.setColumnView(5, 30);
           sheet.setColumnView(6, 30);
           sheet.setColumnView(7, 30);

           sheet.mergeCells(0, 0, 8, 0);
           sheet.mergeCells(1, 1, 8, 1);
           sheet.mergeCells(0, 2, 8, 2);


           /*WritableCellFormat wrappedText = new WritableCellFormat();
           wrappedText.setWrap(true);

           WritableCellFormat color_blue = new WritableCellFormat();
           color_blue.setBackground(jxl.format.Colour.BLUE);

           WritableCellFormat color_l_blue = new WritableCellFormat();
           color_l_blue.setBackground(jxl.format.Colour.LIGHT_BLUE);


           WritableCellFormat yellow = new WritableCellFormat();
            yellow.setBackground(jxl.format.Colour.YELLOW);


            WritableCellFormat green = new WritableCellFormat();
            green.setBackground(jxl.format.Colour.LIGHT_GREEN);

            WritableFont bold_0 = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, true);
            WritableCellFormat bold_1 = new WritableCellFormat (bold_0);

            WritableCellFeatures cellFeatures = new WritableCellFeatures();*/

           WritableFont bold_0 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);

           WritableCellFormat bold_1 = new WritableCellFormat (bold_0);
           bold_1.setAlignment(jxl.format.Alignment.CENTRE);
           bold_1.setWrap(true);

           WritableCellFormat color_blue = new WritableCellFormat(bold_0);
           color_blue.setBackground(jxl.format.Colour.BLUE);
           color_blue.setAlignment(jxl.format.Alignment.CENTRE);
           color_blue.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           color_blue.setWrap(true);

           WritableCellFormat node = new WritableCellFormat(bold_0);
           node.setBackground(jxl.format.Colour.BLUE);

           WritableFont ca_b1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
           WritableCellFormat ca_b = new WritableCellFormat(ca_b1);
           ca_b.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           ca_b.setWrap(true);

           WritableCellFormat color_l_blue = new WritableCellFormat();
           color_l_blue.setBackground(jxl.format.Colour.LIGHT_BLUE);
           color_l_blue.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           color_l_blue.setWrap(true);

           WritableFont bold_y = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
           WritableCellFormat yellow = new WritableCellFormat(bold_y);
           yellow.setBackground(jxl.format.Colour.YELLOW);
           yellow.setAlignment(jxl.format.Alignment.CENTRE);
           yellow.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           yellow.setWrap(true);

           WritableFont bold_g = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
           WritableCellFormat green = new WritableCellFormat(bold_g);
           green.setBackground(jxl.format.Colour.LIGHT_GREEN);
           green.setAlignment(jxl.format.Alignment.CENTRE);
           green.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           green.setWrap(true);

           WritableCellFormat va_c = new WritableCellFormat();
           va_c.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           va_c.setWrap(true);

           WritableCellFormat na = new WritableCellFormat();
           na.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
           na.setFont(bold_g);
           na.setWrap(true);



           int apz_ver_val_0 = 0, apz_ver_val_1 = 0;

           for (String st : configList)
           {
               if (st.contains("APZ TYPE"))
               {
                   apz_ver_val_0 = configList.indexOf(st);
                   break;
               }
           }
           apz_ver_val_1 = apz_ver_val_0 + 1;

// for hwver

           int apg_ver=0;
           for (String st : apgfile)
           {
               if (st.contains(">hwver"))
               {
                   apg_ver = apgfile.indexOf(st);
                   apg_ver = apg_ver+3;
                   break;
               }
           }

// for node name

           int node_name_ind=0;
           for (String st : apgfile)
           {
               if (st.contains("<ioexp;"))
               {
                   node_name_ind = apgfile.indexOf(st);
                   node_name_ind = node_name_ind+4;
                   break;
               }
           }
           String node_name[] = apgfile.get(node_name_ind).split(" ");

// prcstate

           int prc=0, prc_state=0, prc_l=0, clus_node=0;
           for (String st : apgfile)
           {
               if (st.contains(">Prcstate -l"))
               {
                   prc = apgfile.indexOf(st);
                   prc_state = prc - 2; // active or passive
                   break;
               }
           }

// cluster node

           for (String st : apgfile)
           {
               if (st.contains(">Cluster node"))
               {
                   clus_node = apgfile.indexOf(st);
                   break;
               }
           }



           if( (apgfile.get(prc_state).equals("active") || apgfile.get(prc_state).equals("passive"))
               && ( apgfile.get(prc+1).endsWith("up and working") && apgfile.get(prc+2).endsWith("up and working"))
               && (apgfile.get(clus_node+5).endsWith("Up") && apgfile.get(clus_node+6).endsWith("Up")) )
           {
               Label apg_status = new Label(1, 4, "OK", green);
               sheet.addCell(apg_status);
           }
           else
           {
               Label apg_status = new Label(1, 4, "Warning", yellow);
               sheet.addCell(apg_status);

               Label apg_status_act = new Label(4, 4, "Follow OPI: AP NOT REDUNDANT");
               sheet.addCell(apg_status_act);

               String apg_state = null;
               String apg_tmp   = "";

               for(int i=prc_state-1; i<=clus_node+6; i++)
               {
                   apg_state = apgfile.get(i);
                   apg_tmp+=apg_state;
               }

               Label apg_status_obs = new Label(2, 4, "");

               WritableCellFeatures apg_comm = new WritableCellFeatures();
               apg_comm.setComment(apg_tmp);
               apg_status_obs.setCellFeatures(apg_comm);
               sheet.addCell(apg_status_obs);
           }

//---
           String apz_ver = configList.get(apz_ver_val_0).substring(34, 37) + configList.get(apz_ver_val_1).substring(35, 37);

           Label prs = new Label(0, 0, "Proactive Support (PRS) Report");
           Label label = new Label(0, 1, "NODE", node);
            Label label1 = new Label(1, 1, node_name[0] + "     APZ: " + apz_ver + "    HARDWARE: " + apgfile.get(apg_ver));
            Label label2 = new Label(0, 3, "Check Name", color_blue);
            Label label3 = new Label(1, 3, "Status", color_blue);
            Label label4 = new Label(2, 3, "Observation", color_blue);
            Label label5 = new Label(3, 3, "Node/Network Impact", color_blue);
            Label label6 = new Label(4, 3, "Action Recommended", color_blue);
            Label label7 = new Label(5, 3, "Severity", color_blue);
            Label label8 = new Label(6, 3, "First Reported", color_blue);
            Label label9 = new Label(7, 3, "Recipient Update", color_blue);

            Label label10 = new Label(0, 4, "APG status (active/passive)", ca_b);
            Label label11 = new Label(0, 5, "APG software level check", ca_b);
            Label clus_res_lab = new Label(0, 6, "Check APG cluster resources", ca_b);
            Label label12 = new Label(0, 7, "Check APG RAID", ca_b);
            Label apg_vol_lab = new Label(0, 8, "Check APG Volumes (name, attributes, and size)", ca_b);
            Label label13 = new Label(0, 9, "Check Number of MML Sessions opened", ca_b);
            Label chk_sys_dsk = new Label(0, 10, "Check System Disk", ca_b);
            Label chk_data_dsk = new Label(0, 11, "Check Data Disk", ca_b);
            Label up_time_l = new Label(0, 12, "Check the Uptime", ca_b);
            Label sts_l = new Label(0, 13, "STS functionality check", ca_b);
            Label rep_l = new Label(0, 14, "File Replication check", ca_b);
            Label adc_l = new Label(0, 15, "Active Directory check", ca_b);
            Label bkc_l = new Label(0, 16, "Check the date of the latest backup", ca_b);

            int row_index = 16;

            Label bsz_l = new Label(0, row_index++, "Check the size of backups", ca_b);
            Label bkv_l = new Label(0, row_index++, "Verify the backup", ca_b);
            Label alan_l = new Label(0, row_index++, "Faults from Audit", ca_b);

            sheet.addCell(prs);
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
           sheet.addCell(clus_res_lab);
           sheet.addCell(apg_vol_lab);
           sheet.addCell(chk_sys_dsk);
           sheet.addCell(chk_data_dsk);
           sheet.addCell(up_time_l);
           sheet.addCell(sts_l);
           sheet.addCell(rep_l);
           sheet.addCell(adc_l);
           sheet.addCell(bkc_l);
           sheet.addCell(bsz_l);
           sheet.addCell(bkv_l);
           sheet.addCell(alan_l);

           int swr_ver=0;
           for (String st : apgfile)
           {
               if (st.contains(">swrprint"))
               {
                   swr_ver = apgfile.indexOf(st);
                   swr_ver = swr_ver+3;
                   break;
               }
           }
           String sw_lev[] = apgfile.get(swr_ver).split(" ");

           if(sw_lev[6].equals("AGM021"))
           {
               Label sw_ver_ok = new Label(1, 5, "OK", green);
                  sheet.addCell(sw_ver_ok);
           }
           else
           {
               Label sw_ver_ok = new Label(1, 5, "Warning", yellow);
                  sheet.addCell(sw_ver_ok);
           }

           Label sw_ver_lab = new Label(2, 5, sw_lev[6], va_c);
              sheet.addCell(sw_ver_lab);

// cluster res

              int clus_cmd=0, clus_start=0;

              for(String st : apgfile)
              {
                  if(st.contains(">CLUSTER RES"))
                  {
                      clus_cmd = apgfile.indexOf(st);
                      clus_start = clus_cmd + 5;
                      break;
                  }
              }

              String header_clus_res = apgfile.get(clus_cmd+3) + "\n" + apgfile.get(clus_cmd+4) + "\n";

              int clus_end=0;

              for(String st : apgfile)
              {
                  if(st.contains(">cluster res |findstr -ive online"))
                  {
                      clus_end = apgfile.indexOf(st);
                      clus_end--;
                      break;
                  }
              }

              String clus_str = null;
              String clus_tmp = "";

              for(int i=clus_start; i<=clus_end; i++)
              {
                  clus_str = apgfile.get(i);

                  if(clus_str.endsWith("Online"))
                  {
                      Label clus_lab = new Label(1, 6, "OK", green);
                      sheet.addCell(clus_lab);
                  }
                  else
                  {
                      {
                      Label clus_lab = new Label(1, 6, "warning", yellow);
                      sheet.addCell(clus_lab);

                      Label clus_act = new Label(4, 6, "Follow OPI : AP PROCESS STOPPED", va_c);
                    sheet.addCell(clus_act);

                      clus_tmp+=clus_str+"\n";
                      }

                  Label clus_obs = new Label(2, 6, "Not all resources are Online", va_c);
                  WritableCellFeatures clus_res = new WritableCellFeatures();
                clus_res.setComment(header_clus_res + clus_tmp);
                clus_obs.setCellFeatures(clus_res);
                sheet.addCell(clus_obs);
                  }
              }

//  raids of APG40C/4

              int raid0_chk=0, raid0=0, raid1=0, raid2=0, raid_end=0;
              for(String st : apgfile)
              {
                  if(st.contains("*******Information Of Logical Drive 0*******"))
                  {
                      raid0_chk = apgfile.indexOf(st);
                      raid0 = raid0_chk + 2;
                      break;
                  }
              }

              for(String st : apgfile)
              {
                  if(st.contains("*******Information Of Logical Drive 1*******"))
                  {
                      raid1 = apgfile.indexOf(st);
                      raid1 = raid1 + 2;
                      break;
                  }
              }

              for(String st : apgfile)
              {
                  if(st.contains("*******Information Of Logical Drive 2*******"))
                  {
                      raid_end = apgfile.indexOf(st);
                      raid2 = raid_end + 2;
                      break;
                  }
              }

             if(apgfile.get(raid0).endsWith("OPTIMAL") && apgfile.get(raid1).endsWith("OPTIMAL") && apgfile.get(raid2).endsWith("OPTIMAL"))
             {
               Label raid = new Label(1, 7, "OK", green);
               sheet.addCell(raid);
             }
             else
             {
               Label raid = new Label(1, 7, "Warning", yellow);
               sheet.addCell(raid);

               Label raid_act = new Label(4, 7, "Follow OPI AP Fault", va_c);
               sheet.addCell(raid_act);

               String raid_err = null;
               String raid_tmp = "";

               for(int i=raid0_chk; i<=raid_end+11; i++)
               {
                   raid_err = apgfile.get(i);
                   raid_tmp+=raid_err + "\n";
               }

               Label raid_obs = new Label(2, 7, "Not all RAID Status is not OPTIMAL", va_c);

               WritableCellFeatures raid_comm = new WritableCellFeatures();
               raid_comm.setComment(raid_tmp);
               raid_obs.setCellFeatures(raid_comm);
               sheet.addCell(raid_obs);

             }

//===== DISKPART> list vol

             int disk_vol=0, disk_cmd=0;
             for(String st : apgfile)
            {
                 if(st.contains("DISKPART> list vol"))
                {
                     disk_cmd = apgfile.indexOf(st);
                     disk_vol = disk_cmd + 4;
                    break;
                }
            }

             String list_vol0 = "  Volume 0     Q   Disk Q       NTFS   Partition   4001 MB  Healthy            ".trim();
             String list_vol1 = "  Volume 1     Y   Disk Y       NTFS   Partition     63 GB  Healthy            ".trim();
             String list_vol2 = "  Volume 2     I   Disk I       NTFS   Partition    204 MB  Healthy            ".trim();
             String list_vol3 = "  Volume 3     E   ntboot       NTFS   Partition     31 MB  Healthy    System  ".trim();
             String list_vol4 = "  Volume 4     C   ntserv       NTFS   Partition     14 GB  Healthy    Boot    ".trim();
             String list_vol5 = "  Volume 5     D   ntbackup     NTFS   Partition     14 GB  Healthy            ".trim();
             String list_vol6 = "  Volume 6     F   ntdump       NTFS   Partition      9 GB  Healthy            ".trim();
             String list_vol7 = "  Volume 7     K   Disk K       NTFS   Partition     10 GB  Healthy            ".trim();
             String list_vol8 = "  Volume 8     L   Disk L       NTFS   Partition     39 GB  Healthy            ".trim();
             String list_vol9 = "  Volume 9     M   Disk M       NTFS   Partition     19 GB  Healthy            ".trim();
             String list_vol10 = "  Volume 10    R   Disk R       NTFS   Partition     20 GB  Healthy            ".trim();
             String list_vol11 = "  Volume 11    S   Disk S       NTFS   Partition     10 GB  Healthy            ".trim();
             String list_vol12 = "  Volume 12    V   Disk V       NTFS   Partition     23 GB  Healthy            ".trim();
             String list_vol13 = "  Volume 13    G   Disk G       NTFS   Partition     15 GB  Healthy           ".trim();

             if( apgfile.get(disk_vol).trim().equals(list_vol0) && apgfile.get(disk_vol+1).trim().equals(list_vol1) &&
                   apgfile.get(disk_vol+2).trim().equals(list_vol2) && apgfile.get(disk_vol+3).trim().equals(list_vol3) &&
                   apgfile.get(disk_vol+4).trim().equals(list_vol4) && apgfile.get(disk_vol+5).trim().equals(list_vol5) &&
                   apgfile.get(disk_vol+6).trim().equals(list_vol6) && apgfile.get(disk_vol+7).trim().equals(list_vol7) &&
                   apgfile.get(disk_vol+8).trim().equals(list_vol8) && apgfile.get(disk_vol+9).trim().equals(list_vol9) &&
                   apgfile.get(disk_vol+10).trim().equals(list_vol10) && apgfile.get(disk_vol+11).trim().equals(list_vol11) &&
                   apgfile.get(disk_vol+12).trim().equals(list_vol12) && apgfile.get(disk_vol+13).trim().equals(list_vol13) )
             {
                 Label disk_ok = new Label(1, 8, "OK", green);
                 sheet.addCell(disk_ok);
             }
             else
             {
                 Label disk_ok = new Label(1, 8, "Warning", yellow);
               sheet.addCell(disk_ok);

               Label disk_act = new Label(4, 8, "Follow OPI AP Fault");
              sheet.addCell(disk_act);

              String list_vol_header = apgfile.get(disk_cmd+2) + "\n" + apgfile.get(disk_cmd+3) + "\n";

              String disk_vol_str = null;
              String disk_vol_tmp = "";

              for(int i=disk_vol; i<=disk_vol+13; i++)
              {
                  disk_vol_str = apgfile.get(i);

                  disk_vol_tmp+=disk_vol_str+"\n";
              }

              Label disk_obs = new Label(2, 8, "APG Volumes not correct", va_c);
                WritableCellFeatures disk_vol_com = new WritableCellFeatures();
                disk_vol_com.setComment(list_vol_header + disk_vol_tmp, 2.1, 15);
                disk_obs.setCellFeatures(disk_vol_com);
                sheet.addCell(disk_obs);

             }

   //---- mml

          int sys_mml=0,sys1_mml=0,sys2_mml=0;
          for (String st : apgfile)
          {
              if (st.contains(">pstat |findstr -i mml"))
              {
                  sys_mml = apgfile.indexOf(st);
                  sys_mml++;
                  break;
              }
          }
          int cpd_lst=0;
          for (String st : apgfile)
          {
              if (st.contains(">cpdlist -a"))
                  {
                  sys1_mml = apgfile.indexOf(st);
                  cpd_lst  = sys1_mml+1;
                  break;
              }
          }

          for (String st : apgfile)
          {
              if (st.contains("wmic VOLUME GET Capacity, DriveLetter, FreeSpace, Label"))
              {
                  sys2_mml = apgfile.indexOf(st);
                  sys2_mml = sys2_mml-2;
                  break;
              }
          }

          int s_mml = sys1_mml-sys_mml;

          String str_mml=null;
          String temp_mml="";

          if (s_mml<11)
          {
              Label mml_lab = new Label(1, 9, "OK", green);
              sheet.addCell(mml_lab);
          }
          else
          {
                  Label mml_lab = new Label(1, 9, "Warning", yellow);
                  sheet.addCell(mml_lab);

                  Label mml_act = new Label(4, 9, "Follow OPI AP Fault", va_c);
                  sheet.addCell(mml_act);

                  for (int i=cpd_lst; i<=sys2_mml; i++)
                  {
                      str_mml=apgfile.get(i);
                      temp_mml+=str_mml+ "\n";
                  }

                  Label mml_lab1 = new Label(2, 9, "Too many mml sessions", va_c);
                  WritableCellFeatures mml_comm = new WritableCellFeatures();
                  mml_comm.setComment(temp_mml, 2.15, 4);
                  mml_lab1.setCellFeatures(mml_comm);
                  sheet.addCell(mml_lab1);
          }


//====

   // wmic VOLUME GET Capacity, DriveLetter, FreeSpace, Label

     // sys disk

          int fs_start=0;
          for (String st : apgfile)
          {
              if (st.contains("wmic VOLUME GET Capacity, DriveLetter, FreeSpace, Label"))
              {
                  fs_start = apgfile.indexOf(st);
                  fs_start = fs_start+3; // start for sys disk
                  break;
              }
          }

          int fs_end=0;
          int up_time=0;

          for (String st : apgfile)
          {
                  if (st.contains(">systeminfo"))
                  {
                      fs_end = apgfile.indexOf(st);
                      fs_end = fs_end-5; // end for data disk
                      up_time = apgfile.indexOf(st);
                      up_time= up_time+12;
                      break;
                  }
          }

          for(int i=fs_start; i<=fs_start+6; i=i+2)
          {
              String fs_start_tab[] = apgfile.get(i).split("           "); // tab

              String fs_word1[] = fs_start_tab[0].split(" ");
              float fs_val1 = Float.parseFloat(fs_word1[0]);

              String fs_word3[] = fs_start_tab[1].split(" ");
              float fs_val3 = Float.parseFloat(fs_word3[0]);

              float fs_div = (fs_val3/fs_val1)*100;

              if(fs_div >= 20)
              {
                  Label sys_dsk_lab = new Label(1, 10, "OK", green);
                  sheet.addCell(sys_dsk_lab);
              }
              else
              {
                  Label sys_dsk_lab = new Label(1, 10, "Warning", yellow);
                  sheet.addCell(sys_dsk_lab);

                  Label sys_dsk_act = new Label(4, 10, "Follow OPI AP SYSTEM ANALYSIS", va_c);
                  sheet.addCell(sys_dsk_act);

                  String fs_sys_err = null;
                  String fs_sys_tmp   = "";
                  String fs_sys_header = "Capacity     DriveLetter  FreeSpace    Label" + "\n";
                  {
                      fs_sys_err = apgfile.get(i);
                      fs_sys_tmp+=fs_sys_err;
                  }

                  Label sys_dsk_lab_1 = new Label(2, 10, "Free space is Less", va_c);
                  WritableCellFeatures sys_fs_comm = new WritableCellFeatures();
                  sys_fs_comm.setComment(fs_sys_header + fs_sys_tmp);
                  sys_dsk_lab_1.setCellFeatures(sys_fs_comm);
                  sheet.addCell(sys_dsk_lab_1);
              }
          }

//----

   // data disk

//          String dd_tmp_1 = null;
//          String dd_tmp_2 = "";

          for(int i=fs_start+8; i<=fs_end; i=i+2)
          {
              String ds_start_tab[] = apgfile.get(i).split("           "); // tab

              String ds_word1[] = ds_start_tab[0].split(" ");
              float ds_val1 = Float.parseFloat(ds_word1[0]);

              String ds_word3[] = ds_start_tab[1].split(" ");
              float ds_val3 = Float.parseFloat(ds_word3[0]);

              float ds_div = (ds_val3/ds_val1)*100;

              if( (ds_div >= 20)  && apgfile.get(raid0).endsWith("OPTIMAL") && apgfile.get(raid1).endsWith("OPTIMAL") && apgfile.get(raid2).endsWith("OPTIMAL"))
                 {
                  Label ds_dsk_lab = new Label(1, 11, "OK", green);
                  sheet.addCell(ds_dsk_lab);
                 }
              else
              {
                  Label ds_dsk_act = new Label(4, 11, "Follow OPI AP SYSTEM ANALYSIS", va_c);
                  sheet.addCell(ds_dsk_act);

                  String ds_sys_err = null;
                  String ds_sys_tmp   = "";
                  String ds_sys_header = "Capacity     DriveLetter  FreeSpace    Label" + "\n";
                  {
                      ds_sys_err = apgfile.get(i);
                      ds_sys_tmp+=ds_sys_err;
                  }

                  Label ds_dsk_lab = new Label(1, 11, "Warning", yellow);
                  sheet.addCell(ds_dsk_lab);

                  Label ds_dsk_lab_1 = new Label(2, 11, "Free space is Less", va_c);
                  WritableCellFeatures ds_fs_comm = new WritableCellFeatures();
                  ds_fs_comm.setComment(ds_sys_header + ds_sys_tmp);
                  ds_dsk_lab_1.setCellFeatures(ds_fs_comm);
                  sheet.addCell(ds_dsk_lab_1);
              }
          }


//          System.out.println(dd_tmp_2);

//              float dd_tmp_2_f = Float.parseFloat(dd_tmp_2);
//              System.out.println(dd_tmp_2_f);

//          if()



//-----
   // system up

          String up_str = apgfile.get(up_time);

          if(up_str.contains("Days"))
          {
              String up_time_chk[] = up_str.split("            ");
              String up_date_chk[] = up_time_chk[1].split(" ");
              int date_cmp = Integer.parseInt(up_date_chk[0]);

              if(date_cmp < 90)
              {
                  Label lab_up = new Label(1, 12, "OK", green);
                  sheet.addCell(lab_up);
              }
              else
              {
                  Label lab_up = new Label(1, 12, "Warning", yellow);
                  sheet.addCell(lab_up);

                  Label lab_up1 = new Label(2, 12, "System uptime should be less than 90 days", va_c);

                  WritableCellFeatures up_tm_cmt = new WritableCellFeatures();
                  up_tm_cmt.setComment(up_str);
                  lab_up1.setCellFeatures(up_tm_cmt);
                  sheet.addCell(lab_up1);

                  Label lab_up_act = new Label(4, 12, "Follow OPI AP REBOOT", va_c);
                  sheet.addCell(lab_up_act);
              }
          }
          else
          {
              Label lab_up = new Label(1, 12, "OK", green);
              sheet.addCell(lab_up);
          }

//=====
    // STS

          int stmmp_start=0, stmmp_end=0;
          for (String st : apgfile)
          {
              if (st.contains("stmmp -lL"))
              {
                  stmmp_start = apgfile.indexOf(st);
                  stmmp_start = stmmp_start+4; // chk for 1st ASN
                  break;
              }
          }


          int stmrp_start=0;
          for (String st : apgfile)
          {
              if (st.contains("stmrp -lL"))
              {
                  stmrp_start = apgfile.indexOf(st);
                  stmmp_end = stmrp_start-3;
                  break;
              }
          }

          String stmmp_run = null;
          String stmmp_err = "";

//          System.out.println(stmmp_start);
//          System.out.println(stmmp_end);

//          for(int i=stmmp_start; i<=)



          for(int i=stmmp_start; i<=stmmp_end; i=i+7)
          {
              stmmp_run = apgfile.get(i);
              if(stmmp_run.contains("running"))
              {

              }
              else
              {
                  String stmrp_err_s = null;
                  String stmrp_err_e = "";
                  for(int j=stmmp_start-3; j<=stmmp_start+2; j++)
                  {
                      stmrp_err_s = apgfile.get(j);
                      stmrp_err_e+=stmrp_err_s + "\n";


                  }
//                  System.out.println(stmrp_err_e);
//                  break;
              }
//              stmmp_start=stmmp_start+7;
//              System.out.println(stmmp_start);
          }


//=====
    // replication

          int callbackm=0;
       for (String st : apgfile)
       {
           if (st.contains("CALLBACK MESSAGE: SyncAll Finished."))
           {
               callbackm = apgfile.indexOf(st);
               callbackm= callbackm+2;
               break;
           }
       }
       String call_back  = apgfile.get(callbackm);

       int comment_rep=0;
       for (String st : apgfile)
       {
           if (st.contains("Beginning data collection for replication summary, this may take awhile:"))
           {
               comment_rep = apgfile.indexOf(st);
               comment_rep= comment_rep+8;
               break;
           }
       }
       String call_back3 = apgfile.get(comment_rep) + apgfile.get(comment_rep+2) + apgfile.get(comment_rep+4);

       String compare1   = "SyncAll terminated with no errors.";

       if (call_back.equals(compare1))
       {
           Label sw_call_lab5 = new Label(1, 14, "OK", green);
           sheet.addCell(sw_call_lab5);
       }
       else
       {
           Label sw_call_lab5 = new Label(1, 14, "Warning", yellow);
           sheet.addCell(sw_call_lab5);

           Label rep_act = new Label(4, 14, "Follow OPI AP, System Restore, Initiate with good AP backup.", va_c);
           sheet.addCell(rep_act);

           Label sw_veri_lab10 = new Label(2, 14, "replication Error", va_c);

           WritableCellFeatures replica_comm = new WritableCellFeatures();
           replica_comm.setComment(call_back3);
           sw_call_lab5.setCellFeatures(replica_comm);
           sheet.addCell(sw_veri_lab10);
       }


//=====
    // burverify

          int veri_b=0, new_bk_date=0;
       for (String st : apgfile)
       {
           if (st.contains("burverify -d"))
           {
               new_bk_date = apgfile.indexOf(st);
               new_bk_date = new_bk_date - 4;
               veri_b = apgfile.indexOf(st);
               veri_b = veri_b+2;
               break;
           }
       }

       String bac_ver = apgfile.get(veri_b);
       String lastWord = bac_ver.substring(bac_ver.lastIndexOf(" ")+1);

       if(lastWord.equals("OK."))
       {
           Label sw_veri_lab = new Label(1, 17, "OK", green);
           sheet.addCell(sw_veri_lab);
       }
       else
       {
           Label sw_veri_lab = new Label(1, 17, "Warning", yellow);
           sheet.addCell(sw_veri_lab);

           Label sw_veri_lab1 = new Label(2, 17, apgfile.get(veri_b), va_c);
           sheet.addCell(sw_veri_lab1);
       }

//-----
   // latest backup date

//        String back_up_date_str    = apgfile.get(new_bk_date);
//        System.out.println(back_up_date_str);

//        String back_up_date_str1[] = back_up_date_str.split("  ");

//        System.out.println(back_up_date_str1[0]);
//        System.out.println(back_up_date_str1[1]);

//        String dateString = "10/02/2012";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date convertedDate = dateFormat.parse(dateString);

//        System.out.println(convertedDate);


//--
     /*  Calendar currentDate = Calendar.getInstance();
       SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
       String dateString = formatter.format(currentDate.getTime());
        String back_up_date_str = apgfile.get(new_bk_date);
        System.out.println(back_up_date_str);

        String back_up_date_str1[] = back_up_date_str.split("  ");

        System.out.println(back_up_date_str1[0]);
        System.out.println(back_up_date_str1[1]);
        System.out.println(back_up_date_str1[3]);
        String bac_u=back_up_date_str1[3];
        String back_up_date_str0[] = bac_u.split(" ");
        System.out.println(back_up_date_str0[1]);
        int newOne = Integer.parseInt(back_up_date_str0[1].replaceAll(",",""));
        newOne=newOne/1024;
        newOne=newOne/1024;
        newOne=newOne/1024;
        System.out.println(newOne);
        String date1= back_up_date_str1[0];
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date obj1 = dateFormat.parse(dateString);
        Date obj2 = dateFormat.parse(date1);
        long diff = obj1.getTime() - obj2.getTime();
        int diffDays =  (int) (diff / (24* 1000 * 60 * 60));
        Label date_cell = new Label(1, 16, "OK", green);
        sheet.addCell(date_cell);
        if(diffDays<30)
           {
//               Label date_cell = new Label(1, 16, "OK", green);
//               sheet.addCell(date_cell);
           }
           else
           {
//               Label date_cell = new Label(1, 16, "Warning", yellow);
//               sheet.addCell(date_cell);
//
//               Label date1_cell = new Label(2, 16, "Backup is " + diffDays +" days older");
//               sheet.addCell(date1_cell);
           }*/

//--
/*

        // latest backup

          int ind_SDD=0;
           for (String st : configList)
        {
            if (st.contains("SDD"))
            {
                ind_SDD = configList.indexOf(st);
                break;
            }
        }

              Label label14 = new Label(2, 5, ab1);
              sheet.addCell(label14);

           for (String plsvp : configList)
           {
               if (plsvp.contains("<plsvp;"))
               {
                   plsvps = configList.indexOf(plsvp);
                   break;
               }
           }

              String str_SDD0 = configList.get(ind_SDD);

              String str_SDD = "20" + str_SDD0.substring(17, 19) + "-" + str_SDD0.substring(19, 21) + "-" + str_SDD0.substring(21, 23);

               System.out.println("backup date is " + str_SDD);

               WritableCellFormat cf4 = new WritableCellFormat();
             cf4.setBackground(jxl.format.Colour.LIGHT_GREEN);
             cf4.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.DOUBLE);

            Label label_SDD = new Label(0, 8, "latest backup date");
            sheet.addCell(label_SDD);

            Label label_SDD_col0 = new Label(1, 8, "OK", cf4);
            sheet.addCell(label_SDD_col0);

            Label label_SDD_op = new Label(2, 8, str_SDD);
            sheet.addCell(label_SDD_op);


           for (String plsvp : configList)
           {
               if (plsvp.contains("<sybfp:file;"))
               {
                   plsvpe = configList.indexOf(plsvp);
                   break;
               }
           }

           String plsvpse = null;
           String temp = "";

           for (int pls = plsvps; pls < plsvpe; pls++)
           {
               plsvpse = configList.get(pls);
               temp+=plsvpse+"\n";

               Label label15 = new Label(1, 7, "warning", cf3);
               sheet.addCell(label15);
               Label label16 = new Label(2, 7, plsvpse.toString());
               sheet.addCell(label16);
           }

           WritableCellFormat wrappedText = new WritableCellFormat();
           wrappedText.setWrap(true);

           Label label16 = new Label(2, 7, temp,wrappedText);
           sheet.addCell(label16);

           */


              Label label14 = new Label(0, 39, "APZ HW/SW status", ca_b);
           sheet.addCell(label14);

           Label label15 = new Label(0, 41, "Software Recovery Information analysis", ca_b);
           sheet.addCell(label15);


           int syrip_start=0, syrip_end=0;

           for (String st : configList)
           {
               if (st.contains("EVENT CODE   INF1   INF2   INF3   INF4   SIDE STATE  DATE   TIME ACTIVE"))
               {
                   syrip_start = configList.indexOf(st);
                   syrip_start++; // down portion 1st line
                   break;
               }
           }

           for (String st : configList)
           {
               if (st.contains("<dircp;"))
               {
                   syrip_end = configList.indexOf(st);
                   syrip_end = syrip_end - 7; // down portion last line
                   break;
               }
           }

           int syrip_cmp_abv=0;

           for (String st : configList)
           {
               if (st.contains("EVENT TYPE          EXPLANATION                         EVENTCNT  FRDEL"))
               {
                   syrip_cmp_abv = configList.indexOf(st);
                   syrip_cmp_abv++; // up portion 1st line
                   break;
               }
           }

           int syrip_cmp_ind = syrip_start-3; // up portion last line

           for(int i=syrip_start; i<=syrip_end; i++ ) // i=down portion 1st line, i<=down portion last line
           {
               String syrip_str = configList.get(i); // down portion values

//               System.out.println(syrip_str);

               if(syrip_str.endsWith("NO"))
               {
                   Label label16 = new Label(1, 41, "OK", green);
                   sheet.addCell(label16);
               }
               else
               {
                   String a = syrip_str.substring(3, 6); // event number for which is yes

//                   System.out.println(a); //ok

//                   System.out.println(syrip_cmp_abv + " " + syrip_cmp_ind);

                   for(int j=syrip_cmp_abv; j<=syrip_cmp_ind; j++) // j=up portion 1st line; j<=up last
                   {
                       String syrip_str_cmp = configList.get(j); // up portion all values

//                       System.out.println("up" + syrip_str_cmp);

                       String b = syrip_str_cmp.substring(3, 6);

//                       System.out.println(b);

                       if(a.equals(b))
                       {
                           String c = syrip_str_cmp.substring(0);
//                           System.out.println(c); // entire line of above if it matches

                           Label label16 = new Label(1, 41, "warning", yellow);
                           sheet.addCell(label16);

                           Label label17 = new Label(2, 41, "Active events present", va_c);

                           WritableCellFeatures cellFeatures_act = new WritableCellFeatures();
                           cellFeatures_act.setComment(c);
                           label17.setCellFeatures(cellFeatures_act);
                           sheet.addCell(label17);
                       }
                       else
                       {}
                   }
                   Label label16 = new Label(1, 41, "warning", va_c);
                   sheet.addCell(label16);
               }
           }


 //============ chk
/*           String syrip_str = null;
           String tmp = "";
           String tmp_0 = "";

           for(int i=syrip_start; i<=syrip_end; i++ ) // i=down portion 1st line, i<=down portion last line
           {
               syrip_str = configList.get(i); // down portion values
//               tmp+=syrip_str+"\n";
               tmp = syrip_str.substring(3, 6); // event number for which is yes
               tmp+="\n";
//               tmp_0+=a+"\n";
           }

           String syrip_str_cmp = null;
           String tmp_1 = "";
           String str_2 = "";

           for(int j=syrip_cmp_abv; j<=syrip_cmp_ind; j++) // j=up portion 1st line; j<=up last
           {
               syrip_str_cmp = configList.get(j); // up portion all values
               str_2 = syrip_str_cmp + "\n";
               tmp_1 = syrip_str_cmp.substring(3, 6);
               tmp_1+="\n";
//               tmp_1+=a+"\n";
           }

               if(syrip_str.endsWith("NO"))
               {
                   Label label16 = new Label(1, 41, "OK", green);
                   sheet.addCell(label16);
               }
               else
               {


                   for(int j=syrip_cmp_abv; j<=syrip_cmp_ind; j++) // j=up portion 1st line; j<=up last
                   {
                       String syrip_str_cmp = configList.get(j); // up portion all values

//                       System.out.println("up" + syrip_str_cmp);

                       String b = syrip_str_cmp.substring(3, 6);

//                       System.out.println(b);

                       if(a.equals(b))
                       {
                           String c = syrip_str_cmp.substring(0);
//                           System.out.println(c); // entire line of above if it matches

                           Label label16 = new Label(1, 41, "warning", yellow);
                           sheet.addCell(label16);

                           Label label17 = new Label(2, 41, "Active events present");

                           cellFeatures.setComment(c);
                           label17.setCellFeatures(cellFeatures);
                           sheet.addCell(label17);
                       }
                       else
                       {}
                   }
                   Label label16 = new Label(1, 41, "warning");
                   sheet.addCell(label16);
               }
           }*/



//=========

     // CP event record analysis

           int cp_event=0;
           for (String st : configList)
           {
               if (st.contains("NO  DATE   TIME ETYPE ACT REP BNR    CODE INF1   INF2   DINO"))
               {
                   cp_event = configList.indexOf(st);
                   cp_event++; // index of 1st line
                   break;
               }
           }

//           String cp_ev = configList.get(cp_event); // 1st line
//           System.out.println("cp_ev" + cp_ev); // ok

//           String cp_date_0 = cp_ev.substring(3, 10); // date of 1st line (ie.) current date
//           System.out.println("cp date0 is " + cp_date_0);
//           int cp_date_new = Integer.parseInt(cp_date_0);

        /*   System.out.println("new val is " + cp_date_new--);


           int cp_date_old_1 = cp_date_new-1; // getting old dates
           String cp_date_1 = Integer.toString(cp_date_old_1); // date 1 day before
           System.out.println("cp date1 is " + cp_date_1);

           int cp_date_old_2 = cp_date_new-2; // getting old dates
           String cp_date_2 = Integer.toString(cp_date_old_2); // date 2 days before
           System.out.println("cp date2 is " + cp_date_2);

           int cp_date_old_3 = cp_date_new-3; // getting old dates
           String cp_date_3 = Integer.toString(cp_date_old_3); // date 3 days before
           System.out.println("cp date3 is " + cp_date_3);

           int cp_date_cmp=0;
           for (String st : configList)
           {
               if (st.contains(cp_date_1))
               {
                   cp_date_cmp = configList.indexOf(st); // index of old date
                   break;
               }
           }

           int rp_event=0;
           for (String st : configList)
           {
               if (st.contains("<dirrp:rp=all;"))
               {
                   rp_event = configList.indexOf(st);
                   break;
               }
           }

           for(int i=cp_event; i<rp_event; i++)
           {
               String dircp = configList.get(i);

               if(dircp.contains(cp_date_0)){}
           }
  */
           Label cp_label = new Label(0, 42, "CP Event Record analysis", ca_b);
           sheet.addCell(cp_label);

//==== syfdp

           Label label17 = new Label(0, 44, "Forlopp Handling check", ca_b);
           sheet.addCell(label17);

           int syfdp_1=0, syfdp_2=0, syfdp_3=0;
           int rp_end = 0;

           for (String st : configList)
           {
               if (st.contains("<syfdp;"))
               {
                   rp_end = configList.indexOf(st);
                   rp_end--;

                   syfdp_1 = configList.indexOf(st);
                   syfdp_1 = syfdp_1 + 4; // SUPERVISION OF LONG DURATION FOR ACTIVE FORLOPPS
                   syfdp_2 = syfdp_1 + 9; // CONTINUOUS SUPERVISION
                   syfdp_3 = syfdp_1 + 15;
                   break;
               }
           }
//-------

   // <dirrp:rp=all;
         // ER WORKING
           ArrayList<String> list = new ArrayList<String>();
           try{
               BufferedReader b = new BufferedReader(new FileReader("MSS_mine.log"));
               String data = b.readLine();
               while(data!=null){
                   if(!data.trim().equals("")){
                       list.add(data);
                   }
                   data = b.readLine();
               }
           }catch(Exception e){
               e.printStackTrace();
           }
           int counter = 0;
           int counter1 = 0;
           for(String p:list){
               if(p.trim().equals("RP    TYPE      INTERFACE")){
                   for(int i = counter;i<list.size();i++){
                       if(list.get(i).trim().equals("END")){
                           counter1 = i;
                           break;
                       }
                   }
                   break;
               }
               counter++;
           }
           String rav="";
           for(int i=counter;i<counter1;i++){
               if(list.get(i).trim().equals("RP    TYPE      INTERFACE")){
                   rav+=",";
               }else{
                    if(!list.get(i).trim().equals(""))
                   rav+=list.get(i)+"$";
               }
           }

           StringTokenizer s = new StringTokenizer(rav,",");
           while(s.hasMoreElements()){
               StringTokenizer s1 = new StringTokenizer(s.nextElement().toString(),"$");
               String temp1 = s1.nextToken();
               while(s1.hasMoreElements()){
                   String temp = s1.nextElement().toString();
                   if(temp.contains("ERWORKING")){
                       System.out.println(temp1+":"+temp);
                   }
               }
           }
           /*StringTokenizer s = new StringTokenizer(rav,"RP    TYPE      INTERFACE");
           while(s.hasMoreElements()){
               System.out.println(s.nextElement());
           }*/

                /* int rp_start=0;
                 for (String st : configList)
                 {
                     if (st.contains("EVENT DATE   TIME    REASON     ETYPE  INF1    INF2"))
                     {
                         rp_start = configList.indexOf(st);
                         rp_start++;
                         break;
                     }
                 }

                 String rp_val_str = null;
                 String rp_val_tmp = "";
                 for(int i=rp_start; i<=rp_end; i++)
                 {
                     if(configList.get(i).contains("ERWORKING"))
                     {
                         rp_val_str = configList.get(i);

                     }
                     else
                     {

                     }
                 }*/


                 Label rp_label = new Label(0, 43, "RP Event Record analysis", ca_b);
                 sheet.addCell(rp_label);

                 Label rp_label_1 = new Label(1, 43, "OK/Cancel", green);
                 sheet.addCell(rp_label_1);

                 Label rp_label_2 = new Label(2, 43, "RP Event Record analysis", va_c);

                 WritableCellFeatures cellFeatures_rp = new WritableCellFeatures();
                 cellFeatures_rp.setComment(" ");
                 rp_label_2.setCellFeatures(cellFeatures_rp);
                 sheet.addCell(rp_label_2);




//=======   syfsp

           int syfsp_1=0, syfsp_2=0, syfsp_3=0, syfsp_4=0;

           for (String st : configList)
           {
               if (st.contains("<syfsp;"))
               {
                   syfsp_1 = configList.indexOf(st);
                   syfsp_1 = syfsp_1 + 4;  // FORLOPP HANDLING
                   syfsp_2 = syfsp_1 + 7;  // FORLOPP EXECUTION CONTROL FUNCTION (ECF)
                   syfsp_3 = syfsp_1 + 10; // FORLOPP ERROR FUNCTION (FLERROR)
                   syfsp_4 = syfsp_1 + 13; // FORLOPP MODE   SUBMODE        LIMIT
                   break;
               }
           }

           if(configList.get(syfdp_1).equals("PASSIVE") && configList.get(syfdp_2).equals("ACTIVE") && configList.get(syfdp_3).equals("PASSIVE")
                   && configList.get(syfsp_1).equals("ACTIVE") && configList.get(syfsp_2).equals("OFF") && configList.get(syfsp_3).equals("ON")
                   && configList.get(syfsp_4).equals("OPERATION      REDUCED LOAD   NO LIMIT"))
           {
               Label label18 = new Label(1, 44, "OK", green);
               sheet.addCell(label18);
           }
           else
           {
               Label label18 = new Label(1, 44, "warning", yellow);
               sheet.addCell(label18);
           }

//==========

           int syrap_cmp=0, syrap_0=0, syrap_1=0, syrap_2=0, syrap_3=0, syrap_4=0;

           for (String st : configList)
           {
               if (st.contains("<syrap;"))
               {
                   syrap_1 = configList.indexOf(st);

                   syrap_cmp = syrap_1 + 1;

                   syrap_0 = syrap_1 + 4;  // FORLOPP RELEASE
                   syrap_2 = syrap_1 + 7;  // SELECTIVE RESTART
                   syrap_3 = syrap_1 + 10; // SELECTIVE RESTART TYPE
                   syrap_4 = syrap_1 + 13; // SIGNALLING ERRORS
                   break;
               }
           }
           Label syrap_lab = new Label(0, 45, "System Recovery Setting check", ca_b);
           sheet.addCell(syrap_lab);

           if(configList.get(syrap_0).equals("ACTIVE") && configList.get(syrap_2).equals("ACTIVE") && configList.get(syrap_3).equals("SMALLDELAYED") && configList.get(syrap_4).equals("ACTIVE"))
           {
               Label label20 = new Label(1, 45, "OK", green);
               sheet.addCell(label20);
           }
           else
           {
               Label label20 = new Label(1, 45, "warning", yellow);
               sheet.addCell(label20);


               int dpwsp=0;

               for (String st : configList)
               {
                   if (st.contains("<dpwsp;"))
                   {
                       dpwsp = configList.indexOf(st);
                       dpwsp = dpwsp-2;
                       break;
                   }
               }

               String syp = null;
               String syp_tmp = "";

               for(int i=syrap_cmp; i<=dpwsp; i++)
               {
                   syp = configList.get(i);
                   syp_tmp+=syp+"\n";

                   Label syp_lab = new Label(2, 45, syp.toString());
                   sheet.addCell(syp_lab);
               }

               Label syrap_warn = new Label(2, 45, "Not correct", va_c);
               WritableCellFeatures cellFeatures_syrap = new WritableCellFeatures();
               cellFeatures_syrap.setComment(syp_tmp);
               syrap_warn.setCellFeatures(cellFeatures_syrap);
               sheet.addCell(syrap_warn);
           }

//============= dpwsp

           Label cp_test = new Label(0, 46, "Central Processor Test functionality check", ca_b);
           sheet.addCell(cp_test);

           int dpwsp=0, dpwsp_1=0;

           for (String st : configList)
           {
               if (st.contains("MAU  SB SBSTATE      RPH-A       RPH-B       BUA STATE"))
               {
                   dpwsp = configList.indexOf(st);
                   dpwsp_1 = dpwsp+1;
                   dpwsp++;
                   break;
               }
           }

           String dpwsp_str = configList.get(dpwsp);
           String dpwsp_1_str = configList.get(dpwsp_1);

           String dpwsp_fn = dpwsp_str + "\n" + dpwsp_1_str;

           if ( dpwsp_str.equals("NRM  B  WO           -           -                   1") )
           {
               Label dpwsp_lab = new Label(1, 46, "OK", green);
               sheet.addCell(dpwsp_lab);
           }
           else
           {
               Label dpwsp_lab = new Label(1, 46, "warning", yellow);
               sheet.addCell(dpwsp_lab);

               Label dpwsp_1_lab = new Label(2, 46, "CP state not correct", va_c);
               WritableCellFeatures cellFeatures_dp = new WritableCellFeatures();
               cellFeatures_dp.setComment(dpwsp_fn);
               dpwsp_1_lab.setCellFeatures(cellFeatures_dp);
               sheet.addCell(dpwsp_1_lab);
           }

//======  ptwsp

           int ptwsp=0;

           for (String st : configList)
           {
               if (st.contains("CPT MESSAGE CP STATE"))
               {
                   ptwsp = configList.indexOf(st);
                   ptwsp = ptwsp+2;
                   break;
               }
           }

           String ptwsp_str = configList.get(ptwsp);

//           String ptwsp_sub_str = ptwsp_str.substring(4, 7) + "-" + ptwsp_str.substring(12, 17) + "-" + ptwsp_str.substring(28);

           if(ptwsp_str.equals("CP-A EX CP-B SBWO CON B: PHC:PAS"))
           {
               Label ptwsp_lab = new Label(1, 46, "OK", green);
               sheet.addCell(ptwsp_lab);

               Label ptwsp_lab_1 = new Label(2, 46, ptwsp_str, va_c);
               sheet.addCell(ptwsp_lab_1);
           }
           else
           {
               Label ptwsp_lab = new Label(1, 46, "warning", yellow);
               sheet.addCell(ptwsp_lab);

               Label ptwsp_lab_1 = new Label(2, 46, ptwsp_str, va_c);
               sheet.addCell(ptwsp_lab_1);
           }

//=============== plldp

           Label ptwsp_lab_1 = new Label(0, 47, "Check Processor load", ca_b);
           sheet.addCell(ptwsp_lab_1);

           int plldp_start=0, plldp_end=0, plsvp=0;

           for (String st : configList)
           {
               if (st.contains("<plldp;"))
               {
                   plldp_start = configList.indexOf(st);
                   plldp_start++;
                   break;
               }
           }

           for (String st : configList)
           {
               if (st.contains("<plsvp;"))
               {
                   plldp_end = configList.indexOf(st);
                   plldp_end--;

                   plsvp = configList.indexOf(st);
                   break;
               }
           }

           String plldp_str = null;
           String plldp_tmp = "";

           for(int i=plldp_start; i<=plldp_end; i++)
           {
               plldp_str = configList.get(i);
               plldp_tmp+=plldp_str + "\n";

           }
           Label plldp_lab0 = new Label(1, 47, "OK", green);
           sheet.addCell(plldp_lab0);

           Label plldp_lab1 = new Label(2, 47, "", va_c);
           WritableCellFeatures cellFeatures_pl = new WritableCellFeatures();
           cellFeatures_pl.setComment(plldp_str);
           plldp_lab1.setCellFeatures(cellFeatures_pl);
           sheet.addCell(plldp_lab1);

//==============

           int plsvp_end=0, sybtp=0;

           for (String st : configList)
           {
               if (st.contains("<sybtp;"))
               {
                   plsvp_end = configList.indexOf(st);
                   sybtp = plsvp_end + 1;
                   break;
               }
           }

           String plsvpse = null;
           String temp = "";

           Label plsvp_lab0 = new Label(0, 48, "Processor Load Supervision Data check", ca_b);
           sheet.addCell(plsvp_lab0);

           for (int i = plsvp; i<plsvp_end-2; i++)
           {
               plsvpse = configList.get(i);
               temp+=plsvpse+"\n";
           }


           if(temp.contains("NO DATA LOADED"))
           {
               Label plsvp_lab1 = new Label(1, 48, "warning", yellow);
               sheet.addCell(plsvp_lab1);

               Label pls_val2 = new Label(2, 48, temp, va_c);
               sheet.addCell(pls_val2);
           }
           else
           {
               Label plsvp_lab1 = new Label(1, 48, "OK", green);
               sheet.addCell(plsvp_lab1);
           }

//               Label pls_label = new Label(2, 48, temp, va_c);
//               sheet.addCell(pls_label);

//============

               Label swcmp_lab = new Label(0, 49, "Software Record comparison", ca_b);
               sheet.addCell(swcmp_lab);

               Label swcmp_lab1 = new Label(2, 49, "Upload Tool", va_c);
               sheet.addCell(swcmp_lab1);

//======= <sybtp;

               int sybtp_end=0;

            for (String st : configList)
            {
                if (st.contains("<sybfp:file;"))
                {
                    sybtp_end = configList.indexOf(st);
                    sybtp_end = sybtp_end-3;
                    break;
                }
            }

            String sybtp_str = null;
            String sybtp_tmp = "";

            for(int i=sybtp+1; i<=sybtp_end; i++)
            {
                sybtp_str = configList.get(i);
                sybtp_tmp+=sybtp_str+"\n";

//                System.out.println(sybtp_str);

                Label sybtp_lab1 = new Label(1, 50, "OK", green);
                   sheet.addCell(sybtp_lab1);

                   Label sybtp_lab2 = new Label(2, 50, sybtp_str, va_c);
                   sheet.addCell(sybtp_lab2);
            }

//            WritableCellFormat wrappedText = new WritableCellFormat();
//            wrappedText.setWrap(true);

            Label sybtp_label = new Label(2, 50, sybtp_tmp ,va_c);
            sheet.addCell(sybtp_label);

               Label sysbackup = new Label(0, 50, "System backup settings check", ca_b);
               sheet.addCell(sysbackup);

//===============
               // <sybfp:file;

               Label sybfp_label0 = new Label(0, 51, "Check the date of the latest dump", ca_b);
               sheet.addCell(sybfp_label0);

//===============


//============= <lamip;

               int lamip=0;

               for (String st : configList)
            {
                if (st.contains("<lamip;"))
                {
                    lamip = configList.indexOf(st);
                    break;
                }
            }

               Label lamip_lab = new Label(0, 52, "Checksum the dump", ca_b);
               sheet.addCell(lamip_lab);

               Label lamip_lab_1 = new Label(1, 52, "N/A", na);
               sheet.addCell(lamip_lab_1);

//===============

//=============== <OCINP:IPN=ALL;

               Label OCINP_lab = new Label(0, 53, "Check correct MW is loaded (212xx)", ca_b);
               sheet.addCell(OCINP_lab);

//================ ipn

               Label ipn_lab = new Label(0, 54, "Check IPN links (only 2123x)", ca_b);
               sheet.addCell(ipn_lab);

               Label ipn_lab_1 = new Label(1, 54, "N/A", va_c);
               sheet.addCell(ipn_lab_1);

//==========  <fcepp;

               Label fcepp_lab = new Label(0, 55, "RP / CP function change state check", ca_b);
               sheet.addCell(fcepp_lab);

               int fcepp=0;
               int fcepp_inc=0;

               for(String st : configList)
               {
                   if(st.contains("<fcepp;"))
                   {
                       fcepp = configList.indexOf(st);
                       fcepp_inc = fcepp+4;
                       break;
                   }
               }

               String fcepp_fch = configList.get(fcepp_inc);

               if(fcepp_fch.equals("NORM"))
               {
                   Label fcepp_lab1 = new Label(1, 55, "OK", green);
                   sheet.addCell(fcepp_lab1);
               }
               else
               {
                   int fcepp_end=0;

                   for(String st : configList)
                   {

                       if(st.contains("<SASTP:UNITS=MW;"))
                       {
                       fcepp_end = configList.indexOf(st);
                       fcepp_end--;
                       break;
                       }
                   }

                   String fcepp_str = null;
                   String fcepp_tmp = "";

                   for(int i=fcepp; i<fcepp_end; i++)
                   {
                       fcepp_str = configList.get(i);

                       fcepp_tmp+=fcepp_str+"\n";

                       Label fcepp_lab1 = new Label(1, 55, "warning", yellow);
                       sheet.addCell(fcepp_lab1);
                   }

                   Label fcepp_tmp_label = new Label(2, 55, "FCH state is wrong", va_c);
                   WritableCellFeatures cellFeatures_fc = new WritableCellFeatures();
                   cellFeatures_fc.setComment(fcepp_tmp);
                   fcepp_tmp_label.setCellFeatures(cellFeatures_fc);
                   sheet.addCell(fcepp_tmp_label);
               }

//========== <SASTP:UNITS=MW;

               int tca=0, tba=0, ps=0;

               for(String st : configList)
               {
                   if(st.contains("TOTAL ALLOCATED AREAS"))
                   {
                       tca = configList.indexOf(st);
                       break;
                   }
               }
               String tca_str = configList.get(tca);
               String tca_split[] = tca_str.split(" ");
               String tca_last_str = tca_split[tca_split.length - 1]; // last word

               int tca_int = Integer.parseInt(tca_last_str);

               for(String st : configList)
               {
                   if(st.contains("TOTAL BACKUP AREA"))
                   {
                       tba = configList.indexOf(st);
                       break;
                   }
               }
               String tba_str = configList.get(tba);
               String tba_split[] = tba_str.split(" ");
               String tba_last_str = tba_split[tba_split.length-1];

               int tba_int = Integer.parseInt(tba_last_str);

               for(String st : configList)
               {
                   if(st.contains("PHYSICAL STORE"))
                   {
                       ps = configList.indexOf(st);
                       break;
                   }
               }
               String ps_str = configList.get(ps);
               String ps_split[] = ps_str.split(" ");
               String ps_last_str = ps_split[ps_split.length-1];

               int ps_int = Integer.parseInt(ps_last_str);
               float tca_tba_add = ( (tca_int + tba_int)*100 );

               tca_tba_add = tca_tba_add/ps_int;

               String ds_str = Float.toString(tca_tba_add);

               if(tca_tba_add >= 80.00)
               {
                   Label sastp_lab1 = new Label(1, 56, "warning", yellow);
                   sheet.addCell(sastp_lab1);

                   int sastp_start=0;

                   for(String st : configList)
                   {
                       if(st.contains("<SASTP:UNITS=MW;"))
                       {
                           sastp_start = configList.indexOf(st);
                           break;
                       }
                   }
//                   String sastp_start_str = configList.get(sastp_start);

                   int sastp_end=0;

                   for(String st : configList)
                   {
                       if(st.contains("<labup;"))
                       {
                           sastp_end = configList.indexOf(st);
                           break;
                       }
                   }
//                   String sastp_end_str = configList.get(sastp_end);

                   String sastp_cmp = null;
                   String sastp_val = "";

                   for(int i=sastp_start; i<sastp_end; i++)
                   {
                       sastp_cmp = configList.get(i);
                       sastp_val+=sastp_cmp+"\n";
                   }

                   Label sastp_1 = new Label(2, 56, "DS utilization exceeded 80%" + "\n" + "DS utilization is " + ds_str, va_c);
                   WritableCellFeatures cellFeatures_ss = new WritableCellFeatures();
                   cellFeatures_ss.setComment(sastp_val);
                sastp_1.setCellFeatures(cellFeatures_ss);
                sheet.addCell(sastp_1);
               }
               else
               {
                   Label sastp_lab1 = new Label(1, 56, "OK", green);
                   sheet.addCell(sastp_lab1);
               }

               Label sastp_lab = new Label(0, 56, "Check Store Allocations", ca_b);
               sheet.addCell(sastp_lab);

//========= <labup;

               int labup_start=0, labup_end=0, labup_start_val =0, labup_last_val=0;

               for(String st : configList)
               {
                   if(st.contains("BANKTYPE     SIZE       NIU      MNIU     NCONG"))
                   {
                       labup_start = configList.indexOf(st);
                       break;
                   }
               }

               String str_labup_1 = configList.get(labup_start);

               for(String st : configList)
               {
                   if(st.contains("END"))
                   {
                       labup_end = configList.lastIndexOf(st);
                       labup_last_val = labup_end;
                       labup_end--;
                   }
               }

               String labup_str = null;
               String labup_tmp = "";

               for(int i=labup_start+1; i<=labup_end; i++)
               {
                   labup_str = configList.get(i);
                   if(labup_str.endsWith("0"))
                   {
                       Label labup_lab_1 = new Label(1, 57, "OK", green);
                       sheet.addCell(labup_lab_1);

                   }
                   else
                   {
                       Label labup_lab_1 = new Label(1, 57, "Warning", yellow);
                       sheet.addCell(labup_lab_1);

                       for(String st : configList)
                       {
                           if(st.contains("<labup;"))
                           {
                               labup_start_val = configList.indexOf(st);
                               break;
                           }
                       }

                       String lab_val = null;
                       String lab_tmp = "";

                       for(int j=labup_start_val; j<=labup_last_val; j++)
                       {
                           lab_val = configList.get(j);
                           lab_tmp+=lab_val+"\n";
                    }

                    Label lab_warn = new Label(2, 57, "Storage Bank congestion error!", va_c);
                    WritableCellFeatures cellFeatures_cg = new WritableCellFeatures();
                    cellFeatures_cg.setComment(lab_tmp);
                    lab_warn.setCellFeatures(cellFeatures_cg);
                    sheet.addCell(lab_warn);


//                       String q = str_labup_1 + "\n" + labup_str + "\n";
//                       labup_tmp+=q;
//
//                       Label labup_lab2 = new Label(2, 57, q);
//                       sheet.addCell(labup_lab2);

                   }

//                   Label fcepp_tmp_label = new Label(2, 57, labup_tmp);
//                   sheet.addCell(fcepp_tmp_label);
               }


               Label labup_lab = new Label(0, 57, "Check Storage Bank congestion", ca_b);
               sheet.addCell(labup_lab);


//------- APT
      // <pcorp:block=missra;

               int pcorp=0, ipa_val=0;
               for (String apt : aptfile)
            {
                if (apt.contains("pcorp"))
                {
                    pcorp = aptfile.indexOf(apt);
                    ipa_val = pcorp + 9;
                    pcorp = pcorp + 14;
                    break;
                }
            }
               String rev = aptfile.get(pcorp).substring(4, 6) + "." + aptfile.get(pcorp).charAt(6); // 13.2

               String ipa_splt[] = aptfile.get(ipa_val).split(" ");
               String ipa = ipa_splt[0].substring(0, 3); // IPA

               String ipa_hex = ipa_splt[0].substring(3);
               int iHex = Integer.parseInt(ipa_hex,16);
               int ipa_bin =Integer.toBinaryString(iHex).length(); // binary value, and its length (7)

               Label apt_status = new Label(0, 59, "APT HW/SW status", ca_b);
               sheet.addCell(apt_status);

               Label apt_ok = new Label(1, 59, "", va_c);
               sheet.addCell(apt_ok);

               workbook.write();
               workbook.close();

       } catch (WriteException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
 }
}




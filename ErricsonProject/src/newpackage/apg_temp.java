package newpackage;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.io.File;
import jxl.*;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;
import org.jfree.ui.RefineryUtilities;

public class apg_temp {

    public static ArrayList<String> getFileContentList(String fileName) {
        ArrayList<String> data = new ArrayList<String>();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = input.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException ex) {
            data = new ArrayList<String>();
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (Exception e) {
                    data = new ArrayList<String>();
                }
            }
        }
        return data;
    }

    @SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, WriteException, BiffException {
        int row_index = 0;
        int row_index_1 = 0;
        int k = 0;
        int n = 0;
        double[] active = new double[100]; //active subs
        double[] ds_util = new double[100];
        double[] busy_cha = new double[100];
        double[] ipet_double = new double[100];
        double[] im_double = new double[100];
        double[] mfd_double = new double[100];
        WritableWorkbook workbook = Workbook.createWorkbook(new File("Capacity_tool" + ".xls"));
        WritableSheet sheet = workbook.createSheet("MSS", 0);
        WritableSheet sheet1 = workbook.createSheet("Mediagateway", 1);

        sheet.mergeCells(0, 1, 0, 3); // customer
        sheet.mergeCells(1, 1, 1, 3); // circle
        sheet.mergeCells(2, 1, 2, 3); // node
        sheet.mergeCells(3, 1, 3, 3); // APZ
        sheet.mergeCells(4, 1, 7, 1); // Date
        sheet.mergeCells(4, 2, 4, 3); // Pload
        sheet.mergeCells(5, 2, 6, 2); //Subscribers
        sheet.mergeCells(7, 2, 7, 3); //	 Memory util

        sheet1.mergeCells(0, 1, 0, 3); // customer
        sheet1.mergeCells(1, 1, 1, 3); // circle
        sheet1.mergeCells(2, 1, 2, 3); // node
        sheet1.mergeCells(3, 1, 3, 3); // HW/SW Configuration
        sheet1.mergeCells(4, 1, 4, 3);
        sheet1.mergeCells(5, 1, 9, 1); // Date
        sheet1.mergeCells(5, 2, 5, 3); // Busy media Stream Channels
        sheet1.mergeCells(6, 2, 6, 3); //% of busy
        sheet1.mergeCells(7, 2, 9, 2); //	 Device util
        
        try 
        {
        	for (int z = 1; z < 10; z++) 
            {
        		ArrayList<String> apgfile = getFileContentList("MSS" + z + ".log");
                ArrayList<String> configList = getFileContentList("mgw" + z + ".log");

                sheet.setColumnView(0, 20);
                sheet.setColumnView(2, 30);
                sheet.setColumnView(3, 20);
                sheet.setColumnView(4, 20);
                sheet.setColumnView(5, 20);
                sheet.setColumnView(6, 20);
                sheet.setColumnView(7, 20);

                sheet1.setColumnView(0, 15);
                sheet1.setColumnView(1, 15);
                sheet1.setColumnView(2, 15);
                sheet1.setColumnView(3, 30);
                sheet1.setColumnView(4, 10);
                sheet1.setColumnView(5, 20);
                sheet1.setColumnView(6, 30);
                sheet1.setColumnView(7, 20);
                sheet1.setColumnView(8, 20);
                /*sheet.mergeCells(0, 1, 0, 3); // customer
                sheet.mergeCells(1, 1, 1, 3); // circle
                sheet.mergeCells(2, 1, 2, 3); // node
                sheet.mergeCells(3, 1, 3, 3); // APZ
                sheet.mergeCells(4, 1, 7, 1); // Date
                sheet.mergeCells(4, 2, 4, 3); // Pload
                sheet.mergeCells(5, 2, 6, 2); //Subscribers
                sheet.mergeCells(7, 2, 7, 3); //	 Memory util
                 */
                WritableFont bold_0 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);

                WritableCellFormat bold_1 = new WritableCellFormat(bold_0);
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
                yellow.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.HAIR, jxl.format.Colour.BLACK);
                yellow.setWrap(true);

                WritableFont bold_g = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
                WritableCellFormat green = new WritableCellFormat(bold_g);
                green.setBackground(jxl.format.Colour.LIGHT_GREEN);
                green.setAlignment(jxl.format.Alignment.CENTRE);
                green.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
                green.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.HAIR, jxl.format.Colour.BLACK);
                green.setWrap(true);

                WritableCellFormat va_c = new WritableCellFormat();
                va_c.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
                va_c.setShrinkToFit(true);
                va_c.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.HAIR, jxl.format.Colour.BLACK);
                va_c.setWrap(true);

                WritableCellFormat alan_set = new WritableCellFormat();
                alan_set.setWrap(true);

                WritableCellFormat color_blue_border = new WritableCellFormat(bold_0);
                color_blue_border.setBackground(jxl.format.Colour.ORANGE);
                color_blue_border.setAlignment(jxl.format.Alignment.CENTRE);
                color_blue_border.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
                color_blue_border.setWrap(true);
                color_blue_border.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.HAIR, jxl.format.Colour.BLACK);

                WritableCellFormat na = new WritableCellFormat();
                na.setAlignment(jxl.format.Alignment.CENTRE);
                na.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
                na.setFont(bold_g);
                na.setWrap(true);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                //  cal.add(Calendar.DATE,0);
                String date = dateFormat.format(cal.getTime());

//saosp
                String apz_ver = "";
                for (String st : apgfile) {
                    if (st.trim().endsWith("APZ TYPE") || st.trim().endsWith("APZ VERSION")) {
                        String apz_ver_type[] = apgfile.get(apgfile.indexOf(st)).trim().replaceAll("\\s+", " ").split(" ");
                        apz_ver += apz_ver_type[3];
                    }
                }

                int merge_1 = 4 + row_index + k;

                Label apz_type = new Label(3, 4 + row_index + k, apz_ver, green);
                sheet.addCell(apz_type);

//mgsvp
                int tot_sub = 0, active_sub = 0;
                for (String st : apgfile) {
                    if (st.trim().startsWith("TOTNSUB")) {
                        tot_sub = apgfile.indexOf(st);
                        break;
                    }
                }
                String val_tot = apgfile.get(tot_sub + 1);

                Label tot_lab = new Label(5, 4 + row_index + k, val_tot, green);
                sheet.addCell(tot_lab);

                String val_act = null;
                for (String st : apgfile) {
                    if (st.contains("TOTNSUBA")) {
                        active_sub = apgfile.indexOf(st);
                        break;
                    } else {
                        val_act = null;
                    }
                }

                val_act = apgfile.get(active_sub + 1);
                int act_sub = Integer.parseInt(val_act);
                //	 System.out.println(act_sub);
                if (act_sub > 0 && act_sub < 100000) {

                    active[act_sub / 100000] = active[act_sub / 100000] + 1;
                } else if (act_sub >= 100000 && act_sub < 200000) {
                    active[act_sub / 100000] = active[act_sub / 100000] + 1;
                } else if (act_sub >= 200000 && act_sub < 300000) {
                    active[act_sub / 100000] = active[act_sub / 100000] + 1;
                } else if (act_sub >= 300000 && act_sub < 400000) {
                    active[act_sub / 100000] = active[act_sub / 100000] + 1;
                } else if (act_sub >= 400000 && act_sub < 500000) {
                    active[act_sub / 100000] = active[act_sub / 100000] + 1;
                } else if (act_sub >= 500000 && act_sub < 10000000) {
                    active[5] = active[5] + 1;
                }

                Label act_lab = new Label(6, 4 + row_index + k, val_act, green);
                sheet.addCell(act_lab);

//for node name

                int ioexp = 0;
                for (String st : apgfile) {
                    if (st.contains("<ioexp;")) {
                        ioexp = apgfile.indexOf(st) + 4;
                        break;
                    }
                }
                String node_name = apgfile.get(ioexp);

                Label node_lab = new Label(2, 4 + row_index + k, node_name, green);
                sheet.addCell(node_lab);

// DS memory utilization

                int mem_util = 0;
                for (String st : apgfile) {
                    if (st.contains("TEST  STORE  FLAG  LIM1   HYST1 ACL1  LIM2   HYST2  ACL2  UTIL")) {
                        mem_util = apgfile.indexOf(st) + 1;
                        break;
                    }
                }
                String mem_lev[] = apgfile.get(mem_util).replaceAll("\\s+", " ").split(" ");

                String util = mem_lev[mem_lev.length - 1];

                int util_mss = Integer.parseInt(util);
//                System.out.println(util_mss);
                // System.out.println(util_mss);

                if (util_mss >= 0 && util_mss < 10) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 10 && util_mss < 20) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 20 && util_mss < 30) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 30 && util_mss < 40) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 40 && util_mss < 50) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 50 && util_mss < 60) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 60 && util_mss < 70) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 70 && util_mss < 80) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 80 && util_mss < 90) {
                    ds_util[util_mss / 10] = ds_util[util_mss / 10] + 1;
                } else if (util_mss >= 90 && util_mss < 200) {
                    ds_util[9] = ds_util[9] + 1;
                }
                Label util_lab = new Label(7, 4 + row_index + k, util, green);
                sheet.addCell(util_lab);

// PLOad
                int pl = 0;
                for (String st : apgfile) {
                    if (st.trim().endsWith("type LOAS.data")) {
                        pl = apgfile.indexOf(st);
                        break;
                    }
                }

                int eof = 0;
                float division = 0.0f;
                for (String st : apgfile) {
                    if (st.contains(">")) {
                        eof = apgfile.lastIndexOf(st);
                    }
                }

                String ser_pl[] = null;
                for (int j = pl + 1; j <= eof; j++) {
                    if (apgfile.get(j).contains(">")) {
                        break;
                    } else if (apgfile.get(j).contains(",")) {
                        ser_pl = apgfile.get(j).split(",");

                        division = Integer.parseInt(ser_pl[2]) / Integer.parseInt(ser_pl[4]);
                        pl += 1;
                    } else {
                    }

                    String str10 = Float.toString(division);

                    Label pwload_label = new Label(4, 4 + k + row_index, str10, va_c);
                    WritableCellFeatures apg_comm = new WritableCellFeatures();
                    apg_comm.setComment(ser_pl[0], 1, 1);
                    pwload_label.setCellFeatures(apg_comm);
                    sheet.addCell(pwload_label);

                    k++;
                }

                k = k - 1;
                int merge_2 = 4 + k + row_index;

                for (int m = 0; m <= 7; m++) {
                    if (m == 4)
                    {} 
                    else 
                    {
//                        sheet.mergeCells(m, merge_1, m, merge_2);
                    }
                }

                Label prs = new Label(0, 1, "Customer", color_blue_border);
                Label label = new Label(1, 1, "Circle", color_blue_border);
                Label label1 = new Label(2, 1, "Node", color_blue_border);
                Label label2 = new Label(3, 1, "APZ", color_blue_border);
                Label label3 = new Label(4, 2, "PLoad", color_blue_border);
                Label label4 = new Label(4, 1, "Date:" + date, color_blue_border);
                Label label5 = new Label(5, 2, "Subscribers (for VLRs only)", color_blue_border);
                Label label6 = new Label(7, 2, "DS memory utilization", color_blue_border);
                Label label7 = new Label(5, 3, "Total Subs", color_blue_border);
                Label label8 = new Label(6, 3, "Active Subs", color_blue_border);

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

                Label prss1 = new Label(0, 1, "Customer", color_blue_border);
                Label labels1 = new Label(1, 1, "Circle", color_blue_border);
                Label label1s1 = new Label(2, 1, "Node", color_blue_border);
                Label label2s1 = new Label(3, 1, "HW/SW Configuration", color_blue_border);
                Label label3s1 = new Label(4, 1, "License Capacity", color_blue_border);
                Label label4s1 = new Label(5, 1, "Date:" + date, color_blue_border);
                Label label5s1 = new Label(5, 2, "Busy Media Stream Channels(Busy hour)", color_blue_border);
                Label label6s1 = new Label(6, 2, "% of busy channels to Licensed Capacity (E-F)", color_blue_border);
                Label label7s1 = new Label(7, 2, "Device Utilization", color_blue_border);

                Label label8s1 = new Label(7, 3, "MFD pool", color_blue_border);
                Label label9s1 = new Label(8, 3, "IPET pool", color_blue_border);
                Label label10s1 = new Label(9, 3, "IM pool", color_blue_border);
                sheet1.addCell(prss1);
                sheet1.addCell(labels1);
                sheet1.addCell(label1s1);
                sheet1.addCell(label2s1);
                sheet1.addCell(label3s1);
                sheet1.addCell(label4s1);
                sheet1.addCell(label5s1);
                sheet1.addCell(label6s1);
                sheet1.addCell(label7s1);
                sheet1.addCell(label8s1);
                sheet1.addCell(label9s1);
                sheet1.addCell(label10s1);
                //Node name
                int n_n = 0;
                for (String st : configList) {
                    if (st.trim().startsWith("userLabel")) {
                        n_n = configList.indexOf(st);
                        String ab[] = configList.get(n_n).replaceAll("\\s+", " ").split(" ");
                        String cd = ab[1];
                        //      System.out.println(cd);
                        Label node_label = new Label(2, 4 + row_index_1, cd, va_c);
                        sheet1.addCell(node_label);
                    }
                }

                if (n_n == 0) {
                    Label node_label = new Label(2, 4 + row_index_1, "", va_c);
                    sheet1.addCell(node_label);
                }

//Product no.
                int ind1 = 0;
                for (String st : configList) {
                    if (st.contains("productNumber")) {
                        ind1 = configList.indexOf(st);
                        String ab[] = configList.get(ind1).replaceAll("\\s+", " ").split(" ");
                        String cd = ab[1];

                        Label node_label = new Label(3, 4 + row_index_1, cd, va_c);
                        sheet1.addCell(node_label);
                    }
                }

                if (ind1 == 0) {
                    Label node_label = new Label(3, 4 + row_index_1, "", va_c);
                    sheet1.addCell(node_label);
                }

//License Capacity
                int soft = 0;
                String ser_n[] = null;

                for (String st : configList) {
                    if (st.trim().startsWith("MgwApplication=1 maxNrOfLicMediaStreamChannels")) {
                        soft = configList.indexOf(st);

                        break;
                    }
                }
                ser_n = configList.get(soft).replaceAll("\\s+", " ").split(" ");
                int ser = Integer.parseInt(ser_n[2]);

                Label lic_capacity = new Label(4, 4 + row_index_1, ser_n[2], va_c);
                sheet1.addCell(lic_capacity);

// Busy Stream channels
                int bsc = 0;
                for (String st : configList) {
                    if ((st.startsWith("MgwApplication=1 pmNrOfMediaStreamChannelsBusy")) || (st.trim().startsWith("MgwApplication=1") && st.contains("MediaStreamChannelsBusy"))) {
                        bsc = configList.indexOf(st);
                        break;
                    }
                }
                String ser_bsc[] = configList.get(bsc).replaceAll("\\s+", " ").split(" ");

                ArrayList<Integer> arr_bsc = new ArrayList<Integer>();
                float avg1 = 0;
                int div1 = 0;
                for (int i = 2; i < ser_bsc.length; i++) {
                    arr_bsc.add(Integer.parseInt(ser_bsc[i]));
                    avg1 += Integer.parseInt(ser_bsc[i]);
                    div1 = i - 1;
                }

                avg1 = avg1 / div1;
                String str4 = Float.toString(avg1);

                Label mfd_bsc = new Label(5, 4 + row_index_1, str4, va_c);
                sheet1.addCell(mfd_bsc);

                float percent = avg1 / ser;
                percent = percent * 100;
                percent = (float) (Math.round(percent * 100.0) / 100.0);
                String str5 = Float.toString(percent);
                busy_cha[n] = Double.parseDouble(str5);
                Label mfd_per = new Label(6, 4 + row_index_1, str5, va_c);
                sheet1.addCell(mfd_per);

// MFD
                int mfd = 0;
                for (String st : configList) {
                    if (st.contains(" MFD Pool MFD Pool MFD Pool MFD Pool MFD Pool MFD Pool MFD Pool MFD Pool") || st.contains("mfd    mfd    mfd    mfd    mfd    mfd    mfd  ")) {
                        mfd = (configList.indexOf(st)) - 1;
                        break;
                    }
                }
                String ser_mfd[] = configList.get(mfd).replaceAll("\\s+", " ").split(" ");

                ArrayList<Integer> arey = new ArrayList<Integer>();
                float avg = 0;
                int div = 0;
                for (int i = 2; i < ser_mfd.length; i++) {
                    arey.add(Integer.parseInt(ser_mfd[i]));
                    avg += Integer.parseInt(ser_mfd[i]);
                    div = i - 1;
                }
                avg = avg / div;
                avg = (float) (Math.round(avg * 100.0) / 100.0);
                String str1 = Float.toString(avg);
                mfd_double[n] = Double.parseDouble(str1);
                Label mfd_lab = new Label(7, 4 + row_index_1, str1, va_c);
                sheet1.addCell(mfd_lab);

//IM pool
                int im = 0;
                for (String st : configList) {
                    if (st.contains("IM Pool IM Pool IM Pool IM Pool IM Pool IM Pool IM Pool IM Pool")) {
                        im = (configList.indexOf(st)) - 1;
                        String ser_im[] = configList.get(im).replaceAll("\\s+", " ").split(" ");

                        ArrayList<Integer> imarray = new ArrayList<Integer>();
                        float avgim = 0;
                        int divim = 0;
                        for (int i = 2; i < ser_im.length; i++) {
                            imarray.add(Integer.parseInt(ser_im[i]));
                            avgim += Integer.parseInt(ser_im[i]);
                            divim = i - 1;
                        }

                        avgim = avgim / divim;
                        avgim = (float) (Math.round(avgim * 100.0) / 100.0);
                        String str2 = Float.toString(avgim);
                        im_double[n] = Double.parseDouble(str2);


                        Label im_lab = new Label(8, 4 + row_index_1, str2, va_c);
                        sheet1.addCell(im_lab);

                        break;
                    } else {
                        Label im_lab = new Label(8, 4 + row_index_1, "", va_c);
                        sheet1.addCell(im_lab);
                    }
                }
                /* String ser_im[] = configList.get(im).replaceAll("\\s+", " ").split(" ");

                ArrayList<Integer> imarray = new ArrayList<Integer>();
                float avgim=0;
                int divim=0;
                for(int i=2; i<ser_im.length; i++)
                {
                imarray.add(Integer.parseInt(ser_im[i]));
                avgim+=Integer.parseInt(ser_im[i]);
                divim=i-1;
                }

                avgim=avgim/divim;
                String str2= Float.toString(avgim);

                Label im_lab = new Label(8, 4, str2);
                sheet1.addCell(im_lab); */

//Ipet tool
                int ipet = 0;
                for (String st : configList) {
                    if (st.contains("IpEtPool IpEtPool IpEtPool IpEtPool IpEtPool IpEtPool IpEtPool IpEtPool") || st.contains("IPET Pool IPET Pool IPET Pool IPET Pool IPET Pool IPET Pool IPET Pool IPET Pool") || st.contains("ipet   ipet   ipet   ipet   ipet   ipet   ipet   ipet")) {
                        ipet = (configList.indexOf(st)) - 1;
                        break;
                    }
                }
                String ser_ipet[] = configList.get(ipet).replaceAll("\\s+", " ").split(" ");

                float avgipet = 0;
                int divipet = 0;
                for (int i = 2; i < ser_ipet.length; i++) {
                    avgipet += Integer.parseInt(ser_ipet[i]);
                    divipet = i - 1;
                }
                avgipet = avgipet / divipet;
                avgipet = (float) (Math.round(avgipet * 100.0) / 100.0);
                String str3 = Float.toString(avgipet);
                ipet_double[n] = Double.parseDouble(str3);
                n++;
                Label ipet_lab = new Label(9, 4 + row_index_1, str3, va_c);
                sheet1.addCell(ipet_lab);

                row_index++;
                row_index_1++;
            }
            /*for (int l = 0; l < 10; l++) 
            {
//            	System.out.println("ds_util"+ds_util[l]);
//            	System.out.println("busy"+ busy_cha[l]);
//            	System.out.println("active"+active[l]);
//                System.out.println("Array for IPET " + ipet_double[l]);
//                System.out.println("Array for IM " + im_double[l]);
//                System.out.println("Array for MFD " + mfd_double[l]); 
            }*/
            workbook.write();
            workbook.close();
              BarChartDemo1 bcd = new BarChartDemo1("",ds_util, busy_cha, ipet_double, im_double, mfd_double,active);    //1st string is the title you want
           bcd.pack();
        RefineryUtilities.centerFrameOnScreen(bcd);
        bcd.setVisible(true); //  bcd.your method in barchartdemo which will create the graph
            
        } catch (WriteException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

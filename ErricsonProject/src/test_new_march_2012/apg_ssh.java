package test_new_march_2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.jscape.inet.ssh.SshException;
import com.jscape.inet.ssh.SshSession;

public class apg_ssh implements Runnable{

    String oss_un;

    public apg_ssh(String oss_un) {
        this.oss_un = oss_un;
    }

    public void run() {
        try {
            Workbook workbook1 = Workbook.getWorkbook(new File("hi.xls"));
            Sheet sheet1 = workbook1.getSheet("IDEA");
            Cell[] c = sheet1.getColumn(0); // getting column 1
            List<String> cell = new ArrayList<String>();
            for (int i = 1; i < c.length; i++) {
                if (!c[i].getContents().trim().equals("")) {
                    cell.add(c[i].getContents().trim()); // values in column 1
                }
            }
            ArrayList<String> node_name = new ArrayList<String>();
            for (String node : cell) {
                node_name.add(node);
            }
            String info = null;
            String node_n = null;
            String rsg_ip_add = null;
            String oss_ip_add = null;
            String oss_password = null;
            for (int i = 0; i < node_name.size(); i++) {
                if (oss_un.equals(node_name.get(i))) {
                    Cell node = sheet1.getCell(0, i + 1);
                    node_n = node.getContents();
                    Cell rsg_ip = sheet1.getCell(1, i + 1);
                    rsg_ip_add = rsg_ip.getContents();
                    Cell oss_ip = sheet1.getCell(2, i + 1);
                    oss_ip_add = oss_ip.getContents();
                    Cell temp = sheet1.getCell(3, i + 1);
                    info = temp.getContents();
                    Cell oss_pass = sheet1.getCell(4, i + 1);
                    oss_password = oss_pass.getContents();
                    break;
                } else {
                }
            }
            System.out.println("node name " + node_n);
            System.out.println("rsg ip " + rsg_ip_add);
            System.out.println("oss ip " + oss_ip_add);
            System.out.println("oss_un " + info);
            System.out.println("oss pass " + oss_password);
            String shellPrompt = ">";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Password: ");
            String tmpPass = reader.readLine();
            SshSession session = new SshSession("150.236.14.11", "equwxyb", tmpPass);
            session.setShellPrompt(shellPrompt);
            session.connect();
            System.out.println("connected");
            log("apg_ssh_log.txt", session.sendWait("show host", shellPrompt));
            log("apg_ssh_log.txt", session.sendWait("ssh ssgpun", ":"));
            log("apg_ssh_log.txt", session.sendWait("equwxyb11", shellPrompt));
            log("apg_ssh_log.txt", session.sendWait("net 10.136.197.82", ":"));
            log("apg_ssh_log.txt", session.sendWait("els", ":"));
            log("apg_ssh_log.txt", session.sendWait("dec@12345", shellPrompt));
            log("apg_ssh_log.txt", session.sendWait("eaw MSSIND4", "<"));
            log("apg_ssh_log.txt", session.sendWait("aploc;", shellPrompt));
            log("apg_ssh_log.txt", session.sendWait("mml", "<"));
            log("apg_ssh_log.txt", session.sendWait("ioexp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("aploc;", ">"));
            log("apg_ssh_log.txt", session.sendWait("prcstate", ">"));
            log("apg_ssh_log.txt", session.sendWait("prcstate -l", ">"));
            log("apg_ssh_log.txt", session.sendWait("cluster node", ">"));
            log("apg_ssh_log.txt", session.sendWait("swrprint", ">"));
            log("apg_ssh_log.txt", session.sendWait("cluster res", ">"));
            log("apg_ssh_log.txt", session.sendWait("megarc -ldinfo -lall -a0", ">"));
            log("apg_ssh_log.txt", session.sendWait("diskpart", ">")); // not working
            log("apg_ssh_log.txt", session.sendWait("list vol", ">")); //
            log("apg_ssh_log.txt", session.sendWait("pstat", ">")); //
            log("apg_ssh_log.txt", session.sendWait("cpdlist -a", ">"));
            log("apg_ssh_log.txt", session.sendWait("wmic VOLUME GET Capacity, DriveLetter, FreeSpace, Label", ">")); //
            log("apg_ssh_log.txt", session.sendWait("systeminfo", ">")); //
            log("apg_ssh_log.txt", session.sendWait("stmotls", ">"));
            log("apg_ssh_log.txt", session.sendWait("stmmp -lL", ">"));
            log("apg_ssh_log.txt", session.sendWait("stmrp -lL", ">"));
            log("apg_ssh_log.txt", session.sendWait("\"C:\\Program files\\force\\frconfig\\domainrename\\repadmin\" /replsummary", ">")); //
            log("apg_ssh_log.txt", session.sendWait("m:", ">"));
            log("apg_ssh_log.txt", session.sendWait("cd images", ">"));
            log("apg_ssh_log.txt", session.sendWait("dir", ":\\"));
            log("apg_ssh_log.txt", session.sendWait("cd nodea", ">"));
            log("apg_ssh_log.txt", session.sendWait("dir", ":\\"));
            log("apg_ssh_log.txt", session.sendWait("cd ..", ">"));
            log("apg_ssh_log.txt", session.sendWait("cd nodeb", ">"));
            log("apg_ssh_log.txt", session.sendWait("dir", ":\\"));
            log("apg_ssh_log.txt", session.sendWait("burverify -d", ">"));
            log("apg_ssh_log.txt", session.sendWait("mml", "<"));
            log("apg_ssh_log.txt", session.sendWait("saosp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("dirrp:rp=all;", "<"));
            log("apg_ssh_log.txt", session.sendWait("syfdp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("syfsp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("syrap;", "<"));
            log("apg_ssh_log.txt", session.sendWait("dpwsp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ptcoi;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ptwsp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ptcoe;", "<"));
            log("apg_ssh_log.txt", session.sendWait("plldp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("plsvp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("sybtp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("lamip;", "<"));
            log("apg_ssh_log.txt", session.sendWait("OCINP:IPN=ALL;", "<"));
            log("apg_ssh_log.txt", session.sendWait("fcepp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("pcorp:block=missra;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ALLIP:ALCAT=APT,ACL=A1;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ALLIP:ALCAT=APT,ACL=A2;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ALLIP:ALCAT=APT,ACL=A3;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ALLIP:ALCAT=APT,ACL=O1;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ALLIP:ALCAT=APT,ACL=O2;", "<"));
            log("apg_ssh_log.txt", session.sendWait("gsstp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("gdstp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("caclp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("nsstp;", "<"));
            log("apg_ssh_log.txt", session.sendWait("mgepp:id=all;", "<"));
            log("apg_ssh_log.txt", session.sendWait("dbtsp:tab=saactions;", "<"));
            log("apg_ssh_log.txt", session.sendWait("exrpp:rp=all;", "<"));
            log("apg_ssh_log.txt", session.sendWait("EXEMP:RP=ALL,EM=ALL;", "<"));
            log("apg_ssh_log.txt", session.sendWait("ntstp:snt=all;", "<"));
            log("apg_ssh_log.txt", session.sendWait("dtstp:dip=all;", "<"));
            log("apg_ssh_log.txt", session.sendWait("tpstp:sdip=all;", "<"));
            log("apg_ssh_log.txt", session.sendWait("CHOIP;", "<"));
            log("apg_ssh_log.txt", session.sendWait("CHOPP:FN=ALL;", "<"));
            log("apg_ssh_log.txt", session.sendWait("CHOPP;", "<"));
            session.disconnect();
        } catch (SshException ex) {
            Logger.getLogger(apg_ssh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(apg_ssh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(apg_ssh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void log(String fname, String data) {
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter(fname, true));
            b.append(data);
            b.newLine();
            b.close();
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }
}

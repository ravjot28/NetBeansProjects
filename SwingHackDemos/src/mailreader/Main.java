package mailreader;

public class Main {
    public Main() {
    }
    public static void main(String[] args) {

        try {

            GmailUtilities gmail = new GmailUtilities();
            gmail.setUserPass("airindiapayroll@gmail.com", "airindia1960");
            gmail.connect();
            gmail.openFolder("INBOX");

            int totalMessages = gmail.getMessageCount();
            int newMessages = gmail.getNewMessageCount();

            System.out.println("Total messages = " + totalMessages);
            System.out.println("New messages = " + newMessages);
            System.out.println("-------------------------------");

//Uncomment the below line to print the body of the message. Remember it will eat-up your bandwidth if you have 100's of messages.            //gmail.printAllMessageEnvelopes();
            gmail.printAllMessages();

        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

}
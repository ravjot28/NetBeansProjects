import javax.mail.MessagingException;
import javax.swing.*;

public class MailSender extends JFileChooser
{

    private JTextField attachmentTextField;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
    private JScrollPane jScrollPane1;
    private JTextArea messageTextArea;
    private JButton sendButton, cancelButton, browseButton;
    private JTextField ccTextField, subjectTextField, toTextField;
    String toAddress = null, ccAddress = null, message = null,
            receipientsList[] = null, attachments[] = null, receipients, subject;
    String fromAddress = "ravjot28@gmail.com"; //Place your mail id here.
    String authenticationPassword = "ravjotsingh71";//Place your password here

    public MailSender()
    {
        initComponents();
    }

    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel("To");
        toTextField = new javax.swing.JTextField(20);
        jLabel3 = new javax.swing.JLabel("CC");
        ccTextField = new javax.swing.JTextField(20);
        jLabel4 = new javax.swing.JLabel("Subject");
        subjectTextField = new javax.swing.JTextField(20);
        jLabel5 = new javax.swing.JLabel("Attachemnet");
        attachmentTextField = new javax.swing.JTextField(20);
        browseButton = new javax.swing.JButton("Browse");
        jLabel6 = new javax.swing.JLabel("Message");
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea(20, 10);
        sendButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("AlMateen-Bold", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 203, 221));
        jLabel1.setText("Mail Sender");
        jScrollPane1.setViewportView(messageTextArea);
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener()
        {

            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sendButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {

            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        browseButton.addActionListener(new java.awt.event.ActionListener()
        {

            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                browseButtonActionPerformed(evt);
            }
        });

        jLabel1.setBounds(100, 50, 200, 50);
        jLabel2.setBounds(50, 100, 100, 50);
        toTextField.setBounds(150, 100, 300, 40);

        jLabel3.setBounds(50, 150, 100, 50);
        ccTextField.setBounds(150, 150, 300, 40);

        jLabel4.setBounds(50, 200, 100, 50);
        subjectTextField.setBounds(150, 200, 300, 40);

        jLabel5.setBounds(50, 250, 100, 50);
        attachmentTextField.setBounds(150, 250, 200, 40);
        browseButton.setBounds(375, 250, 100, 20);

        jLabel6.setBounds(50, 300, 100, 50);
        messageTextArea.setBounds(150, 300, 300, 40);

        sendButton.setBounds(100, 400, 75, 20);
        cancelButton.setBounds(200, 400, 75, 20);
        JFrame mailFrame = new JFrame("Mail Sender");
        mailFrame.add(jLabel1);
        mailFrame.add(jLabel2);
        mailFrame.add(toTextField);
        mailFrame.add(jLabel3);
        mailFrame.add(ccTextField);
        mailFrame.add(jLabel4);
        mailFrame.add(subjectTextField);
        mailFrame.add(jLabel5);
        mailFrame.add(attachmentTextField);
        mailFrame.add(browseButton);
        mailFrame.add(jLabel6);
        mailFrame.add(messageTextArea);
        mailFrame.add(sendButton);
        mailFrame.add(cancelButton);

        mailFrame.setLayout(null);
        mailFrame.setVisible(true);
        mailFrame.setSize(500, 500);
        mailFrame.setResizable(false);
        mailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        // TODO add your handling code here:
    }

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        JFileChooser selectFile = new JFileChooser();
        selectFile.showOpenDialog(this);
        attachmentTextField.setText(selectFile.getSelectedFile().toString());
    }

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt)
    {

        toAddress = toTextField.getText().trim();
        ccAddress = ccTextField.getText().trim();
        subject = subjectTextField.getText().trim();
        message = messageTextArea.getText().trim();
        String attachment = attachmentTextField.getText() + " ";

        attachments = attachment.split(" ");

        receipients = toAddress + "," + ccAddress;
        receipientsList = receipients.split(",");

        SendMailUsingAuthentication mailUsingAuthentication =
                new SendMailUsingAuthentication();
        try {
            mailUsingAuthentication.postMail(receipientsList,
                    subject, message, fromAddress, authenticationPassword, attachments);
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }
    }

    void login(String userName, String password)
    {
        fromAddress = userName;
        authenticationPassword = password;
        System.out.println("User name : " + fromAddress);
    }

    public static void main(String[] args)
    {
        new MailSender();
    }
}

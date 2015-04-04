/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mailreader;

/**
 *
 * @author Rav
 */
public class MessageContent {

    private String to;
    private String from;
    private String body;
    private String subject;
    private String sendDate;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

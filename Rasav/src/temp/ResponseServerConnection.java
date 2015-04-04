/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

/**
 *
 * @author Rav
 */
public class ResponseServerConnection {
    
    private String status;
    private String connectionInfo;
    private int code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConnectionInfo() {
        return connectionInfo;
    }

    public void setConnectionInfo(String connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

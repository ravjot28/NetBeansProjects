package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flat {

    @Id
    private String username;
    private String password;
    private String balMukul;
    private String balVijay;
    private String balPuneet;
    private String balPankaj;
    

    public String getBalMukul() {
        return balMukul;
    }

    public void setBalMukul(String balMukul) {
        this.balMukul = balMukul;
    }

    public String getBalPankaj() {
        return balPankaj;
    }

    public void setBalPankaj(String balPankaj) {
        this.balPankaj = balPankaj;
    }

    public String getBalPuneet() {
        return balPuneet;
    }

    public void setBalPuneet(String balPuneet) {
        this.balPuneet = balPuneet;
    }

    public String getBalVijay() {
        return balVijay;
    }

    public void setBalVijay(String balVijay) {
        this.balVijay = balVijay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

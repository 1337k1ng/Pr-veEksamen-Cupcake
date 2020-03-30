package FunctionLayer;

import DBAccess.OrdreMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

public class Ordre {

    private String bund;
    private String top;
    private String pris;
    private String Tidspunkt;
    private String Email;
    private String Antal;

    public Ordre(String tidspunkt, String email, String bund, String top, String pris) {
        this.bund = bund;
        this.top = top;
        this.pris = pris;
        this.Email = email;
        this.Tidspunkt = tidspunkt;
    }


    public String getBund() {
        return bund;
    }

    public String getTop() {
        return top;
    }

    public String getPris() {
        return pris;
    }

    public String getTidspunkt() {
        return Tidspunkt;
    }

    public String getEmail() {
        return Email;
    }

    public String getAntal() {
        return Antal;
    }
}

package pojo;

import java.util.Date;

public class Sparkasse {

    Double dBetrag;
    Integer iBetrag;
    String zweck;
    String datum;

    public Sparkasse(Double dBetrag, String zweck, String datum) {
        this.dBetrag = dBetrag;
        this.zweck = zweck;
        this.datum = datum;
    }


    public Sparkasse(Integer iBetrag, String zweck, String datum) {
        this.iBetrag = iBetrag;
        this.zweck = zweck;
        this.datum = datum;
    }

    public Double getdBetrag() {
        return dBetrag;
    }

    public void setdBetrag(Double dBetrag) {
        this.dBetrag = dBetrag;
    }

    public Integer getiBetrag() {
        return iBetrag;
    }

    public void setiBetrag(Integer iBetrag) {
        this.iBetrag = iBetrag;
    }

    public String getZweck() {
        return zweck;
    }

    public void setZweck(String zweck) {
        this.zweck = zweck;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}

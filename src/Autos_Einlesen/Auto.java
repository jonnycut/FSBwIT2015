package Autos_Einlesen;

import java.util.List;

/**
 * Created by JonnyCut on 28.10.2015.
 */
public class Auto implements Comparable<Auto> {

    private String ez;
    private String hu;
    private String anbieter;
    private String art;
    private String km;
    private String leistung;
    private String preis;
    private String kraftstoff;
    private String schlatung;
    private String unfall;
    private String name;
    private String ort;
    private List<String> extras;


    public Auto(String ez, String hu, String anbieter, String art, String km, String leistung, String preis, String kraftstoff, String schlatung, String unfall, String name, String ort, List extras) {
        this.ez = ez;
        this.hu = hu;
        this.anbieter = anbieter;
        this.art = art;
        this.km = km;
        this.leistung = leistung;
        this.preis = preis;
        this.kraftstoff = kraftstoff;
        this.schlatung = schlatung;
        this.unfall = unfall;
        this.name = name;
        this.ort = ort;
        this.extras=extras;
    }

    public String getAnbieter() {
        return anbieter;
    }

    public String getEz() {
        return ez;
    }

    public String getHu() {
        return hu;
    }

    public String getArt() {
        return art;
    }

    public String getKm() {
        return km;
    }

    public String getLeistung() {
        return leistung;
    }

    public String getPreis() {
        return preis;
    }

    public String getKraftstoff() {
        return kraftstoff;
    }

    public String getSchlatung() {
        return schlatung;
    }

    public String getUnfall() {
        return unfall;
    }

    public String toString(){

        return "Auto:\t\t"+this.name+
                "\nOrt:\t\t"+this.ort+
                "\nKm:\t\t\t"+this.km+
                "\nArt:\t\t"+this.art+
                "\nAnbieter:\t"+this.anbieter+
                "\nEZ:\t\t\t"+this.ez+
                "\nHU:\t\t\t"+this.hu+
                "\nLeistung:\t"+this.leistung+
                "\nKraftstoff:\t"+this.kraftstoff+
                "\nSchaltung:\t"+this.schlatung+
                "\nUnfall:\t\t"+this.unfall+
                "\nExtras: \n"+this.extras+
                "\n\n\nPreis:\t\t"+this.preis;
    }


    @Override
    public int compareTo(Auto o) {
        return this.ez.compareTo(o.getEz());
    }
}

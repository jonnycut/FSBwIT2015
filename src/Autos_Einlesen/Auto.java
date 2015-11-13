package Autos_Einlesen;

import java.util.Comparator;
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

       String ret = "<html>";

        ret += "<br>"+
                    "Auto:\t\t"+this.name+
                    "<br>Ort:\t\t"+this.ort+
                    "<br>Km:\t\t\t"+this.km+
                    "<br>Art:\t\t"+this.art+
                    "<br>Anbieter:\t"+this.anbieter+
                    "<br>EZ:\t\t\t"+this.ez+
                    "<br>HU:\t\t\t"+this.hu+
                    "<br>Leistung:\t"+this.leistung+
                    "<br>Kraftstoff:\t"+this.kraftstoff+
                    "<br>Schaltung:\t"+this.schlatung+
                    "<br>Unfall:\t\t"+this.unfall+
                    "<br>Extras: \n"+this.extras+
                    "<br><br><br>Preis:\t\t"+this.preis+
                    "<br>______________________________<br>";
        ret += "</html>";

        return ret;
    }


    @Override
    public int compareTo(Auto o) {

        return this.ez.compareTo(o.getEz());
    }

    public final static Comparator<Auto> SORT_NAME = new Comparator<Auto>() {
        @Override
        public int compare(Auto o1, Auto o2) {
            if(o1 == null && o2 == null) return 0;
            if(o1 == null) return 1;
            if(o2 == null) return -1;

            return o1.name.compareTo(o2.name);
        }
    };

    public static final Comparator<Auto> SORT_NAME_AUF = new Comparator<Auto>() {
        @Override
        public int compare(Auto o1, Auto o2) {
            if(o2 == null && o1 == null) return 0;
            if(o1 == null) return -1;
            if(o2 == null) return 1;

            return o2.name.compareTo(o1.name);
        }
    };

   /* public static final Comparator<Auto> SORT_PREIS = new Comparator<Auto>() { --> Strings, die Zahlen sind, müssen noch in INT geparsed werden
        @Override
        public int compare(Auto o1, Auto o2) {
            if(o1 == null && o2 == null) return 0;
            if(o1 == null) return 1;
            if(02 == null) return -1;

            return o1.preis - o2.preis;
        }
    };*/

}

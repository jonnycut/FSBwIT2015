package Kalender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KNapret on 28.01.2016.
 */
public class Termin implements Comparable<Termin> {

    private Date startzeit;
    private Date endzeit;
    private String beschreibung;


    public Termin (String start, String end, String text){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh,mm");

        try {
            this.startzeit = dateFormat.parse(start);
            this.endzeit = dateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.beschreibung = text;


    }


    public Date getStartzeit(){
        return this.startzeit;
    }

    public Date getEndzeit(){
        return this.endzeit;
    }

    public String getBeschreibung(){
        return this.beschreibung;
    }




    @Override
    public int compareTo(Termin o) {
        return this.startzeit.compareTo(o.getStartzeit());
    }
}

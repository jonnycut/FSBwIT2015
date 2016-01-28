package Kalender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by KNapret on 28.01.2016.
 */
public class Termin {

//    private Date startzeit;
//    private Date endzeit;
    private String beschreibung;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh,mm");

    public Termin (String text){

            this.beschreibung = text;

//        try {
//            this.startzeit = dateFormat.parse(start);
//
//        } catch (ParseException e) {
//            this.startzeit=null;
//        }
//        try {
//            this.endzeit = dateFormat.parse(end);
//        } catch (ParseException e){
//            this.endzeit = null;
//        }

        this.beschreibung = text;


    }


//    public Date getStartzeit(){
//        return this.startzeit;
//    }
//
//    public Date getEndzeit(){
//        return this.endzeit;
//    }
//
//    public String getBeschreibung(){
//        return this.beschreibung;
//    }
//
    public String toString(){

        return beschreibung;
    }




//    @Override
//    public int compareTo(Termin o) {
//        return this.startzeit.compareTo(o.getStartzeit());
//    }
}

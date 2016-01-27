package Gui_2016.KlausurUebung_Januar;

import javax.swing.*;

/**
 * Created by JonnyCut on 27.01.2016.
 */
public class MyLabel extends JLabel {

    private String termin;

    public MyLabel(String beschriftung){
        super(beschriftung);
    }


    public void setTermin(String text){

        this.termin = text+"\b";
    }

    public String getTermin(){
        return termin;
    }
}

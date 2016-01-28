package Kalender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Collections;

/**
 * Created by JonnyCut on 27.01.2016.
 */
public class MyLabel extends JLabel {

    private Termin[] termine = new Termin[1];

    public MyLabel(String beschriftung){
        super(beschriftung);
    }


    public void addTermin(String text){

        termine[0]= new Termin(text);
    }

    public void eraseTermine(){

        termine[0]=null;
    }

    public Termin getTermin(){
        return termine[0];
    }

}

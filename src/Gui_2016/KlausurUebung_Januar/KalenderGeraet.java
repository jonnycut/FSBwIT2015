package Gui_2016.KlausurUebung_Januar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.spi.CalendarDataProvider;

/**
 * Created by JonnyCut on 26.01.2016.
 */
public class KalenderGeraet {
    private JFrame window;
    private JPanel inhalt;
    private JButton berechne;
    private JTextField datum;
    private JLabel tag;
    private JLabel woche;

    private JLabel startWoche;
    private JLabel endWoche;

    private JLabel ersterTag;
    GregorianCalendar cal = new GregorianCalendar();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");



    public KalenderGeraet() {

        this.window = new JFrame("Kalender Rechner");
        this.inhalt = new JPanel(new FlowLayout());
        this.datum = new JTextField(10);
        this.tag = new JLabel();
        this.woche = new JLabel();
        this.startWoche = new JLabel();
        this.endWoche = new JLabel();
        this.ersterTag = new JLabel();
        this.berechne = new JButton("Berechne");

        berechne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                berechneDatum();

            }
        });

        inhalt.add(datum);
        inhalt.add(berechne);
        inhalt.add(tag);
        inhalt.add(woche);
        inhalt.add(startWoche);
        inhalt.add(endWoche);
        inhalt.add(ersterTag);

        window.add(inhalt);

        datum.setText(dateFormat.format(cal.getTime()));



        woche.setText("Wochen Nr");



        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        berechneDatum();

        window.setVisible(true);








    }//end constructor

    private void berechneDatum(){

        String[] days = {"Sonntag","Montag","Dienstag","Mittwoch", "Donnerstag","Freitag","Samstag"};

        try {
            cal.setTime(dateFormat.parse(datum.getText()));
            int tagInt = cal.get(Calendar.DAY_OF_WEEK);

            tag.setText(days[tagInt-1]);
            woche.setText(cal.get(Calendar.WEEK_OF_YEAR) + ". Kw");


            cal.set(Calendar.DAY_OF_WEEK, 2);

            startWoche.setText(dateFormat.format(cal.getTime()) + "");

            cal.set(Calendar.DAY_OF_WEEK, 1);

            endWoche.setText(dateFormat.format(cal.getTime()) + "");

            cal.set(Calendar.WEEK_OF_YEAR,1);


            ersterTag.setText(cal.get(Calendar.MONTH)+"");






        }catch (ParseException p){

            JOptionPane.showMessageDialog(window, "Falsches Format! Bitte TT.MM.YYYY eingeben","Falsches Format", JOptionPane.WARNING_MESSAGE);

        }
        window.pack();




    }
}

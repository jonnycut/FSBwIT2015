package Gui_2016.datumRechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by KNapret on 19.01.2016.
 */
public class DatumRechner {

    private JFrame window;
        private JPanel wrapper;
            private JTextField eingabe;
            private JTextArea ausgabe;
            private JButton berechnen;



    public DatumRechner(){

        window = new JFrame();
        wrapper = new JPanel(new FlowLayout());
        eingabe = new JTextField(15);


        ausgabe = new JTextArea(1,15);
        berechnen = new JButton("Berechnen");

        berechnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String pufferEingabe = eingabe.getText();

                if(pufferEingabe.matches("(([0-2][0-9])|([3][0|1]))\\.(([0][1-9])|([1][0-2]))\\.\\d{1,4}")) {

                    berechneDatum(pufferEingabe);

                }else{

                    ausgabe.setText("Format TT.MM.JJJJ eingeben");


                }







            }
        });

        wrapper.add(eingabe);
        wrapper.add(ausgabe);
        wrapper.add(berechnen);

        window.add(wrapper, BorderLayout.CENTER);

        window.pack();

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setVisible(true);

    }



    private void berechneDatum(String eingabe){


        String[] datum = eingabe.split("\\.");

        GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(datum[2]),Integer.parseInt(datum[1])-1,Integer.parseInt(datum[0]));

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch(day){

            case GregorianCalendar.MONDAY:
                ausgabe.setText("Montag");
                break;
            case GregorianCalendar.TUESDAY:
                ausgabe.setText("Dienstag");
                break;
            case GregorianCalendar.WEDNESDAY:
                ausgabe.setText("Mittwoch");
                break;
            case GregorianCalendar.THURSDAY:
                ausgabe.setText("Donnerstag");
                break;
            case GregorianCalendar.FRIDAY:
                ausgabe.setText("Freitag");
                break;
            case GregorianCalendar.SATURDAY:
                ausgabe.setText("Samstag");
                break;
            case GregorianCalendar.SUNDAY:
                ausgabe.setText("Sonntag");
                break;
            default:
                ausgabe.setText("Kein datum gefunden");

        }


        }





}

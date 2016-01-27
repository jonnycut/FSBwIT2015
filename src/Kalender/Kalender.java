package Kalender;

import Gui_2016.KlausurUebung_Januar.MyLabel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by JonnyCut on 27.01.2016.
 */
public class Kalender {
    private int groesse = 700;
    private GregorianCalendar calendar = new GregorianCalendar();

    private SimpleDateFormat tag  = new SimpleDateFormat("EEEEEEEEE");
    private SimpleDateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat monat = new SimpleDateFormat("MMMMMMM");
    private SimpleDateFormat jahr = new SimpleDateFormat("y");
    private JFrame window = new JFrame("Kurrys Kalender");

    private JButton prev = new JButton("zurück");
    private JLabel month = new JLabel();
    private JLabel year = new JLabel();
    private JButton next = new JButton("vor");
    private JPanel oben = new JPanel(new GridLayout(1,3));
    private JPanel inhalt = new JPanel(new GridLayout(5,7));


    public Kalender() {

        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.get(Calendar.MONTH));

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthDown();
                fillCal();

            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthUp();
                fillCal();
            }
        });

        oben.add(prev);
        oben.add(month);
        oben.add(year);
        oben.add(next);


        window.add(oben, BorderLayout.NORTH);

        fillCal();

        window.setSize(groesse, groesse);
        window.setVisible(true);

    }
        public void fillCal(){

            window.remove(inhalt);


            inhalt = new JPanel(new GridLayout(5,7));

            int maxDays =  calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            month.setText(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMAN));
            month.setHorizontalAlignment(SwingConstants.CENTER);
            year.setText(jahr.format(calendar.getTime()));
            year.setHorizontalAlignment(SwingConstants.CENTER);


            for(int i=0; i< maxDays;i++){

                MyLabel temp = new MyLabel(calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT,Locale.GERMAN));
                temp.setBorder(new LineBorder(Color.black));
                temp.setBackground(Color.gray);
                temp.setOpaque(true);
                temp.setHorizontalAlignment(SwingConstants.CENTER);
                this.inhalt.add(temp);

                if(calendar.get(Calendar.DAY_OF_MONTH)!=maxDays)
                 calendar.add(Calendar.DAY_OF_MONTH,1);
            }

            for(int i = maxDays; i <35;i++){
                this.inhalt.add(new JLabel());
            }

            window.add(inhalt);





        window.add(inhalt, BorderLayout.CENTER);

        }

    public void monthUp(){
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);

    }

    public void monthDown(){

        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH, -1);
    }

    }


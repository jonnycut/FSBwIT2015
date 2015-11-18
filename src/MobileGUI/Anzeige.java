package MobileGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;


/**
 * Created by dfleuren on 09.11.2015.
 */
public class Anzeige implements ActionListener{

    JFrame box;
    JPanel bottom;
    JButton startSort;
    JButton exit;
    JMenuBar menuBar;
    JMenu sortBy;
    JMenu name;
    JMenu preis;
    JMenu ez;
    JRadioButtonMenuItem nameAuf;
    JRadioButtonMenuItem nameAb;
    JRadioButtonMenuItem preisAuf;
    JRadioButtonMenuItem preisAb;
    JRadioButtonMenuItem ezAuf;
    JRadioButtonMenuItem ezAb;
    ButtonGroup buttonGroup;
    JList<Auto> jListAutos;
    JScrollPane scrollListe;
    DefaultListModel<Auto> model;
    List<Auto> speicherAuto;


    public Anzeige(){

        this.box = new JFrame("Mobile.de");
        this.bottom = new JPanel();
        this.startSort = new JButton("Starte Sortierung");
        this.exit = new JButton("Exit");
        this.sortBy = new JMenu("Sortiere nach");
        this.menuBar = new JMenuBar();
        this.name = new JMenu("Name");
        this.preis = new JMenu("Preis");
        this.ez = new JMenu("EZ");
        this.nameAuf = new JRadioButtonMenuItem("Aufsteigend");
        this.nameAb = new JRadioButtonMenuItem("Absteigend");
        this.preisAuf = new JRadioButtonMenuItem("Aufsteigend");
        this.preisAb = new JRadioButtonMenuItem("Absteigend");
        this.ezAuf = new JRadioButtonMenuItem("Aufsteigend");
        this.ezAb = new JRadioButtonMenuItem("Absteigend");
        this.model = new DefaultListModel<>();
        this.buttonGroup = new ButtonGroup();





        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonGroup.add(nameAb);
        buttonGroup.add(nameAuf);
        buttonGroup.add(preisAb);
        buttonGroup.add(preisAuf);
        buttonGroup.add(ezAb);
        buttonGroup.add(ezAuf);


        name.add(nameAuf);
        name.add(nameAb);

        preis.add(preisAuf);
        preis.add(preisAb);

        ez.add(ezAuf);
        ez.add(ezAb);

        sortBy.add(name);
        sortBy.add(preis);
        sortBy.add(ez);
        menuBar.add(sortBy);

        box.setJMenuBar(menuBar);


    }

    public void baueAnzeige(List<Auto> autos){

        this.speicherAuto = autos;
        this.jListAutos = new JList<>(model);

        for(Auto a : autos){
            model.addElement(a);
        }

        this.scrollListe = new JScrollPane(jListAutos);


        box.add(scrollListe, BorderLayout.CENTER);
        bottom.add(startSort);
        bottom.add(exit);
        box.add(bottom, BorderLayout.SOUTH);

        startSort.addActionListener(this);
        exit.addActionListener(this);



        box.setSize((int) jListAutos.getPreferredSize().getWidth() + 50, 500);
        box.setLocationRelativeTo(null);
        box.setVisible(true);






    }

    public void reFresh (){


        model.removeAllElements();
        for(Auto a:speicherAuto) {
            model.addElement(a);
        }
        box.isAlwaysOnTop();



    }




    @Override
    public void actionPerformed(ActionEvent e) {
        JButton temp = (JButton) e.getSource();

        if(temp.getText().equalsIgnoreCase("exit"))
            System.exit(0);

        if(nameAuf.isSelected()){
            Collections.sort(speicherAuto, Auto.SORT_NAME);

        }else if(nameAb.isSelected()){
            Collections.sort(speicherAuto,Auto.SORT_NAME_RE);

        }else if(preisAuf.isSelected()){
            Collections.sort(speicherAuto,Auto.SORT_PREIS);

        }else if(preisAb.isSelected()){
            Collections.sort(speicherAuto,Auto.SORT_PREIS_RE);

        }else if(ezAuf.isSelected()){
            Collections.sort(speicherAuto,Auto.SORT_EZ);

        }else if(ezAb.isSelected()){
            Collections.sort(speicherAuto,Auto.SORT_EZ_RE);
        }

        reFresh();




    }
}
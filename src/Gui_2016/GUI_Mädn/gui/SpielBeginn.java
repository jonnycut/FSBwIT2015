package Gui_2016.GUI_Mädn.gui;

import Gui_2016.GUI_Mädn.images.Images;
import Gui_2016.GUI_Mädn.model.Farbe;
import Gui_2016.GUI_Mädn.model.Spiel;
import Gui_2016.GUI_Mädn.model.Spieler;
import sun.security.provider.ConfigFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * Created by JonnyCut on 19.01.2016.
 */
public class SpielBeginn extends JDialog {


    private Spieler[] startAufstellung = new Spieler[4];
    private JButton weiter = new JButton("WEITER");
    private int groesse = 320;
    private HashMap<DragLable, Spieler> zuordnung = new HashMap<>();


    public SpielBeginn(){

        super((JFrame) null, "Mensch ärgere dich nicht SpielBeginn", true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                startAufstellung = null;
                setVisible(false);
            }
        });


        JPanel oben = new JPanel(new GridLayout(2,1));
        oben.add(new JLabel("Ziehen Sie die Figuren an", JLabel.CENTER));
        oben.add(new JLabel("die gewünschte Startposition", JLabel.CENTER));
        this.add(oben, BorderLayout.NORTH);

        JPanel mitte = new JPanel(null);


        //figuren bauen und in das mittepanel schieben


        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                DragLable dl = (DragLable) e.getSource();

                for (int i = 0; i<4; i++){
                    if(startAufstellung[i]==zuordnung.get(dl))
                        startAufstellung[i] = null;
                }

                //prüfen b dl außerhalb des Fensters

                if (dl.getX() < -dl.getWidth() / 2 || dl.getY() < -dl.getHeight() / 2 || dl.getX() > groesse - dl.getWidth() / 2 || dl.getY() > groesse - dl.getHeight() / 2) { //figur draussen
                    dl.setLocation(groesse / 2, groesse / 2);
                } else if (dl.getX() < dl.getWidth() && dl.getY() < dl.getHeight()) { //oben lks
                    if(startAufstellung[0]==null) {
                        startAufstellung[0] = zuordnung.get(dl);
                        dl.setLocation(0, 0);
                    }
                }else if(dl.getX()>groesse-dl.getWidth()*2 && dl.getY()<dl.getHeight()){ //oben rechts
                    if(startAufstellung[1]==null) {
                        startAufstellung[1] = zuordnung.get(dl);
                        dl.setLocation(groesse - dl.getWidth(), 0);
                    }
                }else if(dl.getX()>groesse-dl.getWidth()*2 && dl.getY()>groesse-dl.getHeight()*2){ //unten rechts
                    if(startAufstellung[2]==null) {
                        startAufstellung[2] = zuordnung.get(dl);
                        dl.setLocation(groesse - dl.getWidth(), groesse - dl.getHeight());
                    }
                }else if(dl.getX()< dl.getWidth() && dl.getY()>groesse-dl.getHeight()*2){ //unten lks
                    if(startAufstellung[3]==null) {
                        startAufstellung[3] = zuordnung.get(dl);
                        dl.setLocation(0, groesse - dl.getHeight());
                    }
                }


                int counter = 0;
                for(Spieler s: startAufstellung){
                    if (s != null)
                        counter++;
                }
                weiter.setEnabled(counter>1);


            }
        };



        DragLable dl = new DragLable(Images.FIGUR_ROT);
        dl.addMouseListener(ma);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2, groesse / 2);
        mitte.add(dl);
        zuordnung.put(dl, new Spieler(Farbe.ROT));

        dl = new DragLable(Images.FIGUR_BLAU);
        dl.addMouseListener(ma);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2, groesse / 2 - dl.getHeight()); //die hoehe des Draglabels wird abgezogen, damit die Figuren nicht übereinander stehen
        mitte.add(dl);
        zuordnung.put(dl, new Spieler(Farbe.BLAU));

        dl = new DragLable(Images.FIGUR_GELB);
        dl.addMouseListener(ma);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2 - dl.getWidth(), groesse / 2);
        mitte.add(dl);
        zuordnung.put(dl, new Spieler(Farbe.GELB));

        dl = new DragLable(Images.FIGUR_GRUEN);
        dl.addMouseListener(ma);
        dl.setSize(dl.getPreferredSize());
        dl.setLocation(groesse / 2 - dl.getWidth(), groesse / 2 - dl.getHeight());
        mitte.add(dl);
        zuordnung.put(dl, new Spieler(Farbe.GRUEN));





        JLabel jL = new JLabel(Images.KREIS_GRAU);
        jL.setSize(jL.getPreferredSize());
        jL.setLocation(0, 0);
        mitte.add(jL);


        jL = new JLabel(Images.KREIS_GRAU);
        jL.setSize(jL.getPreferredSize());
        jL.setLocation(0, groesse - jL.getWidth());
        mitte.add(jL);

        jL = new JLabel(Images.KREIS_GRAU);
        jL.setSize(jL.getPreferredSize());
        jL.setLocation(groesse - jL.getHeight(), 0);
        mitte.add(jL);

        jL = new JLabel(Images.KREIS_GRAU);
        jL.setSize(jL.getPreferredSize());
        jL.setLocation(groesse - jL.getHeight(), groesse - jL.getWidth());
        mitte.add(jL);

        mitte.setPreferredSize(new Dimension(groesse,groesse));

        add(mitte);









        //weiterButton bauen
        weiter.setEnabled(false);
        weiter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        this.add(weiter, BorderLayout.SOUTH);
        pack();
        setVisible(true);


    }//end constructor

    public Spieler[] getStartaufstellung(){

        return this.startAufstellung;
    }





}

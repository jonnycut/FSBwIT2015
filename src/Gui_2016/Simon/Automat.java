package Gui_2016.Simon;

import Misc_2015.Autos_Einlesen.Auto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JonnyCut on 23.02.2016.
 */
public class Automat {

    private JButton[] buttons;
    private int pos = 0;
    private int zustand = 1;
    private List<JButton> farben = new ArrayList<>();
    private JPanel panel;

    public Automat(JPanel panel, JButton[] buttons){
        this.panel = panel;
        this.buttons = buttons;
    }

    public void schalten(ActionEvent e){

        switch (zustand){

            case 1:
                ((CardLayout)panel.getLayout()).show(panel,"Spiel");
                zustand = 2;
                farben.add(buttons[(int)(Math.random()*4)]);
                schalten(null);

                break;

            case 2:
                if(e!=null) break;
                new Thread() {
                    public void run() {

                        try{
                            Thread.sleep(1000);
                        } catch (InterruptedException e1){}

                        for(JButton jb : farben){

                            Icon temp = jb.getIcon();
                            //Color c = jb.getBackground();
                            System.out.println(jb.getName());

                            String bild = "src/Gui_2016/Simon/on_"+jb.getName();

                            System.out.println(bild);
                            jb.setIcon(new ImageIcon(bild));
                            //setze hellere Farbe
                            //jb.setBackground(new Color(c.getRGB()|0x808080));

                            try{
                                Thread.sleep(500);
                            } catch (InterruptedException e1){}


                            jb.setIcon(temp);
                            //jb.setBackground(c);

                            try{
                                Thread.sleep(1000);
                            } catch (InterruptedException e1){}

                        }//end for
                        zustand=3;
                        ((CardLayout)panel.getLayout()).show(panel,"Lösen");

                    }
                }.start();

                break;

            case 3:

                ((CardLayout)panel.getLayout()).show(panel,"Spiel");
                zustand=4;
                break;

            case 4:

                if(e.getSource() != farben.get(pos)){
                    zustand = 1;
                    farben.clear();
                    JOptionPane.showMessageDialog(panel, "Leider verloren...", "VERLOREN", JOptionPane.WARNING_MESSAGE);
                            ((CardLayout) panel.getLayout()).show(panel, "Start");
                } else if ( pos < farben.size()-1){
                    pos++;
                } else {
                    zustand = 1;
                    pos =0;
                    JOptionPane.showMessageDialog(panel,"Gewonnen","Glückwunsch",JOptionPane.INFORMATION_MESSAGE);
                            ((CardLayout) panel.getLayout()).show(panel, "Start");
                }







                break;
        }//end switch
    } //end Schalten







}



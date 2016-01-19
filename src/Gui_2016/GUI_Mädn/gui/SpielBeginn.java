package Gui_2016.GUI_Mädn.gui;

import Gui_2016.GUI_Mädn.model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by JonnyCut on 19.01.2016.
 */
public class SpielBeginn extends JDialog {


    private Spieler[] startAufstellung = new Spieler[4];
    private JButton weiter = new JButton("WEITER");


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

    public Spieler[] getStartAufstellung(){

        return this.startAufstellung;
    }





}

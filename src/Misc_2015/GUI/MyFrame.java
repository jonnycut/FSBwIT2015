package Misc_2015.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by KNapret on 03.11.2015.
 */
public class MyFrame extends JFrame {

    public MyFrame(String titel, String inhalt, int JLableAlignment,double textSize, Color JLableColor, Color JLableBackGround){

        this.setTitle(titel);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        JLabel text = new JLabel(inhalt);
        text.setHorizontalAlignment(JLableAlignment);
        text.setForeground(JLableColor);
        text.setFont(text.getFont().deriveFont((float)textSize));
        text.setBackground(JLableBackGround);
        text.setOpaque(true);

        this.add(text);
        /*
        Position des Fensters:
        .setLocation(x,y);
        .setBounds(x,y, Breite, Höhe)
        .setLocationRelativeTo(null);--> zentriert

         */
    }
}

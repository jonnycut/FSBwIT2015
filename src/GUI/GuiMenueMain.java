package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by KNapret on 10.11.2015.
 */
public class GuiMenueMain {

    public static void main(String[] args) {

        JFrame box = new JFrame();


        JMenuBar menuBar = new JMenuBar();


        JMenu ansicht = new JMenu("Ansicht");
        menuBar.add(ansicht);

        JMenu bearbeiten = new JMenu("Bearbeiten");
        menuBar.add(bearbeiten);

        JMenu hilfe = new JMenu("?");
        menuBar.add(hilfe);


        JMenuItem normal = new JMenuItem("Normal");
        ansicht.add(normal);

        JMenuItem wissen = new JMenuItem("Wisschenschaftlich");
        ansicht.add(wissen);

        JMenuItem online = new JMenuItem("Online...");
        hilfe.add(online);

        JLabel display = new JLabel("DISPLAY", SwingConstants.CENTER);
        display.setBackground(Color.BLUE);
        display.setOpaque(true);
        box.add(display);





        box.setJMenuBar(menuBar);
        box.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        box.setSize(500, 200);
        box.setVisible(true);




    }
}

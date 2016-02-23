package Gui_2016.Simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KNapret on 23.02.2016.
 */
public class Simon extends JFrame{



    public Simon(){

        super("Simon");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel wrapperPanel = new JPanel(new CardLayout());
        Color[] colors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};
        JButton[] buttons = new JButton[4];

        JPanel startPanel = new JPanel();
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) wrapperPanel.getLayout()).show(wrapperPanel,"spiel");
            }
        });



        startPanel.add(start);



        JPanel buttonPanel = new JPanel();
        for(int i = 0; i<4; i++){

            JButton jb = buttons[i]= new JButton();
            jb.setBackground(colors[i]);
            jb.setContentAreaFilled(false);
            jb.setOpaque(true);
            jb.setPreferredSize(new Dimension(100, 100));

            buttonPanel.add(jb);


        }



        JPanel loesePanel = new JPanel();
        JButton loese = new JButton("Lösen");
        loesePanel.add(loese);


        wrapperPanel.add(startPanel,"start");
        wrapperPanel.add(buttonPanel,"spiel");
        wrapperPanel.add(loesePanel,"löse");




        add(wrapperPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Simon simon = new Simon();
    }
}

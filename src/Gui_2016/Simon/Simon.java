package Gui_2016.Simon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;

/**
 * Created by KNapret on 23.02.2016.
 */
public class Simon extends JFrame{

    private Automat automat;


    public Simon(){

        super("Simon");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel wrapperPanel = new JPanel(new CardLayout());

        Color[] colors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};
        String[] buttonsStart = {"rot_lks_o.png","blau_re_o.png","gelb_lks_u.png","gruen_re_u.png"};
        JButton[] buttons = new JButton[4];

        JPanel startPanel = new JPanel();
        Icon iconStart = new ImageIcon("src/Gui_2016/Simon/start.png");
        JButton start = new JButton(iconStart);
        start.setContentAreaFilled(false);
        start.setPreferredSize(new Dimension(200,200));
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                automat.schalten(e);
            }
        };

        start.addActionListener(actionListener);



        startPanel.add(start);



        JPanel buttonPanel = new JPanel(new GridLayout(2,2));

         for(int i = 0; i<4; i++){

            Icon image = new ImageIcon("src/Gui_2016/Simon/"+buttonsStart[i]);

            JButton jb = buttons[i]= new JButton(image);
            jb.setName(buttonsStart[i]);
            jb.setContentAreaFilled(false);
            jb.setBackground(Color.black);
            jb.setOpaque(true);
            jb.setPreferredSize(new Dimension(220, 220));
            jb.addActionListener(actionListener);

            buttonPanel.add(jb);


        }





      /*  for(int i = 0; i<4; i++){

            JButton jb = buttons[i]= new JButton();
            jb.setBackground(colors[i]);
            jb.setContentAreaFilled(false);
            jb.setOpaque(true);
            jb.setPreferredSize(new Dimension(100, 100));
            jb.addActionListener(actionListener);

            buttonPanel.add(jb);


        }*/





        JPanel loesePanel = new JPanel();
        JButton loese = new JButton("Lösen");
        loese.addActionListener(actionListener);
        loesePanel.add(loese);

        automat = new Automat(wrapperPanel, buttons);

        wrapperPanel.add(startPanel,"Start");
        wrapperPanel.add(buttonPanel,"Spiel");
        wrapperPanel.add(loesePanel,"Lösen");




        add(wrapperPanel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Simon simon = new Simon();
    }
}

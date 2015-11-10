package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KNapret on 10.11.2015.
 */
public class GUIListenerMain     {

    public static void main(String[] args) {

        JFrame box = new JFrame();
        JLabel bg = new JLabel("BackGround",SwingConstants.CENTER);

        bg.setOpaque(true);
        bg.setHorizontalAlignment(SwingConstants.CENTER);


        JButton farbe = new JButton("Change");
        farbe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (bg.getBackground() == Color.RED)
                    bg.setBackground(Color.WHITE);
                else
                    bg.setBackground(Color.red);

            }
        });




        box.add(bg);
        box.add(farbe,BorderLayout.NORTH);

        box.setSize(200, 200);
        box.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        box.setVisible(true);



    }//endMain
}//endClass

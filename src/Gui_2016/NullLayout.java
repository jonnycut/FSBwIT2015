package Gui_2016;

import javax.swing.*;

/**
 * Created by KNapret on 15.01.2016.
 */
public class NullLayout {

    private JFrame window = new JFrame();
    private DragLable pictureA = new DragLable(new ImageIcon("fuYou.jpg"));
    private JPanel jP = new JPanel();


    public void baue_Fenster(){

        window.setLayout(null);
        jP.add(pictureA);


        jP.setSize(500,500);

        window.add(jP);
        window.setSize(500,500);

        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }




}

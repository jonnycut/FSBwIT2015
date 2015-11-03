package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JonnyCut on 03.11.2015.
 */
public class GuiMain {

    public static void main(String[] args) {

        JFrame anzeige = new JFrame("Normaler JFrame");
        anzeige.setSize(200, 200);
        JLabel text1 = new JLabel("HIWEISFENSTER");
        text1.setHorizontalAlignment(JLabel.CENTER);
        anzeige.add(text1);
        anzeige.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //DISPOSE=Programm erst beenden, wenn alle Fenster geschlossen wurden



        MyFrame anzeige2 = new MyFrame("Die ist MEIN Frame!!!!","Das ist mein Text!",JLabel.CENTER,40.00, Color.red, Color.cyan);





        anzeige2.setVisible(true);
        anzeige.setLocationRelativeTo(anzeige2);
        anzeige.setVisible(true);
        anzeige2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}

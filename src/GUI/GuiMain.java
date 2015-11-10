package GUI;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory;
import java.awt.*;

/**
 * Created by JonnyCut on 03.11.2015.
 */
public class GuiMain {

    public static void main(String[] args) {

        //JLabel[] lableList = new JLabel[5];

        JFrame anzeige = new JFrame("Normaler JFrame");



        anzeige.setSize(900, 700);
       /* addLable(anzeige, "NORTH", Color.white, 50, BorderLayout.NORTH);
        addLable(anzeige,"EAST",Color.yellow,50,BorderLayout.EAST);
        addLable(anzeige,"SOUTH",Color.green,50,BorderLayout.SOUTH);
        addLable(anzeige,"WEST",Color.red,50,BorderLayout.WEST);
        addLable(anzeige,"CENTER",Color.gray,50,BorderLayout.CENTER );*/

        addLableNoT(anzeige, new ImageIcon("C:\\Users\\knapret\\Pictures\\Grumpy-cat.jpg"), BorderLayout.CENTER);
        addLableNoT(anzeige, new ImageIcon("C:\\Users\\knapret\\Pictures\\grumpy.jpg"), BorderLayout.SOUTH);
        addLableNoT(anzeige, new ImageIcon("C:\\Users\\knapret\\Pictures\\fuYou.jpg"), BorderLayout.EAST);
        addLableNoT(anzeige, new ImageIcon("C:\\Users\\knapret\\Pictures\\fuYou.jpg"), BorderLayout.WEST);
        addLable(anzeige, "How is SOP?", Color.WHITE, 60, BorderLayout.NORTH);


        JList<String> list = new JList<>();
        


        anzeige.setVisible(true);




        anzeige.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //DISPOSE=Programm erst beenden, wenn alle Fenster geschlossen wurden








        /*MyFrame anzeige2 = new MyFrame("Die ist MEIN Frame!!!!","Das ist mein Text!",JLabel.CENTER,40.00, Color.red, Color.cyan);
        anzeige2.setVisible(true);
        anzeige.setLocationRelativeTo(anzeige2);
        anzeige.setVisible(true);
        anzeige2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);*/


    }

    public static void addLable(JFrame frame,String name, Color color, double textSize,String pos){
        JLabel jL = new JLabel(name,SwingConstants.CENTER);
        jL.setBackground(color);
        jL.setOpaque(true);
        jL.setFont(jL.getFont().deriveFont((float) textSize));


        frame.add(jL, pos);

    }

    public static void addLableNoT(JFrame frame,Icon bild,String pos){
        JLabel jL = new JLabel(bild);
        jL.setIcon(bild);


        jL.setOpaque(true);


        frame.add(jL,pos);

    }
}

package SchiebePuzzle;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by JonnyCut on 17.11.2015.
 */
public class SchiebePuzzle implements ActionListener {
    private static final int XX = 4;
    private static final int YY = 3;
    private JButton[] buttons = new JButton[XX*YY];
    private int lastButton = 0;
    private Icon lastIcon = null;
    private boolean firstClick = true;

    public static void main(String[] args) {

        new SchiebePuzzle();


    }

    public SchiebePuzzle(){
        JFrame jF = new JFrame("SchiebePuzzle");
        jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jF.setLayout(new GridLayout(YY,XX));
        try{
            BufferedImage fuYou = ImageIO.read(new File("fuYou.jpg"));
            int w = fuYou.getWidth();
            int h = fuYou.getHeight();
            for(int y=0; y<YY; y++)
                for(int x=0;x<XX;x++){
                    buttons[y*XX+x] = new JButton(
                            new ImageIcon(fuYou.getSubimage(x*(w/XX),y*(h/YY),w/XX,h/YY))
                    );
                    buttons[y*XX+x].setBorder(new LineBorder(Color.BLACK,1));
                    buttons[y*XX+x].setActionCommand("" + (y * XX + x));
                    buttons[y*XX+x].setName("" + (y * XX + x));
                    buttons[y*XX+x].addActionListener(this);
                    jF.add(buttons[y*XX+x]);
                }

        } catch (IOException e) {
            System.out.println("Bild nicht gefunden!");
        }

        jF.pack();
        jF.setVisible(true);

    }


    private boolean isDone(){

        for(JButton b : buttons){
            if(!b.getName().equals(b.getActionCommand()))
                return false;
        }

        return true;
    };

    private void switchButton(int pos){
        buttons[lastButton].setIcon(buttons[pos].getIcon());
        buttons[pos].setIcon(null);

       String puffer = buttons[pos].getName();
        buttons[pos].setName(buttons[lastButton].getName());
        buttons[lastButton].setName(puffer);
        lastButton = pos;

    };

    private boolean inTouch(int pos){

        return ((pos % XX == lastButton%XX)&&Math.abs(pos/XX-lastButton/XX)<2)||
                ((pos/YY==lastButton/XX)&& Math.abs(pos % XX-lastButton%XX)<2);

    };


    @Override
    public void actionPerformed(ActionEvent e) {

        if(firstClick){
            firstClick = false;
            buttons[0].setIcon(null);
        }
        int pos = Integer.parseInt(e.getActionCommand());
        switchButton(pos);

    }
}

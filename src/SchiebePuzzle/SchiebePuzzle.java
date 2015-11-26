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




public class SchiebePuzzle implements ActionListener {
    private static final int XX = 2;
    private static final int YY = 3;
    private PuzzButton[][] buttons = new PuzzButton[YY][XX];
    private int lastButtonX = 0;
    private int lastButtonY =0;
    private Icon lastIcon = null;
    private boolean firstClick = true;

    public static void main(String[] args) {

        new SchiebePuzzle();


    }

    public SchiebePuzzle(){
        JFrame jF = new JFrame("SchiebePuzzle");
        jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jF.setLayout(new GridLayout(YY,XX)); //ggf zu ändern
        try{
            BufferedImage fuYou = ImageIO.read(new File("fuYou.jpg"));
            int w = fuYou.getWidth();
            int h = fuYou.getHeight();
            for(int y=0; y<YY; y++)
                for(int x=0;x<XX;x++){
                    buttons[y][x] = new PuzzButton(
                            new ImageIcon(fuYou.getSubimage(x*(w/XX),y*(h/YY),w/XX,h/YY))
                    );

                    buttons[y][x].setBorder(new LineBorder(Color.BLACK, 1));
                    buttons[y][x].setActionCommand("" + x + y);
                    buttons[y][x].setName("" + x + y);
                    buttons[y][x].setPosY(y);
                    buttons[y][x].setPosX(x);
                    buttons[y][x].addActionListener(this);
                    jF.add(buttons[y][x]);
                }

        } catch (IOException e) {
            System.out.println("Bild nicht gefunden!");
        }

        jF.pack();
        jF.setVisible(true);

    }


    private boolean isDone(){

        //hint: name wird umgesetzt, deswegen muss entweder name geprüft werden, oder x / y umgesetzt werden.
        for(PuzzButton[] b : buttons){
            for(PuzzButton button : b){
                if(!button.getYX().equals(button.getActionCommand()))
                    return false;
            }

        }

        return true;
    };

    private void switchButton(int posY, int posX){

        if(inTouch(posY,posX)){

            buttons[lastButtonY][lastButtonX].setIcon(buttons[posY][posX].getIcon());
            buttons[posY][posX].setIcon(null);

            String puffer = buttons[posY][posX].getName();
            buttons[posY][posX].setName(buttons[(int) lastButtonY][lastButtonX].getName());
            buttons[lastButtonY][lastButtonX].setName(puffer);

            lastButtonX= posX;
            lastButtonY= posY;
        }


    };

    private boolean inTouch(int posY, int posX){

       if(posY == lastButtonY && (posX -1 == lastButtonX || posX+1 ==lastButtonX)) {
           return true;
       }else if(posX ==lastButtonX && (posY -1 == lastButtonY || posY + 1 ==lastButtonY)){
            return true;
            //wenn y = y dann muss x = x +1 | x-1
           //wenn x = x dann muss y = y+1 | y-1

        }
        return false;


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(firstClick){
            firstClick = false;
            lastIcon = buttons[0][0].getIcon();
            buttons[0][0].setIcon(null);
            for(int i=0;i<10000;i++) {
                int zufallY = (int)((Math.random()*YY)+0);
                int zufallX = (int) ((Math.random()*XX)+0);
                switchButton(zufallY, zufallX);
            }
            //ToDo: unwiederrufbare Operationen vermeiden?
            // funktion klären und abfangen
            /*while(lastButton % XX != 0)
                switchButton(lastButton-1);
            while (lastButton != "00")
                switchButton(lastButton-XX);*/

        }else {
            PuzzButton tmp = (PuzzButton) e.getSource();
             int posY = tmp.getPosY();
             int posX = tmp.getPosX();

            switchButton(posY,posX);
            if(isDone()){
                buttons[0][0].setIcon(lastIcon);
                firstClick = true;
            }




        }

    }
}

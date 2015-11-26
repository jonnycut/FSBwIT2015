package SchiebePuzzle;

import javax.swing.*;

/**
 * Created by JonnyCut on 23.11.2015.
 */
public class PuzzButton extends JButton {

    private int posX;
    private int posY;


    public PuzzButton(Icon icon) {
        super(icon);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {

        this.posX = posX;
    }

    public int getPosY() {

        return posY;
    }

    public String getYX(){

        return "" + posX + posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }




}

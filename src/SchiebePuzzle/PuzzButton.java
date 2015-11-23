package SchiebePuzzle;

import javax.swing.*;

/**
 * Created by JonnyCut on 23.11.2015.
 */
public class PuzzButton extends JButton {

    private int posX;
    private int posY;
    private boolean isLast;
    private int isBorder; // 1 = top;2=right;3=bottom;4=left

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

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setIsLast(boolean isLast) {
        this.isLast = isLast;
    }

    public void setIsBorder(boolean isBorder){
        this.isBorder = isBorder;
    }
    public boolean getIsBorder(){
        return isBorder;
    }



}

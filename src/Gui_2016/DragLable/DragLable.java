package Gui_2016.DragLable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by KNapret on 15.01.2016.
 */
public class DragLable extends JLabel {
    private Point start;

    public DragLable(Icon icon){
        super(icon);
        MouseAdapter ma = new MouseAdapter() {


            @Override
            public void mousePressed(MouseEvent e){
                super.mouseDragged(e);
               start = new Point(e.getLocationOnScreen().x-getLocation().x,e.getLocationOnScreen().y-getLocation().y);
            }

            @Override
            public void mouseDragged(MouseEvent e){
                super.mousePressed(e);
                setLocation(e.getLocationOnScreen().x - start.x,e.getLocationOnScreen().y - start.y);
            }

        };

        this.addMouseListener(ma);
        this.addMouseMotionListener(ma);
    }
}

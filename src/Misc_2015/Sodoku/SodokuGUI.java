package Misc_2015.Sodoku;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by KNapret on 24.11.2015.
 */
public class SodokuGUI {
    private JFrame mainWindow_F;
    private JPanel headLine_P;
    private JPanel fieldOut_P;

    private JPanel bottomLine_P;
    private JPanel time_P;
    private JButton neu_B;
    private JButton reset_B;


    public SodokuGUI(){

        this.mainWindow_F = new JFrame();
        mainWindow_F.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.headLine_P = new JPanel(new BorderLayout());
        this.fieldOut_P = new JPanel(new GridLayout(3,3));

        this.bottomLine_P = new JPanel(new GridLayout(2,1));


        this.time_P = new JPanel();
        this.neu_B = new JButton("NEU");
        this.reset_B = new JButton("RESET");

        JPanel timeLeft = new JPanel(new FlowLayout());
        JLabel zeit = new JLabel("Zeit:");
        timeLeft.add(zeit);

        JLabel zeitZahl = new JLabel("03:12");
        zeitZahl.setFont(zeitZahl.getFont().deriveFont((float) 30));
        zeitZahl.setForeground(Color.BLUE); //SchriftFarbe
        timeLeft.add(zeitZahl);

        time_P.add(timeLeft);

        headLine_P.add(time_P, BorderLayout.WEST);

        headLine_P.add(neu_B, BorderLayout.EAST);
        mainWindow_F.add(headLine_P, BorderLayout.NORTH);

        fieldOut_P.setBorder(new LineBorder(Color.BLACK, 2));

        for(int i = 0; i <=8;i++){
            JPanel tmpPanel = new JPanel(new GridLayout(3,3));
            tmpPanel.setBorder(new LineBorder(Color.BLACK, 2));
            for(int j =0;j<=8;j++){
                JLabel tempLable = new JLabel();
                tempLable.setBackground(Color.WHITE);
                tempLable.setOpaque(true);
                tempLable.setBorder(new LineBorder(Color.BLACK,1));
                tmpPanel.add(tempLable);
            }

            fieldOut_P.add(tmpPanel);
        }//end


        mainWindow_F.add(fieldOut_P, BorderLayout.CENTER);

        JPanel untenOben = new JPanel(new GridLayout(1,6));

        for(int i = 1; i<=6; i++){
            JButton tmp = new JButton(""+i);
            tmp.setName(""+i);
            tmp.setActionCommand("" + i);

            untenOben.add(tmp);


        }//end add buttons;
        bottomLine_P.add(untenOben);

        JPanel unten_unten = new JPanel(new GridLayout(1,2));

        JPanel bottomPanel_unten_lks = new JPanel(new GridLayout(1,3));

        for(int i=7; i<=9; i++){
            JButton tmp = new JButton(""+i);
            tmp.setName(""+i);
            tmp.setActionCommand("" + i);

            bottomPanel_unten_lks.add(tmp);

        }

        unten_unten.add(bottomPanel_unten_lks);


        JPanel untenRechts = new JPanel(new BorderLayout());
        JButton raddzeFu = new JButton(new ImageIcon("1.jpg"));

        untenRechts.add(raddzeFu, BorderLayout.WEST);
        untenRechts.add(reset_B, BorderLayout.CENTER);
        unten_unten.add(untenRechts);

        bottomLine_P.add(unten_unten);

        mainWindow_F.add(bottomLine_P, BorderLayout.SOUTH);

        mainWindow_F.setSize(900, 1000);


        mainWindow_F.setVisible(true);


    }
}

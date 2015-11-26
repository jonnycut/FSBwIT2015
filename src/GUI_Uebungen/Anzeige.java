package GUI_Uebungen;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KNapret on 26.11.2015.
 */
public class Anzeige implements ActionListener {
    private JFrame anzeige;
            private JMenuBar menuBar;
                private JMenu ansicht;
                        private JRadioButtonMenuItem absteigend;
                        private JRadioButtonMenuItem aufsteigend;
                        private JRadioButtonMenuItem scramble;
                    private JMenu hilfe;
                        private JMenuItem hilfeBut;
        private JPanel topPanel;
        private JPanel content;
        private JPanel bottomLine;
            private JButton exit;


    public Anzeige(){
        this.anzeige = new JFrame();
        anzeige.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.menuBar = new JMenuBar();
                this.ansicht = new JMenu("Ansicht");

                ButtonGroup bg_Ansicht = new ButtonGroup();
                    this.absteigend = new JRadioButtonMenuItem("Absteigend");
                    absteigend.setActionCommand("ab");
                    absteigend.addActionListener(this);

                    this.aufsteigend = new JRadioButtonMenuItem("Aufsteigend");
                    aufsteigend.addActionListener(this);
                    aufsteigend.setActionCommand("auf");

                    this.scramble = new JRadioButtonMenuItem("Scramble");
                    scramble.addActionListener(this);
                    scramble.setActionCommand("scr");

                    bg_Ansicht.add(absteigend);
                    bg_Ansicht.add(aufsteigend);
                    bg_Ansicht.add(scramble);

                this.hilfe = new JMenu("Hilfe");
                    this.hilfeBut = new JMenuItem("?");
                    hilfeBut.setActionCommand("?");
                    hilfeBut.addActionListener(this);

        this.topPanel = new JPanel(new FlowLayout());
        this.content = new JPanel(new GridLayout(3,3));
        this.bottomLine = new JPanel(new GridLayout(1,6));
            this.exit = new JButton("EXIT");
            exit.setActionCommand("exit");
            exit.addActionListener(this);


        buildMenu();
        buildContent();
        buildDisplay();


    }

    private void buildMenu(){

        ansicht.add(absteigend);

        ansicht.add(aufsteigend);

        ansicht.add(scramble);

        hilfe.add(hilfeBut);

        menuBar.add(ansicht);
        menuBar.add(hilfe);
    }

    private void buildContent(){

        //topPanel

        for(int i= 1; i<=4;i++){
            JButton tmpButton =new JButton("topButton "+i);
            tmpButton.setActionCommand("topButton "+i);
            topPanel.add(tmpButton);

        }

        //Content
        for (int i = 1; i<=9;i++){
            JLabel tmpLabel = new JLabel("Feld "+i);
            tmpLabel.setBorder(new LineBorder(Color.BLACK,2));
            content.add(tmpLabel);
        }

        //bottomPanel
        for (int i = 1; i<=5;i++){
            JRadioButton tmpRButton = new JRadioButton("Bottom "+i);
            tmpRButton.setActionCommand("Bottom" +i);
            bottomLine.add(tmpRButton);
        }

        bottomLine.add(exit);

    }

    private void buildDisplay(){

        anzeige.setJMenuBar(menuBar);
        anzeige.add(topPanel, BorderLayout.NORTH);
        anzeige.getContentPane().add(content);
        anzeige.add(bottomLine, BorderLayout.SOUTH);

        anzeige.setSize(500, 500);
        anzeige.setVisible(true);

    }

    private void rebuilContent(String order){

        anzeige.getContentPane().removeAll();
        content.removeAll();

        switch (order){
            case "ab":

                for (int i = 9; i>=1;i--){
                    JLabel tmpLabel = new JLabel("Feld "+i);
                    tmpLabel.setBorder(new LineBorder(Color.BLACK,2));
                    content.add(tmpLabel);
                }
                break;

            case "auf":

                for (int i = 1; i<=9;i++){
                    JLabel tmpLabel = new JLabel("Feld "+i);
                    tmpLabel.setBorder(new LineBorder(Color.BLACK,2));
                    content.add(tmpLabel);
                }
                break;

            case "scr":
                JLabel[] tempArray = new JLabel[9];
                for (int i = 0; i<=8;i++){
                    JLabel tmpLabel = new JLabel("Feld "+(i+1));
                    tmpLabel.setBorder(new LineBorder(Color.BLACK,2));
                    tempArray[i] = tmpLabel;
                }

                for(int i = 0; i <=8;i++){
                    int zufall = (int) ((Math.random()*8)+0);
                    int j = 0;
                    while (tempArray[zufall]==null||j == 8) {
                        zufall++;
                        if (zufall > tempArray.length - 1)
                            zufall = 0;
                    }

                    content.add(tempArray[zufall]);
                    tempArray[zufall] = null;
                }
                break;

            default:
                break;


        }

        anzeige.add(topPanel, BorderLayout.NORTH);
        anzeige.getContentPane().add(content);
        anzeige.add(bottomLine, BorderLayout.SOUTH);
        anzeige.revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch(e.getActionCommand()){

            case "exit":
                System.exit(0);
                break;
            case "auf":
                rebuilContent("auf");
                break;
            case "ab":
                rebuilContent("ab");
                break;

            case "scr":
                rebuilContent("scr");
                break;
            case "?":
                JFrame about = new JFrame();
                JLabel text = new JLabel("Built by Uwe --- FlUwe Ltd.");
                about.add(text);
                about.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                about.setSize(200,200);
                about.setVisible(true);

            default:
                break;

        }

    }
}

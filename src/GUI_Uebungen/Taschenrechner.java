package GUI_Uebungen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by KNapret on 27.11.2015.
 */
public class Taschenrechner {
    private JFrame window;
        private JPanel oben;
            private JTextArea verlauf = new JTextArea(20,4);
            private JScrollPane scrollPane = new JScrollPane(verlauf);

            private JTextField eingabe = new JTextField(10);
        private JPanel bogenmas;
            private JRadioButton deg;
            private JRadioButton rad;
            private JRadioButton grad;

        private JPanel buttons;
        private JPanel pnButtonsNorth;
        private JPanel pnButtonsSouth;

    private ActionListener alZahl = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            eingabe.setText(eingabe.getText() + e.getActionCommand());

        }
    };

    private ActionListener alZeichen = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            verlauf.append(eingabe.getText() + "\n" + e.getActionCommand());

        }
    };

    public Taschenrechner(){

        buildWindow();
    }


    private void buildWindow(){
        this.window = new JFrame("Taschenrechner");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.oben = new JPanel(new BorderLayout());
        oben.add(scrollPane, BorderLayout.NORTH);
        oben.add(eingabe, BorderLayout.CENTER);
        window.add(oben,BorderLayout.NORTH);




        this.bogenmas = new JPanel(new FlowLayout(FlowLayout.CENTER));

        this.deg = new JRadioButton("deg");
        deg.setSelected(true);
        this.rad = new JRadioButton("rad");
        this.grad = new JRadioButton("grad");

        ButtonGroup bogen = new ButtonGroup();
        bogen.add(deg);
        bogen.add(rad);
        bogen.add(grad);


        bogenmas.add(deg);
        bogenmas.add(rad);
        bogenmas.add(grad);

        window.add(bogenmas);
        this.buttons = new JPanel(new BorderLayout());


        this.pnButtonsNorth = new JPanel(new FlowLayout());
        pnButtonsNorth.add(baueButton("wurzel"));
        pnButtonsNorth.add(baueButton("clear"));



        this.pnButtonsSouth = new JPanel(new GridLayout(3,5));

        String[] buttonsArr = {"7","8","9","+","-","4","5","6","*","/","1","2","3","="};

        for(String b: buttonsArr){
            pnButtonsSouth.add(baueButton(b));

        }

        buttons.add(pnButtonsNorth,BorderLayout.NORTH);
        buttons.add(pnButtonsSouth, BorderLayout.SOUTH);

        window.add(buttons, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);

    }






















    private JButton baueButton(String text){

        JButton tmp = new JButton(text);
        tmp.setActionCommand(text);
        tmp.setFont(tmp.getFont().deriveFont((float)30));

        if(text.matches("[0-9]")){
            tmp.addActionListener(alZahl);
            tmp.setActionCommand(text);
        }else if (text.matches("[+\\-*]")){
            tmp.addActionListener(alZeichen);
            tmp.setActionCommand(text);

        }if (text.equals("clear")){
            tmp.setForeground(Color.RED);
        }
         return tmp;

    }
}

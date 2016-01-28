package Kalender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JonnyCut on 27.01.2016.
 */
public class MyLabel extends JLabel {

    private String termin;

    public MyLabel(String beschriftung){
        super(beschriftung);
    }


    public void setTermin(String text){

        this.termin = text+"\b";
    }

    public String getTermin(){
        return termin;
    }

    public void showAgenda(){



        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JTextArea agenda = new JTextArea(10,10);
        agenda.setText(termin);
        window.add(agenda, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(1,2));

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() instanceof JButton){
                    if(((JButton) e.getSource()).getText().equals("CLOSE")){
                        window.setVisible(false);
                    }else if(((JButton) e.getSource()).getText().equals("Save")){

                        termin = agenda.getText();
                        window.setVisible(false);

                    } else {

                    }
                }
            }
        };

        JButton close = new JButton("CLOSE");
        close.addActionListener(al);

        JButton save = new JButton("Save");
        save.addActionListener(al);

        buttons.add(close);
        buttons.add(save);

        window.add(buttons, BorderLayout.SOUTH);
        window.pack();

        window.setVisible(true);



    }
}

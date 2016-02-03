package Kalender;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by JonnyCut on 28.01.2016.
 */
public class PopUp {

    private Termin termin;

    private MyLabel tag;
    private JFrame window;
    private JPanel oben;
    private JLabel day;
    private JLabel month;
    private JLabel year;

    private JScrollPane scrollPane;
    private JTextArea agenda;

    public PopUp(final MyLabel tag,String monat, String jahr ){
        this.tag = tag;
        this.day= new JLabel(tag.getText());
        this.month = new JLabel(monat);
        this.year = new JLabel(jahr);
        this.termin = tag.getTermin();
        if(termin==null)
            termin = new Termin("");

        this.window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.oben = new JPanel();
        oben.add(day);
        oben.add(month);
        oben.add(year);

        window.add(oben,BorderLayout.NORTH);

        this.agenda = new JTextArea(10,10);
        agenda.setText(termin.toString());
        this. scrollPane = new JScrollPane(agenda);
        window.add(scrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(1,3));

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() instanceof JButton){
                    String text = ((JButton) e.getSource()).getText();
                    if(text.equals("CLOSE")){
                        window.dispose();
                    }else if(text.equals("Save")){

                        save();
                        window.dispose();

                    } else if(text.equals("export")){

                        export();

                    }
                }
            }
        };

        JButton close = new JButton("CLOSE");
        close.addActionListener(al);

        JButton save = new JButton("Save");
        save.addActionListener(al);

        JButton export = new JButton("export");
        export.addActionListener(al);

        buttons.add(close);
        buttons.add(save);
        buttons.add(export);

        window.add(buttons, BorderLayout.SOUTH);
        window.pack();

        window.setVisible(true);



    }

    public void save(){
        tag.addTermin(agenda.getText());

    }

    public void export(){

        try (BufferedWriter bR = new BufferedWriter(new FileWriter(tag.getText()+"."+month.getText()+"."+year.getText()+"Export.txt"))) {

            bR.write(tag.getTermin().toString());
            JOptionPane.showMessageDialog(window, "Export erfolgreich", "Export abgeschlossen", JOptionPane.INFORMATION_MESSAGE);




        } catch (IOException e) {
            JOptionPane.showMessageDialog(window,"Fehler beim Schreiben","Schreibfehler",JOptionPane.WARNING_MESSAGE);
        }

    }
}

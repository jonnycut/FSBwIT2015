package GUI_Uebungen;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KNapret on 01.12.2015.
 */
public class GuiList implements ListModel {

    private JFrame window;
    private JScrollPane scrollPane;
    private JList datenListe;
    private JPanel buttons;
    private JButton add;
    private int zahl =1;


    List<Integer> liste = new ArrayList<>();
    List<ListDataListener> ldls = new ArrayList<>();


    public GuiList() {

        baueListe();
        GuiList.this.add(zahl++);
        window.setVisible(true);
    }


    private void baueListe() {

        this.window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.datenListe = new JList(this);

        scrollPane = new JScrollPane(datenListe);


        window.add(scrollPane, BorderLayout.CENTER);

        this.buttons = new JPanel();

        this.add = new JButton("add");
        add.setActionCommand("add");

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiList.this.add(zahl++);
            }
        });

        buttons.add(add);

        window.add(buttons, BorderLayout.SOUTH);


        window.setSize(200, 400);
        window.pack();


    }

    public void add(Integer zahl){
        liste.add(zahl);

        for(ListDataListener l: ldls)
            l.contentsChanged(new ListDataEvent(this,ListDataEvent.CONTENTS_CHANGED,0,liste.size()-1));
    }


    @Override
    public int getSize() {
        return liste.size();
    }

    @Override
    public Object getElementAt(int index) {
        return liste.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

        ldls.add(l);

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

        ldls.remove(l);

    }
}

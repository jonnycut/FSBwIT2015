package GUI_Uebungen;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
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


    List<Integer> liste = new ArrayList<>();
    List<ListDataListener> ldls = new ArrayList<>();


    public GuiList() {

        baueListe();
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

        buttons.add(add);

        window.add(buttons, BorderLayout.SOUTH);

        window.setSize(200, 400);
        window.pack();


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

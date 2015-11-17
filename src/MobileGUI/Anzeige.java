package MobileGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by cjaeschke on 05.11.2015.
 */


/**
 * Created by dfleuren on 09.11.2015.
 */
public class Anzeige {


    public void frame(List<Auto> autos) {
        JFrame box = new JFrame("Auswahl");
        box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultListModel listModel = new DefaultListModel();
        JList<Auto> list = new JList<>(listModel);

        JScrollPane listeSrcoller = new JScrollPane(list);
        box.add(listeSrcoller, BorderLayout.CENTER);

        for (Auto a : autos) {
            listModel.addElement(a.toHTML());
        }

        //box.setSize(600, 500);
        box.setSize((int) list.getPreferredSize().getWidth() + 50, 500);
        box.setLocationRelativeTo(null);
        box.isAlwaysOnTop();
        box.setVisible(true);

    }

    public void frame1(JList<Auto> list) {
        JFrame box = new JFrame("Auswahl");
        box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        box.setSize((int) list.getPreferredSize().getWidth() + 50, 500);
        JScrollPane listeSrcoller = new JScrollPane(list);
        box.add(listeSrcoller, BorderLayout.CENTER);

        box.setLocationRelativeTo(null);
        box.isAlwaysOnTop();
        box.setVisible(true);
    }

    public void menu(JList<Auto> autos){

        JFrame box = new JFrame("Auswahl");
        box.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        box.setSize((int) autos.getPreferredSize().getWidth() + 50, 500);
        JScrollPane listeScroller = new JScrollPane(autos);
        box.add(listeScroller, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu sortBy = new JMenu("Sortieren nach");
        menuBar.add(sortBy);
        box.setJMenuBar(menuBar);

        box.setLocationRelativeTo(null);
        box.isAlwaysOnTop();
        box.setVisible(true);
        //ToDo: MenuEinträge setzen, ActionListener auf sortierung anwenden

    }
}
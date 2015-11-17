package MobileGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by JonnyCut on 17.11.2015.
 */
public class TestGui {

    List<String> stringList = fillList();

    public static void main(String[] args) {

        TestGui gui = new TestGui();



    }

    public TestGui(){
        final DefaultListModel model = new DefaultListModel();

        final JFrame box = new JFrame("Anzeige");
        box.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();
        JMenu sort = new JMenu("Sortierung");
        final JCheckBoxMenuItem ab = new JCheckBoxMenuItem("Absteigend");
        final JCheckBoxMenuItem auf = new JCheckBoxMenuItem("Aufsteigend");
        ButtonGroup group = new ButtonGroup();

        group.add(ab);
        group.add(auf);

        sort.add(ab);
        sort.add(auf);
        menuBar.add(sort);

        JPanel bottom = new JPanel(new FlowLayout());
        JButton go = new JButton("Go");
        JButton exit = new JButton("Exit");

        bottom.add(go);

        box.add(bottom, BorderLayout.SOUTH);


        box.setJMenuBar(menuBar);










        final JList<String> list = new JList<>(model);

        for(String s: stringList) {
            model.addElement(s);
        }
        final JScrollPane scrollList = new JScrollPane(list);
        box.add(scrollList);

        box.setSize(500, 500);
        box.setVisible(true);



        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(auf.isSelected()){

                    box.setVisible(false);
                    Collections.sort(stringList);
                    model.removeAllElements();
                    for(String s: stringList) {
                        model.addElement(s);
                    }
                    box.isAlwaysOnTop();
                    box.setVisible(true);
                }else if(ab.isSelected()){

                    box.setVisible(false);
                    Collections.sort(stringList, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o2.compareTo(o1);
                        }
                    });

                    model.removeAllElements();
                    for(String s: stringList) {
                        model.addElement(s);
                    }
                    box.isAlwaysOnTop();
                    box.setVisible(true);
                }else {
                    JFrame fehler = new JFrame("Fehler");
                    fehler.add(new JLabel("Bitte Sortiermethode wählen"));

                    ;

                    fehler.setSize(250, 250);
                    fehler.setVisible(true);
                }




            }
        };



        go.addActionListener(listener);
    }


    public static List<String> fillList(){
        List<String> liste = new ArrayList<>();


        for(int i = 0;i<1000;i++){

            liste.add(String.valueOf((int)(Math.random()*1000)));

        }

        return liste;

    }

    public static String[] listToArray(List<String> stringList){
        String[] stringArray = new String[stringList.size()];
        int i=0;

        for(String s : stringList){
            stringArray[i] = s;
            i++;
        }

        return stringArray;

    }


}

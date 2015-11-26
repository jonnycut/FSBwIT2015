package GUI_Uebungen;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by JonnyCut on 26.11.2015.
 */
public class EinlesenAnzeige implements ActionListener {
    private JFrame window;
        private JPanel pn_topLine;
            private JPanel pn_datei;
                private JPanel pn_datei_north;
                    private JLabel name;
                    private JTextField tf_dateiName;
                private JPanel pn_Datei_south;
                    private JButton open;
                    private JButton save;

            private JPanel pn_addWord;
                private JPanel pn_addWord_north;
                    private JLabel anzahl;
                    private JTextField tf_wordAdd_Anzahl;
                    private JLabel word;
                    private JTextField tf_wordAdd;
                private JPanel pn_addWord_south;
                    private JButton paste;

            private JPanel pn_deleteWord;
                private JPanel pn_deleteWord_north;
                    private JLabel wordDel;
                    private JTextField tf_wordDel;
                private JPanel pn_deleteWord_south;
                    private JButton delete;

        private JScrollPane content;
            private JTextArea ausgabe;


    public EinlesenAnzeige() {
        this.window = new JFrame("TextEditor");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            this.pn_topLine = new JPanel();
                this.pn_datei = new JPanel(new BorderLayout());

                    this.pn_datei_north = new JPanel(new FlowLayout());
                        this.name = new JLabel("Name:");
                        this.tf_dateiName = new JTextField(20);
                    this.pn_Datei_south = new JPanel(new FlowLayout());
                        this.open = new JButton("Öffnen");
                        open.setActionCommand("open");
                        open.addActionListener(this);

                        this.save = new JButton("Speichern");
                        save.setActionCommand("save");
                        save.addActionListener(this);

                this.pn_addWord = new JPanel(new BorderLayout());
                    this.pn_addWord_north = new JPanel(new FlowLayout());
                        this.anzahl = new JLabel("Anzahl:");
                        this.tf_wordAdd_Anzahl = new JTextField(3);

                        this.word = new JLabel("Wort:");
                        this.tf_wordAdd = new JTextField(10);
                    this.pn_addWord_south = new JPanel();
                        this.paste = new JButton("Einfügen");
                        paste.setActionCommand("paste");
                        paste.addActionListener(this);

            this.pn_deleteWord = new JPanel(new BorderLayout());
                this.pn_deleteWord_north = new JPanel(new FlowLayout());
                    this.wordDel = new JLabel("Wort:");
                    this.tf_wordDel = new JTextField(10);
                this.pn_deleteWord_south = new JPanel();
                    this.delete = new JButton("delete");
                    delete.setActionCommand("delete");
                    delete.addActionListener(this);

            this.ausgabe = new JTextArea();
            this.content = new JScrollPane(ausgabe);


            builtTopLine();
        builtWindow();
            window.setVisible(true);





    }

        private void builtTopLine(){
            pn_datei_north.add(name);
            pn_datei_north.add(tf_dateiName);

            pn_datei.add(pn_datei_north, BorderLayout.NORTH);

            pn_Datei_south.add(open);
            pn_Datei_south.add(save);

            pn_datei.add(pn_Datei_south, BorderLayout.SOUTH);
            pn_datei.setBorder(new TitledBorder("Datei"));

            pn_topLine.add(pn_datei);


            //--------------------------------------ende Datei------------------------------

            pn_addWord_north.add(anzahl);
            pn_addWord_north.add(tf_wordAdd_Anzahl);
            pn_addWord_north.add(word);
            pn_addWord_north.add(tf_wordAdd);

            pn_addWord.add(pn_addWord_north, BorderLayout.NORTH);
            pn_addWord.setBorder(new TitledBorder("Einfügen"));

            pn_addWord_south.add(paste);
            pn_addWord.add(pn_addWord_south,BorderLayout.SOUTH);
            pn_topLine.add(pn_addWord);

            //-------------------------------------ende Wort einfügen-----------------------

            pn_deleteWord_north.add(wordDel);
            pn_deleteWord_north.add(tf_wordDel);

            pn_deleteWord.add(pn_deleteWord_north, BorderLayout.NORTH);

            pn_deleteWord_south.add(delete);
            pn_deleteWord.add(pn_deleteWord_south, BorderLayout.SOUTH);
            pn_deleteWord.setBorder(new TitledBorder("Löschen"));

            pn_topLine.add(pn_deleteWord);

            //------------------------------------ende Wort löschen------------------------





        }
    public void builtWindow(){

        window.add(pn_topLine, BorderLayout.NORTH);

        //content.add(ausgabe);
        window.getContentPane().add(content);
        window.setSize(800, 500);
        //window.pack();



    }





    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){

            case "open":
                try(BufferedReader br = new BufferedReader(new FileReader(tf_dateiName.getText()))) {

                    String zeile ="";
                    StringBuffer text = new StringBuffer();

                    while((zeile = br.readLine()) != null){

                        text.append(zeile);
                        text.append("\n");

                    }
                    ausgabe.setText(text.toString());

                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(window, "Datei nicht gefunden!", "Dateifehler", JOptionPane.ERROR_MESSAGE);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(window, "Fehler beim einlesen!", "Dateifehler", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "save":
                try(BufferedWriter bWr = new BufferedWriter(new FileWriter(tf_dateiName.getText()))){

                    bWr.write(ausgabe.getText());

                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(window, "Fehler beim Speichern!", "Dateifehler", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "paste":

               try {
                   for (int i = Integer.parseInt(tf_wordAdd_Anzahl.getText()); i > 0; i--) {

                       ausgabe.append(tf_wordAdd.getText());

                   }
               } catch (NumberFormatException n) {
                   JOptionPane.showMessageDialog(window, "EINE ZAHL DU HURENSOHN", "SPASTI", JOptionPane.ERROR_MESSAGE);
               }

                break;
            case "delete":
                ausgabe.setText(ausgabe.getText().replaceAll(tf_wordDel.getText(),""));
                break;
            default:
                System.out.println("FUCK U");
                break;






        }


    }


}

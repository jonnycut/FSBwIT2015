package Autos_Einlesen;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by JonnyCut on 20.10.2015.
 */
public class Autos_einlesen {

    public static void main(String[] args) {


        String pfad = "Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_";
        //StringBuilder datenSatz = new StringBuilder();

        List<String> zeilen = new ArrayList<>();
        Set<Auto> autoListe = new HashSet<>();

        String ez = "^(EZ|ez)\\s?([0][1-9]|[1][0-2])[/]\\d{2,4}";
        String hu = "HU\\s*(([0][1-9]|[1][0-2])[/]\\d{4})|neu";
        String anbieter = "([hH]ändler|[pP]rivat.*)";
        String art = "([kK]leinwagen|[cC]abrio[.]*|[kK]ombi|[lL]imousine|[gG]eländewagen[.]*|[sS]portwagen[.]*|[vV]an[.]*|[aA]ndere)";
        String km = "(\\d{1,3}\\.*)?(\\d{1,3})?\\s?[kK][mM].*";
        String leistung = "\\d{1,3} kW \\(\\d{1,3} PS\\).*";
        String preis = ".+\\s?€";
        //String kraftstoff = "([bB]enzin)|([eE]lektro)|([dD]iesel)|([aA]utogas)|([eE]rdgas)|([wW]asserstoff)|([Hh]ybrid)|([Ee]thanol)";
        String schlatung = "([sS]chalt.*|[aA]uto.*)";
        String unfall = ".*[uU]nfall.*";

        String ezA = "keine Angabe";
        String huA = "keine Angabe";
        String anbieterA = "keine Angabe";
        String artA = "keine Angabe";
        String kmA = "-1";
        String leistungA = "keine Angabe";
        String preisA = "keine Angabe";
        String kraftstoffA = "keine Angabe";
        String schaltungA = "keine Angabe";
        String unfallA = "keine Angabe";
        String ortA = "keine Angabe";
        String nameA = "keine Angabe";


        for (int i = 0; i < 32; i++) {
            String datei = pfad + i + ".txt";

            try (BufferedReader br = new BufferedReader(new FileReader(datei))) {
                String zeile;

                while ((zeile = br.readLine()) != null) {
                    zeilen.add(zeile);

                }


            } catch (FileNotFoundException e) {
                System.out.println("File: \"" + datei + "\" not found. Will try " + pfad + (i + 1) + ".txt");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        System.out.println("Einlesen der Dateien beendet...");

        System.out.println("Starte Filtern der Autos....");

        for (int index = 0; index < zeilen.size(); index++) {
            String ort = zeilen.get(index);


            if (ort.matches("^DE( )?-( )?\\d{5}( )?[A-ZÜÄÖ][a-züäö]*")) {

                ortA = zeilen.get(index);
                nameA = zeilen.get(index - 1);
                List<String> extras = new LinkedList<>();
                //datenSatz.append("Ort:\t\t" + zeilen.get(index) + "\n" + "Auto:\t\t" + zeilen.get(index - 1) + "\n");


                for (int i = index + 1; ; i++) {

                    String zeile = zeilen.get(i);
                    if (zeile.startsWith("Finanzierung")) {

                        autoListe.add(new Auto(ezA, huA, anbieterA, artA, kmA, leistungA, preisA, kraftstoffA, schaltungA, unfallA, nameA, ortA, extras));
                        ezA = "keine Angabe";
                        huA = "keine Angabe";
                        anbieterA = "keine Angabe";
                        artA = "keine Angabe";
                        kmA = "-1";
                        leistungA = "keine Angabe";
                        preisA = "keine Angabe";
                        kraftstoffA = "keine Angabe";
                        schaltungA = "keine Angabe";
                        unfallA = "keine Angabe";
                        ortA = "keine Angabe";
                        nameA = "keine Angabe";

                        //datenSatz.append("\n------------------------------------------------------------------\n");
                        break;
                    } else if (zeile.matches(ez)) {
                        ezA = zeile;
                        //datenSatz.append("EZ:\t\t" + zeile + "\n");
                    } else if (zeile.matches(hu)) {
                        huA = zeile;
                        //datenSatz.append("HU:\t\t" + zeile + "\n");
                    } else if (zeile.matches(anbieter)) {
                        anbieterA = zeile;
                        //datenSatz.append("Anbieter:\t" + zeile + "\n");
                    } else if (zeile.matches(art)) {
                        artA = zeile;
                        //datenSatz.append("Art:\t\t" + zeile + "\n");
                    } else if (zeile.matches(km)) {
                        kmA = zeile;
                        //datenSatz.append("Km:\t\t" + zeile + "\n");
                    } else if (zeile.matches(leistung)) {
                        leistungA = zeile.split(",")[0];
                        kraftstoffA = zeile.split(", ")[1];
                        //datenSatz.append("Leistung:\t\t" + zeile + "\n");
                    } else if (zeile.matches(preis)) {
                        preisA = zeile;
                        //datenSatz.append("Preis:\t\t" + zeile + "\n");

                   /* } else if (zeile.matches(kraftstoff)) {
                        kraftstoffA = zeile;
                        datenSatz.append("Kraftstoff:\t" + zeile + "\n");*/

                    } else if (zeile.matches(schlatung)) {
                        schaltungA = zeile;
                        //datenSatz.append("Schaltung:" + zeile + "\n");
                    } else if (zeile.matches(unfall)) {
                        unfallA = zeile;
                        //datenSatz.append("Unfall:\t\t" + zeile + "\n");
                    }else{
                        extras.add(zeile);
                    }

                }
            }

            //System.out.println(datenSatz);


        }

        /*for (Auto a : autoListe) {
            System.out.println(a);
            System.out.println("----------------------------------------------------------------------------------------");
        }*/
        Auto[] autoArray = new Auto[autoListe.size()];
        int i=0;
        for(Auto a : autoListe){

            autoArray[i] = a;
            i++;

        }

        JList<Auto> autoJ = new JList<>(autoArray);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(autoJ);

        JFrame box = new JFrame();
        box.add(scrollPane);
        box.setSize(1000,1000);
        box.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        box.setVisible(true);


    }//end Main
}

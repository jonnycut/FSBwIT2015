package Misc_2015.MobileGUI;

import java.util.List;

        import javax.swing.*;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
import java.util.*;

/**
 * Created by cjaeschke on 19.10.2015.
 */
public class Mobile {



    public static void main(String[] args) {

        List<String> l = findeDateien();
        Anzeige anzeige = new Anzeige();
        anzeige.baueAnzeige(finder(l));

    }

    public static LinkedList<String> findeDateien() {
        String pfadName = "Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\";
        String dateiName = ".txt";
        LinkedList<String> datei = new LinkedList<>();
        File file;
        for (int i = 1; i < 255; i++) {
            dateiName = "Autos_" + i + ".txt";
            file = new File(pfadName + dateiName);
            if (file.exists())
                datei.add(pfadName + dateiName);
        }
        System.out.println("Es wurden " + datei.size() + " Dateien gefunden!\n\n");
        return datei;
    }

    public static List<Auto> finder(List<String> dateien){

        LinkedList<String> con = new LinkedList<>();


        for (String s : dateien) {
            try (BufferedReader br = new BufferedReader(new FileReader(s))) {
                String line = "";
                while ((line = br.readLine()) != null)
                    con.add(line);
            } catch (IOException e) {
                System.out.println("Fehler beihm Lesen . . .");
            }
        }

        List<Auto> autos = new ArrayList<>();

        for (int index = 0; index < con.size(); index++) {
            if (con.get(index).matches("\\w{2,3}\\s-\\s\\d{5}\\s\\w+.*")) {
                List<String> daten = new LinkedList<>();
                index--;
                while (!con.get(index).startsWith("Finanzierung, Versicherung") &&
                        !con.get(index).startsWith("FinanzierungVersicherungParken")) {
                    daten.add(con.get(index));
                    index++;
                }
                Auto tmp = Auto.baueAuto(daten);
                if (tmp != null)
                    autos.add(tmp);
            }
        }


        return autos;
    }

    public static void jlist( List<Auto> autos){
        Auto[] autoArray =  new Auto[autos.size()];
        autos.toArray(autoArray);
        JList<Auto> list = new JList<>(autoArray);
        Anzeige box = new Anzeige();


        //box.frame(autos);
        //box.frame1(list);

    }



    public static void auswahl(List<Auto> autos){

        String auswahl;
        String aufab;




            autos.sort(Auto.SORT_NAME);
            //anzeige.baueAnzeige(autos);



    }

}
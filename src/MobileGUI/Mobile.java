package MobileGUI;

import java.util.List;

        import javax.swing.*;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.lang.reflect.Array;
        import java.util.*;

/**
 * Created by cjaeschke on 19.10.2015.
 */
public class Mobile {

    public static void main(String[] args) {

        List<String> l = findeDateien();
        finder(l);

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

        new Anzeige();
        auswahl(autos);

        return autos;
    }

    public static void jlist( List<Auto> autos){
        Auto[] autoArray =  new Auto[autos.size()];
        autos.toArray(autoArray);
        JList<Auto> list = new JList<>(autoArray);
        Anzeige box = new Anzeige();


        //box.frame(autos);
        //box.frame1(list);
        box.menu(list);
    }



    public static void auswahl(List<Auto> autos){

        String auswahl;
        String aufab;
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("Bitte wählen Sie eine Sortierart.");
            System.out.println("---------------------------------\n");
            System.out.println("(1) Erstzulassung");
            System.out.println("(2) Kilometerstand");
            System.out.println("(3) Preis");
            System.out.println("(4) Namen");
            System.out.println("(x) Exit");


            auswahl = scan.next();

            switch (auswahl) {
                case "1":
                    System.out.println("Es wird nach der Erstzulassung sortiert!\n");
                    System.out.println("(a) Aufsteigend");
                    System.out.println("(b) Absteigend");
                    aufab = scan.next();
                    switch (aufab) {
                        case "a":
                            System.out.println();
                            System.out.println("############################################################\n");
                            autos.sort(Auto.SORT_EZ_RE);
                            jlist(autos);
                            System.out.println("############################################################\n");
                            break;
                        case "b":
                            System.out.println();
                            System.out.println("############################################################\n");
                            autos.sort(Auto.SORT_EZ);
                            jlist(autos);
                            System.out.println("############################################################\n");
                            break;
                        default:
                            System.out.println("Falsche Eingabe\n\n");
                    }
                    break;
                case "2":
                    System.out.println("Es wird nach dem Kilometerstrand sortiert!\n");
                    System.out.println("(a) Aufsteigend");
                    System.out.println("(b) Absteigend");
                    aufab = scan.next();
                    switch (aufab) {
                        case "a":
                            System.out.println("Es wird aufsteigend sortiert!\n");
                            System.out.println("############################################################\n");
                            autos.sort(Auto.SORT_KMSTAND_RE);
                            jlist(autos);
                            System.out.println("############################################################\n");
                            break;
                        case "b":
                            System.out.println("Es wird absteigend sortiert!\n");
                            System.out.println("############################################################\n");
                            autos.sort(Auto.SORT_KMSTAND);
                            jlist(autos);
                            System.out.println("############################################################\n");
                            break;
                        default:
                            System.out.println("Falsche Eingabe\n\n");
                    }
                    break;
                case "3":
                    System.out.println("Es wird nach dem Preis sortiert!\n");
                    System.out.println("(a) Aufsteigend");
                    System.out.println("(b) Absteigend");
                    aufab = scan.next();
                    switch (aufab) {
                        case "a":
                            System.out.println("Es wird aufsteigend sortiert!\n");
                            System.out.println("############################################################\n");
                            autos.sort(Auto.SORT_PREIS_RE);
                            jlist(autos);
                            System.out.println("############################################################\n");
                            break;
                        case "b":
                            System.out.println("Es wird absteigend sortiert!\n");
                            System.out.println("############################################################\n");
                            autos.sort(Auto.SORT_PREIS);
                            jlist(autos);
                            System.out.println("############################################################\n");
                            break;
                        default:
                            System.out.println("Falsche Eingabe\n\n");
                    }
                    break;
                case "x":
                    System.exit(0);
                case "4":
                    System.out.println("Es wird nach Namen sortiert!");
                    System.out.println("############################################################\n");
                    autos.sort(Auto.SORT_NAME);
                    jlist(autos);
                    System.out.println("############################################################\n");
                    break;
                default:
                    System.out.println("Falsche Eingabe\n\n");
            }

        }
    }

}
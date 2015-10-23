import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JonnyCut on 20.10.2015.
 */
public class Autos_einlesen {

    public static void main(String[] args) {


        String pfad ="Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_";
        StringBuilder datenSatz = new StringBuilder();

        List<String> zeilen = new ArrayList<>();

        String ez ="EZ([0][1-9]|[1][0-2])[/]\\d{4}";
        String hu ="HU([0][1-9]|[1][0-2])[/]\\d{4}";
        String anbieter ="([hH]ändler|[pP]rivat)";
        String art="([kK]leinwagen|[cC]abrio[.]*|[kK]ombi|[lL]imousine|[gG]eländewagen[.]*|[sS]portwagen[.]*|[vV]an[.]*|[aA]ndere)";
        String km = "\\d* ([kK][mM])";
        String leistung ="\\d{3} [kKpP][wWsS]";
        String preis = "\\d+ [€]";
        String kraftstoff="([bB]enzin|[dD]iesel)";
        String schlatung="([sS]chalt[.]*|[aA]uto[.]*)";
        String unfall ="([uU]nfall[.]*|)";


        for(int i=0;i<32;i++){
           String datei = pfad + i +".txt";

            try(BufferedReader br = new BufferedReader(new FileReader(datei))){
                String zeile;

                while((zeile = br.readLine()) != null){
                    zeilen.add(zeile);

                }


            } catch (FileNotFoundException e) {
                System.out.println("File: \"" + datei +"\" not found. Will try "+ pfad +(i+1)+".txt");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        System.out.println("Einlesen der Dateien beendet...");

        System.out.println("Starte Filtern der Autos....");

        for (int index=0; index<zeilen.size(); index++) {
            String ort = zeilen.get(index);


            if (ort.matches("[A-Z]{2}[ ]?[-][ ]?\\d+[ ]?[A-Za-zÜÄÖüäöß]?[.]*")) {


                //String name = zeilen.get(index-1);

                datenSatz.append("Ort:"+ zeilen.get(index)+"\n"+"Auto:"+ zeilen.get(index-1)+"\n");
//change



                for (int i=index+1; ;i++) {

                    String zeile = zeilen.get(i);
                    if (zeile.startsWith("Finanzierung, Versicherung"))
                        break;
                    else
                        if(zeile.matches(ez))
                            datenSatz.append("EZ:" + zeile +"\n");
                        if(zeile.matches(hu))
                            datenSatz.append("HU:"+zeile+"\n");
                        if(zeile.matches(anbieter))
                            datenSatz.append("Anbieter:"+zeile+"\n");
                        if(zeile.matches(art))
                            datenSatz.append("Art"+zeile+"\n");
                        if(zeile.matches(km))
                            datenSatz.append("Km:"+zeile+"\n");
                        if(zeile.matches(leistung))
                            datenSatz.append("Leistung"+zeile+"\n");
                        if(zeile.matches(preis))
                            datenSatz.append("Preis:"+zeile+"\n");
                        if(zeile.matches(kraftstoff))
                            datenSatz.append("Kraftstoff:"+zeile+"\n");
                        if(zeile.matches(schlatung))
                            datenSatz.append("Schaltung:"+zeile+"\n");
                        if(zeile.matches(unfall))
                            datenSatz.append("Unfall:"+zeile+"\n");
                }
            }

            System.out.println(datenSatz);
            System.out.println("------------------------------------------------------------------");

        }

    }//end Main
}

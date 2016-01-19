package Misc_2015.misc_uebungen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JonnyCut on 29.09.2015.
 */
public class regularExp_uebung {
    public static void main(String[] args) {



        try(BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {

            Pattern p = Pattern.compile("\\b([äüößÜÄÖ][a-züäö]+)|([a-zA-Z][a-z]*[äüöß][a-züäöß]*)"); //kompiliert einen regulären Ausdruck aus dem gegebenen Muster
            //Pattern p = Pattern.compile("(^| |-)[aA]n[a-zäüöß]+");
            //                            (Anfang der Zeile OR Leerzeichen OR "bindestrich" FOLLOWEDBY[=FB] a OR A FB n AND[a bis z inkl. Sonderzeichen] + = mind. ein Buchstabe
            int counter=0;
            String zeile;
            while((zeile = br.readLine())!=null){
                //test
                Matcher m = p.matcher(zeile); //nimmt den von p kompilierten Audruck und ueberprueft das "matching"

                while(m.find()) {
                    System.out.println(m.group());
                    counter++;
                }
            }
            System.out.println(p+" wurde: " + counter+" erwähnt");






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen");
        }
    }
}

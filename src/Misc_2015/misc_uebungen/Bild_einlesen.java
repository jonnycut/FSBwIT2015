package Misc_2015.misc_uebungen;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by JonnyCut on 18.09.2015.
 */
public class Bild_einlesen {
    //test
    //test vom HS aus!
    //test die zweite!
    public static void main(String[] args) {
        Collection<String> al = new ArrayList<>();


        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream("bild.jpg"))){
            String puffer;
            int zeile=0;
            while((zeile = reader.read())!= -1){

                puffer = null;
                puffer = Integer.toHexString(zeile);
                if(puffer.length()==1) puffer = 0+ puffer;
                al.add(puffer);
            }
        }


            catch(IOException e){
                System.out.println("Fehler beim Lesen");
            }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("hex_daten.txt"))){
            int i=0;
            int adresse = 0;
            int umbruch = 0;
            String ausgabe ="";

            String hexAdresse = Integer.toHexString(adresse);

            while(hexAdresse.length()<Integer.toHexString(al.size()).length()){
                hexAdresse = "0"+hexAdresse;
            }

            writer.write("0x"+hexAdresse+"        ");
            //test

            for(String s : al){

                ausgabe =ausgabe +s;
                writer.write(s.toUpperCase());
                writer.write(" ");
                i++;

                if(i==16) {

                    writer.write("        ");
                    writer.write(new String(ausgabe));
                    ausgabe = "";
                    umbruch ++;
                    i = 0;
                    writer.newLine();
                    adresse = adresse +16;
                    if(umbruch ==16){
                        writer.write("\n\n");
                        umbruch =0;
                    }
                    hexAdresse=Integer.toHexString(adresse);
                    while(hexAdresse.length()<Integer.toHexString(al.size()).length()){
                        hexAdresse = "0"+hexAdresse;
                    }
                        writer.write("0x"+hexAdresse+ "        ");


                }
            }


        }

        catch(IOException e){
            System.out.println("Fehler beim Schreiben!");
        }
    }//end MainFunction
}//end MainClass

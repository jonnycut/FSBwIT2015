import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by KNapret on 18.09.2015.
 */
public class Bild_einlesen_byte {


    public static void main(String[] args) {
        Collection<byte[]> al = new ArrayList<>();


        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream("bild.jpg"))){

            byte[] puffer= new byte[16];
            int zLang;

            while((zLang = reader.read(puffer))!= -1){
                byte[] toStore = new byte[zLang];

                for(int i = 0; i<zLang;i++){
                    toStore[i] = puffer[i];
                }

                al.add(puffer);

            }
        }


            catch(IOException e){
                System.out.println("Fehler beim Lesen");
            }

        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("hex_daten.txt"))){
            //ToDo: schreiben in Datei


        }

        catch(IOException e){
            System.out.println("Fehler beim Schreiben!");
        }
    }//end MainFunction
}//end MainClass

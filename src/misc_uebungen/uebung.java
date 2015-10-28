package misc_uebungen;

import java.io.*;
import java.util.*;

/**
 * Created by knapret on 14.09.2015.
 */
public class uebung {
    public static void main(String[] args) throws IOException {

        Deque<String> cl = new ArrayDeque<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Nationalhymne.txt"))){
                String zeile = null;
                while ((zeile = br.readLine()) != null){

                    cl.push(zeile);

                }

        }
        catch (IOException e) {

            System.out.println("Fehler beim Lesen!");
        }



        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ausgabe.txt"))){

            while(!cl.isEmpty()){

                writer.write(cl.pop());
                writer.newLine();
            }
        }
        catch (IOException e){
            System.out.println("Fehler beim Schreiben");
        }





    }
}

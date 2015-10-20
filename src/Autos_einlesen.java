import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by KNapret on 20.10.2015.
 */
public class Autos_einlesen {

    public static void main(String[] args) {


        String pfad ="Y:\\3_XI\\XI_6\\302_SOP_OOP\\Autos\\Autos_";

        for(int i=0;i<32;i++){
           String datei = pfad + i +".txt";

            try(BufferedReader br = new BufferedReader(new FileReader(datei))){
                String zeile;

                while((zeile = br.readLine()) != null){
                    System.out.println(zeile);

                }


            } catch (FileNotFoundException e) {
                System.out.println("File: \"" + datei +"\" not found. Will try "+ pfad +(i+1)+".txt");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}

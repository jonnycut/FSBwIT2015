import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by KNapret on 29.09.2015.
 */
public class regularExp_uebung {
    public static void main(String[] args) {



        try(BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {

            Pattern p = Pattern.compile("God"); //kompiliert einen regulären Ausdruck aus dem gegebenen Muster
            int counter=0;
            String zeile;
            while((zeile = br.readLine())!=null){

                Matcher m = p.matcher(zeile); //nimmt den von p kompilierten Audruck und ueberprueft das "matching"

                while(m.find())
                    counter ++;

            }
            System.out.println("Gott wurde: " + counter+" erwähnt");






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen");
        }
    }
}

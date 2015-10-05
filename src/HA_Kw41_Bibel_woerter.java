import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jonnycut on 05.10.2015.
 */
public class HA_Kw41_Bibel_woerter {

    public static void main(String[] args) {

        Map<String, Integer> allWords = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {

            Pattern p = Pattern.compile("\\b\\p{Alpha}+"); //kompiliert einen regulären Ausdruck aus dem gegebenen Muster
            //Pattern p = Pattern.compile("(^| |-)[aA]n[a-zäüöß]+");
            //                            (Anfang der Zeile OR Leerzeichen OR "bindestrich" FOLLOWEDBY[=FB] a OR A FB n AND[a bis z inkl. Sonderzeichen] + = mind. ein Buchstabe
            int counter = 0;
            String zeile;
            while ((zeile = br.readLine()) != null) {

                Matcher m = p.matcher(zeile); //nimmt den von p kompilierten Audruck und ueberprueft das "matching"

                while (m.find()) {
                    String tmp = m.group();

                    if (allWords.containsKey(tmp) == false) {

                        allWords.put(tmp, 1);

                    } else {
                        allWords.put(tmp, allWords.get(tmp) + 1);
                    }
                }




            }

            System.out.println(allWords.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

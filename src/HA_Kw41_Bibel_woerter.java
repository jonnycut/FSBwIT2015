import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jonnycut on 05.10.2015.
 */
public class HA_Kw41_Bibel_woerter {

    public static void main(String[] args) {

        Map<String, Integer> allWords = new HashMap<>();

        long time = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader("bibel.txt"))) {

            Pattern p = Pattern.compile("\\b[a-zA-ZüäöÜÄÖß]+"); //kompiliert einen regulären Ausdruck aus dem gegebenen Muster
            //Pattern p = Pattern.compile("(^| |-)[aA]n[a-zäüöß]+");
            //                            (Anfang der Zeile OR Leerzeichen OR "bindestrich" FOLLOWEDBY[=FB] a OR A FB n AND[a bis z inkl. Sonderzeichen] + = mind. ein Buchstabe
            int counter = 0;
            String zeile;
            while ((zeile = br.readLine()) != null) {

                Matcher m = p.matcher(zeile); //nimmt den von p kompilierten Audruck und ueberprueft das "matching"

                while (m.find()) {
                    String tmp = m.group().toLowerCase();

                    if (allWords.containsKey(tmp) == false) {

                        allWords.put(tmp, 1);

                    } else {
                        allWords.put(tmp, allWords.get(tmp) + 1);
                    }
                }


            }

            //LinkedList aus dem EntrySet (enthält Key und Value --> object.getKey(); oder object.getValue();
            LinkedList<Map.Entry<String, Integer>> tmpList = new LinkedList<>(allWords.entrySet());

            //Liste sortieren mit eigenem (new) comparator --> Wenn Value gleich, dann nach Key (string)
            Collections.sort(tmpList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o2.getValue() - o1.getValue() == 0)
                        return o2.getKey().compareTo(o1.getKey());

                    return o1.getValue() - o2.getValue();
                }
            });
            //
            //da Liste aus entryset, kann direkt ausgegeben werden.
            //zum weiteren Bearbeiten müsste aus der Liste wieder eine Map gebaut werden


            System.out.println(tmpList);

            System.out.println(allWords.size());
            System.out.println(System.currentTimeMillis() - time);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

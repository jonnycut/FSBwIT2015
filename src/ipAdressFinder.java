import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JonnyCut on 08.10.2015.
 */
public class ipAdressFinder {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("ip.log"))) {

            Pattern p = Pattern.compile("((\\d|[1-9 ]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}((255[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d))");
            //                           ((0-9 OR 1-9,digit OR 1, 2 digits OR 2,0-4, digit OR 25,0-5.)3 mal hintereinander, Dann rückwärts damit nicht nach 1 Zahl abgebrochen wird

            String zeile;
            int counter = 0;
            while ((zeile = reader.readLine()) != null) {

                Matcher m = p.matcher(zeile);
                while (m.find()) {
ja

                    counter++;
                    System.out.println(m.group());
                }
            }
            System.out.println(counter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

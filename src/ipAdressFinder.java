import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JonnyCut on 08.10.2015.
 */
public class ipAdressFinder {



    public static void main(String[] args) {



        try (BufferedReader reader = new BufferedReader(new FileReader("ip.log"))) {

            Pattern p = Pattern.compile("(\\d|[1-9 ]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9 ]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d|[1-9 ]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.(255[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)");
            //                           ((0-9 OR 1-9,digit OR 1, 2 digits OR 2,0-4, digit OR 25,0-5.)3 mal hintereinander, Dann rückwärts damit nicht nach 1 Zahl abgebrochen wird

            String zeile;
            int counter = 0;
            while ((zeile = reader.readLine()) != null) {

                Matcher m = p.matcher(zeile);
                while (m.find()) {


                    counter++;
                    System.out.printf("%02X.%02X.%02X.%02X\n",
                        Integer.parseInt(m.group(1)),
                        Integer.parseInt(m.group(2)),
                        Integer.parseInt(m.group(3)),
                        Integer.parseInt(m.group(4)));

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

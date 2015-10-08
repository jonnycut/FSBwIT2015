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
       try( BufferedReader reader = new BufferedReader(new FileReader("ip.log"))){

           Pattern p = Pattern.compile("\\d");//ToDo: RegEx für IP finden

           String zeile;
           int counter = 0;
           while((zeile = reader.readLine())!=null){

               Matcher m = p.matcher(zeile);
               while(m.find()){

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

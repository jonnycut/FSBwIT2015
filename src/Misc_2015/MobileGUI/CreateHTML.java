package Misc_2015.MobileGUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by cjaeschke on 23.10.2015.
 */
public class CreateHTML {

    public static boolean CREATE(ArrayList<Auto> auto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("index.html"))) {


        } catch (IOException e) {
            return false;
        }
        return true;
    }
}

package Misc_2015.MobileGUI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cjaeschke on 26.10.2015.
 */
public class Leistung implements Comparable<Leistung> {
    private static Pattern P_LEISTUNG = Pattern.compile("(\\d+)\\skW\\s\\((\\d+)\\sPS\\)(,\\s\\w+)?");
    // man könnte auch einfach von kW in PS umrechnen (1 kW = 1,35962 PS)
    private int kW;
    private int ps;

    public Leistung (String leistung){
        if (leistung != null){
            Matcher matcher = P_LEISTUNG.matcher(leistung);
            if (matcher.find()) {
                this.kW = Integer.parseInt(matcher.group(1));
                this.ps = Integer.parseInt(matcher.group(2));
            }
        }
    }

    public Leistung (int kW, int ps){
        this.kW = kW;
        this.ps = ps;
    }

    public int getkW (){
        return kW;
    }

    public int getPs () {
        return ps;
    }

    public String toString (){
        return kW + " kW | " + ps + " PS";
    }

    public int compareTo(Leistung o) {
        return this.kW - o.kW;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Leistung) || o == null) return false;
        if (this == o) return true;
        Leistung leistung = (Leistung) o;
        if (this.kW != leistung.kW) return false;
        return this.ps == leistung.ps;
    }

    public int hashCode() {
        return this.kW ^ this.ps;
    }
}

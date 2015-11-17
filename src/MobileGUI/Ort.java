package MobileGUI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cjaeschke on 23.10.2015.
 */

public class Ort implements Comparable<Ort> {
    private static Pattern P_ORT = Pattern.compile("(\\w{2,3})\\s-\\s(\\d{5})\\s(\\w+.*)");

    private String land;
    private String plz;
    private String ort;

    public Ort(String ort) {
        if (ort != null) {
            Matcher machter = P_ORT.matcher(ort);
            if (machter.find()) {
                this.land = machter.group(1);
                this.plz = machter.group(2);
                this.ort = machter.group(3);
            }
        }
    }

    public Ort(String land, String plz, String ort) {
        this.land = land;
        this.plz = plz;
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public String getPLZ() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    public String toString() {
        return land + " - " + plz + " " + ort;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Ort) || o == null) return false;
        if (this == o) return true;

        Ort ort = (Ort) o;

        if (!this.land.equals(ort.land)) return false;
        if (!this.plz.equals(ort.plz)) return false;
        if (!this.ort.equals(ort.ort)) return false;

        return true;
    }

    public int hashCode() {
        int result = land != null ? land.hashCode() : 0;
        result = result ^ (plz != null ? plz.hashCode() : 0);
        result = result ^ (ort != null ? ort.hashCode() : 0);
        return result;
    }

    public int compareTo(Ort o) {
        if (!this.land.equals(o.land)) return this.land.compareTo(o.land);
        if (!this.plz.equals(o.plz)) return  this.plz.compareTo(o.plz);
        return this.ort.compareTo(o.ort);
    }
}
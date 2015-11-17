package MobileGUI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cjaeschke on 26.10.2015.
 */
public class Datum implements Comparable<Datum>{
    private static Pattern P_DATE = Pattern.compile("(\\d{2})/(\\d{4})");

    private int monat;
    private int jahr;

    public Datum(String datum) {
        if (datum != null) {
            Matcher matcher = P_DATE.matcher(datum);
            if (matcher.find()) {
                this.monat = Integer.parseInt(matcher.group(1));
                this.jahr = Integer.parseInt(matcher.group(2));
            }
        }
    }

    public Datum (int monat, int jahr){
        this.monat = monat;
        this.jahr = jahr;
    }

    public int getJahr() {
        return jahr;
    }

    public int getMonat() {
        return monat;
    }

    public String toString() {
        String re = (monat < 10) ? "0" + monat : "" + monat;
        return re + " / " + jahr;
    }

    public int compareTo(Datum o) {
        if (this.jahr != o.jahr)
            return this.jahr - o.jahr;
        return this.monat - o.monat;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Datum) || o == null) return false;
        if (this == o) return true;

        Datum datum = (Datum) o;

        if (monat != datum.monat) return false;
        return jahr == datum.jahr;
    }

    public int hashCode() {
        return jahr ^ monat;
    }

    public boolean isEmpty() { return (monat == 0 && jahr == 0);   }
}

package MobileGUI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cjaeschke on 23.10.2015.
 */

public class Auto implements Comparable<Auto> {
    private final static Pattern P_ORT = Pattern.compile("(\\w{2,3})\\s-\\s(\\d{5})\\s(\\w+.*)");
    private final static Pattern P_TYP = Pattern.compile("(Limousine|Geländewagen / Pickup|Kleinwagen|Cabrio / Roadster|Van / Minibus|Kombi|Sportwagen / Coupé|Andere)");
    private final static Pattern P_SCHALTUNG = Pattern.compile("(Schaltgetriebe|Halbautomatik|Automatik)");
    private final static Pattern P_KRAFTSTOFF = Pattern.compile("(Autogas \\(LPG\\)|Benzin|Diesel|Elektro|Erdgas \\(CNG\\)|Ethanol \\(FFV\\, E85 etc\\.\\|Hybrid \\(Benzin/Elektro\\)|Hybrid \\(Diesel / Elektro\\)|Wasserstoff|Andere)");
    private final static Pattern P_LEISTUNG = Pattern.compile("(\\d+)\\skW\\s\\((\\d+)\\sPS\\)(,\\s\\w+)?");
    private final static Pattern P_ZUSTAND = Pattern.compile("(Unfallfrei|Reparierter Unfallschaden)");
    private final static Pattern P_ANBIETER = Pattern.compile("(Privatanbieter|Händler)");
    private final static Pattern P_HU = Pattern.compile("HU\\s(\\d{2})/(\\d{4})");
    private final static Pattern P_EZ = Pattern.compile("EZ\\s(\\d{2})/(\\d{4})");
    private final static Pattern P_KMSTAND = Pattern.compile("((\\d{1,3}\\.)?\\d{1,3})\\skm\\s");
    private final static Pattern P_PREIS = Pattern.compile("((\\d{1,3}\\.)*\\d{1,3})\\s€");

    public final static Comparator<Auto> SORT_PREIS = new Comparator<Auto>() {
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return o1.preis - o2.preis;
        }
    };

    public final static Comparator<Auto> SORT_PREIS_RE = new Comparator<Auto>() {
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o2.preis - o1.preis;
        }
    };

    public final static Comparator<Auto> SORT_EZ = new Comparator<Auto>() {
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return o1.ez.compareTo(o2.ez);
        }
    };

    public final static Comparator<Auto> SORT_EZ_RE = new Comparator<Auto>() {
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o2.ez.compareTo(o1.ez);
        }
    };

    public final static Comparator<Auto> SORT_NAME = new Comparator<Auto>() {
        @Override
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return o1.name.compareTo(o2.name);
        }
    };

    public final static Comparator<Auto> SORT_NAME_RE = new Comparator<Auto>() {
        @Override
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return o2.name.compareTo(o1.name);
        }
    };


    public final static Comparator<Auto> SORT_KMSTAND = new Comparator<Auto>() {
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return o1.kmStand - o2.kmStand;
        }
    };

    public final static Comparator<Auto> SORT_KMSTAND_RE = new Comparator<Auto>() {
        public int compare(Auto o1, Auto o2) {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return o2.kmStand - o1.kmStand;
        }
    };

    private String name;
    private Ort ort;
    private String kraftstoff;
    private String typ;
    private String schaltung;
    private Datum hu = new Datum (0, 0);
    private Datum ez = new Datum (0, 0);
    private int preis = -1;
    private Leistung leistung;
    private String anbieter;
    private String zustand;
    private int kmStand = -1;
    List<String> extras = new ArrayList<>();

    public final static Auto baueAuto(List<String> daten) {
        if (daten.isEmpty()) return null;
        Auto auto = new Auto();
        Matcher matcher;
        auto.name = daten.get(0);
        daten.remove(0);
        for (String s : daten) {
            matcher = P_ORT.matcher(s);
            if (matcher.find()) {
                auto.ort = new Ort(matcher.group(1), matcher.group(2), matcher.group(3));
                continue;
            }

            matcher = P_TYP.matcher(s);
            if (matcher.find()) {
                auto.typ = matcher.group();
                continue;
            }

            matcher = P_SCHALTUNG.matcher(s);
            if (matcher.find()) {
                auto.schaltung = matcher.group();
                continue;
            }

            matcher = P_KRAFTSTOFF.matcher(s);
            if (matcher.find()) {
                auto.kraftstoff = matcher.group();
            }

            matcher = P_LEISTUNG.matcher(s);
            if (matcher.find()) {
                auto.leistung = new Leistung(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                continue;
            }

            matcher = P_ZUSTAND.matcher(s);
            if (matcher.find()) {
                auto.zustand = matcher.group();
                continue;
            }

            matcher = P_ANBIETER.matcher(s);
            if (matcher.find()) {
                auto.anbieter = matcher.group();
                continue;
            }

            matcher = P_EZ.matcher(s);
            if (matcher.find()) {
                auto.ez = new Datum(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                continue;
            }

            matcher = P_HU.matcher(s);
            if (matcher.find()) {
                auto.hu = new Datum(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                continue;
            }

            matcher = P_KMSTAND.matcher(s);
            if (matcher.find()) {
                String km = matcher.group(1);
                km = km.replaceAll("\\.", "");
                auto.kmStand = Integer.parseInt(km);
                continue;
            }

            matcher = P_PREIS.matcher(s);
            if (matcher.find()) {
                String pr = matcher.group(1);
                pr = pr.replaceAll("\\.", "");
                auto.preis = Integer.parseInt(pr);
                continue;
            }

            auto.extras.add(s);
        }
        return auto;
    }

    public int compareTo(Auto o) {
        return this.name.compareTo(o.name);
    }

    public boolean equals(Object o) {
        // prüfe, ob 'o' überhaupt ein MobileGUI.Auto ist oder null
        if (!(o instanceof Auto) || o == null)
            return false;
        if (this == o) return true;

        Auto auto = (Auto) o;

        if (!this.name.equals(auto.name)) return false;
        if (!this.ort.equals(auto.ort)) return false;
        if (!this.kraftstoff.equals(auto.kraftstoff)) return false;
        if (!this.typ.equals(auto.typ)) return false;
        if (!this.schaltung.equals(auto.schaltung)) return false;
        if (!this.hu.equals(auto.hu)) return false;
        if (!this.ez.equals(auto.ez)) return false;
        if (this.preis != auto.preis) return false;
        if (!this.leistung.equals(auto.leistung)) return false;
        if (!this.anbieter.equals(auto.anbieter)) return false;
        if (!this.zustand.equals(auto.zustand)) return false;
        if (this.kmStand != auto.kmStand) return false;
        if (!this.extras.equals(auto.extras)) return false;

        return true;
    }

    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = result ^ (ort != null ? ort.hashCode() : 0);
        result = result ^ (kraftstoff != null ? kraftstoff.hashCode() : 0);
        result = result ^ (typ != null ? typ.hashCode() : 0);
        result = result ^ (schaltung != null ? schaltung.hashCode() : 0);
        result = result ^ (hu != null ? hu.hashCode() : 0);
        result = result ^ (ez != null ? ez.hashCode() : 0);
        result = result ^ preis;
        result = result ^ (leistung != null ? leistung.hashCode() : 0);
        result = result ^ (anbieter != null ? anbieter.hashCode() : 0);
        result = result ^ (zustand != null ? zustand.hashCode() : 0);
        result = result ^ kmStand;
        result = result ^ (extras != null ? extras.hashCode() : 0);
        return result;
    }

    public String toHTML() {
        String re = "";
        re += name != null ? "Name:\t\t" + name + "\n" : "";
        re += ort != null ? "MobileGUI.Ort:\t\t" + ort + "\n" : "";
        re += anbieter != null ? "Anbieter:\t" + anbieter + "\n" : "";
        re += typ != null ? "TYP:\t\t" + typ + "\n" : "";
        re += schaltung != null ? "Schaltung:\t" + schaltung + "\n" : "";
        re += kraftstoff != null ? "Kraftstoff:\t" + kraftstoff + "\n" : "";
        re += leistung != null ? "MobileGUI.Leistung:\t" + leistung + "\n" : "";
        re += kmStand > 0 ? "Km-Stand:\t" + kmStand + " km\n" : "";
        re += zustand != null ? "Zustand:\t" + zustand + "\n" : "";
        re += !ez.isEmpty() ? "EZ:\t\t\t" + ez + "\n" : "";
        re += !hu.isEmpty() ? "HU:\t\t\t" + hu + "\n" : "";
        re += preis > 0 ? "Preis:\t\t" + preis + " €" : "";
        if (!extras.isEmpty())
            re += "\n\nEXTRAS";
        for (String s : extras)
            re += "\n\t- " + s;
        return re;
    }

    public String toString () {
        String re = "<html><pre>";
        re += name != null ? "Name:\t\t" + name + "<br>" : "";
        re += ort != null ? "MobileGUI.Ort:\t\t" + ort + "<br>" : "";
        re += anbieter != null ? "Anbieter:\t" + anbieter + "<br>" : "";
        re += typ != null ? "TYP:\t\t" + typ + "<br>" : "";
        re += schaltung != null ? "Schaltung:\t" + schaltung + "<br>" : "";
        re += kraftstoff != null ? "Kraftstoff:\t" + kraftstoff + "<br>" : "";
        re += leistung != null ? "MobileGUI.Leistung:\t" + leistung + "<br>" : "";
        re += kmStand > 0 ? "Km-Stand:\t" + kmStand + " km<br>" : "";
        re += zustand != null ? "Zustand:\t" + zustand + "<br>" : "";
        re += !ez.isEmpty() ? "EZ:\t\t" + ez + "<br>" : "";
        re += !hu.isEmpty() ? "HU:\t\t" + hu + "<br>" : "";
        re += preis > 0 ? "Preis:\t\t" + preis + " €" : "";
        if (!extras.isEmpty())
            re += "<br><br>EXTRAS";
        for (String s : extras)
            re += "<br>\t- " + s;

        return re + "</pre></html>";
    }
}
package Entities;

import java.util.*;

/**
 * kreiert von Jan Tilger
 * Klasse zur Implementation eines Baumen basierend auf Baumknoten, Kanten werden zz. noch nicht verwendet
 */

/*  Der Baum wird implementiert als HashMap <String, Baumknoten>, d.h. als eine  */
/*  Hashtabelle mit Keys vom Typ String und Values vom Typ Baumknoten             */
/*  Er wird in der Datenbank als String in folgender Form geespeichert: "A1B1C0D0...*/
    /*   A
        /   \
       B      C
       |  \  /  |
       H   D    E
       /\       / \
       I J      F  G
       | |      |  |
       K L      M  N
       | |      |  |
       O P      Q   R
       */

public class Baum {

    private HashMap<String, Baumknoten> graph;          // Datenstruktur fuer Baum

    public Baum() {                             // leerer Baum wird angelegt
        graph = new HashMap<>();   // als HashMap von String,Baumknoten
    }

    /**
     * getBaumknoten erzeugt bzw return den gegebenen Baumknotenstring
     */
    public Baumknoten getBaumknoten(String s) {  // liefere Baumknoten zu String
        Baumknoten v = graph.get(s);          // besorge Baumknoten zu Baumknotennamen
        if (v == null) {                    // falls nicht gefunden
            v = new Baumknoten(s);              // lege neuen Baumknoten an
            graph.put(s, v);                // fuege Namen und Baumknoten in HashMap ein
        }
        return v;                         // liefere gefundenen oder neuen Baumknoten
    }

    /**
     * erzeugt eine Baumkante die zz nicht genutzt wird. Fuegt allerdings noch die gg. Werte zu dem Knoten hinzu
     */
    public void addBaumkante(String source, //fuege Baumkante ein von Baumknotennamen source
                             String source1,//
                             String dest,    // zu Baumknotennamen dest
                             String effekt
    ) {
        Baumknoten v = getBaumknoten(source);     // finde Baumknoten v zum Startnamen
        Baumknoten x = getBaumknoten(source1);     // finde Baumknoten v zum Startnamen
        Baumknoten w = getBaumknoten(dest);       // finde Baumknoten w zum Zielnamen
        v.getList().add(new Baumkante(w));   // fuege Baumkante (v,w)  ein
        v.getList().add(new Baumkante(x));
        w.setPrev(v);
        w.setPrev1(x);
        w.setEffekt(effekt);
    }

    /**
     * Sucht den entsprechenden Baumknoten im Baum. Im gegensatz zu getBaumknoten erzeugt diese Methode keinen neuen
     * wenn der gesuchte noch nicht existiert
     */
    public Baumknoten searchBaumknoten(String s) {
        return graph.get(s);
    }

    /**
     * Prueft ob ein Knoten aktivierbar ist und noch nicht aktiviert wurde
     */
    public boolean isActivable(String s) {
        Baumknoten dest = searchBaumknoten(s);
        if (dest.getPrev() == dest && dest.getPrev1() == dest && dest.getActivate() == 0) return true;

        else if ((dest.getPrev().getActivate() == 1 && dest.getActivate() == 0) || (dest.getPrev1().getActivate() == 1 && dest.getActivate() == 0)) {
            if (s.equals("S")) {
                if ((searchBaumknoten("O").getActivate() == 1) && (searchBaumknoten("P").getActivate() == 1) && (searchBaumknoten("Q").getActivate() == 1) && (searchBaumknoten("R").getActivate() == 1))
                    return true;
            } else {
                return true;
            }
        } else return false;
        return false;
    }

    /**
     * setzt einen einzelnen Knoten auf 1
     */
    public boolean setActivate(String s) {
        Baumknoten dest = searchBaumknoten(s);
        if (dest.getPrev() == dest && dest.getPrev() == dest) { // Hierbei handelt es sich um die Wurzel
            dest.setActivate();
        } else if ((dest.getPrev().getActivate() == 1) || (dest.getPrev1().getActivate() == 1)) { // ueberprueft ob man den Baumknoten ueberhaupt aktivieren darf
            dest.setActivate();
            return true;
        }
        return false;
    }

    /**
     * setzt einen einzelnen Knoten auf 2
     */
    public boolean setInBau(String s) {
        Baumknoten dest = searchBaumknoten(s);
        if (dest.getPrev() == dest && dest.getPrev() == dest) { // Hierbei handelt es sich um die Wurzel
            dest.setZustand(2);
        } else if ((dest.getPrev().getActivate() == 1) || (dest.getPrev1().getActivate() == 1)) { // ueberprueft ob man den Baumknoten ueberhaupt aktivieren darf
            dest.setZustand(2);
            return true;
        }
        return false;
    }

    /**
     * erzeugt den String welche Knoten alle aktiv sind "Knoten + 2/1/0" A1B0...
     */
    public String getStringBaum() {
        return getActive("A") + "/" +
                getActive("B") + "/" +
                getActive("C") + "/" +
                getActive("D") + "/" +
                getActive("E") + "/" +
                getActive("F") + "/" +
                getActive("G") + "/" +
                getActive("H") + "/" +
                getActive("I") + "/" +
                getActive("J") + "/" +
                getActive("K") + "/" +
                getActive("L") + "/" +
                getActive("M") + "/" +
                getActive("N") + "/" +
                getActive("O") + "/" +
                getActive("P") + "/" + getActive("Q") + "/" + getActive("R") + "/" + getActive("S");
    }

    /**
     * Methode zum updaten des Talenbaums anhand des erhaltenen Strings.
     * Setzt nacheinander alphabetisch die "aktivierten" Knoten auf true
     */
    public void updateBaum(String updateBaum) {
        String[] updateString = updateBaum.split("/");
        for (int i = 0; i < updateString.length; i++) {
            if (updateString[i].charAt(1) == '1') {
                setActivate("" + updateString[i].charAt(0));
            } else if (updateString[i].charAt(1) == '2') {
                setInBau("" + updateString[i].charAt(0));
            }
        }
    }

    /**
     * Methode zum Ueberpruefen des Aktivierngszustandes des Baumknoten fuer den String
     * gibt den Namen des Knoten + Zustandsnummer zurueck
     */
    public String getActive(String s) {
        if (searchBaumknoten(s).getActivate() == 1) {
            return s + "1";
        } else if (searchBaumknoten(s).getActivate() == 2) {
            return s + "2";
        } else {
            return s + "0";
        }
    }

}
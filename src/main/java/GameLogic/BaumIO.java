package GameLogic;

import Entities.Baum;

import java.lang.*;
import java.util.*;

/**
 * Kreiert von Jan Tilger
 * Routinen zum Einlesen eines "gerichteten "Baumen
 * Der Baum wird realisiert durch eine HashMap, welche
 * den Namen des Baumknoten auf den Baumknoten abbildet.
 * Der Knoten besteht aus zwei vorgaengern , im selbst und dem Effekt
 */

public class BaumIO {
    private ArrayList<String> cKBaumListe = new ArrayList<String>();
    private ArrayList<String> cDBaumListe = new ArrayList<String>();
    private ArrayList<String> fKBaumListe = new ArrayList<String>();
    private ArrayList<String> fMBaumListe = new ArrayList<String>();
    private ArrayList<String> fPBaumListe = new ArrayList<String>();
    private ArrayList<String> frBaumListe = new ArrayList<String>();
    private static BaumIO baumio;

    private BaumIO() {
        initCDBaumListe();
        initCKBaumListe();
        initFKBaumListe();
        initFMBaumListe();
        initFPBaumListe();
        initFRBaumListe();
    }

    public static BaumIO getInstance() {
        if (BaumIO.baumio == null) {
            BaumIO.baumio = new BaumIO();
        }
        return baumio;
    }

    /**
     * Diese Methode liest einen der Baeume ein und erstellt anhand dieser den Baum
     * mit seinen Knoten und Kanten
     *
     * @param list eine der Vorgegebenen Listen
     * @return
     */
    public static Baum readBaum(ArrayList<String> list) {   // liest Baum aus Datei ein
        Baum g = new Baum();
        try {
            int i = 0;
            for (char j = 'A'; j <= 'S'; j++) {
                StringTokenizer st = new StringTokenizer(list.get(i));

                String source = st.nextToken();  //erster Elternknoten
                String source1 = st.nextToken(); //zweiter Elternknoten
                String dest = st.nextToken();  // Kindknoten
                String effekt = st.nextToken(); // der zu bekommende Effekt [Effekt;Wert]
                g.addBaumkante(source, source1, dest, effekt);
                i++;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            //System.out.println("ARRRG bei read Baum");
        }
        return g;
    }

    /**
     * Der Skillbaum von Charakter Kumpel
     *
     * @return
     */
    private ArrayList<String> initCKBaumListe() {
        cKBaumListe.add("A A A GELDBONUS;50");
        cKBaumListe.add("A A B PRODUKTIONSBONUS;50");
        cKBaumListe.add("A A C PRODUKTIONSBONUS;50");
        cKBaumListe.add("B C D FORSCHUNGSKOSTENBONUS;100");
        cKBaumListe.add("C C E TRUPPENKOSTENBONUS;100");
        cKBaumListe.add("E E F GEMUESEPRODUKTIONSBONUS;25");
        cKBaumListe.add("E E G GELDBONUS;25");
        cKBaumListe.add("B B H TRUPPENGESCHWINDIGKEITSBONUS;100");
        cKBaumListe.add("H H I MEHLPRODUKTIONSBONUS;25");
        cKBaumListe.add("H H J FLEISCHPRODUKTIONSBONUS;25");
        cKBaumListe.add("I I K TRUPPENGESCHWINDIGKEITSBONUS;50");
        cKBaumListe.add("J J L TRUPPENKOSTENBONUS;50");
        cKBaumListe.add("F F M TRUPPENANGRIFFSBONUS;50");
        cKBaumListe.add("G G N TRUPPENVERTEIDIGUNGSBONUS;50");
        cKBaumListe.add("K K O TRUPPENGESCHWINDIGKEITSBONUS;150");
        cKBaumListe.add("L L P TRUPPENKOSTENBONUS;150");
        cKBaumListe.add("M M Q TRUPPENANGRIFFSBONUS;150");
        cKBaumListe.add("N N R TRUPPENVERTEIDIGUNGSBONUS;150");
        cKBaumListe.add("O R S NO-Game-No-Life;Ultimative Einheit freischalten");
        return cKBaumListe;
    }

    /**
     * Der Skillbaum vom Charakter Diktator
     *
     * @return
     */
    private ArrayList<String> initCDBaumListe() {
        cDBaumListe.add("A A A GELDBONUS;50");
        cDBaumListe.add("A A B PRODUKTIONSBONUS;50");
        cDBaumListe.add("A A C PRODUKTIONSBONUS;50");
        cDBaumListe.add("B C D FORSCHUNGSGESCHWINDIGKEITSBONUS;50");
        cDBaumListe.add("C C E PRODUKTIONSBONUS;15");
        cDBaumListe.add("E E F TRUPPENANGRIFFSBONUS;25");
        cDBaumListe.add("E E G TRUPPENVERTEIDIGUNGSBONUS;25");
        cDBaumListe.add("B B H PRODUKTIONSBONUS;15");
        cDBaumListe.add("H H I TRUPPENGESCHWINDIGKEITSBONUS;25");
        cDBaumListe.add("H H J TRUPPENKOSTENBONUS;25");
        cDBaumListe.add("I I K MEHLPRODUKTIONSBONUS;50");
        cDBaumListe.add("J J L FLEISCHPRODUKTIONSBONUS;50");
        cDBaumListe.add("F F M GEMUESEPRODUKTIONSBONUS;50");
        cDBaumListe.add("G G N GELDBONUS;50");
        cDBaumListe.add("K K O MEHLPRODUKTIONSBONUS;150");
        cDBaumListe.add("L L P FLEISCHPRODUKTIONSBONUS;150");
        cDBaumListe.add("M M Q GEMUESEPRODUKTIONSBONUS;150");
        cDBaumListe.add("N N R GELDBONUS;150");
        cDBaumListe.add("O R S NO-Game-No-Life;Ultimative Einheit freischalten");
        return cDBaumListe;
    }

    /**
     * Der Skillbaum der Fraktion KFC
     *
     * @return
     */
    private ArrayList<String> initFKBaumListe() {
        fKBaumListe.add("A A A TRUPPENGESCHWINDIGKEITSBONUS;50");
        fKBaumListe.add("A A B TRUPPENKOSTENBONUS;50");
        fKBaumListe.add("A A C TRUPPENVERTEIDIGUNGSBONUS;50");
        fKBaumListe.add("B C D TRUPPENANGRIFFSBONUS;50");
        fKBaumListe.add("C C E PRODUKTIONSBONUS;50");
        fKBaumListe.add("E E F TRUPPENANGRIFFSBONUS;50");
        fKBaumListe.add("E E G FLEISCHPRODUKTIONSBONUS;50");
        fKBaumListe.add("B B H GELDBONUS;50");
        fKBaumListe.add("H H I FLEISCHPRODUKTIONSBONUS;50");
        fKBaumListe.add("H H J TRUPPENANGRIFFSBONUS;50");
        fKBaumListe.add("I I K TRUPPENANGRIFFSBONUS;50");
        fKBaumListe.add("J J L FLEISCHPRODUKTIONSBONUS;50");
        fKBaumListe.add("F F M FLEISCHPRODUKTIONSBONUS;50");
        fKBaumListe.add("G G N TRUPPENANGRIFFSBONUS;50");
        fKBaumListe.add("K K O GELDBONUS;50");
        fKBaumListe.add("L L P PRODUKTIONSBONUS;25");
        fKBaumListe.add("M M Q GELDBONUS;50");
        fKBaumListe.add("N N R PRODUKTIONSBONUS;25");
        fKBaumListe.add("O R S NO-Game-No-Life;Ultimative Einheit freischalten");
        return fKBaumListe;
    }

    /**
     * Der Skillbaum der Fraktion McKing
     *
     * @return
     */
    private ArrayList<String> initFMBaumListe() {
        fMBaumListe.add("A A A TRUPPENGESCHWINDIGKEITSBONUS;50");
        fMBaumListe.add("A A B TRUPPENKOSTENBONUS;50");
        fMBaumListe.add("A A C TRUPPENVERTEIDIGUNGSBONUS;50");
        fMBaumListe.add("B C D TRUPPENANGRIFFSBONUS;50");
        fMBaumListe.add("C C E PRODUKTIONSBONUS;50");
        fMBaumListe.add("E E F TRUPPENVERTEIDIGUNGSBONUS;50");
        fMBaumListe.add("E E G GEMUESEPRODUKTIONSBONUS;50");
        fMBaumListe.add("B B H GELDBONUS;50");
        fMBaumListe.add("H H I GEMUESEPRODUKTIONSBONUS;50");
        fMBaumListe.add("H H J TRUPPENVERTEIDIGUNGSBONUS;50");
        fMBaumListe.add("I I K TRUPPENVERTEIDIGUNGSBONUS;50");
        fMBaumListe.add("J J L GEMUESEPRODUKTIONSBONUS;50");
        fMBaumListe.add("F F M GEMUESEPRODUKTIONSBONUS;50");
        fMBaumListe.add("G G N TRUPPENVERTEIDIGUNGSBONUS;50");
        fMBaumListe.add("K K O GELDBONUS;50");
        fMBaumListe.add("L L P PRODUKTIONSBONUS;25");
        fMBaumListe.add("M M Q GELDBONUS;50");
        fMBaumListe.add("N N R PRODUKTIONSBONUS;25");
        fMBaumListe.add("O R S NO-Game-No-Life;Ultimative Einheit freischalten");
        return fMBaumListe;
    }

    /**
     * Der Skillbaum der Fraktion PizzaCap
     *
     * @return
     */
    private ArrayList<String> initFPBaumListe() {
        fPBaumListe.add("A A A TRUPPENGESCHWINDIGKEITSBONUS;50");
        fPBaumListe.add("A A B TRUPPENKOSTENBONUS;50");
        fPBaumListe.add("A A C TRUPPENVERTEIDIGUNGSBONUS;50");
        fPBaumListe.add("B C D TRUPPENANGRIFFSBONUS;50");
        fPBaumListe.add("C C E PRODUKTIONSBONUS;50");
        fPBaumListe.add("E E F TRUPPENKOSTENBONUS;75");
        fPBaumListe.add("E E G MEHLPRODUKTIONSBONUS;50");
        fPBaumListe.add("B B H GELDBONUS;50");
        fPBaumListe.add("H H I MEHLPRODUKTIONSBONUS;50");
        fPBaumListe.add("H H J TRUPPENKOSTENBONUS;75");
        fPBaumListe.add("I I K TRUPPENKOSTENBONUS;75");
        fPBaumListe.add("J J L MEHLPRODUKTIONSBONUS;50");
        fPBaumListe.add("F F M MEHLPRODUKTIONSBONUS;50");
        fPBaumListe.add("G G N TRUPPENKOSTENBONUS;75");
        fPBaumListe.add("K K O GELDBONUS;50");
        fPBaumListe.add("L L P PRODUKTIONSBONUS;25");
        fPBaumListe.add("M M Q GELDBONUS;50");
        fPBaumListe.add("N N R PRODUKTIONSBONUS;25");
        fPBaumListe.add("O R S NO-Game-No-Life;Ultimative Einheit freischalten");
        return fPBaumListe;
    }

    /**
     * Der Skillbaum der Franchise
     *
     * @return
     */
    private ArrayList<String> initFRBaumListe() {
        frBaumListe.add("A A A PRODUKTIONSBONUS;100");
        frBaumListe.add("A A B GELDBONUS;100");
        frBaumListe.add("A A C GELDBONUS;100");
        frBaumListe.add("B C D PRODUKTIONSBONUS;100");
        frBaumListe.add("C C E FORSCHUNGSKOSTENBONUS;100");
        frBaumListe.add("E E F TRUPPENKOSTENBONUS;100");
        frBaumListe.add("E E G TRUPPENGESCHWINDIGKEITSBONUS;100");
        frBaumListe.add("B B H FORSCHUNGSKOSTENBONUS;100");
        frBaumListe.add("H H I PRODUKTIONSBONUS;100");
        frBaumListe.add("H H J PRODUKTIONSBONUS;100");
        frBaumListe.add("I I K TRUPPENANGRIFFSBONUS;100");
        frBaumListe.add("J J L TRUPPENVERTEIDIGUNGSBONUS;100");
        frBaumListe.add("F F M TRUPPENVERTEIDIGUNGSBONUS;100");
        frBaumListe.add("G G N TRUPPENANGRIFFSBONUS;100");
        frBaumListe.add("K K O TRUPPENKOSTENBONUS;100");
        frBaumListe.add("L L P TRUPPENGESCHWINDIGKEITSBONUS;100");
        frBaumListe.add("M M Q PRODUKTIONSBONUS;100");
        frBaumListe.add("N N R PRODUKTIONSBONUS;100");
        frBaumListe.add("O R S NO-Game-No-Life;Ultimative Einheit freischalten");
        return frBaumListe;
    }

    public ArrayList<String> getcKBaumListe() {
        return cKBaumListe;
    }

    public ArrayList<String> getcDBaumListe() {
        return cDBaumListe;
    }

    public ArrayList<String> getfKBaumListe() {
        return fKBaumListe;
    }

    public ArrayList<String> getfMBaumListe() {
        return fMBaumListe;
    }

    public ArrayList<String> getfPBaumListe() {
        return fPBaumListe;
    }

    public ArrayList<String> getFrBaumListe() {
        return frBaumListe;
    }
}




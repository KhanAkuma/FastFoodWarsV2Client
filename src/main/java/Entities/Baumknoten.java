package Entities;

import java.util.*;

/**
 * /** Klasse zur Repraesentation eines Baumknoten
 */

/** erzeugt von Jan Tilger                                                        */

public class Baumknoten { // wegen Priority-Queue

    private String name;          // Name des Baumknoten               (fix)
    private List<Baumkante> edges;        // Nachbarn als Baumkantenliste      (fix)
    private int zustand;      // Aktivierungs-Status           (variabel)
    private Baumknoten prev;          // Erster Elternknoten
    private Baumknoten prev1;         // Zweiter Elternknoten
    private String effekt;        // den Boni den der Knoten gibt

    public Baumknoten(String s) {        // Konstruktor fuer Baumknoten
        name = s;                       // initialisiere Name des Baumknoten
        edges = new LinkedList<Baumkante>(); // initialisiere Nachbarschaftsliste
    }

    /** Ein Moeglicher Elternknoten */
    public void setPrev(Baumknoten v) {
        prev = v;
    }

    /** Ein Moeglicher Elternknoten */
    public void setPrev1(Baumknoten v) {
        prev1 = v;
    }

    /** analysiert welcher Boni  uebergeben wurde und fuehrt entsprechende Aktionen aus */
    public String setActivate() {
        String[] effektString = this.effekt.split(";");
        zustand = 1;
        switch (effektString[0]) {
            case "MEHLPRODUKTIONSBONUS":
                //Boni.getInstance().setMehlProduktionsbonus(Boni.getInstance().getMehlProduktionsbonus() + Integer.parseInt(effektString[1]));
                break;
            case "FLEISCHPRDUKTIONSBONUS":
                //Boni.getInstance().setFleischProduktionsbonus(Boni.getInstance().getFleischProduktionsbonus() + Integer.parseInt(effektString[1]));
                break;
            case "GEMUESEPRDUKTIONSBONUS":
                //Boni.getInstance().setGemueseProduktionsbonus(Boni.getInstance().getGemueseProduktionsbonus() + Integer.parseInt(effektString[1]));
                break;

            case "TRUPPENGESCHWINDIGKEITSBONUS":
                //Boni.getInstance().setTruppenGeschwindigkeitsbonus(Boni.getInstance().getTruppenGeschwindigkeitsbonus() + Integer.parseInt(effektString[1]));
                break;
            case "TRUPPENKOSTENBONUS":
                //Boni.getInstance().setTruppenKostenbonus(Boni.getInstance().getTruppenKostenbonus() + Integer.parseInt(effektString[1]));
                break;
            case "TRUPPENANGRIFFSBONUS":
                //Boni.getInstance().setTruppenAngriffsbonus(Boni.getInstance().getTruppenAngriffsbonus() + Integer.parseInt(effektString[1]));
                break;
            case "TRUPPENVERTEIDIGUNGSBONUS":
                //Boni.getInstance().setTruppenVerteidigungsbonus(Boni.getInstance().getTruppenVerteidigungsbonus() + Integer.parseInt(effektString[1]));
                break;
            case "FORSCHUNGSGESCHWINDIGKEITSBONUS":
                //Boni.getInstance().setForschungsGeschwindigkeitsbonus(Boni.getInstance().getForschungsGeschwindigkeitsbonus() + Integer.parseInt(effektString[1]));
                break;
            case "FORSCHUNGSKOSTENBONUS":
                //Boni.getInstance().setForschungsKostenbonus(Boni.getInstance().getForschungsKostenbonus() + Integer.parseInt(effektString[1]));
                break;
            case "NO-Game-No-Life":
                Spieler.getInstance().setKeinRealLife(true);
            default:
                return "No valid Input";

        }
        return null;
    }

    public String getEffekt() {
        return effekt;
    }

    public void setEffekt(String effekt) {
        this.effekt = effekt;
    }

    public int getActivate() {
        return zustand;
    }

    public Baumknoten getPrev() {
        return prev;
    }

    public Baumknoten getPrev1() {
        return prev1;
    }

    public List<Baumkante> getList() {
        return edges;
    }

    public void setZustand(int zustand) {
        this.zustand = zustand;
    }

    public int getZustand() {
        return zustand;
    }
}
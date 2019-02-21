package Entities;

import GameLogic.BefehlHandler;

/**
 * Autor: Christoph Wohlers
 */
public class Auktion {

    /**
     * Beim Erzeugen einer Auktion fragt der Konstruktor den Server anhand der Auktions-ID, welche
     * Parameter er hat. Der erhaltene String sieht wie folgt aus:
     * "TRUE;ANBIETER;name;ANGEBOTENERESSOURCE;name;ANGEBOTSMENGE;menge;VERLANGTERESSOURCE;name;ANGEBOTSPREIS;menge"
     */

    private String id;
    private String anbieter;
    private String angeboteneRessource;
    private String angebotsMenge;
    private String verlangteRessource;
    private String angebotsPreis;

    /**
     * Der Konstruktor holt sich die Werte fuer die Auktions-Attribute vom Server.
     *
     * @param id
     */
    public Auktion(String id) {
        this.id = id;
        BefehlHandler bh = BefehlHandler.getInstance();

        String[] befehl = {"LADEN", "AUKTION", id};

        String[] auktionenString = bh.sendeBefehl(befehl);

        this.anbieter = auktionenString[2];
        this.angeboteneRessource = auktionenString[4];
        this.angebotsMenge = auktionenString[6];
        this.verlangteRessource = auktionenString[8];
        this.angebotsPreis = auktionenString[10];

    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getAnbieter() {
        return anbieter;
    }

    public void setAnbieter(String anbieter) {
        this.anbieter = anbieter;
    }

    public String getAngeboteneRessource() {
        return angeboteneRessource;
    }

    public void setAngeboteneRessource(String angeboteneRessource) {
        this.angeboteneRessource = angeboteneRessource;
    }

    public String getAngebotsMenge() {
        return angebotsMenge;
    }

    public void setAngebotsMenge(String angebotsMenge) {
        this.angebotsMenge = angebotsMenge;
    }

    public String getVerlangteRessource() {
        return verlangteRessource;
    }

    public void setVerlangteRessource(String verlangteRessource) {
        this.verlangteRessource = verlangteRessource;
    }

    public String getAngebotsPreis() {
        return angebotsPreis;
    }

    public void setAngebotsPreis(String angebotsPreis) {
        this.angebotsPreis = angebotsPreis;
    }
}

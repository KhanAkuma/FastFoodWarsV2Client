package Entities;

import GameLogic.BaumIO;

/**
 * Autoren: Christoph Wohlers, Jan Tilger
 */

public class Franchise {

    /**
     * Kreiert von Jan Tilger
     * Ein Franchise mit allen dazugehoerigen Informationen.
     * Im Franchise werden Mitglieder und Ankuendigungen gespeichert.
     * Jede Franchise hat auch einen eigenen Forschungsbaum.
     * Die Frnachise hat ebenfalls ID, Name, einen Leiter (CEO) und
     * eigenes Geld.
     */

    private String id;
    private String name;
    private String CEO;
    private int geld;
    private Baum Forschungsbaum;
    private String[] mitgliederListe;
    private String[] mitgliederListeID;
    private String[] ankuendigungen;

    public String[] getAnkuendigungen() {
        return ankuendigungen;
    }

    public void setAnkuendigungen(String[] ankuendigungen) {
        this.ankuendigungen = ankuendigungen;
    }

    public Franchise(String id) {
        this.id = id;
    }

    public Franchise(String iName, String iCeo, String iId, String iKasse) {
        name = iName;
        CEO = iCeo;
        geld = Integer.parseInt(iKasse);
        id = iId;
        Forschungsbaum = BaumIO.getInstance().readBaum(BaumIO.getInstance().getFrBaumListe());
        ankuendigungen = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        mitgliederListe = new String[1];
        mitgliederListeID = new String[1];
        mitgliederListe[0] = iCeo;
        mitgliederListeID[0] = Spieler.getInstance().getId();
    }

    public String getCEO() {
        return CEO;
    }


    public String getName() {
        return name;
    }

    public Baum getForschungsbaum() {
        return Forschungsbaum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }

    public void setForschungsbaum(Baum forschungsbaum) {
        Forschungsbaum = forschungsbaum;
    }

    public String[] getMitgliederListe() {
        return mitgliederListe;
    }

    public void setMitgliederListe(String[] mitgliederListe) {
        this.mitgliederListe = mitgliederListe;
    }

    public String[] getMitgliederListeID() {
        return mitgliederListeID;
    }

    public void setMitgliederListeID(String[] mitgliederListeID) {
        this.mitgliederListeID = mitgliederListeID;
    }
}


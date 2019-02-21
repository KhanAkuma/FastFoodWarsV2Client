package Entities;

import GameLogic.BaumIO;

import java.util.ArrayList;
import java.util.List;

/**
 * Autoren: Christoph Wohlers, Jan Tilger
 */

public class Spieler {

    /**
     * Da es in jedem Client nur einen Spieler gibt, ist dieser ein Singleton.
     * Der Spieler hat viele Attribute, die beim Login gesetzt werden. Durch
     * einen Update-Handler oder durch Aktionen des Spieler werden diese
     * gegebenenfalls neu gesetzt.
     */

    private static Spieler spieler;

    private Spieler() {
    }

    public static Spieler getInstance() {
        if (Spieler.spieler == null) {
            Spieler.spieler = new Spieler();
        }
        return spieler;
    }

    private String id;
    private String name;
    private String fraktion;
    private Franchise franchise;
    private String passwort;
    private int geld;
    private int gutschein;
    private Standort aktuellerStandort;
    private List<Standort> standorte = new ArrayList<Standort>();
    private String charakter;
    private Boni boni;
    private List<Nachricht> gesendeteNachrichten = new ArrayList<Nachricht>();
    private List<Nachricht> empfangeneNachrichten = new ArrayList<Nachricht>();
    private Baum charakterBaum;
    private Baum fraktionsBaum;
    private boolean urlaubsmodus;
    private boolean keinRealLife;
    private long lastupdate;
    private String aktuellesZielID;
    private boolean darfForschen;
    private List<Bewegung> bewegungen = new ArrayList<>();

    public static Spieler getSpieler() {
        return spieler;
    }

    public static void setSpieler(Spieler spieler) {
        Spieler.spieler = spieler;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFraktion() {
        return fraktion;
    }

    public void setFraktion(String fraktion) {
        this.fraktion = fraktion;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }

    public int getGutschein() {
        return gutschein;
    }

    public void setGutschein(int gutschein) {
        this.gutschein = gutschein;
    }

    public List<Standort> getStandorte() {
        return standorte;
    }

    public void setStandorte(List<Standort> standorte) {
        this.standorte = standorte;
    }

    public String getCharakter() {
        return charakter;
    }

    public void setCharakter(String charakter) {
        this.charakter = charakter;
    }

    public Boni getBoni() {
        return boni;
    }

    public void setBoni(Boni boni) {
        this.boni = boni;
    }

    public List<Nachricht> getGesendeteNachrichten() {
        return gesendeteNachrichten;
    }

    public void setGesendeteNachrichten(List<Nachricht> gesendeteNachrichten) {
        this.gesendeteNachrichten = gesendeteNachrichten;
    }

    public List<Nachricht> getEmpfangeneNachrichten() {
        return empfangeneNachrichten;
    }

    public void setEmpfangeneNachrichten(List<Nachricht> empfangeneNachrichten) {
        this.empfangeneNachrichten = empfangeneNachrichten;
    }

    public Baum getCharakterBaum() {
        return charakterBaum;
    }

    public void setCharakterBaum(Baum charakterBaum) {
        this.charakterBaum = charakterBaum;
    }

    public boolean isUrlaubsmodus() {
        return urlaubsmodus;
    }

    public void setUrlaubsmodus(boolean urlaubsmodus) {
        this.urlaubsmodus = urlaubsmodus;
    }

    public Baum getFraktionsBaum() {
        return fraktionsBaum;
    }

    public boolean isKeinRealLife() {
        return keinRealLife;
    }

    public void setKeinRealLife(boolean keinRealLife) {
        this.keinRealLife = keinRealLife;
    }

    /**
     * Der Charakter-Forschungsbaum wird mit dem gewaehlten Spiel-Charakter initialisiert.
     */
    public void initCharakterBaum() {

        if (charakter.equals("D")) {
            charakterBaum = BaumIO.readBaum(BaumIO.getInstance().getcDBaumListe());
        } else if (charakter.equals("K")) {
            charakterBaum = BaumIO.readBaum(BaumIO.getInstance().getcKBaumListe());
        }
    }

    public Standort getAktuellerStandort() {
        return aktuellerStandort;
    }

    public void setAktuellerStandort(Standort aktuellerStandort) {
        this.aktuellerStandort = aktuellerStandort;
    }

    /**
     * Der Fraktion-Forschungsbaum wird mit der gewaehlten Fraktion initialisiert.
     */
    public void initFraktionsBaum() {
        if (fraktion.equals("K")) {
            fraktionsBaum = BaumIO.readBaum(BaumIO.getInstance().getfKBaumListe());
        } else if (fraktion.equals("M")) {
            fraktionsBaum = BaumIO.readBaum(BaumIO.getInstance().getfMBaumListe());
        } else if (fraktion.equals("P")) {
            fraktionsBaum = BaumIO.readBaum(BaumIO.getInstance().getfPBaumListe());
        }
    }

    public long getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(long update) {
        //ong update = System.currentTimeMillis()/1000;
        //update = lastupdate;
        lastupdate = update;
    }

    public String getAktuellesZielID() {
        return aktuellesZielID;
    }

    public void setAktuellesZielID(String aktuellesZielID) {
        this.aktuellesZielID = aktuellesZielID;
    }

    public void setFraktionsBaum(Baum fraktionsBaum) {
        this.fraktionsBaum = fraktionsBaum;
    }

    public boolean isDarfForschen() {
        return darfForschen;
    }

    public void setDarfForschen(boolean darfForschen) {
        this.darfForschen = darfForschen;
    }

    public List<Bewegung> getBewegungen() {
        return bewegungen;
    }

    public void setBewegungen(List<Bewegung> bewegungen) {
        this.bewegungen = bewegungen;
    }
}


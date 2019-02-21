package Entities;

/**
 * Created by Jakob on 04.08.2016.
 */
public class Bewegung {

    /**
     * Speichert die Daten einer Bewegung von Truppen bei Angriffen oder Transfers.
     */

    private String id;
    private String startStandort;
    private String zielStandort;
    private long ankunft;
    private String art;

    public Bewegung(String id, String startStandort, String zielStandort, long ankunft, String art) {
        this.id = id;
        this.startStandort = startStandort;
        this.zielStandort = zielStandort;
        this.ankunft = ankunft;
        this.art = art;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getStartStandort() {
        return startStandort;
    }

    public void setStartStandort(String startStandort) {
        this.startStandort = startStandort;
    }

    public String getZielStandort() {
        return zielStandort;
    }

    public void setZielStandort(String zielStandort) {
        this.zielStandort = zielStandort;
    }

    public long getAnkunft() {
        return ankunft;
    }

    public void setAnkunft(long ankunft) {
        this.ankunft = ankunft;
    }
}

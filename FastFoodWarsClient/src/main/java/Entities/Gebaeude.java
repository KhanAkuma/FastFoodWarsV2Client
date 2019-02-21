package Entities;

/**
 * Autor: Christoph Wohlers, Michael Schwenk
 */

public class Gebaeude {

    /**
     * Ein Gebaeude hat eine ID, einen Typ und ein boolean,
     * ob es sich derzeit im Bau befindet.
     */

    private String id;
    private String typ;
    private boolean imBau;

    public Gebaeude() {

    }

    public Gebaeude(String id, String typ, boolean imBau) {
        this.id = id;
        this.typ = typ;
        this.imBau = imBau;
    }

    public boolean isImBau() {
        return imBau;
    }

    public void setImBau(boolean imBau) {
        this.imBau = imBau;
    }

    public Gebaeude(String typ) {
        this.typ = typ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

}
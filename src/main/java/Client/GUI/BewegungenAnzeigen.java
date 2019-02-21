package Client.GUI;

import javafx.beans.property.SimpleStringProperty;

/**
 * Autor: Christoph Wohlers
 */
public class BewegungenAnzeigen {

    /**
     * Diese Klasse wird benoetigt, um die Bewegungen im gewuenschten Format
     * in die TableViews der GUI zu laden.
     */

    private final SimpleStringProperty startSpalte;

    private final SimpleStringProperty zielSpalte;

    private final SimpleStringProperty ankunftSpalte;

    private final SimpleStringProperty artSpalte;

    public BewegungenAnzeigen(String startSpalte, String zielSpalte, String ankunftSpalte, String artSpalte) {
        this.startSpalte = new SimpleStringProperty(startSpalte);
        this.zielSpalte = new SimpleStringProperty(zielSpalte);
        this.ankunftSpalte = new SimpleStringProperty(ankunftSpalte);
        this.artSpalte = new SimpleStringProperty(artSpalte);
    }

    public String getStartSpalte() {
        return startSpalte.get();
    }

    public SimpleStringProperty startSpalteProperty() {
        return startSpalte;
    }

    public void setStartSpalte(String startSpalte) {
        this.startSpalte.set(startSpalte);
    }

    public String getZielSpalte() {
        return zielSpalte.get();
    }

    public SimpleStringProperty zielSpalteProperty() {
        return zielSpalte;
    }

    public void setZielSpalte(String zielSpalte) {
        this.zielSpalte.set(zielSpalte);
    }

    public String getAnkunftSpalte() {
        return ankunftSpalte.get();
    }

    public SimpleStringProperty ankunftSpalteProperty() {
        return ankunftSpalte;
    }

    public void setAnkunftSpalte(String ankunftSpalte) {
        this.ankunftSpalte.set(ankunftSpalte);
    }

    public String getArtSpalte() {
        return artSpalte.get();
    }

    public SimpleStringProperty artSpalteProperty() {
        return artSpalte;
    }

    public void setArtSpalte(String artSpalte) {
        this.artSpalte.set(artSpalte);
    }
}

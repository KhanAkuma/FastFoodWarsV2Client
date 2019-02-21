package Client.GUI;

import javafx.beans.property.SimpleStringProperty;

/**
 * Autor: Christoph Wohlers
 */
public class BoniAnzeigen {

    /**
     * Diese Klasse wird benoetigt, um die Boni im gewuenschten Format
     * in die TableViews der GUI zu laden.
     */

    private final SimpleStringProperty boniNameSpalte;

    private final SimpleStringProperty boniWertSpalte;

    public BoniAnzeigen(String boniNameSpalte, String boniWertSpalte) {
        this.boniNameSpalte = new SimpleStringProperty(boniNameSpalte);
        this.boniWertSpalte = new SimpleStringProperty(boniWertSpalte);
    }

    public String getBoniNameSpalte() {
        return boniNameSpalte.get();
    }

    public SimpleStringProperty boniNameSpalteProperty() {
        return boniNameSpalte;
    }

    public void setBoniNameSpalte(String boniNameSpalte) {
        this.boniNameSpalte.set(boniNameSpalte);
    }

    public String getBoniWertSpalte() {
        return boniWertSpalte.get();
    }

    public SimpleStringProperty boniWertSpalteProperty() {
        return boniWertSpalte;
    }

    public void setBoniWertSpalte(String boniWertSpalte) {
        this.boniWertSpalte.set(boniWertSpalte);
    }
}

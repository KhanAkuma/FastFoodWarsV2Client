package Client.GUI;

import javafx.beans.property.SimpleStringProperty;

/**
 * Autor: Christoph Wohlers
 */
public class neueAuktionen {

    /**
     * Diese Klasse wird benoetigt, um die Auktionen im gewuenschten Format
     * in die TableViews der GUI zu laden.
     */

    private final SimpleStringProperty anbieterID;

    private final SimpleStringProperty angebotID;

    private final SimpleStringProperty angebotsMengeID;
    private final SimpleStringProperty verlangteRessourceID;
    private final SimpleStringProperty angebotsPreisID;

    private final SimpleStringProperty auktionsID;

    public neueAuktionen(String anbieterID, String angebotID, String angebotsMengeID, String verlangteRessourceID, String angebotsPreisID, String auktionsID) {
        this.anbieterID = new SimpleStringProperty(anbieterID);
        this.angebotID = new SimpleStringProperty(angebotID);
        this.angebotsMengeID = new SimpleStringProperty(angebotsMengeID);
        this.verlangteRessourceID = new SimpleStringProperty(verlangteRessourceID);
        this.angebotsPreisID = new SimpleStringProperty(angebotsPreisID);
        this.auktionsID = new SimpleStringProperty(auktionsID);
    }

    public String getAnbieterID() {
        return anbieterID.get();
    }

    public SimpleStringProperty anbieterIDProperty() {
        return anbieterID;
    }

    public void setAnbieterID(String anbieterID) {
        this.anbieterID.set(anbieterID);
    }

    public String getAngebotID() {
        return angebotID.get();
    }

    public SimpleStringProperty angebotIDProperty() {
        return angebotID;
    }

    public void setAngebotID(String angebotID) {
        this.angebotID.set(angebotID);
    }

    public String getAngebotsMengeID() {
        return angebotsMengeID.get();
    }

    public SimpleStringProperty angebotsMengeIDProperty() {
        return angebotsMengeID;
    }

    public void setAngebotsMengeID(String angebotsMengeID) {
        this.angebotsMengeID.set(angebotsMengeID);
    }

    public String getVerlangteRessourceID() {
        return verlangteRessourceID.get();
    }

    public SimpleStringProperty verlangteRessourceIDProperty() {
        return verlangteRessourceID;
    }

    public void setVerlangteRessourceID(String verlangteRessourceID) {
        this.verlangteRessourceID.set(verlangteRessourceID);
    }

    public String getAngebotsPreisID() {
        return angebotsPreisID.get();
    }

    public SimpleStringProperty angebotsPreisIDProperty() {
        return angebotsPreisID;
    }

    public void setAngebotsPreisID(String angebotsPreisID) {
        this.angebotsPreisID.set(angebotsPreisID);

    }

    public String getAuktionsID() {
        return auktionsID.get();
    }

    public SimpleStringProperty auktionsIDProperty() {
        return auktionsID;
    }

    public void setAuktionsID(String auktionsID) {
        this.auktionsID.set(auktionsID);
    }
}

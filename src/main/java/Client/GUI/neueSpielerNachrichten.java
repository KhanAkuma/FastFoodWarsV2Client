package Client.GUI;

import javafx.beans.property.SimpleStringProperty;

/**
 * Autor: Christoph Wohlers
 */
public class neueSpielerNachrichten {

    /**
     * Diese Klasse wird benoetigt, um die Spieler-Nachrichten im gewuenschten Format
     * in die TableViews der GUI zu laden.
     */

    private final SimpleStringProperty absenderID;

    private final SimpleStringProperty empfaengerID;

    private final SimpleStringProperty nachrichtID;

    public neueSpielerNachrichten(String absenderID, String empfaengerID, String nachrichtID) {
        this.absenderID = new SimpleStringProperty(absenderID);
        this.empfaengerID = new SimpleStringProperty(empfaengerID);
        this.nachrichtID = new SimpleStringProperty(nachrichtID);
    }

    public String getAbsenderID() {
        return absenderID.get();
    }

    public SimpleStringProperty absenderIDProperty() {
        return absenderID;
    }

    public void setAbsenderID(String absenderID) {
        this.absenderID.set(absenderID);
    }

    public String getEmpfaengerID() {
        return empfaengerID.get();
    }

    public SimpleStringProperty empfaengerIDProperty() {
        return empfaengerID;
    }

    public void setEmpfaengerID(String empfaengerID) {
        this.empfaengerID.set(empfaengerID);
    }

    public String getNachrichtID() {
        return nachrichtID.get();
    }

    public SimpleStringProperty nachrichtIDProperty() {
        return nachrichtID;
    }

    public void setNachrichtID(String nachrichtID) {
        this.nachrichtID.set(nachrichtID);
    }
}

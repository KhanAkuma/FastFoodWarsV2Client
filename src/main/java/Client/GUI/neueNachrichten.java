package Client.GUI;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Michalko on 21.06.2016.
 */
public class neueNachrichten {

    /**
     * Diese Klasse wird benoetigt, um die Nachrichten der Home-Seite im gewuenschten Format
     * in die TableViews der GUI zu laden.
     */

    private final SimpleStringProperty absenderID;

    private final SimpleStringProperty nachrichtID;

    public neueNachrichten(String absenderID, String nachrichtID) {
        this.absenderID = new SimpleStringProperty(absenderID);
        this.nachrichtID = new SimpleStringProperty(nachrichtID);
    }

    public String getNachrichtID() {
        return nachrichtID.get();
    }

    public void setNachrichtID(String nachrichtID) {
        this.nachrichtID.set(nachrichtID);
    }

    public String getAbsenderID() {
        return absenderID.get();
    }

    public void setAbsenderID(String absenderID) {
        this.absenderID.set(absenderID);
    }
}

package GameLogic;

import Entities.Auktion;
import Entities.Handelsposten;

import java.util.ArrayList;

/**
 * Autor: Christoph Wohlers
 */
public class HandelspostenLogic {

    /**
     * Die HandelspostenLogic kann Auktionen erstellen, abschliessen, loeschen oder
     * die laufenden Auktionen aktualisieren.
     */

    /**
     * Beim Login werden zunaechst fuer alle in der Datenbank enthaltenen Auktionen
     * Auktions-Objekte erzeugt. Diese Methode erzeugt dabei die Objekte.
     *
     * @param auktionId uebergebene Auktions-ID
     * @return erstellte Auktion
     */
    public Auktion erstelleAuktion(String auktionId) {

        Auktion auktion = new Auktion(auktionId);

        return auktion;

    }

    /**
     * Diese Methode wird aufgerufen, wenn in der GUI eine neue Auktion erstellt wird.
     * Dafuer werden die noetigen Parameter aus der GUI uebergeben und dem Server
     * wird diese neue Auktion mitgeteilt.
     *
     * @param spielerID     Der Spieler, der die Auktion erstellt
     * @param standortId    Der Standort des Spielers, an der eine Auktion erstellt wird.
     * @param angebot       Die Resource, die angeboten wird
     * @param angebotsmenge Die Ressourcenmenge, die angeboten wird
     * @param gebot         Die Ressource, die verlangt wird
     * @param gebotsmenge   Die Ressourcenmenge, die verlangt wird
     * @return True oder False, je nachdem ob die Aktion erfolgreich war
     */
    public String[] erstelleNeueAuktion(String spielerID, String standortId, String angebot, String angebotsmenge, String gebot, String gebotsmenge) {

        String[] befehl = {"AUKTION", "ERSTELLE", spielerID, standortId, angebot, angebotsmenge, gebot, gebotsmenge};
        BefehlHandler bf = BefehlHandler.getInstance();
        return bf.sendeBefehl(befehl);
    }

    /**
     * Diese Methode schliesst eine Auktion ab. Sie teilt dem Server mit, welcher Spieler
     * mit welchem Standort die Auktion abgeschlossen hat und welche Auktion
     * abgeschlossen wurde. Dies geschieht ueber die IDs.
     *
     * @param spielerID  Spieler, der die Auktion abgeschlossen hat
     * @param auktionsID Auktion, die abgeschlossen wurde
     * @param standortID Der Standort des Spielers, an dem die Auktion abgeschlossen wurde
     * @return True oder False, je nachdem ob die Aktion erfolgreich war
     */
    public String[] auktionAbschliessen(String spielerID, String auktionsID, String standortID) {

        String[] befehl = {"AUKTION", "ABSCHLIESSEN", spielerID, auktionsID, standortID};
        BefehlHandler bf = BefehlHandler.getInstance();
        return bf.sendeBefehl(befehl);
    }

    /**
     * Diese Methode loescht eine Auktion. Sie teilt dem Server mit, welcher Spieler
     * welche Auktion abgebrochen hat.
     *
     * @param auktionsID Abgebrochene Auktion
     * @param spielerID  Spieler, der die Auktion abgebrochen hat
     * @return True oder False, je nachdem ob die Aktion erfolgreich war
     */
    public String[] auktionLoeschen(String auktionsID, String spielerID) {

        String[] befehl = {"AUKTION", "LOESCHE", auktionsID, spielerID};
        BefehlHandler bf = BefehlHandler.getInstance();
        return bf.sendeBefehl(befehl);
    }

    /**
     * Diese Methode aktualisiert die im Handelsposten gespeicherten Auktionen.
     * Mit dem BefehlHandler werden die Auktions-IDs, die derzeit in der Datenbank
     * vorhanden sind, abgefragt. Falls dies erfolgreich ist, werden die Auktionen
     * im Handelsposten geloescht und fuer jede uebergebene ID wird eine neue Auktion
     * erzeugt und in den Handelsposten geschrieben.
     *
     * @return True oder False, je nachdem ob die Aktion erfolgreich war
     */
    public String aktualisiereAuktionen() {

        BefehlHandler bh = BefehlHandler.getInstance();

        String[] befehl = {"ANFRAGE", "AUKTIONSIDS"};
        String[] antwort = bh.sendeBefehl(befehl);
        String[] auktionsIds = antwort[1].split(";");
        Handelsposten handelsposten = Handelsposten.getInstance();

        if (antwort[0].equals("TRUE")) {
            handelsposten.setAuktionen(new ArrayList<>());
            if (auktionsIds[0] != null && !auktionsIds[0].equals("")) {
                for (int i = 0; i < auktionsIds.length; i++) {
                    handelsposten.getAuktionen().add(erstelleAuktion(auktionsIds[i]));

                }
            }
        }
        return "TRUE";
    }

}

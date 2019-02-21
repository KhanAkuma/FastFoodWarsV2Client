package GameLogic;

import Entities.Nachricht;
import Entities.Spieler;

/**
 * Autor: Christoph Wohlers
 */
public class NachrichtenLogic {

    /**
     * Die NachrichtenLogic kann Nachrichten erstellen, versenden und aktualisieren.
     */

    /**
     * Beim Login werden zunaechst fuer alle in der Datenbank enthaltenen Nachrichten
     * Nachrichten-Objekte erzeugt. Diese Methode erzeugt dabei die Objekte.
     *
     * @param nachrichtId Die Nachricht-ID der Nachricht, die erstellt werden soll
     * @return Die erstellte Nachricht
     */
    public Nachricht createNachricht(String nachrichtId) {

        Nachricht nachricht = new Nachricht(nachrichtId);

        return nachricht;

    }

    /**
     * Diese Methode schickt die gesendete Nachricht an den Server. Dabei werden
     * Sender, Empfaenger und Nachrichtentext mit dem BefehlHandler an den Server
     * geschickt.
     *
     * @param senderID   Spieler, der die Nachricht gesendet hat
     * @param empfaenger Spieler, der die Nachricht erhalten soll
     * @param nachricht  Nachrichtentext
     * @return True oder False, je nachdem ob das Versenden erfolgreich war
     */
    public String[] sendeNachricht(String senderID, String empfaenger, String nachricht) {

        String[] befehl = {"NACHRICHT", senderID, empfaenger, nachricht};
        BefehlHandler bf = BefehlHandler.getInstance();
        return bf.sendeBefehl(befehl);
    }

    /**
     * Diese Methode aktualisiert die im Spieler gespeicherten Nachrichten.
     * Dabei werden empfangene und versendete Nachrichten getrennt.
     * Mit dem BefehlHandler werden die Nachrichten-IDs, die derzeit in der Datenbank
     * vorhanden sind, abgefragt. Falls dies erfolgreich ist, werden die Nachrichten
     * im Spieler geloescht und fuer jede uebergebene ID wird eine neue Nachricht
     * erzeugt und in den Spieler geschrieben.
     *
     * @return True oder False, je nachdem ob die Aktion erfolgreich war
     */
    public void aktualisiereNachrichten() {

        Spieler spieler = Spieler.getInstance();

        String[] befehl = {"ANFRAGE", "NACHRICHTENIDS", spieler.getId()};

        BefehlHandler bh = BefehlHandler.getInstance();

        String[] answer = bh.sendeBefehl(befehl);

        if (answer[1] != null && !answer[1].equals("")) {
            String[] versendeteNachrichtenString = answer[1].split(";");
            for (int i = 0; i < versendeteNachrichtenString.length; i++) {
                boolean schonGeladen = false;
                for (Nachricht nachricht : spieler.getGesendeteNachrichten()) {
                    if (nachricht.getId().equals(versendeteNachrichtenString[i])) {
                        schonGeladen = true;
                    }
                }
                if (!schonGeladen) {
                    spieler.getGesendeteNachrichten().add(createNachricht(versendeteNachrichtenString[i]));
                }
            }
        }

        if (answer[2] != null && !answer[2].equals("")) {
            String[] empfangeneNachrichtenString = answer[2].split(";");
            for (int i = 0; i < empfangeneNachrichtenString.length; i++) {
                boolean schonGeladen = false;
                for (Nachricht nachricht : spieler.getEmpfangeneNachrichten()) {
                    if (nachricht.getId().equals(empfangeneNachrichtenString[i])) {
                        schonGeladen = true;
                    }
                }
                if (!schonGeladen) {
                    spieler.getEmpfangeneNachrichten().add(createNachricht(empfangeneNachrichtenString[i]));
                }
            }
        }
    }
}

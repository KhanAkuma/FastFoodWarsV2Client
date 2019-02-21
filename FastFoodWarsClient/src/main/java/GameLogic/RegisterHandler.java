package GameLogic;

/**
 * Autor: Jakob Grosse Boeckmann
 * <p>
 * Klasse um einen Registrierenbefehl zu generieren
 */
public class RegisterHandler {

    /**
     * Methode die einen String an den Server schickt um einen neuen Spieler in die Datenbank einzutragen
     *
     * @param spielername Name des Spielers
     * @param passwort    Passwort des Spielers
     * @param fraktion    Fraktion des Spielers
     * @param charakter   Charakter des Spielers
     * @return Gibt die Antwort des Servers als String zurueck
     */
    public String[] register(String spielername, String passwort, String fraktion, String charakter) {

        String[] befehl = {"REGISTRIEREN", spielername, passwort, fraktion, charakter};
        BefehlHandler bh = BefehlHandler.getInstance();
        return bh.sendeBefehl(befehl);
    }


}

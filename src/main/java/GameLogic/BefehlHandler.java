package GameLogic;

/**
 * Autoren: Christoph Wohlers, Jakob Grosse Boeckmann
 */
public class BefehlHandler {

    /**
     * Fuer jeden Client gibt es nur einen BefehlHandler, daher ist dieser ein Singleton.
     * Der BefehlHandler verschickt eine Nachricht in Form eines String-Arrays an den Server
     * und bekommt eine Antwort in Form eines String-Arrays.
     */

    private static BefehlHandler instance;
    NetzwerkHandler nw = NetzwerkHandler.getInstance();

    private BefehlHandler() {

    }

    public static BefehlHandler getInstance() {
        if (BefehlHandler.instance == null) {
            BefehlHandler.instance = new BefehlHandler();
        }
        return BefehlHandler.instance;
    }

    /**
     * Verschickt einen String an den Server und gibt dessen Antwort zurueck.
     * Die Methode ist dabei Synchronized, damit keine andere Anfrage an den
     * Server dazwischen kommen kann.
     *
     * @param befehl der zu verschickende String
     * @return die Antwort vom Server
     */
    public synchronized String[] sendeBefehl(String[] befehl) {
        nw.setServerAnswer(null);

        nw.sendeBefehl(befehl);
        while (nw.getServerAnswer() == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
        return nw.getServerAnswer();
    }
}
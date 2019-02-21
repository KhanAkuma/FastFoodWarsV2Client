package Client.Threads;

import Entities.Spieler;
import GameLogic.BefehlHandler;

/**
 * Created by Jakob on 03.08.2016.
 */
public class ForschungUpdateThread extends Thread {

    /**
     * Aktualisiert Forschungsknoten, wenn diese gekauft oder fertig erforscht sind.
     */

    private long fertigstellung;

    public ForschungUpdateThread(long fertigstellung) {
        super("ForschungUpdateThread");
        this.fertigstellung = fertigstellung + 3;
    }

    public void run() {
        //System.out.println("FroschungsUpdateThread gestartet!");
        long aktuell = System.currentTimeMillis() / 1000;
        while (aktuell < fertigstellung) {
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
            aktuell = System.currentTimeMillis() / 1000;
        }
        BefehlHandler befehlHandler = BefehlHandler.getInstance();
        Spieler spieler = Spieler.getInstance();
        String[] befehl = {"ANFRAGE", "GIBBAEUME", spieler.getId()};
        String[] answer = befehlHandler.sendeBefehl(befehl);

        spieler.getCharakterBaum().updateBaum(answer[1]);
        spieler.getFraktionsBaum().updateBaum(answer[2]);
        if (!spieler.getFranchise().getId().equals("0")) {
            //System.out.println("Ich habe eine Franchise! Ist das korrekt?");
            spieler.getFranchise().getForschungsbaum().updateBaum(answer[3]);
        }
        //System.out.println("Baum geupdatet!");
    }
}

package GameLogic;

import Client.Threads.BewegungsUpdateThread;
import Entities.Bewegung;
import Entities.Spieler;

/**
 * Created by Jakob on 04.08.2016.
 */
public class BewegungsLogic {

    /**
     * Eine Bewegung wird erstellt.
     * @param eigenschaften
     * @param id
     * @return
     */
    public boolean erzeugeBewegung(String[] eigenschaften, String id) {
        long ankunft = Long.parseLong(eigenschaften[2]);
        Bewegung bewegung = new Bewegung(id, eigenschaften[0], eigenschaften[1], ankunft, eigenschaften[3]);
        Spieler.getInstance().getBewegungen().add(bewegung);
        if (ankunft > System.currentTimeMillis() / 1000) {
            BewegungsUpdateThread thread = new BewegungsUpdateThread(bewegung);
            thread.start();
        }
        return true;
    }

    /**
     * Laedt Bewegung vom Server.
     * @param ids
     * @return
     */
    public boolean erzeugeBewegungen(String[] ids) {
        BefehlHandler befehlHandler = BefehlHandler.getInstance();
        for (String id : ids) {
            if (Integer.parseInt(id) > 0) {
                String[] befehl = {"LADEN", "BEWEGUNG", id};
                String[] answer = befehlHandler.sendeBefehl(befehl);
                erzeugeBewegung(answer, id);
            }
        }
        return true;
    }
}

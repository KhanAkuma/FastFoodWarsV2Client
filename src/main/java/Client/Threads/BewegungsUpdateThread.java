package Client.Threads;

import Entities.Bewegung;
import Entities.Spieler;
import GameLogic.StandortLogic;

/**
 * Created by Jakob on 04.08.2016.
 */
public class BewegungsUpdateThread extends Thread {

    /**
     * Aktualisiert Bewegungen, wenn sie ausgefuehrt oder beendet werden.
     */

    private Bewegung bewegung;

    public BewegungsUpdateThread(Bewegung bewegung) {
        super("BewegungsUpdateThread");
        this.bewegung = bewegung;
    }

    public void run() {
        //System.out.println("Bewegungsthread gestartet.");
        long ankunft = bewegung.getAnkunft();
        long jetzt = System.currentTimeMillis() / 1000;
        while (jetzt < ankunft) {
            long sleep = (ankunft+2 - jetzt) * 1000;
            try {
                sleep(sleep);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
            jetzt = System.currentTimeMillis()/1000;
        }
        //System.out.println("Bewegungsart: " + bewegung.getArt());
        if(bewegung.getArt().equals("UEBERNAHME")){
            //System.out.println("Oh es ist eine uebernahme, dann lade mal den Standort");
            new StandortLogic().createStandort(bewegung.getZielStandort());
        }
        Spieler.getInstance().getBewegungen().remove(bewegung);
    }
}

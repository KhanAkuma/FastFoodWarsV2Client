package Client.Threads;

import Entities.Gebaeude;
import Entities.Spieler;
import Entities.Standort;

/**
 * Created by Jakob on 01.08.2016.
 */
public class GebaeudeUpdateThread extends Thread {

    /**
     * Gebaeude werden aktualisiert, wenn sie in Bau sind oder fertig werden.
     */

    private Gebaeude gebaeude;
    private long fertigstellung;
    private String standortId;

    public GebaeudeUpdateThread(Gebaeude gebaeude, long fertigstellung, String standortId) {
        super("GebaeudeUpdateThread");
        this.gebaeude = gebaeude;
        this.fertigstellung = fertigstellung;
        this.standortId = standortId;
    }

    public void run() {
        //System.out.println("Gebaeudethreat gestartet! Gebaeude hat lvl: " + gebaeude.getTyp());
        long aktuell = System.currentTimeMillis() / 1000;
        while (aktuell < fertigstellung) {
            try {
                long schlafen = (fertigstellung - aktuell) * 1500 + 500;
                this.sleep(schlafen);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
            aktuell = System.currentTimeMillis() / 1000;
        }
        if (gebaeude.getTyp().contains("H")) {
            for (Standort standort : Spieler.getInstance().getStandorte()) {
                if (standort.getId().equals(standortId)) {
                    String typ = gebaeude.getTyp();
                    standort.setHauptgebaeudeLvl(Integer.parseInt(typ.substring(typ.length() - 1)));
                    standort.setHauptGebauedeImBau(false);
                }
            }
        }
        gebaeude.setImBau(false);
        //System.out.println("Gebaude gebaut!");
    }
}

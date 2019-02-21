package GameLogic;

import Client.Threads.GebaeudeUpdateThread;
import Entities.Gebaeude;
import Entities.Spieler;
import Entities.Standort;

/**
 * Autoren: Christoph Wohlers, Jakob Grosse-Boeckmann
 */
public class StandortLogic {

    /**
     * Die StandortLogic erzeugt beim Login die zum Spieler gehoerenden Standort-Objekte.
     * Dazu werden anhand der Standort-ID alle noetigen Informationen vom Server erfragt.
     */

    /**
     * Diese Methode erzeugt Standort-Objekte. Dazu werden vom Server mit der ID die Informationen
     * abgerufen, damit ein Standort erstellt und in die Standort-Liste des Spielers geschrieben.
     * Der vom Server erhaltene String sieht dabei wie folgt aus:
     * <p>
     * "TRUE-NAME;name-RESSOURCEN;mehl;gemuese;fleisch-KOORD;x;y-HAUPTGEBAEUDE;level-VERTEIDIGUNG;wert-GEBAEUDE;id;id;id"
     *
     * @param standortId Standort, der erzeugt werden soll
     * @return True, falls erfolgreich oder eine Fehlermeldung
     */
    public String createStandort(String standortId) {
        String[] befehl = {"LADEN", "STANDORT", standortId};
        BefehlHandler bh = BefehlHandler.getInstance();
        String[] answer = bh.sendeBefehl(befehl);


        switch (answer[0]) {
            case "FALSE":
                return answer[1];

            case "TRUE":
                boolean imBau = Boolean.parseBoolean(answer[17].split(";")[0]);
                Standort standort = new Standort(standortId, answer[2], Spieler.getInstance(), Integer.parseInt(answer[4]),
                        Integer.parseInt(answer[5]), Integer.parseInt(answer[6]), Integer.parseInt(answer[8]),
                        Integer.parseInt(answer[9]), Integer.parseInt(answer[11]), Integer.parseInt(answer[13]), imBau);
                if (Spieler.getInstance().getStandorte() == null) {

                }
                if (imBau) {
                    Gebaeude gebaeude = new Gebaeude("-1", "H" + standort.getId(), imBau);
                    GebaeudeUpdateThread thread = new GebaeudeUpdateThread(gebaeude, Long.parseLong(answer[17].split(";")[1]), standortId);
                    thread.start();
                }
                Spieler.getInstance().getStandorte().add(standort);
                BewegungsLogic bewegungsLogic = new BewegungsLogic();
                bewegungsLogic.erzeugeBewegungen(answer[16].split(";"));
                GebaeudeLogic gl = new GebaeudeLogic();
                String[] gebaeudeString = answer[15].split(";");
                for (int i = 0; i < gebaeudeString.length; i++) {
                    if (!(gebaeudeString[0].equals(""))) {
                        try {
                            gl.createGebaeude(gebaeudeString[i], standort);
                        } catch (Exception e) {
                           // e.printStackTrace();
                            return "FALSE";
                        }
                    }


                }
                return "TRUE";
            default:
                return "IRGENDWAS FALSCH";
        }
    }
}
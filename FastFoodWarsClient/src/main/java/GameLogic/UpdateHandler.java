package GameLogic;

import Entities.Spieler;
import Entities.Standort;

import java.util.List;

/**
 * Autor: Jakob
 */
public class UpdateHandler {

    /**
     * Der UpdateHandler ruft vom Server saemtliche Daten ab und aktualisiert die Daten
     * im Client. Dabei werden alle Daten aktualisiert, die sich nach dem letzten Update
     * geaendert haben.
     */

    private static UpdateHandler updateHandler;
    private boolean update = false;

    public static UpdateHandler getInstance() {
        if (updateHandler == null) {
            updateHandler = new UpdateHandler();
        }
        return updateHandler;
    }

    private UpdateHandler() {

    }

    /**
     * Initialisiert die Updates.
     */
    public void initialize() {
        update = true;
        while (update) {
            String[] array = {"UPDATE", "" + Spieler.getInstance().getId(), "" + Spieler.getInstance().getLastupdate()};
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
               // e.printStackTrace();
            }
            String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
            if (answer[0].equals("TRUE")) {
                Spieler.getInstance().setLastupdate((long) Integer.parseInt(answer[1]));
                Spieler.getInstance().setGeld(Integer.parseInt(answer[2]));
                Spieler.getInstance().setGutschein(Integer.parseInt(answer[4]));
                Spieler.getInstance().getCharakterBaum().updateBaum(answer[5]);
                Spieler.getInstance().getFraktionsBaum().updateBaum(answer[6]);
                if (!answer[7].equals("")) {
                    Spieler.getInstance().getFranchise().getForschungsbaum().updateBaum(answer[7]);
                }
                List<Standort> standorte = Spieler.getInstance().getStandorte();
                String[] standorteString = answer[3].split("-");

                new BoniLogic().setBoni();

                for (int i = 0; i < standorte.size(); i++) {
                    String[] einStandortString = standorteString[i].split(";");
                    String id = standorte.get(i).getId();
                    if (id.equals(einStandortString[0])) {
                        standorte.get(i).setFleisch(Integer.parseInt(einStandortString[1]));
                        standorte.get(i).setMehl(Integer.parseInt(einStandortString[2]));
                        standorte.get(i).setGemuese(Integer.parseInt(einStandortString[3]));
                        String[] einheiten = einStandortString[4].split("/");
                        for (int j = 0; j < einheiten.length; j++) {
                            String einheit[] = einheiten[j].split(":");
                            switch (einheit[0]) {
                                case "L1":
                                    standorte.get(i).setLt1(Integer.parseInt(einheit[1]));
                                    break;
                                case "L2":
                                    standorte.get(i).setLt2(Integer.parseInt(einheit[1]));
                                    break;
                                case "M1":
                                    standorte.get(i).setMt1(Integer.parseInt(einheit[1]));
                                    break;
                                case "M2":
                                    standorte.get(i).setMt2(Integer.parseInt(einheit[1]));
                                    break;
                                case "S1":
                                    standorte.get(i).setSt1(Integer.parseInt(einheit[1]));
                                    break;
                                case "S2":
                                    standorte.get(i).setSt2(Integer.parseInt(einheit[1]));
                                    break;
                                case "T1":
                                    standorte.get(i).setTt1(Integer.parseInt(einheit[1]));
                                    break;
                                case "T2":
                                    standorte.get(i).setTt2(Integer.parseInt(einheit[1]));
                                    break;
                                case "X1":
                                    standorte.get(i).setXt1(Integer.parseInt(einheit[1]));
                                    break;
                            }
                        }

                        String[] ausbildungsEinheiten = einStandortString[5].split("/");
                        for (int j = 0; j < ausbildungsEinheiten.length; j++) {
                            String einheit[] = ausbildungsEinheiten[j].split(":");
                            switch (einheit[0]) {
                                case "L1":
                                    standorte.get(i).setLt1ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "L2":
                                    standorte.get(i).setLt2ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "M1":
                                    standorte.get(i).setMt1ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "M2":
                                    standorte.get(i).setMt2ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "S1":
                                    standorte.get(i).setSt1ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "S2":
                                    standorte.get(i).setSt2ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "T1":
                                    standorte.get(i).setTt1ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "T2":
                                    standorte.get(i).setTt2ia(Integer.parseInt(einheit[1]));
                                    break;
                                case "X1":
                                    standorte.get(i).setXt1ia(Integer.parseInt(einheit[1]));
                                    break;
                            }
                        }

                    }
                }
            }
        }
    }

    public static UpdateHandler getUpdateHandler() {
        return updateHandler;
    }

    public static void setUpdateHandler(UpdateHandler updateHandler) {
        UpdateHandler.updateHandler = updateHandler;
    }
}

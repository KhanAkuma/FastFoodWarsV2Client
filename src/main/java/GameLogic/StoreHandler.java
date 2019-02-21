package GameLogic;

import Entities.Boni;
import Entities.Spieler;

/**
 * Kreiert by Jan Tilger on 26/07/2016.
 * KLasse die das einkaufen der Objekte realisiert.
 * Booster Objekte werden so selbst nicht mehr gebraucht
 * Einkauf von 1-11 sind die fuer jeden erhaeltlichen Einkaeufe
 * Der 12te ist ein Skill des Diktators/Kumpels
 */
public class StoreHandler {
    private static StoreHandler storehandler;

    private StoreHandler() {
    }

    public static StoreHandler getInstance() {
        if (StoreHandler.storehandler == null) {
            StoreHandler.storehandler = new StoreHandler();
        }
        return storehandler;
    }

    /**
     * Schickt den Einkauf mitsamt der Kosten an den Server
     *
     * @param id ID des jeweiligen Buttons im Store Tab der GUI
     * @return
     */
    public boolean storeEinkauf(String id) {
        Boni boni = Spieler.getInstance().getBoni().getInstance();
        int preis0 = 1;
        int preis1 = 1;
        int preis2 = 1;
        int preis3 = 1;
        int preis4 = 1;
        int preis5 = 1;
        int preis6 = 1;
        int preis7 = 1;
        int preis8 = 1;
        int preis9 = 1;
        int preis10 = 4;

        switch (id) {
            case "00":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "fleischProduktionsbonus", "1000", "" + preis0};
                String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                return true;
            case "01":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                // boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array1 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "gemueseProduktionsbonus", "1000", "" + preis1};
                String[] answer1 = BefehlHandler.getInstance().sendeBefehl(array1);
                return true;
            case "02":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                // boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array2 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "mehlProduktionsbonus", "1000", "" + preis2};
                String[] answer2 = BefehlHandler.getInstance().sendeBefehl(array2);
                return true;

            case "03":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array3 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenGeschwindigkeitsbonus", "500", "" + preis3};
                String[] answer3 = BefehlHandler.getInstance().sendeBefehl(array3);
                return true;
            case "04":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array4 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "forschungsGeschwindigkeitsbonus", "500", "" + preis4};
                String[] answer4 = BefehlHandler.getInstance().sendeBefehl(array4);
                return true;
            case "05":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array5 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenVerteidigungsbonus", "500", "" + preis5};
                String[] answer5 = BefehlHandler.getInstance().sendeBefehl(array5);
                return true;
            case "06":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array6 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenAngriffsbonus", "500", "" + preis6};
                String[] answer6 = BefehlHandler.getInstance().sendeBefehl(array6);
                return true;
            case "07":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array7 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenKostenbonus", "500", "" + preis7};
                String[] answer7 = BefehlHandler.getInstance().sendeBefehl(array7);
                return true;
            case "08":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array8 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "forschungsGeschwindigkeitsbonus", "500", "" + preis8};
                String[] answer8 = BefehlHandler.getInstance().sendeBefehl(array8);
                return true;
            case "09":
                if (Spieler.getInstance().getGutschein() < 1) return false;
                // boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array9 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "geldbonus", "1000", "" + preis9};
                String[] answer9 = BefehlHandler.getInstance().sendeBefehl(array9);
                return true;
            case "10":
                if (Spieler.getInstance().getGutschein() < preis10) return false;
                //boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                String[] array10 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "produktionsbonus", "1000", "" + preis10};
                String[] answer10 = BefehlHandler.getInstance().sendeBefehl(array10);
                return true;
            case "11":
                if (Spieler.getInstance().getCharakter().equals("K") && Spieler.getInstance().getGutschein() < 3)
                    return false;
                if (Spieler.getInstance().getCharakter().equals("D") && Spieler.getInstance().getGutschein() < 6)
                    return false;
                if (Spieler.getInstance().getCharakter().equals("K")) {
                    // boni.setFleischProduktionsbonus(boni.getFleischProduktionsbonus() + 1);
                    String[] array11 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenGeschwindigkeitsbonus", "1000", "3"};
                    String[] answer11 = BefehlHandler.getInstance().sendeBefehl(array11);
                    String[] array12 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenKostenbonus", "1000", "0"};
                    String[] array13 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenAngriffsbonus", "1000", "0"};
                    String[] array14 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "truppenVerteidigungsbonus", "1000", "0"};
                    BefehlHandler.getInstance().sendeBefehl(array12);
                    BefehlHandler.getInstance().sendeBefehl(array13);
                    BefehlHandler.getInstance().sendeBefehl(array14);
                    return true;
                } else if (Spieler.getInstance().getCharakter().equals("D")) {
                    String[] array11 = {"BONI", "BOOSTER", Spieler.getInstance().getId(), "produktionsbonus", "2000", "6"};
                    String[] answer11 = BefehlHandler.getInstance().sendeBefehl(array11);
                }
            default:
                //System.out.println("Invalid Store input");
        }
        return false;
    }

}

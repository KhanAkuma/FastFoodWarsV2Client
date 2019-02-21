package GameLogic;

import Entities.Baumknoten;
import Entities.Franchise;
import Entities.Spieler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * Kreiert by Jan Tilger on 25/07/2016.
 * Eine Klasse die fuer die VErwaltung der Franchise verantwortlich ist
 * Die Methoden werden aus der HomeGUI aufgerufen
 */
public class FranchiseHandler {
    private static FranchiseHandler franchiseHandler;

    private FranchiseHandler() {
    }

    ;


    public static FranchiseHandler getInstance() {
        if (FranchiseHandler.franchiseHandler == null) {
            FranchiseHandler.franchiseHandler = new FranchiseHandler();
        }
        return franchiseHandler;
    }

    /**
     * Erstellt die Boni GUI Liste der Franchise
     *
     * @param gBaumListe Die Liste der G-Knoten der GUI
     * @return Die GUI-BONI-Liste
     */
    public ObservableList<String> loadFranchiseBoni(ArrayList<Circle> gBaumListe) {
        int j = 0;
        int verteidigungsbonus = 0;
        int produktionsbonus = 0;
        int geldbonus = 0;
        int mehlProduktionsbonus = 0;
        int fleischProduktionsbonus = 0;
        int gemueseProduktionsbonus = 0;
        int truppenGeschwindigkeitsbonus = 0;
        int truppenKostenbonus = 0;
        int truppenAngriffsbonus = 0;
        int truppenVerteidigungsbonus = 0;
        int forschungsGeschwindigkeitsbonus = 0;
        int forschungsKostenbonus = 0;

        for (char i = 'A'; i <= 'S'; i++) {
            String search = gBaumListe.get(j).getId().toString();
            if (Spieler.getInstance().getFranchise().getForschungsbaum().searchBaumknoten("" + search.charAt(1)).getActivate() == 1) {
                Baumknoten knoten = Spieler.getInstance().getFranchise().getForschungsbaum().searchBaumknoten("" + search.charAt(1));
                String[] effektString = knoten.getEffekt().split(";");
                switch (effektString[0]) {
                    case "PRODUKTIONSBONUS":
                        produktionsbonus = produktionsbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "GELDBONUS":
                        geldbonus = geldbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "MEHLPRODUKTIONSBONUS":
                        mehlProduktionsbonus = mehlProduktionsbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "FLEISCHPRODUKTIONSBONUS":
                        fleischProduktionsbonus = fleischProduktionsbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "GEMUESEPRODUKTIONSBONUS":
                        gemueseProduktionsbonus = gemueseProduktionsbonus + Integer.parseInt(effektString[1]);
                        break;

                    case "TRUPPENGESCHWINDIGKEITSBONUS":
                        truppenGeschwindigkeitsbonus = truppenGeschwindigkeitsbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "TRUPPENKOSTENBONUS":
                        truppenKostenbonus = truppenKostenbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "TRUPPENANGRIFFSBONUS":
                        truppenAngriffsbonus = truppenAngriffsbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "TRUPPENVERTEIDIGUNGSBONUS":
                        truppenVerteidigungsbonus = truppenVerteidigungsbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "FORSCHUNGSGESCHWINDIGKEITSBONUS":
                        forschungsGeschwindigkeitsbonus = forschungsGeschwindigkeitsbonus + Integer.parseInt(effektString[1]);
                        break;
                    case "FORSCHUNGSKOSTENBONUS":
                        forschungsKostenbonus = forschungsKostenbonus + Integer.parseInt(effektString[1]);
                        break;
                    default:
                        //System.out.println("Invalid Baum input");
                }

            }
            j++;
        }
        final ObservableList<String> boniliste = FXCollections.observableArrayList();
        boniliste.add("verteidigungsbonus: " + verteidigungsbonus);
        boniliste.add("produktionsbonus: " + produktionsbonus);
        boniliste.add("geldbonus: " + geldbonus);
        boniliste.add("mehlProduktionsbonus: " + mehlProduktionsbonus);
        boniliste.add("fleischProduktionsbonus: " + fleischProduktionsbonus);
        boniliste.add("gemueseProduktionsbonus: " + gemueseProduktionsbonus);
        boniliste.add("truppenGeschwindigkeitsbonus: " + truppenGeschwindigkeitsbonus);
        boniliste.add("truppenKostenbonus: " + truppenKostenbonus);
        boniliste.add("truppenAngriffsbonus: " + truppenAngriffsbonus);
        boniliste.add("truppenVerteidigungsbonus: " + truppenVerteidigungsbonus);
        boniliste.add("forschungsGeschwindigkeitsbonus: " + forschungsGeschwindigkeitsbonus);
        boniliste.add("forschungsKostenbonus: " + forschungsKostenbonus);

        return boniliste;
    }

    /**
     * Methode zum gruenden einer Franchise
     *
     * @param name Name der zu erstellenden Franchise
     * @return true bei erfolg
     */
    public boolean franchiseErstellen(String name) {
        String[] array = {"FRANCHISE", "ERSTELLEN", Spieler.getInstance().getId(), name};
        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
        if (answer[0].equals("TRUE")) {
            Franchise franchise = new Franchise(name, Spieler.getInstance().getName(), answer[1], "0");
            Spieler.getInstance().setFranchise(franchise);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode zum beitreten einer Franchise
     *
     * @param name Name der beizutretenden Franchise
     * @return true wenn beitreten erfolgreich und name existiert
     */
    public String[] franchiseBeitreten(String name) {
        String[] array = {"FRANCHISE", "BEITRETEN", Spieler.getInstance().getId(), name};
        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
        //System.out.println("miep" + answer[0]);
        if (answer[0].equals("TRUE")) {
            setFranchise(answer[1]);
            return answer;
        } else {

            return answer;
        }
    }

    /**
     * Methode zum initalen laden einer Franchise
     *
     * @param id erwartet die ID der Franchise
     */
    public void setFranchise(String id) {
        String[] array = {"FRANCHISE", "BEKOMMEINFOS", id};
        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);

        String name = answer[0];
        String ceo = answer[1];
        String geld = answer[2];
        String franchiseBaum = answer[3];
        String[] mitgliederListeID = answer[4].split(";");

        String[] array1 = {"FRANCHISE", "BEKOMMENAMEN", id};
        String[] answer1 = BefehlHandler.getInstance().sendeBefehl(array1);
        String[] mitgliederListe = answer1;

        String[] array2 = {"FRANCHISE", "BEKOMMEANKUENDIGUNG", id};
        String[] answer2 = BefehlHandler.getInstance().sendeBefehl(array2);

        Franchise franchise = new Franchise(name, ceo, id, geld);
        Spieler.getInstance().setFranchise(franchise);
        franchise.getForschungsbaum().updateBaum(franchiseBaum);
        Spieler.getInstance().getFranchise().setMitgliederListe(mitgliederListe);
        Spieler.getInstance().getFranchise().setMitgliederListeID(mitgliederListeID);
        Spieler.getInstance().getFranchise().setAnkuendigungen(answer2);

    }

    /**
     * @param menge : Die Menge des eingezahlten Gelds
     *              Uebergibt dem Server einen String zum einzahlen in die Gemeinschaftskasse
     *              FRANCHISE EINZAHLEN franchiseid spielerid GELDMENGE
     */
    public void einzahlen(String menge) {
        String spielerID = Spieler.getInstance().getId();
        String franchiseID = Spieler.getInstance().getFranchise().getId();
        String[] array = {"FRANCHISE", "EINZAHLEN", franchiseID, spielerID, menge};
        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
        if (answer[0].equals("TRUE")) {
            Spieler.getInstance().getFranchise().setGeld(Integer.parseInt(answer[1]));
            Spieler.getInstance().setGeld(Integer.parseInt(answer[2]));
        }
    }
}

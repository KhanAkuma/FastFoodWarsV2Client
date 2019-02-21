package GameLogic;

import Entities.Boni;
import Entities.Spieler;

/**
 * Created by Jakob on 04.08.2016.
 */
public class BoniLogic {

    /**
     * Boni werden vom Server abgerufen und in die Boni-Klasse geschrieben.
     */
    public void setBoni() {
        BefehlHandler befehlHandler = BefehlHandler.getInstance();
        String[] befehl = {"LADEN", "BONI", Spieler.getInstance().getId()};
        String[] boni = befehlHandler.sendeBefehl(befehl);
        Boni bonus = Boni.getInstance();
        bonus.setSpieler(Spieler.getInstance());
        double verteidigungsbonus = Double.parseDouble(boni[0]);
        double produktionsbonus = Double.parseDouble(boni[1]);
        double geldbonus = Double.parseDouble(boni[2]);

        //Gebaeudeboni
        double mehlProduktionsbonus = Double.parseDouble(boni[3]);
        double fleischProduktionsbonus = Double.parseDouble(boni[4]);
        double gemueseProduktionsbonus = Double.parseDouble(boni[5]);

        //Truppenboni
        double truppenGeschwindigkeitsbonus = Double.parseDouble(boni[6]);
        double truppenKostenbonus = Double.parseDouble(boni[7]);
        double truppenAngriffsbonus = Double.parseDouble(boni[8]);
        double truppenVerteidigungsbonus = Double.parseDouble(boni[9]);

        //Forschungsboni
        double forschungsGeschwindigkeitsbonus = Double.parseDouble(boni[10]);
        double forschungsKostenbonus = Double.parseDouble(boni[11]);
        bonus.setVerteidigungsbonus(verteidigungsbonus);
        bonus.setProduktionsbonus(produktionsbonus);
        bonus.setGeldbonus(geldbonus);
        bonus.setMehlProduktionsbonus(mehlProduktionsbonus);
        bonus.setFleischProduktionsbonus(fleischProduktionsbonus);
        bonus.setGemueseProduktionsbonus(gemueseProduktionsbonus);
        bonus.setTruppenGeschwindigkeitsbonus(truppenGeschwindigkeitsbonus);
        bonus.setTruppenKostenbonus(truppenKostenbonus);
        bonus.setTruppenAngriffsbonus(truppenAngriffsbonus);
        bonus.setTruppenVerteidigungsbonus(truppenVerteidigungsbonus);
        bonus.setForschungsGeschwindigkeitsbonus(forschungsGeschwindigkeitsbonus);
        bonus.setForschungsKostenbonus(forschungsKostenbonus);
        Spieler.getInstance().setBoni(bonus);
    }
}

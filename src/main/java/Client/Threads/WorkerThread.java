package Client.Threads;

/**
 * Created by Jakob on 27.07.2016.
 */

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entities.Gebaeude;
import Entities.Spieler;
import GameLogic.BefehlHandler;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @Autoren Jakob Grosse Boeckmann, Michael Schwenk, Jan Tilger, Christoph Wohlers
 */
public class WorkerThread extends Thread {

    /**
     * Aktualisiert die Elemente in den GUI-Elementen.
     */

    private Label geldAnzahl = null;
    private Label fleischAnzahlID = null;
    private Label mehlAnzahlID = null;
    private Label veggieAnzahlID = null;
    private Label gutscheineAnzahl = null;
    private Label kapazitaetLabel = null;
    private Button aufwertenBasis = null;
    private ImageView imBauBasis = null;
    private ArrayList<ImageView> imBau = null;
    private ArrayList<Button> aufwertenButtons = null;
    private ArrayList<Button> truppenOk = null;
    private ArrayList<Label> truppenAnzahl = null;
    private ArrayList<Label> truppeniaAnzahl = null;
    private Group ltGroup = null;
    private Group mtGroup = null;
    private Group stGroup = null;
    private Tab handelspostenTab = null;
    private Tab forschenTab = null;
    private ArrayList<Circle> cBaumListe;
    private ArrayList<Circle> gBaumListe;
    private ArrayList<Circle> fBaumListe;


    public WorkerThread(Label geldAnzahl, Label mehlAnzahlID, Label fleischAnzahlID, Label veggieAnzahlID,
                        Label gutscheineAnzahl, ArrayList<ImageView> imBau, ArrayList<Button> truppenOk,
                        ArrayList<Button> aufwertenButtons, ArrayList<Label> truppenAnzahl,
                        ArrayList<Label> truppeniaAnzahl, Group ltGroup, Group mtGroup, Group stGroup,
                        Tab handelspostenTab, Tab forschenTab, Label kapazitaetLabel, ArrayList<Circle> cBaumListe, ArrayList<Circle> gBaumListe, ArrayList<Circle> fBaumListe, Button aufwertenBasis, ImageView imBauBasis) {
        setDaemon(true);

        this.truppenOk = truppenOk;
        this.geldAnzahl = geldAnzahl;
        this.fleischAnzahlID = fleischAnzahlID;
        this.mehlAnzahlID = mehlAnzahlID;
        this.veggieAnzahlID = veggieAnzahlID;
        this.gutscheineAnzahl = gutscheineAnzahl;
        this.imBau = imBau;
        this.aufwertenButtons = aufwertenButtons;
        this.truppenAnzahl = truppenAnzahl;
        this.truppeniaAnzahl = truppeniaAnzahl;
        this.ltGroup = ltGroup;
        this.mtGroup = mtGroup;
        this.stGroup = stGroup;
        this.handelspostenTab = handelspostenTab;
        this.kapazitaetLabel = kapazitaetLabel;
        this.forschenTab = forschenTab;
        this.cBaumListe = cBaumListe;
        this.gBaumListe = gBaumListe;
        this.fBaumListe = fBaumListe;
        this.aufwertenBasis = aufwertenBasis;
        this.imBauBasis = imBauBasis;
    }

    @Override
    public void run() {

        while (!this.isInterrupted()) {

            // UI updaten
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    // entsprechende UI Komponente updaten
                    Spieler spieler = Spieler.getInstance();
                    geldAnzahl.setText("" + spieler.getGeld());
                    fleischAnzahlID.setText("" + spieler.getAktuellerStandort().getFleisch());
                    mehlAnzahlID.setText("" + spieler.getAktuellerStandort().getMehl());
                    veggieAnzahlID.setText("" + spieler.getAktuellerStandort().getGemuese());
                    gutscheineAnzahl.setText("" + spieler.getGutschein());
                    truppenAnzahl.get(0).setText("" + spieler.getAktuellerStandort().getLt1());
                    truppenAnzahl.get(1).setText("" + spieler.getAktuellerStandort().getLt2());
                    truppenAnzahl.get(2).setText("" + spieler.getAktuellerStandort().getMt1());
                    truppenAnzahl.get(3).setText("" + spieler.getAktuellerStandort().getMt2());
                    truppenAnzahl.get(4).setText("" + spieler.getAktuellerStandort().getSt1());
                    truppenAnzahl.get(5).setText("" + spieler.getAktuellerStandort().getSt2());
                    truppenAnzahl.get(6).setText("" + spieler.getAktuellerStandort().getTt1());
                    truppenAnzahl.get(7).setText("" + spieler.getAktuellerStandort().getTt2());
                    truppenAnzahl.get(8).setText("" + spieler.getAktuellerStandort().getXt1());
                    truppeniaAnzahl.get(0).setText("" + spieler.getAktuellerStandort().getLt1ia());
                    truppeniaAnzahl.get(1).setText("" + spieler.getAktuellerStandort().getLt2ia());
                    truppeniaAnzahl.get(2).setText("" + spieler.getAktuellerStandort().getMt1ia());
                    truppeniaAnzahl.get(3).setText("" + spieler.getAktuellerStandort().getMt2ia());
                    truppeniaAnzahl.get(4).setText("" + spieler.getAktuellerStandort().getSt1ia());
                    truppeniaAnzahl.get(5).setText("" + spieler.getAktuellerStandort().getSt2ia());
                    truppeniaAnzahl.get(6).setText("" + spieler.getAktuellerStandort().getTt1ia());
                    truppeniaAnzahl.get(7).setText("" + spieler.getAktuellerStandort().getTt2ia());
                    truppeniaAnzahl.get(8).setText("" + spieler.getAktuellerStandort().getXt1ia());
                    kapazitaetLabel.setText("" + spieler.getAktuellerStandort().getKapazitaet());


                    if (!spieler.getAktuellerStandort().isHauptGebauedeImBau()) {

                        imBauBasis.setVisible(false);

                        if (spieler.getAktuellerStandort().getHauptgebaeudeLvl() != 3)
                            aufwertenBasis.setDisable(false);
                    }


                    for (Gebaeude g : spieler.getAktuellerStandort().getGebaeudes()) {

                        try {
                            if (g != null) {
                                if (g.getTyp().contains("R1") && !g.isImBau()) {
                                    ltGroup.setVisible(true);
                                } else if (g.getTyp().contains("R2") && !g.isImBau()) {
                                    ltGroup.setVisible(true);
                                    mtGroup.setVisible(true);
                                } else if (g.getTyp().contains("R3") && !g.isImBau()) {
                                    ltGroup.setVisible(true);
                                    mtGroup.setVisible(true);
                                    stGroup.setVisible(true);
                                } else {
                                }
                            }
                        } catch (NullPointerException e) {
                           // e.printStackTrace();

                        }
                    }


                    for (int i = 0; i <= 8; i++) {

                        try {
                            if (!spieler.getAktuellerStandort().getGebaeudes()[i].isImBau()) {
                                imBau.get(i).setVisible(false);
                                if (spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().equals("KP1") ||
                                        spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().equals("MP1") ||
                                        spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().equals("PP1")) {
                                    handelspostenTab.setDisable(false);
                                }
                                if ((spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().equals("KD1") ||
                                        spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().equals("MD1") ||
                                        spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().equals("PD1"))
                                        && spieler.isDarfForschen() == false) {
                                    spieler.setDarfForschen(true);
                                    String[] befehl = {"SPEICHERN", "DARFFORSCHEN", spieler.getId()};
                                    BefehlHandler.getInstance().sendeBefehl(befehl);
                                    forschenTab.setDisable(false);
                                }

                                if (!spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().contains("3"))
                                    aufwertenButtons.get(i).setDisable(false);
                            }

                        } catch (NullPointerException e) {
                            //e.printStackTrace();
                        }

                    }

                    if (spieler.getAktuellerStandort().getLt1ia() == 0)
                        truppenOk.get(0).setDisable(false);
                    if (spieler.getAktuellerStandort().getLt2ia() == 0)
                        truppenOk.get(1).setDisable(false);
                    if (spieler.getAktuellerStandort().getMt1ia() == 0)
                        truppenOk.get(2).setDisable(false);
                    if (spieler.getAktuellerStandort().getMt2ia() == 0)
                        truppenOk.get(3).setDisable(false);
                    if (spieler.getAktuellerStandort().getSt1ia() == 0)
                        truppenOk.get(4).setDisable(false);
                    if (spieler.getAktuellerStandort().getSt2ia() == 0)
                        truppenOk.get(5).setDisable(false);
                    if (spieler.getAktuellerStandort().getTt1ia() == 0)
                        truppenOk.get(6).setDisable(false);
                    if (spieler.getAktuellerStandort().getTt2ia() == 0)
                        truppenOk.get(7).setDisable(false);
                    if (spieler.getAktuellerStandort().getXt1ia() == 0 && spieler.getAktuellerStandort().getXt1() == 0)
                        truppenOk.get(8).setDisable(false);

                    activateCBaum();
                    activateFBaum();
                    if (!Spieler.getInstance().getFranchise().getId().equals("0")) {
                        activateGBaum();
                    }

                }
            });

            // Thread schlafen
            try {
                // fuer 5 Sekunden
                sleep(TimeUnit.SECONDS.toMillis(1));
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
                //ex.printStackTrace();
            }
        }


    }

    /**
     * Die Knoten deaktivieren bzw aktivieren sofern ein Knoten die Bedingung erfuellt erforscht zu werden (Charakterbaum)
     */
    public void activateCBaum() {
        int j = 0;
        for (char i = 'A'; i <= 'S'; i++) {
            // Gerade Skillbare Knoten
            if (Spieler.getInstance().getCharakterBaum().isActivable("" + i) == true) {
                cBaumListe.get(j).setDisable(false);
                // fBaumListe.get(j).setVisible(false);
                cBaumListe.get(j).setFill(Color.web("grey", 0));
            }
            //deaktivierte Knoten
            else if (Spieler.getInstance().getCharakterBaum().isActivable("" + i) == false) {
                cBaumListe.get(j).setDisable(true);
                cBaumListe.get(j).setFill(Color.web("grey", 0.7));
                if (Spieler.getInstance().getCharakterBaum().searchBaumknoten("" + i).getActivate() == 1) {
                    cBaumListe.get(j).setFill(Color.web("yellow", 0.4));
                } else if (Spieler.getInstance().getCharakterBaum().searchBaumknoten("" + i).getActivate() == 2) {
                    cBaumListe.get(j).setFill(Color.web("red", 0.4));
                }

            }
            j++;
        }
    }

    /**
     * Die Knoten deaktivieren bzw aktivieren sofern ein Knoten die Bedingung erfuellt erforscht zu werden ( Fraktionsbaum)
     */
    public void activateFBaum() {

        int j = 0;
        for (char i = 'A'; i <= 'S'; i++) {
            // Gerade Skillbare Knoten
            if (Spieler.getInstance().getFraktionsBaum().isActivable("" + i) == true) {
                fBaumListe.get(j).setDisable(false);
                // fBaumListe.get(j).setVisible(false);
                fBaumListe.get(j).setFill(Color.web("grey", 0));
            }
            //deaktivierte Knoten
            else if (Spieler.getInstance().getFraktionsBaum().isActivable("" + i) == false) {
                fBaumListe.get(j).setDisable(true);
                fBaumListe.get(j).setFill(Color.web("grey", 0.7));
                if (Spieler.getInstance().getFraktionsBaum().searchBaumknoten("" + i).getActivate() == 1) {
                    fBaumListe.get(j).setFill(Color.web("yellow", 0.4));
                } else if (Spieler.getInstance().getFraktionsBaum().searchBaumknoten("" + i).getActivate() == 2) {
                    fBaumListe.get(j).setFill(Color.web("red", 0.4));
                }

            }
            j++;
        }
    }

    /**
     * Die Knoten deaktivieren bzw aktivieren sofern ein Knoten die Bedingung erfuellt erforscht zu werden ( Franchisebaum)
     */
    public void activateGBaum() {
        int j = 0;
        for (char i = 'A'; i <= 'S'; i++) {
            // Gerade Skillbare Knoten
            if (Spieler.getInstance().getFranchise().getForschungsbaum().isActivable("" + i) == true) {
                if (Spieler.getInstance().getFranchise().getCEO().equals(Spieler.getInstance().getName())) {
                    gBaumListe.get(j).setDisable(false);
                }
                // fBaumListe.get(j).setVisible(false);
                gBaumListe.get(j).setFill(Color.web("grey", 0));
            }
            //deaktivierte Knoten
            else if (Spieler.getInstance().getFranchise().getForschungsbaum().isActivable("" + i) == false) {
                gBaumListe.get(j).setDisable(true);
                gBaumListe.get(j).setFill(Color.web("grey", 0.7));
                if (Spieler.getInstance().getFranchise().getForschungsbaum().searchBaumknoten("" + i).getActivate() == 1) {
                    gBaumListe.get(j).setFill(Color.web("yellow", 0.4));
                } else if (Spieler.getInstance().getFranchise().getForschungsbaum().searchBaumknoten("" + i).getActivate() == 2) {
                    gBaumListe.get(j).setFill(Color.web("red", 0.4));
                }

            }
            j++;
        }
    }

}
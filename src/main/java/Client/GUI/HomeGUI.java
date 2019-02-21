package Client.GUI;


import Client.Threads.ForschungUpdateThread;
import Client.Threads.GebaeudeUpdateThread;
import Client.Threads.WorkerThread;
import Entities.*;
import GameLogic.*;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Autoren: Michael Schwenk, Christoph Wohlers, Jan Tilger, Jakob Grosse Boeckmann
 *
 * Die HomeGUI.Java ist der Controller fuer die Home GUI. Hier werden die Elemente
 * der Home GUI geladen und Aktionen in der Home GUI werden verarbeitet.
 */
public class HomeGUI implements Initializable {

    // Define Table

    @FXML
    TableView<BewegungenAnzeigen> bewegungTabelle;

    @FXML
    TableColumn<BewegungenAnzeigen, String> startSpalte, zielSpalte, ankunftSpalte, artSpalte;

    @FXML
    TableView<BoniAnzeigen> boniHomeTabelle;

    @FXML
    TableColumn<BoniAnzeigen, String> boniNameSpalte, boniWertSpalte;

    @FXML
    TableView<neueNachrichten> neueNachrichtenID;

    @FXML
    TableView<neueSpielerNachrichten> erhalteneNachrichtenID, gesendeteNachrichtenID;

    @FXML
    TableView<neueAuktionen> handelsPostenView;

    @FXML
    TableColumn<neueAuktionen, String> anbieterID, angebotID, angebotsMengeID, verlangteRessourceID, angebotsPreisID, auktionsIDSpalte;

    @FXML
    ComboBox neueAuktionAngebot, neueAuktionGebot;

    @FXML
    TableColumn<neueSpielerNachrichten, String> erhalteneNachrichtenAbsenderID, erhalteneNachrichtenEmpfaengerID, erhalteneNachrichtenTextID,
            gesendeteNachrichtenEmpfaengerID, gesendeteNachrichtenTextID, gesendeteNachrichtenAbsenderID;

    @FXML
    TableColumn<neueNachrichten, String> absenderID, nachrichtID;

    @FXML
    ListView<String> standorteID, mitgliederID, ankuendigungenID, boniID, homeListView;

    @FXML
    ListView<String> aufwertenListe0, aufwertenListe1, aufwertenListe2, aufwertenListe3, aufwertenListe4, aufwertenListe5, aufwertenListe6, aufwertenListe7, aufwertenListe8;

    @FXML
    Button vorherigerStandort, naechsterStandort, neueNachrichtButton, sendenButton, franchiseGruendenButton, franchiseBeitretenButton, einzahlen, nachrichtBearbeitenButton;

    @FXML
    Button aufwertenBasis, aufwerten0, aufwerten1, aufwerten2, aufwerten3, aufwerten4, aufwerten5, aufwerten6, aufwerten7, aufwerten8;

    @FXML
    Button kaufen00, kaufen01, kaufen02, kaufen03, kaufen04, kaufen05, kaufen06, kaufen07, kaufen08, kaufen09, kaufen10, kaufen11;

    @FXML
    Button aktualisiereNachrichtenButton, auktionAbschliessenButton, auktionErstellenButton, aktualisiere2, aktualisiere1, superHerstellen;

    @FXML
    Label mehlAnzahlID, fleischAnzahlID, veggieAnzahlID, geldAnzahl, gutscheineAnzahl, kapazitaetLabel, systemnachrichtAuktionLabel, ausbildungAbgebrochen, forschenFehler;

    @FXML
    Label levelplatzBasis, levelplatz1, levelplatz2, levelplatz3, levelplatz4, levelplatz5, levelplatz6, levelplatz7, levelplatz8, levelplatz9, superName, superAnzahl, superiaAnzahl;

    @FXML
    Label lt1, lt2, mt1, mt2, st1, st2, versendetLabel, franchiseTName, franchiseTCEO, franchiseGruendenFehler, franchisekasse, geldEinzahlenError, keinGeld, storeError, lkwiaAnzahl, tabletiaAnzahl, lt1iaAnzahl, lt2iaAnzahl, mt1iaAnzahl, mt2iaAnzahl, st1iaAnzahl, st2iaAnzahl;

    @FXML
    Label nameAendernFail, lkwAnzahl, tabletAnzahl, lt1Anzahl, lt2Anzahl, mt1Anzahl, mt2Anzahl, st1Anzahl, st2Anzahl, lkwDazu, tabletDazu, lt1Dazu, lt2Dazu, mt1Dazu, mt2Dazu, st1Dazu, st2Dazu;

    @FXML
    Tab standortTab, neueNachrichtTab, franchiseGruenden, franchiseTab, erhalteneNachrichtenTab, gesendeteNachrichtenTab, nachrichtenTabID, handelsPostenTabID, kampfTab;

    @FXML
    TabPane tabpane, nachrichtTabPane;

    @FXML
    ImageView imBauBasis, basisBauplatz, bauplatz1, bauplatz2, bauplatz3, bauplatz4, bauplatz5, bauplatz6, bauplatz7, bauplatz8, bauplatz9, charakterBaumView, fraktionsBaumView;

    @FXML
    TextField empfaengerFeld, franchiseName, geldmenge, neueAuktionAngebotsmenge, neueAuktionGebotsmenge, nachrichtenTextFeld;

    @FXML
    Group stGroup, mtGroup, ltGroup, superGroup;

    @FXML
    Button nameAendern, lkwPlus, tabletPlus, lt1Plus, lt2Plus, mt1Plus, mt2Plus, st1Plus, st2Plus, lkwMinus, tabletMinus, lt1Minus, lt2Minus, mt1Minus, mt2Minus, st1Minus, st2Minus, lkwOk, tabletOk, lt1Ok, lt2Ok, mt1Ok, mt2Ok, st1Ok, st2Ok;

    @FXML
    Button aktualisiereAuktionenButton, auktionAbbrechenButton, ankuendigungenSpeichern, aktualisiere3, aktualisiere4;

    @FXML
    Tooltip tooltipa0, tooltipa1, tooltipa2, tooltipa3, tooltipa4, tooltipa5, tooltipa6, tooltipa7, tooltipa8, tooltipp0, tooltipp1, tooltipp2, tooltipp3, tooltipp4, tooltipp5, tooltipp6, tooltipp7, tooltipp8;

    @FXML
    ImageView imBau1, imBau2, imBau3, imBau4, imBau5, imBau6, imBau7, imBau8, imBau9, lt1Bild, lt2Bild, mt1Bild, mt2Bild, st1Bild, st2Bild, booster11;

    @FXML
    Tab homeTab, forschungTab;

    @FXML
    Label uebernahmeTextLabel;

    @FXML
    TextField standortName;

    @FXML
    Label angreifenderStandortLabel, zielSpielerLabel, zielStandortLabel, kampfLeicht1Label,
            kampfLeicht2Label, kampfMittel1Label, kampfMittel2Label, kampfSchwer1Label,
            kampfSchwer2Label, KampfSuperLabel, kampfLeicht1AnzahlLabel, kampfLeicht2AnzahlLabel, kampfTabletAnzahlLabel,
            kampfMittel1AnzahlLabel, kampfMittel2AnzahlLabel, kampfSchwer1AnzahlLabel, kampfSchwer2AnzahlLabel, kampfSuperAnzahlLabel,
            kampfLKWAnzahlLabel, kampfErfolgLabel;

    @FXML
    Label kampfLeicht1AnzahlLabel1, kampfLeicht2AnzahlLabel1, kampfTabletAnzahlLabel1,
            kampfMittel1AnzahlLabel1, kampfMittel2AnzahlLabel1, kampfSchwer1AnzahlLabel1, kampfSchwer2AnzahlLabel1, kampfSuperAnzahlLabel1,
            kampfLKWAnzahlLabel1;

    @FXML
    Button ueberfallButton, uebernahmeButton, truppenTransferButton, kampfPlusL1Button, kampfMinusL1Button,
            kampfPlusL2Button, kampfMinusL2Button, kampfMinusTButton, kampfPlusM1Button, kampfMinusM1Button,
            kampfPlusM2Button, kampfMinusM2Button, kampfPlusS1Button, kampfMinusS1Button, kampfPlusS2Button,
            kampfMinusS2Button, kampfPlusTButton, kampfPlusLKWButton, kampfMinusLKWButton, aktualisiereTruppenAnzahlButton;

    @FXML
    CheckBox kampfSuperCheckbox;

    private boolean minTablet = false;
    private boolean minTruppe = false;
    private boolean istKampf = false;
    private boolean istTransfer = false;
    private boolean darfUebernehmen = false;
    private boolean kannUebernehmen = false;

    @FXML
    Button logoutButton;

    @FXML
    Rectangle karte00, karte01, karte02, karte03, karte04, karte05, karte06, karte07, karte08;
    @FXML
    Rectangle karte10, karte11, karte12, karte13, karte14, karte15, karte16, karte17, karte18;
    @FXML
    Rectangle karte20, karte21, karte22, karte23, karte24, karte25, karte26, karte27, karte28;
    @FXML
    Rectangle karte30, karte31, karte32, karte33, karte34, karte35, karte36, karte37, karte38;
    @FXML
    Rectangle karte40, karte41, karte42, karte43, karte44, karte45, karte46, karte47, karte48;
    @FXML
    Rectangle karte50, karte51, karte52, karte53, karte54, karte55, karte56, karte57, karte58;
    @FXML
    Rectangle karte60, karte61, karte62, karte63, karte64, karte65, karte66, karte67, karte68;
    @FXML
    Rectangle karte70, karte71, karte72, karte73, karte74, karte75, karte76, karte77, karte78;
    @FXML
    Rectangle karte80, karte81, karte82, karte83, karte84, karte85, karte86, karte87, karte88;


    private int lt1DazuInt = 0;
    private int lt2DazuInt = 0;
    private int mt1DazuInt = 0;
    private int mt2DazuInt = 0;
    private int st1DazuInt = 0;
    private int st2DazuInt = 0;
    private int tabletDazuInt = 0;
    private int lkwDazuInt = 0;


    /**
     * Die verschiedenen Knoten zum Forschen
     */
    @FXML
    Circle CA, CB, CC, CD, CE, CF, CG, CH, CI, CJ, CK, CL, CM, CN, CO, CP, CQ, CR, CS;

    @FXML
    Circle FA, FB, FC, FD, FE, FF, FG, FH, FI, FJ, FK, FL, FM, FN, FO, FP, FQ, FR, FS;

    @FXML
    Circle GA, GB, GC, GD, GE, GF, GG, GH, GI, GJ, GK, GL, GM, GN, GO, GP, GQ, GR, GS;

    Spieler spieler = Spieler.getInstance();

    /**
     * ArrayList zum einfachen iterieren durch die Knoten
     */
    private ArrayList<Circle> cBaumListe = new ArrayList<Circle>();
    private ArrayList<Circle> gBaumListe = new ArrayList<Circle>();
    private ArrayList<Circle> fBaumListe = new ArrayList<Circle>();

    private ArrayList<Rectangle> mapListe = new ArrayList<Rectangle>();


    private ArrayList<ImageView> gebaudeBilderListe = new ArrayList<ImageView>();
    private ArrayList<Label> gebaeudeLvl = new ArrayList<Label>();
    private ArrayList<ListView> aufwertenListen = new ArrayList<ListView>();
    private ArrayList<Button> aufwertenButtons = new ArrayList<Button>();

    private ArrayList<Label> truppenDazu = new ArrayList<Label>();
    private ArrayList<Button> truppenPlus = new ArrayList<Button>();
    private ArrayList<Button> truppenMinus = new ArrayList<Button>();
    private ArrayList<Button> truppenOk = new ArrayList<Button>();
    private ArrayList<Integer> truppenDazuInt = new ArrayList<Integer>();
    private ArrayList<Label> truppenAnzahl = new ArrayList<Label>();
    private ArrayList<Label> truppenia = new ArrayList<Label>();
    private ArrayList<Tooltip> tooltipsa = new ArrayList<Tooltip>();
    private ArrayList<ImageView> imBau = new ArrayList<ImageView>();

    private static final String grassURL = "file:Grass_1.png";

    BefehlHandler bh = BefehlHandler.getInstance();


    /**
     * Hier wird die Home GUI initialisiert. Zum einen werden hier FXML Elemente mit Standardwerten belegt, die davon abhaengig sind,
     * wie der Benutzer sich eingeloggt/ registriert hat und zum anderen werden den zahlreichen Buttons etc. hier ihre Methoden zugeordnet.
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nachrichtBearbeitenButton.setDisable(true);
        nachrichtBearbeitenButton.setVisible(false);


        //homeListView.setVisible(false);

        /**
         * Logout-Button disable, da NetzwerkThread nicht richtig beendet.
         */
        logoutButton.setDisable(true);
        logoutButton.setVisible(false);

        if (spieler.isDarfForschen() == true) {
            forschungTab.setDisable(false);
        } else {
            forschungTab.setDisable(true);
        }

        aktualisiereNachrichten();
        aktualisiereBoniAnzeige();
        aktualisiereBewegungenAnzeige();

        for (int g = 0; g < spieler.getAktuellerStandort().getGebaeudes().length; g++) {
            try {
                if (spieler.getAktuellerStandort().getGebaeudes()[g].equals("KP1") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("MP1") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("PP1") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("KP2") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("MP2") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("PP2") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("KP3") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("MP3") ||
                        spieler.getAktuellerStandort().getGebaeudes()[g].equals("PP3")) {
                    handelsPostenTabID.setDisable(false);
                } else {
                    handelsPostenTabID.setDisable(true);
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

        standortListe = FXCollections.observableArrayList();

        for (Standort s : Spieler.getInstance().getStandorte()) {
            standortListe.add("ID:" + s.getId() + " Name: " + s.getName());
        }
        ;

        neueAuktionAngebot.getItems().addAll(
                "Mehl", "Fleisch", "Gemuese", "Geld"
        );

        neueAuktionGebot.getItems().addAll(
                "Mehl", "Fleisch", "Gemuese", "Geld"
        );

        neueAuktionAngebot.getSelectionModel().select(0);
        neueAuktionGebot.getSelectionModel().select(0);
        neueAuktionAngebotsmenge.setText("0");
        neueAuktionGebotsmenge.setText("0");

        final ObservableList<String> data4 = FXCollections.observableArrayList();
        try {
            for (String s : Spieler.getInstance().getFranchise().getAnkuendigungen()) {
                data4.add(s);
            }
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }


        standorteID.setItems(standortListe);
        ankuendigungenID.setItems(data4);


        versendetLabel.setText("");

        systemnachrichtAuktionLabel.setText("");

        erhalteneNachrichtenID.setItems(empfangeneNachricht);
        gesendeteNachrichtenID.setItems(gesendeteNachricht);
        neueNachrichtenID.setItems(homeEmpfangeneNachricht);
        boniHomeTabelle.setItems(boniListe);
        bewegungTabelle.setItems(bewegungenListe);


        anbieterID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("anbieterID"));
        angebotID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("angebotID"));
        angebotsMengeID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("angebotsMengeID"));
        verlangteRessourceID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("verlangteRessourceID"));
        angebotsPreisID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("angebotsPreisID"));
        auktionsIDSpalte.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("auktionsID"));

        handelsPostenView.setItems(auktionenListe);


        standortName.setText(spieler.getAktuellerStandort().getName());


        mehlAnzahlID.setText("" + Spieler.getInstance().getAktuellerStandort().getMehl());
        fleischAnzahlID.setText("" + Spieler.getInstance().getAktuellerStandort().getFleisch());
        veggieAnzahlID.setText("" + Spieler.getInstance().getAktuellerStandort().getGemuese());

        geldAnzahl.setText("" + Spieler.getInstance().getGeld());
        gutscheineAnzahl.setText("" + Spieler.getInstance().getGutschein());
        String[] array = {"ANFRAGE", "STANDORTKAP", Spieler.getInstance().getAktuellerStandort().getId()};
        String answer[] = bh.sendeBefehl(array);
        //System.out.println("KAPAZITAeT " + answer[1]);
        kapazitaetLabel.setText(answer[1]);

        initCBaum();
        initFBaum();
        initGBaum();
        setTooltipps(cBaumListe);
        setTooltipps(fBaumListe);
        activateCBaum();
        activateFBaum();

        gebaudeBilderListe.add(bauplatz1);
        gebaudeBilderListe.add(bauplatz2);
        gebaudeBilderListe.add(bauplatz3);
        gebaudeBilderListe.add(bauplatz4);
        gebaudeBilderListe.add(bauplatz5);
        gebaudeBilderListe.add(bauplatz6);
        gebaudeBilderListe.add(bauplatz7);
        gebaudeBilderListe.add(bauplatz8);
        gebaudeBilderListe.add(bauplatz9);

        gebaeudeLvl.add(levelplatz1);
        gebaeudeLvl.add(levelplatz2);
        gebaeudeLvl.add(levelplatz3);
        gebaeudeLvl.add(levelplatz4);
        gebaeudeLvl.add(levelplatz5);
        gebaeudeLvl.add(levelplatz6);
        gebaeudeLvl.add(levelplatz7);
        gebaeudeLvl.add(levelplatz8);
        gebaeudeLvl.add(levelplatz9);

        aufwertenListen.add(aufwertenListe0);
        aufwertenListen.add(aufwertenListe1);
        aufwertenListen.add(aufwertenListe2);
        aufwertenListen.add(aufwertenListe3);
        aufwertenListen.add(aufwertenListe4);
        aufwertenListen.add(aufwertenListe5);
        aufwertenListen.add(aufwertenListe6);
        aufwertenListen.add(aufwertenListe7);
        aufwertenListen.add(aufwertenListe8);

        aufwertenButtons.add(aufwerten0);
        aufwertenButtons.add(aufwerten1);
        aufwertenButtons.add(aufwerten2);
        aufwertenButtons.add(aufwerten3);
        aufwertenButtons.add(aufwerten4);
        aufwertenButtons.add(aufwerten5);
        aufwertenButtons.add(aufwerten6);
        aufwertenButtons.add(aufwerten7);
        aufwertenButtons.add(aufwerten8);

        truppenDazu.add(lt1Dazu);
        truppenDazu.add(lt2Dazu);
        truppenDazu.add(mt1Dazu);
        truppenDazu.add(mt2Dazu);
        truppenDazu.add(st1Dazu);
        truppenDazu.add(st2Dazu);
        truppenDazu.add(tabletDazu);
        truppenDazu.add(lkwDazu);

        truppenPlus.add(lt1Plus);
        truppenPlus.add(lt2Plus);
        truppenPlus.add(mt1Plus);
        truppenPlus.add(mt2Plus);
        truppenPlus.add(st1Plus);
        truppenPlus.add(st2Plus);
        truppenPlus.add(tabletPlus);
        truppenPlus.add(lkwPlus);

        truppenMinus.add(lt1Minus);
        truppenMinus.add(lt2Minus);
        truppenMinus.add(mt1Minus);
        truppenMinus.add(mt2Minus);
        truppenMinus.add(st1Minus);
        truppenMinus.add(st2Minus);
        truppenMinus.add(tabletMinus);
        truppenMinus.add(lkwMinus);

        truppenOk.add(lt1Ok);
        truppenOk.add(lt2Ok);
        truppenOk.add(mt1Ok);
        truppenOk.add(mt2Ok);
        truppenOk.add(st1Ok);
        truppenOk.add(st2Ok);
        truppenOk.add(tabletOk);
        truppenOk.add(lkwOk);
        truppenOk.add(superHerstellen);


        truppenDazuInt.add(lt1DazuInt);
        truppenDazuInt.add(lt2DazuInt);
        truppenDazuInt.add(mt1DazuInt);
        truppenDazuInt.add(mt2DazuInt);
        truppenDazuInt.add(st1DazuInt);
        truppenDazuInt.add(st2DazuInt);
        truppenDazuInt.add(tabletDazuInt);
        truppenDazuInt.add(lkwDazuInt);


        truppenAnzahl.add(lt1Anzahl);
        truppenAnzahl.add(lt2Anzahl);
        truppenAnzahl.add(mt1Anzahl);
        truppenAnzahl.add(mt2Anzahl);
        truppenAnzahl.add(st1Anzahl);
        truppenAnzahl.add(st2Anzahl);
        truppenAnzahl.add(tabletAnzahl);
        truppenAnzahl.add(lkwAnzahl);
        truppenAnzahl.add(superAnzahl);

        truppenia.add(lt1iaAnzahl);
        truppenia.add(lt2iaAnzahl);
        truppenia.add(mt1iaAnzahl);
        truppenia.add(mt2iaAnzahl);
        truppenia.add(st1iaAnzahl);
        truppenia.add(st2iaAnzahl);
        truppenia.add(tabletiaAnzahl);
        truppenia.add(lkwiaAnzahl);
        truppenia.add(superiaAnzahl);

        tooltipsa.add(tooltipa0);
        tooltipsa.add(tooltipa1);
        tooltipsa.add(tooltipa2);
        tooltipsa.add(tooltipa3);
        tooltipsa.add(tooltipa4);
        tooltipsa.add(tooltipa5);
        tooltipsa.add(tooltipa6);
        tooltipsa.add(tooltipa7);
        tooltipsa.add(tooltipa8);

        imBau.add(imBau1);
        imBau.add(imBau2);
        imBau.add(imBau3);
        imBau.add(imBau4);
        imBau.add(imBau5);
        imBau.add(imBau6);
        imBau.add(imBau7);
        imBau.add(imBau8);
        imBau.add(imBau9);

        ankuendigungenID.setCellFactory(TextFieldListCell.forListView());


        Image imBauImg = new Image("/Bilder/FoodWarsImBau.png");

        imBauBasis.setImage(imBauImg);

        for (ImageView iv : imBau) {
            iv.setImage(imBauImg);
        }


        for (int i = 0; i <= 7; i++) {
            truppenDazu.get(i).setText("" + truppenDazuInt.get(i));
        }

        for (Button b : truppenPlus) {
            b.setOnMousePressed(this::handleButtonActionTruppenPlus);
        }

        for (Button b : truppenMinus) {
            b.setOnMousePressed(this::handleButtonActionTruppenMinus);
        }

        for (Button b : truppenOk) {
            b.setOnMousePressed(this::handleButtonActionTruppenOk);
        }

        truppenia.get(0).setText("" + Spieler.getInstance().getAktuellerStandort().getLt1ia());
        truppenia.get(1).setText("" + Spieler.getInstance().getAktuellerStandort().getLt2ia());
        truppenia.get(2).setText("" + Spieler.getInstance().getAktuellerStandort().getMt1ia());
        truppenia.get(3).setText("" + Spieler.getInstance().getAktuellerStandort().getMt2ia());
        truppenia.get(4).setText("" + Spieler.getInstance().getAktuellerStandort().getSt1ia());
        truppenia.get(5).setText("" + Spieler.getInstance().getAktuellerStandort().getSt2ia());
        truppenia.get(6).setText("" + Spieler.getInstance().getAktuellerStandort().getTt1ia());
        truppenia.get(7).setText("" + Spieler.getInstance().getAktuellerStandort().getTt2ia());

        ltGroup.setVisible(false);
        mtGroup.setVisible(false);
        stGroup.setVisible(false);
        superGroup.setVisible(false);

        if (Spieler.getInstance().getFraktion().equals("K")) {
            lt1.setText("ChickenWings");
            lt1Bild.setImage(new Image("/Bilder/chicken-leg.png"));
            lt2.setText("FiletChicken");
            mt1.setText("Burger");
            mt1Bild.setImage(new Image("/Bilder/hamburger.png"));
            mt2.setText("Wraps");
            mt2Bild.setImage(new Image("/Bilder/wrap.png"));
            st1.setText("SpecialWings");
            st1Bild.setImage(new Image("/Bilder/chicken-leg.png"));
            st2.setText("SpecialFilet");

            kampfLeicht1Label.setText("ChickenWings");
            kampfLeicht2Label.setText("FiletChicken");
            kampfMittel1Label.setText("Burger");
            kampfMittel2Label.setText("Wraps");
            kampfSchwer1Label.setText("SpecialWings");
            kampfSchwer2Label.setText("SpecialFilet");
            KampfSuperLabel.setText("Super-KFC-Chick");

            superName.setText("Super-KFC-Chick");

        } else if (Spieler.getInstance().getFraktion().equals("M")) {
            lt1.setText("Pommes");
            lt1Bild.setImage(new Image("/Bilder/fries.png"));
            lt2.setText("Salat");
            lt2Bild.setImage(new Image("/Bilder/salad.png"));
            mt1.setText("Burger");
            mt1Bild.setImage(new Image("/Bilder/burger.png"));
            mt2.setText("Apfeltasche");
            st1.setText("King Burger");
            st1Bild.setImage(new Image("/Bilder/burgerXL.png"));
            st2.setText("Chef Salat");
            st2Bild.setImage(new Image("/Bilder/saladchef.png"));

            kampfLeicht1Label.setText("Pommes");
            kampfLeicht2Label.setText("Salat");
            kampfMittel1Label.setText("Burger");
            kampfMittel2Label.setText("Apfeltasche");
            kampfSchwer1Label.setText("King Burger");
            kampfSchwer2Label.setText("Chef Salat");
            KampfSuperLabel.setText("Super-MC-King");

            superName.setText("Super-MC-King");

        } else {
            lt1.setText("Margherita");
            lt1Bild.setImage(new Image("/Bilder/margherita.png"));
            lt2.setText("Pizzabrot");
            lt2Bild.setImage(new Image("/Bilder/sandwich.png"));
            mt1.setText("Salami");
            mt1Bild.setImage(new Image("/Bilder/pizza.png"));
            mt2.setText("Spezial");
            mt2Bild.setImage(new Image("/Bilder/mushrooms.png"));
            st1.setText("Diavolo");
            st1Bild.setImage(new Image("/Bilder/chili-pepper.png"));
            st2.setText("Calzone");
            st2Bild.setImage(new Image("/Bilder/pizzakarton.png"));

            kampfLeicht1Label.setText("Margherita");
            kampfLeicht2Label.setText("Pizzabrot");
            kampfMittel1Label.setText("Salami");
            kampfMittel2Label.setText("Spezial");
            kampfSchwer1Label.setText("Diavolo");
            kampfSchwer2Label.setText("Calzone");
            KampfSuperLabel.setText("Super-Pizza-Man");

            superName.setText("Super-Pizza-Man");

        }

        kampfErfolgLabel.setText("");

        uebernahmeTextLabel.setText("Uebernimmt den Ziel-Standort. Eine Rechtsabteilung wird benoetigt!");

        ueberfallButton.setDisable(true);
        uebernahmeButton.setDisable(true);
        truppenTransferButton.setDisable(true);

        setzeKampfLabelZurueck();


        superAnzahl.setText("" + spieler.getAktuellerStandort().getXt1());
        superiaAnzahl.setText("" + spieler.getAktuellerStandort().getXt1ia());

        if (spieler.getAktuellerStandort().getXt1ia() != 0 || spieler.getAktuellerStandort().getXt1() != 0) {
            superHerstellen.setDisable(true);
        }


        /**
         * Truppenbewegung-Buttons
         */
        ueberfallButton.setOnAction(this::ueberfallAction);
        uebernahmeButton.setOnAction(this::uebernahmeAction);
        truppenTransferButton.setOnAction(this::truppenTransferAction);
        kampfPlusL1Button.setOnAction(this::kampfPlusL1Action);
        kampfPlusL2Button.setOnAction(this::kampfPlusL2Action);
        kampfPlusM1Button.setOnAction(this::kampfPlusM1Action);
        kampfPlusM2Button.setOnAction(this::kampfPlusM2Action);
        kampfPlusS1Button.setOnAction(this::kampfPlusS1Action);
        kampfPlusS2Button.setOnAction(this::kampfPlusS2Action);
        kampfMinusL1Button.setOnAction(this::kampfMinusL1Action);
        kampfMinusL2Button.setOnAction(this::kampfMinusL2Action);
        kampfMinusM1Button.setOnAction(this::kampfMinusM1Action);
        kampfMinusM2Button.setOnAction(this::kampfMinusM2Action);
        kampfMinusS1Button.setOnAction(this::kampfMinusS1Action);
        kampfMinusS2Button.setOnAction(this::kampfMinusS2Action);
        kampfPlusTButton.setOnAction(this::kampfPlusTAction);
        kampfMinusTButton.setOnAction(this::kampfMinusTAction);
        kampfPlusLKWButton.setOnAction(this::kampfPlusLKWAction);
        kampfMinusLKWButton.setOnAction(this::kampfMinusLKWAction);
        nameAendern.setOnAction(this::handleButtonActionNameAendern);

        nameAendernFail.setVisible(false);

        naechsterStandort.setOnAction(this::handleButtonActionNaechsterStandort);
        vorherigerStandort.setOnAction(this::handleButtonActionVorherigerStandort);


        lt1Anzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getLt1());
        lt2Anzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getLt2());
        mt1Anzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getMt1());
        mt2Anzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getMt2());
        st1Anzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getSt1());
        st2Anzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getSt2());
        tabletAnzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getTt1());
        lkwAnzahl.setText("" + Spieler.getInstance().getAktuellerStandort().getTt2());


        TruppenEigenschaften te = TruppenEigenschaften.getInstance();
        tooltipp0.setText("Preis:" + "\n" + "Mehl: " + te.getL1()[0] + "\n" + "Fleisch: " + te.getL1()[1] + "\n" + "Veggies: " + te.getL1()[2]);
        tooltipp1.setText("Preis:" + "\n" + "Mehl: " + te.getL2()[0] + "\n" + "Fleisch: " + te.getL2()[1] + "\n" + "Veggies: " + te.getL2()[2]);
        tooltipp2.setText("Preis:" + "\n" + "Mehl: " + te.getM1()[0] + "\n" + "Fleisch: " + te.getM1()[1] + "\n" + "Veggies: " + te.getM1()[2]);
        tooltipp3.setText("Preis:" + "\n" + "Mehl: " + te.getM2()[0] + "\n" + "Fleisch: " + te.getM2()[1] + "\n" + "Veggies: " + te.getM2()[2]);
        tooltipp4.setText("Preis:" + "\n" + "Mehl: " + te.getS1()[0] + "\n" + "Fleisch: " + te.getS1()[1] + "\n" + "Veggies: " + te.getS1()[2]);
        tooltipp5.setText("Preis:" + "\n" + "Mehl: " + te.getS2()[0] + "\n" + "Fleisch: " + te.getS2()[1] + "\n" + "Veggies: " + te.getS2()[2]);
        tooltipp6.setText("Preis:" + "\n" + "Mehl: " + te.getT1()[0] + "\n" + "Fleisch: " + te.getT1()[1] + "\n" + "Veggies: " + te.getT1()[2]);
        tooltipp7.setText("Preis:" + "\n" + "Mehl: " + te.getT2()[0] + "\n" + "Fleisch: " + te.getT2()[1] + "\n" + "Veggies: " + te.getT2()[2]);
        tooltipp8.setText("Preis:" + "\n" + "Mehl: " + te.getX1()[0] + "\n" + "Fleisch: " + te.getX1()[1] + "\n" + "Veggies: " + te.getX1()[2]);


        setzeBilder(Spieler.getInstance().getAktuellerStandort().getGebaeudes());
        setzeBaustellen();

        aufwertenBasis.setOnAction(this::handleButtonActionAufwertenHG);
        aufwerten0.setOnAction(this::handleButtonActionAufwerten);
        aufwerten1.setOnAction(this::handleButtonActionAufwerten);
        aufwerten2.setOnAction(this::handleButtonActionAufwerten);
        aufwerten3.setOnAction(this::handleButtonActionAufwerten);
        aufwerten4.setOnAction(this::handleButtonActionAufwerten);
        aufwerten5.setOnAction(this::handleButtonActionAufwerten);
        aufwerten6.setOnAction(this::handleButtonActionAufwerten);
        aufwerten7.setOnAction(this::handleButtonActionAufwerten);
        aufwerten8.setOnAction(this::handleButtonActionAufwerten);

        kaufen00.setOnAction((this::shopEinkaufen));
        kaufen01.setOnAction((this::shopEinkaufen));
        kaufen02.setOnAction((this::shopEinkaufen));
        kaufen03.setOnAction((this::shopEinkaufen));
        kaufen04.setOnAction((this::shopEinkaufen));
        kaufen05.setOnAction((this::shopEinkaufen));
        kaufen06.setOnAction((this::shopEinkaufen));
        kaufen07.setOnAction((this::shopEinkaufen));
        kaufen08.setOnAction((this::shopEinkaufen));
        kaufen09.setOnAction((this::shopEinkaufen));
        kaufen10.setOnAction((this::shopEinkaufen));
        kaufen11.setOnAction((this::shopEinkaufen));

        aktualisiere1.setOnAction((this::aktualisiereGUI));
        aktualisiere2.setOnAction((this::aktualisiereGUI));
        aktualisiere3.setOnAction((this::aktualisiereGUI));
        aktualisiere4.setOnAction((this::aktualisiereGUI));

        ankuendigungenSpeichern.setOnAction((this::handleButtonActionAnkuendigungenSpeichern));


        neueNachrichtButton.setOnAction(this::neueNachrichtAction);
        sendenButton.setOnAction(this::sendeNachrichtAction);
        erhalteneNachrichtenTab.setOnSelectionChanged(this::aktualisiereNachrichtenTab);
        gesendeteNachrichtenTab.setOnSelectionChanged(this::aktualisiereNachrichtenTab);
        franchiseGruendenButton.setOnAction(this::franchiseErstellen);
        franchiseBeitretenButton.setOnAction(this::franchiseBeitreten);
        nachrichtenTabID.setOnSelectionChanged(this::ladeNachrichten);
        aktualisiereNachrichtenButton.setOnAction(this::handleButtonActionAktualisieren);
        einzahlen.setOnAction(this::geldEinzahlen);
        auktionErstellenButton.setOnAction(this::auktionErstellen);
        aktualisiereAuktionenButton.setOnAction(this::aktualisiereAuktionen);
        auktionAbbrechenButton.setOnAction(this::auktionAbbrechen);
        handelsPostenTabID.setOnSelectionChanged(this::ladeHandelsposten);
        neueNachrichtTab.setOnSelectionChanged(this::neueNachrichtFenster);
        homeTab.setOnSelectionChanged(this::homeTabWahl);
        kampfTab.setOnClosed(this::kampfTabAusAction);
        aktualisiereTruppenAnzahlButton.setOnAction(this::aktualisiereTruppenAnzahlAction);

        nachrichtBearbeitenButton.setOnAction(this::nachrichtBearbeitenAction);

        nachrichtenTextFeld.setOnKeyPressed(this::nachrichtlaengePruefenAction);


        for (int i = 0; i <= 8; i++) {

            try {
                if (Spieler.getInstance().getAktuellerStandort().getGebaeudes()[i] != null) {
                    if (Spieler.getInstance().getAktuellerStandort().getGebaeudes()[i].getTyp().contains("3"))
                        aufwertenButtons.get(i).setDisable(true);
                }
            } catch (NullPointerException e) {
                //e.printStackTrace();
            }
        }


        new Thread(new WorkerThread(geldAnzahl, mehlAnzahlID, fleischAnzahlID, veggieAnzahlID, gutscheineAnzahl, imBau,
                truppenOk, aufwertenButtons, truppenAnzahl, truppenia, ltGroup, mtGroup, stGroup,
                handelsPostenTabID, forschungTab, kapazitaetLabel, cBaumListe, gBaumListe, fBaumListe, aufwertenBasis, imBauBasis)).start();


        logoutButton.setOnAction(this::logoutAction);

        auktionAbschliessenButton.setOnAction(this::auktionAbschliessen);

        /** Initalisiert die Franchise auf ebene der GUI
         * aktivieren/deaktivieren der Tabs
         * Laden des Baums ...*/
        if (Spieler.getInstance().getFranchise().getCEO() == null) {
            franchiseTab.setDisable(true);
            franchiseGruenden.setDisable(false);
        } else {
            loadFranchise();
            franchiseGruenden.setDisable(true);
            franchiseTab.setDisable(false);
            setTooltipps(gBaumListe);
            activateGBaum();
            geldEinzahlenError.setText("");
        }

        if (Spieler.getInstance().getCharakter().equals("D")) {
            charakterBaumView.setImage(new Image("/Bilder/CD.png"));
            booster11.setImage(new Image("/Bilder/Booster11D.png"));
        } else if (Spieler.getInstance().getCharakter().equals("K")) {
            charakterBaumView.setImage(new Image("/Bilder/CK.png"));
            booster11.setImage(new Image("/Bilder/Booster11K.png"));
        }

        if (Spieler.getInstance().getFraktion().equals("K")) {
            fraktionsBaumView.setImage(new Image("/Bilder/FK.png"));
        } else if (Spieler.getInstance().getFraktion().equals("M")) {
            fraktionsBaumView.setImage(new Image("/Bilder/FM.png"));
        } else {
            fraktionsBaumView.setImage(new Image("/Bilder/FP.png"));
        }
        /** Initalisierung des Karten Attributs + Aufruf der MEthode zum zeichen*/

        initMapListe();
        initMap();

        kampfTab.setDisable(true);

    }

    /**
     * Wenn eine Nachricht zu lang ist und er Textfeld gesperrt wurde, kann
     * mit dem Bearbeiten-Button ein Zeichen geloescht werden und das Textfeld
     * wieder frei gegeben werden.
     *
     * @param event
     */
    @FXML
    private void nachrichtBearbeitenAction(ActionEvent event) {
        String text = nachrichtenTextFeld.getText();
        nachrichtenTextFeld.setText(text.substring(0, 99));
        nachrichtenTextFeld.setDisable(false);
        nachrichtBearbeitenButton.setVisible(false);
        nachrichtBearbeitenButton.setDisable(true);
    }

    /**
     * Die Laenge einer Nachricht wird geprueft.
     *
     * @param event
     */
    @FXML
    private void nachrichtlaengePruefenAction(Event event) {
        if (nachrichtenTextFeld.getText().length() >= 100) {
            nachrichtenTextFeld.setDisable(true);
            nachrichtBearbeitenButton.setVisible(true);
            nachrichtBearbeitenButton.setDisable(false);
        } else {
            nachrichtenTextFeld.setDisable(false);
            nachrichtBearbeitenButton.setVisible(false);
            nachrichtBearbeitenButton.setDisable(true);
        }
    }

    boolean kampfTabKannAus = false;

    /**
     * Prueft, ob der KampfTab deaktiviert werden darf.
     *
     * @param event
     */
    @FXML
    private void kampfTabAusAction(Event event) {
        if (kampfTabKannAus) {
            kampfTab.setDisable(true);
            kampfTabKannAus = false;
            setzeKampfLabelZurueck();
            kannUebernehmen = false;
        }
    }

    /**
     * Aktualisiert beim Waehlen des HomeTabs die Home-Seite.
     *
     * @param event
     */
    @FXML
    private void homeTabWahl(Event event) {
        //aktualisiereGUIMethode();
    }

    /**
     * Beim Klick auf Logout wird die LoginGui geladen (derzeit nicht aktiv)
     *
     * @param event
     */
    @FXML
    private void logoutAction(ActionEvent event) {
        try {
            Parent rootHome = FXMLLoader.load(getClass().getClassLoader().getResource("Ansichten/LoginGUI.fxml"));
            Scene sceneHome = new Scene(rootHome);
            Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            homeStage.setScene(sceneHome);
            setzeAllesZurueck();
            NetzwerkThreadHandler nth = NetzwerkThreadHandler.getInstance();
            homeStage.show();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    /**
     * Die Listen fuer Nachrichten, Standorte und Auktionen werden geloescht, damit
     * sie neu vom Server abgerufen werden koennen.
     */
    private void setzeAllesZurueck() {
        spieler.getEmpfangeneNachrichten().clear();
        spieler.getGesendeteNachrichten().clear();
        spieler.getStandorte().clear();
        Handelsposten.getInstance().getAuktionen().clear();

    }

    /**
     * KAMPF METHODEN
     */

    /**
     * Setzt die Labels zurueck.
     */
    private void setzeKampfLabelZurueck() {
        kampfLeicht1AnzahlLabel.setText("0");
        kampfLeicht2AnzahlLabel.setText("0");
        kampfMittel1AnzahlLabel.setText("0");
        kampfMittel2AnzahlLabel.setText("0");
        kampfSchwer1AnzahlLabel.setText("0");
        kampfSchwer2AnzahlLabel.setText("0");
        kampfTabletAnzahlLabel.setText("0");
        kampfLKWAnzahlLabel.setText("0");
        kampfSuperAnzahlLabel.setText("0");

        kampfLeicht1AnzahlLabel1.setText("0");
        kampfLeicht2AnzahlLabel1.setText("0");
        kampfMittel1AnzahlLabel1.setText("0");
        kampfMittel2AnzahlLabel1.setText("0");
        kampfSchwer1AnzahlLabel1.setText("0");
        kampfSchwer2AnzahlLabel1.setText("0");
        kampfTabletAnzahlLabel1.setText("0");
        kampfLKWAnzahlLabel1.setText("0");
        kampfSuperAnzahlLabel1.setText("0");
    }

    /**
     * Aktualisiert die Anzeige der vorhandenen Truppen im Truppenbewegung-Tab.
     */
    private void aktualisiereTruppenAnzahlAnzeige() {
        Standort ssa = spieler.getAktuellerStandort();
        kampfLeicht1AnzahlLabel1.setText("" + ssa.getLt1());
        kampfLeicht2AnzahlLabel1.setText("" + ssa.getLt2());
        kampfMittel1AnzahlLabel1.setText("" + ssa.getMt1());
        kampfMittel2AnzahlLabel1.setText("" + ssa.getMt2());
        kampfSchwer1AnzahlLabel1.setText("" + ssa.getSt1());
        kampfSchwer2AnzahlLabel1.setText("" + ssa.getSt2());
        kampfTabletAnzahlLabel1.setText("" + ssa.getTt1());
        kampfLKWAnzahlLabel1.setText("" + ssa.getTt2());
        kampfSuperAnzahlLabel1.setText("" + ssa.getXt1());
    }

    /**
     * Aktualisiert die Anzeige der vorhandenen Truppen im Truppenbewegung-Tab.
     */
    @FXML
    private void aktualisiereTruppenAnzahlAction(ActionEvent event) {
        aktualisiereTruppenAnzahlAnzeige();
    }

    /**
     * Aktualisiert die Anzeige der Truppen im Truppenbewegung-Tab.
     * Testet, ob genug Truppen ausgewaehlt wurden, um einen Angriff auszufuehren.
     */
    private void aktualisiereTruppenbewegungElemente() {

        double truppenanzahl = ((Integer.parseInt(kampfLeicht1AnzahlLabel.getText())) +
                (Integer.parseInt(kampfLeicht2AnzahlLabel.getText())) +
                (Integer.parseInt(kampfMittel1AnzahlLabel.getText())) +
                (Integer.parseInt(kampfMittel2AnzahlLabel.getText())) +
                (Integer.parseInt(kampfSchwer1AnzahlLabel.getText())) +
                (Integer.parseInt(kampfSchwer2AnzahlLabel.getText())));

        double minTablets = Math.ceil((truppenanzahl / 10));

        if (truppenanzahl > 0) {
            minTruppe = true;
        } else {
            minTruppe = false;
        }


        if ((Integer.parseInt(kampfTabletAnzahlLabel.getText())) >= minTablets &&
                (Integer.parseInt(kampfTabletAnzahlLabel.getText())) > 0) {
            minTablet = true;
        } else {
            minTablet = false;
        }

        if (minTruppe && minTablet) {
            if (istKampf && darfUebernehmen) {
                if (kannUebernehmen) {
                    uebernahmeButton.setDisable(false);
                    uebernahmeTextLabel.setText("Uebernimmt den Ziel-Standort. Eine Rechtsabteilung wird benoetigt!");
                } else {
                    uebernahmeButton.setDisable(true);
                    uebernahmeTextLabel.setText("Sie haben nicht genug Geld, um den Standort zu uebernehmen!");
                }
            } else {
                uebernahmeButton.setDisable(true);
            }

            if (istKampf) {
                ueberfallButton.setDisable(false);
            } else {
                ueberfallButton.setDisable(true);
            }

            if (istTransfer) {
                truppenTransferButton.setDisable(false);
            } else {
                truppenTransferButton.setDisable(true);
            }
        } else {
            uebernahmeButton.setDisable(true);
            ueberfallButton.setDisable(true);
            truppenTransferButton.setDisable(true);
        }

    }

    /**
     * Ein Ueberfall wird ausgefuehrt.
     *
     * @param event
     */
    @FXML
    private void ueberfallAction(ActionEvent event) {
        String truppen = "L1:" + kampfLeicht1AnzahlLabel.getText() + "/L2:" + kampfLeicht2AnzahlLabel.getText() +
                "/M1:" + kampfMittel1AnzahlLabel.getText() + "/M2:" + kampfMittel2AnzahlLabel.getText() +
                "/S1:" + kampfSchwer1AnzahlLabel.getText() + "/S2:" + kampfSchwer2AnzahlLabel.getText() +
                "/T1:" + kampfTabletAnzahlLabel.getText() + "/T2:" + kampfLKWAnzahlLabel.getText();
        if (kampfSuperCheckbox.isSelected() == true) {
            truppen += "/X1:1";
        } else {
            truppen += "/X1:0";
        }
        String[] befehl = {"TRUPPEN", "VERSCHIEBEN", spieler.getAktuellerStandort().getId(),
                spieler.getAktuellesZielID(), truppen, "UEBERFALL"};
        String[] antwort = bh.sendeBefehl(befehl);
        if (antwort[0].equals("TRUE")) {
            kampfErfolgLabel.setText("Aktion wurde erfolgreich ausgefuehrt!");
            setzeKampfLabelZurueck();
            String[] bewegung = {antwort[1]};
            bewegungAnstossen(bewegung);
        } else {
            kampfErfolgLabel.setText("Aktion konnte nicht ausgefuehrt werden!");
        }
    }

    /**
     * Eine Bewegung der Truppen zu einem anderen Standort wird gestartet.
     *
     * @param bewegung
     */
    private void bewegungAnstossen(String[] bewegung) {
        ;
        BewegungsLogic bewegungsLogic = new BewegungsLogic();
        bewegungsLogic.erzeugeBewegungen(bewegung);
    }

    /**
     * Eine Uebernahme wird gestartet.
     *
     * @param event
     */
    @FXML
    private void uebernahmeAction(ActionEvent event) {
        String truppen = "L1:" + kampfLeicht1AnzahlLabel.getText() + "/L2:" + kampfLeicht2AnzahlLabel.getText() +
                "/M1:" + kampfMittel1AnzahlLabel.getText() + "/M2:" + kampfMittel2AnzahlLabel.getText() +
                "/S1:" + kampfSchwer1AnzahlLabel.getText() + "/S2:" + kampfSchwer2AnzahlLabel.getText() +
                "/T1:" + kampfTabletAnzahlLabel.getText() + "/T2:" + kampfLKWAnzahlLabel.getText();
        if (kampfSuperCheckbox.isSelected() == true) {
            truppen += "/X1:1";
        } else {
            truppen += "/X1:0";
        }
        String[] befehl = {"TRUPPEN", "VERSCHIEBEN", spieler.getAktuellerStandort().getId(),
                spieler.getAktuellesZielID(), truppen, "UEBERNAHME"};
        String[] antwort = bh.sendeBefehl(befehl);
        if (antwort[0].equals("TRUE")) {
            kampfErfolgLabel.setText("Aktion wurde erfolgreich ausgefuehrt!");
            setzeKampfLabelZurueck();
            String[] bewegung = {antwort[1]};
            bewegungAnstossen(bewegung);
        } else {
            kampfErfolgLabel.setText("Aktion konnte nicht ausgefuehrt werden!");
        }
    }

    /**
     * Truppen werden zum angegebenen Standort tranferiert.
     *
     * @param event
     */
    @FXML
    private void truppenTransferAction(ActionEvent event) {
        String truppen = "L1:" + kampfLeicht1AnzahlLabel.getText() + "/L2:" + kampfLeicht2AnzahlLabel.getText() +
                "/M1:" + kampfMittel1AnzahlLabel.getText() + "/M2:" + kampfMittel2AnzahlLabel.getText() +
                "/S1:" + kampfSchwer1AnzahlLabel.getText() + "/S2:" + kampfSchwer2AnzahlLabel.getText() +
                "/T1:" + kampfTabletAnzahlLabel.getText() + "/T2:" + kampfLKWAnzahlLabel.getText();
        String[] befehl = {"TRUPPEN", "VERSCHIEBEN", spieler.getAktuellerStandort().getId(),
                spieler.getAktuellesZielID(), truppen, "TRANSFER"};
        String[] antwort = bh.sendeBefehl(befehl);
        if (antwort[0].equals("TRUE")) {
            kampfErfolgLabel.setText("Aktion wurde erfolgreich ausgefuehrt!");
            setzeKampfLabelZurueck();
            String[] bewegung = {antwort[1]};
            bewegungAnstossen(bewegung);
        } else {
            kampfErfolgLabel.setText("Aktion konnte nicht ausgefuehrt werden!");
        }
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusL1Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfLeicht1AnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getLt1() >= anzahl) {
            kampfLeicht1AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusL1Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfLeicht1AnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfLeicht1AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusL2Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfLeicht2AnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getLt2() >= anzahl) {
            kampfLeicht2AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusL2Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfLeicht2AnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfLeicht2AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusTAction(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfTabletAnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getTt1() >= anzahl) {
            kampfTabletAnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusTAction(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfTabletAnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfTabletAnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusLKWAction(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfLKWAnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getTt2() >= anzahl) {
            kampfLKWAnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusLKWAction(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfLKWAnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfLKWAnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusM1Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfMittel1AnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getMt1() >= anzahl) {
            kampfMittel1AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusM1Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfMittel1AnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfMittel1AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusM2Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfMittel2AnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getMt2() >= anzahl) {
            kampfMittel2AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusM2Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfMittel2AnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfMittel2AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusS1Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfSchwer1AnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getSt1() >= anzahl) {
            kampfSchwer1AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusS1Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfSchwer1AnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfSchwer1AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Erhoehen der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfPlusS2Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfSchwer2AnzahlLabel.getText()) + 1;
        if (spieler.getAktuellerStandort().getSt2() >= anzahl) {
            kampfSchwer2AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * Button zum Verringern der zu sendenden Truppen.
     *
     * @param event
     */
    @FXML
    private void kampfMinusS2Action(ActionEvent event) {
        int anzahl = Integer.parseInt(kampfSchwer2AnzahlLabel.getText()) - 1;
        if (anzahl >= 0) {
            kampfSchwer2AnzahlLabel.setText(Integer.toString(anzahl));
        }
        aktualisiereTruppenbewegungElemente();
    }

    /**
     * prueft, ob genug Ressourcen vorhanden sind.
     *
     * @param ressource
     * @param anzahl
     * @return
     */
    private boolean pruefeRessource(String ressource, int anzahl) {

        Standort s = spieler.getAktuellerStandort();

        switch (ressource) {
            case "Fleisch":

                if (anzahl <= s.getFleisch()) {
                    return true;
                } else {
                    return false;
                }
            case "Gemuese":
                if (anzahl <= s.getGemuese()) {
                    return true;
                } else {
                    return false;
                }
            case "Mehl":
                if (anzahl <= s.getMehl()) {
                    return true;
                } else {
                    return false;
                }
            case "Geld":
                if (anzahl <= spieler.getGeld()) {
                    return true;
                } else {
                    return false;
                }
        }
        return false;
    }

    /**
     * Schliesst eine Auktion ab.
     *
     * @param event
     */
    @FXML
    private void auktionAbschliessen(ActionEvent event) {

        neueAuktionen gewaehlteAuktion = handelsPostenView.getSelectionModel().getSelectedItem();

        boolean erlaubt = pruefeRessource(gewaehlteAuktion.getVerlangteRessourceID(), Integer.parseInt(gewaehlteAuktion.getAngebotsPreisID()));

        if (erlaubt) {

            HandelspostenLogic hl = new HandelspostenLogic();

            String[] antwort = hl.auktionAbschliessen(spieler.getId(), gewaehlteAuktion.getAuktionsID(), spieler.getAktuellerStandort().getId());

            if (antwort[0].equals("TRUE")) {
                aktualisiereAuktionenMethode();
                systemnachrichtAuktionLabel.setText("Die Auktion wurde erfolgreich abgeschlossen!");
            } else {
                systemnachrichtAuktionLabel.setText("Die Auktion konnte nicht abgeschlossen werden!");
            }
        } else {
            systemnachrichtAuktionLabel.setText("Sie haben nicht genug " + gewaehlteAuktion.getVerlangteRessourceID() + "!");
        }
    }

    /**
     * Erstellt eine Auktion.
     *
     * @param event
     */
    @FXML
    private void auktionErstellen(ActionEvent event) {

        boolean mengeIstZahl = true;
        boolean erlaubt = false;

        String angebotsMenge = neueAuktionAngebotsmenge.getText();
        String gebotsMenge = neueAuktionGebotsmenge.getText();

        try {
            Integer.parseInt(angebotsMenge);
            Integer.parseInt(gebotsMenge);
            erlaubt = pruefeRessource(neueAuktionAngebot.getSelectionModel().getSelectedItem().toString(),
                    Integer.parseInt(neueAuktionAngebotsmenge.getText()));
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            systemnachrichtAuktionLabel.setText("Eine der Mengenangaben ist keine Zahl");
            mengeIstZahl = false;
        }


        if (erlaubt && mengeIstZahl) {

            HandelspostenLogic hl = new HandelspostenLogic();

            String[] antwort = hl.erstelleNeueAuktion(spieler.getId().toString(), spieler.getAktuellerStandort().getId().toString(),
                    neueAuktionAngebot.getSelectionModel().getSelectedItem().toString(),
                    neueAuktionAngebotsmenge.getText(), neueAuktionGebot.getSelectionModel().getSelectedItem().toString(),
                    neueAuktionGebotsmenge.getText());

            if (antwort[0].equals("TRUE")) {
                systemnachrichtAuktionLabel.setText("Die Auktion wurde erfolgreich erstellt!");
                neueAuktionAngebot.getSelectionModel().select(3);
                neueAuktionAngebotsmenge.setText("0");
                neueAuktionAngebotsmenge.setPromptText("Menge");
                neueAuktionGebot.getSelectionModel().select(3);
                neueAuktionGebotsmenge.setText("0");
                neueAuktionGebotsmenge.setPromptText("Menge");
                aktualisiereAuktionenMethode();
            } else {
                systemnachrichtAuktionLabel.setText("Die Auktion konnte nicht erstellt werden!");
            }
        } else {
            systemnachrichtAuktionLabel.setText("Sie haben nicht genug " + neueAuktionAngebot.getSelectionModel().getSelectedItem().toString() + "!");
        }
    }

    /**
     * Bricht eine Auktion ab.
     *
     * @param event
     */
    @FXML
    private void auktionAbbrechen(ActionEvent event) {

        neueAuktionen gewaehlteAuktion = handelsPostenView.getSelectionModel().getSelectedItem();

        if (spieler.getName().equals(gewaehlteAuktion.getAnbieterID())) {

            HandelspostenLogic hl = new HandelspostenLogic();

            String[] antwort = hl.auktionLoeschen(gewaehlteAuktion.getAuktionsID(), spieler.getId());

            if (antwort[0].equals("TRUE")) {
                systemnachrichtAuktionLabel.setText("Die Auktion wurde erfolgreich geloescht!");
                aktualisiereAuktionenMethode();
            } else {
                systemnachrichtAuktionLabel.setText("Die Auktion konnte nicht geloescht werden!");
            }
        } else {
            systemnachrichtAuktionLabel.setText("Diese Auktion gehoert dir nicht!");
        }

    }

    ObservableList<neueAuktionen> auktionenListe = FXCollections.observableArrayList();

    /**
     * Aktualisiert die Auktionen im Handelsposten und in der GUI.
     *
     * @param event
     */
    @FXML
    private void aktualisiereAuktionen(ActionEvent event) {
        aktualisiereAuktionenMethode();
    }

    /**
     * Aktualisiert die Auktionen im Handelsposten und in der GUI.
     *
     * @param event
     */
    @FXML
    private void ladeHandelsposten(Event event) {
        aktualisiereAuktionenMethode();
    }

    /**
     * Aktualisiert die Auktionen im Handelsposten und in der GUI.
     */
    @FXML
    public void aktualisiereAuktionenMethode() {
        systemnachrichtAuktionLabel.setText("");
        HandelspostenLogic hl = new HandelspostenLogic();
        String answer = hl.aktualisiereAuktionen();

        try {
            anbieterID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("anbieterID"));
            angebotID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("angebotID"));
            angebotsMengeID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("angebotsMengeID"));
            verlangteRessourceID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("verlangteRessourceID"));
            angebotsPreisID.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("angebotsPreisID"));
            auktionsIDSpalte.setCellValueFactory(new PropertyValueFactory<neueAuktionen, String>("auktionsID"));
        } catch (NullPointerException e) {
            // e.printStackTrace();
        }

        auktionenListe = FXCollections.observableArrayList();


        Handelsposten hp = Handelsposten.getInstance();

        for (int i = 0; i < hp.getAuktionen().size(); i++) {
            try {
                auktionenListe.add(new neueAuktionen(hp.getAuktionen().get(i).getAnbieter(),
                        hp.getAuktionen().get(i).getAngeboteneRessource(),
                        hp.getAuktionen().get(i).getAngebotsMenge(), hp.getAuktionen().get(i).getVerlangteRessource(),
                        hp.getAuktionen().get(i).getAngebotsPreis(), hp.getAuktionen().get(i).getID()));
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        //System.out.println("Groesse der Auktionsliste in GUI: " + auktionenListe.size());


        try {
            handelsPostenView.setItems(auktionenListe);
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

    }

    /**
     * Setzt das Label zurueck, wenn man auf neue Nachricht klickt.
     *
     * @param event
     */
    @FXML
    private void neueNachrichtFenster(Event event) {
        versendetLabel.setText("");
    }

    /**
     * Oeffnet den neue Nachricht Tab beim Klick auf den Button.
     *
     * @param event
     */
    @FXML
    private void neueNachrichtAction(ActionEvent event) {
        nachrichtTabPane.getSelectionModel().select(neueNachrichtTab);
    }

    /**
     * Sendet eine Nachricht an den angegebenen Spieler.
     *
     * @param event
     */
    @FXML
    private void sendeNachrichtAction(ActionEvent event) {

        if (!(empfaengerFeld.getText().contains("#") || empfaengerFeld.getText().contains("'") ||
                nachrichtenTextFeld.getText().contains("#") || nachrichtenTextFeld.getText().contains("'"))) {

            NachrichtenLogic nl = new NachrichtenLogic();

            String[] befehl = {"ANFRAGE", "EXISTSPIELER", empfaengerFeld.getText()};

            if (bh.sendeBefehl(befehl)[0].equals("TRUE")) {
                String[] antwort = nl.sendeNachricht(spieler.getId(), empfaengerFeld.getText(), nachrichtenTextFeld.getText());


                if (antwort[0].equals("TRUE")) {
                    versendetLabel.setText("Nachricht wurde erfolgreich versandt!");
                    empfaengerFeld.setText("");
                    empfaengerFeld.setPromptText("Empfaenger");
                    nachrichtenTextFeld.setText("");
                    nachrichtenTextFeld.setPromptText("Nachricht");
                } else {
                    versendetLabel.setText("Beim Versenden der Nachricht ist ein Fehler aufgetreten!");
                }
            } else {
                versendetLabel.setText("Den angegebenen Empfaenger gibt es nicht!");
            }
        } else {
            versendetLabel.setText("Versenden nicht moeglich. \nFelder duerfen # und ' nicht enthalten!");
        }
    }

    /**
     * Aktualisiert die Spielernachrichten und zeigt sie in der GUI an.
     *
     * @param event
     */
    @FXML
    private void aktualisiereNachrichtenTab(Event event) {
        aktualisiereNachrichten();
    }

    /**
     * Aktualisiert die Spielernachrichten und zeigt sie in der GUI an.
     *
     * @param event
     */
    @FXML
    private void ladeNachrichten(Event event) {
        aktualisiereNachrichten();
    }

    /**
     * Aktualisiert die Spielernachrichten und zeigt sie in der GUI an.
     *
     * @param event
     */
    @FXML
    private void handleButtonActionAktualisieren(ActionEvent event) {
        aktualisiereNachrichten();
    }

    ObservableList<neueSpielerNachrichten> empfangeneNachricht = FXCollections.observableArrayList();
    ObservableList<neueSpielerNachrichten> gesendeteNachricht = FXCollections.observableArrayList();
    ObservableList<neueNachrichten> homeEmpfangeneNachricht = FXCollections.observableArrayList();
    ObservableList<BoniAnzeigen> boniListe = FXCollections.observableArrayList();
    ObservableList<BewegungenAnzeigen> bewegungenListe = FXCollections.observableArrayList();

    /**
     * Aktualisiert die Spielernachrichten und zeigt sie in der GUI an.
     */
    @FXML
    public void aktualisiereNachrichten() {

        NachrichtenLogic nl = new NachrichtenLogic();
        nl.aktualisiereNachrichten();

        try {
            erhalteneNachrichtenAbsenderID.setCellValueFactory(new PropertyValueFactory<neueSpielerNachrichten, String>("absenderID"));
            erhalteneNachrichtenEmpfaengerID.setCellValueFactory(new PropertyValueFactory<neueSpielerNachrichten, String>("empfaengerID"));
            erhalteneNachrichtenTextID.setCellValueFactory(new PropertyValueFactory<neueSpielerNachrichten, String>("nachrichtID"));

            gesendeteNachrichtenAbsenderID.setCellValueFactory(new PropertyValueFactory<neueSpielerNachrichten, String>("absenderID"));
            gesendeteNachrichtenEmpfaengerID.setCellValueFactory(new PropertyValueFactory<neueSpielerNachrichten, String>("empfaengerID"));
            gesendeteNachrichtenTextID.setCellValueFactory(new PropertyValueFactory<neueSpielerNachrichten, String>("nachrichtID"));

            absenderID.setCellValueFactory(new PropertyValueFactory<neueNachrichten, String>("absenderID"));
            nachrichtID.setCellValueFactory(new PropertyValueFactory<neueNachrichten, String>("nachrichtID"));
        } catch (NullPointerException e) {
            // e.printStackTrace();
        }

        empfangeneNachricht = FXCollections.observableArrayList();
        gesendeteNachricht = FXCollections.observableArrayList();
        homeEmpfangeneNachricht = FXCollections.observableArrayList();

        if (spieler.getEmpfangeneNachrichten().size() > 0) {
            for (int i = 0; i < spieler.getEmpfangeneNachrichten().size(); i++) {
                try {
                    empfangeneNachricht.add(new neueSpielerNachrichten(spieler.getEmpfangeneNachrichten().get(i).getSender(),
                            spieler.getEmpfangeneNachrichten().get(i).getEmpfaenger(), spieler.getEmpfangeneNachrichten().get(i).getNachricht()));
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }
        if (spieler.getGesendeteNachrichten().size() > 0) {
            for (int i = 0; i < spieler.getGesendeteNachrichten().size(); i++) {
                try {
                    gesendeteNachricht.add(new neueSpielerNachrichten(spieler.getGesendeteNachrichten().get(i).getSender(),
                            spieler.getGesendeteNachrichten().get(i).getEmpfaenger(), spieler.getGesendeteNachrichten().get(i).getNachricht()));
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }
        }

        if (spieler.getEmpfangeneNachrichten().size() > 0) {
            int letzteNachrichten = spieler.getEmpfangeneNachrichten().size();
            for (int k = 1; (k < 11 && (k < spieler.getEmpfangeneNachrichten().size() + 1)); k++) {
                try {
                    homeEmpfangeneNachricht.add(new neueNachrichten(spieler.getEmpfangeneNachrichten().get((letzteNachrichten - k)).getSender(),
                            spieler.getEmpfangeneNachrichten().get((letzteNachrichten - k)).getNachricht()));
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }

        try {
            erhalteneNachrichtenID.setItems(empfangeneNachricht);
            gesendeteNachrichtenID.setItems(gesendeteNachricht);
            neueNachrichtenID.setItems(homeEmpfangeneNachricht);
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

    }

    /**
     * Aktualisert die Bewegungen und zeigt sie in der GUI an.
     */
    @FXML
    private void aktualisiereBewegungenAnzeige() {
        try {
            startSpalte.setCellValueFactory(new PropertyValueFactory<BewegungenAnzeigen, String>("startSpalte"));
            zielSpalte.setCellValueFactory(new PropertyValueFactory<BewegungenAnzeigen, String>("zielSpalte"));
            ankunftSpalte.setCellValueFactory(new PropertyValueFactory<BewegungenAnzeigen, String>("ankunftSpalte"));
            artSpalte.setCellValueFactory(new PropertyValueFactory<BewegungenAnzeigen, String>("artSpalte"));
        } catch (Exception e) {
            //e.printStackTrace();
        }

        bewegungenListe = FXCollections.observableArrayList();

        try {

            if (spieler.getBewegungen().size() > 0) {

                for (int i = 0; i < spieler.getBewegungen().size(); i++) {
                    try {
                        Date zeit = new Date(spieler.getBewegungen().get(i).getAnkunft() * 1000L);
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        String formatierteZeit = sdf.format(zeit);
                        bewegungenListe.add(new BewegungenAnzeigen(spieler.getBewegungen().get(i).getStartStandort(),
                                spieler.getBewegungen().get(i).getZielStandort(),
                                formatierteZeit, spieler.getBewegungen().get(i).getArt()));
                    } catch (Exception e) {
                        //e.printStackTrace();
                    }
                }
            }

        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

        try {
            bewegungTabelle.setItems(bewegungenListe);
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

    }

    /**
     * Aktualisiert die Boni und zeigt sie in der GUI an.
     */
    @FXML
    private void aktualisiereBoniAnzeige() {
        try {
            boniNameSpalte.setCellValueFactory(new PropertyValueFactory<BoniAnzeigen, String>("boniNameSpalte"));
            boniWertSpalte.setCellValueFactory(new PropertyValueFactory<BoniAnzeigen, String>("boniWertSpalte"));
        } catch (Exception e) {
            //e.printStackTrace();
        }

        boniListe = FXCollections.observableArrayList();

        Boni boni = Boni.getInstance();

        try {
            // System.out.println("BONUS ------ " + Double.toString(boni.getVerteidigungsbonus()));

            boniListe.add(new BoniAnzeigen("Verteidigungsbonus", Double.toString(boni.getVerteidigungsbonus())));
            boniListe.add(new BoniAnzeigen("Produktionsbonus", Double.toString(boni.getProduktionsbonus())));
            boniListe.add(new BoniAnzeigen("Geldbonus", Double.toString(boni.getGeldbonus())));
            boniListe.add(new BoniAnzeigen("MehlProduktionsbonus", Double.toString(boni.getMehlProduktionsbonus())));
            boniListe.add(new BoniAnzeigen("FleischProduktionsbonus", Double.toString(boni.getFleischProduktionsbonus())));
            boniListe.add(new BoniAnzeigen("GemueseProduktionsbonus", Double.toString(boni.getGemueseProduktionsbonus())));
            boniListe.add(new BoniAnzeigen("TruppenGeschwindigkeitsbonus", Double.toString(boni.getTruppenGeschwindigkeitsbonus())));
            boniListe.add(new BoniAnzeigen("TruppenKostenbonus", Double.toString(boni.getTruppenKostenbonus())));
            boniListe.add(new BoniAnzeigen("TruppenAngriffsbonus", Double.toString(boni.getTruppenAngriffsbonus())));
            boniListe.add(new BoniAnzeigen("TruppenVerteidigungsbonus", Double.toString(boni.getTruppenVerteidigungsbonus())));
            boniListe.add(new BoniAnzeigen("ForschungsGeschwindigkeitsbonus", Double.toString(boni.getForschungsGeschwindigkeitsbonus())));
            boniListe.add(new BoniAnzeigen("ForschungsKostenbonus", Double.toString(boni.getForschungsKostenbonus())));

        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

        try {
            boniHomeTabelle.setItems(boniListe);
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

    }

    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer einen Plus-Button bei der Truppenherstellung betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf einen der zugewiesenen Button der Zwischenzaehler um eins erhoeht wird.
     *
     * @param event
     */
    @FXML
    private void handleButtonActionTruppenPlus(MouseEvent event) {

        for (int i = 0; i <= 7; i++) {
            if (truppenPlus.get(i).equals(event.getSource())) {
                truppenDazuInt.set(i, truppenDazuInt.get(i) + 1);
                truppenDazu.get(i).setText("" + truppenDazuInt.get(i));
            }
        }
    }


    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer einen Minus-Button bei der Truppenherstellung betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf einen der zugewiesenen Button der Zwischenzaehler um eins reduziert wird.
     *
     * @param event
     */
    @FXML
    private void handleButtonActionTruppenMinus(MouseEvent event) {

        for (int i = 0; i <= 7; i++) {
            if (truppenMinus.get(i).equals(event.getSource())) {
                if (truppenDazuInt.get(i) >= 1) {
                    truppenDazuInt.set(i, truppenDazuInt.get(i) - 1);
                }
                truppenDazu.get(i).setText("" + truppenDazuInt.get(i));
            }
        }
    }

    /**
     * Speichert die komplette Liste der Ankuendigungen im Server
     *
     * @param event
     */
    @FXML
    private void handleButtonActionAnkuendigungenSpeichern(ActionEvent event) {

        boolean hatUnerlaubteZeichen = false;

        String[] ankuendigungen = new String[15];
        for (int i = 0; i <= 14; i++) {
            ankuendigungen[i] = ankuendigungenID.getItems().get(i);
            if (ankuendigungen[i].contains("#") || ankuendigungen[i].contains("'")) {
                hatUnerlaubteZeichen = true;
            }
        }

        if (!hatUnerlaubteZeichen) {

            String[] array = {"FRANCHISE", "ANKUENDIGUNG", Spieler.getInstance().getFranchise().getId(), ankuendigungen[0], ankuendigungen[1], ankuendigungen[2],
                    ankuendigungen[3], ankuendigungen[4], ankuendigungen[5], ankuendigungen[6], ankuendigungen[7],
                    ankuendigungen[8], ankuendigungen[9], ankuendigungen[10], ankuendigungen[11], ankuendigungen[12],
                    ankuendigungen[13], ankuendigungen[14]};

            bh.sendeBefehl(array);
            Spieler.getInstance().getFranchise().setAnkuendigungen(ankuendigungen);
        } else {
            keinGeld.setText("Speichern nicht moeglich. Felder duerfen # und ' nicht enthalten!");
        }

    }

    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer einen Ok-Button bei der Truppenherstellung betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf einen der zugewiesenen Button der Zwischenzaehlerstand abgefragt wird und versucht wird diese
     * Anzahl an dazugehoerigen Truppen zu bauen. Die Methode prueft ob genug Ressourcen vorhanden sind und verhindert den Bau falls dem nicht so ist,
     * damit das Programm durch eine negative Ressourcen Anzahl nicht in einen fehlerhaften Zustand geraet.
     *
     * @param event
     */
    @FXML
    private void handleButtonActionTruppenOk(MouseEvent event) {

        for (int i = 0; i <= 8; i++) {
            if (truppenOk.get(i).equals(event.getSource())) {

                ausbildungAbgebrochen.setVisible(false);

                int mehl = spieler.getAktuellerStandort().getMehl();
                int fleisch = spieler.getAktuellerStandort().getFleisch();
                int veggies = spieler.getAktuellerStandort().getGemuese();
                TruppenEigenschaften te = TruppenEigenschaften.getInstance();

                if (i == 0) {
                    if (mehl - (truppenDazuInt.get(i) * te.getL1()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getL1()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getL1()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setLt1ia(Spieler.getInstance().getAktuellerStandort().getLt1ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getLt1ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "L1", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getL1()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getL1()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getL1()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }

                } else if (i == 1) {
                    if (mehl - (truppenDazuInt.get(i) * te.getL2()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getL2()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getL2()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setLt2ia(Spieler.getInstance().getAktuellerStandort().getLt2ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getLt2ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "L2", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getL2()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getL2()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getL2()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else if (i == 2) {
                    if (mehl - (truppenDazuInt.get(i) * te.getM1()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getM1()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getM1()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setMt1ia(Spieler.getInstance().getAktuellerStandort().getMt1ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getMt1ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "M1", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getM1()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getM1()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getM1()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else if (i == 3) {
                    if (mehl - (truppenDazuInt.get(i) * te.getM2()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getM2()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getM2()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setMt2ia(Spieler.getInstance().getAktuellerStandort().getMt2ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getMt2ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "M2", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getM2()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getM2()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getM2()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else if (i == 4) {
                    if (mehl - (truppenDazuInt.get(i) * te.getS1()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getS1()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getS1()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setSt1ia(Spieler.getInstance().getAktuellerStandort().getSt1ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getSt1ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "S1", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getS1()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getS1()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getS1()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else if (i == 5) {
                    if (mehl - (truppenDazuInt.get(i) * te.getS2()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getS2()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getS2()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setSt2ia(Spieler.getInstance().getAktuellerStandort().getSt2ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getSt2ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "S2", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getS2()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getS2()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getS2()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else if (i == 6) {
                    if (mehl - (truppenDazuInt.get(i) * te.getT1()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getT1()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getT1()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setTt1ia(Spieler.getInstance().getAktuellerStandort().getTt1ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getTt1ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "T1", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getT1()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getT1()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getT1()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else if (i == 7) {
                    if (mehl - (truppenDazuInt.get(i) * te.getT2()[0]) >= 0 && fleisch - (truppenDazuInt.get(i) * te.getT2()[1]) >= 0 && veggies - (truppenDazuInt.get(i) * te.getT2()[2]) >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setTt2ia(Spieler.getInstance().getAktuellerStandort().getTt2ia() + truppenDazuInt.get(i));
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getTt2ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "T2", "" + truppenDazuInt.get(i)};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getT2()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getT2()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getT2()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else if (i == 8) {
                    if (mehl - te.getX1()[0] >= 0 && fleisch - te.getX1()[1] >= 0 && veggies - te.getX1()[2] >= 0) {
                        Spieler.getInstance().getAktuellerStandort().setXt1ia(Spieler.getInstance().getAktuellerStandort().getXt1ia() + 1);
                        truppenia.get(i).setText("" + Spieler.getInstance().getAktuellerStandort().getXt1ia());
                        String[] array = {"TRUPPEN", "AUSBILDUNG", Spieler.getInstance().getAktuellerStandort().getId(), Spieler.getInstance().getFraktion(), "X1", "" + "1"};
                        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                        spieler.getAktuellerStandort().setMehl(mehl - (truppenDazuInt.get(i) * te.getX1()[0]));
                        spieler.getAktuellerStandort().setFleisch(fleisch - (truppenDazuInt.get(i) * te.getX1()[1]));
                        spieler.getAktuellerStandort().setGemuese(veggies - (truppenDazuInt.get(i) * te.getX1()[2]));
                    } else {
                        ausbildungAbgebrochen.setVisible(true);
                    }
                } else {
                }


                truppenOk.get(i).setDisable(true);


                if (i < 8) {
                    truppenDazuInt.set(i, 0);
                    truppenDazu.get(i).setText("" + truppenDazuInt.get(i));
                }
            }
        }
    }

    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer den Aufwerten Button beim Hauptgebaeude betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf den Button das Hauptgebaeude in den imBau Zustand geraet an dessen Ende das Hauptgebaeude
     * sein Level um 1 erhoeht. Das Maximale Level ist 3.
     *
     * @param event
     */
    @FXML
    private void handleButtonActionAufwertenHG(ActionEvent event) {
        int hauptgebaeudeLvl = Spieler.getInstance().getAktuellerStandort().getHauptgebaeudeLvl();

        String[] array = {"BAUEN", "UPDATE", "-1", Spieler.getInstance().getFraktion() + "H" + Integer.toString(hauptgebaeudeLvl + 1), "" + Spieler.getInstance().getId(), Spieler.getInstance().getAktuellerStandort().getId()};
        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);

        Gebaeude gebaeude = new Gebaeude("-1", "H" + (hauptgebaeudeLvl + 1), true);
        Spieler.getInstance().getAktuellerStandort().setHauptGebauedeImBau(true);
        GebaeudeUpdateThread thread = new GebaeudeUpdateThread(gebaeude, Long.parseLong(answer[1]), Spieler.getInstance().getAktuellerStandort().getId());
        thread.start();

        aufwertenBasis.setDisable(true);
        imBauBasis.setVisible(true);


        levelplatzBasis.setText("" + (Spieler.getInstance().getAktuellerStandort().getHauptgebaeudeLvl() + 1));

    }


    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer einen Aufwerten-Button der Gebaeude betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf einen der zugewiesenen Button eine ListView auf der GUI erscheint,
     * in der dem Benutzer die fuer eine Aufwertung bereitstehenden Gebaeude angezeigt werden.
     *
     * @param event
     */
    @FXML
    private void handleButtonActionAufwerten(ActionEvent event) {


        GebaudeLevelHandler glh = new GebaudeLevelHandler();
        GebaudeLevelHandler glh2 = new GebaudeLevelHandler();
        Gebaeude[] g = spieler.getAktuellerStandort().getGebaeudes();

        final ObservableList<String> aufwerten = FXCollections.observableArrayList();

        int i = ((Button) event.getSource()).getId().toString().charAt(9) - 48;

        try {
            aufwerten.addAll(glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(g[i].getTyp())));

            for (String s : glh.gebaeudeErweitern(g[i].getTyp())) {

                String[] tooltipsaarray = {"ANFRAGE", "GEBAEUDEKOSTEN", s};
                String[] tooltipsaanswer = BefehlHandler.getInstance().sendeBefehl(tooltipsaarray);
                tooltipsa.get(i).setText(" Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(g[i].getTyp()))[0] + " \n " + tooltipsaanswer[1]);
            }

        } catch (NullPointerException e) {
            //e.printStackTrace();

            aufwerten.addAll((glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))));


            String[] kosten = new String[8];
            for (int s = 0; s <= 7; s++) {
                String[] tooltipsaarray = {"ANFRAGE", "GEBAEUDEKOSTEN", glh.gebaeudeErweitern(null)[s]};
                String[] tooltipsaanswer = BefehlHandler.getInstance().sendeBefehl(tooltipsaarray);
                kosten[s] = tooltipsaanswer[1];
            }

            tooltipsa.get(i).setText(" Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[0] + " \n " + kosten[0] + " \n " +
                    "Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[1] + " \n " + kosten[1] + " \n " +
                    "Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[2] + " \n " + kosten[2] + " \n " +
                    "Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[3] + " \n " + kosten[3] + " \n " +
                    "Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[4] + " \n " + kosten[4] + " \n " +
                    "Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[5] + " \n " + kosten[5] + " \n " +
                    "Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[6] + " \n " + kosten[6] + " \n " +
                    "Preis fuer " + glh2.gebaeudeVonCodeUebersetzung(glh.gebaeudeErweitern(null))[7] + " \n " + kosten[7]);

        }

        aufwertenListen.get(i).setItems(aufwerten);
        aufwertenListen.get(i).setVisible(true);


    }


    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer ein Feld in der zuvor sichtbar gewordenen ListView auswaehlt.
     * Die Methode sorgt dafuer das beim Klick auf eins der vorhanden Elemente das Gebaeude gebaut wird, sofern genug Ressourcen vorhanden sind.
     * Dazu werden dann die neuen Werte fuer die Elemente in der GUI gesetzt und dem Server werden die Neuerungen uebermittelt.
     * Sind nicht genug Ressourcen vorhanden, so wird das Gebaeude nicht gebaut.
     *
     * @param arg0
     */
    @FXML
    public void handleMouseClickAufwertenListe(MouseEvent arg0) {
        GebaudeLevelHandler glh = new GebaudeLevelHandler();
        Gebaeude[] g = Spieler.getInstance().getAktuellerStandort().getGebaeudes();

        int i = ((ListView) arg0.getSource()).getId().toString().charAt(14) - 48;
        // System.out.println("gebaeudeliste: " + g.length + "; index: " + i);
        String gebaeudeTyp = glh.gebaeudeZuCodeUebersetzung(aufwertenListen.get(i).getSelectionModel().getSelectedItem().toString());
        String[] preisarray = {"ANFRAGE", "GEBAEUDEKOSTEN", gebaeudeTyp};
        String[] preisaanswer = BefehlHandler.getInstance().sendeBefehl(preisarray);

        int x = Integer.parseInt(preisaanswer[1]);

        try {
            if (Spieler.getInstance().getGeld() - x >= 0) {
                Spieler.getInstance().setGeld(Spieler.getInstance().getGeld() - x);
                g[i].setTyp(gebaeudeTyp);
            } else {
                return; //TODO ausgeben alter du hast keine kohle!
            }

        } catch (NullPointerException e) {

            //e.printStackTrace();

            Spieler.getInstance().setGeld(Spieler.getInstance().getGeld() - x);
            Gebaeude gebaeude = new Gebaeude();
            gebaeude.setImBau(true);
            gebaeude.setTyp(gebaeudeTyp);
            g[i] = gebaeude;
        }


        if (g[i].getTyp().contains("1")) {
            String[] array = {"BAUEN", "ERSTELLEN", "" + Spieler.getInstance().getAktuellerStandort().getId(), "" + i, g[i].getTyp(), "" + Spieler.getInstance().getId()};
            String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
            g[i].setId(answer[1]);
            if (answer[0].equals("TRUE")) {
                GebaeudeUpdateThread thread = new GebaeudeUpdateThread(g[i], Long.parseLong(answer[2]), Spieler.getInstance().getAktuellerStandort().getId());
                thread.start();
            }
        } else {
            String[] array = {"BAUEN", "UPDATE", g[i].getId(), g[i].getTyp(), "" + Spieler.getInstance().getId(), Spieler.getInstance().getAktuellerStandort().getId()};
            String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
            if (answer[0].equals("TRUE")) {
                g[i].setImBau(true);
                GebaeudeUpdateThread thread = new GebaeudeUpdateThread(g[i], Long.parseLong(answer[1]), Spieler.getInstance().getAktuellerStandort().getId());
                thread.start();
            }
        }

        Spieler.getInstance().getAktuellerStandort().setGebaeudes(g);

        /*
        String[] array = {"UPDATEGEBAEUDES" ,  "" + Spieler.getInstance().getAktuellerStandort().getId() , "" + g[0].getTyp()};
        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
        */

        aufwertenListen.get(i).setVisible(false);

        if (g[i].getTyp().contains("3")) {
            aufwertenButtons.get(i).setDisable(true);
        } else {
        }
        setzeBilder(g);
        imBau.get(i).setVisible(true);
        aufwertenButtons.get(i).setDisable(true);
    }

    /**
     * Diese Methode sorgt dafuer das Aufwerten ListViews wieder verschwinden, sobald man sie mit der Maus verlaesst.
     *
     * @param arg0
     */
    @FXML
    public void handleMouseExitAufwertenListe(MouseEvent arg0) {

        for (ListView l : aufwertenListen) {
            l.setVisible(false);
        }

    }

    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer den Naechster Standort -Button im Standort Tab betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf den zugewiesenen Button der naechste  Standort in der Standortliste des
     * Spielers als aktueller Standort gesetzt wird und die neuen Werte in die GUI Elemente geladen werden.
     * Gibt es keinen naechsten Standort in der Standort Liste des Spieler, passiert nichts.
     *
     * @param arg0
     */
    @FXML
    public void handleButtonActionNaechsterStandort(ActionEvent arg0) {
        try {
            spieler.setAktuellerStandort(spieler.getStandorte().get(spieler.getStandorte().indexOf(spieler.getAktuellerStandort()) + 1));
            setzeBilder(spieler.getAktuellerStandort().getGebaeudes());
            setzeBaustellen();

            //System.out.println("" + Spieler.getInstance().getAktuellerStandort().getErlaubteHandel());
        } catch (Exception e) {
            //e.printStackTrace();
        }


    }


    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer den Vorheriger Standort -Button im Standort Tab betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf den zugewiesenen Button der vorherige Standort in der Standortliste des
     * Spielers als aktueller Standort gesetzt wird und die neuen Werte in die GUI Elemente geladen werden.
     * Gibt es keinen vorherigen Standort in der Standort Liste des Spieler, passiert nichts.
     *
     * @param arg0
     */
    @FXML
    public void handleButtonActionVorherigerStandort(ActionEvent arg0) {
        try {
            spieler.setAktuellerStandort(spieler.getStandorte().get(spieler.getStandorte().indexOf(spieler.getAktuellerStandort()) + -1));
            setzeBilder(spieler.getAktuellerStandort().getGebaeudes());
            setzeBaustellen();
            //System.out.println("" + Spieler.getInstance().getAktuellerStandort().getErlaubteHandel());
        } catch (Exception e) {
            //e.printStackTrace();

        }


    }

    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer den Aendern Button bei dem Standortnamen Feld betaetigt.
     * Die Methode sorgt dafuer das beim Klick auf den zugewiesenen Button der aktuell im Text Feld eingegebene Text
     * als Name fuer den Standort gesetzt wird, sofern das Namensfeld nicht leer ist und kein ungueltiges Zeichen enthaelt.
     * Die Aenderung wird anschliessend dem Server mitgeteilt.
     *
     * @param event
     */
    @FXML
    public void handleButtonActionNameAendern(ActionEvent event) {

        if (standortName.getText().length() > 0 && !standortName.getText().contains("#") && !standortName.getText().contains("'")) {
            spieler.getAktuellerStandort().setName(standortName.getText());
            nameAendernFail.setVisible(false);

            String[] nameAendernSpeichern = {"SPEICHERN", "STANDORTNAME", "" + spieler.getAktuellerStandort().getId(), spieler.getAktuellerStandort().getName()};
            String[] answer = BefehlHandler.getInstance().sendeBefehl(nameAendernSpeichern);

        } else {
            nameAendernFail.setVisible(true);
        }

    }


    /**
     * Diese Methode behandelt den Fall, dass ein Benutzer ein Feld in der Standorte Liste im Home Tab auswaehlt.
     * Die Methode sorgt dafuer, dass der in der Liste ausgewaehlte Standort als aktueller Standort gesetzt wird und im Standort Tab
     * den GUI Elementen die richtigen Werte zugeordnet werden.
     *
     * @param arg0
     */
    @FXML
    public void handleMouseClickStandortListe(MouseEvent arg0) {
        for (Standort s : Spieler.getSpieler().getStandorte()) {
            if (("ID:" + s.getId() + " Name: " + s.getName()).equals(standorteID.getSelectionModel().getSelectedItem())) {


                Spieler.getInstance().setAktuellerStandort(s);
                setzeBilder(s.getGebaeudes());
                setzeBaustellen();
                //System.out.println("" + Spieler.getInstance().getAktuellerStandort().getErlaubteHandel());

            }
        }

        tabpane.getSelectionModel().select(standortTab);
    }


    /**
     * Diese Methode wird in anderen Methoden aufgerufen um Code-Duplikation zu verhinden. Hier werden die korrekten Bilder und Level
     * zum (durch die benutzenden Methoden neu gesetzten) aktuellen Standort  in der GUI gesetzt.
     *
     * @param g
     */
    public void setzeBilder(Gebaeude[] g) {

        for (int i = 0; i <= 8; i++) {
            try {


                if (g[i].getTyp().contains("1")) {
                    gebaeudeLvl.get(i).setText("1");
                } else if (g[i].getTyp().contains("2")) {
                    gebaeudeLvl.get(i).setText("2");
                } else if (g[i].getTyp().contains("3")) {
                    gebaeudeLvl.get(i).setText("3");
                } else {
                    gebaeudeLvl.get(i).setText(" ");
                }

                if (g[i].getTyp().equals("KF") || g[i].getTyp().equals("MF") || g[i].getTyp().equals("PF")) {
                    Image image1 = new Image("/Bilder/FoodWarsFreierBauplatz.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);

                } else if (g[i].getTyp().equals("KD1") || g[i].getTyp().equals("KD2") || g[i].getTyp().equals("KD3") ||
                        g[i].getTyp().equals("MD1") || g[i].getTyp().equals("MD2") || g[i].getTyp().equals("MD3") ||
                        g[i].getTyp().equals("PD1") || g[i].getTyp().equals("PD2") || g[i].getTyp().equals("PD3")) {

                    Image image1 = new Image("/Bilder/FoodWarsDNALabor.jpg");


                    gebaudeBilderListe.get(i).setImage(image1);


                } else if (g[i].getTyp().equals("KM1") || g[i].getTyp().equals("KM2") || g[i].getTyp().equals("KM3") ||
                        g[i].getTyp().equals("MM1") || g[i].getTyp().equals("MM2") || g[i].getTyp().equals("MM3") ||
                        g[i].getTyp().equals("PM1") || g[i].getTyp().equals("PM2") || g[i].getTyp().equals("PM3")) {

                    Image image1 = new Image("/Bilder/FoodWarsMuehle.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);


                } else if (g[i].getTyp().equals("KS1") || g[i].getTyp().equals("KS2") || g[i].getTyp().equals("KS3") ||
                        g[i].getTyp().equals("MS1") || g[i].getTyp().equals("MS2") || g[i].getTyp().equals("MS3") ||
                        g[i].getTyp().equals("PS1") || g[i].getTyp().equals("PS2") || g[i].getTyp().equals("PS3")) {

                    Image image1 = new Image("/Bilder/FoodWarsSchlachter.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);


                } else if (g[i].getTyp().equals("KB1") || g[i].getTyp().equals("KB2") || g[i].getTyp().equals("KB3") ||
                        g[i].getTyp().equals("MB1") || g[i].getTyp().equals("MB2") || g[i].getTyp().equals("MB3") ||
                        g[i].getTyp().equals("PB1") || g[i].getTyp().equals("PB2") || g[i].getTyp().equals("PB3")) {

                    Image image1 = new Image("/Bilder/FoodWarsBauernhof.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);

                } else if (g[i].getTyp().equals("KP1") || g[i].getTyp().equals("KP2") || g[i].getTyp().equals("KP3") ||
                        g[i].getTyp().equals("MP1") || g[i].getTyp().equals("MP2") || g[i].getTyp().equals("MP3") ||
                        g[i].getTyp().equals("PP1") || g[i].getTyp().equals("PP2") || g[i].getTyp().equals("PP3")) {

                    Image image1 = new Image("/Bilder/FoodWarsHandelsposten.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);


                } else if (g[i].getTyp().equals("KL1") || g[i].getTyp().equals("KL2") || g[i].getTyp().equals("KL3") ||
                        g[i].getTyp().equals("ML1") || g[i].getTyp().equals("ML2") || g[i].getTyp().equals("ML3") ||
                        g[i].getTyp().equals("PL1") || g[i].getTyp().equals("PL2") || g[i].getTyp().equals("PL3")) {

                    Image image1 = new Image("/Bilder/FoodWarsLager.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);


                } else if (g[i].getTyp().equals("KA1") || g[i].getTyp().equals("KA2") || g[i].getTyp().equals("KA3") ||
                        g[i].getTyp().equals("MA1") || g[i].getTyp().equals("MA2") || g[i].getTyp().equals("MA3") ||
                        g[i].getTyp().equals("PA1") || g[i].getTyp().equals("PA2") || g[i].getTyp().equals("PA3")) {

                    Image image1 = new Image("/Bilder/FoodWarsRechtsabteilung.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);


                } else if (g[i].getTyp().equals("KR1") || g[i].getTyp().equals("KR2") || g[i].getTyp().equals("KR3")) {

                    Image image1 = new Image("/Bilder/FoodWarsRestaurantKFC.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);

                } else if (g[i].getTyp().equals("MR1") || g[i].getTyp().equals("MR2") || g[i].getTyp().equals("MR3")) {

                    Image image1 = new Image("/Bilder/FoodWarsRestaurantMcKing.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);

                } else if (g[i].getTyp().equals("PR1") || g[i].getTyp().equals("PR2") || g[i].getTyp().equals("PR3")) {

                    Image image1 = new Image("/Bilder/FoodWarsRestaurantPizzaCap.jpg");

                    gebaudeBilderListe.get(i).setImage(image1);

                }
            } catch (NullPointerException e) {
                //e.printStackTrace();

                Image image1 = new Image("/Bilder/FoodWarsFreierBauplatz.jpg");

                gebaudeBilderListe.get(i).setImage(image1);

                gebaeudeLvl.get(i).setText(" ");

            }
        }

    }

    /**
     * Diese Methode wird in anderen Methoden aufgerufen um Code-Duplikation zu verhinden. Hier werden unteranderem Baustellen
     * zum (durch die benutzenden Methoden neu gesetzten) aktuellen Standort  in der GUI gesetzt.
     *
     * @param
     */
    public void setzeBaustellen() {

        try {
            standortName.setText(spieler.getAktuellerStandort().getName());
            nameAendernFail.setVisible(false);

            ltGroup.setVisible(false);
            mtGroup.setVisible(false);
            stGroup.setVisible(false);
            superGroup.setVisible(false);

            for (Gebaeude g : Spieler.getInstance().getAktuellerStandort().getGebaeudes()) {
                try {
                    if (g.getTyp().contains("R1")) {
                        ltGroup.setVisible(true);
                    } else if (g.getTyp().contains("R2")) {
                        ltGroup.setVisible(true);
                        mtGroup.setVisible(true);
                    } else if (g.getTyp().contains("R3")) {
                        ltGroup.setVisible(true);
                        mtGroup.setVisible(true);
                        stGroup.setVisible(true);
                        if (spieler.isKeinRealLife()) {
                            superGroup.setVisible(true);
                        }
                    } else {
                    }
                } catch (NullPointerException e) {
                    // e.printStackTrace();
                }
            }




            for (int i = 0; i <= 8; i++) {
                try {
                    if (spieler.getAktuellerStandort().getGebaeudes()[i].isImBau()) {

                        imBau.get(i).setVisible(true);
                        aufwertenButtons.get(i).setDisable(true);
                    } else {
                        imBau.get(i).setVisible(false);
                        aufwertenButtons.get(i).setDisable(false);
                    }
                } catch (NullPointerException e) {
                    //e.printStackTrace();
                    imBau.get(i).setVisible(false);
                    aufwertenButtons.get(i).setDisable(false);
                }
                try {
                    if (spieler.getAktuellerStandort().getGebaeudes()[i].getTyp().contains("3")) {
                        aufwertenButtons.get(i).setDisable(true);
                    }

                }catch(Exception e){

                }
            }

            GebaudeLevelHandler glh = new GebaudeLevelHandler();
            String[] hg = glh.setzeHauptgebaeude(Spieler.getInstance().getFraktion(), Spieler.getInstance().getAktuellerStandort().getHauptgebaeudeLvl());
            Image imageHG = new Image(hg[0]);
            basisBauplatz.setImage(imageHG);
            levelplatzBasis.setText(hg[1]);

            if (spieler.getAktuellerStandort().isHauptGebauedeImBau()) {
                imBauBasis.setVisible(true);
                aufwertenBasis.setDisable(true);

                /*if(levelplatzBasis.getText().equals("1")) {
                    levelplatzBasis.setText("2");
                }else if (levelplatzBasis.getText().equals("2")){
                    levelplatzBasis.setText("3");
                }*/

            }

            if (Spieler.getInstance().getAktuellerStandort().getHauptgebaeudeLvl() == 3) {
                aufwertenBasis.setDisable(true);
            }
        } catch (Exception e) {

        }

    }


    /**
     * Methode zum erforschen der Knoten
     * sendet den Baum als String zum Server "UPDATEBAUM;spielerid;C/F/G;baum"
     * Zieht die Kosten im Vorfeld ab
     */
    @FXML
    public void knotenKlickForschung(MouseEvent arg0) {
        String knoten = (((Circle) arg0.getSource()).getId().toString());
        if (knoten.charAt(0) == 'C') {
            String[] preisinfo = {"ANFRAGE", "INFOBAUM", "PREIS", "C", "" + knoten.charAt(1), Spieler.getInstance().getCharakter()};

            String[] answer = BefehlHandler.getInstance().sendeBefehl(preisinfo);
            if (Integer.parseInt(answer[1]) <= Spieler.getInstance().getGeld()) {
                String[] einkauf = {"BEZAHLEN", "GELD", Spieler.getInstance().getId(), answer[1]};
                BefehlHandler.getInstance().sendeBefehl(einkauf);

                Spieler.getInstance().getCharakterBaum().setInBau("" + knoten.charAt(1));
                activateCBaum(); // GUI Grafik Methode
                //System.out.println(Spieler.getInstance().getCharakterBaum().getStringBaum());
                String[] array = {"UPDATEBAUM", "" + Spieler.getInstance().getId(), "C" + Spieler.getInstance().getCharakter(), "" + Spieler.getInstance().getCharakterBaum().getStringBaum(), "" + knoten.charAt(1)};

                String[] answer1 = BefehlHandler.getInstance().sendeBefehl(array);
                ForschungUpdateThread ft = new ForschungUpdateThread(Long.parseLong(answer1[2]));
                ft.start();
                updateGUI();
            } else {
                forschenFehler.setText("Du hast nicht genug Geld");
            }

        } else if (knoten.charAt(0) == 'F') {
            String[] preisinfo = {"ANFRAGE", "INFOBAUM", "PREIS", "F", "" + knoten.charAt(1), Spieler.getInstance().getFraktion()};

            String[] answer = BefehlHandler.getInstance().sendeBefehl(preisinfo);
            if (Integer.parseInt(answer[1]) <= Spieler.getInstance().getGeld()) {
                String[] einkauf = {"BEZAHLEN", "GELD", Spieler.getInstance().getId(), answer[1]};
                BefehlHandler.getInstance().sendeBefehl(einkauf);
                Spieler.getInstance().getFraktionsBaum().setInBau("" + knoten.charAt(1));
                activateFBaum();
                //System.out.println(Spieler.getInstance().getCharakterBaum().getStringBaum());
                String[] array = {"UPDATEBAUM", "" + Spieler.getInstance().getId(), "F" + Spieler.getInstance().getFraktion(), "" + Spieler.getInstance().getFraktionsBaum().getStringBaum(), "" + knoten.charAt(1)};
                String[] answer1 = BefehlHandler.getInstance().sendeBefehl(array);
                ForschungUpdateThread ft = new ForschungUpdateThread(Long.parseLong(answer1[2]));
                ft.start();
                updateGUI();
            } else {
                forschenFehler.setText("Du hast nicht genug Geld");
            }
        } else if (knoten.charAt(0) == 'G') {
            String[] preisinfo = {"ANFRAGE", "INFOBAUM", "PREIS", "G", "" + knoten.charAt(1)};
            String[] answer = BefehlHandler.getInstance().sendeBefehl(preisinfo);
            if (Integer.parseInt(answer[1]) <= Spieler.getInstance().getFranchise().getGeld()) {
                String effekt = Spieler.getInstance().getFranchise().getForschungsbaum().searchBaumknoten(knoten.substring(1)).getEffekt();
                String bonus = effekt.split(";")[0];
                String wert = effekt.split(";")[1];
                String[] einkauf = {"FRANCHISE", "BEZAHLEN", Spieler.getInstance().getFranchise().getId(), answer[1], bonus, wert};
                String[] neuerGeldbetrag = BefehlHandler.getInstance().sendeBefehl(einkauf);
                Spieler.getInstance().getFranchise().getForschungsbaum().setInBau("" + knoten.charAt(1));
                activateGBaum();
                //System.out.println(Spieler.getInstance().getCharakterBaum().getStringBaum());
                String[] array = {"UPDATEBAUM", "" + Spieler.getInstance().getFranchise().getId(), "G", "" + Spieler.getInstance().getFranchise().getForschungsbaum().getStringBaum(), "" + knoten.charAt(1)};
                Spieler.getInstance().getFranchise().setGeld(Integer.parseInt(neuerGeldbetrag[1]));
                String[] answer1 = BefehlHandler.getInstance().sendeBefehl(array);
                ForschungUpdateThread ft = new ForschungUpdateThread(Long.parseLong(answer1[2]));
                ft.start();
                updateGUI();
            } else {
                keinGeld.setText("Ihr habt kein Geld! Treibe mehr Steuern ein!");
            }
            initBoniList();
        }
    }

    ObservableList<String> standortListe = FXCollections.observableArrayList();

    /**
     * Fuellen der Arraylist fuer den Charakterbaum
     */
    private void initCBaum() {
        cBaumListe.add(CA);
        cBaumListe.add(CB);
        cBaumListe.add(CC);
        cBaumListe.add(CD);
        cBaumListe.add(CE);
        cBaumListe.add(CF);
        cBaumListe.add(CG);
        cBaumListe.add(CH);
        cBaumListe.add(CI);
        cBaumListe.add(CJ);
        cBaumListe.add(CK);
        cBaumListe.add(CL);
        cBaumListe.add(CM);
        cBaumListe.add(CN);
        cBaumListe.add(CO);
        cBaumListe.add(CP);
        cBaumListe.add(CQ);
        cBaumListe.add(CR);
        cBaumListe.add(CS);
    }

    /**
     * Fuellen der ArrayList fuer den Fraktionsbaum
     */
    private void initFBaum() {
        fBaumListe.add(FA);
        fBaumListe.add(FB);
        fBaumListe.add(FC);
        fBaumListe.add(FD);
        fBaumListe.add(FE);
        fBaumListe.add(FF);
        fBaumListe.add(FG);
        fBaumListe.add(FH);
        fBaumListe.add(FI);
        fBaumListe.add(FJ);
        fBaumListe.add(FK);
        fBaumListe.add(FL);
        fBaumListe.add(FM);
        fBaumListe.add(FN);
        fBaumListe.add(FO);
        fBaumListe.add(FP);
        fBaumListe.add(FQ);
        fBaumListe.add(FR);
        fBaumListe.add(FS);
    }

    /**
     * Fuellen der ArrayList fuer den Franchisebaum
     */
    private void initGBaum() {
        gBaumListe.add(GA);
        gBaumListe.add(GB);
        gBaumListe.add(GC);
        gBaumListe.add(GD);
        gBaumListe.add(GE);
        gBaumListe.add(GF);
        gBaumListe.add(GG);
        gBaumListe.add(GH);
        gBaumListe.add(GI);
        gBaumListe.add(GJ);
        gBaumListe.add(GK);
        gBaumListe.add(GL);
        gBaumListe.add(GM);
        gBaumListe.add(GN);
        gBaumListe.add(GO);
        gBaumListe.add(GP);
        gBaumListe.add(GQ);
        gBaumListe.add(GR);
        gBaumListe.add(GS);
    }

    /**
     * Liste der 9x9 Rechteck Karte
     */
    private void initMapListe() {
        mapListe.add(karte00);
        mapListe.add(karte01);
        mapListe.add(karte02);
        mapListe.add(karte03);
        mapListe.add(karte04);
        mapListe.add(karte05);
        mapListe.add(karte06);
        mapListe.add(karte07);
        mapListe.add(karte08);
        mapListe.add(karte10);
        mapListe.add(karte11);
        mapListe.add(karte12);
        mapListe.add(karte13);
        mapListe.add(karte14);
        mapListe.add(karte15);
        mapListe.add(karte16);
        mapListe.add(karte17);
        mapListe.add(karte18);
        mapListe.add(karte20);
        mapListe.add(karte21);
        mapListe.add(karte21);
        mapListe.add(karte22);
        mapListe.add(karte23);
        mapListe.add(karte24);
        mapListe.add(karte25);
        mapListe.add(karte26);
        mapListe.add(karte27);
        mapListe.add(karte28);
        mapListe.add(karte30);
        mapListe.add(karte31);
        mapListe.add(karte32);
        mapListe.add(karte33);
        mapListe.add(karte34);
        mapListe.add(karte35);
        mapListe.add(karte36);
        mapListe.add(karte37);
        mapListe.add(karte38);
        mapListe.add(karte40);
        mapListe.add(karte41);
        mapListe.add(karte42);
        mapListe.add(karte43);
        mapListe.add(karte44);
        mapListe.add(karte45);
        mapListe.add(karte46);
        mapListe.add(karte47);
        mapListe.add(karte48);
        mapListe.add(karte50);
        mapListe.add(karte51);
        mapListe.add(karte52);
        mapListe.add(karte53);
        mapListe.add(karte54);
        mapListe.add(karte55);
        mapListe.add(karte56);
        mapListe.add(karte57);
        mapListe.add(karte58);
        mapListe.add(karte60);
        mapListe.add(karte61);
        mapListe.add(karte62);
        mapListe.add(karte63);
        mapListe.add(karte64);
        mapListe.add(karte65);
        mapListe.add(karte66);
        mapListe.add(karte67);
        mapListe.add(karte68);
        mapListe.add(karte70);
        mapListe.add(karte71);
        mapListe.add(karte72);
        mapListe.add(karte73);
        mapListe.add(karte74);
        mapListe.add(karte75);
        mapListe.add(karte76);
        mapListe.add(karte77);
        mapListe.add(karte78);
        mapListe.add(karte80);
        mapListe.add(karte81);
        mapListe.add(karte82);
        mapListe.add(karte83);
        mapListe.add(karte84);
        mapListe.add(karte85);
        mapListe.add(karte86);
        mapListe.add(karte87);
        mapListe.add(karte88);


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
     * Methode zum einfaerben des Franchise Skillbaums
     * deaktiviert/aktiviert auch die Knoten passend / nach Berechtigung
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


    /**
     * Iteriert durch die Liste und setzte einen Tooltipp mit der "Beschreibung" des BONI
     * Fallunterscheidung C/F/G Baum
     *
     * @param list : Die Liste der Knoten(Circle) des jeweiligen Forschungsbaums
     */
    private void setTooltipps(ArrayList<Circle> list) {
        int j = 0;
        for (char i = 'A'; i <= 'S'; i++) {
            String knoten = list.get(j).getId().toString();
            if (knoten.charAt(0) == 'C') {
                String text = Spieler.getInstance().getCharakterBaum().searchBaumknoten("" + knoten.charAt(1)).getEffekt().split(";")[0];
                String text1 = Spieler.getInstance().getCharakterBaum().searchBaumknoten("" + knoten.charAt(1)).getEffekt().split(";")[1];
                String[] array = {"ANFRAGE", "INFOBAUM", "PREIS", "C", "" + knoten.charAt(1), Spieler.getInstance().getCharakter()};
                String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                //TODO SERVER
                Tooltip.install(list.get(j), new Tooltip("Bonus: " + "\n" + text + "\n" + text1 + "\n Kosten:" + answer[1]));
            } else if (knoten.charAt(0) == 'F') {
                String text = Spieler.getInstance().getFraktionsBaum().searchBaumknoten("" + knoten.charAt(1)).getEffekt().split(";")[0];
                String text1 = Spieler.getInstance().getFraktionsBaum().searchBaumknoten("" + knoten.charAt(1)).getEffekt().split(";")[1];
                String[] array = {"ANFRAGE", "INFOBAUM", "PREIS", "F", "" + knoten.charAt(1), Spieler.getInstance().getFraktion()};
                String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                Tooltip.install(list.get(j), new Tooltip("Bonus: " + "\n" + text + "\n" + text1 + "\n Kosten:" + answer[1]));

            } else if (knoten.charAt(0) == 'G') {
                String text = Spieler.getInstance().getFranchise().getForschungsbaum().searchBaumknoten("" + knoten.charAt(1)).getEffekt().split(";")[0];
                String text1 = Spieler.getInstance().getFranchise().getForschungsbaum().searchBaumknoten("" + knoten.charAt(1)).getEffekt().split(";")[1];
                String[] array = {"ANFRAGE", "INFOBAUM", "PREIS", "G", "" + knoten.charAt(1)};
                String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
                Tooltip.install(list.get(j), new Tooltip("Bonus: " + "\n" + text + "\n" + text1 + "\n Kosten:" + answer[1]));

            }
            j++;
        }

    }

    /**
     * Wird aufgerufen wenn man Franchise erstellen drueckt
     * ruft Franchise erstellen auf mit dem eingegebenen Namen aus dem FranchiseHandler
     * Wechselt dann in den FranchiseTab
     *
     * @param event
     */
    @FXML
    private void franchiseErstellen(ActionEvent event) {

        if (!(franchiseName.getText().contains("#") || franchiseName.getText().contains("'"))) {

            String name = franchiseName.getText();
            // TODO Ueberpruefen ob der Name bereits existiert

            if (name.equals("")) {
                franchiseGruendenFehler.setText("Name darf nicht Leer sein oder der Name existiert bereits");
            } else {
                if (FranchiseHandler.getInstance().franchiseErstellen(name) == true) {

                    loadFranchise();
                    String[] array = {"FRANCHISE", "ANKUENDIGUNG", Spieler.getInstance().getFranchise().getId(), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",};
                    BefehlHandler.getInstance().sendeBefehl(array);
                    franchiseTab.setDisable(false);
                    tabpane.getSelectionModel().select(franchiseTab);
                    franchiseGruenden.setDisable(true);


                } else {
                    franchiseGruendenFehler.setText("Franchise existiert schon");
                }


            }
        } else {
            franchiseGruendenFehler.setText("Franchise gruenden nicht moeglich. \nFelder duerfen # und ' nicht enthalten!");
        }
    }

    /**
     * setzt die GUI Elemente fuer Franchise passend
     */
    private void loadFranchise() {
        Franchise franchise = Spieler.getInstance().getFranchise();
        franchiseTName.setText(franchise.getName());
        franchiseTCEO.setText(franchise.getCEO());
        setTooltipps(gBaumListe);
        activateGBaum();
        initBoniList();


        final ObservableList<String> mitglieder = FXCollections.observableArrayList();

        if (Spieler.getInstance().getFranchise().getMitgliederListe() == null) {
            mitglieder.add("Hallo ? Jemand da? da da da...");
        } else {
            mitglieder.addAll(Spieler.getInstance().getFranchise().getMitgliederListe());
        }
        mitgliederID.setItems(mitglieder);
        franchisekasse.setText("" + Spieler.getInstance().getFranchise().getGeld());

        final ObservableList<String> data4 = FXCollections.observableArrayList();
        try {
            for (String s : Spieler.getInstance().getFranchise().getAnkuendigungen()) {
                data4.add(s);
            }
        } catch (NullPointerException e) {
            // e.printStackTrace();
        }

        ankuendigungenID.setItems(data4);
    }

    /**
     * laedt die Boni Liste der Franchise in die GUI
     */
    private void initBoniList() {
        boniID.setItems(FranchiseHandler.getInstance().loadFranchiseBoni(gBaumListe));
    }

    private void franchiseBeitreten(ActionEvent event) {

        if (!(franchiseName.getText().contains("#") || franchiseName.getText().contains("'"))) {

            String name = franchiseName.getText();
            if (name.equals("")) {
                franchiseGruendenFehler.setText("Name darf nicht Leer sein");
            } else {
                String[] erfolgreich = FranchiseHandler.getInstance().franchiseBeitreten(name);
                if (erfolgreich[0].equals("TRUE")) {
                    loadFranchise();
                    franchiseTab.setDisable(false);
                    tabpane.getSelectionModel().select(franchiseTab);
                    franchiseGruenden.setDisable(true);


                } else {
                    franchiseGruendenFehler.setText(erfolgreich[1]);
                }

                updateGUI();
            }
        } else {
            franchiseGruendenFehler.setText("Franchise gruenden nicht moeglich. \nFelder duerfen # und ' nicht enthalten!");
        }
    }

    /**
     * Methode zum einzahlen von Geld in die Franchise
     * ueberprueft ob der Spieler auch genug Geld hat
     * Gibt je nach Situation eine passende Nachricht aus
     *
     * @param event
     */
    @FXML
    private void geldEinzahlen(ActionEvent event) {
        String menge = geldmenge.getText();
        try {
            if (Integer.parseInt(menge) > Spieler.getInstance().getGeld()) throw new OutOfMemoryError();
            Integer.parseInt(menge);
            FranchiseHandler.getInstance().einzahlen(menge);
            geldEinzahlenError.setText("erfolgreich eingezahlt");
            geldmenge.setText("");
        } catch (NumberFormatException ex) {
            //ex.printStackTrace();
            geldEinzahlenError.setText("Nur Zahlen sind erlaubt");
        } catch (OutOfMemoryError ex) {
            //ex.printStackTrace();
            geldEinzahlenError.setText("Wir lassen nicht zu das du Schulden aufnimmst");
        }
        updateGUI();
    }

    /**
     * Methode zum einkaufen im Shop beim anklicken des jeweiligen Buttons
     * Gibt die ID des Buttons an den StoreHandler weiter (storeEinkauf)
     *
     * @param event
     */
    @FXML
    private void shopEinkaufen(ActionEvent event) {
        String button = ((Button) event.getSource()).getId().toString();
        if (!StoreHandler.getInstance().storeEinkauf(button.substring(6))) {
            storeError.setText("Du hast nicht genug Gutscheine um hier etwas einzuloesen");
        } else {
            storeError.setText("Erfolgreich");
        }
        updateGUI();
    }

    /**
     * Aktualisiert die GUI ( ueberwiegend Label)
     * Aktualisiert auch die Nachrichten und die Map
     */
    private void updateGUI() {
        //UpdateHandler.getInstance().initialize();
        try {
            mehlAnzahlID.setText("" + Spieler.getInstance().getAktuellerStandort().getMehl());
            fleischAnzahlID.setText("" + Spieler.getInstance().getAktuellerStandort().getFleisch());
            veggieAnzahlID.setText("" + Spieler.getInstance().getAktuellerStandort().getGemuese());
            geldAnzahl.setText("" + Spieler.getInstance().getGeld());
            gutscheineAnzahl.setText("" + Spieler.getInstance().getGutschein());
            String[] array = {"ANFRAGE", "STANDORTKAP", Spieler.getInstance().getAktuellerStandort().getId()};
            String answer[] = BefehlHandler.getInstance().sendeBefehl(array);
            kapazitaetLabel.setText(answer[1]);
            if (Spieler.getInstance().getFranchise().getCEO() != null) {
                loadFranchise();
            }
            initMap();
            aktualisiereNachrichten();
            geldEinzahlenError.setText("");
        } catch (NullPointerException e) {
            //e.printStackTrace();
        }

    }

    /**
     * Aktuallisiert einige Elemente in der Gui beim klicken auf einen aktualisieren Buton
     * ruft auch updateGUI auf
     *
     * @param event
     */
    @FXML
    private void aktualisiereGUI(ActionEvent event) {
        aktualisiereGUIMethode();
    }

    @FXML
    private void aktualisiereGUIMethode() {
        updateGUI();
        aktualisiereNachrichten();
        aktualisiereBoniAnzeige();
        aktualisiereBewegungenAnzeige();

        standortListe = FXCollections.observableArrayList();

        for (Standort s : Spieler.getInstance().getStandorte()) {
            standortListe.add("ID:" + s.getId() + " Name: " + s.getName());
        }

        standorteID.setItems(standortListe);

        String[] array = {"ANFRAGE", "GIBBAEUME", Spieler.getInstance().getId()};
        String[] answer = BefehlHandler.getInstance().sendeBefehl(array);
        Spieler.getInstance().getCharakterBaum().updateBaum(answer[1]);
        Spieler.getInstance().getFraktionsBaum().updateBaum(answer[2]);
        activateCBaum();
        activateFBaum();
        geldmenge.setText("");
        geldEinzahlenError.setText("");
        forschenFehler.setText("");
        storeError.setText("");
    }

    /**
     * Methode zum einfaerben der Karte
     * Aktueller Standort GOld
     * Eigener Standort ORange
     * Franchise Standort Blau
     * Alle anderen Rot
     */
    private void initMap() {
        String[] array1 = {"ANFRAGE", "KARTE", "" + Spieler.getInstance().getAktuellerStandort().getKoordinateX(), "" + Spieler.getInstance().getAktuellerStandort().getKoordinateY()};
        String[] answer1 = bh.sendeBefehl(array1);
        kartenHandler.getInstance().setKarte(answer1);

        Image grass = new Image("/Bilder/grass.png");
        Image enemy = new Image("/Bilder/enemy.png");
        Image franchise = new Image("/Bilder/alli.png");
        Image current = new Image("/Bilder/current.png");
        Image own = new Image("/Bilder/own.png");
        for (int i = 0; i <= 81; i++) {
            Rectangle rectangle = mapListe.get(i);
            rectangle.setFill(new ImagePattern(grass, 0, 0, 1, 1, true));
            String rectangleID = rectangle.getId();
            //System.out.println("GROessE" + mapListe.size());
            // System.out.println(rectangleID.charAt(5) + ":" + rectangleID.charAt(6));
            String[][] spielerKarte = kartenHandler.getInstance().getSpielerKarte();
            int x = Integer.parseInt("" + rectangleID.charAt(5));
            int y = Integer.parseInt("" + rectangleID.charAt(6));
            int n = Integer.parseInt(spielerKarte[x][y]);
            if (n != 0) {
                rectangle.setFill(new ImagePattern(enemy, 0, 0, 1, 1, true));
                rectangle.setStyle("-fx-cursor: hand;");
                /** Behandlung des angeklickten Standorts*/
                rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        String rechteck = ((Rectangle) me.getSource()).getId().toString();
                        int x1 = Integer.parseInt("" + rectangleID.charAt(5));
                        int y1 = Integer.parseInt("" + rectangleID.charAt(6));
                        String n1 = spielerKarte[x1][y1];

                        //System.out.println("Ein gefuerchteter Gegner");
                        Spieler.getInstance().setAktuellesZielID(n1);
                        kampfTab.setDisable(false);
                        angreifenderStandortLabel.setText(spieler.getAktuellerStandort().getName());
                        BefehlHandler bh = BefehlHandler.getInstance();
                        String[] zielBefehl = {"ANFRAGE", "ZIEL", spieler.getAktuellesZielID()};
                        String[] antwort = bh.sendeBefehl(zielBefehl);
                        zielStandortLabel.setText(antwort[1]);
                        zielSpielerLabel.setText(antwort[2]);

                        boolean istFreund = false;
                        if (!spieler.getFranchise().getId().equals("0")) {
                            for (int f = 0; f < spieler.getFranchise().getMitgliederListe().length; f++) {
                                if (spieler.getFranchise().getMitgliederListe()[f].equals(antwort[2])) {
                                    istFreund = true;
                                }
                            }
                        }

                        if (istFreund || antwort[2].equals(spieler.getName())) {
                            istTransfer = true;
                            istKampf = false;
                            darfUebernehmen = false;
                        } else {
                            istTransfer = false;
                            istKampf = true;
                            darfUebernehmen = false;
                            for (int s = 0; s < spieler.getAktuellerStandort().getGebaeudes().length; s++) {
                                try {
                                    //System.out.println("Gebaeude: " + spieler.getAktuellerStandort().getGebaeudes()[s].getTyp());
                                    if (spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("KA1") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("KA2") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("KA3") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("MA1") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("MA2") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("MA3") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("PA1") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("PA2") ||
                                            spieler.getAktuellerStandort().getGebaeudes()[s].getTyp().equals("PA3")) {
                                        //System.out.println("Ich komme hier an");
                                        darfUebernehmen = true;
                                    }
                                } catch (Exception e) {
                                    // e.printStackTrace();
                                }
                            }
                        }
                        if (spieler.getAktuellerStandort().getXt1() >= 1) {
                            kampfSuperCheckbox.setDisable(false);
                        } else {
                            kampfSuperCheckbox.setDisable(true);
                        }
                        aktualisiereTruppenAnzahlAnzeige();

                        String[] befehlUebernahme = {"ANFRAGE", "STANDORTWERT", spieler.getAktuellesZielID()};
                        String[] antwortUebernahme = bh.sendeBefehl(befehlUebernahme);
                        if (Integer.parseInt(antwortUebernahme[0]) < spieler.getGeld()) {
                            kannUebernehmen = true;
                        }

                        aktualisiereTruppenbewegungElemente();
                        tabpane.getSelectionModel().select(kampfTab);
                        kampfTabKannAus = true;
                    }
                });
                /** Hier aktueller Standort */
                if (Spieler.getInstance().getAktuellerStandort().getId().equals("" + n)) {
                    rectangle.setFill(new ImagePattern(current, 0, 0, 1, 1, true));
                    rectangle.setStyle("");
                    rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                        }

                    });
                }
                /** Hier eigener Standort aber nicht aktueler */
                if (istEigenerStandort("" + n) && !Spieler.getInstance().getAktuellerStandort().getId().equals("" + n)) {
                    rectangle.setFill(new ImagePattern(own, 0, 0, 1, 1, true));
                }
                /** Hier Franchise Standorte, wird nur ueberprueft wenn eine Franchise gegruendet/beigetreten wurde */
                if (Spieler.getInstance().getFranchise().getCEO() != null) {
                    for (int j = 0; j < Spieler.getInstance().getFranchise().getMitgliederListeID().length; j++) {
                        String id = Spieler.getInstance().getFranchise().getMitgliederListeID()[j];
                        if (id.equals("" + n) && istEigenerStandort(id) == false) {
                            rectangle.setFill(new ImagePattern(franchise, 0, 0, 1, 1, true));
                        }

                    }
                }


            }
        }
    }

    /**
     * Hilfsmethode, ueberprueft ob die ID ein eigener Standort ist
     *
     * @param id des zu vergleichenden Standorts
     * @return true wenn eigener Standort, wenn nicht dann false
     */
    private boolean istEigenerStandort(String id) {
        for (int i = 0; i < Spieler.getInstance().getStandorte().size(); i++) {
            String standort = Spieler.getInstance().getStandorte().get(i).getId();
            if (id.equals(standort)) {
                return true;
            }
        }
        return false;
    }

}


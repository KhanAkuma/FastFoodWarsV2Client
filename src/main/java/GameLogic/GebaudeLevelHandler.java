package GameLogic;

import Entities.Spieler;

/**
 * @Autor Michael Schwenk
 *
 * Der GebaudeLevelHandler beinhaltet Methoden die wir brauchen, um das Abkuerzungs-System das wir fuer unsere Gebaeude Typen
 * eingefuehrt haben umzusetzen.
 */
public class GebaudeLevelHandler {

    /**
     * Diese Methode erhaelt den Typen des aktellen Gebaeudes und gibt eine Liste mit allen moeglichen Erweiterungen fuer diesen
     * Gebaeudetypen zurueck.
     *
     * @param gebauede
     * @return String[] mit moeglichen Erweiterungen
     */
    public String[] gebaeudeErweitern(String gebauede) {

        try {
            char[] gebaeude2 = gebauede.toCharArray();


            if (gebauede.equals("KF")) {
                String[] erweiterungen = {"KR1", "KD1", "KM1", "KS1", "KB1", "KP1", "KL1", "KA1"};
                return erweiterungen;

            } else if (gebauede.equals("MF")) {
                String[] erweiterungen = {"MR1", "MD1", "MM1", "MS1", "MB1", "MP1", "ML1", "MA1"};
                return erweiterungen;

            } else if (gebauede.equals("PF")) {
                String[] erweiterungen = {"PR1", "PD1", "PM1", "PS1", "PB1", "PP1", "PL1", "PA1"};
                return erweiterungen;

            } else if (gebauede.contains("1")) {
                gebauede = gebauede.replace('1', '2');
                String[] erweiterungen = {gebauede};
                return erweiterungen;

            } else if (gebauede.contains("2")) {
                gebauede = gebauede.replace('2', '3');
                String[] erweiterungen = {gebauede};
                return erweiterungen;

            } else if (gebauede.contains("3")) {
                String[] erweiterungen = {};
                return erweiterungen;
            } else {
                String[] erweiterungen = {"Fehler"};
                return erweiterungen;
            }
        } catch (NullPointerException e) {
            //e.printStackTrace();
            String[] erweiterungen = {"KR1", "KD1", "KM1", "KS1", "KB1", "KP1", "KL1", "KA1"};
            return erweiterungen;
        }
    }

    /**
     * Diese Methode erhaelt eine Liste an GebaeudeTypen Abkuerzungen und Uebersetzt sie fuer die GUI in einer fuer den Benutzer
     * verstaendliche Form.
     *
     * @param gebauede
     * @return String[] mit Typ Uebersetzungen
     */
    public String[] gebaeudeVonCodeUebersetzung(String[] gebauede) {
        String[] ausgabe = new String[gebauede.length];
        for (int i = 0; i <= (gebauede.length - 1); i++) {

            try {
                if (gebauede[i].equals("KR1") || gebauede[i].equals("MR1") || gebauede[i].equals("PR1")) {
                    ausgabe[i] = "Restaurant Lvl 1";

                } else if (gebauede[i].equals("KR2") || gebauede[i].equals("MR2") || gebauede[i].equals("PR2")) {
                    ausgabe[i] = "Restaurant Lvl 2";

                } else if (gebauede[i].equals("KR3") || gebauede[i].equals("MR3") || gebauede[i].equals("PR3")) {
                    ausgabe[i] = "Restaurant Lvl 3";

                } else if (gebauede[i].equals("KD1") || gebauede[i].equals("MD1") || gebauede[i].equals("PD1")) {
                    ausgabe[i] = "DNA-Labor Lvl 1";

                } else if (gebauede[i].equals("KD2") || gebauede[i].equals("MD2") || gebauede[i].equals("PD2")) {
                    ausgabe[i] = "DNA-Labor Lvl 2";

                } else if (gebauede[i].equals("KD3") || gebauede[i].equals("MD3") || gebauede[i].equals("PD3")) {
                    ausgabe[i] = "DNA-Labor Lvl 3";

                } else if (gebauede[i].equals("KM1") || gebauede[i].equals("MM1") || gebauede[i].equals("PM1")) {
                    ausgabe[i] = "Muehle Lvl 1";

                } else if (gebauede[i].equals("KM2") || gebauede[i].equals("MM2") || gebauede[i].equals("PM2")) {
                    ausgabe[i] = "Muehle Lvl 2";

                } else if (gebauede[i].equals("KM3") || gebauede[i].equals("MM3") || gebauede[i].equals("PM3")) {
                    ausgabe[i] = "Muehle Lvl 3";

                } else if (gebauede[i].equals("KS1") || gebauede[i].equals("MS1") || gebauede[i].equals("PS1")) {
                    ausgabe[i] = "Schlachter Lvl 1";

                } else if (gebauede[i].equals("KS2") || gebauede[i].equals("MS2") || gebauede[i].equals("PS2")) {
                    ausgabe[i] = "Schlachter Lvl 2";

                } else if (gebauede[i].equals("KS3") || gebauede[i].equals("MS3") || gebauede[i].equals("PS3")) {
                    ausgabe[i] = "Schlachter Lvl 3";

                } else if (gebauede[i].equals("KB1") || gebauede[i].equals("MB1") || gebauede[i].equals("PB1")) {
                    ausgabe[i] = "Bauernhof Lvl 1";

                } else if (gebauede[i].equals("KB2") || gebauede[i].equals("MB2") || gebauede[i].equals("PB2")) {
                    ausgabe[i] = "Bauernhof Lvl 2";

                } else if (gebauede[i].equals("KB3") || gebauede[i].equals("MB3") || gebauede[i].equals("PB3")) {
                    ausgabe[i] = "Bauernhof Lvl 3";

                } else if (gebauede[i].equals("KP1") || gebauede[i].equals("MP1") || gebauede[i].equals("PP1")) {
                    ausgabe[i] = "Handelsposten Lvl 1";

                } else if (gebauede[i].equals("KP2") || gebauede[i].equals("MP2") || gebauede[i].equals("PP2")) {
                    ausgabe[i] = "Handelsposten Lvl 2";

                } else if (gebauede[i].equals("KP3") || gebauede[i].equals("MP3") || gebauede[i].equals("PP3")) {
                    ausgabe[i] = "Handelsposten Lvl 3";

                } else if (gebauede[i].equals("KL1") || gebauede[i].equals("ML1") || gebauede[i].equals("PL1")) {
                    ausgabe[i] = "Lager Lvl 1";

                } else if (gebauede[i].equals("KL2") || gebauede[i].equals("ML2") || gebauede[i].equals("PL2")) {
                    ausgabe[i] = "Lager Lvl 2";

                } else if (gebauede[i].equals("KL3") || gebauede[i].equals("ML3") || gebauede[i].equals("PL3")) {
                    ausgabe[i] = "Lager Lvl 3";

                } else if (gebauede[i].equals("KA1") || gebauede[i].equals("MA1") || gebauede[i].equals("PA1")) {
                    ausgabe[i] = "Rechtsabteilung Lvl 1";

                } else if (gebauede[i].equals("KA2") || gebauede[i].equals("MA2") || gebauede[i].equals("PA2")) {
                    ausgabe[i] = "Rechtsabteilung Lvl 2";

                } else {
                    ausgabe[i] = "Rechtsabteilung Lvl 3";
                }


            } catch (ArrayIndexOutOfBoundsException e) {
                //e.printStackTrace();
                return ausgabe;
            }

        }
        return ausgabe;
    }

    /**
     * Diese Methode dient dazu die in der GUI benutzten Schreibweisen fuer Gebaeudetypen wieder zurueck in unsere Abkuerzungsform
     * zu uebersetzen.
     *
     * @param gebaeude
     * @return String mit Abkuerzungscode fuer Ausgeschriebenen Gebaeudetypen.
     */
    public String gebaeudeZuCodeUebersetzung(String gebaeude) {

        if (Spieler.getInstance().getFraktion().equals("K")) {
            if (gebaeude.equals("Restaurant Lvl 1")) {
                return "KR1";

            } else if (gebaeude.equals("Restaurant Lvl 2")) {
                return "KR2";

            } else if (gebaeude.equals("Restaurant Lvl 3")) {
                return "KR3";

            } else if (gebaeude.equals("DNA-Labor Lvl 1")) {
                return "KD1";

            } else if (gebaeude.equals("DNA-Labor Lvl 2")) {
                return "KD2";

            } else if (gebaeude.equals("DNA-Labor Lvl 3")) {
                return "KD3";

            } else if (gebaeude.equals("Muehle Lvl 1")) {
                return "KM1";

            } else if (gebaeude.equals("Muehle Lvl 2")) {
                return "KM2";

            } else if (gebaeude.equals("Muehle Lvl 3")) {
                return "KM3";

            } else if (gebaeude.equals("Schlachter Lvl 1")) {
                return "KS1";

            } else if (gebaeude.equals("Schlachter Lvl 2")) {
                return "KS2";

            } else if (gebaeude.equals("Schlachter Lvl 3")) {
                return "KS3";

            } else if (gebaeude.equals("Bauernhof Lvl 1")) {
                return "KB1";

            } else if (gebaeude.equals("Bauernhof Lvl 2")) {
                return "KB2";

            } else if (gebaeude.equals("Bauernhof Lvl 3")) {
                return "KB3";

            } else if (gebaeude.equals("Handelsposten Lvl 1")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 5);
                return "KP1";

            } else if (gebaeude.equals("Handelsposten Lvl 2")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 10);
                return "KP2";

            } else if (gebaeude.equals("Handelsposten Lvl 3")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 10);
                return "KP3";

            } else if (gebaeude.equals("Lager Lvl 1")) {
                return "KL1";

            } else if (gebaeude.equals("Lager Lvl 2")) {
                return "KL2";

            } else if (gebaeude.equals("Lager Lvl 3")) {
                return "KL3";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 1")) {
                return "KA1";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 2")) {
                return "KA2";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 3")) {
                return "KA3";

            } else {
                return "KF";
            }
        } else if (Spieler.getInstance().getFraktion().equals("M")) {
            if (gebaeude.equals("Restaurant Lvl 1")) {
                return "MR1";

            } else if (gebaeude.equals("Restaurant Lvl 2")) {
                return "MR2";

            } else if (gebaeude.equals("Restaurant Lvl 3")) {
                return "MR3";

            } else if (gebaeude.equals("DNA-Labor Lvl 1")) {
                return "MD1";

            } else if (gebaeude.equals("DNA-Labor Lvl 2")) {
                return "MD2";

            } else if (gebaeude.equals("DNA-Labor Lvl 3")) {
                return "MD3";

            } else if (gebaeude.equals("Muehle Lvl 1")) {
                return "MM1";

            } else if (gebaeude.equals("Muehle Lvl 2")) {
                return "MM2";

            } else if (gebaeude.equals("Muehle Lvl 3")) {
                return "MM3";

            } else if (gebaeude.equals("Schlachter Lvl 1")) {
                return "MS1";

            } else if (gebaeude.equals("Schlachter Lvl 2")) {
                return "MS2";

            } else if (gebaeude.equals("Schlachter Lvl 3")) {
                return "MS3";

            } else if (gebaeude.equals("Bauernhof Lvl 1")) {
                return "MB1";

            } else if (gebaeude.equals("Bauernhof Lvl 2")) {
                return "MB2";

            } else if (gebaeude.equals("Bauernhof Lvl 3")) {
                return "MB3";

            } else if (gebaeude.equals("Handelsposten Lvl 1")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 5);
                return "MP1";

            } else if (gebaeude.equals("Handelsposten Lvl 2")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 10);
                return "MP2";

            } else if (gebaeude.equals("Handelsposten Lvl 3")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 10);
                return "MP3";

            } else if (gebaeude.equals("Lager Lvl 1")) {
                return "ML1";

            } else if (gebaeude.equals("Lager Lvl 2")) {
                return "ML2";

            } else if (gebaeude.equals("Lager Lvl 3")) {
                return "ML3";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 1")) {
                return "MA1";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 2")) {
                return "MA2";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 3")) {
                return "MA3";

            } else {
                return "MF";
            }
        } else {
            if (gebaeude.equals("Restaurant Lvl 1")) {
                return "PR1";

            } else if (gebaeude.equals("Restaurant Lvl 2")) {
                return "PR2";

            } else if (gebaeude.equals("Restaurant Lvl 3")) {
                return "PR3";

            } else if (gebaeude.equals("DNA-Labor Lvl 1")) {
                return "PD1";

            } else if (gebaeude.equals("DNA-Labor Lvl 2")) {
                return "PD2";

            } else if (gebaeude.equals("DNA-Labor Lvl 3")) {
                return "PD3";

            } else if (gebaeude.equals("Muehle Lvl 1")) {
                return "PM1";

            } else if (gebaeude.equals("Muehle Lvl 2")) {
                return "PM2";

            } else if (gebaeude.equals("Muehle Lvl 3")) {
                return "PM3";

            } else if (gebaeude.equals("Schlachter Lvl 1")) {
                return "PS1";

            } else if (gebaeude.equals("Schlachter Lvl 2")) {
                return "PS2";

            } else if (gebaeude.equals("Schlachter Lvl 3")) {
                return "PS3";

            } else if (gebaeude.equals("Bauernhof Lvl 1")) {
                return "PB1";

            } else if (gebaeude.equals("Bauernhof Lvl 2")) {
                return "PB2";

            } else if (gebaeude.equals("Bauernhof Lvl 3")) {
                return "PB3";

            } else if (gebaeude.equals("Handelsposten Lvl 1")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 5);
                return "PP1";

            } else if (gebaeude.equals("Handelsposten Lvl 2")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 10);
                return "PP2";

            } else if (gebaeude.equals("Handelsposten Lvl 3")) {
                Spieler.getInstance().getAktuellerStandort().setErlaubteHandel(Spieler.getInstance().getAktuellerStandort().getErlaubteHandel() + 10);
                return "PP3";

            } else if (gebaeude.equals("Lager Lvl 1")) {
                return "PL1";

            } else if (gebaeude.equals("Lager Lvl 2")) {
                return "PL2";

            } else if (gebaeude.equals("Lager Lvl 3")) {
                return "PL3";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 1")) {
                return "PA1";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 2")) {
                return "PA2";

            } else if (gebaeude.equals("Rechtsabteilung Lvl 3")) {
                return "PA3";

            } else {
                return "PF";
            }
        }
    }

    /**
     * Diese Methode entscheidet anhand der Fraktion des eingeloggten Benutzers welches Hauptgebaeude Bild
     * das richtige fuer die GUI ist.
     *
     * @param fraktion
     * @param lvl
     * @return String[] mit Bildpfad und Level
     */
    public String[] setzeHauptgebaeude(String fraktion, int lvl) {

        String[] hg = new String[2];

        if (fraktion.equals("K")) {
            hg[0] = "/Bilder/FoodWarsKFCBasis.jpg";
        } else if (fraktion.equals("M")) {
            hg[0] = "/Bilder/FoodWarsMcKingBasis.jpg";
        } else {
            hg[0] = "/Bilder/FoodWarsPizzaCapBasis.jpg";
        }

        if (lvl == 1) {
            hg[1] = "1";
        } else if (lvl == 2) {
            hg[1] = "2";
        } else {
            hg[1] = "3";
        }

        return hg;
    }

}
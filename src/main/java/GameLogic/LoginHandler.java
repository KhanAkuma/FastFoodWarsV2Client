package GameLogic;

import Client.Threads.UpdateThread;
import Entities.*;

/**
 * Autoren: Christoph Wohlers, Jan Tilger, Michael Schwenk, Jakob Grosse Boeckmann
 */
public class LoginHandler {

    /**
     * Der LoginHandler soll beim Login alle zum Spieler gehoerigen Objekte erzeugt.
     * Dafuer werden mit dem BefehlHandler alle Daten aus der Datenbank vom Server
     * erfragt, die beim Login noetig sind. Die Antwort vom Server ist ein String-Array,
     * der alle noetigen Informationen enthaelt. Dieser wird benutzt, um alle noetigen Objekte
     * zu erzeugen bzw. alle noetigen Attribute zu setzen. Der erhaltene String sieht wie folgt aus:
     *
     * "TRUE-SPIELER;id;spielername;charakterbaum-FRAKTION;name;fraktionbaum-FRANCHISE;id-GELD;zahl-
     * GUTSCHEINE;zahl-STANDORTE;id;id;id-CHARAKTER;name-BONI;id-VNACHRICHTEN;id;id;id;-E
     * NACHRICHTEN;id;id;id-AUKTIONEN;id;id;id-LASTUPDATE-DARFFORSCHEN(true)-bewegungsIds"
     *
     * Ausserdem wird ein Update-Thread gestartet, der regelmaessig Waehrungen in der GUI aktualisiert.
     */

    /**
     * Die Login-Methode bekommt den Spielernamen und das Passwort. Sind diese Angaben korrekt,
     * werden vom Server alle noetigen Informationen vom Server erfragt und die zum Spieler
     * oder Client gehoerigen Objekte erzeugt und Attribute gesetzt.
     *
     * @param spielername Der Spieler, der sich einloggt
     * @param passwort    Das Passwort des Spielers, der sich einloggt.
     * @return True, falls der Login erfolgreich war, "No valid Input",
     * falls die Logindaten nicht stimmen.
     */
    public String login(String spielername, String passwort) {

        String[] befehl = {"EINLOGGEN", spielername, passwort};
        BefehlHandler bf = BefehlHandler.getInstance();
        String[] answer = bf.sendeBefehl(befehl);

        switch (answer[0]) {
            case "FALSE":
                return answer[1]; //Fehlermeldung wird zurueckgegeben / String: "FALSE;FEHLERMELDUNG"

            case "TRUE":
                Spieler spieler = Spieler.getInstance();
                spieler.setId(answer[2]);
                spieler.setName(answer[3]);

                spieler.setGeld(Integer.parseInt(answer[11]));
                spieler.setFraktion(answer[6]);
                BoniLogic boniLogic = new BoniLogic();
                boniLogic.setBoni();

                if (!answer[9].equals("null")) {
                    if (!answer[9].equals("0")) {
                        FranchiseHandler.getInstance().setFranchise(answer[9]);
                    } else {
                        spieler.setFranchise(new Franchise(answer[9]));
                    }
                }
                spieler.setGutschein(Integer.parseInt(answer[13]));
                spieler.setCharakter(answer[17]);
                //System.out.println("Answer laenge: " + answer.length);
                long lastupdate = Integer.parseInt(answer[26]);
                spieler.setLastupdate(lastupdate);
                spieler.initFraktionsBaum();
                spieler.initCharakterBaum();
                spieler.getCharakterBaum().updateBaum(answer[4]);
                spieler.getFraktionsBaum().updateBaum(answer[7]);
                StandortLogic sl = new StandortLogic();

                String[] standorteString = answer[15].split(";");

                for (int i = 0; i < standorteString.length; i++) {
                    String id = standorteString[i];
                    sl.createStandort(id);
                }

                spieler.setAktuellerStandort(spieler.getStandorte().get(0));

                NachrichtenLogic nl = new NachrichtenLogic();
                if (answer[21] != null && !answer[21].equals("")) {
                    String[] versendeteNachrichtenString = answer[21].split(";");

                    if (!versendeteNachrichtenString[0].equals("null")) {
                        for (int i = 0; i < versendeteNachrichtenString.length; i++) {
                            spieler.getGesendeteNachrichten().add(nl.createNachricht(versendeteNachrichtenString[i]));
                        }
                    }
                }
                if (answer[23] != null && !answer[23].equals("")) {
                    String[] empfangeneNachrichtenString = answer[23].split(";");
                    if (!empfangeneNachrichtenString[0].equals("null") && !answer[23].equals("")) {
                        for (int i = 0; i < empfangeneNachrichtenString.length; i++) {
                            spieler.getEmpfangeneNachrichten().add(nl.createNachricht(empfangeneNachrichtenString[i]));
                        }
                    }
                }

                Handelsposten handelsposten = Handelsposten.getInstance();

                HandelspostenLogic hl = new HandelspostenLogic();
                if (answer[25] != null && !answer[25].equals("")) {
                    String[] auktionenString = answer[25].split(";");
                    if (!auktionenString[0].equals("")) {
                        for (int i = 0; i < auktionenString.length; i++) {
                            handelsposten.getAuktionen().add(hl.erstelleAuktion(auktionenString[i]));
                        }
                    }
                }

                spieler.setDarfForschen(Boolean.parseBoolean(answer[27]));

                String[] befehl1 = {"ANFRAGE", "TRUPPENEIGENSCHAFTEN", spieler.getFraktion()};
                String[] answer1 = bf.sendeBefehl(befehl1);
                TruppenLogic tl = new TruppenLogic();
                tl.updateEigenschaften(answer1);
                String[] befehl2 = {"ANFRAGE", "GEBAEUDEEIGENSCHAFTEN", spieler.getFraktion()};
                String[] answer2 = bf.sendeBefehl(befehl2);
                GebaeudeLogic gebaeudeLogic = new GebaeudeLogic();
                gebaeudeLogic.updateEigenschaften(answer2);

                new Thread(new UpdateThread()).start();
                return "TRUE";

            default:
                return "No valid Input";

        }
    }
}

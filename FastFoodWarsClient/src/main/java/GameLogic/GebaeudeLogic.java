package GameLogic;

import Client.Threads.GebaeudeUpdateThread;
import Entities.Gebaeude;
import Entities.GebaeudeEigenschaften;
import Entities.Spieler;
import Entities.Standort;

/**
 * Autor: Christoph Wohlers
 */
public class GebaeudeLogic {

    /**
     * "TRUE-TYP;name"
     *
     * @param gebaeudeID
     * @return
     */

    /**
     * Die GebaeudeLogic erzeugt beim Login die zu einem Standort gehoerenden Gebaeude-Objekte.
     * Dazu werden anhand der Gebaeude-ID alle noetigen Informationen vom Server erfragt.
     */

    /**
     * Diese Methode erzeugt Gebaeude-Objekte. Dazu werden vom Server mit der ID die Informationen
     * abgerufen, damit ein Gebaeude erstellt und in die Gebaeude-Liste des Standorts geschrieben.
     * Der vom Server erhaltene String sieht dabei wie folgt aus:
     * <p>
     * "TRUE-TYP;name"
     *
     * @param gebaeudeID Gebaeude, das erzeugt werden soll
     * @return True, falls erfolgreich oder eine Exception
     */
    public Gebaeude createGebaeude(String gebaeudeID, Standort standort) {
        String[] befehl = {"LADEN", "GEBAEUDE", gebaeudeID};
        BefehlHandler bh = BefehlHandler.getInstance();
        String[] answer = bh.sendeBefehl(befehl);

        switch (answer[0]) {
            case "FALSE":
                throw new IllegalArgumentException();

            case "TRUE":
                //System.out.println("Answer: " + answer[0] + ";" + answer[1] + ";" + answer[2] + ";" + answer[3] + ";" + answer[4] + ";" + answer[5]);
                String typ = answer[2];
                boolean imBau = Boolean.parseBoolean(answer[5]);
                if (imBau) {
                    int lvl = Integer.parseInt(typ.substring(typ.length() - 1));
                    //System.out.println("Gebaeude level: " + lvl);
                    lvl = lvl + 1;
                    typ = typ.substring(0, typ.length() - 1) + lvl;
                    //System.out.print("Neuer Typ " + typ);
                }
                Gebaeude gebaeude = new Gebaeude(gebaeudeID, typ, imBau);
                standort.getGebaeudes()[Integer.parseInt(answer[4])] = gebaeude;
                if (Boolean.parseBoolean(answer[5])) {
                    String[] befehl1 = {"ANFRAGE", "FERTIGSTELLUNG", "GEBAEUDE", gebaeudeID};
                    String[] answer1 = bh.sendeBefehl(befehl1);
                    if (answer1[0].equals("TRUE")) {
                        long fertigstellung = Long.parseLong(answer1[1]);
                        //System.out.print("Fertigstellung: " + fertigstellung);
                        Spieler.getInstance().setAktuellerStandort(standort);
                        GebaeudeUpdateThread thread = new GebaeudeUpdateThread(gebaeude, fertigstellung, Spieler.getInstance().getAktuellerStandort().getId());
                        thread.start();
                    } else {
                        //System.out.println("Fuuuuuuuuuuuck alles kaputt");
                    }


                }

                return gebaeude;
            default:
                throw new IllegalArgumentException();
        }

    }

    /**
     * Es werden die Gebaeude-Eigenschaften vom Server abgefragt und geupdatet.
     *
     * @param answer Antwort vom Server
     */
    public void updateEigenschaften(String[] answer) {
        GebaeudeEigenschaften ge = GebaeudeEigenschaften.getInstance();
        int[] h1 = parseString(answer[0]);
        int[] h2 = parseString(answer[1]);
        int[] h3 = parseString(answer[2]);
        int[] b1 = parseString(answer[3]);
        int[] b2 = parseString(answer[4]);
        int[] b3 = parseString(answer[5]);
        int[] m1 = parseString(answer[6]);
        int[] m2 = parseString(answer[7]);
        int[] m3 = parseString(answer[8]);
        int[] s1 = parseString(answer[9]);
        int[] s2 = parseString(answer[10]);
        int[] s3 = parseString(answer[11]);
        int[] l1 = parseString(answer[12]);
        int[] l2 = parseString(answer[13]);
        int[] l3 = parseString(answer[14]);
        int[] r1 = parseString(answer[15]);
        int[] r2 = parseString(answer[16]);
        int[] r3 = parseString(answer[17]);
        int[] d1 = parseString(answer[18]);
        int[] d2 = parseString(answer[19]);
        int[] d3 = parseString(answer[20]);
        int[] p1 = parseString(answer[21]);
        int[] p2 = parseString(answer[22]);
        int[] p3 = parseString(answer[23]);
        int[] a1 = parseString(answer[24]);
        int[] a2 = parseString(answer[25]);
        int[] a3 = parseString(answer[26]);
        ge.setH1(h1);
        ge.setH2(h2);
        ge.setH3(h3);
        ge.setB1(b1);
        ge.setB2(b2);
        ge.setB3(b3);
        ge.setM1(m1);
        ge.setM2(m2);
        ge.setM3(m3);
        ge.setS1(s1);
        ge.setS2(s2);
        ge.setS3(s3);
        ge.setL1(l1);
        ge.setL2(l2);
        ge.setL3(l3);
        ge.setR1(r1);
        ge.setR2(r2);
        ge.setR3(r3);
        ge.setD1(d1);
        ge.setD2(d2);
        ge.setD3(d3);
        ge.setP1(p1);
        ge.setP2(p2);
        ge.setP3(p3);
        ge.setA1(a1);
        ge.setA2(a2);
        ge.setA3(a3);
    }

    /**
     * Methode, um die Strings aus der Server-Antwort in Integer umzuwandeln.
     *
     * @param toParse Server-String zum parsen
     * @return Server-Antwort als Integer
     */
    private int[] parseString(String toParse) {
        int[] result = new int[4];
        String[] array = toParse.split(";");
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}

package GameLogic;

/**
 * Created by Jan on 31/07/2016.
 */
public class kartenHandler {

    /**
     * Verwaltet die Karten.
     */

    private static kartenHandler kartenHandler;
    private String[][] spielerKarte = new String[10][10];

    private kartenHandler() {
    }


    public static kartenHandler getInstance() {
        if (kartenHandler.kartenHandler == null) {
            kartenHandler.kartenHandler = new kartenHandler();
        }
        return kartenHandler;
    }

    /**
     * Erwartet eine "Map" mit dem Aufbau
     * id;id;id;id;id;id....
     * 9x
     * nach Koordinaten sortiert
     * Bei keinem spieler  eine 0 als ID
     *
     * @param map
     */
    public void setKarte(String[] map) {
        for (int i = 1; i < 10; i++) {
            String[] chars = map[i].split(";");
            for (int n = 0; n < 9; n++) {
                spielerKarte[i - 1][n] = chars[n];
            }
        }

    }

    public String[][] getSpielerKarte() {
        return spielerKarte;
    }
}

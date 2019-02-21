package Client;

import Client.GUI.GUIMain;

/**
 * Autor: Christoph Wohlers
 */

public class Main {

    /**
     * Die Main-Klasse startet die GUI.
     */

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(GUIMain.class);
            }
        }.start();

    }

}

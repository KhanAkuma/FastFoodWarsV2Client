package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor: Christoph Wohlers
 */
public class Handelsposten {

    /**
     * Der Handelsposten wird beim Einloggen erstellt. Er haelt eine Liste von Auktionen.
     * Es gibt nur einen Handelsposten pro Client, daher ist dieser ein Singleton.
     */

    private List<Auktion> auktionen = new ArrayList<>();

    private static Handelsposten handelsposten;

    public Handelsposten() {

    }

    public static Handelsposten getInstance() {
        if (Handelsposten.handelsposten == null) {
            Handelsposten.handelsposten = new Handelsposten();
        }
        return handelsposten;
    }

    public static Handelsposten getHandelsposten() {
        return handelsposten;
    }

    public static void setHandelsposten(Handelsposten handelsposten) {
        Handelsposten.handelsposten = handelsposten;
    }

    public List<Auktion> getAuktionen() {
        return auktionen;
    }

    public void setAuktionen(List<Auktion> auktionen) {
        this.auktionen = auktionen;
    }
}

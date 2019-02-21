package Entities;

import GameLogic.BefehlHandler;

/**
 * Autor: Christoph Wohlers
 */
public class Nachricht {

    /**
     * Beim Erzeugen einer Nachricht fragt der Konstruktor den Server anhand der Nachricht-ID, welche
     * Parameter er hat. Der erhaltene String sieht wie folgt aus:
     * "TRUE;sender;empfaenger;nachricht;datum"
     */

    private String id;
    private String sender;
    private String empfaenger;
    private String nachricht;
    private String datum;


    public Nachricht(String id) {
        this.id = id;
        BefehlHandler bh = BefehlHandler.getInstance();

        String[] befehl = {"LADEN", "NACHRICHT", id};

        String[] nachrichtenString = bh.sendeBefehl(befehl);

        this.sender = nachrichtenString[1];
        this.empfaenger = nachrichtenString[2];
        this.nachricht = nachrichtenString[3];
        this.datum = nachrichtenString[4];
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getEmpfaenger() {
        return empfaenger;
    }

    public void setEmpfaenger(String empfaenger) {
        this.empfaenger = empfaenger;
    }

    public String getNachricht() {
        return nachricht;
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
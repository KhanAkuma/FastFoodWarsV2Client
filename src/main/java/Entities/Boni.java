package Entities;

/**
 * Kreiert von Jan Tilger
 * Die Singelton Klasse Boni ist fuer das "Aufbewahren" der Boni zustaendigt.
 * Es listet jeden Moegichen Boni mit dem ihm zugehoerigen Wert auf.
 * Diese "Liste" an Boni wird dynamisch anhand der erforschten Knoten gefuellt.
 */

public class Boni {
    private static Boni boni;

    public Boni() {

    }


    public static Boni getInstance() {
        if (Boni.boni == null) {
            Boni.boni = new Boni();
        }

        return boni;
    }

    //Boni zugehoerigkeit. Nur eines der beiden kann initialisert sein, dass andere ist dementsprechend null.
    private Franchise franchise;
    private Spieler spieler;
    private String id;

    //Standort- /Spielerboni
    private double verteidigungsbonus;
    private double produktionsbonus;
    private double geldbonus;

    //Gebaeudeboni
    private double mehlProduktionsbonus;
    private double fleischProduktionsbonus;
    private double gemueseProduktionsbonus;

    //Truppenboni
    private double truppenGeschwindigkeitsbonus;
    private double truppenKostenbonus;
    private double truppenAngriffsbonus;
    private double truppenVerteidigungsbonus;

    //Forschungsboni
    private double forschungsGeschwindigkeitsbonus;
    private double forschungsKostenbonus;


    public Spieler getSpieler() {
        return spieler;
    }

    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getVerteidigungsbonus() {
        return verteidigungsbonus;
    }

    public void setVerteidigungsbonus(double verteidigungsbonus) {
        this.verteidigungsbonus = verteidigungsbonus;
    }

    public double getProduktionsbonus() {
        return produktionsbonus;
    }

    public void setProduktionsbonus(double produktionsbonus) {
        this.produktionsbonus = produktionsbonus;
    }

    public double getGeldbonus() {
        return geldbonus;
    }

    public void setGeldbonus(double geldbonus) {
        this.geldbonus = geldbonus;
    }

    public double getMehlProduktionsbonus() {
        return mehlProduktionsbonus;
    }

    public void setMehlProduktionsbonus(double mehlProduktionsbonus) {
        this.mehlProduktionsbonus = mehlProduktionsbonus;
    }

    public double getFleischProduktionsbonus() {
        return fleischProduktionsbonus;
    }

    public void setFleischProduktionsbonus(double fleischProduktionsbonus) {
        this.fleischProduktionsbonus = fleischProduktionsbonus;
    }

    public double getGemueseProduktionsbonus() {
        return gemueseProduktionsbonus;
    }

    public void setGemueseProduktionsbonus(double gemueseProduktionsbonus) {
        this.gemueseProduktionsbonus = gemueseProduktionsbonus;
    }

    public double getTruppenGeschwindigkeitsbonus() {
        return truppenGeschwindigkeitsbonus;
    }

    public void setTruppenGeschwindigkeitsbonus(double truppenGeschwindigkeitsbonus) {
        this.truppenGeschwindigkeitsbonus = truppenGeschwindigkeitsbonus;
    }

    public double getTruppenKostenbonus() {
        return truppenKostenbonus;
    }

    public void setTruppenKostenbonus(double truppenKostenbonus) {
        this.truppenKostenbonus = truppenKostenbonus;
    }

    public double getTruppenAngriffsbonus() {
        return truppenAngriffsbonus;
    }

    public void setTruppenAngriffsbonus(double truppenAngrifssbonus) {
        this.truppenAngriffsbonus = truppenAngrifssbonus;
    }

    public double getTruppenVerteidigungsbonus() {
        return truppenVerteidigungsbonus;
    }

    public void setTruppenVerteidigungsbonus(double truppenVerteidigungsbonus) {
        this.truppenVerteidigungsbonus = truppenVerteidigungsbonus;
    }

    public double getForschungsGeschwindigkeitsbonus() {
        return forschungsGeschwindigkeitsbonus;
    }

    public void setForschungsGeschwindigkeitsbonus(double forschungsGeschwindigkeitsbonus) {
        this.forschungsGeschwindigkeitsbonus = forschungsGeschwindigkeitsbonus;
    }

    public double getForschungsKostenbonus() {
        return forschungsKostenbonus;
    }

    public void setForschungsKostenbonus(double forschungsKostenbonus) {
        this.forschungsKostenbonus = forschungsKostenbonus;
    }

}
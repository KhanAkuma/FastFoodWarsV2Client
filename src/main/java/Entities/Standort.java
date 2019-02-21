package Entities;

/**
 * Autoren: Christoph Wohlers, Michael Schwenk
 */

public class Standort {

    /**
     * Ein Standort hat ID, Name und einen Besitzer.
     * Im Standort werden zusaetzlich die Ressourcen, die sich an diesem Standort befinden,
     * gespeichert, die Koordinaten, wo sich dieser auf der Karte befindet, sowie
     * die Gebaeude mit den jeweiligen Stufen.
     */

    private String id;
    private String name;
    private Spieler besitzer;

    private int mehl;
    private int gemuese;
    private int fleisch;
    private int koordinateX;
    private int koordinateY;
    private int hauptgebaeudeLvl;
    private int verteidigung;
    private int erlaubteHandel;
    private int lt1;
    private int lt2;
    private int mt1;
    private int mt2;
    private int st1;
    private int st2;
    private int tt1;
    private int tt2;
    private int xt1;
    private int lt1ia;
    private int lt2ia;
    private int mt1ia;
    private int mt2ia;
    private int st1ia;
    private int st2ia;
    private int tt1ia;
    private int tt2ia;
    private int xt1ia;

    private boolean hauptGebauedeImBau = false;

    public boolean isHauptGebauedeImBau() {
        return hauptGebauedeImBau;
    }

    public void setHauptGebauedeImBau(boolean hauptGebauedeImBau) {
        this.hauptGebauedeImBau = hauptGebauedeImBau;
    }

    public int getLt1ia() {
        return lt1ia;
    }

    public void setLt1ia(int lt1ia) {
        this.lt1ia = lt1ia;
    }

    public int getLt2ia() {
        return lt2ia;
    }

    public void setLt2ia(int lt2ia) {
        this.lt2ia = lt2ia;
    }

    public int getMt1ia() {
        return mt1ia;
    }

    public void setMt1ia(int mt1ia) {
        this.mt1ia = mt1ia;
    }

    public int getMt2ia() {
        return mt2ia;
    }

    public void setMt2ia(int mt2ia) {
        this.mt2ia = mt2ia;
    }

    public int getSt1ia() {
        return st1ia;
    }

    public void setSt1ia(int st1ia) {
        this.st1ia = st1ia;
    }

    public int getSt2ia() {
        return st2ia;
    }

    public void setSt2ia(int st2ia) {
        this.st2ia = st2ia;
    }

    private Gebaeude[] gebaeudes = new Gebaeude[9];

    public Standort(String id, String name, Spieler besitzer, int mehl, int gemuese, int fleisch, int koordinateX, int koordinateY, int hauptgebaeudeLvl, int verteidigung, boolean hauptGebauedeImBau) {
        this.id = id;
        this.name = name;
        this.besitzer = besitzer;
        this.mehl = mehl;
        this.gemuese = gemuese;
        this.fleisch = fleisch;
        this.koordinateX = koordinateX;
        this.koordinateY = koordinateY;
        this.hauptgebaeudeLvl = hauptgebaeudeLvl;
        this.verteidigung = verteidigung;
        this.hauptGebauedeImBau = hauptGebauedeImBau;
        erlaubteHandel = 0;
        lt1 = 0;
        lt2 = 0;
        mt1 = 0;
        mt2 = 0;
        st1 = 0;
        st2 = 0;
        lt1ia = 0;
        lt2ia = 0;
        mt1ia = 0;
        mt2ia = 0;
        st1ia = 0;
        st2ia = 0;
        tt1 = 0;
        tt2 = 0;
        tt1ia = 0;
        tt2ia = 0;
        xt1 = 0;
        xt1ia = 0;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Spieler getBesitzer() {
        return besitzer;
    }

    public void setBesitzer(Spieler besitzer) {
        this.besitzer = besitzer;
    }

    public int getMehl() {
        return mehl;
    }

    public void setMehl(int mehl) {
        this.mehl = mehl;
    }

    public int getGemuese() {
        return gemuese;
    }

    public void setGemuese(int gemuese) {
        this.gemuese = gemuese;
    }

    public int getFleisch() {
        return fleisch;
    }

    public void setFleisch(int fleisch) {
        this.fleisch = fleisch;
    }

    public int getKoordinateX() {
        return koordinateX;
    }

    public void setKoordinateX(int koordinateX) {
        this.koordinateX = koordinateX;
    }

    public int getKoordinateY() {
        return koordinateY;
    }

    public void setKoordinateY(int koordinateY) {
        this.koordinateY = koordinateY;
    }

    public int getHauptgebaeude() {
        return hauptgebaeudeLvl;
    }

    public void setHauptgebaeude(Gebaeude hauptgebaeude) {
        this.hauptgebaeudeLvl = hauptgebaeudeLvl;
    }

    public int getVerteidigung() {
        return verteidigung;
    }

    public void setVerteidigung(int verteidigung) {
        this.verteidigung = verteidigung;
    }

    public Gebaeude[] getGebaeudes() {
        return gebaeudes;
    }

    public void setGebaeudes(Gebaeude[] gebaeudes) {
        this.gebaeudes = gebaeudes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHauptgebaeudeLvl() {
        return hauptgebaeudeLvl;
    }

    public void setHauptgebaeudeLvl(int hauptgebaeudeLvl) {
        this.hauptgebaeudeLvl = hauptgebaeudeLvl;
    }

    public int getErlaubteHandel() {
        return erlaubteHandel;
    }

    public void setErlaubteHandel(int erlaubteHandel) {
        this.erlaubteHandel = erlaubteHandel;
    }

    public int getLt1() {
        return lt1;
    }

    public void setLt1(int lt1) {
        this.lt1 = lt1;
    }

    public int getLt2() {
        return lt2;
    }

    public void setLt2(int lt2) {
        this.lt2 = lt2;
    }

    public int getMt1() {
        return mt1;
    }

    public void setMt1(int mt1) {
        this.mt1 = mt1;
    }

    public int getMt2() {
        return mt2;
    }

    public void setMt2(int mt2) {
        this.mt2 = mt2;
    }

    public int getSt1() {
        return st1;
    }

    public void setSt1(int st1) {
        this.st1 = st1;
    }

    public int getSt2() {
        return st2;
    }

    public void setSt2(int st2) {
        this.st2 = st2;
    }

    public int getTt1() {
        return tt1;
    }

    public void setTt1(int tt1) {
        this.tt1 = tt1;
    }

    public int getTt2() {
        return tt2;
    }

    public void setTt2(int tt2) {
        this.tt2 = tt2;
    }

    public int getTt1ia() {
        return tt1ia;
    }

    public void setTt1ia(int tt1ia) {
        this.tt1ia = tt1ia;
    }

    public int getTt2ia() {
        return tt2ia;
    }

    public void setTt2ia(int tt2ia) {
        this.tt2ia = tt2ia;
    }

    public int getXt1() {
        return xt1;
    }

    public void setXt1(int xt1) {
        this.xt1 = xt1;
    }

    public int getXt1ia() {
        return xt1ia;
    }

    public void setXt1ia(int xt1ia) {
        this.xt1ia = xt1ia;
    }

    public int getKapazitaet() {
        GebaeudeEigenschaften ge = GebaeudeEigenschaften.getInstance();
        int kap = 0;
        for (Gebaeude gebaeude : gebaeudes) {
            if (gebaeude != null) {
                if (gebaeude.getTyp().contains("L1")) {
                    if (!gebaeude.isImBau()) {
                        kap += ge.getL1()[2];
                    }
                } else if (gebaeude.getTyp().contains("L2")) {
                    if (!gebaeude.isImBau()) {
                        kap += ge.getL2()[2];
                    } else {
                        kap += ge.getL1()[2];
                    }
                } else if (gebaeude.getTyp().contains("L3")) {
                    if (!gebaeude.isImBau()) {
                        kap += ge.getL3()[2];
                    } else {
                        kap += ge.getL2()[2];
                    }
                }
            }
        }
        return kap;
    }
}

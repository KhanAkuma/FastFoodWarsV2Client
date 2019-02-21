package Entities;

/**
 * Created by Jakob on 02.08.2016.
 */
public class TruppenEigenschaften {

    /**
     * Verwaltet die Eigenschaften der Truppen.
     */

    private static TruppenEigenschaften instance;

    //Array der Form: kostenMehl;kostenFleisch;kostenGemuese;angriff;verteidigung;bauzeit;kapazitaet
    private int[] l1 = new int[7];
    private int[] l2 = new int[7];
    private int[] m1 = new int[7];
    private int[] m2 = new int[7];
    private int[] s1 = new int[7];
    private int[] s2 = new int[7];
    private int[] t1 = new int[7];
    private int[] t2 = new int[7];
    private int[] x1 = new int[7];

    private TruppenEigenschaften() {
    }

    public static TruppenEigenschaften getInstance() {
        if (TruppenEigenschaften.instance == null) {
            TruppenEigenschaften.instance = new TruppenEigenschaften();
        }
        return TruppenEigenschaften.instance;
    }

    public int[] getL1() {
        return l1;
    }

    public void setL1(int[] l1) {
        this.l1 = l1;
    }

    public int[] getL2() {
        return l2;
    }

    public void setL2(int[] l2) {
        this.l2 = l2;
    }

    public int[] getM1() {
        return m1;
    }

    public void setM1(int[] m1) {
        this.m1 = m1;
    }

    public int[] getM2() {
        return m2;
    }

    public void setM2(int[] m2) {
        this.m2 = m2;
    }

    public int[] getS1() {
        return s1;
    }

    public void setS1(int[] s1) {
        this.s1 = s1;
    }

    public int[] getS2() {
        return s2;
    }

    public void setS2(int[] s2) {
        this.s2 = s2;
    }

    public int[] getT1() {
        return t1;
    }

    public void setT1(int[] t1) {
        this.t1 = t1;
    }

    public int[] getT2() {
        return t2;
    }

    public void setT2(int[] t2) {
        this.t2 = t2;
    }

    public int[] getX1() {
        return x1;
    }

    public void setX1(int[] x1) {
        this.x1 = x1;
    }
}

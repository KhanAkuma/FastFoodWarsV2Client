package Entities;

/**
 * Created by Jakob on 03.08.2016.
 */
public class GebaeudeEigenschaften {

    /**
     * Verwaltet die Eigenschaften der Gebaeude.
     */

    private static GebaeudeEigenschaften instance;

    //Array der Form: {kosten, produktion, kapazitaet, bauzeit}
    private int[] h1 = new int[4];
    private int[] h2 = new int[4];
    private int[] h3 = new int[4];
    private int[] b1 = new int[4];
    private int[] b2 = new int[4];
    private int[] b3 = new int[4];
    private int[] m1 = new int[4];
    private int[] m2 = new int[4];
    private int[] m3 = new int[4];
    private int[] s1 = new int[4];
    private int[] s2 = new int[4];
    private int[] s3 = new int[4];
    private int[] l1 = new int[4];
    private int[] l2 = new int[4];
    private int[] l3 = new int[4];
    private int[] r1 = new int[4];
    private int[] r2 = new int[4];
    private int[] r3 = new int[4];
    private int[] d1 = new int[4];
    private int[] d2 = new int[4];
    private int[] d3 = new int[4];
    private int[] p1 = new int[4];
    private int[] p2 = new int[4];
    private int[] p3 = new int[4];
    private int[] a1 = new int[4];
    private int[] a2 = new int[4];
    private int[] a3 = new int[4];

    private GebaeudeEigenschaften() {
    }

    public static GebaeudeEigenschaften getInstance() {
        if (GebaeudeEigenschaften.instance == null) {
            GebaeudeEigenschaften.instance = new GebaeudeEigenschaften();
        }
        return GebaeudeEigenschaften.instance;
    }

    public int[] getH1() {
        return h1;
    }

    public void setH1(int[] h1) {
        this.h1 = h1;
    }

    public int[] getH2() {
        return h2;
    }

    public void setH2(int[] h2) {
        this.h2 = h2;
    }

    public int[] getH3() {
        return h3;
    }

    public void setH3(int[] h3) {
        this.h3 = h3;
    }

    public int[] getB1() {
        return b1;
    }

    public void setB1(int[] b1) {
        this.b1 = b1;
    }

    public int[] getB2() {
        return b2;
    }

    public void setB2(int[] b2) {
        this.b2 = b2;
    }

    public int[] getB3() {
        return b3;
    }

    public void setB3(int[] b3) {
        this.b3 = b3;
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

    public int[] getM3() {
        return m3;
    }

    public void setM3(int[] m3) {
        this.m3 = m3;
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

    public int[] getS3() {
        return s3;
    }

    public void setS3(int[] s3) {
        this.s3 = s3;
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

    public int[] getL3() {
        return l3;
    }

    public void setL3(int[] l3) {
        this.l3 = l3;
    }

    public int[] getR1() {
        return r1;
    }

    public void setR1(int[] r1) {
        this.r1 = r1;
    }

    public int[] getR2() {
        return r2;
    }

    public void setR2(int[] r2) {
        this.r2 = r2;
    }

    public int[] getR3() {
        return r3;
    }

    public void setR3(int[] r3) {
        this.r3 = r3;
    }

    public int[] getD1() {
        return d1;
    }

    public void setD1(int[] d1) {
        this.d1 = d1;
    }

    public int[] getD2() {
        return d2;
    }

    public void setD2(int[] d2) {
        this.d2 = d2;
    }

    public int[] getD3() {
        return d3;
    }

    public void setD3(int[] d3) {
        this.d3 = d3;
    }

    public int[] getP1() {
        return p1;
    }

    public void setP1(int[] p1) {
        this.p1 = p1;
    }

    public int[] getP2() {
        return p2;
    }

    public void setP2(int[] p2) {
        this.p2 = p2;
    }

    public int[] getP3() {
        return p3;
    }

    public void setP3(int[] p3) {
        this.p3 = p3;
    }

    public int[] getA1() {
        return a1;
    }

    public void setA1(int[] a1) {
        this.a1 = a1;
    }

    public int[] getA2() {
        return a2;
    }

    public void setA2(int[] a2) {
        this.a2 = a2;
    }

    public int[] getA3() {
        return a3;
    }

    public void setA3(int[] a3) {
        this.a3 = a3;
    }
}

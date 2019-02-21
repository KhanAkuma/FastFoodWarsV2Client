package GameLogic;

import Entities.TruppenEigenschaften;

/**
 * Created by Jakob on 02.08.2016.
 */
public class TruppenLogic {

    /**
     * Setzt die Eigenschaften der Truppen.
     * @param answer
     */

    public void updateEigenschaften(String[] answer) {
        TruppenEigenschaften te = TruppenEigenschaften.getInstance();
        int[] l1 = parseString(answer[0]);
        te.setL1(l1);
        int[] l2 = parseString(answer[1]);
        te.setL2(l2);
        int[] m1 = parseString(answer[2]);
        te.setM1(m1);
        int[] m2 = parseString(answer[3]);
        te.setM2(m2);
        int[] s1 = parseString(answer[4]);
        te.setS1(s1);
        int[] s2 = parseString(answer[5]);
        te.setS2(s2);
        int[] t1 = parseString(answer[6]);
        te.setT1(t1);
        int[] t2 = parseString(answer[7]);
        te.setT2(t2);
        int[] x1 = parseString(answer[8]);
        te.setX1(x1);
    }

    private int[] parseString(String toParse) {
        int[] result = new int[7];
        String[] array = toParse.split(";");
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }
}

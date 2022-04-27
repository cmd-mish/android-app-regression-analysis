package fi.arcada.regressionsanalys;

public class RegressionLine {

    private static double[] xData, yData;
    private double k, m, x;

    // Konstruktormetod
    public RegressionLine(double[] xData, double[] yData) {
        this.xData = new double[xData.length];
        for (int i = 0; i < xData.length; i++) {
            this.xData[i] += xData[i];
        }

        this.yData = new double[yData.length];
        for (int i = 0; i < yData.length; i++) {
            this.yData[i] += yData[i];
        }

        this.k = getk();
    }

    // Formeln för minsta kvadratmetoden
    public static double getk() {
        /* PREPARE DATA */
        int n;
        double Sx, Sy, Sxy, Sx2;
        double[] xy, x2, y2;

        // n
        n = xData.length;

        // Sx
        Sx = 0.0;
        for (double value: xData) {
            Sx += value;
        }

        // Sy
        Sy = 0.0;
        for (double value: yData) {
            Sy += value;
        }

        // xy
        xy = new double[n];
        for (int i = 0; i < n; i++) {
            xy[i] = xData[i] * yData[i];
        }

        // x2
        x2 = new double[n];
        for (int i = 0; i < n; i++) {
            x2[i] = Math.pow(xData[i], 2);
        }

        // y2
        y2 = new double[n];
        for (int i = 0; i < n; i++) {
            y2[i] = Math.pow(yData[i], 2);
        }

        // Sxy
        Sxy = 0.0;
        for (double value: xy) {
            Sxy += value;
        }

        // Sx2
        Sx2 = 0.0;
        for (double value: x2) {
            Sx2 += value;
        }

        /* CALCULATE FORMULA IN 6 STEPS (s1 - s6) */

        // n(Sxy)
        double s1 = n * Sxy;
        System.out.println("s1: " + s1);

        // (Sx)(Sy)
        double s2 = Sx * Sy;
        System.out.println("s2: " + s2);

        // n(Sxy) - (Sx)(Sy)
        double s3 = s1 - s2;
        System.out.println("s3: " + s3);

        // n(Sx2)
        double s4 = n * Sx2;
        System.out.println("s4: " + s4);

        // (Sx)2
        double s5 = Math.pow(Sx2, 2);
        System.out.println("s5: " + s5);

        // n(Sx2) - (Sx)2
        double s6 = s4 - s5;
        System.out.println("s6: " + s6);

        // k
        double k = s3 / s6;
        System.out.println("k: " + k);
        return k;
    }

    // Del 3: Korrelationskoefficienten
    public static double getCorrelationCoefficient() {
        /* PREPARE DATA */
        int n;
        double Sx, Sy, Sxy, Sx2, Sy2;
        double[] xy, x2, y2;

        // n
        n = xData.length;

        // Sx
        Sx = 0.0;
        for (double value: xData) {
            Sx += value;
        }

        // Sy
        Sy = 0.0;
        for (double value: yData) {
            Sy += value;
        }

        // xy
        xy = new double[n];
        for (int i = 0; i < n; i++) {
            xy[i] = xData[i] * yData[i];
        }

        // x2
        x2 = new double[n];
        for (int i = 0; i < n; i++) {
            x2[i] = Math.pow(xData[i], 2);
        }

        // y2
        y2 = new double[n];
        for (int i = 0; i < n; i++) {
            y2[i] = Math.pow(yData[i], 2);
        }

        // Sxy
        Sxy = 0.0;
        for (double value: xy) {
            Sxy += value;
        }

        // Sx2
        Sx2 = 0.0;
        for (double value: x2) {
            Sx2 += value;
        }

        // Sy2
        Sy2 = 0.0;
        for (double value: y2) {
            Sy2 += value;
        }

        /* CALCULATE FORMULA in 11 steps (s1 - s11) */

        // n(Sxy)
        double s1 = n * Sxy;

        // (Sx)(Sy)
        double s2 = Sx * Sy;

        // n(Sxy) - (Sx)(Sy)
        double s3 = s1 - s2;

        // n * Sx2
        double s4 = n * Sx2;

        // n * Sy2
        double s5 = n * Sy2;

        // (Sx)2
        double s6 = Math.pow(Sx, 2);

        // (Sy)2
        double s7 = Math.pow(Sy, 2);

        // (n * Sx2) - (Sx)2
        double s8 = s4 - s6;

        // (n * Sy2) - (Sy)2
        double s9 = s5 - s7;

        // [(n * Sx2) - (Sx)2] * [(n * Sy2) - (Sy)2]
        double s10 = s8 * s9;

        // sqrt s10
        double s11 = Math.sqrt(s10);

        // r
        double r = s3 / s11;
        return  r;
    }



    // deklarera k, m, x  och correlationCoefficient som double

    // Skapa en konstruktor som tar emot data-arrays för x och y
    // Uträkningen för k och m kan ske i konstruktorn m.h.a.
    // formeln för minsta kvadratmetoden
    // Del 3: uträkningen för correlationCoefficient kan också ske i konstruktorn
    // (det är förstås också ok att ha en skild metod för uträknigarna om man vill
    // hålla konstruktorn simpel.)

    // skapa en metod getX som tar emot ett y-värde, räknar ut x
    // m.h.a. räta linjens ekvation y=kx+m, och returnerar x

    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgrad

}
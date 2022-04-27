package fi.arcada.regressionsanalys;

public class RegressionLine {

    double[] xData, yData;
    double k, m, x, r;

    public RegressionLine(double[] xData, double[] yData) {
        this.xData = xData;
        this.yData = yData;
    }

    public static void rCalculate(double[] xData, double[] yData) {
        /* PREPARE DATA */
        int n;
        double Sx, Sy, Sxy, Sx2, Sy2;
        double[] xy, x2, y2;

        // n
        n = xData.length;
        System.out.println("n " + n);

        // Sx
        Sx = 0.0;
        for (double value: xData) {
            Sx += value;
        }
        System.out.println("Sx " + Sx);

        // Sy
        Sy = 0.0;
        for (double value: yData) {
            Sy += value;
        }
        System.out.println("Sy " + Sy);

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
        System.out.println("Sxy " + Sxy);

        // Sx2
        Sx2 = 0.0;
        for (double value: x2) {
            Sx2 += value;
        }
        System.out.println("Sx2 " + Sx2);

        // Sy2
        Sy2 = 0.0;
        for (double value: y2) {
            Sy2 += value;
        }
        System.out.println("Sy2 " + Sy2);

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

        System.out.println("r " + r);
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
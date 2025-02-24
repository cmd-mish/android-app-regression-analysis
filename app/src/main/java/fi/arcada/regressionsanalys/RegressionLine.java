package fi.arcada.regressionsanalys;

public class RegressionLine {

    private static double[] xData, yData;
    private double k, m, correlationCoefficient;

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
        this.correlationCoefficient = getCorrelationCoefficient();
        this.m = getm();
    }

    // Formeln för minsta kvadratmetoden
    public double getk() {
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

        // (Sx)(Sy)
        double s2 = Sx * Sy;

        // n(Sxy) - (Sx)(Sy)
        double s3 = s1 - s2;

        // n(Sx2)
        double s4 = n * Sx2;

        // (Sx)2
        double s5 = Math.pow(Sx, 2);

        // n(Sx2) - (Sx)2
        double s6 = s4 - s5;

        // k
        double k = s3 / s6;
        return k;
    }

    public double getm() {
        /* PREPARE DATA */
        int n;
        double My, Mx, sum, m;

        // n
        n = xData.length;

        // My
        My = 0.0;
        sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += yData[i];
        }
        My = sum / n;

        // Mx
        Mx = 0.0;
        sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += xData[i];
        }
        Mx = sum / n;

        /* CALCULATE FORMULA */
        m = My - this.k * Mx;
        return m;
    }

    public double getX(double y) {
        double x;
        x = (y - this.m) / this.k;
        return x;
    }

    // Del 3: Korrelationskoefficienten
    public double getCorrelationCoefficient() {
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

    public String getCorrelationGrade() {
        String grade = "";
        double r = this.correlationCoefficient;

        if (r == 1 || r == -1) grade = "Perfekt";
        if ((r < 1 && r >= 0.75) || (r > -1 && r <= -0.75)) grade = "Hög";
        if ((r < 0.75 && r >= 0.25) || (r > -0.75 && r <= -0.25)) grade = "Måttlig";
        if ((r < 0.25 && r > 0) || (r > -0.25 && r < 0)) grade = "Låg";
        if (r == 0) grade = "Ingen korrelation";

        return grade;
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
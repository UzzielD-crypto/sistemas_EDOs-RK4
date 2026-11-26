public class RK4CircuitoRLC {

    public static double[] evaluarSistema(double t, double[] Y) {
        double y1 = Y[0];
        double y2 = Y[1];

        // TODO 1
        double dy1 = y2;
        double dy2 = -0.4 * y2 - y1;

        return new double[]{dy1, dy2};
    }

    public static double[] sumaEscalada(double[] A, double factor, double[] B) {
        int n = A.length;
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = A[i] + factor * B[i];
        }
        return res;
    }
    public static double exacta(double t) {
        double wd = Math.sqrt(0.96);
        return Math.exp(-0.2 * t) * (Math.cos(wd * t) + (0.2 / wd) * Math.sin(wd * t));
    }
    public static void main(String[] args) {
        double t0 = 0.0;
        double h = 0.2; // 0.2, 0.1, 0.05
        int nPuntos = 25;

        double[] Y = {1.0, 0.0};
        double t = t0;

        System.out.println("n\t t_n\t y1 (Carga)\t y2 (Corr)");
        System.out.println("---------------------------------------------");
        System.out.printf("%d\t %.2f\t %.6f\t %.6f\n", 0, t, Y[0], Y[1]);

        for (int i = 0; i < nPuntos; i++) {
            double[] k1 = evaluarSistema(t, Y);
            double[] k2 = evaluarSistema(t + h / 2.0, sumaEscalada(Y, h / 2.0, k1));
            double[] k3 = evaluarSistema(t + h / 2.0, sumaEscalada(Y, h / 2.0, k2));

            // TODO 2
            double[] k4 = evaluarSistema(t + h, sumaEscalada(Y, h, k3));

            // TODO 3
            for (int j = 0; j < Y.length; j++) {
                Y[j] = Y[j] + (h / 6.0) * (k1[j] + 2 * k2[j] + 2 * k3[j] + k4[j]);
            }

            t += h;
            System.out.printf("%d\t %.2f\t %.6f\t %.6f\n", i + 1, t, Y[0], Y[1]);
        }
    }
}
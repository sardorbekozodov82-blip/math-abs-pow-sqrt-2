public class MathAbsPowSqrtAdvanced {

    // Mandelbrot set membership
    static boolean inMandelbrot(double cr, double ci, int maxIter) {
        double zr=0, zi=0;
        for (int i=0; i<maxIter; i++) {
            double nzr = zr*zr - zi*zi + cr;
            double nzi = 2*zr*zi + ci;
            zr=nzr; zi=nzi;
            if (Math.sqrt(zr*zr + zi*zi) > 2) return false;
        }
        return true;
    }

    // Newton-Raphson square root
    static double sqrtNewton(double n) {
        if (n < 0) return Double.NaN;
        double x = n;
        while (Math.abs(x*x - n) > 1e-10) x = (x + n/x) / 2.0;
        return x;
    }

    // Prime factorization using sqrt
    static java.util.List<Integer> primeFactors(int n) {
        java.util.List<Integer> factors = new java.util.ArrayList<>();
        for (int i=2; i <= Math.sqrt(n); i++)
            while (n % i == 0) { factors.add(i); n /= i; }
        if (n > 1) factors.add(n);
        return factors;
    }

    // Compound interest with Math.pow
    static double futureValue(double pv, double rate, int periods) {
        return pv * Math.pow(1 + rate, periods);
    }

    public static void main(String[] args) {
        System.out.println("=== Newton-Raphson sqrt ===");
        for (double n : new double[]{2, 3, 9, 144, 1000})
            System.out.printf("sqrt(%.0f) = %.10f (Math: %.10f)%n", n, sqrtNewton(n), Math.sqrt(n));

        System.out.println("\n=== Prime Factorization ===");
        for (int n : new int[]{12, 60, 100, 360, 1024})
            System.out.printf("%4d = %s%n", n, primeFactors(n));

        System.out.println("\n=== Investment Future Value ===");
        System.out.printf("$10,000 at 7%% for 10yr = $%,.2f%n", futureValue(10000,0.07,10));
        System.out.printf("$50,000 at 5%% for 20yr = $%,.2f%n", futureValue(50000,0.05,20));

        System.out.println("\n=== Mandelbrot Membership ===");
        double[][] points = {{0,0},{-1,0},{0.5,0.5},{2,2},{-0.5,0.5}};
        for (double[] p : points)
            System.out.printf("(%.1f+%.1fi) → %s%n", p[0],p[1], inMandelbrot(p[0],p[1],100)?"IN":"OUT");
    }
}

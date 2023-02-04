package medium;

public class M50Pow {

    public static double myPow(double x, int n) {
        long count = n;
        if (count < 0) {
            x = 1 / x;
            count = -count;
        }
        double pow = 1;
        for (long i = 0; i < count; i++) {
            pow *= x;
        }
        return pow;
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow2(double x, int n) {
        long count = n;
        if (count < 0) {
            x = 1 / x;
            count = -count;
        }
        double pow = 1;
        double currentProduct = x;
        for (long i = count; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                pow *= currentProduct;
            }
            currentProduct *= currentProduct;
        }
        return pow;
    }
}

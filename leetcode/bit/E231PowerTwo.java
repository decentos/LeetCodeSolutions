package bit;

public class E231PowerTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        // log2(Integer.MAX_VALUE) = 30; 2^30 = 1073741824;
        return n > 0 && 1073741824 % n == 0;
    }
}

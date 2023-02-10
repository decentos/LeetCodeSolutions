package easy;

public class E342PowerFour {

    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public boolean isPowerOfFour2(int n) {
        // Math.log(n) / Math.log(2) == log2(n);
        return n > 0 && (Math.log(n) / Math.log(2) % 2 == 0);
    }
}

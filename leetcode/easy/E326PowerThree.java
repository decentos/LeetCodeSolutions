package easy;

public class E326PowerThree {

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        // log3(Integer.MAX_VALUE) = 19; 3^19 = 1162261467;
        return n > 0 && 1162261467 % n == 0;
    }
}

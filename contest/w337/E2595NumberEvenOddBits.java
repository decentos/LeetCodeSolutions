package w337;

public class E2595NumberEvenOddBits {

    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        String binary = Integer.toBinaryString(n);
        StringBuilder reverse = new StringBuilder(binary).reverse();
        for (int i = 0; i < reverse.length(); i++) {
            if (reverse.charAt(i) == '0') continue;

            if (i % 2 == 0) ans[0]++;
            else ans[1]++;
        }
        return ans;
    }
}

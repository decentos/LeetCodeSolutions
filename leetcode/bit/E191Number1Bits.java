package bit;

public class E191Number1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        String binary = Integer.toBinaryString(n);
        for (char i : binary.toCharArray()) {
            if (i == '1') count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }
}

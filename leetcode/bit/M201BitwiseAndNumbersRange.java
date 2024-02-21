package bit;

public class M201BitwiseAndNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        String binaryLeft = Integer.toBinaryString(left);
        String binaryRight = Integer.toBinaryString(right);
        if (binaryLeft.length() != binaryRight.length()) {
            return 0;
        }
        StringBuilder prefix = new StringBuilder("0".repeat(binaryLeft.length()));
        for (int i = 0; i < binaryLeft.length(); i++) {
            if (binaryLeft.charAt(i) != binaryRight.charAt(i)) {
                break;
            }

            if (binaryLeft.charAt(i) == '1') {
                prefix.setCharAt(i, binaryLeft.charAt(i));
            }
        }
        return Integer.valueOf(prefix.toString(), 2);
    }

    public int rangeBitwiseAnd2(int left, int right) {
        int shift = 0;
        // find the common 1-bits
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}

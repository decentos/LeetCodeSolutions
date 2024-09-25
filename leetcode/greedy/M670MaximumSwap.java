package greedy;

public class M670MaximumSwap {

    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];

        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i] - '0';
            lastIndex[digit] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i] - '0';
            for (int j = 9; j > digit; j--) {
                if (lastIndex[j] > i) {
                    char temp = digits[i];
                    digits[i] = digits[lastIndex[j]];
                    digits[lastIndex[j]] = temp;
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }
        return num;
    }
}

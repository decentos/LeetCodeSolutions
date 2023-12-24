package string;

public class E1758MinChangesToMakeBinary {

    public int minOperations(String s) {
        int n = s.length();
        char startsOne = '1', startsZero = '0';
        int countOne = 0, countZero = 0;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (curr != startsOne) {
                countOne++;
            }
            if (curr != startsZero) {
                countZero++;
            }
            char temp = startsOne;
            startsOne = startsZero;
            startsZero = temp;
        }
        return Math.min(countOne, countZero);
    }

// ===============================================================================

    public int minOperations2(String s) {
        int n = s.length();
        char startsOne = '1';
        int countOne = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != startsOne) {
                countOne++;
            }
            startsOne = startsOne == '1' ? '0' : '1';
        }
        return Math.min(countOne, n - countOne);
    }
}

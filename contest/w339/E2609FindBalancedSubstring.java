package w339;

public class E2609FindBalancedSubstring {

    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        for (int i = 0, j = i + 1; j < s.length(); i++, j++) {
            if (s.charAt(i) == '0' && s.charAt(j) == '1') {
                int curr = 2;
                int zeroIndex = i - 1;
                int oneIndex = j + 1;
                while (zeroIndex >= 0 && oneIndex < s.length() && s.charAt(zeroIndex) == '0' && s.charAt(oneIndex) == '1') {
                    curr += 2;
                    zeroIndex--;
                    oneIndex++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    public int findTheLongestBalancedSubstring2(String s) {
        int max = 0;
        String temp = "01";
        while (temp.length() <= s.length()) {
            if (s.contains(temp)) {
                max = temp.length();
                temp = String.format("0%s1", temp);
            } else {
                break;
            }
        }
        return max;
    }

    public int findTheLongestBalancedSubstring3(String s) {
        int max = 0, zeros = 0, ones = 0, i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == '0') {
                zeros++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1') {
                ones++;
                i++;
            }
            max = Math.max(max, 2 * Math.min(zeros, ones));
            zeros = 0;
            ones = 0;
        }
        return max;
    }
}

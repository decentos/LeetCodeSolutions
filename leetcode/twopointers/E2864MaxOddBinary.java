package twopointers;

public class E2864MaxOddBinary {

    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;

        while (left <= right) {
            while (left <= right && chars[left] == '1') {
                left++;
            }
            while (left <= right && chars[right] == '0') {
                right--;
            }
            if (left < right) {
                chars[left] = '1';
                chars[right] = '0';
            }
        }
        chars[left - 1] = chars[n - 1];
        chars[n - 1] = '1';
        return String.valueOf(chars);
    }
}

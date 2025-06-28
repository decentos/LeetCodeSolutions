package uber.algo;

public class M5LongestPalindromicSubstring {

    private int low, high;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            isPalindrome(s, i, i);
            isPalindrome(s, i, i + 1);
        }
        return s.substring(low, high + 1);
    }

    private void isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;

        if (high - low < right - left) {
            low = left;
            high = right;
        }
    }
}

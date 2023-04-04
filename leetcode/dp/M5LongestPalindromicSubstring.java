package dp;

public class M5LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        String sub = "";

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String currSub = s.substring(i, j);
                if (currSub.length() > sub.length() && isPalindrome(currSub)) {
                    sub = currSub;
                }
            }
        }
        return sub;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

// ===============================================================================

    private int low;
    private int high;

    public String longestPalindrome2(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        return s.substring(low, high + 1);
    }

    private void findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;

        if (right - left > high - low) {
            low = left;
            high = right;
        }
    }
}

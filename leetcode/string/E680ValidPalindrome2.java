package string;

public class E680ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindromeAfterRemoving(s, left + 1, right) || isPalindromeAfterRemoving(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindromeAfterRemoving(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}

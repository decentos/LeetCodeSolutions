package string;

public class E2108FindFirstPalindromic {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindromic(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindromic(String word) {
        int left = 0, right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

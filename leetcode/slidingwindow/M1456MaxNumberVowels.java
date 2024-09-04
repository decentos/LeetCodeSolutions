package slidingwindow;

public class M1456MaxNumberVowels {

    public int maxVowels(String s, int k) {
        int curr = 0;

        for (int i = 0; i < k; i++) {
            curr += isVowel(s.charAt(i)) ? 1 : 0;
        }

        int max = curr;

        for (int i = k; i < s.length(); i++) {
            curr += isVowel(s.charAt(i)) ? 1 : 0;
            curr -= isVowel(s.charAt(i - k)) ? 1 : 0;
            max = Math.max(max, curr);

            if (max == k) {
                return max;
            }
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

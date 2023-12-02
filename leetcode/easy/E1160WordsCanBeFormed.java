package easy;

import java.util.Arrays;

public class E1160WordsCanBeFormed {

    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] alpha = new int[26];
        int[] beta = new int[26];
        for (char c : chars.toCharArray()) {
            alpha[c - 'a']++;
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                beta[c - 'a']++;
            }

            int i = 0;
            while (i < alpha.length) {
                if (beta[i] > alpha[i]) break;
                i++;
            }

            if (i == alpha.length) {
                ans += word.length();
            }
            Arrays.fill(beta, 0);
        }
        return ans;
    }
}

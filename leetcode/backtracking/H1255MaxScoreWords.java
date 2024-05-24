package backtracking;

public class H1255MaxScoreWords {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char с : letters) {
            count[с - 'a']++;
        }
        int res = backtrack(words, count, score, 0);
        return res;
    }

    int backtrack(String[] words, int[] count, int[] score, int index) {
        int max = 0;
        for (int i = index; i < words.length; i++) {
            int res = 0;
            boolean isValid = true;

            for (char c : words[i].toCharArray()) {
                count[c - 'a']--;
                res += score[c - 'a'];
                if (count[c - 'a'] < 0) {
                    isValid = false;
                }
            }

            if (isValid) {
                res += backtrack(words, count, score, i + 1);
                max = Math.max(res, max);
            }

            for (char c : words[i].toCharArray()) {
                count[c - 'a']++;
            }
        }
        return max;
    }
}

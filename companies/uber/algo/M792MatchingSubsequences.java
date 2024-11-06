package uber.algo;

import java.util.HashMap;
import java.util.Map;

public class M792MatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length(), count = 0;
        Map<String, Integer> uniqueWords = new HashMap<>();

        for (String word : words) {
            uniqueWords.merge(word, 1, Integer::sum);
        }

        for (String word : uniqueWords.keySet()) {
            int wordIndex = 0, m = word.length(), sIndex = 0;

            while (wordIndex < m && sIndex < n) {
                if (word.charAt(wordIndex) == s.charAt(sIndex)) {
                    wordIndex++;
                }
                sIndex++;
            }
            if (wordIndex == m) {
                count += uniqueWords.get(word);
            }
        }
        return count;
    }
}

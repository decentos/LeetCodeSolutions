package slidingwindow;

import java.util.*;

public class H30SubstringConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> starts = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        int step = words[0].length();

        for (String word : words) {
            wordsMap.merge(word, 1, Integer::sum);
        }

        for (int start = 0; start < step; start++) {
            slidingWindow(s, start, step, wordsMap, starts);
        }
        return starts;
    }

    private void slidingWindow(String s, int start, int step, Map<String, Integer> wordsMap, List<Integer> starts) {
        Map<String, Integer> currMap = new HashMap<>();
        int startIndex = start, usedWords = 0;

        for (int i = start; i + step <= s.length(); i += step) {
            String word = s.substring(i, i + step);

            if (wordsMap.containsKey(word)) {
                int currCount = currMap.merge(word, 1, Integer::sum);
                int wordCount = wordsMap.get(word);

                if (currCount == wordCount) {
                    usedWords++;
                } else if (currCount > wordCount) {
                    while (currMap.get(word) > wordCount) {
                        String removedWord = s.substring(startIndex, startIndex + step);
                        if (!removedWord.equals(word) && wordsMap.get(removedWord) == currMap.get(removedWord)) {
                            usedWords--;
                        }
                        currMap.merge(removedWord, -1, Integer::sum);
                        startIndex += step;
                    }
                }

                if (usedWords == wordsMap.size()) {
                    starts.add(startIndex);

                    String removedWord = s.substring(startIndex, startIndex + step);
                    currMap.merge(removedWord, -1, Integer::sum);
                    usedWords--;
                    startIndex += step;
                }

            } else {
                currMap.clear();
                usedWords = 0;
                startIndex = i + step;
            }
        }
    }
}

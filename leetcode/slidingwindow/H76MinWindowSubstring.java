package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class H76MinWindowSubstring {

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }

        Map<Character, Integer> tLetters = new HashMap<>();
        for (char c : t.toCharArray()) {
            tLetters.merge(c, 1, Integer::sum);
        }
        Map<Character, Integer> currLetters = new HashMap<>();
        int left = 0, usedLetters = 0;
        int minWindowSize = Integer.MAX_VALUE, leftBorder = 0, rightBorder = 0;

        for (int right = 0; right < m; right++) {
            char curr = s.charAt(right);

            if (tLetters.containsKey(curr)) {
                int currCount = currLetters.merge(curr, 1, Integer::sum);

                if (currCount == tLetters.get(curr)) {
                    usedLetters++;
                }

                while (usedLetters == tLetters.size()) {
                    while (!tLetters.containsKey(s.charAt(left))) {
                        left++;
                    }

                    int currLength = right - left + 1;
                    if (minWindowSize > currLength) {
                        minWindowSize = currLength;
                        leftBorder = left;
                        rightBorder = right + 1;
                    }

                    char leftChar = s.charAt(left);
                    left++;
                    int removedCount = currLetters.merge(leftChar, -1, Integer::sum);
                    if (removedCount < tLetters.get(leftChar)) {
                        usedLetters--;
                    }
                }
            }
        }
        return s.substring(leftBorder, rightBorder);
    }
}

package string;

import java.util.HashMap;
import java.util.Map;

public class E409LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : counter.values()) {
            if (count % 2 == 0) {
                length += count;
            } else if (!hasOdd) {
                length += count;
                hasOdd = true;
            } else {
                length += count - 1;
            }
        }
        return length;
    }
}

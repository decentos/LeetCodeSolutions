package string;

import java.util.HashMap;
import java.util.Map;

public class E409LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);

        boolean hasOdd = false;
        int length = 0;
        for (int count : map.values()) {
            if (count % 2 == 0 ) {
                length += count;
            } else {
                if (hasOdd) {
                    length += count - 1;
                } else {
                    length += count;
                    hasOdd = true;
                }
            }
        }
        return length;
    }
}

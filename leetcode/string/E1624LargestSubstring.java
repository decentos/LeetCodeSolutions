package string;

import java.util.HashMap;
import java.util.Map;

public class E1624LargestSubstring {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> first = new HashMap<>();
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (first.containsKey(curr)) {
                max = Math.max(max, i - first.get(curr) - 1);
            } else {
                first.put(curr, i);
            }
        }
        return max;
    }
}

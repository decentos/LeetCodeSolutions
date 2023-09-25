package string;

import java.util.HashMap;
import java.util.Map;

public class E389FindDiff {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.merge(c, 1, Integer::sum);
        }

        for (char c : t.toCharArray()) {
            int count = countMap.getOrDefault(c, 0);
            if (count == 0) {
                return c;
            }
            countMap.replace(c, count - 1);
        }
        return '0';
    }
}

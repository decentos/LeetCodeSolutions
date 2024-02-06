package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class H76MinWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (char curr : t.toCharArray()) {
            map.merge(curr, 1, Integer::sum);
            set.add(curr);
        }

        int left = 0, rigth = 0;
        int minLeft = 0, minRight = 0, minLength = Integer.MAX_VALUE;
        while (rigth < s.length()) {
            char curr = s.charAt(rigth++);
            if (map.containsKey(curr)) {
                int count = map.merge(curr, -1, Integer::sum);
                if (count == 0) {
                    set.remove(curr);
                }
                while (set.isEmpty()) {
                    while(!map.containsKey(s.charAt(left))) {
                        left++;
                    }
                    if (minLength > rigth - left) {
                        minLength = rigth - left;
                        minLeft = left;
                        minRight = rigth;
                    }
                    char removed = s.charAt(left++);
                    int newCount = map.merge(removed, 1, Integer::sum);
                    if (newCount > 0) {
                        set.add(removed);
                    }
                }
            }
        }
        return s.substring(minLeft, minRight);
    }
}

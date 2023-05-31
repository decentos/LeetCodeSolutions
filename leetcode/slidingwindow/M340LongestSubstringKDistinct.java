package slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class M340LongestSubstringKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n < k) return n;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, longest = 0;

        while (right < n) {
            map.put(s.charAt(right), right++);

            if (map.size() > k) {
                int delete = Collections.min(map.values());
                map.remove(s.charAt(delete));
                left = delete + 1;
            }

            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}

package slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class M159LongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int longest = 0;

        while (right < n) {
            map.put(s.charAt(right), right++);

            if (map.size() > 2) {
                int delete = Collections.min(map.values());
                map.remove(s.charAt(delete));
                left = delete + 1;
            }
            longest = Math.max(longest, right - left);
        }
        return longest;
    }

    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int n = s.length();
        if (n < 3) return n;

        char[] arr = s.toCharArray();
        int first = -1, second = -1;
        int longest = 0, lenght = 0;

        for (int i = 0; i < n; i++) {
            if (first == -1 || arr[first] == arr[i]) {
                first = i;
                lenght++;
                longest = Math.max(longest, lenght);
            } else if (second == -1 || arr[second] == arr[i]) {
                second = i;
                lenght++;
                longest = Math.max(longest, lenght);
            } else {
                if (first < second) {
                    lenght = i - first;
                    first = i;
                } else {
                    lenght = i - second;
                    second = i;
                }
            }
        }
        return longest;
    }
}

package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class M1100FindKLengthSubstrings {

    public int numKLenSubstrNoRepeats(String s, int k) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
            }

            if (set.size() == k) {
                count++;
                set.remove(s.charAt(left++));
            }
        }
        return count;
    }
}

package heap;

import java.util.HashSet;
import java.util.Set;

public class M128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int longest = 0;

        for (int num : nums) {
            unique.add(num);
        }

        for (int num : unique) {
            if (unique.contains(num - 1)) {
                continue;
            }

            int currNum = num;
            int currCons = 1;
            while (unique.contains(currNum + 1)) {
                currNum++;
                currCons++;
            }
            longest = Math.max(longest, currCons);
        }

        return longest;
    }
}

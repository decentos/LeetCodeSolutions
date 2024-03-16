package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class M525ContiguousArray {

    public int findMaxLength(int[] nums) {
        int ones = 0, zeros = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
            int diff = ones - zeros;
            if (map.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return maxLen;
    }
}

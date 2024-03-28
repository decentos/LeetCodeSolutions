package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class M2958LengthLongestSubarray {

    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0, left = 0;
        Map<Integer, Integer> counter = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            counter.merge(nums[right], 1, Integer::sum);

            while (counter.get(nums[right]) > k) {
                counter.merge(nums[left], -1, Integer::sum);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

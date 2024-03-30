package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class H992SubarraysKIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return calculateCount(nums, k) - calculateCount(nums, k - 1);
    }

    private int calculateCount(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            counter.merge(nums[right], 1, Integer::sum);

            while (counter.size() > k) {
                counter.merge(nums[left], -1, Integer::sum);
                if (counter.get(nums[left]) == 0) {
                    counter.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}

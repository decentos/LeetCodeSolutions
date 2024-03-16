package prefixsum;

import java.util.HashMap;
import java.util.Map;

public class M560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (sum == k) count++;
            count += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}

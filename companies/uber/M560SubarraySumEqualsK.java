package uber;

import java.util.HashMap;
import java.util.Map;

public class M560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            if (sum == k) {
                count++;
            }
            count += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}

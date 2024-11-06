package uber.algo;

import java.util.HashMap;
import java.util.Map;

public class M523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixMod = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (map.containsKey(prefixMod)) {
                if (i - map.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                map.put(prefixMod, i);
            }
        }
        return false;
    }
}

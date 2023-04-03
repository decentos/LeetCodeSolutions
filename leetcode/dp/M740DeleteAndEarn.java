package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class M740DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.merge(num, num, Integer::sum);
            max = Math.max(max, num);
        }
        if (map.size() == 1) return map.values().iterator().next();

        int n = max + 1;
        int[] dp = new int[n];
        dp[1] = map.getOrDefault(1, 0);

        for (int i = 2; i < n; i++) {
            int curr = map.getOrDefault(i, 0);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + curr);
        }
        return dp[n - 1];
    }

    public int deleteAndEarn2(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.merge(num, num, Integer::sum);
            max = Math.max(max, num);
        }
        if (map.size() == 1) return map.values().iterator().next();

        int prev1 = 0, prev2 = map.getOrDefault(1, 0), curr = 0;

        for (int i = 2; i <= max; i++) {
            int add = map.getOrDefault(i, 0);
            curr = Math.max(prev2, prev1 + add);
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }

    public int deleteAndEarn3(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.merge(num, num, Integer::sum);
        }
        if (map.size() == 1) return map.values().iterator().next();

        List<Integer> keys = new ArrayList<>(map.keySet());
        int prev1 = 0, prev2 = map.get(keys.get(0)), curr = prev2;

        for (int i = 1; i < keys.size(); i++) {
            int currItem = keys.get(i);
            int currPoints = map.get(currItem);
            if (currItem - 1 == keys.get(i - 1)) {
                curr = Math.max(prev2, prev1 + currPoints);
            } else {
                curr += currPoints;
            }
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}

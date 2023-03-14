package backtracking;

import java.util.Map;

public class M494TargetSum {
    private int total;

    public int findTargetSumWays(int[] nums, int target) {
        for (int i : nums) total += i;
        Integer[][] memo = new Integer[nums.length][total * 2 + 1];
        return find(nums, target, 0, 0, memo);
    }

    private int find(int[] nums, int target, int sum, int index, Integer[][] memo) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        } else {
            if (memo[index][sum + total] != null) return memo[index][sum + total];

            int add = find(nums, target, sum + nums[index], index + 1, memo);
            int sub = find(nums, target, sum - nums[index], index + 1, memo);
            memo[index][sum + total] = add + sub;
            return memo[index][sum + total];
        }
    }

    private int find2(int[] nums, int target, int sum, int index, Map<String, Integer> memo) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        } else {
            String key = String.format("%d->%d", index, sum);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            int add = find2(nums, target, sum + nums[index], index + 1, memo);
            int sub = find2(nums, target, sum - nums[index], index + 1, memo);
            memo.put(key, add + sub);
            return add + sub;
        }
    }
}

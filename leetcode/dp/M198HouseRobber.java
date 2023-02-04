package dp;

import java.util.Arrays;

public class M198HouseRobber {
    private static final int[] memo = new int[100];

    public static int rob(int[] nums) {
        Arrays.fill(memo, -1);
        return helper(nums, 0);
    }

    private static int helper(int[] nums, int n) {
        if (n >= nums.length) return 0;
        if (memo[n] != -1) return memo[n];
        int max = Math.max(helper(nums, n + 1), helper(nums, n + 2) + nums[n]);
        memo[n] = max;
        return max;
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (nums.length == 0) return 0;

        int robNext = nums[n - 1], robNextPlusOne = 0;
        for (int i = n - 2; i >= 0; i--) {
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;
    }

    public static int rob3(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] loot = new int[n + 1];
        loot[0] = 0; // no house
        loot[1] = nums[0]; //first house

        for (int i = 2; i <= n; i++) {
            loot[i] = Math.max(loot[i - 1], loot[i - 2] + nums[i - 1]);
        }
        return loot[n];
    }
}

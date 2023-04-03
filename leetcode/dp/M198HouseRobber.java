package dp;

public class M198HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int prev1 = 0, prev2 = nums[0], curr = 0;

        for (int i = 1; i < n; i++) {
            curr = Math.max(prev2, prev1 + nums[i]);
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}

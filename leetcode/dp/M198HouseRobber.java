package dp;

public class M198HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];

        for (int i = 1; i < n ; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[n];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int prev = 0, curr = nums[0];

        for (int i = 1; i < n ; i++) {
            int max = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = max;
        }
        return curr;
    }
}

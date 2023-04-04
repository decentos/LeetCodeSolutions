package dp;

public class H1770MaximumScore {

    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length, n = nums.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                int useLeft = mult * nums[left] + dp[i + 1][left + 1];
                int useRight = mult * nums[right] + dp[i + 1][left];
                dp[i][left] = Math.max(useLeft, useRight);
            }
        }
        return dp[0][0];
    }

    public int maximumScore2(int[] nums, int[] multipliers) {
        int m = multipliers.length, n = nums.length;
        int[] dp = new int[m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = 0; left <= i; left++) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                int useLeft = mult * nums[left] + dp[left + 1];
                int useRight = mult * nums[right] + dp[left];
                dp[left] = Math.max(useLeft, useRight);
            }
        }
        return dp[0];
    }

    public int maximumScore3(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        return dp(nums, multipliers, new int[m][m], 0, 0);
    }

    private int dp(int[] nums, int[] multipliers, int[][] memo, int index, int left) {
        if (index == multipliers.length) return 0;

        if (memo[index][left] == 0) {
            int mult = multipliers[index];
            int right = nums.length - 1 - (index - left);
            int useLeft = mult * nums[left] + dp(nums, multipliers, memo, index + 1, left + 1);
            int useRight = mult * nums[right] + dp(nums, multipliers, memo, index + 1, left);
            memo[index][left] = Math.max(useLeft, useRight);
        }
        return memo[index][left];
    }
}

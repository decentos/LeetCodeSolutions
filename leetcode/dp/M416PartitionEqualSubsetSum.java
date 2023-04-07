package dp;

public class M416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return dfs(nums, target, 0, memo);
    }

    private boolean dfs(int[] nums, int target, int index, Boolean[][] memo) {
        if (target < 0 || index == nums.length) return false;
        if (target == 0) return true;
        if (memo[index][target] != null) return memo[index][target];

        boolean result = dfs(nums, target - nums[index], index + 1, memo) || dfs(nums, target, index + 1, memo);
        memo[index][target] = result;
        return result;
    }

    public boolean canPartition2(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                if (curr > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
                }
            }
        }
        return dp[n][target];
    }

    public boolean canPartition3(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int curr : nums) {
            for (int j = target; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[target];
    }
}

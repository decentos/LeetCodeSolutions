package dp;

public class M413ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        int[] dp = new int[n];

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            count += dp[i];
        }
        return count;
    }

// ===============================================================================

    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        int count = 0;
        int curr = 0, prev = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = prev + 1;
            }
            count += curr;
            prev = curr;
            curr = 0;
        }
        return count;
    }
}

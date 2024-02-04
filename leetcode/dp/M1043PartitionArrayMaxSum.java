package dp;

public class M1043PartitionArrayMaxSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = 0, best = 0;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                best = Math.max(best, dp[i - j] + max * j);
            }
            dp[i] = best;
        }
        return dp[n];
    }
}

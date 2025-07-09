package dp;

public class M3466MaxCoinCollection {

    public long maxCoins(int[] lane1, int[] lane2) {
        int n = lane1.length;
        long max = Math.max(lane1[0], lane2[0]);

        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][2] = lane1[0];  //lane1 , 2 moves left
        dp[0][0][0] = lane1[0];  //lane1 , no moves left
        dp[0][1][1] = lane2[0];  //lane 2 , one move left

        for (int i = 1; i < n; i++) {
            //continue lane1 or enter now lane1
            dp[i][0][2] = Math.max(dp[i - 1][0][2] + lane1[i], lane1[i]);

            //lane1 - remain here or enter from lane 2
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][1]) + lane1[i];

            //lane2 - move from lane1 or continue lane 2 or enter lane 2 now
            dp[i][1][1] = Math.max(0, Math.max(dp[i - 1][1][1], dp[i - 1][0][2])) + lane2[i];

            long currMax = Math.max(dp[i][0][0], Math.max(dp[i][0][2], dp[i][1][1]));
            max = Math.max(max, currMax);
        }
        return max;
    }
}

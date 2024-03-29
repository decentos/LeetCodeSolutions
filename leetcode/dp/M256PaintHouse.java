package dp;

public class M256PaintHouse {

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    public int minCost2(int[][] costs) {
        int[] prevRow = costs[0];

        for (int i = 1; i < costs.length; i++) {
            int[] currRow = costs[i];
            currRow[0] += Math.min(prevRow[1], prevRow[2]);
            currRow[1] += Math.min(prevRow[0], prevRow[2]);
            currRow[2] += Math.min(prevRow[0], prevRow[1]);
            prevRow = currRow;
        }
        return Math.min(prevRow[0], Math.min(prevRow[1], prevRow[2]));
    }
}

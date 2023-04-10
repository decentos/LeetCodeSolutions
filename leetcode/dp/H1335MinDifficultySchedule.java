package dp;

public class H1335MinDifficultySchedule {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;

        int[][] dp = new int[n][d + 1];
        dp[n - 1][d] = jobDifficulty[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i][d] = Math.max(dp[i + 1][d], jobDifficulty[i]);
        }

        for (int day = d - 1; day > 0; day--) {
            for (int index = day - 1; index < n - (d - day); index++) {
                dp[index][day] = Integer.MAX_VALUE;
                int hardest = 0;
                for (int temp = index; temp < n - (d - day); temp++) {
                    hardest = Math.max(hardest, jobDifficulty[temp]);
                    dp[index][day] = Math.min(dp[index][day], hardest + dp[temp + 1][day + 1]);
                }
            }
        }
        return dp[0][1];
    }

    public int minDifficulty2(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;

        int[][] dp = new int[d + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], jobDifficulty[i - 1]);
        }

        for (int day = 2; day <= d; day++) {
            for (int index = day; index <= n; index++) {
                dp[day][index] = Integer.MAX_VALUE;
                int hardest = 0;
                for (int temp = index; temp >= day; temp--) {
                    hardest = Math.max(hardest, jobDifficulty[temp - 1]);
                    dp[day][index] = Math.min(dp[day][index], hardest + dp[day - 1][temp - 1]);
                }
            }
        }
        return dp[d][n];
    }

    public int minDifficulty3(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;

        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], jobDifficulty[i]);
        }

        for (int day = 2; day <= d; day++) {
            for (int index = 0; index <= n - day; index++) {
                dp[index] = Integer.MAX_VALUE;
                int hardest = 0;
                for (int temp = index; temp <= n - day; temp++) {
                    hardest = Math.max(hardest, jobDifficulty[temp]);
                    dp[index] = Math.min(dp[index], hardest + dp[temp + 1]);
                }
            }
        }
        return dp[0];
    }
}

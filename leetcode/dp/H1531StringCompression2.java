package dp;

import java.util.Arrays;

public class H1531StringCompression2 {

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, n);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }

                int same = 0, diff = 0;
                for (int t = i; t >= 1; t--) {
                    if (s.charAt(t - 1) == s.charAt(i - 1)) {
                        same++;
                    } else {
                        diff++;
                    }

                    if (diff <= j) {
                        dp[i][j] = Math.min(dp[i][j], dp[t - 1][j - diff] + getLen(same));
                    }
                }
            }
        }
        return dp[n][k];
    }

    private int getLen(int count) {
        if (count == 1) return 1;
        else if (count < 10) return 2;
        else if (count < 100) return 3;
        else return 4;
    }
}

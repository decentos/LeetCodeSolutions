package uber.algo;

import java.util.Arrays;

public class H1326MinNumberTaps {

    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);

            for (int j = start; j <= end; j++) {
                dp[end] = Math.min(dp[end], dp[j] + 1);
            }
        }

        return dp[n] == Integer.MAX_VALUE - 1 ? -1 : dp[n];
    }

// ===============================================================================

    public int minTaps2(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            maxReach[start] = Math.max(maxReach[start], end);
        }

        int taps = 0, currEnd = 0, nextEnd = 0;

        for (int i = 0; i <= n; i++) {
            if (i > nextEnd) {
                return -1;
            }

            if (i > currEnd) {
                taps++;
                currEnd = nextEnd;
            }

            nextEnd = Math.max(nextEnd, maxReach[i]);
        }
        return taps;
    }
}

package dp;

import java.util.Arrays;

public class M279PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        int max = (int) Math.sqrt(n);
        int[] squares = new int[max + 1];
        for (int i = 1; i < squares.length; i++) {
            squares[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int square : squares) {
                if (square > i) continue;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }
}

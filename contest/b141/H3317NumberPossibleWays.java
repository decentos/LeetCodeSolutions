package b141;

import java.util.Arrays;

public class H3317NumberPossibleWays {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x, int y) {
        // Initialize combination array
        int[][] comb = new int[x + 1][x + 1];
        for (int i = 0; i <= x; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        // Initialize Stirling numbers of the second kind
        int[][] stirling = new int[n + 1][x + 1];
        stirling[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                stirling[i][j] = (int) (((long) j * stirling[i - 1][j] + stirling[i - 1][j - 1]) % MOD);
            }
        }

        // Factorial array initialization
        int[] factorial = new int[x + 1];
        Arrays.fill(factorial, 1);
        for (int i = 1; i <= x; i++) {
            factorial[i] = (int) (((long) factorial[i - 1] * i) % MOD);
        }

        // Calculate the result using the precomputed arrays
        long totalWays = 0;
        for (int k = 1; k <= x; k++) {
            long yPow = 1;
            for (int i = 0; i < k; i++) {
                yPow = (yPow * y) % MOD;
            }
            totalWays = (totalWays + ((long) comb[x][k] * stirling[n][k] % MOD * factorial[k] % MOD * yPow % MOD)) % MOD;
        }

        return (int) totalWays;
    }
}

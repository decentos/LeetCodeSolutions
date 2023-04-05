package dp;

import java.util.Arrays;

public class M322CoinChange {

    public int coinChange(int[] coins, int amount) {
        return findMin(coins, amount, new int[amount + 1]);
    }

    private int findMin(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = findMin(coins, amount - coin, memo);
            if (count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }

        memo[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}

package dp;

public class M518CoinChange2 {

    public int change(int amount, int[] coins) {
        int max = amount + 1;
        int[] dp = new int[max];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < max; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}

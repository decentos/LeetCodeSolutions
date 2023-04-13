package dp;

public class E121SellBuyStock {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;

        int[] dp = new int[n];
        dp[0] = 0;
        int min = prices[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[n - 1];
    }

    public int maxProfit2(int[] prices) {
        int profit = 0, min = Integer.MAX_VALUE;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}

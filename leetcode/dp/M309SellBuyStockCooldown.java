package dp;

public class M309SellBuyStockCooldown {

    public int maxProfit(int[] prices) {
        int profit = 0, prevProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = profit;
            profit = Math.max(prevProfit, profit + prices[i] - prices[i - 1]);
            prevProfit = Math.max(temp, prevProfit);
        }
        return Math.max(profit, prevProfit);
    }
}

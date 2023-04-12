package dp;

public class M714SellBuyStockTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int profit = 0, hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, hold + prices[i] - fee);
            hold = Math.max(hold, profit - prices[i]);
        }
        return profit;
    }
}

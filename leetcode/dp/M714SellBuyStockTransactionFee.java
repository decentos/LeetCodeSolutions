package dp;

public class M714SellBuyStockTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int profit = 0, hold = Integer.MIN_VALUE;

        for (int price : prices) {
            hold = Math.max(hold, profit - price);
            profit = Math.max(profit, hold + price - fee);
        }
        return profit;
    }
}

package me.decentos.leetcode.stock;

public class M309BestTimeStockCooldown {

    public static int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }
        return Math.max(sold, reset);
    }

    public static int maxProfit2(int[] prices) {
        int[] maxProfit = new int[prices.length + 2];

        for (int i = prices.length - 1; i >= 0; i--) {
            int case1 = 0;
            // Case 1). buy and sell the stock
            for (int sell = i + 1; sell < prices.length; sell++) {
                int profit = (prices[sell] - prices[i]) + maxProfit[sell + 2];
                case1 = Math.max(profit, case1);
            }

            // Case 2). do no transaction with the stock p[i]
            int case2 = maxProfit[i + 1];

            // wrap up the two cases
            maxProfit[i] = Math.max(case1, case2);
        }
        return maxProfit[0];
    }
}

package me.decentos.leetcode.stock;

public class M122BestTimeStock2 {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        int valley = Integer.MAX_VALUE;
        int peak = valley;

        for (int price : prices) {
            if (price < peak) {
                profit += peak - valley;
                valley = price;
                peak = valley;
            } else {
                peak = price;
            }
        }
        profit += peak - valley;
        return profit;
    }
}

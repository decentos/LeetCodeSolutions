package me.decentos.leetcode.stock;

public class E121BestTimeStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0, dayOfBuy = 0, dayOfSell = dayOfBuy + 1, minBuyPrice = prices[dayOfBuy];
        while (dayOfBuy < prices.length - 1) {
            if (prices[dayOfBuy] < prices[dayOfSell] && minBuyPrice >= prices[dayOfBuy]) {
                minBuyPrice = prices[dayOfBuy];
                while (dayOfSell < prices.length) {
                    int currentProfit = prices[dayOfSell] - prices[dayOfBuy];
                    if (currentProfit > maxProfit) maxProfit = currentProfit;
                    dayOfSell++;
                }
            }
            dayOfBuy++;
            dayOfSell = dayOfBuy + 1;
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int minBuy = prices[0], maxProfit = 0;
        for (int current : prices) {
            minBuy = Math.min(minBuy, current);
            maxProfit = Math.max(maxProfit, current - minBuy);
        }
        return maxProfit;
    }
}

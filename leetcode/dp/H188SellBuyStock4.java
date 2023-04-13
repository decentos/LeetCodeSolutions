package dp;

import java.util.Arrays;

public class H188SellBuyStock4 {

    public int maxProfit(int k, int[] prices) {
        int[] profit = new int[k + 1];
        int[] cost = new int[k + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                cost[i] = Math.min(cost[i], price - profit[i - 1]);
                profit[i] = Math.max(profit[i], price - cost[i]);
            }
        }
        return profit[k];
    }
}

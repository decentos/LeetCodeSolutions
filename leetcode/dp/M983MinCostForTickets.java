package dp;

public class M983MinCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1], cost = 0;
        int[] dp = new int[lastDay + 1];
        int i = 0;

        for (int day = 1; day <= lastDay; day++) {
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                i++;
                int dayPassCost = dp[day - 1] + costs[0];
                int weekPassCost = dp[Math.max(0, day - 7)] + costs[1];
                int monthPassCost = dp[Math.max(0, day - 30)] + costs[2];
                dp[day] = Math.min(dayPassCost, Math.min(weekPassCost, monthPassCost));
            }
        }
        return dp[lastDay];
    }
}

package dp;

public class E746MinCostClimbing {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = cost[0];

        for (int i = 1; i < n; i++) {
            int next = Math.min(cost[i] + prev, cost[i] + curr);
            prev = curr;
            curr = next;
        }
        return Math.min(prev, curr);
    }
}

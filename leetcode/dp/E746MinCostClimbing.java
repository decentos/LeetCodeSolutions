package dp;

public class E746MinCostClimbing {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] arr = new int[n];
        arr[0] = cost[0];
        arr[1] = cost[1];

        for (int i = 2; i < n; i++) {
            arr[i] = cost[i] + Math.min(arr[i - 1], arr[i - 2]);
        }
        return Math.min(arr[n - 1], arr[n - 2]);
    }
}

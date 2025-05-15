package dp;

public class E70ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int prev = 1, curr = 2;

        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}

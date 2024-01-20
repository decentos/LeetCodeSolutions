package stack;

import java.util.Stack;

public class M907SumSubarrayMin {

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long count = (long) arr[mid] * (mid - left) * (i - mid) % MOD;
                sum = (sum + count) % MOD;
            }
            stack.push(i);
        }
        return (int) sum;
    }
}

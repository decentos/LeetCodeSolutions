package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class H2454NextGreaterElement4 {

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Pair> first = new Stack<>();
        Stack<Pair> second = new Stack<>();
        Stack<Pair> temp = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (!second.isEmpty() && num > second.peek().num) {
                ans[second.pop().id] = num;
            }

            while (!first.isEmpty() && num > first.peek().num) {
                temp.push(first.pop());
            }

            while (!temp.isEmpty()) {
                second.push(temp.pop());
            }

            first.push(new Pair(i, num));
        }
        return ans;
    }

    private static class Pair {
        int id;
        int num;

        public Pair(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }

    public int[] secondGreaterElement2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();
        Deque<Integer> temp = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (!second.isEmpty() && num > nums[second.peek()]) {
                ans[second.pop()] = num;
            }

            while (!first.isEmpty() && num > nums[first.peek()]) {
                temp.push(first.pop());
            }

            while (!temp.isEmpty()) {
                second.push(temp.pop());
            }

            first.push(i);
        }
        return ans;
    }
}

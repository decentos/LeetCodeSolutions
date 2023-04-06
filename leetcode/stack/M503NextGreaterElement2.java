package stack;

import java.util.Stack;

public class M503NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Pair> stack = new Stack<>();
        int[] greaters = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && num > stack.peek().num) {
                greaters[stack.pop().id] = num;
            }
            stack.push(new Pair(i, num));
        }

        for (int num : nums) {
            while (!stack.isEmpty() && num > stack.peek().num) {
                greaters[stack.pop().id] = num;
            }
        }
        while (!stack.isEmpty()) greaters[stack.pop().id] = -1;

        return greaters;
    }

    private static class Pair {
        int id;
        int num;

        public Pair(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }
}

package uber.algo;

import java.util.ArrayDeque;
import java.util.Deque;

public class H84LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int currHeight = heights[stack.pop()];
                int currWeight = i - stack.peek() - 1;
                max = Math.max(max, currHeight * currWeight);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWeight = heights.length - stack.peek() - 1;
            max = Math.max(max, currHeight * currWeight);
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int max = 0;

        for (int i = 0; i <= n; i++) {
            int curr = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && curr < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}

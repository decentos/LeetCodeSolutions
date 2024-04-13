package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class H84LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
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

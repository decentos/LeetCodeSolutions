package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class H85MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] histogram = new int[n];
        int max = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    histogram[col]++;
                } else {
                    histogram[col] = 0;
                }
            }

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i <= n; i++) {
                int curr = i == n ? 0 : histogram[i];
                while (!stack.isEmpty() && curr < histogram[stack.peek()]) {
                    int height = histogram[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, height * width);
                }
                stack.push(i);
            }
        }
        return max;
    }
}

package uber.algo;

import java.util.ArrayList;
import java.util.List;

public class M54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();
        int top = 0, right = n - 1, down = m - 1, left = 0;

        while (spiral.size() < m * n) {
            int curr = left;
            while (curr <= right) {
                spiral.add(matrix[top][curr++]);
            }
            top++;

            curr = top;
            while (curr <= down) {
                spiral.add(matrix[curr++][right]);
            }
            right--;

            curr = right;
            if (top <= down) {
                while (curr >= left) {
                    spiral.add(matrix[down][curr--]);
                }
            }
            down--;

            curr = down;
            if (left <= right) {
                while (curr >= top) {
                    spiral.add(matrix[curr--][left]);
                }
            }
            left++;
        }
        return spiral;
    }
}

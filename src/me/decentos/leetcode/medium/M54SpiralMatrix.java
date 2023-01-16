package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class M54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int left = 0, up = 0, right = m - 1, down = n - 1;
        while (result.size() < n * m) {
            for (int row = left; row <= right; row++) {
                result.add(matrix[up][row]);
            }

            for (int col = up + 1; col <= down; col++) {
                result.add(matrix[col][right]);
            }

            if (up != down) {
                for (int row = right - 1; row >= left; row--) {
                    result.add(matrix[down][row]);
                }
            }

            if (left != right) {
                for (int col = down - 1; col > up; col--) {
                    result.add(matrix[col][left]);
                }
            }

            left++;
            right--;
            up++;
            down--;
        }
        return result;
    }
}

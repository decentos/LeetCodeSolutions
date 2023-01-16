package me.decentos.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M498DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;

        for (int i = 0; i < n + m - 1; i++) {
            List<Integer> diagonal = new ArrayList<>();
            int head = i < m ? 0 : i - m + 1;
            int seq = i < m ? i : m - 1;
            while (head < n && seq >= 0) {
                diagonal.add(mat[head][seq]);
                head++;
                seq--;
            }
            if (i % 2 == 0) {
                Collections.reverse(diagonal);
            }
            for (int e : diagonal) {
                result[index] = e;
                index++;
            }
        }
        return result;
    }

    public int[] findDiagonalOrder2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int col = 0, row = 0, direction = 1;
        int[] result = new int[n * m];
        int index = 0;

        while (col < n && row < m) {
            result[index++] = matrix[col][row];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int nextCol = col + (direction == 1 ? -1 : 1);
            int nextRow = row + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (nextCol < 0 || nextCol == n || nextRow < 0 || nextRow == m) {
                // If the current diagonal was going in the upwards direction.
                if (direction == 1) {
                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    col += (row == m - 1 ? 1 : 0);
                    row += (row < m - 1 ? 1 : 0);
                } else {
                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    row += (col == n - 1 ? 1 : 0);
                    col += (col < n - 1 ? 1 : 0);
                }
                // Flip the direction
                direction = 1 - direction;
            } else {
                col = nextCol;
                row = nextRow;
            }
        }
        return result;
    }
}

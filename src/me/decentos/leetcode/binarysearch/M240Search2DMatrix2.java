package me.decentos.leetcode.binarysearch;

public class M240Search2DMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[0] <= target && ints[ints.length - 1] >= target) {
                int low = 0, high = ints.length - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (ints[mid] == target) return true;
                    else if (ints[mid] > target) high = mid - 1;
                    else low = mid + 1;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1, column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] == target) return true;
            else if (matrix[row][column] > target) row--;
            else column++;
        }
        return false;
    }
}

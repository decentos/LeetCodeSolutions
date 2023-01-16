package me.decentos.leetcode.binarysearch;

public class M74Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[ints.length - 1] >= target) {
                int low = 0, high = ints.length - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (ints[mid] == target) return true;
                    else if (ints[mid] > target) high = mid - 1;
                    else low = mid + 1;
                }
                return false;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midElement = matrix[mid / n][mid % n];
            if (midElement == target) return true;
            else if (midElement > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}

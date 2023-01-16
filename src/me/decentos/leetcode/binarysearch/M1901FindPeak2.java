package me.decentos.leetcode.binarysearch;

public class M1901FindPeak2 {

    public static int[] findPeakGrid(int[][] mat) {
        int max = 0, column = 0;
        int low = 0, high = mat.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            for (int i = 0; i < mat[mid].length; i++) {
                if (mat[mid][i] > max) {
                    max = mat[mid][i];
                    column = i;
                }
            }
            if ((mid == 0 || max > mat[mid - 1][column])
                    && (mid + 1 == mat.length || max > mat[mid + 1][column])) {
                return new int[]{mid, column};
            } else if (mid + 1 == mat.length || max < mat[mid + 1][column]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return new int[]{-1, -1};
    }
}

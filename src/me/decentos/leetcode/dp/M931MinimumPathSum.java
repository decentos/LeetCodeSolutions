package me.decentos.leetcode.dp;

public class M931MinimumPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        int[][] memo = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            minSum = Math.min(minSum, helper(matrix, 0, i, memo));
        }
        return minSum;
    }

    private static int helper(int[][] matrix, int n, int m, int[][] memo) {
        if (m < 0 || m == matrix.length) return Integer.MAX_VALUE;
        if (memo[n][m] != 0) return memo[n][m];
        if (n == matrix.length - 1) return matrix[n][m];

        int left = helper(matrix, n + 1, m - 1, memo);
        int mid = helper(matrix, n + 1, m, memo);
        int right = helper(matrix, n + 1, m + 1, memo);

        memo[n][m] = Math.min(left, Math.min(mid, right)) + matrix[n][m];
        return memo[n][m];
    }
}

package me.decentos.leetcode.easy;

public class E1572MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int n = mat.length, primary = 0, sec = n - 1;
        int sum = 0;
        while (primary < n) {
            sum += mat[primary][primary];
            primary++;
        }

        int i = 0;
        while (sec >= 0) {
            sum += mat[i][sec];
            sec--;
            i++;
        }
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }

    public int diagonalSum2(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }

        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }
}

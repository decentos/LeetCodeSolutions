package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class H51NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        generate(ans, board, new HashSet<>(), new HashSet<>(), new HashSet<>(), n, 0);
        return ans;
    }

    private void generate(List<List<String>> ans, char[][] board, Set<Integer> diagonals, Set<Integer> antDiagonals, Set<Integer> cols, int queens, int row) {
        if (queens == 0) {
            List<String> curr = new ArrayList<>();
            for (char[] arr : board) curr.add(String.valueOf(arr));
            ans.add(curr);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if (diagonals.contains(currDiagonal) || antDiagonals.contains(currAntiDiagonal) || cols.contains(col)) continue;

            diagonals.add(currDiagonal);
            antDiagonals.add(currAntiDiagonal);
            cols.add(col);
            board[row][col] = 'Q';

            generate(ans, board, diagonals, antDiagonals, cols, queens - 1, row + 1);

            diagonals.remove(currDiagonal);
            antDiagonals.remove(currAntiDiagonal);
            cols.remove(col);
            board[row][col] = '.';
        }
    }
}

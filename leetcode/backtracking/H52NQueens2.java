package backtracking;

import java.util.HashSet;
import java.util.Set;

public class H52NQueens2 {

    public int totalNQueens(int n) {
        return generate(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int generate(int size, int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
        if (row == size) return 1;

        int count = 0;
        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if (diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal) || cols.contains(col)) continue;

            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            cols.add(col);

            count += generate(size, row + 1, diagonals, antiDiagonals, cols);

            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            cols.remove(col);
        }
        return count;
    }
}

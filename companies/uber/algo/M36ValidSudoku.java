package uber.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                char curr = board[row][col];
                int box = (row / 3) * 3 + (col / 3);

                if (rows.containsKey(row) && rows.get(row).contains(curr)
                        || cols.containsKey(col) && cols.get(col).contains(curr)
                        || boxes.containsKey(box) && boxes.get(box).contains(curr)) {
                    return false;
                }

                rows.computeIfAbsent(row, val -> new HashSet<>()).add(curr);
                cols.computeIfAbsent(col, val -> new HashSet<>()).add(curr);
                boxes.computeIfAbsent(box, val -> new HashSet<>()).add(curr);
            }
        }
        return true;
    }

// ===============================================================================

    public boolean isValidSudoku2(char[][] board) {
        int n = board.length;
        int[][] rows = new int[n][n + 1];
        int[][] cols = new int[n][n + 1];
        int[][] boxes = new int[n][n + 1];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                int curr = board[row][col] - '0';
                int box = (row / 3) * 3 + (col / 3);

                if (rows[row][curr] > 0 || cols[col][curr] > 0 || boxes[box][curr] > 0) {
                    return false;
                }

                rows[row][curr]++;
                cols[col][curr]++;
                boxes[box][curr]++;
            }
        }
        return true;
    }
}

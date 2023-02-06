package matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;

                Set<Character> row = rows.get(i);
                if (row != null && row.contains(curr)) {
                    return false;
                } else {
                    rows.computeIfAbsent(i, val -> new HashSet<>()).add(curr);
                }

                Set<Character> column = columns.get(j);
                if (column != null && column.contains(curr)) {
                    return false;
                } else {
                    columns.computeIfAbsent(j, val -> new HashSet<>()).add(curr);
                }

                int currBox = (i / 3) * 3 + j / 3;
                Set<Character> box = boxes.get(currBox);
                if (box != null && box.contains(curr)) {
                    return false;
                } else {
                    boxes.computeIfAbsent(currBox, val -> new HashSet<>()).add(curr);
                }
            }
        }
        return true;
    }
}

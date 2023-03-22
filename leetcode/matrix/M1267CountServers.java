package matrix;

public class M1267CountServers {

    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[] rowCounts = new int[m];
        int[] colCounts = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    rowCounts[row]++;
                    colCounts[col]++;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 && (rowCounts[row] > 1 || colCounts[col] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}

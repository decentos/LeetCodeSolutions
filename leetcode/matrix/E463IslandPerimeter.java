package matrix;

public class E463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        perimeter--;
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        perimeter--;
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        perimeter--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        perimeter--;
                    }
                }
            }
        }
        return perimeter;
    }
}

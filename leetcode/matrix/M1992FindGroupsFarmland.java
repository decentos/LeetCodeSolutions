package matrix;

import java.util.ArrayList;
import java.util.List;

public class M1992FindGroupsFarmland {

    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> farms = new ArrayList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (land[row][col] == 1) {
                    int[] farm = {row, col, row, col};
                    farms.add(farm);
                    dfs(land, farm, row, col);
                }
            }
        }
        return farms.toArray(int[][]::new);
    }

    private void dfs(int[][] land, int[] farm, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[0].length || land[row][col] != 1) {
            return;
        }

        land[row][col] = 0;
        if (row > farm[2] || col > farm[3]) {
            farm[2] = row;
            farm[3] = col;
        }

        dfs(land, farm, row + 1, col);
        dfs(land, farm, row - 1, col);
        dfs(land, farm, row, col + 1);
        dfs(land, farm, row, col - 1);
    }
}

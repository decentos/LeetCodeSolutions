package dp;

public class H265PaintHouse2 {

    public int minCostII(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int[][] dp = new int[m][n];
        dp[0] = costs[0];

        for (int house = 1; house < m; house++) {
            for (int color = 0; color < n; color++) {
                dp[house][color] = findMin(dp[house - 1], color) + costs[house][color];
            }
        }
        return findMin(dp[m - 1], -1);
    }

    private int findMin(int[] row, int curr) {
        int min = Integer.MAX_VALUE;
        for (int color = 0; color < row.length; color++) {
            if (color == curr) continue;
            min = Math.min(min, row[color]);
        }
        return min;
    }

    public int minCostII2(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int[] prevRow = costs[0];

        for (int house = 1; house < m; house++) {
            int[] currRow = costs[house];
            for (int color = 0; color < n; color++) {
                currRow[color] += findMin(prevRow, color);
            }
            prevRow = currRow;
        }
        return findMin(prevRow, -1);
    }

    public int minCostII3(int[][] costs) {
        int m = costs.length, n = costs[0].length;

        for (int house = 1; house < m; house++) {
            int minColor = -1, secondMinColor = -1;

            for (int color = 0; color < n; color++) {
                int cost = costs[house - 1][color];

                if (minColor == -1 || cost < costs[house - 1][minColor]) {
                    secondMinColor = minColor;
                    minColor = color;
                } else if (secondMinColor == -1 || cost < costs[house - 1][secondMinColor]) {
                    secondMinColor = color;
                }
            }

            for (int color = 0; color < n; color++) {
                if (color == minColor) costs[house][color] += costs[house - 1][secondMinColor];
                else costs[house][color] += costs[house - 1][minColor];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : costs[m - 1]) {
            min = Math.min(min, i);
        }
        return min;
    }
}

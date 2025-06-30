package uber.algo;

public class M2672NumberAdjColor {

    public int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length;
        int[] sameColor = new int[m];
        int[] colors = new int[n];

        for (int i = 0; i < m; i++) {
            int queryIndex = queries[i][0];
            int queryColor = queries[i][1];
            int count = i > 0 ? sameColor[i - 1] : 0;

            if (colors[queryIndex] != 0) {
                count += queryIndex == 0 ? 0 : colors[queryIndex - 1] == colors[queryIndex] ? -1 : 0;
                count += queryIndex == n - 1 ? 0 : colors[queryIndex + 1] == colors[queryIndex] ? -1 : 0;
            }

            colors[queryIndex] = queryColor;
            count += queryIndex == 0 ? 0 : colors[queryIndex - 1] == colors[queryIndex] ? 1 : 0;
            count += queryIndex == n - 1 ? 0 : colors[queryIndex + 1] == colors[queryIndex] ? 1 : 0;
            sameColor[i] = count;
        }
        return sameColor;
    }
}

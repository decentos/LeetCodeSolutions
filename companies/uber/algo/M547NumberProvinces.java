package uber.algo;

public class M547NumberProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind graph = new UnionFind(n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isConnected[row][col] == 1) {
                    graph.union(row, col);
                }
            }
        }
        return graph.getCount();
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;
        private int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (root[node] == node) {
                return node;
            }
            return root[node] = find(root[node]);
        }

        public void union(int nodeX, int nodeY) {
            int rootX = find(nodeX);
            int rootY = find(nodeY);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}

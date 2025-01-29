package graph.unionfind;

public class M684RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind graph = new UnionFind(edges.length);
        int[] redundant = new int[0];

        for (int[] edge : edges) {
            if (graph.isConnected(edge[0], edge[1])) {
                redundant = edge;
            } else {
                graph.union(edge[0], edge[1]);
            }
        }
        return redundant;
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];

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
            }
        }

        public boolean isConnected(int nodeX, int nodeY) {
            return find(nodeX) == find(nodeY);
        }
    }
}

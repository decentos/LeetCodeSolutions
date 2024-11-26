package graph.unionfind;

import java.util.ArrayList;
import java.util.List;

public class H305NumberIslands2 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> islands = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);

        for (int[] position : positions) {
            int landPosition = position[0] * n + position[1];
            uf.addLand(landPosition);

            for (int[] dir : dirs) {
                int nextRow = position[0] + dir[0];
                int nextCol = position[1] + dir[1];
                int nextLandPosition = nextRow * n + nextCol;

                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && uf.isLand(nextLandPosition)) {
                    uf.union(landPosition, nextLandPosition);
                }
            }
            islands.add(uf.getCount());
        }
        return islands;
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;
        private int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = 0;

            for (int i = 0; i < size; i++) {
                root[i] = -1;
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

        public void addLand(int node) {
            if (root[node] >= 0) {
                return;
            }
            root[node] = node;
            count++;
        }

        public boolean isLand(int node) {
            return root[node] >= 0;
        }
    }
}

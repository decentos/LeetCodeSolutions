package uber.algo;

import java.util.HashSet;
import java.util.Set;

public class H827MakingLargeIsland {

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        UnionFind graph = new UnionFind(n * n);
        int maxSize = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    int landPosition = row * n + col;

                    for (int[] dir : dirs) {
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        int nextLandPosition = nextRow * n + nextCol;

                        if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == n || grid[nextRow][nextCol] == 0) {
                            continue;
                        }

                        graph.union(landPosition, nextLandPosition);
                    }
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    int currSize = 1;
                    Set<Integer> roots = new HashSet<>();

                    for (int[] dir : dirs) {
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];
                        int nextLandPosition = nextRow * n + nextCol;

                        if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == n || grid[nextRow][nextCol] == 0) {
                            continue;
                        }

                        int root = graph.find(nextLandPosition);
                        roots.add(root);
                    }

                    for (int root : roots) {
                        currSize += graph.getLandSize(root);
                    }
                    maxSize = Math.max(maxSize, currSize);
                }
            }
        }
        return maxSize == 0 ? n * n : maxSize;
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;
        private final int[] landSize;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            landSize = new int[size];

            for (int i = 0; i < size; i++) {
                root[i] = i;
                landSize[i] = 1;
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
                    landSize[rootX] += landSize[rootY];
                } else if (rank[rootX] > rank[rootY]) {
                    root[rootX] = rootY;
                    landSize[rootY] += landSize[rootX];
                } else {
                    root[rootY] = rootX;
                    landSize[rootX] += landSize[rootY];
                    rank[rootX]++;
                }
            }
        }

        public int getLandSize(int root) {
            return landSize[root];
        }
    }
}

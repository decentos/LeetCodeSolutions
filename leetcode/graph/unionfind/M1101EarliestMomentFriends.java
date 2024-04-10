package graph.unionfind;

import java.util.Arrays;
import java.util.Comparator;

public class M1101EarliestMomentFriends {

    public int earliestAcq(int[][] logs, int n) {
        if (logs.length < n - 1) {
            return -1;
        }

        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        UnionFind uf = new UnionFind(n);

        for (int[] log : logs) {
            uf.union(log[1], log[2]);

            if (uf.getCount() == 1) {
                return log[0];
            }
        }
        return -1;
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;
        private int count;

        public UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
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

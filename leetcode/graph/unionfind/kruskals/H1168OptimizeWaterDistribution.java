package graph.unionfind.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H1168OptimizeWaterDistribution {

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int cost = 0;
        UnionFind uf = new UnionFind(n);
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edges.add(new Edge(0, i + 1, wells[i]));
        }
        for (int[] pipe : pipes) {
            edges.add(new Edge(pipe[0], pipe[1], pipe[2]));
        }
        Collections.sort(edges);

        for (Edge edge : edges) {
            if (!uf.isConnected(edge.from, edge.to)) {
                uf.union(edge.from, edge.to);
                cost += edge.weight;
            }
        }
        return cost;
    }

    private static class UnionFind {
        private final int[] root;
        private final int[] rank;

        public UnionFind(int size) {
            root = new int[size + 1];
            rank = new int[size + 1];

            for (int i = 0; i <= size; i++) {
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

    private static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}

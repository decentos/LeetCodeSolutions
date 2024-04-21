package graph.unionfind.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M1584MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int cost = 0;
        UnionFind uf = new UnionFind(n);
        List<Edge> edges = new ArrayList<>();

        for (int from = 0; from < n; from++) {
            for (int to = from + 1; to < n; to++) {
                int weight = Math.abs(points[from][0] - points[to][0]) + Math.abs(points[from][1] - points[to][1]);
                Edge edge = new Edge(from, to, weight);
                edges.add(edge);
            }
        }
        Collections.sort(edges);

        for (Edge edge : edges) {
            if (uf.getCount() == 1) {
                break;
            }
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

        public boolean isConnected(int nodeX, int nodeY) {
            return find(nodeX) == find(nodeY);
        }

        private int getCount() {
            return count;
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

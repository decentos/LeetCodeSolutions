package graph.unionfind;

import java.util.*;

public class M399EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] results = new double[queries.size()];
        UnionFind graph = new UnionFind(equations.size() * 2);
        Map<String, Integer> toIndexMap = new HashMap<>();
        int nodeIndex = 0;
        Map<Integer, List<Calculation>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String divisor = equations.get(i).get(0);
            String divider = equations.get(i).get(1);

            toIndexMap.putIfAbsent(divisor, nodeIndex++);
            toIndexMap.putIfAbsent(divider, nodeIndex++);

            int divisorIndex = toIndexMap.get(divisor);
            int dividerIndex = toIndexMap.get(divider);

            graph.union(divisorIndex, dividerIndex);
            adj.computeIfAbsent(divisorIndex, val -> new ArrayList<>()).add(new Calculation(dividerIndex, values[i]));
            adj.computeIfAbsent(dividerIndex, val -> new ArrayList<>()).add(new Calculation(divisorIndex, 1 / values[i]));
        }

        for (int i = 0; i < queries.size(); i++) {
            String divisor = queries.get(i).get(0);
            String divider = queries.get(i).get(1);
            int divisorIndex = toIndexMap.getOrDefault(divisor, -1);
            int dividerIndex = toIndexMap.getOrDefault(divider, -1);

            if (divisorIndex == -1 || dividerIndex == -1 || !graph.isConnected(divisorIndex, dividerIndex)) {
                results[i] = -1.0;
            } else if (divisorIndex == dividerIndex) {
                results[i] = 1.0;
            } else {
                Deque<Calculation> queue = new ArrayDeque<>();
                queue.offer(new Calculation(divisorIndex, 1.0));

                boolean[] visited = new boolean[equations.size() * 2];
                visited[divisorIndex] = true;

                while (!queue.isEmpty()) {
                    Calculation curr = queue.poll();

                    if (curr.node == dividerIndex) {
                        results[i] = curr.value;
                        break;
                    }

                    List<Calculation> neighbors = adj.get(curr.node);
                    for (Calculation neighbor : neighbors) {
                        if (!visited[neighbor.node]) {
                            visited[neighbor.node] = true;
                            queue.offer(new Calculation(neighbor.node, curr.value * neighbor.value));
                        }
                    }
                }
            }
        }
        return results;
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

    private record Calculation(int node, double value) {}
}

package graph.unionfind;

import java.util.*;

public class M399EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        UnionFind uf = new UnionFind(equations.size() * 2);
        Map<String, Integer> stringToNode = new HashMap<>();
        int stringToNodeIndex = 0;
        Map<Integer, List<Calculation>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double value = values[i];
            double revertValue = 1 / values[i];

            stringToNode.putIfAbsent(dividend, stringToNodeIndex++);
            stringToNode.putIfAbsent(divisor, stringToNodeIndex++);

            uf.union(stringToNode.get(dividend), stringToNode.get(divisor));

            adj.computeIfAbsent(stringToNode.get(dividend), val -> new ArrayList<>()).add(new Calculation(stringToNode.get(divisor), value));
            adj.computeIfAbsent(stringToNode.get(divisor), val -> new ArrayList<>()).add(new Calculation(stringToNode.get(dividend), revertValue));
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!stringToNode.containsKey(dividend) || !stringToNode.containsKey(divisor) || !uf.isConnected(stringToNode.get(dividend), stringToNode.get(divisor))) {
                result[i] = -1.0;
            } else if (dividend.equals(divisor)) {
                result[i] = 1.0;
            } else {
                int nodeFirst = stringToNode.get(dividend);
                int nodeSecond = stringToNode.get(divisor);

                boolean[] visited = new boolean[equations.size() * 2];
                visited[nodeFirst] = true;

                Deque<Calculation> queue = new ArrayDeque<>();
                queue.offer(new Calculation(nodeFirst, 1.0));

                while (!queue.isEmpty()) {
                    Calculation curr = queue.poll();

                    if (curr.node == nodeSecond) {
                        result[i] = curr.amount;
                        break;
                    }

                    if (adj.containsKey(curr.node)) {
                        List<Calculation> neighbors = adj.get(curr.node);
                        for (Calculation neighbor : neighbors) {
                            if (!visited[neighbor.node]) {
                                visited[neighbor.node] = true;
                                queue.offer(new Calculation(neighbor.node, curr.amount * neighbor.amount));
                            }
                        }
                    }
                }
            }
        }
        return result;
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

    private static class Calculation {
        int node;
        double amount;

        public Calculation(int node, double amount) {
            this.node = node;
            this.amount = amount;
        }
    }
}

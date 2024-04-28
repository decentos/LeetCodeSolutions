package graph;

import java.util.*;

public class H834SumDistances {

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] sum = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
        }

        postOrder(sum, count, adj, 0, -1);
        preOrder(sum, count, adj, n, 0, -1);
        return sum;
    }

    private void postOrder(int[] sum, int[] count, Map<Integer, List<Integer>> adj, int node, int parent) {
        if (adj.containsKey(node)) {
            List<Integer> neighbors = adj.get(node);
            for (int neighbor : neighbors) {
                if (neighbor != parent) {
                    postOrder(sum, count, adj, neighbor, node);
                    count[node] += count[neighbor];
                    sum[node] += sum[neighbor] + count[neighbor];
                }
            }
        }
    }

    private void preOrder(int[] sum, int[] count, Map<Integer, List<Integer>> adj, int size, int node, int parent) {
        if (adj.containsKey(node)) {
            List<Integer> neighbors = adj.get(node);
            for (int neighbor : neighbors) {
                if (neighbor != parent) {
                    sum[neighbor] = sum[node] - count[neighbor] + size - count[neighbor];
                    preOrder(sum, count, adj, size, neighbor, node);
                }
            }
        }
    }
}
